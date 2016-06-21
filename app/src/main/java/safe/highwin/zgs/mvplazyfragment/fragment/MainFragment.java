package safe.highwin.zgs.mvplazyfragment.fragment;

import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.LinearLayout;

import java.util.List;

import butterknife.InjectView;
import safe.highwin.zgs.mvplazyfragment.R;
import safe.highwin.zgs.mvplazyfragment.adapter.ViewPagerMainAdapter;
import safe.highwin.zgs.mvplazyfragment.presenter.MainFragmentPresenter;
import safe.highwin.zgs.mvplazyfragment.view.MainFragmentViewI;

/**
 * Created by zgsHighwin on 2016/6/21.
 */
public class MainFragment extends BaseFragment implements MainFragmentViewI, ViewPager.OnPageChangeListener {

    @InjectView(R.id.viewpager_main)
    ViewPager viewpagerMain;
    @InjectView(R.id.linearlayout_dot)
    LinearLayout linearlayoutDot;
    private List<View> list;
    private MainFragmentPresenter mMainFragmentPresenter;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Override
    protected boolean isButterKnifeInject() {
        return true;
    }

    @Override
    protected void initPresenter() {
        mMainFragmentPresenter = new MainFragmentPresenter(this);
    }

    @Override
    protected void initView() {
        viewpagerMain.setOnPageChangeListener(this);
    }

    @Override
    protected int fragmentLayout() {
        return R.layout.fragment_main;
    }

    @Override
    public void setAdapter(ViewPagerMainAdapter adapter) {
        viewpagerMain.setAdapter(adapter);
    }

    @Override
    public void setDotStatus(int child) {
        linearlayoutDot.getChildAt(child).setEnabled(child == viewpagerMain.getCurrentItem());
    }

    @Override
    public void addView(View view) {
        linearlayoutDot.addView(view);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }

    @Override
    public void onPageSelected(int position) {
        mMainFragmentPresenter.setDotsStatus();
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

}
