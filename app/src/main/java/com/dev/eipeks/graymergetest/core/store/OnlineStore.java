package com.dev.eipeks.graymergetest.core.store;

import com.dev.eipeks.graymergetest.core.api.models.AppBaseModel;
import com.dev.eipeks.graymergetest.core.api.models.RepositoryModel;
import com.dev.eipeks.graymergetest.core.api.services.RepositoriesService;

import java.util.Map;

import javax.inject.Inject;

import retrofit2.Retrofit;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class OnlineStore {

    private RepositoriesService repositoriesService;

    @Inject
    public OnlineStore(Retrofit retrofit){
        repositoriesService = retrofit.create(RepositoriesService.class);
    }

    public Observable<AppBaseModel<RepositoryModel>> searchTrendingRepositories(Map<String, String> queryMap){
        return repositoriesService.searchTrendingRepositories(queryMap)
                .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }
}
