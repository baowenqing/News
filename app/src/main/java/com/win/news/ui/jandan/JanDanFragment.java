package com.win.news.ui.jandan;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;


import com.win.news.R;
import com.win.news.di.component.ApplicationComponent;
import com.win.news.net.JianDanApi;
import com.win.news.ui.adapter.BoredPicAdapter;
import com.win.news.ui.adapter.FreshNewsAdapter;
import com.win.news.ui.adapter.JokesAdapter;
import com.win.news.ui.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * desc: 煎蛋
 * author: Will .
 * date: 2017/9/2 .
 */
public class JanDanFragment extends BaseFragment {

    @BindView(R.id.tablayout)
    TabLayout mTabLayout;
    @BindView(R.id.viewpager)
    ViewPager mViewpager;
    private JanDanPagerAdapter mJanDanPagerAdapter;

    public static JanDanFragment newInstance() {
        Bundle args = new Bundle();
        JanDanFragment fragment = new JanDanFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getContentLayout() {
        return R.layout.fragment_jiandan;
    }

    @Override
    public void initInjector(ApplicationComponent applicationComponent) {

    }


    @Override
    public void bindView(View view, Bundle savedInstanceState) {
    }

    @Override
    public void initData() {
        List<String> strings = new ArrayList<>();
        strings.add("新鲜事");
        strings.add("无聊图");
        strings.add("妹子图");
        strings.add("段子");
        mJanDanPagerAdapter = new JanDanPagerAdapter(getChildFragmentManager(), strings);
        mViewpager.setAdapter(mJanDanPagerAdapter);
        mViewpager.setOffscreenPageLimit(1);
        mViewpager.setCurrentItem(0, false);
        mTabLayout.setupWithViewPager(mViewpager, true);
    }

    @Override
    public void onRetry() {

    }

    public class JanDanPagerAdapter extends FragmentStatePagerAdapter {
        private List<String> titles;

        public JanDanPagerAdapter(FragmentManager fm, List<String> titles) {
            super(fm);
            this.titles = titles;
        }

        @Override
        public BaseFragment getItem(int position) {
            switch (position) {
                case 0:
                    return JdDetailFragment.newInstance(JianDanApi.TYPE_FRESH,new FreshNewsAdapter(getActivity(),null));
                case 1:
                    return JdDetailFragment.newInstance(JianDanApi.TYPE_BORED,new BoredPicAdapter(getActivity(),null));
                case 2:
                    return JdDetailFragment.newInstance(JianDanApi.TYPE_GIRLS,new BoredPicAdapter(getActivity(),null));
                case 3:
                    return JdDetailFragment.newInstance(JianDanApi.TYPE_Duan,new JokesAdapter(null));
            }
            return null;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles.get(position);
        }

        @Override
        public int getCount() {
            return titles.size();
        }

        @Override
        public int getItemPosition(Object object) {
            return POSITION_NONE;
        }

    }

}
