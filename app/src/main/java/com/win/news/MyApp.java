package com.win.news;

import com.win.news.di.component.ApplicationComponent;
import com.win.news.di.component.DaggerApplicationComponent;
import com.win.news.di.module.ApplicationModule;
import com.win.news.di.module.HttpModule;
import com.win.news.utils.ContextUtils;

import org.litepal.LitePal;
import org.litepal.LitePalApplication;

import cn.bingoogolapple.swipebacklayout.BGASwipeBackManager;

/**
 * Created by wenqing .
 * DATE   2018/3/1.
 */

public class MyApp extends LitePalApplication {

    private ApplicationComponent mApplicationComponent;
    private static MyApp sMyApp;

    public static int width = 0;

    public static int height = 0;

    @Override
    public void onCreate() {
        super.onCreate();
        sMyApp = this;
        BGASwipeBackManager.getInstance().init(this);
        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .httpModule(new HttpModule())
                .build();
        LitePal.initialize(this);
        width = ContextUtils.getSreenWidth(MyApp.getContext());
        height = ContextUtils.getSreenHeight(MyApp.getContext());
    }

    public static MyApp getInstance() {
        if (sMyApp == null) {
            synchronized (MyApp.class) {
                if (sMyApp == null) {
                    sMyApp = new MyApp();
                }
            }
        }
        return sMyApp;
    }

    public ApplicationComponent getApplicationComponent() {
        return mApplicationComponent;
    }
}
