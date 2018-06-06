package com.dev.eipeks.graymergetest.core.dagger.components;

import com.dev.eipeks.graymergetest.core.dagger.modules.network.RetrofitModule;
import com.dev.eipeks.graymergetest.core.dagger.scope.AppComponentScope;
import com.dev.eipeks.graymergetest.screens.main.activity.MainActivity;

import dagger.Component;

@AppComponentScope
@Component(modules = {RetrofitModule.class})
public interface AppComponent {
    void inject(MainActivity mainActivity);
}
