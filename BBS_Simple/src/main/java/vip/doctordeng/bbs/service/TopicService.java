package vip.doctordeng.bbs.service;

import vip.doctordeng.bbs.common.page.Page;
import vip.doctordeng.bbs.pojo.vo.SimpleTopicVo;
import vip.doctordeng.bbs.pojo.vo.TopicVo;

import java.util.List;

public interface TopicService {
	boolean addTopic(final String topic_title, final String topic_content, final Integer user_id, final  Integer forum_id);
	boolean addNotice(final String topic_title, final String topic_content, final Integer user_id);
	Page<SimpleTopicVo> querySimpleTopicAll(final int currPage, final int pageSize);
	Page<SimpleTopicVo> querySimpleTopicByForum(final Integer forum_id, final int currPage, final int pageSize);
	Page<SimpleTopicVo> querySimpleTopicByTitle(final String topic_title, final int currPage, final int pageSize);
	Page<SimpleTopicVo> querySimpleTopicByUser(final Integer user_id, final int currPage, final int pageSize);
	Page<SimpleTopicVo> queryUserApplyBestTopic(final Integer user_id, final int currPage, final int pageSize);
	Page<SimpleTopicVo> queryBestTopic(final int currPage, final int pageSize);
	Page<SimpleTopicVo> queryApplyBestTopic(final int currPage, final int pageSize);
	// 查询最新发布的 5 条帖子
	List<SimpleTopicVo> queryNewSimpleTopic();
	// 查询最新发布的 5 条精华帖
	List<SimpleTopicVo> queryNewBestSimpleTopic();
	// // 查询所有公告, 公告数量为 5 条
	List<SimpleTopicVo> queryAllNotice();

	Page<TopicVo> queryTopicById(final Integer topic_id, final  int currPage, final int pageSize);
	boolean topicApplyBest(final  Integer topic_id);
	boolean agreeTopicApplyBest(final  Integer topic_id);
	boolean rejectTopicApplyBest(final Integer topic_id);
}
