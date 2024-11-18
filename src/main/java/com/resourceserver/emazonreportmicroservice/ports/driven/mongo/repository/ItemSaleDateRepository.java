package com.resourceserver.emazonreportmicroservice.ports.driven.mongo.repository;

import com.resourceserver.emazonreportmicroservice.ports.driven.mongo.documents.ItemSaleData;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemSaleDateRepository extends MongoRepository<ItemSaleData, String> {
}
