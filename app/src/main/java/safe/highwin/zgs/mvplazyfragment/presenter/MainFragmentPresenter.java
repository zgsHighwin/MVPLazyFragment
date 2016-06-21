package safe.highwin.zgs.mvplazyfragment.presenter;

import android.view.View;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import safe.highwin.zgs.mvplazyfragment.LLWPApplication;
import safe.highwin.zgs.mvplazyfragment.R;
import safe.highwin.zgs.mvplazyfragment.adapter.ViewPagerMainAdapter;
import safe.highwin.zgs.mvplazyfragment.view.MainFragmentViewI;


/**
 * Created by zgsHighwin on 2016/6/21.
 */
public class MainFragmentPresenter {

/*    private final ViewPager mViewPagerMain;*/
    private final ViewPagerMainAdapter mAdapter;
/*    private final LinearLayout mLinearLayoutDot;*/
    private MainFragmentViewI mMainFragmentViewI;

    private List<Integer> list;

    private boolean mIsInit = false;

    public MainFragmentPresenter(MainFragmentViewI mainFragmentViewI) {
        mMainFragmentViewI = mainFragmentViewI;
        initListViewData();
        mAdapter = new ViewPagerMainAdapter(LLWPApplication.getInstance(), list);
        mainFragmentViewI.setAdapter(mAdapter);
        initDot();
    }

    public void setDotsStatus() {
        for (int i = 0; i <  list.size(); i++) {
            mMainFragmentViewI.setDotStatus(i);
        }
    }

    private void initDot() {
        for (int i = 0; i < list.size(); i++) {
            View view = new View(LLWPApplication.getInstance());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(30, 30);
            view.setLayoutParams(layoutParams);
            layoutParams.bottomMargin = 10;
            layoutParams.leftMargin = 12;
            view.setBackgroundResource(R.drawable.select_dots);
            mMainFragmentViewI.addView(view);
        }
        setDotsStatus();
    }

    private void initListViewData() {

        if(list==null){
            list = new ArrayList<>();
        }else {
            list.clear();
        }
        for (int i = 0; i < 4; i++) {
            list.add(R.mipmap.viewpager_main);
        }
    }
}
