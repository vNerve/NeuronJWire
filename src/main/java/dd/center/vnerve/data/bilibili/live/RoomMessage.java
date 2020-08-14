package dd.center.vnerve.data.bilibili.live;

/**
 * 与房间相关的消息 <br />
 * BiLive 实时消息的根消息
 */
public interface RoomMessage {
    /**
     * 获取直播间长ID
     * @return 直播间长ID
     */
    int getRoomId();
}
