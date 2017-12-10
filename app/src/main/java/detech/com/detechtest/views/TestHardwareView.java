package detech.com.detechtest.views;

import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.detect.androidutils.custom.LogUtil;

import detech.com.detechtest.R;
import detech.com.detechtest.utils.TestConstants;

/**
 * Created by Luke O on 2017/11/15.
 */

public abstract class TestHardwareView {

    public static final String TAG = TestHardwareView.class.getSimpleName();

    protected Activity activity;
    protected EditText settingTime;
    protected EditText settingValue;
    protected EditText queryTime;
    protected String settingSelectValue;
    protected String querySelectValue;

    public TestHardwareView(final Activity activity, int layoutId){
        if(activity == null) return;
        this.activity = activity;
        activity.setContentView(layoutId);
        activity.findViewById(R.id.button_confirm).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.getId() == R.id.button_confirm){
                    Toast.makeText(activity, "设置协议成功！", Toast.LENGTH_SHORT).show();
                }
            }
        });
        initSpinner(R.id.spinner_protocol_select, R.array.protocol_select, TestConstants.SELECT_PROTOCOL, new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                LogUtil.i(TAG, "你选择了" + parent.getAdapter().getItem(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    protected abstract void sendSettingAction(String settingValue, int time, int value);
    protected abstract void sendQueryAction(String queryValue, int time);

    protected void initSpinner(int spinnerId, int textArrayResId, CharSequence positionItem,AdapterView.OnItemSelectedListener listener) {
        if(activity == null) return;
        Spinner spinner = (Spinner) activity.findViewById(spinnerId);
        final ArrayAdapter<CharSequence> modeAdapter = ArrayAdapter.createFromResource(activity, textArrayResId,
                android.R.layout.simple_spinner_item);
        modeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        int position = modeAdapter.getPosition(positionItem);
        spinner.setAdapter(modeAdapter);
        spinner.setSelection(position);
        if(listener != null){
            spinner.setOnItemSelectedListener(listener);
        }
        spinner.setVisibility(View.VISIBLE);
    }
}
