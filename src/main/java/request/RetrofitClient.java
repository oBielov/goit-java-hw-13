package request;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.*;


import java.util.List;

public interface RetrofitClient {
    @POST("/users")
    @Headers({"ContentType-Type: application/json" })
    Call<User> userCreate(@Body User user);

    @PUT("/users/{id}")
    @Headers({"ContentType-Type: application/json"})
    Call<User> userUpdate(@Path ("id") Integer id, @Body User user);

    @DELETE("/users/{id}")
    @Headers({"ContentType-Type: application/json"})
    Call<ResponseBody> userDelete(@Path ("id") Integer id);

    @GET("/users")
    @Headers({"ContentType-Type: application/json"})
    Call<List<User>> getUsers();

    @GET("/users/{id}")
    @Headers({"ContentType-Type: application/json"})
    Call<User> getUserById(@Path("id") Integer id);

    @GET("/users/?username=")
    @Headers({"ContentType-Type: application/json"})
    Call<List<User>> getUserByName(@Query("username") String userName);

}
