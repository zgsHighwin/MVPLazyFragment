package safe.highwin.zgs.mvplazyfragment;

import android.app.Application;

/**
 * Created by zgsHighwin on 2016/6/21.
 */
public class LLWPApplication extends Application {

    private static LLWPApplication mInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
    }

    public static LLWPApplication getInstance() {
        return mInstance;
    }
}
