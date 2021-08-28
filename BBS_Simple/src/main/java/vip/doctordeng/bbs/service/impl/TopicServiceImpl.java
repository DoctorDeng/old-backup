package vip.doctordeng.bbs.service.impl;

import org.springframework.stereotype.Service;
import vip.doctordeng.bbs.common.constant.ForumConstant;
import vip.doctordeng.bbs.common.constant.TopicConstant;
import vip.doctordeng.bbs.common.page.Page;
import vip.doctordeng.bbs.dao.ForumDao;
import vip.doctordeng.bbs.dao.ReplyDao;
import vip.doctordeng.bbs.dao.TopicDao;
import vip.doctordeng.bbs.pojo.entity.TopicEntity;
import vip.doctordeng.bbs.pojo.vo.SimpleTopicVo;
import vip.doctordeng.bbs.pojo.vo.TopicVo;
import vip.doctordeng.bbs.service.TopicService;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description:
 *
 * @author Doctor邓
 * @since 2017/4/10 12:50
 */
@Service
public class TopicServiceImpl implements TopicService {
    @Resource
    private TopicDao topicDao;
    @Resource
    private ReplyDao replyDao;
    @Resource
    private ForumDao forumDao;

    @Override
    public boolean addTopic(String topic_title, String topic_content, Integer user_id, Integer forum_id) {
        if (!checkForumId(forum_id)) return false;

        TopicEntity topicEntity = new TopicEntity();
        topicEntity.setTopic_title(topic_title);
        topicEntity.setTopic_introduction("");
        topicEntity.setTopic_content(topic_content);
        topicEntity.setUser_id(user_id);
        topicEntity.setForum_id(forum_id);
        topicEntity.setTopic_type(TopicConstant.TOPIC_TYPE_COMMON);

        int result = topicDao.insertTopic(topicEntity);
        return result > 0;
    }

    @Override
    public boolean addNotice(String topic_title, String topic_content, Integer user_id) {

        TopicEntity topicEntity = new TopicEntity();
        topicEntity.setTopic_title(topic_title);
        topicEntity.setTopic_introduction("");
        topicEntity.setTopic_content(topic_content);
        topicEntity.setUser_id(user_id);
        topicEntity.setForum_id(ForumConstant.FORUM_SYSTEM_NOTICE);
        topicEntity.setTopic_type(TopicConstant.TOPIC_TYPE_NOTICE);

        int result = topicDao.insertTopic(topicEntity);
        return result > 0;
    }

    @Override
    public Page<SimpleTopicVo> querySimpleTopicAll(int currPage, int pageSize) {
        Map queryCountMap = new HashMap(){{
            put("topic_status",TopicConstant.TOPIC_STATUS_NORMAL);
            put("topic_types", getCommonTopicTypes());
        }};

        int count = topicDao.getTopicCountByCondition(queryCountMap);
        Page<SimpleTopicVo> page = new Page<>(count, currPage, pageSize);

        queryCountMap.put("start", page.getSqlStart());
        queryCountMap.put("size", page.getPageSize());
        List<Map> simpleTopicMaps = topicDao.listSimpleTopicByCondition(queryCountMap);
        List<SimpleTopicVo> simpleTopicVos = SimpleTopicVo.covertList(simpleTopicMaps);
        page.setResultList(simpleTopicVos);

        return page;
    }

    @Override
    public Page<SimpleTopicVo> querySimpleTopicByForum(Integer forum_id, int currPage, int pageSize) {
        Map queryCountMap = new HashMap(){{
           put("forum_id",forum_id);
           put("topic_status",TopicConstant.TOPIC_STATUS_NORMAL);
            put("topic_types", getCommonTopicTypes());
        }};

        int count = topicDao.getTopicCountByCondition(queryCountMap);
        Page<SimpleTopicVo> page = new Page<>(count, currPage, pageSize);

        queryCountMap.put("start", page.getSqlStart());
        queryCountMap.put("size", page.getPageSize());
        List<Map> simpleTopicMaps = topicDao.listSimpleTopicByCondition(queryCountMap);
        List<SimpleTopicVo> simpleTopicVos = SimpleTopicVo.covertList(simpleTopicMaps);
        page.setResultList(simpleTopicVos);

        return page;
    }

