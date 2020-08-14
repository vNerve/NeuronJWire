package dd.center.vnerve.data.bilibili.live;

import java.util.Objects;

/** 大航海/上舰 */
public class NewGuardMessage implements UserMessage {
    /** 直播间长 ID */
    private int roomId;
    /** 用户 ID */
    private long uid;
    /** 用户名 */
    private String userName;

    /** 舰队等级 */
    private GuardLevel guardLevel;
    /** 总瓜子金额 */
    private int totalCoin;
    /** 上舰时间，以 {@link NewGuardMessage#durationLevel} 为单位（月或周） */
    private int count;
    /** 上舰时长类型，可能为月或周 */
    private GuardDurationLevel durationLevel;
    /** 上舰操作类型，可能为新加入或续费  */
    private GuardBuyType buyType;

    public NewGuardMessage() {
    }

    public NewGuardMessage(int roomId, long uid, String userName, GuardLevel guardLevel, int totalCoin, int count, GuardDurationLevel durationLevel, GuardBuyType buyType) {
        this.roomId = roomId;
        this.uid = uid;
        this.userName = userName;
        this.guardLevel = guardLevel;
        this.totalCoin = totalCoin;
        this.count = count;
        this.durationLevel = durationLevel;
        this.buyType = buyType;
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

    public GuardLevel getGuardLevel() {
        return guardLevel;
    }

    public void setGuardLevel(GuardLevel guardLevel) {
        this.guardLevel = guardLevel;
    }

    public int getTotalCoin() {
        return totalCoin;
    }

    public void setTotalCoin(int totalCoin) {
        this.totalCoin = totalCoin;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public GuardDurationLevel getDurationLevel() {
        return durationLevel;
    }

    public void setDurationLevel(GuardDurationLevel durationLevel) {
        this.durationLevel = durationLevel;
    }

    public GuardBuyType getBuyType() {
        return buyType;
    }

    public void setBuyType(GuardBuyType buyType) {
        this.buyType = buyType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NewGuardMessage that = (NewGuardMessage) o;
        return roomId == that.roomId &&
                uid == that.uid &&
                totalCoin == that.totalCoin &&
                count == that.count &&
                userName.equals(that.userName) &&
                guardLevel == that.guardLevel &&
                durationLevel == that.durationLevel &&
                buyType == that.buyType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomId, uid, userName, guardLevel, totalCoin, count, durationLevel, buyType);
    }

    @Override
    public String toString() {
        return "NewGuardMessage{" +
                "roomId=" + roomId +
                ", uid=" + uid +
                ", userName='" + userName + '\'' +
                ", guardLevel=" + guardLevel +
                ", totalCoin=" + totalCoin +
                ", count=" + count +
                ", durationLevel=" + durationLevel +
                ", buyType=" + buyType +
                '}';
    }

    /** 判断上舰操作是续费还是新加入 */
    public enum GuardBuyType {
        /** 未知 */
        NO_TYPE,
        /** 新加入 */
        BUY,
        /** 续费 */
        RENEW
    }

    /** 判断上舰操作是按月还是按周 */
    public enum GuardDurationLevel {
        /** 未知 */
        NO_DURATION,
        /** 按月 */
        MONTHLY_GUARD,
        /** 按周 */
        WEEKLY_GUARD
    }
}
