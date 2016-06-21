package safe.highwin.zgs.mvplazyfragment.activities;

import android.content.Intent;
import android.view.animation.AlphaAnimation;
import android.widget.RelativeLayout;

import butterknife.InjectView;
import safe.highwin.zgs.mvplazyfragment.R;
import safe.highwin.zgs.mvplazyfragment.presenter.WelcomeActivityPresenter;
import safe.highwin.zgs.mvplazyfragment.view.WelcomeActivityI;

/**
 * Created by zgsHighwin on 2016/6/21.
 */
public class WelcomeActivity extends BaseActivity implements WelcomeActivityI {

    @InjectView(R.id.relativelayout_welcome)
    RelativeLayout relativelayoutWelcome;
    private WelcomeActivityPresenter mPrenseter;
   // private RelativeLayout mRelativeLayoutWelcome;

    @Override
    protected boolean isButterKnifeInject() {
        return true;
    }

    @Override
    protected void initPresenter() {
        mPrenseter = new WelcomeActivityPresenter(this, this);
        mPrenseter.setRxTimer();
        mPrenseter.startAlphaAnimation();
    }

    @Override
    protected void initView() {}


    @Override
    protected int layout() {
        return R.layout.activity_welcome;
    }

    @Override
    public void startActivity() {
        startActivity(new Intent(WelcomeActivity.this, MainActivity.class));
        finish();
    }

    @Override
    public void startAnimation(AlphaAnimation alphaAnimation) {
        relativelayoutWelcome.startAnimation(alphaAnimation);
    }

}
