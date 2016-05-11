package cn.imrhj.olddriverquery.api;

import cn.imrhj.olddriverquery.model.duowan_entity.Hero;
import cn.imrhj.olddriverquery.model.duowan_entity.PlayerInfo;
import cn.imrhj.olddriverquery.model.duowan_entity.Record;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by rhj on 16/5/11.
 */
public interface DuowanService {
    @GET("playerinfo.php")
    Observable<PlayerInfo> getPlayerInfo(
            @Query("serverName") String serverName,
            @Query("playerName") String playerName);

    @GET("Record.php")
    Observable<Record> getRecord(
            @Query("serverName") String serverName,
            @Query("playerName") String playerName);

    @GET("hero.php")
    Observable<Hero> getHero(
            @Query("serverName") String serverName,
            @Query("playerName") String playerName);

}

