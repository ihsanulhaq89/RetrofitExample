package example.android.com.retrofitexample.networkapi;

import example.android.com.retrofitexample.dto.LoginResponse;
import example.android.com.retrofitexample.dto.UserDetailResponse;
import example.android.com.retrofitexample.dto.UserResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by Ihsanulhaq on 4/19/2017.
 */

public interface NetworkAPIService {

    @FormUrlEncoded
    @POST("/user/login")
    Call<LoginResponse> loginUser(@Field("email") String email, @Field("password") String password);


    @POST("users")
    Call<Void> createUserWithJson(@Body UserRequest user);


    @FormUrlEncoded
    @GET("/user")
    Call<UserDetailResponse> getUserData(@Field("id") String userId);


    @FormUrlEncoded
    @POST("/user/create")
    Call<UserResponse> createUser(@Field("name") String name);
}