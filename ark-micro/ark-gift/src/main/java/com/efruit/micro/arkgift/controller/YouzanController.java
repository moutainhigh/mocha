package com.efruit.micro.arkgift.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.efruit.micro.arkcommon.ArkCommonResult;
import com.efruit.micro.youzan.common.YouzanApiException;
import com.efruit.micro.youzan.service.YouzanService;
import com.youzan.open.sdk.gen.v3_0_0.model.YouzanUsersWeixinFollowerGetResult;

/**
 * 有赞交互相关接口
 * @author wangyang
 */
@RestController
@RequestMapping("youzan")
public class YouzanController {
	
	@Autowired
	private YouzanService youzanService;
	
	/**
	 * 是否订阅公众号
	 * @param openId
	 */
	@RequestMapping("isSubscribe")
	public ArkCommonResult isSubscribe(@RequestParam String openId) {
		int i = 0;
		try {
			YouzanUsersWeixinFollowerGetResult.CrmWeixinFans user = youzanService.getYouzanUserInfoByWxOpenId(openId);
			if(user != null) {
				if(user.getIsFollow()) {
					i = 1;
				}
			}
		} catch (YouzanApiException e) {
			e.printStackTrace();
		}
		return ArkCommonResult.ok(i);
	}
}
