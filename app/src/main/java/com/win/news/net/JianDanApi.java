package com.win.news.net;

import android.support.annotation.StringDef;

import com.win.news.bean.FreshNewsArticleBean;
import com.win.news.bean.FreshNewsBean;
import com.win.news.bean.JdDetailBean;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import io.reactivex.Observable;

/**
 * Created by wenqing .
 * DATE   2018/3/1.
 */

public class JianDanApi {

    public static final String TYPE_FRESH = "get_recent_posts";
    public static final String TYPE_FRESHARTICLE = "get_post";
    public static final String TYPE_BORED = "jandan.get_pic_comments";
    public static final String TYPE_GIRLS = "jandan.get_ooxx_comments";
    public static final String TYPE_Duan = "jandan.get_duan_comments";

    @StringDef({TYPE_FRESH, TYPE_BORED, TYPE_FRESHARTICLE,TYPE_GIRLS,TYPE_Duan})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Type {
    }

    public static JianDanApi sInstance;

    private JiandanService mService;


    private JianDanApi(JiandanService service) {
        this.mService = service;
    }

    public static JianDanApi getInstance(JiandanService service) {
        if (sInstance == null)
            sInstance = new JianDanApi(service);
        return sInstance;
    }


    /**
     * 获取新鲜事列表
     *
     * @param page 页码
     * @return
     */
    public Observable<FreshNewsBean> getFreshNews(int page) {
        return mService.getFreshNews(ApiConstants.sJanDanApi, TYPE_FRESH,
                "url,date,tags,author,title,excerpt,comment_count,comment_status,custom_fields",
                page, "thumb_c,views", "1");
    }

    /**
     * 获取 无聊图，妹子图，段子列表
     *
     * @param type {@link Type}
     * @param page 页码
     * @return
     */
    public Observable<JdDetailBean> getJdDetails(@Type String type, int page) {
        return mService.getDetailData(ApiConstants.sJanDanApi, type, page);
    }

    /**
     * 获取新鲜事文章详情
     *
     * @param id PostsBean id {@link FreshNewsBean.PostsBean}
     * @return
     */
    public Observable<FreshNewsArticleBean> getFreshNewsArticle(int id) {
        return mService.getFreshNewsArticle(ApiConstants.sJanDanApi, TYPE_FRESHARTICLE, "content,date,modified", id);
    }


}
