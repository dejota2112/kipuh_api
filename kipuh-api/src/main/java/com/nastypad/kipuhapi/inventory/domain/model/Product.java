package com.nastypad.kipuhapi.inventory.domain.model;

import jakarta.persistence.*;
import lombok.*;

import javax.xml.transform.Source;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}
