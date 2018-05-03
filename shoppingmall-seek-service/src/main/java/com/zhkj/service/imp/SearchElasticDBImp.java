package com.zhkj.service.imp;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zhkj.service.ISearchElasticDB;
import com.zhkj.service.entity.CommodityKey;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.reindex.BulkByScrollResponse;
import org.elasticsearch.index.reindex.BulkByScrollTask;
import org.elasticsearch.index.reindex.DeleteByQueryAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SearchElasticDBImp implements ISearchElasticDB{
    @Autowired
    private TransportClient transportClient;
    @Autowired
    private ObjectMapper objectMapper;
    @Override
    public void search_Commodity(String  id) {
        GetResponse response=transportClient.prepareGet(CommodityKey.INDEX,CommodityKey.TYPES_COMMODITY,id)
                .setOperationThreaded(false).get();
        String entity=response.getSourceAsString();
        System.out.println(entity);
//        try {
//            objectMapper.readValue(entity,);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }

    @Override
    public void search_Commoditytyperelation(Integer id) {

    }

    @Override
    public void search_Specificationsrelation(Integer id) {

    }

    @Override
    public void search_Specificationstopic(Integer id) {

    }

    @Override
    public void search_Specificationsdetailed(Integer id) {

    }

    @Override
    public void search_Discount(Integer id) {

    }

    @Override
    public void search_Type(Integer id) {

    }

    @Override
    public void searchDelete(String id) {
       DeleteResponse response= transportClient.prepareDelete(CommodityKey.INDEX,CommodityKey.TYPES_COMMODITY,id).get();
        System.out.println();
    }

    @Override
    public void searchDeleteByQuery(String name) {
        BulkByScrollResponse response= DeleteByQueryAction.INSTANCE.newRequestBuilder(transportClient)
                .filter(QueryBuilders.matchQuery("name",name))
                .source("test").get();
        Long deleted=response.getDeleted();
        System.out.println(deleted);
    }
}
