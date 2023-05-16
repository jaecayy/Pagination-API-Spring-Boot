package com.entertainment.entity;

import javax.persistence.*;

@Entity
@Table(name = "production")
public class Production {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer prodId;
    private String prodName;
    private String productionOwner;
    private Integer countOfMovie;
}
