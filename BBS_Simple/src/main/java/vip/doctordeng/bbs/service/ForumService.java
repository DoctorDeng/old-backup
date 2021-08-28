package vip.doctordeng.bbs.service;

import vip.doctordeng.bbs.pojo.entity.ForumEntity;
import vip.doctordeng.bbs.result.Message;

import java.util.List;

public interface ForumService {
	boolean  addForum(final String forum_name, final String forum_introduction, final Integer forum_parent_id);
	List<ForumEntity> queryAllForum();
	Message checkForum(final String forum_name, final Integer forum_parent_id);
	boolean checkForumId(Integer forum_id);
}
