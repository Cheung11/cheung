package detech.com.detechtest.utils;

import android.app.Activity;

import com.detect.androidutils.custom.LogUtil;
import com.detect.androidutils.custom.MyFunc;

import detech.com.detechhardwarelib.impl.HardwareDefine;
import detech.com.detechtest.views.TestHardwareView;
import detech.com.detechtest.views.TestDollMachineLierfangHardwareView;

/**
 * Created by Luke O on 2017/11/15.
 */

public class TestUIThemeUtil {

    private static final String TAG = "TestUIThemeUtil";

    private static Activity activity;

    public static void setActivity(Activity activity){
        TestUIThemeUtil.activity = activity;
    }

    /**
     * 改变view
     * @param hardwareProtocol
     * @return
     */
    public static TestHardwareView createView(String hardwareProtocol){
        TestHardwareView view = null;
        if(MyFunc.isNullOrEmpty(hardwareProtocol)){
            LogUtil.w(TAG, "使用默认主题");
            view = new TestDollMachineLierfangHardwareView(activity);
            return view;
        }
        if(hardwareProtocol.equals(HardwareDefine.DOLL_MACHINE_LIERFANG)) {
            view = new TestDollMachineLierfangHardwareView(activity);
        }
        return view;
    }
}
