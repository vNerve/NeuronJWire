package dd.center.vnerve.data.bilibili.live;

import java.util.Objects;

/**
 * 直播间上下播状态更新
 */
public class LiveStatusUpdateMessage implements RoomMessage {
    /**
     * 直播间长ID
     */
    private int roomId;
    /**
     * 新的上下播状态
     */
    private LiveStatus newStatus;
    /**
     * 在新的状态为 {@link LiveStatus#CUT_OFF} 时候提供切断直播时超管的消息
     */
    private String message;

    public LiveStatusUpdateMessage() {
    }

    public LiveStatusUpdateMessage(int roomId, LiveStatus newStatus, String message) {
        this.roomId = roomId;
        this.newStatus = newStatus;
        this.message = message;
    }

    @Override
    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public LiveStatus getNewStatus() {
        return newStatus;
    }

    public void setNewStatus(LiveStatus newStatus) {
        this.newStatus = newStatus;
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
        LiveStatusUpdateMessage that = (LiveStatusUpdateMessage) o;
        return roomId == that.roomId &&
                newStatus == that.newStatus &&
                message.equals(that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomId, newStatus, message);
    }

    @Override
    public String toString() {
        return "LiveStatusUpdateMessage{" +
                "roomId=" + roomId +
                ", newStatus=" + newStatus +
                ", message='" + message + '\'' +
                '}';
    }
}
