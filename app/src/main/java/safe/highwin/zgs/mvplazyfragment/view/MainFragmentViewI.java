package safe.highwin.zgs.mvplazyfragment.view;

import android.view.View;

import safe.highwin.zgs.mvplazyfragment.adapter.ViewPagerMainAdapter;


/**
 * Created by zgsHighwin on 2016/6/21.
 */
public interface MainFragmentViewI {


    void setAdapter(ViewPagerMainAdapter adapter);

    void setDotStatus(int child);

    void addView(View view);

}
