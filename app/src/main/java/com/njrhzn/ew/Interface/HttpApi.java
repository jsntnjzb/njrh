package com.njrhzn.ew.Interface;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface HttpApi {
    /**
     * 查询apk版本信息
     * */
    @GET("getApk")
    Observable<Object> getApk(@Url String url);
}
