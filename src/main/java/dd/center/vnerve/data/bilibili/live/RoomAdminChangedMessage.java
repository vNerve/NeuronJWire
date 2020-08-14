package dd.center.vnerve.data.bilibili.live;

import java.util.List;
import java.util.Objects;

/** 直播间房管列表 */
public class RoomAdminChangedMessage implements RoomMessage {
    /** 直播间长 ID */
    private int roomId;

    /** 直播间房管列表 */
    private List<Long> admins;

    public RoomAdminChangedMessage() {
    }

    public RoomAdminChangedMessage(int roomId, List<Long> admins) {
        this.roomId = roomId;
        this.admins = admins;
    }

    @Override
    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public List<Long> getAdmins() {
        return admins;
    }

    public void setAdmins(List<Long> admins) {
        this.admins = admins;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoomAdminChangedMessage that = (RoomAdminChangedMessage) o;
        return roomId == that.roomId &&
                admins.equals(that.admins);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomId, admins);
    }

    @Override
    public String toString() {
        return "RoomAdminChangedMessage{" +
                "roomId=" + roomId +
                ", admins=" + admins +
                '}';
    }
}
