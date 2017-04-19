package com.example.oat.sellhemeth;

import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.Request;

/**
 * Created by oat on 19-Apr-17.
 */

public class Okhttp {

    public String getServerResult(String URL, okhttp3.RequestBody params) {
        okhttp3.OkHttpClient client = new okhttp3.OkHttpClient();

        if(params == null){
            params = new FormBody.Builder().build();
        }

        Request request = new Request.Builder()
                .url(URL)
                .post(params)
                .build();

        okhttp3.Response response;
        try {
            response = client.newCall(request).execute();
            return response.body().string();
        } catch (IOException e) {
            return "ERROR";
        }
    }

}
