package dd.center.vnerve.data.bilibili.live;

import java.util.List;
import java.util.Objects;

/** 删除 Super Chat 消息，通常由房管发出 */
public class SuperChatDeletedMessage implements RoomMessage {
    /** 长直播间ID */
    private int roomId;
    /** 删除的所有 Super Chat 的 ID，对应 {@link SuperChatMessage#getId} 字段 */
    private List<Long> ids;

    public SuperChatDeletedMessage() {
    }

    public SuperChatDeletedMessage(int roomId, List<Long> ids) {
        this.roomId = roomId;
        this.ids = ids;
    }

    @Override
    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public List<Long> getIds() {
        return ids;
    }

    public void setIds(List<Long> ids) {
        this.ids = ids;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SuperChatDeletedMessage that = (SuperChatDeletedMessage) o;
        return roomId == that.roomId &&
                Objects.equals(ids, that.ids);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomId, ids);
    }

    @Override
    public String toString() {
        return "SuperChatDeletedMessage{" +
                "roomId=" + roomId +
                ", ids=" + ids +
                '}';
    }
}
