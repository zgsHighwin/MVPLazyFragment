package safe.highwin.zgs.mvplazyfragment.utils;

import android.text.TextUtils;

/**
 * Created by zgsHighwin on 2016/6/21.
 */
public class StringUtil {

    public static boolean isStringEmpty(String string){
        return TextUtils.isEmpty(string)&&"null".equals(string);
    }
}
