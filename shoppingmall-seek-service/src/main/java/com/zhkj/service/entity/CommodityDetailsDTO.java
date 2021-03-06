package com.zhkj.service.entity;

import com.zhkj.dto.seek_dto.CommodityevaluationDTO;
import com.zhkj.dto.seek_dto.PromotionitemDTO;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * ${user}
 *
 * @Author: Jiankang.Ren
 * @Description: 商品详细展示类提供给前台数据展示
 * @Date: Created in 14:08 2018/5/23 0023
 */
public class CommodityDetailsDTO {
    private String id;//商品id
    private String commodityName;//商品名字
    //商品规格和规格详细
    private CommoditySpecificationDTO commoditySpecificationDTO;
    private List<String> headPictures;//商品头部图片
    private List<String> detailsPictures;//商品详情图片
//    private PromotionitemDTO promotionitemDTO;//商品抢购对象
    private int inventory;//库存
    private Double price;//商品价格
    private List<CommodityevaluationDTO> commodityevaluationDTOS;//商品评价集合
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }

    public CommoditySpecificationDTO getCommoditySpecificationDTO() {
        return commoditySpecificationDTO;
    }

    public void setCommoditySpecificationDTO(CommoditySpecificationDTO commoditySpecificationDTO) {
        this.commoditySpecificationDTO = commoditySpecificationDTO;
    }

    public List<String> getHeadPictures() {
        return headPictures;
    }

    public void setHeadPictures(List<String> headPictures) {
        this.headPictures = headPictures;
    }

    public List<String> getDetailsPictures() {
        return detailsPictures;
    }

    public void setDetailsPictures(List<String> detailsPictures) {
        this.detailsPictures = detailsPictures;
    }

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public List<CommodityevaluationDTO> getCommodityevaluationDTOS() {
        return commodityevaluationDTOS;
    }

    public void setCommodityevaluationDTOS(List<CommodityevaluationDTO> commodityevaluationDTOS) {
        this.commodityevaluationDTOS = commodityevaluationDTOS;
    }
}
