package dd.center.vnerve.data.bilibili.live;

import java.util.Objects;

/** 欢迎老爷 */
public class WelcomeVipMessage implements UserMessage {
    /** 直播间长 ID */
    private int roomId;
    /** 用户 ID */
    private long uid;
    /** 用户名 */
    private String userName;

    /** 老爷等级 */
    private LiveVipLevel level;
    /** 用户是否为本直播间房管（有效性存疑） */
    private boolean admin;

    public WelcomeVipMessage() {
    }

    public WelcomeVipMessage(int roomId, long uid, String userName, LiveVipLevel level, boolean admin) {
        this.roomId = roomId;
        this.uid = uid;
        this.userName = userName;
        this.level = level;
        this.admin = admin;
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

    public LiveVipLevel getLevel() {
        return level;
    }

    public void setLevel(LiveVipLevel level) {
        this.level = level;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WelcomeVipMessage that = (WelcomeVipMessage) o;
        return roomId == that.roomId &&
                uid == that.uid &&
                admin == that.admin &&
                userName.equals(that.userName) &&
                level == that.level;
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomId, uid, userName, level, admin);
    }
}
