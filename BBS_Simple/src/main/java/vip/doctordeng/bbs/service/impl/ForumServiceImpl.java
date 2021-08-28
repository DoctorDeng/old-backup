package vip.doctordeng.bbs.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import vip.doctordeng.bbs.common.constant.ForumConstant;
import vip.doctordeng.bbs.dao.ForumDao;
import vip.doctordeng.bbs.pojo.entity.ForumEntity;
import vip.doctordeng.bbs.result.Message;
import vip.doctordeng.bbs.result.ResultUtil;
import vip.doctordeng.bbs.service.ForumService;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description:
 *
 * @author Doctor邓
 * @since 2017/4/9 17:59
 */
@Service
public class ForumServiceImpl implements ForumService {
    @Resource
    private ForumDao forumDao;

    @Override
    public boolean addForum(final String forum_name, final String forum_introduction, final Integer forum_parent_id) {
        ForumEntity forumEntity = new ForumEntity(forum_parent_id, forum_name, forum_introduction);
        forumEntity.setProp1(ForumConstant.FORUM_TYPE_NORMAL);
        int result = forumDao.insertForum(forumEntity);
        return result > 0;
    }

    @Override
    public boolean checkForumId(Integer forum_id) {
        if (null == forum_id) return false;

        Map queryMap = new HashMap() {{
            put("forum_id", forum_id);
        }};

        int result = forumDao.getForumCountByCondition(queryMap);
        return result > 0;
    }

    private boolean checkForumByNameAndParentid(final String forum_name, final Integer forum_parent_id) {
        if (StringUtils.isEmpty(forum_name) && null == forum_parent_id) return false;

        Map queryMap = new HashMap() {{
            put("forum_name", forum_name);
            put("forum_parent_id", forum_parent_id);
        }};

        int result = forumDao.getForumCountByCondition(queryMap);
        return result > 0;
    }

    @Override
    public List<ForumEntity> queryAllForum() {
        Map queryMap = new HashMap() {{
            put("forum_status", 0);
        }};
        List<ForumEntity> forums = forumDao.listForumByCondition(queryMap);
        if (null == forums) forums = new ArrayList<>();
        return forums;
    }

    @Override
    public Message checkForum(String forum_name, Integer forum_parent_id) {
        if (StringUtils.isEmpty(forum_name)) {
            return ResultUtil.getOneErrorFailMessage("forum_add_error", "板块名称不能为空");
        } else if (forum_name.length() > 6) {
            return ResultUtil.getOneErrorFailMessage("forum_add_error", "板块名称长度不能大于 6");
        }

        if (null != forum_parent_id) {
            boolean result = checkForumId(forum_parent_id);
            if (!result) {
                return ResultUtil.getOneErrorFailMessage("forum_add_error", "父板块数据输入不合法");
            }
        }

        if (checkForumByNameAndParentid(forum_name.trim(), forum_parent_id)) {
            return ResultUtil.getOneErrorFailMessage("forum_add_error", "已存在此板块");
        }

        return ResultUtil.getSuccessMessage();
    }
}
