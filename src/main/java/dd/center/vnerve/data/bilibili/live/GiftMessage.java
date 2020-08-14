package dd.center.vnerve.data.bilibili.live;

import java.util.Objects;

/** 礼物消息 */
public class GiftMessage implements UserMessage {
    /** 直播间长 ID */
    private int roomId;
    /** 用户 ID */
    private long uid;
    /** 用户名 */
    private String userName;
    /** 用户头像 URL */
    private String userAvatarUrl;

    /** 是否为金瓜子 */
    private boolean gold;
    /** 礼物总瓜子数 */
    private int totalCoin;

    /** 礼物 ID */
    private int giftId;
    /** 礼物名称 */
    private String giftName;
    /** 单个礼物的价格。某些情况下礼物价格可能打折，此时本字段为未打折的价格。 */
    private int singlePriceCoinRaw;
    /** 礼物数目 */
    private int count;

    public GiftMessage() {
    }

    public GiftMessage(int roomId, long uid, String userName, String userAvatarUrl, boolean gold, int totalCoin, int giftId, String giftName, int singlePriceCoinRaw, int count) {
        this.roomId = roomId;
        this.uid = uid;
        this.userName = userName;
        this.userAvatarUrl = userAvatarUrl;
        this.gold = gold;
        this.totalCoin = totalCoin;
        this.giftId = giftId;
        this.giftName = giftName;
        this.singlePriceCoinRaw = singlePriceCoinRaw;
        this.count = count;
    }

    @Override
    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    @Override
    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserAvatarUrl() {
        return userAvatarUrl;
    }

    public void setUserAvatarUrl(String userAvatarUrl) {
        this.userAvatarUrl = userAvatarUrl;
    }

    public boolean isGold() {
        return gold;
    }

    public void setGold(boolean gold) {
        this.gold = gold;
    }

    public int getTotalCoin() {
        return totalCoin;
    }

    public void setTotalCoin(int totalCoin) {
        this.totalCoin = totalCoin;
    }

    public int getGiftId() {
        return giftId;
    }

    public void setGiftId(int giftId) {
        this.giftId = giftId;
    }

    public String getGiftName() {
        return giftName;
    }

    public void setGiftName(String giftName) {
        this.giftName = giftName;
    }

    public int getSinglePriceCoinRaw() {
        return singlePriceCoinRaw;
    }

    public void setSinglePriceCoinRaw(int singlePriceCoinRaw) {
        this.singlePriceCoinRaw = singlePriceCoinRaw;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GiftMessage that = (GiftMessage) o;
        return roomId == that.roomId &&
                uid == that.uid &&
                gold == that.gold &&
                totalCoin == that.totalCoin &&
                giftId == that.giftId &&
                singlePriceCoinRaw == that.singlePriceCoinRaw &&
                count == that.count &&
                userName.equals(that.userName) &&
                userAvatarUrl.equals(that.userAvatarUrl) &&
                giftName.equals(that.giftName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomId, uid, userName, userAvatarUrl, gold, totalCoin, giftId, giftName, singlePriceCoinRaw, count);
    }

    @Override
    public String toString() {
        return "GiftMessage{" +
                "roomId=" + roomId +
                ", uid=" + uid +
                ", userName='" + userName + '\'' +
                ", userAvatarUrl='" + userAvatarUrl + '\'' +
                ", gold=" + gold +
                ", totalCoin=" + totalCoin +
                ", giftId=" + giftId +
                ", giftName='" + giftName + '\'' +
                ", singlePriceCoinRaw=" + singlePriceCoinRaw +
                ", count=" + count +
                '}';
    }
}
