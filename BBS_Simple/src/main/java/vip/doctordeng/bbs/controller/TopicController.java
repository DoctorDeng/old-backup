package vip.doctordeng.bbs.controller;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import vip.doctordeng.bbs.common.PointUtil;
import vip.doctordeng.bbs.common.constant.PointConstant;
import vip.doctordeng.bbs.common.constant.TopicConstant;
import vip.doctordeng.bbs.common.constant.UserConstant;
import vip.doctordeng.bbs.common.page.Page;
import vip.doctordeng.bbs.pojo.entity.UserEntity;
import vip.doctordeng.bbs.pojo.vo.SimpleTopicVo;
import vip.doctordeng.bbs.pojo.vo.TopicVo;
import vip.doctordeng.bbs.service.ForumService;
import vip.doctordeng.bbs.service.ReplyService;
import vip.doctordeng.bbs.service.TopicService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 *
 * @author Doctor邓
 * @since 2017/4/9 9:49
 */
@Controller
@RequestMapping("/topic")
public class TopicController {
    private Logger logger = Logger.getLogger(TopicController.class);
    @Resource
    private ForumService forumService;
    @Resource
    private TopicService topicService;
    @Resource
    private ReplyService replyService;
    @RequestMapping(value = "/addTopic", method = RequestMethod.POST)
    @ResponseBody
    public Map addTopic(String forum_id, String topic_content, String topic_title, HttpServletRequest request) {
        logger.info("forum_id:" + forum_id);
        logger.info("topic_content:" + topic_content);
        logger.info("topic_title:" + topic_title);

        Map resultMap = new HashMap();
        if (StringUtils.isEmpty(forum_id)) {
            resultMap.put("resultCode", 1);
            resultMap.put("resultMessage", "必须选择板块!");
            return resultMap;
        }

        boolean checkFormIdResult = forumService.checkForumId(Integer.parseInt(forum_id));
        if (!checkFormIdResult) {
            resultMap.put("resultCode", 1);
            resultMap.put("resultMessage", "输入板块数据不合法！");
            return resultMap;
        }

        request.getSession(false);
        UserEntity userEntity = (UserEntity) request.getSession().getAttribute("user");

        if (null == userEntity) {
            resultMap.put("resultCode", 1);
            resultMap.put("resultMessage", "登录超时, 请重新登录！");
            return resultMap;
        }

        if (UserConstant.USER_STATUS_LIMIT_REPLY_POST == userEntity.getUser_status() ||
                UserConstant.USER_STATUS_LIMIT_POST == userEntity.getUser_status()) {
            resultMap.put("resultCode", 1);
            resultMap.put("resultMessage", "无此权限！");
            return resultMap;
        }

        Integer user_id = userEntity.getUser_id();
        boolean addTopicResult = topicService.addTopic(topic_title, topic_content, user_id, Integer.parseInt(forum_id));

        if (!addTopicResult) {
            resultMap.put("resultCode", 1);
            resultMap.put("resultMessage", "抱歉, 发表帖子失败, 请稍后重试！");
            return resultMap;
        }

        return resultMap;
    }


    @RequestMapping(value = "/apply/best", method = RequestMethod.POST)
    @ResponseBody
    public Map applyBest(String topic_id, HttpServletRequest request) {
        request.getSession(false);
        UserEntity userEntity = (UserEntity) request.getSession().getAttribute("user");

        Map resultMap = new HashMap();
        if (null == userEntity) {
            resultMap.put("resultCode", 1);
            resultMap.put("resultMessage", "登录超时, 请重新登录！");
            return resultMap;
        }

        if (StringUtils.isEmpty(topic_id)) {
            resultMap.put("resultCode", 1);
            resultMap.put("resultMessage", "不合法的请求！");
            return resultMap;
        }

        boolean applyResult = topicService.topicApplyBest(Integer.parseInt(topic_id));

        if (!applyResult) {
            resultMap.put("resultCode", 1);
            resultMap.put("resultMessage", "申请失败, 请稍后再试！");
            return resultMap;
        }

        return resultMap;
    }

    @RequestMapping("/{topic_id}")
    public String topicDetail(@PathVariable String topic_id,
                              String type, String currPage, String pageSize,
                              HttpServletRequest request) {

        if (StringUtils.isEmpty(topic_id)) {
            PointUtil.initToPoint(request,
                    "查找的资源不存在!", PointConstant.POINT_ICO_ERROR, "返回主页", "index");
            return "point/point";
        }

        if (StringUtils.isEmpty(currPage)) currPage = "1";
        if (StringUtils.isEmpty(pageSize)) pageSize = "7";

        Page<TopicVo> page = topicService.queryTopicById(Integer.parseInt(topic_id),
                Integer.parseInt(currPage), Integer.parseInt(pageSize));

        request.setAttribute("topic_id", topic_id);
        request.setAttribute("page", page);
        return "topic/topic_detail";
    }

