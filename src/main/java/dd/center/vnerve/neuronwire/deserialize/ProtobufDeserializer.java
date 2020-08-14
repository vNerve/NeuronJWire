package dd.center.vnerve.neuronwire.deserialize;

import com.google.protobuf.InvalidProtocolBufferException;
import dd.center.vnerve.data.bilibili.live.PopularityUpdateMessage;

import java.time.*;

import static vNerve.bilibili.live.RoomMessageOuterClass.*;
import static vNerve.bilibili.live.UserMessageOuterClass.*;

public class ProtobufDeserializer {
    private static final ZoneId biliveZoneId = ZoneOffset.ofTotalSeconds(8 * 3600); // UTC+8

    public dd.center.vnerve.data.bilibili.live.RoomMessage deserialize(byte[] data) throws DeserializeFailedException {
        try {
            RoomMessage rootMessage = RoomMessage.parseFrom(data);

            return convert(rootMessage);
        } catch (InvalidProtocolBufferException e) {
            throw new DeserializeFailedException(e);
        }
    }

    public dd.center.vnerve.data.bilibili.live.RoomMessage convert(RoomMessage roomMessage) throws DeserializeFailedException {
        int roomId = roomMessage.getRoomId();
        if (roomMessage.getPayloadCase() == null)
            throw new DeserializeFailedException("Invalid room message: Unknown payload type");
        switch (roomMessage.getPayloadCase()) {
            case USER_MESSAGE:
                return convert(roomId, roomMessage.getUserMessage());
            case POPULARITY_CHANGE:
                return new PopularityUpdateMessage(roomId, roomMessage.getPopularityChange().getPopularity());
            case LIVE_STATUS:
                LiveStatusChangedMessage rawLiveStatus = roomMessage.getLiveStatus();
                return new dd.center.vnerve.data.bilibili.live.LiveStatusUpdateMessage(
                        roomId, buildLiveStatus(rawLiveStatus.getStatus()), rawLiveStatus.getMessage()
                );
            case INFO_CHANGE:
                RoomInfoChangedMessage rawInfoChanged = roomMessage.getInfoChange();
                if (rawInfoChanged.getChangedCase() == null)
                    throw new DeserializeFailedException("Invalid Room info changed message: unknown changed field");
                switch (rawInfoChanged.getChangedCase()) {
                    case BASE_INFO:
                        RoomBaseInfo rawBaseInfo = rawInfoChanged.getBaseInfo();
                        return new dd.center.vnerve.data.bilibili.live.RoomBaseInfoChangedMessage(
                                roomId, rawBaseInfo.getTitle(),
                                rawBaseInfo.getAreaId(), rawBaseInfo.getAreaName(),
                                rawBaseInfo.getParentAreaId(), rawBaseInfo.getParentAreaName()
                        );
                    case BACKGROUND_URL:
                        return new dd.center.vnerve.data.bilibili.live.RoomBackgroundURLChangedMessage(
                                roomId, rawInfoChanged.getBackgroundUrl()
                        );
                    case SKIN_ID:
                        return new dd.center.vnerve.data.bilibili.live.RoomSkinIdChangedMessage(
                                roomId, rawInfoChanged.getSkinId()
                        );
                    case ADMIN:
                        return new dd.center.vnerve.data.bilibili.live.RoomAdminChangedMessage(
                                roomId, rawInfoChanged.getAdmin().getUidList()
                        );
                    default:
                        throw new DeserializeFailedException("Invalid Room info changed message: unknown changed field");
                }
            case ROOM_LOCKED:
                return new dd.center.vnerve.data.bilibili.live.RoomLockedMessage(
                        roomId,
                        ZonedDateTime.ofInstant(Instant.ofEpochSecond(roomMessage.getRoomLocked().getLockedUntil()), biliveZoneId)
                );
            case ROOM_WARNING:
                return new dd.center.vnerve.data.bilibili.live.RoomWarningMessage(
                        roomId, roomMessage.getRoomWarning().getMessage()
                );
            case ROOM_LIMITED:
                RoomLimitedMessage rawLimited = roomMessage.getRoomLimited();
                return new dd.center.vnerve.data.bilibili.live.RoomLimitedMessage(
                        roomId, rawLimited.getType(), rawLimited.getDelayRange()
                );
            case SUPERCHAT_DELETE:
                return new dd.center.vnerve.data.bilibili.live.SuperChatDeletedMessage(
                        roomId, roomMessage.getSuperchatDelete().getIdList()
                );
            default:
                throw new DeserializeFailedException("Invalid room message: Unknown payload type");
        }
    }

