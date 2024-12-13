package ru.itis.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private Long id;
    private String dishList;
    private int tableNumber;
    private String waiterName;
}
