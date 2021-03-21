package com.nineodes.service;

import com.nineodes.model.RespResult;
import com.nineodes.vo.SwitchAccountRequest;

/**
 * Created by Deng jin on 2021/3/21 0:31
 */
public interface IBizService {

    RespResult switchAccount(SwitchAccountRequest request);
//    void confirmSwitchAccount(SwitchAccountRequest request);
//    void cancelSwitchAccount(SwitchAccountRequest request);

}
