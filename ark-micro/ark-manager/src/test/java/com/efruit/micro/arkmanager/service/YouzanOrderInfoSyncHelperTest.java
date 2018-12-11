package com.efruit.micro.arkmanager.service;

import com.efruit.micro.arkmanager.BaseTest;
import com.efruit.micro.youzan.common.YouzanApiException;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class YouzanOrderInfoSyncHelperTest extends BaseTest {
    @Autowired
    YouzanOrderInfoSyncHelper youzanOrderInfoSyncHelper;

    @Test
    public void testSync() throws YouzanApiException {
        youzanOrderInfoSyncHelper.syncAllYouzanOrder();
    }
}
