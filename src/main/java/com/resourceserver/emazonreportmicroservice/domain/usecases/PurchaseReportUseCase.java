package com.resourceserver.emazonreportmicroservice.domain.usecases;

import com.resourceserver.emazonreportmicroservice.domain.api.PurchaseReportServicePort;
import com.resourceserver.emazonreportmicroservice.domain.models.PurchaseData;
import com.resourceserver.emazonreportmicroservice.ports.driven.mongo.documents.PurchaseReport;
import com.resourceserver.emazonreportmicroservice.domain.spi.PurchaseReportPersistencePort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseReportUseCase implements PurchaseReportServicePort {

    private final PurchaseReportPersistencePort purchaseReportPersistencePort;

    public PurchaseReportUseCase(PurchaseReportPersistencePort purchaseReportPersistencePort) {
        this.purchaseReportPersistencePort = purchaseReportPersistencePort;
    }

    @Override
    public List<PurchaseReport> getAllPurchaseReportsByUserId() {
        return purchaseReportPersistencePort.getAllPurchaseReportsByUserId();
    }

    @Override
    public String createPurchaseReport(PurchaseData purchaseData) {
        return  purchaseReportPersistencePort.createPurchaseReport(purchaseData);
    }
}
