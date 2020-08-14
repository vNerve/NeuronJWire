package dd.center.vnerve.data.bilibili.live;

import java.time.Duration;
import java.time.ZonedDateTime;
import java.util.Objects;

/** Super Chat - 醒目留言 */
public class SuperChatMessage implements UserMessage {
    /** 长直播间ID */
    private int roomId;
    /** 用户 ID */
    private long uid;
    /** 用户名 */
    private String userName;

    /** 更多用户信息 */
    private UserDetails userDetails;

    /** Super Chat 内容 */
    private String message;

    /** Super Chat ID，与删除 Super Chat 消息中的 ID 对应 */
    private long id;
    /** Super Chat Token，作用未知 */
    private String token;

    /** 人民币形式价格 */
    private int priceCny;
    /** 瓜子形式价格 */
    private int priceCoin;

    /** 持续显示在页面顶部时间 */
    private Duration lastingTime;
    /** 开始显示在页面顶部的时间 */
    private ZonedDateTime startTime;
    /** 结束显示在页面顶部的时 */
    private ZonedDateTime endTime;

    public SuperChatMessage() {
    }

    public SuperChatMessage(int roomId, long uid, String userName, UserDetails userDetails, String message, long id, String token, int priceCny, int priceCoin, Duration lastingTime, ZonedDateTime startTime, ZonedDateTime endTime) {
        this.roomId = roomId;
        this.uid = uid;
        this.userName = userName;
        this.userDetails = userDetails;
        this.message = message;
        this.id = id;
        this.token = token;
        this.priceCny = priceCny;
        this.priceCoin = priceCoin;
        this.lastingTime = lastingTime;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    @Override
    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public UserDetails getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(UserDetails userDetails) {
        this.userDetails = userDetails;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getPriceCny() {
        return priceCny;
    }

    public void setPriceCny(int priceCny) {
        this.priceCny = priceCny;
    }

    public int getPriceCoin() {
        return priceCoin;
    }

    public void setPriceCoin(int priceCoin) {
        this.priceCoin = priceCoin;
    }

    public Duration getLastingTime() {
        return lastingTime;
    }

    public void setLastingTime(Duration lastingTime) {
        this.lastingTime = lastingTime;
    }

    public ZonedDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(ZonedDateTime startTime) {
        this.startTime = startTime;
    }

    public ZonedDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(ZonedDateTime endTime) {
        this.endTime = endTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SuperChatMessage that = (SuperChatMessage) o;
        return roomId == that.roomId &&
                uid == that.uid &&
                id == that.id &&
                priceCny == that.priceCny &&
                priceCoin == that.priceCoin &&
                userName.equals(that.userName) &&
                userDetails.equals(that.userDetails) &&
                message.equals(that.message) &&
                token.equals(that.token) &&
                lastingTime.equals(that.lastingTime) &&
                startTime.equals(that.startTime) &&
                endTime.equals(that.endTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomId, uid, userName, userDetails, message, id, token, priceCny, priceCoin, lastingTime, startTime, endTime);
    }

    public static class UserDetails {
        /** 用户是否为本直播间房管 */
        private boolean admin;

        /** 用户等级边框颜色，RGB */
        private int userLevelBorderColor;
        /** 用户头衔 */
        private String title;
        /** 用户直播勋章信息 */
        private MedalInfo medal;
        /** 用户直播 UL 等级 */
        private int level;
        /** 用户大航海等级 */
        private GuardLevel guardLevel;
        /** 用户直播老爷等级 */
        private LiveVipLevel liveVipLevel;

        /** 用户头像 URL */
        private String userAvatarUrl;

        public UserDetails() {
        }

        public UserDetails(boolean admin, int userLevelBorderColor, String title, MedalInfo medal, int level, GuardLevel guardLevel, LiveVipLevel liveVipLevel, String userAvatarUrl) {
            this.admin = admin;
            this.userLevelBorderColor = userLevelBorderColor;
            this.title = title;
            this.medal = medal;
            this.level = level;
            this.guardLevel = guardLevel;
            this.liveVipLevel = liveVipLevel;
            this.userAvatarUrl = userAvatarUrl;
        }

        public boolean isAdmin() {
            return admin;
        }

        public void setAdmin(boolean admin) {
            this.admin = admin;
        }

        public int getUserLevelBorderColor() {
            return userLevelBorderColor;
        }

        public void setUserLevelBorderColor(int userLevelBorderColor) {
            this.userLevelBorderColor = userLevelBorderColor;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public MedalInfo getMedal() {
            return medal;
        }

        public void setMedal(MedalInfo medal) {
            this.medal = medal;
        }

        public int getLevel() {
            return level;
        }

        public void setLevel(int level) {
            this.level = level;
        }

        public GuardLevel getGuardLevel() {
            return guardLevel;
        }

        public void setGuardLevel(GuardLevel guardLevel) {
            this.guardLevel = guardLevel;
        }

        public LiveVipLevel getLiveVipLevel() {
            return liveVipLevel;
        }

        public void setLiveVipLevel(LiveVipLevel liveVipLevel) {
            this.liveVipLevel = liveVipLevel;
        }

        public String getUserAvatarUrl() {
            return userAvatarUrl;
        }

        public void setUserAvatarUrl(String userAvatarUrl) {
            this.userAvatarUrl = userAvatarUrl;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            UserDetails that = (UserDetails) o;
            return admin == that.admin &&
                    userLevelBorderColor == that.userLevelBorderColor &&
                    level == that.level &&
                    title.equals(that.title) &&
                    medal.equals(that.medal) &&
                    guardLevel == that.guardLevel &&
                    liveVipLevel == that.liveVipLevel &&
                    userAvatarUrl.equals(that.userAvatarUrl);
        }

        @Override
        public int hashCode() {
            return Objects.hash(admin, userLevelBorderColor, title, medal, level, guardLevel, liveVipLevel, userAvatarUrl);
        }
    }
}