    @Override
    public Page<SimpleTopicVo> querySimpleTopicByTitle(String topic_title, int currPage, int pageSize) {
        Map queryCountMap = new HashMap(){{
            put("topic_title", topic_title);
            put("topic_status",TopicConstant.TOPIC_STATUS_NORMAL);
            put("topic_types", getCommonTopicTypes());
        }};

        int count = topicDao.getTopicCountByCondition(queryCountMap);
        Page<SimpleTopicVo> page = new Page<>(count, currPage, pageSize);

        queryCountMap.put("start", page.getSqlStart());
        queryCountMap.put("size", page.getPageSize());
        List<Map> simpleTopicMaps = topicDao.listSimpleTopicByCondition(queryCountMap);
        List<SimpleTopicVo> simpleTopicVos = SimpleTopicVo.covertList(simpleTopicMaps);
        page.setResultList(simpleTopicVos);

        return page;
    }

    @Override
    public Page<SimpleTopicVo> querySimpleTopicByUser(Integer user_id, int currPage, int pageSize) {
        Map queryCountMap = new HashMap(){{
            put("user_id", user_id);
            put("topic_status",TopicConstant.TOPIC_STATUS_NORMAL);
        }};
        int count = topicDao.getTopicCountByCondition(queryCountMap);
        Page<SimpleTopicVo> page = new Page<>(count, currPage, pageSize);

        queryCountMap.put("start", page.getSqlStart());
        queryCountMap.put("size", page.getPageSize());
        List<Map> simpleTopicMaps = topicDao.listSimpleTopicByCondition(queryCountMap);
        List<SimpleTopicVo> simpleTopicVos = SimpleTopicVo.covertList(simpleTopicMaps);
        page.setResultList(simpleTopicVos);

        return page;
    }

    @Override
    public Page<SimpleTopicVo> queryUserApplyBestTopic(Integer user_id, int currPage, int pageSize) {
        Map queryCountMap = new HashMap(){{
            put("user_id", user_id);
            put("topic_status",TopicConstant.TOPIC_STATUS_NORMAL);
            put("prop1s", new String[]{TopicConstant.TOPIC_APPLY_AGREE,
                                        TopicConstant.TOPIC_APPLY_REJECT,
                                        TopicConstant.TOPIC_APPLY_APPLYING});
        }};

        int count = topicDao.getTopicCountByCondition(queryCountMap);
        Page<SimpleTopicVo> page = new Page<>(count, currPage, pageSize);

        queryCountMap.put("start", page.getSqlStart());
        queryCountMap.put("size", page.getPageSize());
        List<Map> simpleTopicMaps = topicDao.listSimpleTopicByCondition(queryCountMap);
        List<SimpleTopicVo> simpleTopicVos = SimpleTopicVo.covertList(simpleTopicMaps);
        page.setResultList(simpleTopicVos);

        return page;
    }

    @Override
    public Page<SimpleTopicVo> queryBestTopic(int currPage, int pageSize) {
        Map queryCountMap = new HashMap(){{
            put("topic_status",TopicConstant.TOPIC_STATUS_NORMAL);
            put("topic_type",TopicConstant.TOPIC_TYPE_BEST);
        }};

        int count = topicDao.getTopicCountByCondition(queryCountMap);
        Page<SimpleTopicVo> page = new Page<>(count, currPage, pageSize);

        queryCountMap.put("start", page.getSqlStart());
        queryCountMap.put("size", page.getPageSize());
        List<Map> simpleTopicMaps = topicDao.listSimpleTopicByCondition(queryCountMap);
        List<SimpleTopicVo> simpleTopicVos = SimpleTopicVo.covertList(simpleTopicMaps);
        page.setResultList(simpleTopicVos);

        return page;
    }

    @Override
    public Page<SimpleTopicVo> queryApplyBestTopic(int currPage, int pageSize) {
        Map queryCountMap = new HashMap(){{
            put("prop1", TopicConstant.TOPIC_APPLY_APPLYING);
            put("topic_status",TopicConstant.TOPIC_STATUS_NORMAL);
        }};

        int count = topicDao.getTopicCountByCondition(queryCountMap);
        Page<SimpleTopicVo> page = new Page<>(count, currPage, pageSize);

        queryCountMap.put("start", page.getSqlStart());
        queryCountMap.put("size", page.getPageSize());
        List<Map> simpleTopicMaps = topicDao.listSimpleTopicByCondition(queryCountMap);
        List<SimpleTopicVo> simpleTopicVos = SimpleTopicVo.covertList(simpleTopicMaps);
        page.setResultList(simpleTopicVos);

        return page;
    }

