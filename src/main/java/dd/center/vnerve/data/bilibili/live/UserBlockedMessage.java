package dd.center.vnerve.data.bilibili.live;

import java.util.Objects;

/** 用户被禁言 */
public class UserBlockedMessage implements UserMessage {
    /** 长直播间ID */
    private int roomId;
    /** 用户 ID */
    private long uid;

    public UserBlockedMessage() {
    }

    public UserBlockedMessage(int roomId, long uid) {
        this.roomId = roomId;
        this.uid = uid;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserBlockedMessage that = (UserBlockedMessage) o;
        return roomId == that.roomId &&
                uid == that.uid;
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomId, uid);
    }
}
