package dd.center.vnerve.data.bilibili.live;

import java.util.Objects;

/** 弹幕消息 */
public class DanmakuMessage implements UserMessage {
    /** 长直播间ID */
    private int roomId;
    /** 用户 ID */
    private long uid;
    /** 用户名 */
    private String userName;

    /** 更多用户信息 */
    private UserDetails userDetails;
    /** 弹幕是否为抽奖/节奏风暴弹幕 */
    private LotteryDanmakuType lotteryType;
    /** 弹幕内容 */
    private String message;

    public DanmakuMessage() {
    }

    public DanmakuMessage(int roomId, long uid, String userName, UserDetails userDetails, LotteryDanmakuType lotteryType, String message) {
        this.roomId = roomId;
        this.uid = uid;
        this.userName = userName;
        this.userDetails = userDetails;
        this.lotteryType = lotteryType;
        this.message = message;
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

    public LotteryDanmakuType getLotteryType() {
        return lotteryType;
    }

    public void setLotteryType(LotteryDanmakuType lotteryType) {
        this.lotteryType = lotteryType;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    /** 弹幕是否为抽奖/节奏风暴弹幕 */
    public enum LotteryDanmakuType {
        /** 非抽奖/节奏风暴 */
        NO_LOTTERY,
        /** 节奏风暴 */
        STORM,
        /** 抽奖 */
        LOTTERY
    }
    /** 更多用户信息 */
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

        /** 用户手机是否认证 */
        private boolean phoneVerified;
        /**
          用户是否为正式会员 <br />
          不可靠！目前对此字段缺乏分析（原始值对应info[2][5]），尽量不要基于这个值判断！
        */
        private boolean regularUser;

        public UserDetails() {
        }

        public UserDetails(boolean admin, int userLevelBorderColor, String title, MedalInfo medal, int level, GuardLevel guardLevel, LiveVipLevel liveVipLevel, boolean phoneVerified, boolean regularUser) {
            this.admin = admin;
            this.userLevelBorderColor = userLevelBorderColor;
            this.title = title;
            this.medal = medal;
            this.level = level;
            this.guardLevel = guardLevel;
            this.liveVipLevel = liveVipLevel;
            this.phoneVerified = phoneVerified;
            this.regularUser = regularUser;
        }

        public boolean isAdmin() {
            return admin;
        }

        public void setAdmin(boolean admin) {
            this.admin = admin;
        }

        public LiveVipLevel getLiveVipLevel() {
            return liveVipLevel;
        }

        public void setLiveVipLevel(LiveVipLevel liveVipLevel) {
            this.liveVipLevel = liveVipLevel;
        }

        public int getLevel() {
            return level;
        }

        public void setLevel(int level) {
            this.level = level;
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

        public GuardLevel getGuardLevel() {
            return guardLevel;
        }

        public void setGuardLevel(GuardLevel guardLevel) {
            this.guardLevel = guardLevel;
        }

        public boolean isPhoneVerified() {
            return phoneVerified;
        }

        public void setPhoneVerified(boolean phoneVerified) {
            this.phoneVerified = phoneVerified;
        }

        public boolean isRegularUser() {
            return regularUser;
        }

        public void setRegularUser(boolean regularUser) {
            this.regularUser = regularUser;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            UserDetails that = (UserDetails) o;
            return admin == that.admin &&
                    userLevelBorderColor == that.userLevelBorderColor &&
                    level == that.level &&
                    phoneVerified == that.phoneVerified &&
                    regularUser == that.regularUser &&
                    title.equals(that.title) &&
                    medal.equals(that.medal) &&
                    guardLevel == that.guardLevel &&
                    liveVipLevel == that.liveVipLevel;
        }

        @Override
        public int hashCode() {
            return Objects.hash(admin, userLevelBorderColor, title, medal, level, guardLevel, liveVipLevel, phoneVerified, regularUser);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DanmakuMessage that = (DanmakuMessage) o;
        return roomId == that.roomId &&
                uid == that.uid &&
                userName.equals(that.userName) &&
                userDetails.equals(that.userDetails) &&
                lotteryType == that.lotteryType &&
                message.equals(that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomId, uid, userName, userDetails, lotteryType, message);
    }
}
