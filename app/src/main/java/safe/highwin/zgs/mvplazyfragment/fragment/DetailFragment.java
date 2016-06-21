package safe.highwin.zgs.mvplazyfragment.fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import butterknife.InjectView;
import safe.highwin.zgs.mvplazyfragment.R;
import safe.highwin.zgs.mvplazyfragment.adapter.ViewPagerDetailAdapter;
import safe.highwin.zgs.mvplazyfragment.presenter.DetailFragmentPresenter;
import safe.highwin.zgs.mvplazyfragment.view.DetailFragmentI;

/**
 * Created by zgsHighwin on 2016/6/21.
 */
public class DetailFragment extends BaseFragment implements DetailFragmentI {

    @InjectView(R.id.tablayout)
    TabLayout tabLayout;
    @InjectView(R.id.vp_fragment)
    ViewPager vpFragment;
    private DetailFragmentPresenter mPresennter;

    public static DetailFragment newInstance() {
        return new DetailFragment();
    }


    @Override
    protected boolean isButterKnifeInject() {
        return true;
    }

    @Override
    protected void initPresenter() {
        mPresennter = new DetailFragmentPresenter(this);
        mPresennter.initFragmentList();
        mPresennter.initAdapter(getActivity().getSupportFragmentManager());
    }

    @Override
    protected void initView() {
        tabLayout.setLayoutMode(TabLayout.MODE_FIXED);
    }

    @Override
    protected int fragmentLayout() {
        return R.layout.fragment_detail;
    }

    @Override
    public void setAdapter(ViewPagerDetailAdapter adapter) {
        vpFragment.setAdapter(adapter);
        tabLayout.setupWithViewPager(vpFragment);
    }
}
