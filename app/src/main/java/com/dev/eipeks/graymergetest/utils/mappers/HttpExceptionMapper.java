package com.dev.eipeks.graymergetest.utils.mappers;

import android.util.Log;

import java.io.IOException;
import java.lang.annotation.Annotation;

import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.HttpException;
import retrofit2.Retrofit;

public class HttpExceptionMapper {
    public static String getServerMessageFromHttpException(Retrofit retrofit, Throwable throwable){
        ResponseBody body = ((HttpException) throwable).response().errorBody();
        Converter<ResponseBody, String> converter = retrofit.responseBodyConverter(String.class, new Annotation[0]);
        try {
            if (body != null){
                return converter.convert(body);
            } else {
                Log.e("Response body", "Response body is null");
            }
        } catch (IOException e) {
            Log.e("Error Mapping", e.getLocalizedMessage());
        }

        return null;
    }
}
