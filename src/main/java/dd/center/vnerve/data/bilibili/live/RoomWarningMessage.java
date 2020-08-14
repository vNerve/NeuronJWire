package dd.center.vnerve.data.bilibili.live;

import java.util.Objects;

/** 直播间被警告 */
public class RoomWarningMessage implements RoomMessage {
    /** 直播间长 ID */
    private int roomId;
    /** 警告的信息 */
    private String message;

    public RoomWarningMessage() {
    }

    public RoomWarningMessage(int roomId, String message) {
        this.roomId = roomId;
        this.message = message;
    }

    @Override
    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoomWarningMessage that = (RoomWarningMessage) o;
        return roomId == that.roomId &&
                message.equals(that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomId, message);
    }
}
