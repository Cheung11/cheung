package detech.com.detechtest;

import android.app.Application;

import com.detect.androidutils.custom.LogUtil;

/**
 * Created by Luke O on 2017/12/11.
 */

public class MyApplication extends Application {

    private static final String TAG = MyApplication.class.getSimpleName();

    @Override
    public void onCreate() {
        super.onCreate();
        LogUtil.i(TAG, "APP START");
    }
}
