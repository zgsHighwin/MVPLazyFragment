package safe.highwin.zgs.mvplazyfragment.presenter;

import android.support.v4.app.FragmentManager;

import java.util.ArrayList;
import java.util.List;

import safe.highwin.zgs.mvplazyfragment.adapter.ViewPagerDetailAdapter;
import safe.highwin.zgs.mvplazyfragment.fragment.DetailVPOneFragment;
import safe.highwin.zgs.mvplazyfragment.fragment.DetailVPThreeFragment;
import safe.highwin.zgs.mvplazyfragment.fragment.DetailVPTwoFragment;
import safe.highwin.zgs.mvplazyfragment.fragment.LazyBaseFragment;
import safe.highwin.zgs.mvplazyfragment.view.DetailFragmentI;


/**
 * Created by zgsHighwin on 2016/6/21.
 */
public class DetailFragmentPresenter {

    List<LazyBaseFragment> mList;
    private ViewPagerDetailAdapter mAdapter;
    private DetailFragmentI mDetailFragmentI;

    public DetailFragmentPresenter(DetailFragmentI detailFragmentI){
        this.mDetailFragmentI  = detailFragmentI;
    }

    public void initFragmentList() {

        if(mList==null){
            mList =new ArrayList<>();
        }
        mList.clear();
        mList.add(DetailVPOneFragment.getInstance());
        mList.add(DetailVPTwoFragment.getInstance());
        mList.add(DetailVPThreeFragment.getInstance());
    }

    public void initAdapter(FragmentManager supportFragmentManager) {
        mAdapter = new ViewPagerDetailAdapter(supportFragmentManager, mList);
        mDetailFragmentI.setAdapter(mAdapter);
    }
}
