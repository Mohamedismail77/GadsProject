package com.ismail.gads.network;

import com.ismail.gads.Record;
import com.ismail.gads.SubmitObject;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface Routes {

    @GET("/api/{topic}")
    Observable<List<Record>> getLeadersList(@Path("topic") String topic);



    @POST("1FAIpQLSf9d1TcNU6zc6KR8bSEM41Z1g1zl35cwZr2xyjIhaMAz8WChQ/formResponse")
    @FormUrlEncoded
    Observable<Response<Void>> submitProjectWithFields(@Field("entry.1877115667")String name,
                                                         @Field("entry.2006916086")String last,
                                                         @Field("entry.1824927963")String email,
                                                         @Field("entry.284483984")String link);

}
