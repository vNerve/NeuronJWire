package dd.center.vnerve.data.bilibili.live;

import java.util.Objects;

/** 直播间背景图 */
public class RoomBackgroundURLChangedMessage implements RoomMessage {
    /** 直播间长 ID */
    private int roomId;

    /** 直播间背景图 */
    private String url;

    public RoomBackgroundURLChangedMessage() {
    }

    public RoomBackgroundURLChangedMessage(int roomId, String url) {
        this.roomId = roomId;
        this.url = url;
    }

    @Override
    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoomBackgroundURLChangedMessage that = (RoomBackgroundURLChangedMessage) o;
        return roomId == that.roomId &&
                url.equals(that.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomId, url);
    }

    @Override
    public String toString() {
        return "RoomBackgroundURLChangedMessage{" +
                "roomId=" + roomId +
                ", url='" + url + '\'' +
                '}';
    }
}
