package cn.imrhj.olddriverquery.model.duowan_entity;

/**
 * Created by rhj on 16/5/11.
 */
public class DetailUserInfo {

    private PlayerInfo playerInfo;
    private Record record;
    private Hero hero;

    public DetailUserInfo(PlayerInfo playerInfo, Record record, Hero hero) {
        this.playerInfo = playerInfo;
        this.record = record;
        this.hero = hero;
    }

    public PlayerInfo getPlayerInfo() {
        return playerInfo;
    }

    public void setPlayerInfo(PlayerInfo playerInfo) {
        this.playerInfo = playerInfo;
    }

    public Record getRecord() {
        return record;
    }

    public void setRecord(Record record) {
        this.record = record;
    }

    public Hero getHero() {
        return hero;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }
}
