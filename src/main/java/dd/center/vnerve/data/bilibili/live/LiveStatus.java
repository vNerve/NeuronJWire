package dd.center.vnerve.data.bilibili.live;

public enum LiveStatus {
    /** 下播 */
    PREPARING,
    /** 上播 */
    LIVE,
    /** 轮播（应视为下播） */
    ROUND,
    /** 直播被切断 */
    CUT_OFF
}
