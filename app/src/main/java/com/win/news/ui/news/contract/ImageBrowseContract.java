package com.win.news.ui.news.contract;

import com.win.news.bean.NewsArticleBean;
import com.win.news.ui.base.BaseContract;

/**
 * desc: .
 * author: Will .
 * date: 2017/9/7 .
 */
public interface ImageBrowseContract {

    interface View extends BaseContract.BaseView{

        void loadData(NewsArticleBean newsArticleBean);

    }

    interface Presenter extends BaseContract.BasePresenter<View>{

        void getData(String aid, boolean isCmpp);

    }

}
