package com.efruit.micro.youzan.common;

import com.efruit.micro.youzan.bean.ArkOrder;
import com.youzan.open.sdk.client.auth.Token;
import com.youzan.open.sdk.client.core.DefaultYZClient;
import com.youzan.open.sdk.client.core.YZClient;
import com.youzan.open.sdk.gen.v3_0_0.api.YouzanTradesSoldGet;
import com.youzan.open.sdk.gen.v3_0_0.model.YouzanTradesSoldGetParams;
import com.youzan.open.sdk.gen.v3_0_0.model.YouzanTradesSoldGetResult;
import org.apache.commons.lang3.tuple.Pair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

;

public class TradesSoldGetHelper {
    private static final Logger LOGGER = LoggerFactory.getLogger(TradesSoldGetHelper.class);

    private String token;

    public TradesSoldGetHelper(String token) {
        this.token = token;
    }

    /**
     *
     * @param start start date
     * @param end end date
     * @return Pair, Left : totalResults ; Right : List<YouzanTradesSoldGetResult.TradeDetailV2>
     * @throws YouzanApiException
     */
    public Pair<Long, List<YouzanTradesSoldGetResult.TradeDetailV2>> getTradeList(Date start, Date end) throws YouzanApiException {
        YZClient client = new DefaultYZClient(new Token(token));
        YouzanTradesSoldGetParams youzanTradesSoldGetParams = new YouzanTradesSoldGetParams();

        long pageSize = 50L;
        youzanTradesSoldGetParams.setPageSize(pageSize);
        youzanTradesSoldGetParams.setStartCreated(start);
        youzanTradesSoldGetParams.setEndCreated(end);

        YouzanTradesSoldGet youzanTradesSoldGet = new YouzanTradesSoldGet();
        youzanTradesSoldGet.setAPIParams(youzanTradesSoldGetParams);
        YouzanTradesSoldGetResult result = client.invoke(youzanTradesSoldGet);

        final Long totalResults = result.getTotalResults();

        final List<YouzanTradesSoldGetResult.TradeDetailV2> resultList = new ArrayList<>();

        long totalPageSize;
        if (totalResults % pageSize == 0) {
            totalPageSize = (totalResults / pageSize);
        } else {
            totalPageSize = (totalResults / pageSize) + 1;
        }


        LOGGER.info("getTradeList() : totalPageSize : {} , totalResults : {}", totalPageSize, totalResults);
        for (long i = 1; i <= totalPageSize; i++) {
            youzanTradesSoldGetParams.setUseHasNext(true);
            youzanTradesSoldGetParams.setPageNo(i);
            LOGGER.info("start get list by page : {}", i);
            YouzanTradesSoldGetResult tempResult = client.invoke(youzanTradesSoldGet);

            YouzanTradesSoldGetResult.TradeDetailV2[] trades = tempResult.getTrades();
            resultList.addAll(Arrays.asList(trades));
        }

        if (resultList.size() != totalResults) {
            throw new YouzanApiException("get tradesSoldGetResult error : size != totalResults");
        }

        return new Pair<Long, List<YouzanTradesSoldGetResult.TradeDetailV2>>() {
            @Override
            public Long getLeft() {
                return totalResults;
            }

            @Override
            public List<YouzanTradesSoldGetResult.TradeDetailV2> getRight() {
                return resultList;
            }

            @Override
            public List<YouzanTradesSoldGetResult.TradeDetailV2> setValue(List<YouzanTradesSoldGetResult.TradeDetailV2> value) {
                return null;
            }
        };
    }

    public static List<ArkOrder> toArkOrderList(List<YouzanTradesSoldGetResult.TradeDetailV2> tradeList) {
        if (CollectionUtils.isEmpty(tradeList)) {
            return new ArrayList<>();
        }
        List<ArkOrder> ArkOrderList = new ArrayList<>();
        for (YouzanTradesSoldGetResult.TradeDetailV2 tradeDetailV2 : tradeList) {
            ArkOrder arkOrder = ArkOrderPojoHelper.toArkOrder(tradeDetailV2);
            if (arkOrder != null) {
                ArkOrderList.add(arkOrder);
            }
        }
        return ArkOrderList;
    }
}
