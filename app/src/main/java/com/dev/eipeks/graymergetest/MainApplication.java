package com.dev.eipeks.graymergetest;

import android.app.Activity;
import android.app.Application;

import com.dev.eipeks.graymergetest.core.dagger.components.AppComponent;
import com.dev.eipeks.graymergetest.core.dagger.components.DaggerAppComponent;
import com.dev.eipeks.graymergetest.core.dagger.modules.external.ContextModule;
import com.facebook.drawee.backends.pipeline.Fresco;

public class MainApplication extends Application {

    private AppComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        component = DaggerAppComponent.builder().contextModule(new ContextModule(this)).build();
        Fresco.initialize(this);
    }

    public static MainApplication get(Activity activity){
        return (MainApplication)activity.getApplication();
    }

    public AppComponent getComponent() {
        return component;
    }
}
