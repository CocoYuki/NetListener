package com.yirong.library.utils;

import android.app.Activity;
import android.content.ComponentName;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.yirong.library.manager.NetworkManager;
import com.yirong.library.annotation.NetType;


/**
 *获取网络状态的工具类
 */
public class NetWorkUtils {

    /**
     * @return 是否有网络
     */
    public static boolean isNetWorkAvailable(){
        ConnectivityManager manager = (ConnectivityManager) NetworkManager.getDefault().getApplication().getSystemService(Context.CONNECTIVITY_SERVICE);
        if(manager == null){
            return  false;
        }
        NetworkInfo[] networkInfos = manager.getAllNetworkInfo();
        if(networkInfos != null){
            for(NetworkInfo info:networkInfos){
                if(info.getState() == NetworkInfo.State.CONNECTED){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * @return @NetType
     */
    public static @NetType String getNetworkType(){
        ConnectivityManager manager = (ConnectivityManager) NetworkManager.getDefault().getApplication().getSystemService(Context.CONNECTIVITY_SERVICE);
        if(manager == null){
            return  NetType.NONE;
        }
        NetworkInfo networkInfo = manager.getActiveNetworkInfo();
        if(networkInfo == null){
            return  NetType.NONE;
        }
        int type = networkInfo.getType();
        if(type == ConnectivityManager.TYPE_MOBILE){
            if(networkInfo.getExtraInfo().toLowerCase().equals("cmnet")){
                return NetType.CMNET;
            }else{
                return NetType.CMWAP;
            }
        }else if(type == ConnectivityManager.TYPE_WIFI){
            return NetType.WIFI;
        }
        return NetType.AUTO;
    }

    /**
     * 打开网络设置界面
     * @param context
     * @param requestCode 请求跳转
     */
    public static void openNetSetting(Context context,int requestCode){
        Intent intent = new Intent("/");
        ComponentName cn = new ComponentName("com.android.settings","com.android.settings.WirelessSettings");
        intent.setComponent(cn);
        intent.setAction("android.intent.action.VIEW");
        ((Activity)context).startActivityForResult(intent,requestCode);
    }
}
