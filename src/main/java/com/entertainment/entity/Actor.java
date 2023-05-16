package com.entertainment.entity;

import javax.persistence.*;

@Entity
@Table(name="actor")
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer actorId;
    private String actorName;
    private String actorPopularity;
    private Integer noOfMovie;
}
