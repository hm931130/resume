package com.prompt.resume.network.converter;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.prompt.resume.network.entity.HttpResult;
import com.prompt.resume.network.entity.Params;
import com.prompt.resume.network.exception.ApiException;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.StringReader;

import okhttp3.ResponseBody;
import retrofit2.Converter;

/**
 * Created by Administrator on 2019/4/1.
 */

public class HMResponseBodyConverter<T> implements Converter<ResponseBody, T> {
    private final Gson gson;
    private final TypeAdapter<T> adapter;

    HMResponseBodyConverter(Gson gson, TypeAdapter<T> adapter) {
        this.gson = gson;
        this.adapter = adapter;
    }

    @Override
    public T convert(ResponseBody value) throws IOException {
        String response = value.string().trim();
        value.close();

        try {
            JSONObject object = new JSONObject(response);
            System.out.println(object.toString());
            // 解析 resCode ,对不成功的返回做统一处理
            if (object.getInt(Params.RES_CODE) != Params.RES_SUCCEED && object.getInt(Params.RES_CODE) != Params.PWD_ERROR) {
                throw new ApiException(new Gson().fromJson(response, HttpResult.class));
            }
            StringReader reader = new StringReader(response);
            JsonReader jsonReader = gson.newJsonReader(reader);
            return adapter.read(jsonReader);
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
