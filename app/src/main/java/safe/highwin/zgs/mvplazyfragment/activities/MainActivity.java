package safe.highwin.zgs.mvplazyfragment.activities;

import android.util.Log;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import butterknife.InjectView;
import safe.highwin.zgs.mvplazyfragment.R;
import safe.highwin.zgs.mvplazyfragment.presenter.MainActivityPresenter;
import safe.highwin.zgs.mvplazyfragment.view.MainActivityViewI;


/**
 * Created by zgsHighwin on 2016/6/21.
 */
public class MainActivity extends BaseActivity implements MainActivityViewI, RadioGroup.OnCheckedChangeListener {


    @InjectView(R.id.framelayout)
    FrameLayout framelayout;
    @InjectView(R.id.radiobtn_main)
    RadioButton radiobtnMain;
    @InjectView(R.id.radiobtn_detail)
    RadioButton radiobtnDetail;
    @InjectView(R.id.radiobtn_set)
    RadioButton radiobtnSet;
    @InjectView(R.id.radiogroup)
    RadioGroup radiogroup;
    private MainActivityPresenter mPresenter;

    @Override
    protected boolean isButterKnifeInject() {
        return true;
    }

    @Override
    protected void initPresenter() {
        mPresenter = new MainActivityPresenter(this, this);
    }

    @Override
    protected void initView() {
        radiogroup.setOnCheckedChangeListener(this);
    }

    @Override
    protected int layout() {
        return R.layout.activity_main;
    }

    @Override
    public void setRadioButtonChecked(int checkedId) {
        Log.i("MainActivity", "checkedId:" + checkedId);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.radiobtn_main:
                mPresenter.radioButtonMain(checkedId, MainActivityPresenter.RADIOGROUP_MAIN);
                break;
            case R.id.radiobtn_detail:
                mPresenter.radioButtonMain(checkedId, MainActivityPresenter.RADIOGROUP_DETAIL);
                break;
            case R.id.radiobtn_set:
                mPresenter.radioButtonMain(checkedId, MainActivityPresenter.RADIOGROUP_SET);
                break;
        }
    }
}
