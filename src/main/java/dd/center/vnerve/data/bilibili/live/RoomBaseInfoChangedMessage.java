package dd.center.vnerve.data.bilibili.live;

import java.util.Objects;

/** 直播间标题与分区变更 */
public class RoomBaseInfoChangedMessage implements RoomMessage {
    /** 直播间长 ID */
    private int roomId;

    /** 直播间标题 */
    private String title;

    /** 分区 ID */
    private int areaId;
    /** 分区名 */
    private String areaName;
    /** 大分区 ID */
    private int parentAreaId;
    /** 大分区名 */
    private String parentAreaName;

    public RoomBaseInfoChangedMessage() {
    }

    public RoomBaseInfoChangedMessage(int roomId, String title, int areaId, String areaName, int parentAreaId, String parentAreaName) {
        this.roomId = roomId;
        this.title = title;
        this.areaId = areaId;
        this.areaName = areaName;
        this.parentAreaId = parentAreaId;
        this.parentAreaName = parentAreaName;
    }

    @Override
    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getAreaId() {
        return areaId;
    }

    public void setAreaId(int areaId) {
        this.areaId = areaId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public int getParentAreaId() {
        return parentAreaId;
    }

    public void setParentAreaId(int parentAreaId) {
        this.parentAreaId = parentAreaId;
    }

    public String getParentAreaName() {
        return parentAreaName;
    }

    public void setParentAreaName(String parentAreaName) {
        this.parentAreaName = parentAreaName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoomBaseInfoChangedMessage that = (RoomBaseInfoChangedMessage) o;
        return roomId == that.roomId &&
                areaId == that.areaId &&
                parentAreaId == that.parentAreaId &&
                title.equals(that.title) &&
                areaName.equals(that.areaName) &&
                parentAreaName.equals(that.parentAreaName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomId, title, areaId, areaName, parentAreaId, parentAreaName);
    }
}
