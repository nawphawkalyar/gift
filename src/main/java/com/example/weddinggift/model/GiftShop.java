package com.example.weddinggift.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;


@Document(collection = "gift_shop")
@Getter @Setter
public class GiftShop extends Shop {

    @Indexed(direction = IndexDirection.ASCENDING)
    private List<GiftItem> giftItems=new ArrayList<>();

    public List<GiftItem> getGiftItems() {
        return giftItems;
    }

    public void setGiftItems(List<GiftItem> giftItems) {
        this.giftItems = giftItems;
    }

}
