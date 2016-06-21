package safe.highwin.zgs.mvplazyfragment.fragment;

import android.os.Bundle;

import butterknife.ButterKnife;
import safe.highwin.zgs.mvplazyfragment.R;


/**
 * Created by zgsHighwin on 2016/6/21.
 */
public class DetailVPThreeFragment extends LazyBaseFragment {


    public static DetailVPThreeFragment getInstance(){
        DetailVPThreeFragment detailVPOneFragment = new DetailVPThreeFragment();
        Bundle bundle = new Bundle();
        bundle.putString("fragment","detail_three");
        detailVPOneFragment.setArguments(bundle);
        return detailVPOneFragment;
    }

    @Override
    protected boolean isButterKnifeInject() {
        return true;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_detail_vpthree;
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
