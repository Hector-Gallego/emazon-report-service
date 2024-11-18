package com.resourceserver.emazonreportmicroservice.ports.driving.controller;

import com.resourceserver.emazonreportmicroservice.domain.api.PurchaseReportServicePort;
import com.resourceserver.emazonreportmicroservice.ports.driven.mongo.documents.PurchaseReport;
import com.resourceserver.emazonreportmicroservice.domain.models.PurchaseData;
import com.resourceserver.emazonreportmicroservice.ports.driven.mongo.repository.PurchaseReportRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reports")
public class PurchaseReportController {

    private final PurchaseReportServicePort purchaseReportServicePort;
    private final PurchaseReportRepository purchaseReportRepository;

    public PurchaseReportController(PurchaseReportServicePort purchaseReportServicePort, PurchaseReportRepository purchaseReportRepository) {
        this.purchaseReportServicePort = purchaseReportServicePort;
        this.purchaseReportRepository = purchaseReportRepository;
    }

    @PostMapping("/saveReport")
    ResponseEntity<String> saveReport(@RequestBody PurchaseData purchaseData) {
        String reportId = purchaseReportServicePort.createPurchaseReport(purchaseData);
        return ResponseEntity.ok(reportId);
    }

    @GetMapping("/getReports")
    public ResponseEntity<List<PurchaseReport>> getAllReportsByUserId(){
        return ResponseEntity.ok(purchaseReportServicePort.getAllPurchaseReportsByUserId());
    }

    @GetMapping("/getAllReports")
    public ResponseEntity<List<PurchaseReport>> getAllReports(){
        return ResponseEntity.ok(purchaseReportRepository.findAll());
    }
}
