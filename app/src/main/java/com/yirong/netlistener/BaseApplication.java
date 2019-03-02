package com.yirong.netlistener;

import android.app.Application;

import com.yirong.library.manager.NetworkManager;

public class BaseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        NetworkManager.getDefault().init(this);
    }
}
