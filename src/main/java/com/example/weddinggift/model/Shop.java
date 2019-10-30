package com.example.weddinggift.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter @Setter
public class Shop {

    @Id
    private String id;

    private String name;
    private String phone;
    private String image;
    private String street;
    private String township;
    private String city;


}
