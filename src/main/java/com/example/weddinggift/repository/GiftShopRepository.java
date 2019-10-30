package com.example.weddinggift.repository;

import com.example.weddinggift.model.GiftItem;
import com.example.weddinggift.model.GiftShop;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface GiftShopRepository extends MongoRepository<GiftShop,String> {
    GiftShop findGiftShopByName (String name);
    GiftShop findGiftShopById(String id);
    //void deleteGiftShopByName(String name);
    void deleteById(String id);
    //void deleteGiftItemByGiftItems(GiftItem name);
    //GiftShop findGiftShopByGiftItems(GiftItem item);
}
