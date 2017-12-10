package detech.com.detechtest.impl;

import com.detect.androidutils.custom.LogUtil;

import detech.com.detechhardwarelib.impl.IHardwareOption;
import detech.com.detechhardwarelib.intf.DollMachineBaseCallback;
import detech.com.detechtest.utils.TestLogDisplayUtil;

/**
 * Created by Luke O on 2017/12/9.
 * 娃娃机接收回调处理
 */

public class MyDollMachineCallback extends DollMachineBaseCallback implements IHardwareOption.onExceptionListener, IHardwareOption.onPortStateListener{

    @Override
    public void onReceiveSetCostCoinNumSuccess(){
        super.onReceiveSetCostCoinNumSuccess();
        TestLogDisplayUtil.setLog("设置币数成功");
    }

    @Override
    public void onReceiveQueryCostCoinNumSetSuccess(int value){
        super.onReceiveQueryCostCoinNumSetSuccess(value);
        TestLogDisplayUtil.setLog("查询币数设置---->" + value);
    }

    @Override
    public void onReceiveSetStrongIntensitySuccess(){
        super.onReceiveSetStrongIntensitySuccess();
        TestLogDisplayUtil.setLog("设置强抓力成功");
    }

    @Override
    public void onReceiveQueryStrongIntensitySetSuccess(int value){
        super.onReceiveQueryStrongIntensitySetSuccess(value);
        TestLogDisplayUtil.setLog("查询强抓力设置成功--->" + value);
    }

    @Override
    public void onReceiveSetAwardRateSuccess(){
        super.onReceiveSetAwardRateSuccess();
        TestLogDisplayUtil.setLog("设置出奖率成功");
    }

    @Override
    public void onReceiveQueryAwardRateSetSuccess(int value){
        super.onReceiveQueryAwardRateSetSuccess(value);
        TestLogDisplayUtil.setLog("查询出奖率设置成功--->" + value);
    }

    @Override
    public void onReceiveSetWeakIntensitySuccess(){
        super.onReceiveSetWeakIntensitySuccess();
        TestLogDisplayUtil.setLog("设置弱抓力成功");
    }

    @Override
    public void onReceiveQueryWeakIntensitySetSuccess(int value){
        super.onReceiveQueryWeakIntensitySetSuccess(value);
        TestLogDisplayUtil.setLog("查询弱抓力设置成功--->" + value);
    }

    @Override
    public void onReceiveSetPlayGameTimeSuccess(){
        super.onReceiveSetPlayGameTimeSuccess();
        TestLogDisplayUtil.setLog("设置游戏时间成功");
    }

    @Override
    public void onReceiveQueryPlayGameTimeSetSuccess(int value){
        super.onReceiveQueryPlayGameTimeSetSuccess(value);
        TestLogDisplayUtil.setLog("查询游戏时间设置成功--->" + value);
    }

    @Override
    public void onReceiveSetGamePlayModeSuccess(){
        super.onReceiveSetGamePlayModeSuccess();
        TestLogDisplayUtil.setLog("设置游戏模式成功");
    }

    @Override
    public void onReceiveQueryGamePlayModeSetSuccess(int value){
        super.onReceiveQueryGamePlayModeSetSuccess(value);
        TestLogDisplayUtil.setLog("查询游戏模式设置成功--->" + value);
    }

    @Override
    public void onReceiveSetGameAwardModeSuccess(){
        super.onReceiveSetGameAwardModeSuccess();
        TestLogDisplayUtil.setLog("设置出奖模式成功");
    }

    @Override
    public void onReceiveQueryGameAwardModeSetSuccess(int value){
        super.onReceiveQueryGameAwardModeSetSuccess(value);
        TestLogDisplayUtil.setLog("查询出奖模式设置成功--->" + value);
    }

    @Override
    public void onReceiveSetPlayDecayTimeSuccess(){
        super.onReceiveSetPlayDecayTimeSuccess();
        TestLogDisplayUtil.setLog("设置强转弱时间成功");
    }

    @Override
    public void onReceiveQueryGameDecayTimeSetSuccess(int value){
        super.onReceiveQueryGameDecayTimeSetSuccess(value);
        TestLogDisplayUtil.setLog("查询强转弱时间设置成功--->" + value);
    }

    @Override
    public void onReceiveClearAwardQueueSuccess(){
        super.onReceiveClearAwardQueueSuccess();
        TestLogDisplayUtil.setLog("清空概率队列成功");
    }

    @Override
    public void onReceiveQueryAwardQueueSuccess(int value){
        super.onReceiveQueryAwardQueueSuccess(value);
        TestLogDisplayUtil.setLog("查询概率队列成功--->" + value);
    }

   @Override
    public void onReceiveQueryLeftCoinNumSuccess(int value){
       super.onReceiveQueryLeftCoinNumSuccess(value);
       TestLogDisplayUtil.setLog("查询游戏剩余币数成功--->" + value);
    }

    @Override
    public void onReceiveAward(int num) {
        LogUtil.w(TAG, "接收到出奖： " + num);
        TestLogDisplayUtil.setLog("接收到出奖： " + num);
    }

    @Override
    public void onReceiveMachineState(int state) {
        LogUtil.w(TAG, "接收到机器状态： " + state);
        TestLogDisplayUtil.setLog("接收到机器状态： " + state);
    }

    @Override
    public void onReceiveHeatBreak() {
        LogUtil.w(TAG, "接收到心跳包");
        TestLogDisplayUtil.setLog("接收到心跳包");
    }

    @Override
    public void onReceiveHardwareError(int errorCode) {
        LogUtil.w(TAG, "接收到报警错误： " + errorCode);
        TestLogDisplayUtil.setLog("接收到报警错误： " + errorCode);
    }

    @Override
    public void onReceiveAddCoinConfirm(int from, int coinNum) {
        LogUtil.w(TAG, "接收到投币确认信号 From： " + from + "   coinNum: " + coinNum);
        TestLogDisplayUtil.setLog("接收到投币确认信号 From： " + from + "   coinNum: " + coinNum);
    }

    @Override
    public void onReceiveGameStart() {
        LogUtil.w(TAG, "游戏开始");
        TestLogDisplayUtil.setLog("游戏开始");
    }

    @Override
    public void onReceiveGameEnd() {
        LogUtil.w(TAG, "游戏结束");
        TestLogDisplayUtil.setLog("游戏结束");
    }

    @Override
    public void onReceiveHardwareVersion(int version) {
        LogUtil.w(TAG, "接收到硬件版本： " + version);
        TestLogDisplayUtil.setLog("接收到硬件版本： " + version);
    }

    @Override
    public void onException(String errMsg) {

        LogUtil.w(TAG, "串口异常： " + errMsg);
        TestLogDisplayUtil.setLog("串口异常： " + errMsg);
    }

    @Override
    public void onError(int errorCode) {

        LogUtil.w(TAG, "串口错误： " + errorCode);
        TestLogDisplayUtil.setLog("串口错误： " + errorCode);
    }

    @Override
    public void onOpenSuccess() {

        LogUtil.w(TAG, "串口打开成功");
        TestLogDisplayUtil.setLog("串口打开成功");
    }

    @Override
    public void onOpenFailed(String reason) {
        LogUtil.w(TAG, "串口打开失败： " + reason);
        TestLogDisplayUtil.setLog("串口打开失败： " + reason);
    }

    @Override
    public void onConnect(byte[] buffer) {

    }

    @Override
    public void onDisconnect() {
        LogUtil.w(TAG, "串口失去连接");
        TestLogDisplayUtil.setLog("串口失去连接");
    }
}
