package com.eme.aelegant.model.net;

import com.eme.aelegant.App;

import java.io.File;

/**
 * net
 *
 * Created by dijiaoliang on 17/3/2.
 */
public final class ApiConstant {

    //主机名
    public static final String API_HOST="http://news-at.zhihu.com";//知乎

    //端口
    public static final String PORT="";

    //正式发布时要做修改
    public static final boolean DEBUG = Boolean.parseBoolean("true");

    public static final String PATH_DATA = App.getAppInstance().getCacheDir().getAbsolutePath() + File.separator + "data";

    public static final String PATH_CACHE = PATH_DATA + "/NetCache";

}
