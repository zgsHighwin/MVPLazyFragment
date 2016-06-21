package safe.highwin.zgs.mvplazyfragment.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

import safe.highwin.zgs.mvplazyfragment.R;


/**
 * Created by zgsHighwin on 2016/6/21.
 */
public class ViewPagerMainAdapter extends PagerAdapter {

    private List<Integer> mList;
    private Context mCtx;

    public ViewPagerMainAdapter(Context context, List<Integer> list) {
        this.mList = list;
        this.mCtx = context;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = View.inflate(mCtx, R.layout.viewpager_main, null);
        ImageView ivViewPager = (ImageView) view.findViewById(R.id.iv_viewpager_main);
        ivViewPager.setImageResource(mList.get(position));
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public int getCount() {
        return mList.size();
    }
}
