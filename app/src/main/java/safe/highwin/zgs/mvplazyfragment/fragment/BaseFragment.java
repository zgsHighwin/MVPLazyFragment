package safe.highwin.zgs.mvplazyfragment.fragment;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * Created by zgsHighwin on 2016/6/21.
 */
public abstract class BaseFragment extends com.trello.rxlifecycle.components.support.RxFragment {

    private View mConvertView;
    private SparseArray<View> mViews;

    private boolean isButterKnife;
    @Nullable
    @Override
    public final View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mViews = new SparseArray<>();
        mConvertView = inflater.inflate(fragmentLayout(), container, false);
        isButterKnife = isButterKnifeInject();
        if(isButterKnife){
            ButterKnife.inject(this,mConvertView);
        }
        return mConvertView;
    }


    protected abstract boolean isButterKnifeInject();

    @Override
    public final void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
        initPresenter();
    }

    protected abstract void initPresenter();

    protected abstract void initView();

    @LayoutRes
    protected abstract int fragmentLayout();


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

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if(isButterKnife){
            ButterKnife.reset(this);
            isButterKnife = false;
        }

    }

}
