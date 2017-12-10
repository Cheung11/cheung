package detech.com.detechtest.views;

import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;

import com.detect.androidutils.custom.LogUtil;
import com.detect.androidutils.custom.MyFunc;

import detech.com.detechhardwarelib.impl.HardwareDefine;
import detech.com.detechhardwarelib.impl.HardwareSender;
import detech.com.detechtest.R;
import detech.com.detechtest.utils.TestLogDisplayUtil;

/**
 * Created by Luke O on 2017/11/15.
 * 测试娃娃机硬件
 */

public class TestDollMachineLierfangHardwareView extends TestHardwareView implements View.OnClickListener{

    public TestDollMachineLierfangHardwareView(Activity activity){
        super(activity, R.layout.test_lierfang_wawaji_hardware);
        if(activity == null) return;
        activity.findViewById(R.id.button_left).setOnClickListener(this);
        activity.findViewById(R.id.button_right).setOnClickListener(this);
        activity.findViewById(R.id.button_up).setOnClickListener(this);
        activity.findViewById(R.id.button_down).setOnClickListener(this);
        activity.findViewById(R.id.button_addcoin).setOnClickListener(this);
        activity.findViewById(R.id.button_setting).setOnClickListener(this);
        activity.findViewById(R.id.button_query).setOnClickListener(this);
        activity.findViewById(R.id.button_clear_log).setOnClickListener(this);
        activity.findViewById(R.id.button_random_command).setOnClickListener(this);
        activity.findViewById(R.id.button_catch).setOnClickListener(this);
        settingTime = (EditText) activity.findViewById(R.id.text_setting_time);
        settingValue = (EditText) activity.findViewById(R.id.text_setting_value);
        queryTime= (EditText) activity.findViewById(R.id.text_query_time);

        initSpinner();

    }

