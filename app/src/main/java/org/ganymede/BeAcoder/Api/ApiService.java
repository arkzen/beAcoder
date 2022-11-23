package org.ganymede.BeAcoder.Api;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ApiService {

    @POST("execute")
    @Headers("Content-Type: application/json")
    Call<String> execute(@Body PostData postData);
//    Call<String> execute(@Field("clientId") String clientId, @Field("clientSecret") String clientSecret, @Field("script") String script, @Field("language") String language, @Field("versionIndex") String versionIndex);


}