    @RequestMapping(value = "/apply/best/update", method = RequestMethod.POST)
    @ResponseBody
    public Map updateApplyBest(String topic_id, HttpServletRequest request, String type) {
        request.getSession(false);
        UserEntity userEntity = (UserEntity) request.getSession().getAttribute("user");

        Map resultMap = new HashMap();
        if (null == userEntity) {
            resultMap.put("resultCode", 1);
            resultMap.put("resultMessage", "登录超时, 请重新登录！");
            return resultMap;
        } else if (userEntity.getUser_type() != 2) {
            resultMap.put("resultCode", 1);
            resultMap.put("resultMessage", "权限不够!");
            return resultMap;
        }

        if (StringUtils.isEmpty(topic_id) || StringUtils.isEmpty(type)) {
            resultMap.put("resultCode", 1);
            resultMap.put("resultMessage", "不合法的请求！");
            return resultMap;
        }

        boolean applyResult = false;
        if ("agree".equals(type)) {
            applyResult = topicService.agreeTopicApplyBest(Integer.parseInt(topic_id));
        } else if ("reject".equals(type)) {
            applyResult = topicService.rejectTopicApplyBest(Integer.parseInt(topic_id));
        }

        if (!applyResult) {
            resultMap.put("resultCode", 1);
            resultMap.put("resultMessage", "操作失败, 请稍后再试！");
            return resultMap;
        }

        return resultMap;
    }

    @RequestMapping("/topic/search")
    public String topicSearch(HttpServletRequest request,
                              String type,
                              String keywords,
                              String currPage,
                              String pageSize,
                              String forum_id) {
        logger.info("type:" + type);
        logger.info("keywords:" + keywords);
        if (keywords == null) keywords = "";
        if (StringUtils.isEmpty(currPage)) currPage = "1";
        if (StringUtils.isEmpty(pageSize)) pageSize = "7";

        Page<SimpleTopicVo> page = null;

        if (StringUtils.isEmpty(type) || TopicConstant.TOPIC_SEARCH_ALL.equals(type)) {
            page = topicService.querySimpleTopicAll(Integer.parseInt(currPage), Integer.parseInt(pageSize));
        }

        if (TopicConstant.TOPIC_SEARCH_FORUM.equals(type)) {
            if (!StringUtils.isEmpty(forum_id)) {
                page = topicService.querySimpleTopicByForum(Integer.parseInt(forum_id),
                        Integer.parseInt(currPage), Integer.parseInt(pageSize));
            }
        }

        if (TopicConstant.TOPIC_SEARCH_BEST.equals(type)) {
            page = topicService.queryBestTopic(Integer.parseInt(currPage), Integer.parseInt(pageSize));
        }

        if (TopicConstant.TOPIC_SEARCH_KEYWORDS.equals(type)) {
            page = topicService.querySimpleTopicByTitle(keywords, Integer.parseInt(currPage), Integer.parseInt(pageSize));
        }

        if (null == page) {
            PointUtil.initToPoint(request,
                    "查找的资源不存在!", PointConstant.POINT_ICO_ERROR, "返回主页", "index");
            return "point/point";
        }

        request.setAttribute("page", page);
        request.setAttribute("keywords", keywords);
        request.setAttribute("forum_id", forum_id);
        request.setAttribute("type", type);
        return "topic/topic_search";
    }

    @RequestMapping("/addReply")
    @ResponseBody
    public Map<String, String> addReply(HttpServletRequest request,
                                        Integer topic_id,
                                        String reply_content) {
        request.getSession(false);
        UserEntity userEntity = (UserEntity) request.getSession().getAttribute("user");

        Map<String, String> resultMap = new HashMap<>();
        if (null == userEntity) {
            resultMap.put("resultCode", "1");
            resultMap.put("resultMessage", "登录超时, 请重新登录！");
            return resultMap;
        }

        if (UserConstant.USER_STATUS_LIMIT_REPLY_POST == userEntity.getUser_status() ||
                UserConstant.USER_STATUS_LIMIT_REPLY == userEntity.getUser_status()) {
            resultMap.put("resultCode", "1");
            resultMap.put("resultMessage", "无此权限！");
            return resultMap;
        }

        if (null == topic_id) {
            resultMap.put("resultCode", "1");
            resultMap.put("resultMessage", "不合法的请求！");
            return resultMap;
        }

        if (StringUtils.isEmpty(reply_content)) {
            resultMap.put("resultCode", "1");
            resultMap.put("resultMessage", "回复内容不能为空!");
            return resultMap;
        }

        if (reply_content.length() < 5) {
            resultMap.put("resultCode", "1");
            resultMap.put("resultMessage", "回复内容至少为 5 字节!");
            return resultMap;
        }

        boolean addReplyResult = replyService.addReply(topic_id, reply_content, userEntity.getUser_id());
        if (!addReplyResult) {
            resultMap.put("resultCode", "1");
            resultMap.put("resultMessage", "回复失败, 请稍后重试!");
            return resultMap;
        }

        return resultMap;
    }
}
