package com.resourceserver.emazonreportmicroservice.ports.driven.mongo.repository;

import com.resourceserver.emazonreportmicroservice.ports.driven.mongo.documents.PurchaseReport;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PurchaseReportRepository extends MongoRepository<PurchaseReport, String> {
    List<PurchaseReport> getAllByUserId(Long userId);
}
