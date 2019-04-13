package com.hblolj.springtransactionlearn.service.impl;

import com.hblolj.springtransactionlearn.SpringTransactionLearnApplicationTests;
import com.hblolj.springtransactionlearn.service.AccountService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @author: hblolj
 * @Date: 2019/4/13 14:03
 * @Description:
 * @Version:
 **/
@Component
public class AccountServiceImplTest extends SpringTransactionLearnApplicationTests{

    @Autowired
    private AccountService accountService;

    @Test
    public void addNewAccount() throws Exception {
        Boolean result = accountService.addNewAccount(4L, "MHT", new BigDecimal(999));
        Assert.assertTrue(result);
    }

    @Test
    public void testTransferAccount() throws Exception {
        Boolean result = accountService.transferAccount(3L, 4L, new BigDecimal(50));
        Assert.assertTrue(result);
    }

}