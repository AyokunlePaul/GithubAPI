package com.dev.eipeks.graymergetest.core.dagger.modules.network;

import android.content.Context;

import com.dev.eipeks.graymergetest.core.dagger.modules.external.ContextModule;
import com.dev.eipeks.graymergetest.core.dagger.scope.AppComponentScope;

import java.io.File;
import java.util.concurrent.TimeUnit;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

@Module(includes = {InterceptorsModule.class, ContextModule.class})
public class OkhttpClientModule {

    @AppComponentScope
    @Provides
    public OkHttpClient provideOkhttpClient(HttpLoggingInterceptor interceptor, Cache cache){
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.cache(cache);
        builder.addNetworkInterceptor(interceptor);
        builder.writeTimeout(120, TimeUnit.SECONDS);
        builder.readTimeout(120, TimeUnit.SECONDS);

        return builder.build();
    }

    @AppComponentScope
    @Provides
    public Cache provideNetworkRequestCache(File file){
        return new Cache(file, 10 * 1000 * 1000);
    }

    @AppComponentScope
    @Provides
    public File provideCacheFile(Context context){
        return new File(context.getCacheDir(), "gray_merge_test");
    }

}
