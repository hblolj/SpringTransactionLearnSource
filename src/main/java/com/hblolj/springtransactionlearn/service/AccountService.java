package com.hblolj.springtransactionlearn.service;

import java.math.BigDecimal;

/**
 * @author: hblolj
 * @Date: 2019/4/13 13:56
 * @Description:
 * @Version:
 **/
public interface AccountService {

    Boolean addNewAccount(Long userId, String userName, BigDecimal money);

    /**
     * 转账
     * @param outUserId 转账人
     * @param inUserId 收钱人
     * @param money
     * @return
     */
    Boolean transferAccount(Long outUserId, Long inUserId, BigDecimal money);

    /**
     * 扣钱
     * @param userId
     * @param money
     * @return
     */
    Boolean reduceMoney(Long userId, BigDecimal money);

    /**
     * 加钱
     * @param userId
     * @param money
     * @return
     */
    Boolean plusMoney(Long userId, BigDecimal money);
}
