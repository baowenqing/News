package com.win.news.di.component;

import com.win.news.di.module.ApplicationModule;
import com.win.news.ui.jandan.JdDetailFragment;
import com.win.news.ui.news.ArticleReadActivity;
import com.win.news.ui.news.ImageBrowseActivity;
import com.win.news.ui.news.NewsFragment;
import com.win.news.ui.video.DetailFragment;
import com.win.news.ui.video.VideoFragment;

import dagger.Component;

/**
 * Created by wenqing .
 * DATE   2018/3/1.
 */
@Component(dependencies = ApplicationComponent.class)
public interface HttpComponent {
    void inject(VideoFragment videoFragment);

    void inject(DetailFragment detailFragment);

    void inject(JdDetailFragment jdDetailFragment);

    void inject(ImageBrowseActivity imageBrowseActivity);

    void inject(com.win.news.ui.news.DetailFragment detailFragment);

    void inject(ArticleReadActivity articleReadActivity);

    void inject(NewsFragment newsFragment);


}
