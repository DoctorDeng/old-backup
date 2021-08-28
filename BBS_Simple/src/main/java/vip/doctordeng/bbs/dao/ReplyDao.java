package vip.doctordeng.bbs.dao;

import vip.doctordeng.bbs.pojo.entity.ReplyEntity;

import java.util.List;
import java.util.Map;

public interface ReplyDao {
	int insertReply(ReplyEntity replyModule);
	List<ReplyEntity> listReplyByCondition(Map conditon);
	List<Map> listReplyInfoByCondition(Map condition);
	int getReplyCountByCondition(Map condition);
}
