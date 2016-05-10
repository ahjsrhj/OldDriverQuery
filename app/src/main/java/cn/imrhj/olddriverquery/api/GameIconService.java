package cn.imrhj.olddriverquery.api;

import android.graphics.Bitmap;

import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by rhj on 16/5/9.
 */
public interface GameIconService {
    @GET("profileicon2/profileicon{icon_id}.jpg")
    Observable<ResponseBody> getPlayerIcon(@Path("icon_id") int id);
}
