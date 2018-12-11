package com.efruit.micro.arkmanager.service;


import com.efruit.micro.arkmanager.bean.MsgPushEntity;
import com.efruit.micro.arkmanager.pojo.Coupon;
import com.efruit.micro.youzan.bean.ArkOrder;

import java.util.Date;

public interface CouponService {

    void processCouponPush(MsgPushEntity msgPushEntity);

}
