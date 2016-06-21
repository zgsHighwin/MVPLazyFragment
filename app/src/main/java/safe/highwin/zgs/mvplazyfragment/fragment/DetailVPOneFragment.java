package safe.highwin.zgs.mvplazyfragment.fragment;

import android.os.Bundle;

import butterknife.ButterKnife;
import safe.highwin.zgs.mvplazyfragment.R;


/**
 * Created by zgsHighwin on 2016/6/21.
 */
public class DetailVPOneFragment extends LazyBaseFragment {

    public static DetailVPOneFragment getInstance(){
        DetailVPOneFragment detailVPOneFragment = new DetailVPOneFragment();
        Bundle bundle = new Bundle();
        bundle.putString("fragment","detail_one");
        detailVPOneFragment.setArguments(bundle);
        return detailVPOneFragment;
    }

    @Override
    protected boolean isButterKnifeInject() {
        return true;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_detail_vpone;
    }

    @Override
    protected void initView() {
    }

    @Override
    protected void initPresenter() {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }
}
