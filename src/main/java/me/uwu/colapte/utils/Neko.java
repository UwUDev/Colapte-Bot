package me.uwu.colapte.utils;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class Neko {

    public static String getFromEndpoint(String endpoint) throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request request = new Request.Builder()
                .url("https://nekos.life/api/v2/img/" + endpoint)
                .method("GET", null)
                .addHeader("Cookie", "__cfduid=dedfeaf9f04a75d4172964ae9d68e64651605022740")
                .build();
        Response response = client.newCall(request).execute();
        String url = response.body().string();
        url = url.substring(8, url.length() -3);

        return url;
    }

}
