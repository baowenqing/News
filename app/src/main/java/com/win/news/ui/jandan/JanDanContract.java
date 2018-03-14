package com.win.news.ui.jandan;


import com.win.news.bean.FreshNewsBean;
import com.win.news.bean.JdDetailBean;
import com.win.news.ui.base.BaseContract;

/**
 * desc: .
 * author: Will .
 * date: 2017/9/27 .
 */
public interface JanDanContract {

    interface View extends BaseContract.BaseView {

        void loadFreshNews(FreshNewsBean freshNewsBean);

        void loadMoreFreshNews(FreshNewsBean freshNewsBean);

        void loadDetailData(String type, JdDetailBean jdDetailBean);

        void loadMoreDetailData(String type, JdDetailBean jdDetailBean);

    }

    interface Presenter extends BaseContract.BasePresenter<View> {

        void getData(String type, int page);

        void getFreshNews(int page);

        void getDetailData(String type, int page);

    }
}
