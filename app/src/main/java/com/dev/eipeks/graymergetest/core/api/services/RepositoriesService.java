package com.dev.eipeks.graymergetest.core.api.services;

import com.dev.eipeks.graymergetest.core.api.models.AppBaseModel;
import com.dev.eipeks.graymergetest.core.api.models.RepositoryModel;

import java.util.Map;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import rx.Observable;

public interface RepositoriesService {
    @GET("/search/repositories")
    Observable<AppBaseModel<RepositoryModel>> searchTrendingRepositories(@QueryMap Map<String, String> queryMap);
}
