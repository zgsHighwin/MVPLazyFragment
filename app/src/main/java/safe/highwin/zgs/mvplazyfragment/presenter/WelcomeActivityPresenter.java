package safe.highwin.zgs.mvplazyfragment.presenter;

import android.util.Log;
import android.view.animation.AlphaAnimation;

import com.trello.rxlifecycle.ActivityEvent;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.schedulers.Schedulers;
import safe.highwin.zgs.mvplazyfragment.view.WelcomeActivityI;

/**
 * Created by zgsHighwin on 2016/6/21.
 */
public class WelcomeActivityPresenter {

    private RxAppCompatActivity mCtx;
    private WelcomeActivityI mWelcomeActivityI;

    public WelcomeActivityPresenter(RxAppCompatActivity context, WelcomeActivityI welcomeActivityI) {
        this.mCtx = context;
        this.mWelcomeActivityI = welcomeActivityI;
    }

    public void setRxTimer() {
        Observable.timer(3000, TimeUnit.MILLISECONDS).doOnUnsubscribe(new Action0() {
            @Override
            public void call() {
                Log.i("WelcomeActivity", "doOnUnsubscribe");
            }
        }).compose(mCtx.<Long>bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1<Long>() {
            @Override
            public void call(Long aLong) {
                mWelcomeActivityI.startActivity();
            }
        });
    }

    public void startAlphaAnimation(){
        AlphaAnimation aa = new AlphaAnimation(0f, 1f);
        aa.setDuration(3000);
        aa.setFillAfter(true);
        mWelcomeActivityI.startAnimation(aa);
    }
}
