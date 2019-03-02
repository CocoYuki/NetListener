package com.yirong.library.annotation;
import android.support.annotation.StringDef;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;



@Retention(RetentionPolicy.SOURCE)
@StringDef({NetType.AUTO,NetType.WIFI,NetType.CMNET,NetType.CMWAP,NetType.NONE})
public @interface NetType {
//有网络，包括Wifi/gprs
    public static final String AUTO = "AUTO";
    //wifi
    public static final String WIFI = "WIFI";
    //PC/笔记本/PDA
    public static final String CMNET = "CMNET";
    //手机端
    public static final String CMWAP = "CMWAP";
    //没有网络
    public static final String NONE = "NONE";
}
