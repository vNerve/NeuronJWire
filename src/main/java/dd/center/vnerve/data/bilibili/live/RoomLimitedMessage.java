package dd.center.vnerve.data.bilibili.live;

import java.util.Objects;

/**
 * 直播间受限，发生情况尚不明<br />
 * 可能在播放带版权的内容时出现，亦可能进入某些特殊分区（放映厅等）时候出现。
 */
public class RoomLimitedMessage implements RoomMessage {
    /** 直播间长 ID */
    private int roomId;

    /** 源 JSON 中的 type 字段 */
    private String type;
    /** 源 JSON 中的 delay_range 字段 */
    private int delayRange;

    public RoomLimitedMessage() {
    }

    public RoomLimitedMessage(int roomId, String type, int delayRange) {
        this.roomId = roomId;
        this.type = type;
        this.delayRange = delayRange;
    }

    @Override
    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getDelayRange() {
        return delayRange;
    }

    public void setDelayRange(int delayRange) {
        this.delayRange = delayRange;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoomLimitedMessage that = (RoomLimitedMessage) o;
        return roomId == that.roomId &&
                delayRange == that.delayRange &&
                type.equals(that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomId, type, delayRange);
    }
}
