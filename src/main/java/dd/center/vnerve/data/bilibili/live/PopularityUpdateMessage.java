package dd.center.vnerve.data.bilibili.live;

import java.util.Objects;

/**
 * 直播间人气值更新<br/>此消息每房间约一分钟发送一条。
 */
public class PopularityUpdateMessage implements RoomMessage {
    /**
     * 直播间长ID
     */
    private int roomId = -1;
    /**
     * 新的直播间人气<br />
     * 注意，未开播时人气固定为 1
     */
    private int popularity = 1;

    public PopularityUpdateMessage() {
    }

    public PopularityUpdateMessage(int roomId, int popularity) {
        this.roomId = roomId;
        this.popularity = popularity;
    }

    @Override
    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public int getPopularity() {
        return popularity;
    }

    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PopularityUpdateMessage that = (PopularityUpdateMessage) o;
        return roomId == that.roomId &&
                popularity == that.popularity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomId, popularity);
    }

    @Override
    public String toString() {
        return "PopularityUpdateMessage{" +
                "roomId=" + roomId +
                ", popularity=" + popularity +
                '}';
    }
}
