package com.efruit.micro.youzan.common;

import com.efruit.micro.youzan.sdk.api.YouzanTradesSoldGet;
import com.efruit.micro.youzan.sdk.model.YouzanTradesSoldGetParams;
import com.efruit.micro.youzan.sdk.model.YouzanTradesSoldGetResult;
import com.youzan.open.sdk.client.auth.Token;
import com.youzan.open.sdk.client.core.DefaultYZClient;
import com.youzan.open.sdk.client.core.YZClient;
import org.apache.commons.lang3.tuple.Pair;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class TradesSoldGetV4Helper {
    private static final Logger LOGGER = LoggerFactory.getLogger(TradesSoldGetV4Helper.class);

    private String token;

    public TradesSoldGetV4Helper(String token) {
        this.token = token;
    }

    public List<YouzanTradesSoldGetResult.StructurizationTrade> getTradeList(Date start, Date end) throws YouzanApiException {

        final Long totalResults = getTotal(start, end);
        if (totalResults > 10000) {
            return getTradeListByPeriod(start, end);
        } else {
            return innerGetTradeList(start, end);
        }
    }

    private List<YouzanTradesSoldGetResult.StructurizationTrade> getTradeListByPeriod(Date start, Date end) throws YouzanApiException {
        final List<YouzanTradesSoldGetResult.StructurizationTrade> result = new ArrayList<>();
        final DateTime endDateTime = new DateTime(end);

        DateTime tempStart = new DateTime(start);
        DateTime tempEnd = null;
        final int factor = 1;
        do {
            if (tempEnd == null) {
                tempEnd = tempStart.plusDays(factor);
            } else {
                tempStart = tempEnd;
                tempEnd = tempEnd.plusDays(factor);
            }

            if (tempEnd.getMillis() > endDateTime.getMillis()) {
                tempEnd = new DateTime(endDateTime);
            }

            final List<YouzanTradesSoldGetResult.StructurizationTrade> tempList = innerGetTradeList(tempStart.toDate(), endDateTime.toDate());
            result.addAll(tempList);
        } while (tempEnd.getMillis() < endDateTime.getMillis());

        return result;
    }

    private Long getTotal(Date start, Date end) {
        YZClient client = new DefaultYZClient(new Token(token));
        YouzanTradesSoldGetParams youzanTradesSoldGetParams = new YouzanTradesSoldGetParams();

        long pageSize = 100L;
        youzanTradesSoldGetParams.setPageSize(pageSize);
        youzanTradesSoldGetParams.setStartCreated(start);
        youzanTradesSoldGetParams.setEndCreated(end);

        YouzanTradesSoldGet youzanTradesSoldGet = new YouzanTradesSoldGet();
        youzanTradesSoldGet.setAPIParams(youzanTradesSoldGetParams);
        YouzanTradesSoldGetResult result = client.invoke(youzanTradesSoldGet);

        return result.getTotalResults();
    }

    private List<YouzanTradesSoldGetResult.StructurizationTrade> innerGetTradeList(Date start, Date end) throws YouzanApiException {
        YZClient client = new DefaultYZClient(new Token(token));
        YouzanTradesSoldGetParams youzanTradesSoldGetParams = new YouzanTradesSoldGetParams();

        long pageSize = 100L;
        youzanTradesSoldGetParams.setPageSize(pageSize);
        youzanTradesSoldGetParams.setStartCreated(start);
        youzanTradesSoldGetParams.setEndCreated(end);

        YouzanTradesSoldGet youzanTradesSoldGet = new YouzanTradesSoldGet();
        youzanTradesSoldGet.setAPIParams(youzanTradesSoldGetParams);
        YouzanTradesSoldGetResult result = client.invoke(youzanTradesSoldGet);

        final Long totalResults = result.getTotalResults();
        if (totalResults > 10000) {
            throw new YouzanApiException("totalResults > 10000");
        }

        final List<YouzanTradesSoldGetResult.StructurizationTrade> resultList = new ArrayList<>();

        long totalPageSize;
        if (totalResults % pageSize == 0) {
            totalPageSize = (totalResults / pageSize);
        } else {
            totalPageSize = (totalResults / pageSize) + 1;
        }

        // totalPageSize不能超过100，否则：订单列表查询失败,错误信息:分页数不能超过100页

        LOGGER.info("getTradeList()-V4 : totalPageSize : {} , totalResults : {}", totalPageSize, totalResults);
        for (long i = 1; i <= totalPageSize; i++) {
            youzanTradesSoldGetParams.setPageNo(i);
            LOGGER.info("getTradeList()-V4 start get list by page : {}", i);
            YouzanTradesSoldGetResult tempResult = client.invoke(youzanTradesSoldGet);

            YouzanTradesSoldGetResult.StructurizationTrade[] trades = tempResult.getFullOrderInfoList();
            resultList.addAll(Arrays.asList(trades));
        }

        if (resultList.size() != totalResults) {
            throw new YouzanApiException("getTradeList()-V4 tradesSoldGetResult error : size != totalResults");
        }

        return resultList;

    }

}
