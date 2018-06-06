package com.dev.eipeks.graymergetest.core.view;

import android.arch.lifecycle.ViewModel;

import com.dev.eipeks.graymergetest.utils.mappers.HttpExceptionMapper;

import retrofit2.Retrofit;

public class CoreViewModel extends ViewModel {

    private Retrofit retrofit;

    public CoreViewModel(Retrofit retrofit){
        this.retrofit = retrofit;
    }

    protected String getHttpErrorMessage(Throwable throwable){
        return HttpExceptionMapper.getServerMessageFromHttpException(retrofit, throwable);
    }

}
