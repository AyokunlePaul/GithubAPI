package com.dev.eipeks.graymergetest.core.store;

import com.dev.eipeks.graymergetest.core.api.models.AppBaseModel;
import com.dev.eipeks.graymergetest.core.api.models.RepositoryModel;

import java.util.Map;

import javax.inject.Inject;

import rx.Observable;

public class DataStore {

    private OnlineStore onlineStore;

    @Inject
    public DataStore(OnlineStore onlineStore){
        this.onlineStore = onlineStore;
    }

    public Observable<AppBaseModel<RepositoryModel>> searchTrendingRepositories(Map<String, String> queryMap){
        return onlineStore.searchTrendingRepositories(queryMap);
    }

}