    private void initSpinner(){
        initSpinner(R.id.spinner_param_setting, R.array.lierfang_tianche_setting_select, "设置强抓力", new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectValue =  parent.getAdapter().getItem(position).toString();
                LogUtil.i(TAG, "你选择了" + selectValue);
                settingSelectValue = selectValue;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                settingSelectValue = null;
            }
        });
        initSpinner(R.id.spinner_param_query, R.array.lierfang_tianche_query_select, "查询强抓力", new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectValue =  parent.getAdapter().getItem(position).toString();
                LogUtil.i(TAG, "你选择了" + selectValue);
                querySelectValue = selectValue;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                querySelectValue = null;
            }
        });
    }

    @Override
    protected void sendSettingAction(String settingValue, int time, int value) {
        if(MyFunc.isNullOrEmpty(settingValue) || time < 0 || value < 0) return;
        int settingTime = 0;
        switch (settingValue){
            case "设置强抓力":
                while (settingTime < time){
                    HardwareSender.SendSetStrongIntensityAction(value);
                    settingTime++;
                }
                break;
            case "设置弱抓力":
                while (settingTime < time){
                    HardwareSender.SendSetWeakIntensityAction(value);
                    settingTime++;
                }
                break;
            case "设置默认游戏时间":
                while (settingTime < time){
                    HardwareSender.SendSetGamePlayTimeAction(value);
                    settingTime++;
                }
                break;
            case "设置概率":
                while (settingTime < time){
                    HardwareSender.SendSetAwardRateAction(value);
                    settingTime++;
                }
                break;
            case "设置启动币数":
                while (settingTime < time){
                    HardwareSender.SendSetCostCoinNumAction(value);
                    settingTime++;
                }
                break;
            case "设置强转弱时间":
                while (settingTime < time){
                    HardwareSender.SendSetDecayTimeAction(value);
                    settingTime++;
                }
                break;
            case "设置游戏模式":
                while (settingTime < time){
                    HardwareSender.SendSetGamePlayModeAction(value);
                    settingTime++;
                }
                break;
            case "设置出奖模式":
                while (settingTime < time){
                    HardwareSender.SendSetGameAwardModeAction(value);
                    settingTime++;
                }
                break;
            case "清空概率队列":
                while (settingTime < time){
                    HardwareSender.SendClearAwardQueueAction();
                    settingTime++;
                }
                break;
            default:
                LogUtil.e(TAG, "没有对应的参数修改");
                break;
        }
    }

    @Override
    protected void sendQueryAction(String queryValue, int time) {
        if(MyFunc.isNullOrEmpty(queryValue) || time < 0) return;
        int queryTime = 0;
        switch (queryValue){
            case "查询强抓力":
                while (queryTime < time){
                    HardwareSender.SendQueryAction(HardwareDefine.QUERY_STRONG_INTENSITY);
                    queryTime++;
                }
                break;
            case "查询弱抓力":
                while (queryTime < time){
                    HardwareSender.SendQueryAction(HardwareDefine.QUERY_WEAK_INTENSITY);
                    queryTime++;
                }
                break;
            case "查询默认游戏时间":
                while (queryTime < time){
                    HardwareSender.SendQueryAction(HardwareDefine.QUERY_GAME_PLAY_TIME);
                    queryTime++;
                }
                break;
            case "查询概率":
                while (queryTime < time){
                    HardwareSender.SendQueryAction(HardwareDefine.QUERY_AWARD_RATE);
                    queryTime++;
                }
                break;
            case "查询启动币数":
                while (queryTime < time){
                    HardwareSender.SendQueryAction(HardwareDefine.QUERY_COST_COIN_NUM);
                    queryTime++;
                }
                break;
            case "查询强转弱时间":
                while (queryTime < time){
                    HardwareSender.SendQueryAction(HardwareDefine.QUERY_PLAY_DECAY_TIME);
                    queryTime++;
                }
                break;
            case "查询游戏模式":
                while (queryTime < time){
                    HardwareSender.SendQueryAction(HardwareDefine.QUERY_GAME_PLAY_MODE);
                    queryTime++;
                }
                break;
            case "查询出奖模式":
                while (queryTime < time){
                    HardwareSender.SendQueryAction(HardwareDefine.QUERY_GAME_AWARD_MODE);
                    queryTime++;
                }
                break;
            case "查询剩余币数":
                while (queryTime < time){
                    HardwareSender.SendQueryAction(HardwareDefine.QUERY_LEFT_COIN_NUM);
                    queryTime++;
                }
                break;
            case "查询概率队列":
                while (queryTime < time){
                    HardwareSender.SendQueryAction(HardwareDefine.QUERY_AWARD_QUEUE);
                    queryTime++;
                }
                break;
            default:
                LogUtil.e(TAG, "没有对应的参数修改");
                break;
        }
    }

    @Override
    public void onClick(View view) {
        int time = 1;//设置次数
        int value = 10;
        switch (view.getId()){
            case R.id.button_left:
                HardwareSender.SendDirectionControllerAction(HardwareDefine.DIRECTION_CONTROL_LEFT);
                break;
            case R.id.button_right:
                HardwareSender.SendDirectionControllerAction(HardwareDefine.DIRECTION_CONTROL_RIGHT);
                break;
            case R.id.button_up:
                HardwareSender.SendDirectionControllerAction(HardwareDefine.DIRECTION_CONTROL_FRONT);
                break;
            case R.id.button_down:
                HardwareSender.SendDirectionControllerAction(HardwareDefine.DIRECTION_CONTROL_BACK);
                break;
            case R.id.button_catch:
                HardwareSender.SendClawCatchAction();
                break;
            case R.id.button_addcoin:
                HardwareSender.SendAddCoinAction(1);
                break;
            case R.id.button_setting:
                if(settingTime != null) time = MyFunc.parseInt(settingTime.getText().toString());
                if(time == 0) time = 1;
                if(settingValue != null) value = MyFunc.parseInt(settingValue.getText().toString());
                sendSettingAction(settingSelectValue, time, value);
                break;
            case R.id.button_query:
                if(queryTime != null) time = MyFunc.parseInt(queryTime.getText().toString());
                if(time == 0) time = 1;
                sendQueryAction(querySelectValue, time);
                break;
            case R.id.button_clear_log:
                TestLogDisplayUtil.clearLog();
                break;
        }
    }
}
