package ezbus.mit20550588.conductor.data.network;

import java.util.Map;

import ezbus.mit20550588.conductor.data.model.UserModel;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiServiceAuthentication {

    @POST("/auth/login/conductor")
    Call<UserModel> loginUser(@Body LoginRequest loginRequest);

    @POST("/auth/signup/conductor")
    Call<Map<String, String>> registerUser (@Body RegistrationRequest registrationRequest);

    @POST("/auth/verify/conductor")
    Call<UserModel> verifyUser (@Body Map<String, String> email);

}


