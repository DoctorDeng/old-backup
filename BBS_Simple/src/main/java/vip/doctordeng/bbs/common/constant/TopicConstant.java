package vip.doctordeng.bbs.common.constant;

/**
 * Description:
 *
 * @author Doctor邓
 * @since 2017/4/13 13:19
 */
public interface TopicConstant {
    int TOPIC_TYPE_COMMON = 0;
    // 精华帖
    int TOPIC_TYPE_BEST = 1;
    // 公告贴
    int TOPIC_TYPE_NOTICE = 2;
    // 帖子正常
    int TOPIC_STATUS_NORMAL = 0;
    // 帖子被删除
    int TOPIC_STATUS_DELETE = 1;
    // 帖子申精状态, 0 正在申精， 1 申精被拒绝，2 申精通过,其他没有申精
    String TOPIC_APPLY_APPLYING = "0";
    String TOPIC_APPLY_REJECT = "1";
    String TOPIC_APPLY_AGREE = "2";

    // 查询所有帖子
    String TOPIC_SEARCH_ALL = "all";
    // 查询板块下的帖子
    String TOPIC_SEARCH_FORUM = "forum";
    // 查询精品贴
    String TOPIC_SEARCH_BEST = "best";
    // 按用户输入查询条件查询所有帖子
    String TOPIC_SEARCH_KEYWORDS = "search";
}
