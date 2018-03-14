package com.win.news.ui.inter;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.win.news.di.component.ApplicationComponent;

/**
 * Created by wenqing .
 * DATE   2018/3/1.
 */

public interface IBase {

    View createView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState);

    View getView();

    int getContentLayout();

    void initInjector(ApplicationComponent applicationComponent);

    void bindView(View view, Bundle saveInstanceState);

    void initData();
}
