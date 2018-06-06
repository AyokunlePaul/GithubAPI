package com.dev.eipeks.graymergetest.core.dagger.modules.network;

import com.dev.eipeks.graymergetest.BuildConfig;
import com.dev.eipeks.graymergetest.core.dagger.scope.AppComponentScope;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module(includes = {OkhttpClientModule.class})
public class RetrofitModule {

    @AppComponentScope
    @Provides
    public Retrofit provideRetrofit(OkHttpClient client, GsonConverterFactory converterFactory,
                                    RxJavaCallAdapterFactory callAdapterFactory){
        Retrofit.Builder builder = new Retrofit.Builder();
        builder.baseUrl(BuildConfig.BASE_URL);
        builder.client(client);
        builder.addCallAdapterFactory(callAdapterFactory);
        builder.addConverterFactory(converterFactory);

        return builder.build();
    }

    @AppComponentScope
    @Provides
    public GsonConverterFactory provideGsonConverterFactory(){
        return GsonConverterFactory.create();
    }

    @AppComponentScope
    @Provides
    public RxJavaCallAdapterFactory provideRxJavaCallAdapterFactory(){
        return RxJavaCallAdapterFactory.create();
    }

}
