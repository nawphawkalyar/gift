package com.example.weddinggift.Service;

import com.example.weddinggift.model.GiftItem;
import com.example.weddinggift.model.GiftShop;
import com.example.weddinggift.repository.GiftShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class GiftShopService {

    @Autowired
    private GiftShopRepository giftShopRepository;


    public GiftShop create(GiftShop giftShop){
        return this.giftShopRepository.save(giftShop);

    }

    public List<GiftShop>findAll(){
        return this.giftShopRepository.findAll();
    }

    public List<GiftItem> findAllItem(){
        return giftShopRepository.findAll()
                .stream()
                .flatMap(shop -> shop.getGiftItems().stream())
                .collect(Collectors.toList());
    }

//    public void delete(String name){
//        this.giftShopRepository.deleteGiftShopByName(name);
//    }
    public void deleteId(String id){
        this.giftShopRepository.deleteById(id);
    }


    public GiftShop findOne(String name){
        return this.giftShopRepository.findGiftShopByName(name);

    }

    public GiftShop update( String name, GiftShop giftShop){
       GiftShop shop= this.giftShopRepository.findGiftShopByName(name);
       shop.setName(giftShop.getName());
       shop.setPhone(giftShop.getPhone());
       shop.setImage(giftShop.getImage());
       shop.setStreet(giftShop.getStreet());
       shop.setTownship(giftShop.getTownship());
       shop.setCity(giftShop.getCity());
       this.giftShopRepository.save(shop);
       return shop;
    }


//    public GiftShop updatePatch(String name,GiftShop giftShop){
//        GiftShop shopp= this.giftShopRepository.findGiftShopByName(name);
//        shopp.setName(giftShop.getName());
//        shopp.setPhone(giftShop.getPhone());
//        shopp.setImage(giftShop.getImage());
//        shopp.setStreet(giftShop.getStreet());
//        shopp.setTownship(giftShop.getTownship());
//        shopp.setCity(giftShop.getCity());
//        shopp.setGiftItems(giftShop.getGiftItems());
//        this.giftShopRepository.save(shopp);
//        return shopp;
//    }


}
