package com.hdl.udpsenderlib;

import android.content.Context;

/**
 * @deprecated 已弃用，之后发送接收都可以用udpsender{@link UDPSender#start(UDPResultCallback)}
 * UDP接收器
 * Created by dali on 2017/5/16.
 */
@Deprecated
public class UDPReceiver {
    private static UDPReceiver receiver;
    private int port;
    private Context mContext;
    private UDPHelper udpHelper;

    private UDPReceiver() {
    }

    public static UDPReceiver getInstance() {

        if (receiver == null) {
            receiver = new UDPReceiver();
        }
        return receiver;
    }

    public UDPReceiver with(Context context) {
        this.mContext = context;
        udpHelper = new UDPHelper(mContext, port);
        return this;
    }

    /**
     * 设置端口
     *
     * @param port
     * @return
     */
    public UDPReceiver setPort(int port) {
        this.port = port;
        return this;
    }

    /**
     * 发送UDP广播
     *
     * @param callback 结果回调
     */
    public synchronized void receive(final UDPResultCallback callback) {
        udpHelper.startReciver(callback);
    }

    /**
     * 停止接收
     *
     * @return
     */
    public void stopReceive() {
        udpHelper.stopReceive();
    }
}
