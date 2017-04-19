package example.android.com.retrofitexample.networkapi;

import example.android.com.retrofitexample.dto.BaseResponse;

/**
 * Created by Ihsanulhaq on 4/19/2017.
 */

public interface NetworkAPICallback<T extends BaseResponse> {
    public void onSuccess(T responseDTO);

    public void onError(int errorCode);

    public void onNetworkFailure(String errorMsg);
}
