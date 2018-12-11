package com.efruit.micro.arkmanager.def;

public class SendMsgDef {
    public static final int SUCCESS = 1;
    public static final int FAIL = 0;

    public static final int MSG_TYPE_KEFU = 1;
    public static final int MSG_TYPE_TEMPLATE = 2;
    public static final int MSG_TYPE_SMS = 3;
    public static final int MSG_TYPE_VOICE_SMS = 4;

    public static final int SEND_REASON_COUPON_PAGE = 1;
    public static final int SEND_REASON_ORDER_TEST = 2;
    public static final int SEND_REASON_ORDER_PAY = 3;
    public static final int SEND_REASON_COUPON_PAGE_TEXT_HINTS = 4;
    public static final int SEND_REASON_ACT_TIPS = 5;
    public static final int SEND_REASON_ACTION_PRODUCT = 6;
    public static final int SEND_REASON_ACTION_WECHAT_GROUP = 7;
    public static final int SEND_REASON_ACTION_WECHAT_GROUP_TEXT_HINT = 8;
    public static final int SEND_REASON_DISPATCHING = 9;
    public static final int SEND_REASON_CSR = 10;
    public static final int SEND_REASON_EFRUIT = 11;

    public static final String TEMPLATE_MSG_ID_ORDER_PAY = "zsyWbLXGfIBsr9HT5_Kx1uO4P_U0ngm3mJMhBHjkcqY";//订单支付完成
    public static final String TEMPLATE_MSG_ID_GEN_COUPON = "CiIC46YhF3lupY6hFl31f1EH39f-Mg01949ER1v2ras";//订单支付完成
    public static final String TEMPLATE_MSG_ID_ORDER_TEST = "jqpoGBbDCUDSXmR_wT2JKJGEJBaIoNaKrBCbwpc5P1Y";//订单配送完成
    public static final String TEMPLATE_MSG_ID_ACTION_PRODUCT = "H1w86u3cNL6nyyPBjJiRWaVvvxjamRPqVbLSkInSUWY";//订单配送完成
    public static final String TEMPLATE_MSG_ID_DISPATCHING = "ac9_viqwWg2GqRQIbazFdDYLLP-ofBnRWPmnZBndvHA";//取货通知

    /**
     *
     {{first.DATA}}
     商品详情：{{keyword1.DATA}}
     取货时间：{{keyword2.DATA}}
     取货地点：{{keyword3.DATA}}
     {{remark.DATA}}
     */
    public static final String TEMPLATE_MSG_ID_CSR = "nwacgdiImpaeGBbzJ7JYaFmRxuI88XHzZgekQQPztjU";//取货完成通知


    public static int parse(boolean isSuccess) {
        if (isSuccess) {
            return SUCCESS;
        }

        return FAIL;
    }
}
