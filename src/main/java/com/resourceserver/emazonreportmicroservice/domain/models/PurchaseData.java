package com.resourceserver.emazonreportmicroservice.domain.models;

import com.resourceserver.emazonreportmicroservice.ports.driven.mongo.documents.ItemSaleData;

import java.math.BigDecimal;
import java.util.List;

public class PurchaseData {

    private List<ItemSaleData> itemsSaleData;
    private BigDecimal totalPurchase;

    public PurchaseData() {
    }

    public PurchaseData(List<ItemSaleData> itemsSaleData, BigDecimal totalPurchase) {
        this.itemsSaleData = itemsSaleData;
        this.totalPurchase = totalPurchase;
    }

    public List<ItemSaleData> getItemsSaleData() {
        return itemsSaleData;
    }

    public void setItemsSaleData(List<ItemSaleData> itemsSaleData) {
        this.itemsSaleData = itemsSaleData;
    }

    public BigDecimal getTotalPurchase() {
        return totalPurchase;
    }

    public void setTotalPurchase(BigDecimal totalPurchase) {
        this.totalPurchase = totalPurchase;
    }
}
