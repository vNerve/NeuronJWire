package dd.center.vnerve.data.bilibili.live;

import java.util.Objects;

/** 直播间皮肤 */
public class RoomSkinIdChangedMessage implements RoomMessage {
    /** 直播间长 ID */
    private int roomId;

    /** 直播间皮肤 ID */
    private int skinId;

    public RoomSkinIdChangedMessage() {
    }

    public RoomSkinIdChangedMessage(int roomId, int skinId) {
        this.roomId = roomId;
        this.skinId = skinId;
    }

    @Override
    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public int getSkinId() {
        return skinId;
    }

    public void setSkinId(int skinId) {
        this.skinId = skinId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoomSkinIdChangedMessage that = (RoomSkinIdChangedMessage) o;
        return roomId == that.roomId &&
                skinId == that.skinId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomId, skinId);
    }

    @Override
    public String toString() {
        return "RoomSkinIdChangedMessage{" +
                "roomId=" + roomId +
                ", skinId=" + skinId +
                '}';
    }
}