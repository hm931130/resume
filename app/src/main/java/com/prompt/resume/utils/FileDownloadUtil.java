package com.prompt.resume.utils;

import android.Manifest;
import android.content.Context;


import com.prompt.resume.common.BaseParams;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import okhttp3.ResponseBody;

/**
 * Author: TinhoXu
 * E-mail: xth@erongdu.com
 * Date: 2016/7/6 09:53
 * <p/>
 * Description:
 */
public class FileDownloadUtil {
    private static final String TAG = "DownloadFile";

    /**
     * 保存文件
     *
     * @param body     文件流
     * @param filename 文件名,含后缀
     */
    public static boolean writeResponseBodyToDisk(ResponseBody body, String filename) {
        // 目录不存在  则创建
        File dir = new File(BaseParams.ROOT_PATH);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        try {
            File futureStudioIconFile = new File(BaseParams.ROOT_PATH + File.separator + filename);
            InputStream inputStream = null;
            OutputStream outputStream = null;
            try {
                byte[] fileReader = new byte[4096];

                long fileSize = body.contentLength();
                long fileSizeDownloaded = 0;

                inputStream = body.byteStream();
                outputStream = new FileOutputStream(futureStudioIconFile);

                while (true) {
                    int read = inputStream.read(fileReader);
                    if (read == -1) {
                        break;
                    }
                    outputStream.write(fileReader, 0, read);
                    fileSizeDownloaded += read;
                }
                outputStream.flush();
                ToastUtil.toast("下载成功");
                //Cutscenes.dismiss(true);
                return true;
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            } finally {
                if (inputStream != null) {
                    inputStream.close();
                }
                if (outputStream != null) {
                    outputStream.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 文件是否存在
     */
    public static boolean isExists(String filename) {
        try {
            File file = new File(BaseParams.ROOT_PATH + File.separator + filename);
            if (!file.exists()) {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
