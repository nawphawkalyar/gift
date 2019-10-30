package com.example.weddinggift.controller;

import com.example.weddinggift.Service.GiftShopService;
import com.example.weddinggift.model.GiftItem;
import com.example.weddinggift.model.GiftShop;
import com.example.weddinggift.model.Response;
import com.example.weddinggift.repository.GiftShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("gift")
@CrossOrigin("*")
public class GiftShopController {

    @Autowired
    private GiftShopService giftShopService;
    @Autowired
    private GiftShopRepository giftShopRepository;

    @PostMapping
    public ResponseEntity<Response> create(@RequestBody GiftShop giftShop) {
         this.giftShopService.create(giftShop);
         return ResponseEntity.ok().body(new Response(HttpStatus.CREATED,"Successfully Create!"));
    }

    @GetMapping
    public List<GiftShop> findAll(){
    return this.giftShopService.findAll();
}

     //@GetMapping("all")
//    public List<GiftItem> findAllItem(){
//        return giftShopService.findAllItem();
//    }
    @PatchMapping("/update/item/{id}")
    public GiftShop update(@PathVariable String id,@RequestBody GiftShop giftShop){
        GiftShop shop=this.giftShopRepository.findGiftShopById(id);

         shop.setGiftItems(giftShop.getGiftItems());
         this.giftShopRepository.save(shop);
        return shop;
    }
    @PatchMapping("/patch/update/{id}")
    public GiftShop updatePath(@PathVariable String id,@RequestBody GiftShop giftShop){

        System.out.println("Id"+id);
        GiftShop shop=this.giftShopRepository.findGiftShopById(id);
        shop.setName(giftShop.getName());
        shop.setCity(giftShop.getCity());
        shop.setTownship(giftShop.getTownship());
        shop.setImage(giftShop.getImage());
        shop.setStreet(giftShop.getStreet());
        shop.setPhone(giftShop.getPhone());
//        shop.setGiftItems(giftShop.getGiftItems().stream()
//        .map( gift ->
//        {
//            gift.getQuantity();
//            gift.getName();
//            gift.getPrice();
//            gift.getDescription();
//            gift.getImage();
//            return  gift;
//        }).collect(Collectors.toList())
//        );
       //Ishop.setGiftItems(giftShop.getGiftItems());

        this.giftShopRepository.save(shop);
        return shop;
    }
//    @GetMapping("/giftShop/{name}")
//    public GiftShop findByName(@PathVariable String name){
//        return this.giftShopService.findOne(name);
//    }

//    @GetMapping("/gift/item/{name}")
//    public GiftItem findByName(@PathVariable String name ){
//        return this.giftShopService.findOne(name);
//    }
//
//
//
  @DeleteMapping("/delete/{id}")
      public void itemDelete(@PathVariable String id){
       this.giftShopService.deleteId(id);

      }
//    @Transactional
//      @DeleteMapping("/delete/item/{id}")
//      public void itemDelete(@PathVariable String id,@RequestBody GiftItem i){
//        List<GiftItem> item=this.giftShopRepository.findById(id).get().getGiftItems();
//        for(GiftItem giftItem:item) {
//                if(giftItem==i) {
//                    this.giftShopRepository.deleteGiftItemByGiftItems(giftItem);
//                }
//                }
//
//        }
//        @GetMapping("/giftShop/ByItemName")
//        public GiftShop findByGiftItem(@RequestBody GiftItem item){
//        return this.giftShopRepository.findGiftShopByGiftItems(item);
//        }



      }




