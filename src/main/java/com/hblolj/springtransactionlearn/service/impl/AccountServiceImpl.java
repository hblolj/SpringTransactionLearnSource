package com.hblolj.springtransactionlearn.service.impl;

import com.hblolj.springtransactionlearn.dao.AccountMapper;
import com.hblolj.springtransactionlearn.dataobject.Account;
import com.hblolj.springtransactionlearn.service.AccountService;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

/**
 * @author: hblolj
 * @Date: 2019/4/13 14:00
 * @Description:
 * @Version:
 **/
@Service
public class AccountServiceImpl implements AccountService{

    @Autowired
    private AccountMapper accountMapper;

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public Boolean addNewAccount(Long userId, String userName, BigDecimal money) {
        return 1 == accountMapper.insert(new Account(userId, userName, money));
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public Boolean transferAccount(Long outUserId, Long inUserId, BigDecimal money) {

//        try {
//            ((AccountService) AopContext.currentProxy()).reduceMoney(outUserId, money);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
        // 外层执行，扣钱
        accountMapper.reduceMoney(outUserId, money);

//        try {
            ((AccountService) AopContext.currentProxy()).plusMoney(inUserId, money);
//        }catch (Exception e){
//            e.printStackTrace();
//        }

//        throw new RuntimeException("模拟外层异常");

        return true;
    }

    @Transactional(propagation = Propagation.NESTED)
    @Override
    public Boolean reduceMoney(Long userId, BigDecimal money) {
        return 1 == accountMapper.reduceMoney(userId, money);
//        accountMapper.reduceMoney(userId, money);
//        throw new RuntimeException("模拟扣钱失败");
    }

    @Transactional(propagation = Propagation.NESTED)
    @Override
    public Boolean plusMoney(Long userId, BigDecimal money) {
//        return 1 == accountMapper.plusMoney(userId, money);
        accountMapper.plusMoney(userId, money);
        throw new RuntimeException("模拟加钱失败");
    }
}
