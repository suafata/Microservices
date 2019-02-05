package com.suafata.order.domain.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "PIZZA")
public class Pizza {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

}
