package detech.com.detechtest;

import android.os.Bundle;
import android.os.Process;
import android.support.v7.app.AppCompatActivity;

import detech.com.detechhardwarelib.impl.HardwareDefine;
import detech.com.detechhardwarelib.impl.IHardwareOption;
import detech.com.detechhardwarelib.presenters.HardwareManager;
import detech.com.detechtest.impl.MyDollMachineCallback;
import detech.com.detechtest.utils.TestConstants;
import detech.com.detechtest.utils.TestLogDisplayUtil;
import detech.com.detechtest.utils.TestUIThemeUtil;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TestUIThemeUtil.setActivity(this);
        TestUIThemeUtil.createView(TestConstants.SELECT_PROTOCOL);
        TestLogDisplayUtil.init(this);

        /*配置硬件信息， 打开串口**/
        MyDollMachineCallback myDollMachineCallback = new MyDollMachineCallback();
        IHardwareOption option = new IHardwareOption()
                .portName(HardwareDefine.PORT_TTY_S0)
                .baudrate(HardwareDefine.BAU_115200)
                .dollMachineCallback(myDollMachineCallback)
                .portStateListener(myDollMachineCallback)
                .exceptionListener(myDollMachineCallback);
        HardwareManager.getInst().initConfig(option);
        HardwareManager.getInst().open();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Process.killProcess(Process.myPid());
        HardwareManager.getInst().onDispose();
    }
}
