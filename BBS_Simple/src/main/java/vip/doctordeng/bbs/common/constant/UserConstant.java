package vip.doctordeng.bbs.common.constant;

/**
 * Description: User (用户) 相关常量
 *
 * @author Doctor邓
 * @since 2017/4/12 19:42
 */
public interface UserConstant {
    // 用户正常状态状态码
    int USER_STATUS_NORMAL = 0;
    // 用户被删除状态码
    int USER_STATUS_INVALID = 1;
    // 用户无法回复状态码
    int USER_STATUS_LIMIT_REPLY = 3;
    // 用户无法发帖状态码
    int USER_STATUS_LIMIT_POST  = 2;
    // 用户无法回复和发帖状态码
    int USER_STATUS_LIMIT_REPLY_POST = 4;
    // 已注册, 未激活用户
    int USER_TYPE_NOACTICATE = 0;
    // 普通用户
    int USER_TYPE_COMMON = 1;
    // 管理员
    int USER_TYPE_ADMIN = 2;
}
