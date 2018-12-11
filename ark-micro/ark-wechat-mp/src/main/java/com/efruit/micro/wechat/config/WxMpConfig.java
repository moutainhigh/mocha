package com.efruit.micro.wechat.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * 
 * @author Binary Wang
 *
 */
@Configuration
public class WxMpConfig {
  @Value("${wx_token}")
  private String token;

  @Value("${wx_appid}")
  private String appid;

  @Value("${wx_appsecret}")
  private String appsecret;

  @Value("${wx_aeskey}")
  private String aesKey;

  public String getToken() {
    return this.token;
  }

  public String getAppid() {
    return this.appid;
  }

  public String getAppsecret() {
    return this.appsecret;
  }

  public String getAesKey() {
    return this.aesKey;
  }

}