    @Override
    public List<SimpleTopicVo> queryNewSimpleTopic() {
        Map queryCountMap = new HashMap(){{
            put("topic_status",TopicConstant.TOPIC_STATUS_NORMAL);
            put("topic_type",TopicConstant.TOPIC_TYPE_COMMON);
            put("start", 0);
            put("size", 5);
        }};
        List<Map> simpleTopicMaps = topicDao.listSimpleTopicByCondition(queryCountMap);
        List<SimpleTopicVo> simpleTopicVos = SimpleTopicVo.covertList(simpleTopicMaps);

        return simpleTopicVos;
    }

    @Override
    public List<SimpleTopicVo> queryNewBestSimpleTopic() {
        Map queryCountMap = new HashMap(){{
            put("topic_status",TopicConstant.TOPIC_STATUS_NORMAL);
            put("topic_type",TopicConstant.TOPIC_TYPE_BEST);
            put("start", 0);
            put("size", 5);
        }};
        List<Map> simpleTopicMaps = topicDao.listSimpleTopicByCondition(queryCountMap);
        List<SimpleTopicVo> simpleTopicVos = SimpleTopicVo.covertList(simpleTopicMaps);

        return simpleTopicVos;
    }

    @Override
    public List<SimpleTopicVo> queryAllNotice() {
        Map queryCountMap = new HashMap(){{
            put("topic_status",TopicConstant.TOPIC_STATUS_NORMAL);
            put("topic_type",TopicConstant.TOPIC_TYPE_NOTICE);
        }};
        List<Map> simpleTopicMaps = topicDao.listSimpleTopicByCondition(queryCountMap);
        List<SimpleTopicVo> simpleTopicVos = SimpleTopicVo.covertList(simpleTopicMaps);

        return simpleTopicVos;
    }

    @Override
    public Page<TopicVo> queryTopicById(Integer topic_id, int currPage, int pageSize) {
        Map queryMap = new HashMap(){{
            put("topic_id",topic_id);
        }};
        int topicReplyCount = replyDao.getReplyCountByCondition(queryMap) + 1;
        Page<TopicVo> page = new Page<>(topicReplyCount, currPage, pageSize);

        List<Map> results = new ArrayList<>();
        if (page.getCurrPage() == 1) {
            Map map = topicDao.getTopicInfoById(topic_id);
            results.add(map);

            queryMap.put("start", page.getSqlStart());
            queryMap.put("size", page.getPageSize() - 1);
            List<Map> replys = replyDao.listReplyInfoByCondition(queryMap);
            results.addAll(replys);
        } else {
            queryMap.put("start", page.getSqlStart() - 1);
            queryMap.put("size", page.getPageSize());
            List<Map> replys = replyDao.listReplyInfoByCondition(queryMap);
             results.addAll(replys);
        }

        List<TopicVo> topicVos = TopicVo.coverList(results);
        page.setResultList(topicVos);
        return page;
    }

    @Override
    public boolean topicApplyBest(Integer topic_id) {
        Map dataMap = new HashMap(){{
            put("prop1",TopicConstant.TOPIC_APPLY_APPLYING);
            put("topic_id",topic_id);
        }};
        int result = topicDao.updateTopicByCondition(dataMap);
        return result > 0;
    }

    @Override
    public boolean agreeTopicApplyBest(Integer topic_id) {
        Map dataMap = new HashMap(){{
            put("prop1",TopicConstant.TOPIC_APPLY_AGREE);
            put("topic_id",topic_id);
            put("topic_type", TopicConstant.TOPIC_TYPE_BEST);
        }};
        int result = topicDao.updateTopicByCondition(dataMap);
        return result > 0;
    }

    @Override
    public boolean rejectTopicApplyBest(Integer topic_id) {
        Map dataMap = new HashMap(){{
            put("prop1",TopicConstant.TOPIC_APPLY_REJECT);
            put("topic_id",topic_id);
        }};
        int result = topicDao.updateTopicByCondition(dataMap);
        return result > 0;
    }

    private boolean checkForumId(Integer forum_id){
        if (null == forum_id) return false;

        Map queryMap = new HashMap(){{
            put("forum_id", forum_id);
        }};

        int result = forumDao.getForumCountByCondition(queryMap);
        return result > 0;
    }

    private ArrayList<Integer> getCommonTopicTypes() {
        return new ArrayList<Integer>() {
            {
                add(TopicConstant.TOPIC_TYPE_COMMON);
                add(TopicConstant.TOPIC_TYPE_BEST);
            }
        };
    }
}
