package example.android.com.retrofitexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import example.android.com.retrofitexample.dto.LoginResponse;
import example.android.com.retrofitexample.dto.UserDetailResponse;
import example.android.com.retrofitexample.dto.UserResponse;
import example.android.com.retrofitexample.networkapi.NetworkAPICallback;
import example.android.com.retrofitexample.networkapi.NetworkAPIManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NetworkAPIManager.getInstance().createUser("Martin", new NetworkAPICallback<UserResponse>() {
            @Override
            public void onSuccess(UserResponse responseDTO) {

            }

            @Override
            public void onError(int errorCode) {

            }

            @Override
            public void onNetworkFailure(String errorMsg) {

            }
        });


        NetworkAPIManager.getInstance().getUserData("101", new NetworkAPICallback<UserDetailResponse>() {
            @Override
            public void onSuccess(UserDetailResponse responseDTO) {

            }

            @Override
            public void onError(int errorCode) {

            }

            @Override
            public void onNetworkFailure(String errorMsg) {

            }
        });

        NetworkAPIManager.getInstance().login("jhon.doe@email.com", "12345ABC#", new NetworkAPICallback<LoginResponse>() {
            @Override
            public void onSuccess(LoginResponse responseDTO) {

            }

            @Override
            public void onError(int errorCode) {

            }

            @Override
            public void onNetworkFailure(String errorMsg) {

            }
        });
    }
}
