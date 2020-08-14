package dd.center.vnerve.data.bilibili.live;

import java.time.ZonedDateTime;
import java.util.Objects;

/** 直播间被锁定/封禁 */
public class RoomLockedMessage implements RoomMessage {
    /** 直播间长 ID */
    private int roomId;

    /** 封禁持续到的时间 */
    private ZonedDateTime lockedUntil;

    public RoomLockedMessage() {
    }

    public RoomLockedMessage(int roomId, ZonedDateTime lockedUntil) {
        this.roomId = roomId;
        this.lockedUntil = lockedUntil;
    }

    @Override
    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public ZonedDateTime getLockedUntil() {
        return lockedUntil;
    }

    public void setLockedUntil(ZonedDateTime lockedUntil) {
        this.lockedUntil = lockedUntil;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoomLockedMessage that = (RoomLockedMessage) o;
        return roomId == that.roomId &&
                lockedUntil.equals(that.lockedUntil);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomId, lockedUntil);
    }

    @Override
    public String toString() {
        return "RoomLockedMessage{" +
                "roomId=" + roomId +
                ", lockedUntil=" + lockedUntil +
                '}';
    }
}
