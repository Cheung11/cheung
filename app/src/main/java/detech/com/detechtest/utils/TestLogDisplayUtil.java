package detech.com.detechtest.utils;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.widget.ScrollView;
import android.widget.TextView;

import com.detect.androidutils.custom.MyFunc;

import detech.com.detechtest.R;

/**
 * Created by Luke O on 2017/11/15.
 */

public class TestLogDisplayUtil {

    private static final String TAG = "TestLogDisplayUtil";

    private static final int DISPLAY_DEBUG  = 1;
    private static final int CLEAR_DEBUG    = 2;
    private static final int UPDATE_QUEUE_VALUE     = 3;

    private static Activity activity;
    private static ScrollView scrollView;
    private static TextView debugText;

    private static int textColumnNum;

    private static Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case DISPLAY_DEBUG:
                    if (debugText != null) {
                        textColumnNum++;
                        if(textColumnNum > 80) {
                            debugText.setText("自动清除行数");
                            textColumnNum = 0;
                        }
                        debugText.setText(debugText.getText() + "\n" + msg.obj.toString());
                        //如果没有到底端，Y偏移量增加10
                        if(scrollView == null) return;
                        if(scrollView.getScrollY()<debugText.getMeasuredHeight()-20){
                            scrollView.scrollBy(0, 20);
                        }
                        else {
                            //直接到底端
                            scrollView.scrollTo(0, debugText.getMeasuredHeight());
                        }
                    }

                    break;
                case CLEAR_DEBUG:
                    if(debugText != null){
                        debugText.setText("");
                    }
                    break;
            }
        }
    };

    public static void init(Context context) {
        TestLogDisplayUtil.activity = (Activity) context;
        debugText = (TextView) activity.findViewById(R.id.text_debug_log);
        try {
            scrollView = (ScrollView) activity.findViewById(R.id.scrollview_debug_log);
            if(scrollView == null) return;
            scrollView.post(new Runnable() {
                @Override
                public void run() {
                    scrollView.fullScroll(ScrollView.FOCUS_DOWN);
                }
            });
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void updateQueueValue(int value){
        sendMessage(UPDATE_QUEUE_VALUE, value);
    }

    public static void setLog(String text){
        if(MyFunc.isNullOrEmpty(text)) return;
        sendMessage(DISPLAY_DEBUG, text);
    }

    public static void clearLog(){
        sendMessage(CLEAR_DEBUG, null);
    }

    private static void sendMessage(int what, Object text){
        Message message = Message.obtain();
        message.what = what;
        message.obj = text;
        if(handler == null) return;
        handler.sendMessage(message);
    }
}
