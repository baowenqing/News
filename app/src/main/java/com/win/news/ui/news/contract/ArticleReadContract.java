package com.win.news.ui.news.contract;

import com.win.news.bean.NewsArticleBean;
import com.win.news.ui.base.BaseContract;

/**
 * desc: .
 * author: Will .
 * date: 2017/9/7 .
 */
public interface ArticleReadContract {

    interface View extends BaseContract.BaseView{

        void loadData(NewsArticleBean articleBean);

    }

    interface Presenter extends BaseContract.BasePresenter<View>{

        void getData(String aid);

    }

}
