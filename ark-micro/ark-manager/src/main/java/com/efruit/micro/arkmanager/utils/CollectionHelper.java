package com.efruit.micro.arkmanager.utils;

import org.apache.commons.collections.CollectionUtils;

import java.util.List;

public class CollectionHelper<T> {

    public interface Callback<T> {
        void onGothrough(List<T> list);
    }

    public void forCollectionByPage(List<T> list, int pageSize, Callback<T> callback) {
        if (CollectionUtils.isEmpty(list)) {
            return;
        }
        final int totalSize = list.size();
        int requestTimes = totalSize / pageSize;
        for (int i = 0; i <= requestTimes; i++) {
            int fromIndex = i * pageSize;
            int toIndex = Math.min(totalSize, (i + 1) * pageSize);

            List<T> tempList = list.subList(fromIndex, toIndex);
            if (callback != null) {
                callback.onGothrough(tempList);
            }

            if (toIndex == totalSize) {
                break;
            }
        }
    }


}
