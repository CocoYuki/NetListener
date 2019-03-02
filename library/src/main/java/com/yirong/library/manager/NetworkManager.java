package com.yirong.library.manager;

import android.app.Application;
import android.content.IntentFilter;
import com.yirong.library.NetStateReceiver;
import com.yirong.library.utils.Constants;

public class NetworkManager {
    private static volatile NetworkManager instance;
    private NetStateReceiver mReceiver;
    private Application mApplication;

    public NetworkManager(){
        mReceiver = new NetStateReceiver();
    }

    public static NetworkManager getDefault(){
        if(instance == null){
            synchronized (NetworkManager.class){
                if(instance == null){
                    instance = new NetworkManager();
                }
            }
        }
        return instance;
    }
    public Application getApplication(){
        if(mApplication == null){
            throw new RuntimeException("NetworkManager.getDefault().init()没有初始化");
        }
        return mApplication;
    }

    public void init(Application application){
        this.mApplication = application;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Constants.ANDROID_NET_CHANGE_ACTION);
        mApplication.registerReceiver(mReceiver,intentFilter);
    }


    public void logout(){
        getApplication().unregisterReceiver(mReceiver);
    }

    public void registerObserver(Object activity) {
        mReceiver.registerObserver(activity);
    }

    public void unRegisterObserver(Object activity) {
        mReceiver.unRegisterObserver(activity);
    }

    public void unRegisterAllObserver() {
        mReceiver.unRegisterAllObserver();
    }
}