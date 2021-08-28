package vip.doctordeng.bbs.dao;

import vip.doctordeng.bbs.pojo.entity.ForumEntity;

import java.util.List;
import java.util.Map;
/**
 * 
 * @ClassName:  ForumDao   
 * @Description:TODO 版块 DAO
 * @author: DoctorDeng
 * @date:   2017年3月5日 下午12:35:54   
 *
 */
public interface ForumDao {
	int insertForum(ForumEntity forumEntity);
	int updateForumByCondition(Map  condition);
	List<ForumEntity> listForumByCondition(Map condition);
	ForumEntity getForumByCondition(Map condition);
	int getForumCountByCondition(Map condition);
}
