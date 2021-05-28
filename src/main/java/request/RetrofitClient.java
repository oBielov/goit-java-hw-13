package request;

import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface RetrofitClient {
    @POST("/users")
    @Headers({"ContentType-Type: application/json" })
    Call<List<User>> newUser(@Body User user);

    @PUT("/users")
    @Headers({"ContentType-Type: application/json"})
    Call<List<User>> userUpdate(@Body User user);

    @GET("/users")
    @Headers({"ContentType-Type: application/json"})
    Call<List<User>> getUsers();

}
