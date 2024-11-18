package com.resourceserver.emazonreportmicroservice.ports.driven.mongo.adapters;

import com.resourceserver.emazonreportmicroservice.configuration.services.AuthenticatedUserManager;
import com.resourceserver.emazonreportmicroservice.ports.driven.mongo.documents.ItemSaleData;
import com.resourceserver.emazonreportmicroservice.ports.driven.mongo.documents.PurchaseReport;
import com.resourceserver.emazonreportmicroservice.domain.models.PurchaseData;
import com.resourceserver.emazonreportmicroservice.domain.spi.PurchaseReportPersistencePort;
import com.resourceserver.emazonreportmicroservice.ports.driven.mongo.repository.ItemSaleDateRepository;
import com.resourceserver.emazonreportmicroservice.ports.driven.mongo.repository.PurchaseReportRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class PurchaseReportAdapter implements PurchaseReportPersistencePort {

    private final PurchaseReportRepository purchaseReportRepository;
    private final ItemSaleDateRepository itemSaleDateRepository;
    private final AuthenticatedUserManager authenticatedUserManager;

    public PurchaseReportAdapter(PurchaseReportRepository purchaseReportRepository, ItemSaleDateRepository itemSaleDateRepository, AuthenticatedUserManager authenticatedUserManager) {
        this.purchaseReportRepository = purchaseReportRepository;
        this.itemSaleDateRepository = itemSaleDateRepository;
        this.authenticatedUserManager = authenticatedUserManager;
    }


    @Override
    public List<PurchaseReport> getAllPurchaseReportsByUserId() {
        Long userId = authenticatedUserManager.getUserId();
        return purchaseReportRepository.getAllByUserId(userId);

    }

    @Override
    public String createPurchaseReport(PurchaseData purchaseData) {
        Long userId = authenticatedUserManager.getUserId();
        String customerEmail = authenticatedUserManager.getUserEmail();

        PurchaseReport purchaseReport = new PurchaseReport();
        purchaseReport.setUserId(userId);
        purchaseReport.setPurchaseDate(LocalDateTime.now());
        purchaseReport.setTotalAmount(purchaseData.getTotalPurchase());
        purchaseReport.setCustomerEmail(customerEmail);

        List<ItemSaleData> savedItems = new ArrayList<>();
        for (ItemSaleData item : purchaseData.getItemsSaleData()) {
            if (item.getId() == null) {
                ItemSaleData savedItem = itemSaleDateRepository.save(item);
                savedItems.add(savedItem);
            } else {
                savedItems.add(item);
            }
        }

        purchaseReport.setItemCarts(savedItems);
        PurchaseReport purchaseReportPersist = purchaseReportRepository.save(purchaseReport);
        return purchaseReportPersist.getId();
    }
}
