package safe.highwin.zgs.mvplazyfragment.presenter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import safe.highwin.zgs.mvplazyfragment.R;
import safe.highwin.zgs.mvplazyfragment.fragment.DetailFragment;
import safe.highwin.zgs.mvplazyfragment.fragment.MainFragment;
import safe.highwin.zgs.mvplazyfragment.fragment.SetFragment;
import safe.highwin.zgs.mvplazyfragment.utils.StringUtil;
import safe.highwin.zgs.mvplazyfragment.view.MainActivityViewI;


/**
 * Created by zgsHighwin on 2016/6/21.
 */
public class MainActivityPresenter {

    private AppCompatActivity context;
    private int mLastFragmentId = R.id.radiobtn_main;
    public static final String RADIOGROUP_MAIN = "RADIOGROUP_MAIN";
    public static final String RADIOGROUP_DETAIL = "RADIOGROUP_DETAIL";
    public static final String RADIOGROUP_SET = "RADIOGROUP_SET";
    private Fragment mLastFragment;
    private MainActivityViewI mMainActivityViewI;

    public MainActivityPresenter(AppCompatActivity context, MainActivityViewI mainActivityViewI) {
        this.context = context;
        this.mMainActivityViewI = mainActivityViewI;
        initRadioGroup();
    }

    private void initRadioGroup() {
        changeFragment(RADIOGROUP_MAIN);
        mLastFragmentId = R.id.radiobtn_main;
    }



    public void radioButtonMain(int checkedId, String radiogroup_tag) {
        if (mLastFragmentId != checkedId) {
            changeFragment(radiogroup_tag);
            mLastFragmentId = checkedId;
        }

        if (mMainActivityViewI != null) {
            mMainActivityViewI.setRadioButtonChecked(checkedId);
        }
    }

    private void changeFragment(String TAG) {
        FragmentManager fragmentManager = context.getSupportFragmentManager();
        Fragment fragmentByTag = fragmentManager.findFragmentByTag(TAG);
        if (fragmentByTag == null) {
            fragmentByTag = createFragmentByTag(TAG);
            addFragment(fragmentByTag, TAG);
        } else {
            showFragment(fragmentByTag);
        }
        mLastFragment = fragmentByTag;
    }

    private void addFragment(Fragment fragmentByTag, String tag) {

        FragmentTransaction fragmentTransaction = context.getSupportFragmentManager().beginTransaction();

        if (mLastFragment != null) {
            fragmentTransaction.hide(mLastFragment);
        }

        fragmentTransaction.add(R.id.framelayout, fragmentByTag, tag);
        fragmentTransaction.commitAllowingStateLoss();
    }

    private void showFragment(Fragment fragmentByTag) {

        FragmentTransaction fragmentTransaction = context.getSupportFragmentManager().beginTransaction();

        if (mLastFragment != null) {
            fragmentTransaction.hide(mLastFragment);
        }
        fragmentTransaction.show(fragmentByTag);
        fragmentTransaction.commitAllowingStateLoss();
    }

    private Fragment createFragmentByTag(String tag) {
        if (StringUtil.isStringEmpty(tag)) {
            return MainFragment.newInstance();
        }

        if (RADIOGROUP_MAIN.equals(tag)) {
            return MainFragment.newInstance();
        }

        if (RADIOGROUP_DETAIL.equals(tag)) {
            return DetailFragment.newInstance();
        }

        if (RADIOGROUP_SET.equals(tag)) {
            return SetFragment.newInstance();
        }

        return MainFragment.newInstance();
    }
}
