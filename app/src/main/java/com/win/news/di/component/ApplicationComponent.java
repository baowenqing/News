package com.win.news.di.component;

import android.content.Context;

import com.win.news.MyApp;
import com.win.news.di.module.ApplicationModule;
import com.win.news.di.module.HttpModule;
import com.win.news.net.JianDanApi;
import com.win.news.net.NewsApi;

import dagger.Component;

/**
 * Created by wenqing .
 * DATE   2018/3/1.
 */
@Component(modules = {ApplicationModule.class, HttpModule.class})
public interface ApplicationComponent {

    MyApp getApplition();

    NewsApi getNetEaseApi();
//
    JianDanApi getJianDanApi();

    Context getContext();

}
