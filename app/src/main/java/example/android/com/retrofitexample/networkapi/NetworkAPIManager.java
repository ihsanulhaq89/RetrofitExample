package example.android.com.retrofitexample.networkapi;

import example.android.com.retrofitexample.dto.LoginResponse;
import example.android.com.retrofitexample.dto.UserDetailResponse;
import example.android.com.retrofitexample.dto.UserResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Ihsanulhaq on 4/19/2017.
 */


public class NetworkAPIManager {

    private NetworkAPIService apiService;
    public static final String BASE_URL = "http://<add_url_here>/";
    private static NetworkAPIManager instance;

    private NetworkAPIManager() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        apiService = retrofit.create(NetworkAPIService.class);
    }

    public static NetworkAPIManager getInstance() {
        if (instance == null) {
            instance = new NetworkAPIManager();
        }
        return instance;
    }

    public void getUserData(String id, final NetworkAPICallback<UserDetailResponse> listener) {
        apiService.getUserData(id).enqueue(new Callback<UserDetailResponse>() {
            @Override
            public void onResponse(Call<UserDetailResponse> call, Response<UserDetailResponse> response) {
                if (response.isSuccessful()) {
                    listener.onSuccess(response.body());
                } else {
                    listener.onError(response.code());
                }
            }

            @Override
            public void onFailure(Call<UserDetailResponse> call, Throwable t) {
                listener.onNetworkFailure(t.getMessage());
            }
        });
    }

    public void createUser(String name, final NetworkAPICallback<UserResponse> listener) {
        apiService.createUser(name).enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                if (response.isSuccessful()) {
                    listener.onSuccess(response.body());
                } else {
                    listener.onError(response.code());
                }
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                listener.onNetworkFailure(t.getMessage());
            }
        });
    }

    public void login(String email, String password, final NetworkAPICallback<LoginResponse> listener) {
        apiService.loginUser(email, password).enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if (response.isSuccessful()) {
                    listener.onSuccess(response.body());
                } else {
                    listener.onError(response.code());
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                listener.onNetworkFailure(t.getMessage());
            }
        });
    }
}





