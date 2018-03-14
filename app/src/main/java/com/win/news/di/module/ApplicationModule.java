package com.win.news.di.module;

import android.content.Context;

import com.win.news.MyApp;

import dagger.Module;
import dagger.Provides;

/**
 * Created by wenqing .
 * DATE   2018/3/1.
 */
@Module
public class ApplicationModule {

    private Context mContext;

    public ApplicationModule(Context context) {
        this.mContext = context;
    }

    @Provides
     MyApp provideApplication() {
        return (MyApp) mContext.getApplicationContext();
    }

    @Provides
     Context provideContext() {
        return mContext;
    }


}
