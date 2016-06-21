package safe.highwin.zgs.mvplazyfragment.activities;

import android.os.Bundle;
import android.util.SparseArray;
import android.view.View;

import com.trello.rxlifecycle.components.support.RxAppCompatActivity;

import butterknife.ButterKnife;

/**
 * Created by zgsHighwin on 2016/6/21.
 */
public abstract class BaseActivity extends RxAppCompatActivity {

    private View mConvertView;
    private boolean isButterKnife;
    private SparseArray<View> mViews;

    @Override
    protected final void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mConvertView = View.inflate(this, layout(), null);
        setContentView(mConvertView);
        isButterKnife = isButterKnifeInject();
        if (isButterKnife) {
            ButterKnife.inject(this, mConvertView);
        }
        mViews = new SparseArray<>();
        initView();
        initPresenter();
    }

    protected abstract boolean isButterKnifeInject();

    protected abstract void initPresenter();

    protected abstract void initView();

    protected abstract int layout();

    /**
     * fragment中可以通过这个方法直接找到需要的view，而不需要进行类型强转
     *
     * @param viewId
     * @param <E>
     * @return
     */
    protected <E extends View> E findView(int viewId) {
        if (mConvertView != null) {
            E view = (E) mViews.get(viewId);
            if (view == null) {
                view = (E) mConvertView.findViewById(viewId);
                mViews.put(viewId, view);
            }
            return view;
        }
        return null;
    }

}
