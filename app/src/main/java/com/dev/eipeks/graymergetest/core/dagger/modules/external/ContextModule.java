package com.dev.eipeks.graymergetest.core.dagger.modules.external;

import android.content.Context;

import com.dev.eipeks.graymergetest.core.dagger.scope.AppComponentScope;

import dagger.Module;
import dagger.Provides;

@Module
public class ContextModule {

    private Context context;

    public ContextModule(Context context){
        this.context = context;
    }

    @Provides
    @AppComponentScope
    public Context provideContext(){
        return context;
    }


}
