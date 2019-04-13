package com.hblolj.springtransactionlearn.dataobject;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
public class Account {

    @Id
    @Column(name = "user_id")
    private Long userId;

    private String userName;

    private BigDecimal money;

    public Account() {
    }

    public Account(Long userId, String userName, BigDecimal money) {
        this.userId = userId;
        this.userName = userName;
        this.money = money;
    }
}