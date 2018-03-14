package com.win.news.di.module;

import com.win.news.MyApp;
import com.win.news.net.ApiConstants;
import com.win.news.net.JianDanApi;
import com.win.news.net.JiandanService;
import com.win.news.net.NewsApi;
import com.win.news.net.NewsApiService;
import com.win.news.net.RetrofitConfig;

import java.io.File;
import java.util.concurrent.TimeUnit;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by wenqing .
 * DATE   2018/3/1.
 */
@Module
public class HttpModule {

    @Provides
    OkHttpClient.Builder provideOkHttpClient() {
        // 指定缓存路径,缓存大小100Mb
        Cache cache = new Cache(new File(MyApp.getContext().getCacheDir(), "httpCache"),
                1024 * 1024 * 100);
        return new OkHttpClient().newBuilder().cache(cache)
                .retryOnConnectionFailure(true)
                .addInterceptor(RetrofitConfig.sLoggingInterceptor)
                .addInterceptor(RetrofitConfig.sQueryParameterInterceptor)
                .addNetworkInterceptor(RetrofitConfig.sRewriteCacheControlInterceptor)
                .connectTimeout(10, TimeUnit.SECONDS);
    }


    @Provides
    NewsApi provideNetEaseApis(OkHttpClient.Builder builder) {
        builder.addInterceptor(RetrofitConfig.sQueryParameterInterceptor);
        Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(builder.build());
        return NewsApi.getInstance(retrofitBuilder.baseUrl(ApiConstants.sIFengApi).build()
                .create(NewsApiService.class));
    }

    @Provides
    JianDanApi provideJiandanApis(OkHttpClient.Builder builder){
        Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(builder.build());
        return JianDanApi.getInstance(retrofitBuilder.baseUrl(ApiConstants.sJanDanApi).build()
                .create(JiandanService.class));
    }



}
