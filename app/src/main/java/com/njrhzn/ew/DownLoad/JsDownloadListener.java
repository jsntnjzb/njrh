package com.njrhzn.ew.DownLoad;

/**
 * Description: 下载进度回调
 * Created by ChuHui on 2019/12/18
 */
public interface JsDownloadListener {
    void onStartDownload();
    void onProgress(int progress);
    void onFinishDownload();
    void onFail(String errorInfo);
}
