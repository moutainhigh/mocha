package com.efruit.micro.youzan.common;

import com.youzan.open.sdk.client.auth.Token;
import com.youzan.open.sdk.client.core.DefaultYZClient;
import com.youzan.open.sdk.client.core.YZClient;
import com.youzan.open.sdk.gen.v3_0_0.api.YouzanUsersWeixinFollowersInfoPull;
import com.youzan.open.sdk.gen.v3_0_0.model.YouzanUsersWeixinFollowersInfoPullParams;
import com.youzan.open.sdk.gen.v3_0_0.model.YouzanUsersWeixinFollowersInfoPullResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FansGetHelper {
    private static final Logger LOGGER = LoggerFactory.getLogger(FansGetHelper.class);

    private String token;

    public FansGetHelper(String token) {
        this.token = token;
    }

    public List<YouzanUsersWeixinFollowersInfoPullResult.WeixinFansCustomerInfo> getFansList() {

        boolean hasNext = true;
        long afterFansId = 0L;

        YZClient client = new DefaultYZClient(new Token(token));
        YouzanUsersWeixinFollowersInfoPullParams youzanUsersWeixinFollowersInfoPullParams = new YouzanUsersWeixinFollowersInfoPullParams();
        youzanUsersWeixinFollowersInfoPullParams.setAfterFansId(afterFansId);
        youzanUsersWeixinFollowersInfoPullParams.setPageSize(50L);
        YouzanUsersWeixinFollowersInfoPull youzanUsersWeixinFollowersInfoPull = new YouzanUsersWeixinFollowersInfoPull();
        youzanUsersWeixinFollowersInfoPull.setAPIParams(youzanUsersWeixinFollowersInfoPullParams);

        final List<YouzanUsersWeixinFollowersInfoPullResult.WeixinFansCustomerInfo> fansList = new ArrayList<>();

        while (hasNext) {
            youzanUsersWeixinFollowersInfoPullParams.setAfterFansId(afterFansId);
            YouzanUsersWeixinFollowersInfoPullResult result = client.invoke(youzanUsersWeixinFollowersInfoPull);
            final YouzanUsersWeixinFollowersInfoPullResult.WeixinFansCustomerInfo[] users = result.getUsers();
            fansList.addAll(Arrays.asList(users));
            afterFansId = result.getLastFansId();
            hasNext = result.getHasNext();
        }

        return fansList;
    }
}
