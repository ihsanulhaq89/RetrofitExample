package example.android.com.retrofitexample.dto;

import com.google.gson.Gson;

/**
 * Created by Ihsanulhaq on 4/19/2017.
 */

public class BaseResponse {
    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}



