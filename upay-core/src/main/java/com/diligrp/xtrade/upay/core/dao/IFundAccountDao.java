package com.diligrp.xtrade.upay.core.dao;

import com.diligrp.xtrade.shared.mybatis.MybatisMapperSupport;
import com.diligrp.xtrade.upay.core.domain.AccountStateDto;
import com.diligrp.xtrade.upay.core.model.FundAccount;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * 资金账户数据访问层
 */
@Repository("fundAccountDao")
public interface IFundAccountDao extends MybatisMapperSupport {
    void insertFundAccount(FundAccount account);

    /**
     * 根据账号ID（非主键）查询资金账号
     */
    Optional<FundAccount> findFundAccountById(Long accountId);

    /**
     * 根据主账户ID查询子账户列表
     */
    List<FundAccount> findFundAccountByParentId(Long parentId);

    /**
     * 修改资金账号状态，根据数据版本（乐观锁）判断记录是否被修改
     */
    Integer compareAndSetState(AccountStateDto accountState);

    /**
     * 修改资金账号信息
     */
    Integer updateFundAccount(FundAccount account);
}
