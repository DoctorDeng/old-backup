package vip.doctordeng.bbs.service.impl;

import org.springframework.stereotype.Service;
import vip.doctordeng.bbs.dao.ReplyDao;
import vip.doctordeng.bbs.pojo.entity.ReplyEntity;
import vip.doctordeng.bbs.service.ReplyService;

import javax.annotation.Resource;

/**
 * Description:
 *
 * @author Doctor邓
 * @since 2017/4/10 12:49
 */
@Service
public class ReplyServiceImpl implements ReplyService {
    @Resource
    private ReplyDao replyDao;
    @Override
    public boolean addReply(Integer topic_id, String reply_content, Integer user_id) {
        ReplyEntity replyEntity = new ReplyEntity();
        replyEntity.setTopic_id(topic_id);
        replyEntity.setReply_content(reply_content);
        replyEntity.setUser_id(user_id);
        int result = replyDao.insertReply(replyEntity);
        return result > 0;
    }

}
