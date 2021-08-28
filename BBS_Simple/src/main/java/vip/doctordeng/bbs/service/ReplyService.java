package vip.doctordeng.bbs.service;


/**
 * Description:
 *
 * @author Doctor邓
 * @since 2017/4/9 10:40
 */
public interface ReplyService {
    boolean addReply(final Integer topic_id, final String reply_content, final Integer user_id);
   /* List<ReplyEntity> queryReplyByTopicIdAndPage(final Integer topic_id, final int currPage, final int pageSize);*/
}
