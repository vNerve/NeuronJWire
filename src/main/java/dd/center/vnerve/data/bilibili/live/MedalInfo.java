package dd.center.vnerve.data.bilibili.live;

import java.util.Objects;

/** 直播勋章信息 */
public class MedalInfo {
    /** 勋章名称 */
    private String name;
    /** 勋章等级 */
    private int level;
    /** 勋章颜色，RGB */
    private int color;
    /** 勋章对应主播的 UID */
    private long streamerUid;
    /** 勋章对应主播主站昵称 */
    private String streamerName;
    /** 勋章对应主播直播间 ID */
    private int streamerRoomId;

    public MedalInfo() {
    }

    public MedalInfo(String name, int level, int color, long streamerUid, String streamerName, int streamerRoomId) {
        this.name = name;
        this.level = level;
        this.color = color;
        this.streamerUid = streamerUid;
        this.streamerName = streamerName;
        this.streamerRoomId = streamerRoomId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public long getStreamerUid() {
        return streamerUid;
    }

    public void setStreamerUid(long streamerUid) {
        this.streamerUid = streamerUid;
    }

    public String getStreamerName() {
        return streamerName;
    }

    public void setStreamerName(String streamerName) {
        this.streamerName = streamerName;
    }

    public int getStreamerRoomId() {
        return streamerRoomId;
    }

    public void setStreamerRoomId(int streamerRoomId) {
        this.streamerRoomId = streamerRoomId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MedalInfo medalInfo = (MedalInfo) o;
        return level == medalInfo.level &&
                color == medalInfo.color &&
                streamerUid == medalInfo.streamerUid &&
                streamerName.equals(medalInfo.streamerName) &&
                streamerRoomId == medalInfo.streamerRoomId &&
                name.equals(medalInfo.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, level, color, streamerUid, streamerName, streamerRoomId);
    }

    @Override
    public String toString() {
        return "MedalInfo{" +
                "name='" + name + '\'' +
                ", level=" + level +
                ", color=" + color +
                ", streamerUid=" + streamerUid +
                ", streamerName='" + streamerName + '\'' +
                ", streamerRoomId=" + streamerRoomId +
                '}';
    }
}
