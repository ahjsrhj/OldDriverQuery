package cn.imrhj.olddriverquery.api;

import java.util.List;

import cn.imrhj.olddriverquery.model.entity.AllBase;
import cn.imrhj.olddriverquery.model.entity.Area;
import cn.imrhj.olddriverquery.model.entity.CombatBean;
import cn.imrhj.olddriverquery.model.entity.TokenInfo;
import cn.imrhj.olddriverquery.model.entity.UserBaseExten;
import cn.imrhj.olddriverquery.model.entity.UserExtInfo;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by rhj on 16/5/6.
 */
public interface GameService {
    @GET("login")
    Observable<TokenInfo> getToken(
            @Query("username") String username,
            @Query("password") String password);

    @GET("UserArea")
    Observable<UserBaseExten> getUserBase(
            @Header("DAIWAN-API-TOKEN") String token,
            @Query("keyword") String keyword);

    @GET("area")
    Observable<List<Area>> getArea();

    @GET("UserExtInfo")
    Observable<AllBase<UserExtInfo>> getUserExtInfo(
            @Header("DAIWAN-API-TOKEN") String token,
            @Query("qquin") String qquin,
            @Query("vaid") int vaid);

    @GET("CombatList")
    Observable<List<CombatBean>> getCombatList(
            @Header("DAIWAN-API-TOKEN") String token,
            @Query("qquin") String qquin,
            @Query("vaid") int vaid,
            @Query("p") int page);
}
