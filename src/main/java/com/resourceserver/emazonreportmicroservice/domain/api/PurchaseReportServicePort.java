package com.resourceserver.emazonreportmicroservice.domain.api;

import com.resourceserver.emazonreportmicroservice.domain.models.PurchaseData;
import com.resourceserver.emazonreportmicroservice.ports.driven.mongo.documents.PurchaseReport;

import java.util.List;

public interface PurchaseReportServicePort {
    List<PurchaseReport>  getAllPurchaseReportsByUserId();
    String createPurchaseReport(PurchaseData purchaseData);
}
