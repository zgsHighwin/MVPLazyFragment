package safe.highwin.zgs.mvplazyfragment.fragment;

import android.os.Bundle;

import butterknife.ButterKnife;
import safe.highwin.zgs.mvplazyfragment.R;


/**
 * Created by zgsHighwin on 2016/6/21.
 */
public class DetailVPTwoFragment extends LazyBaseFragment {


    public static DetailVPTwoFragment getInstance(){
        DetailVPTwoFragment detailVPOneFragment = new DetailVPTwoFragment();
        Bundle bundle = new Bundle();
        bundle.putString("fragment","detail_two");
        detailVPOneFragment.setArguments(bundle);
        return detailVPOneFragment;
    }

    @Override
    protected boolean isButterKnifeInject() {
        return true;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_detail_vptwo;
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
