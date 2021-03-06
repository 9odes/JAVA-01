package com.nineodes.service;

import com.nineodes.model.RespResult;
import com.nineodes.vo.SwitchAccountRequest;

/**
 * Created by Deng jin on 2021/3/20 15:31
 */
public interface IAccountCnyService {

    /**
     * 找到账户类型为CNY的用户
     * 将该用户资金账户扣减指定金额，
     * 在冻结记录中新增指定金额的冻结记录
     * @param request
     * @return
     */
    RespResult switchAccountPre(SwitchAccountRequest request);

    /**
     * 找到账户类型是CNY的用户，
     * 找到该用户冻结资金表记录，以及找到对应的金额
     * 然后将指定金额转移到对手用户id中，
     * 冻结记录失效
     * @param request
     * @return
     */
    RespResult switchAccountConfirm(SwitchAccountRequest request);

    /**
     * 找到账户类型是CNY的用户
     * 找到该用户冻结资金记录，以及对应的金额
     * 将该金额加回该用户资金账户中，
     * 冻结记录失效
     * @param request
     * @return
     */
    RespResult switchAccountCancel(SwitchAccountRequest request);
}
