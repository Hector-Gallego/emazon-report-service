package com.resourceserver.emazonreportmicroservice.ports.driven.mongo.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Document(collection = "purchase_report")
public class PurchaseReport {

    @Id
    private String id;
    private Long userId;
    private LocalDateTime purchaseDate;
    private BigDecimal totalAmount;
    @DBRef(lazy = true)
    private List<ItemSaleData> itemCarts;
    private String customerEmail;

    public PurchaseReport() {
    }

    public PurchaseReport(String id, Long userId, LocalDateTime purchaseDate, BigDecimal totalAmount, List<ItemSaleData> itemCarts, String customerEmail) {
        this.id = id;
        this.userId = userId;
        this.purchaseDate = purchaseDate;
        this.totalAmount = totalAmount;
        this.itemCarts = itemCarts;
        this.customerEmail = customerEmail;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public LocalDateTime getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDateTime purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public List<ItemSaleData> getItemCarts() {
    return itemCarts;
    }

    public void setItemCarts(List<ItemSaleData> itemCarts) {
        this.itemCarts = itemCarts;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    @Override
    public String toString() {
        return "PurchaseReport{" +
                "id=" + id +
                ", userId=" + userId +
                ", purchaseDate=" + purchaseDate +
                ", totalAmount=" + totalAmount +
                ", itemCarts=" + itemCarts +
                ", customerEmail='" + customerEmail + '\'' +
                '}';
    }
}
