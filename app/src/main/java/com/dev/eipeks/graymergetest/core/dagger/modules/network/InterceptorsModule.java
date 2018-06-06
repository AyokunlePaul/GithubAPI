package com.dev.eipeks.graymergetest.core.dagger.modules.network;

import android.util.Log;

import com.dev.eipeks.graymergetest.core.dagger.scope.AppComponentScope;

import dagger.Module;
import dagger.Provides;
import okhttp3.logging.HttpLoggingInterceptor;

@Module
public class InterceptorsModule {

    @AppComponentScope
    @Provides
    public HttpLoggingInterceptor provideInterceptor(){
        return new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                //Timber would do a better job here
                Log.d("Interceptor", message);
            }
        });
    }

    //Other interceptors can go here...

}
