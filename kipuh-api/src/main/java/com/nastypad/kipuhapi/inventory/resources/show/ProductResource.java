package com.nastypad.kipuhapi.inventory.resources.show;

import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class ProductResource {
    private Long Id;
    private String Name;
    private float price;
}