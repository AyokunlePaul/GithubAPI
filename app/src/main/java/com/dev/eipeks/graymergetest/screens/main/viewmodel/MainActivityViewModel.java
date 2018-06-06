package com.dev.eipeks.graymergetest.screens.main.viewmodel;

import com.dev.eipeks.graymergetest.core.api.models.AppBaseModel;
import com.dev.eipeks.graymergetest.core.api.models.RepositoryModel;
import com.dev.eipeks.graymergetest.core.store.DataStore;
import com.dev.eipeks.graymergetest.core.view.CoreViewModel;
import com.dev.eipeks.graymergetest.utils.mappers.StringUtils;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import retrofit2.HttpException;
import retrofit2.Retrofit;
import rx.Subscriber;

public class MainActivityViewModel extends CoreViewModel {

    private DataStore dataStore;

    @Inject
    public MainActivityViewModel(DataStore dataStore, Retrofit retrofit) {
        super(retrofit);
        this.dataStore = dataStore;
    }

    public void searchTrendingRepositories(final SearchTrendingRepositoryCallback callback){
        dataStore.searchTrendingRepositories(generateQueryMap()).subscribe(new Subscriber<AppBaseModel<RepositoryModel>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                if (e instanceof HttpException){
                    callback.onHttpExceptionOccur(getHttpErrorMessage(e));
                    return;
                }
                callback.onErrorOccurred(e);
            }

            @Override
            public void onNext(AppBaseModel<RepositoryModel> repositoryModelAppBaseModel) {
                callback.onSearchQuerySuccessful(repositoryModelAppBaseModel.getResponseList());
            }
        });
    }

    private Map<String, String> generateQueryMap(){
        return StringUtils.buildMyQuery("android", "java", "stars", "desc");
    }

    public interface SearchTrendingRepositoryCallback{
        void onSearchQuerySuccessful(List<RepositoryModel> repositoryModels);
        void onHttpExceptionOccur(String errorMessage);
        void onErrorOccurred(Throwable throwable);
    }

}