    public dd.center.vnerve.data.bilibili.live.UserMessage convert(int roomId, UserMessage userMessage) throws DeserializeFailedException {
        UserInfo user = userMessage.getUser();
        long uid = user.getUid();
        if (userMessage.getPayloadCase() == null)
            throw new DeserializeFailedException("Invalid user message! Unknown payload case");
        switch (userMessage.getPayloadCase()) {
            case DANMAKU:
                DanmakuMessage rawDanmaku = userMessage.getDanmaku();
                return new dd.center.vnerve.data.bilibili.live.DanmakuMessage(
                        roomId,
                        uid,
                        user.getName(),
                        new dd.center.vnerve.data.bilibili.live.DanmakuMessage.UserDetails(
                                user.getAdmin(),
                                user.getUserLevelBorderColor(),
                                user.getTitle(),
                                buildMedalInfo(user.getMedal()),
                                user.getUserLevel(),
                                buildGuardLevel(user.getGuardLevel()),
                                buildLiveVipLevel(user.getLiveVipLevel()),
                                user.getPhoneVerified(), user.getRegularUser()
                        ), buildLotteryDanmakuType(rawDanmaku.getLotteryType()), rawDanmaku.getMessage()
                );
            case GIFT:
                GiftMessage rawGift = userMessage.getGift();
                return new dd.center.vnerve.data.bilibili.live.GiftMessage(
                        roomId, uid, user.getName(),
                        user.getAvatarUrl(),
                        rawGift.getIsGold(),
                        rawGift.getTotalCoin(),
                        rawGift.getGiftId(),
                        rawGift.getGiftName(),
                        rawGift.getSinglePriceCoinRaw(),
                        rawGift.getCount()
                );
            case SUPER_CHAT:
                SuperChatMessage rawSuperChat = userMessage.getSuperChat();
                return new dd.center.vnerve.data.bilibili.live.SuperChatMessage(
                        roomId, uid, user.getName(),
                        new dd.center.vnerve.data.bilibili.live.SuperChatMessage.UserDetails(
                                user.getAdmin(),
                                user.getUserLevelBorderColor(),
                                user.getTitle(),
                                buildMedalInfo(user.getMedal()),
                                user.getUserLevel(),
                                buildGuardLevel(user.getGuardLevel()),
                                buildLiveVipLevel(user.getLiveVipLevel()),
                                user.getAvatarUrl()
                        ),
                        rawSuperChat.getMessage(),
                        rawSuperChat.getId(), rawSuperChat.getToken(),
                        rawSuperChat.getPriceCny(), rawSuperChat.getPriceCoin(),
                        Duration.ofSeconds(rawSuperChat.getLastingTimeSec()),
                        ZonedDateTime.ofInstant(Instant.ofEpochSecond(rawSuperChat.getStartTime()), biliveZoneId),
                        ZonedDateTime.ofInstant(Instant.ofEpochSecond(rawSuperChat.getEndTime()), biliveZoneId)
                );
            case NEW_GUARD:
                NewGuardMessage rawNewGuard = userMessage.getNewGuard();
                return new dd.center.vnerve.data.bilibili.live.NewGuardMessage(
                        roomId, uid, user.getName(),
                        buildGuardLevel(rawNewGuard.getLevel()),
                        rawNewGuard.getTotalCoin(),
                        rawNewGuard.getCount(),
                        buildGuardDurationLevel(rawNewGuard.getDurationLevel()),
                        buildGuardBuyType(rawNewGuard.getBuyType())
                );
            case WELCOME_VIP:
                WelcomeVIPMessage rawWelcomeVip = userMessage.getWelcomeVip();
                return new dd.center.vnerve.data.bilibili.live.WelcomeVipMessage(
                        roomId, uid, user.getName(),
                        buildLiveVipLevel(rawWelcomeVip.getLevel()),
                        user.getAdmin()
                );
            case WELCOME_GUARD:
                WelcomeGuardMessage rawWelcomeGuard = userMessage.getWelcomeGuard();
                return new dd.center.vnerve.data.bilibili.live.WelcomeGuardMessage(
                        roomId, uid, user.getName(),
                        buildGuardLevel(rawWelcomeGuard.getLevel())
                );
            case USER_BLOCKED:
                return new dd.center.vnerve.data.bilibili.live.UserBlockedMessage(
                        roomId, uid
                );
            default:
                throw new DeserializeFailedException("Invalid user message! Unknown payload case");
        }
    }

    private dd.center.vnerve.data.bilibili.live.LiveStatus buildLiveStatus(LiveStatus raw) {
        return dd.center.vnerve.data.bilibili.live.LiveStatus.values()[raw.ordinal()];
    }

    private dd.center.vnerve.data.bilibili.live.NewGuardMessage.GuardDurationLevel buildGuardDurationLevel(GuardDurationLevel level) {
        return dd.center.vnerve.data.bilibili.live.NewGuardMessage.GuardDurationLevel.values()[level.ordinal()];
    }

    private dd.center.vnerve.data.bilibili.live.NewGuardMessage.GuardBuyType buildGuardBuyType(GuardBuyType level) {
        return dd.center.vnerve.data.bilibili.live.NewGuardMessage.GuardBuyType.values()[level.ordinal()];
    }

    private dd.center.vnerve.data.bilibili.live.GuardLevel buildGuardLevel(GuardLevel level) {
        return dd.center.vnerve.data.bilibili.live.GuardLevel.values()[level.ordinal()];
    }

    private dd.center.vnerve.data.bilibili.live.LiveVipLevel buildLiveVipLevel(LiveVipLevel level) {
        return dd.center.vnerve.data.bilibili.live.LiveVipLevel.values()[level.ordinal()];
    }

    private dd.center.vnerve.data.bilibili.live.DanmakuMessage.LotteryDanmakuType buildLotteryDanmakuType(LotteryDanmakuType type) {
        return dd.center.vnerve.data.bilibili.live.DanmakuMessage.LotteryDanmakuType.values()[type.ordinal()];
    }

    private dd.center.vnerve.data.bilibili.live.MedalInfo buildMedalInfo(MedalInfo raw) {
        return new dd.center.vnerve.data.bilibili.live.MedalInfo(
                raw.getMedalName(), raw.getMedalLevel(), raw.getMedalColor(),
                raw.getStreamerUid(), raw.getStreamerName(), raw.getStreamerRoomid()
        );
    }
}
