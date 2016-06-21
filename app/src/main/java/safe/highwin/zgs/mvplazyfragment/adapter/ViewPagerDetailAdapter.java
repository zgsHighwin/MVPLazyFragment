package safe.highwin.zgs.mvplazyfragment.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

import safe.highwin.zgs.mvplazyfragment.fragment.LazyBaseFragment;


/**
 * Created by zgsHighwin on 2016/6/21.
 */
public class ViewPagerDetailAdapter extends FragmentPagerAdapter {

    private List<LazyBaseFragment> mList;

    public ViewPagerDetailAdapter(FragmentManager fm,List<LazyBaseFragment> list) {
        super(fm);
        this.mList = list;
    }

    @Override
    public Fragment getItem(int position) {
        return mList.get(position);
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mList.get(position).getArguments().getString("fragment");
    }
}
