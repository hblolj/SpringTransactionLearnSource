package com.hblolj.springtransactionlearn.dao;

import com.hblolj.springtransactionlearn.dataobject.Account;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.math.BigDecimal;

@Repository
public interface AccountMapper extends Mapper<Account> {

    Integer reduceMoney(@Param("userId") Long userId, @Param("money") BigDecimal money);

    Integer plusMoney(@Param("userId") Long userId, @Param("money") BigDecimal money);
}