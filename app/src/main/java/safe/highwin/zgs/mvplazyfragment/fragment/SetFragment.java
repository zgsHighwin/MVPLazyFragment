package safe.highwin.zgs.mvplazyfragment.fragment;


import safe.highwin.zgs.mvplazyfragment.R;

/**
 * Created by zgsHighwin on 2016/6/21.
 */
public class SetFragment extends BaseFragment {


    public static SetFragment newInstance() {
        return new SetFragment();
    }

    @Override
    protected boolean isButterKnifeInject() {
        return false;
    }

    @Override
    protected void initPresenter() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected int fragmentLayout() {
        return R.layout.fragment_set;
    }

}
