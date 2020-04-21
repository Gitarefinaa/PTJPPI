package com.example.projectipc;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface APIService {
    @FormUrlEncoded
    @POST("login.php")
    Call<UserModel> LoginUser(@Field("username") String username, @Field("password")String password);


     @FormUrlEncoded
     @POST("insert.php")
     Call<InspectionMachine> InsertMesin           (@Field("date_inspection2") String date_inspection2,
                                                    @Field("status_inspection2") String status_inspection2,
                                                    @Field("operation_machine2") String operation_machine2);
     @GET("read-mesin.php")
     Call<ResponLogin> ShowAsset();
//
//@GET
//    Call<LokasiAsset> ViewLokasi();







}
