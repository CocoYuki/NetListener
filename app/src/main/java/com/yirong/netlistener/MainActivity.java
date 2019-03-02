package com.yirong.netlistener;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;


import com.yirong.library.manager.NetworkManager;
import com.yirong.library.annotation.NetworkListener;
import com.yirong.library.annotation.NetType;
import com.yirong.library.utils.Constants;


public class MainActivity extends AppCompatActivity{

    /**
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //注册广播
        NetworkManager.getDefault().registerObserver(this);

    }

    //网络监听
    @NetworkListener(type = NetType.WIFI)
    public void netork(@NetType String type){
        switch (type){
            case NetType.AUTO:
                Log.i(Constants.TAG,"AUTO");
                break;
            case NetType.CMNET:
                Log.i(Constants.TAG,"CMNET");
                break;
            case NetType.CMWAP:
                Log.i(Constants.TAG,"CMWAP");
                break;
            case NetType.WIFI:
                Log.i(Constants.TAG,"WIFI");
                break;
            case NetType.NONE:
                Log.i(Constants.TAG,"NONE");
                break;
        }
    }



    //网络监听
    @NetworkListener(type = NetType.WIFI)
    public void netorkListen(@NetType String type){
        switch (type){
            case NetType.AUTO:
                Log.i(Constants.TAG,"AUTO*");
                break;
            case NetType.CMNET:
                Log.i(Constants.TAG,"CMNET*");
                break;
            case NetType.CMWAP:
                Log.i(Constants.TAG,"CMWAP*");
                break;
            case NetType.WIFI:
                Log.i(Constants.TAG,"WIFI*");
                break;
            case NetType.NONE:
                Log.i(Constants.TAG,"NONE*");
                break;
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        //注销目标广播
        NetworkManager.getDefault().unRegisterObserver(this);
        //注销所有广播
        NetworkManager.getDefault().unRegisterAllObserver();

    }
}
