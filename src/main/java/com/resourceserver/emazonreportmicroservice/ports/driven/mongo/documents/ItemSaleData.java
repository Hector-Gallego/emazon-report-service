package com.resourceserver.emazonreportmicroservice.ports.driven.mongo.documents;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "item_sale_data")
public class ItemSaleData {


    @Id
    private String id;
    private Long articleId;
    private String articleName;
    private Integer articleQuantity;
    private String articleDescription;
    private Double articlePrice;


    public ItemSaleData() {
    }

    public ItemSaleData(String id, Long articleId, String articleName, Integer articleQuantity, String articleDescription, Double articlePrice ) {
        this.id = id;
        this.articleId = articleId;
        this.articleName = articleName;
        this.articleQuantity = articleQuantity;
        this.articleDescription = articleDescription;
        this.articlePrice = articlePrice;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public String getArticleName() {
        return articleName;
    }

    public void setArticleName(String articleName) {
        this.articleName = articleName;
    }

    public Integer getArticleQuantity() {
        return articleQuantity;
    }

    public void setArticleQuantity(Integer articleQuantity) {
        this.articleQuantity = articleQuantity;
    }

    public String getArticleDescription() {
        return articleDescription;
    }

    public void setArticleDescription(String articleDescription) {
        this.articleDescription = articleDescription;
    }

    public Double getArticlePrice() {
        return articlePrice;
    }

    public void setArticlePrice(Double articlePrice) {
        this.articlePrice = articlePrice;
    }
}
