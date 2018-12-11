package com.efruit.micro.arkgift.domain;

import java.math.BigDecimal;
import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class GiftOrder {
    private String id;

    private Date created;

    private String wxOpenId;

    private String wxNick;
    
    private String wxPicUrl;

    private Integer num;

    private Integer remainNum;
    
    @JsonIgnore
    @JSONField(serialize=false)
    private String payNo;
    
    private String giftMsg;

    private String actId;

    private Date expireTime;

    private Integer status;
    
    @JsonIgnore
    @JSONField(serialize=false)
    private BigDecimal payMoney;
    
    private String actName;
    
    private String itemName;
    
    private String itemStandard;
    
    @JsonIgnore
    @JSONField(serialize=false)
    private BigDecimal itemPrice;
    
    @JsonIgnore
    @JSONField(serialize=false)
    private BigDecimal freightPrice;
    
    private String shareTitle;
    
    private String shareDes;
    
    private String shareIcon;
    
    @SuppressWarnings("unused")
	private Long remainTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getWxOpenId() {
        return wxOpenId;
    }

    public void setWxOpenId(String wxOpenId) {
        this.wxOpenId = wxOpenId == null ? null : wxOpenId.trim();
    }

    public String getWxNick() {
        return wxNick;
    }

    public void setWxNick(String wxNick) {
        this.wxNick = wxNick == null ? null : wxNick.trim();
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getRemainNum() {
        return remainNum;
    }

    public void setRemainNum(Integer remainNum) {
        this.remainNum = remainNum;
    }

    public String getPayNo() {
        return payNo;
    }

    public void setPayNo(String payNo) {
        this.payNo = payNo == null ? null : payNo.trim();
    }

    public String getActId() {
        return actId;
    }

    public void setActId(String actId) {
        this.actId = actId == null ? null : actId.trim();
    }

    public Date getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

	public String getWxPicUrl() {
		return wxPicUrl;
	}

	public void setWxPicUrl(String wxPicUrl) {
		this.wxPicUrl = wxPicUrl;
	}

	public String getGiftMsg() {
		return giftMsg;
	}

	public void setGiftMsg(String giftMsg) {
		this.giftMsg = giftMsg;
	}

	public BigDecimal getPayMoney() {
		return payMoney;
	}

	public void setPayMoney(BigDecimal payMoney) {
		this.payMoney = payMoney;
	}

	public BigDecimal getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(BigDecimal itemPrice) {
		this.itemPrice = itemPrice;
	}

	public BigDecimal getFreightPrice() {
		return freightPrice;
	}

	public void setFreightPrice(BigDecimal freightPrice) {
		this.freightPrice = freightPrice;
	}

	public String getActName() {
		return actName;
	}

	public void setActName(String actName) {
		this.actName = actName;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemStandard() {
		return itemStandard;
	}

	public void setItemStandard(String itemStandard) {
		this.itemStandard = itemStandard;
	}

	public String getShareTitle() {
		return shareTitle;
	}

	public void setShareTitle(String shareTitle) {
		this.shareTitle = shareTitle;
	}

	public String getShareDes() {
		return shareDes;
	}

	public void setShareDes(String shareDes) {
		this.shareDes = shareDes;
	}

	public String getShareIcon() {
		return shareIcon;
	}

	public void setShareIcon(String shareIcon) {
		this.shareIcon = shareIcon;
	}

	public Long getRemainTime() {
		if(expireTime != null) {
			Long time = expireTime.getTime()/1000 - new Date().getTime()/1000;
			if(time > 0) {
				return time;
			}else {
				return 0l;
			}
		}
		return null;
	}

	public void setRemainTime(Long remainTime) {
		this.remainTime = remainTime;
	}
	
}