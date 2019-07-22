package frise.project.mordapp.retrofit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public abstract class MyRetrofit {
    protected Retrofit retrofit;

    public MyRetrofit(String baseUrl) {
        OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder();
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(UnsafeOkHttpClient.getUnsafeOkHttpClient())
                .addConverterFactory(GsonConverterFactory.create());
        retrofit = builder.build();
    }
}

