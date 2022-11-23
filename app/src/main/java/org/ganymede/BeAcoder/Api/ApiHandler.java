package org.ganymede.BeAcoder.Api;


import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class ApiHandler {

    private static final String BASE_URL = "https://api.jdoodle.com/v1/";
    public static final String API_ID = "401fdb81a257741c7bab57a20cffb9f0";
    public static final String API_SECRET = "825ed852c042ae25dd2841b7ba15aeb1e8a96e9f79ea6ae490c2e36e570b8978";
    public static final String LANGUAGE = "java";
    public static final String VERSION_INDEX = "4";


    private static Retrofit retrofit;

    public static ApiService getRetrofitInstance(){

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);

        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpClient.build())
                    .build();
        }

        return retrofit.create(ApiService.class);
    }

}
