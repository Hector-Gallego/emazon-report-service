package com.resourceserver.emazonreportmicroservice.domain.spi;

import com.resourceserver.emazonreportmicroservice.domain.models.PurchaseData;
import com.resourceserver.emazonreportmicroservice.ports.driven.mongo.documents.PurchaseReport;

import java.util.List;

public interface PurchaseReportPersistencePort {
    List<PurchaseReport> getAllPurchaseReportsByUserId();
    String createPurchaseReport(PurchaseData purchaseData);

}
