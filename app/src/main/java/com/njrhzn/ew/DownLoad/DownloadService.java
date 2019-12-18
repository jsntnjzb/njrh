package com.njrhzn.ew.DownLoad;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

/**
 * 下载接口
 * */
public interface DownloadService {
    @Streaming
    @GET
    Observable<ResponseBody> download(@Url String url);
}