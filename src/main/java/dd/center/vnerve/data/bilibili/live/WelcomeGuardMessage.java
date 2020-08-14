package dd.center.vnerve.data.bilibili.live;

import java.util.Objects;

/** 欢迎舰长 */
public class WelcomeGuardMessage implements UserMessage {
    /** 直播间长 ID */
    private int roomId;
    /** 用户 ID */
    private long uid;
    /** 用户名 */
    private String userName;

    /** 舰队等级 */
    private GuardLevel level;

    public WelcomeGuardMessage() {
    }

    public WelcomeGuardMessage(int roomId, long uid, String userName, GuardLevel level) {
        this.roomId = roomId;
        this.uid = uid;
        this.userName = userName;
        this.level = level;
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

    public GuardLevel getLevel() {
        return level;
    }

    public void setLevel(GuardLevel level) {
        this.level = level;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WelcomeGuardMessage that = (WelcomeGuardMessage) o;
        return roomId == that.roomId &&
                uid == that.uid &&
                userName.equals(that.userName) &&
                level == that.level;
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomId, uid, userName, level);
    }
}
