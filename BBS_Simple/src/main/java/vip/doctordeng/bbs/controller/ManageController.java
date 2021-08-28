package vip.doctordeng.bbs.controller;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import vip.doctordeng.bbs.common.PointUtil;
import vip.doctordeng.bbs.common.RequestUtil;
import vip.doctordeng.bbs.common.constant.PointConstant;
import vip.doctordeng.bbs.common.constant.UserConstant;
import vip.doctordeng.bbs.common.page.Page;
import vip.doctordeng.bbs.pojo.entity.ForumEntity;
import vip.doctordeng.bbs.pojo.entity.UserEntity;
import vip.doctordeng.bbs.pojo.vo.SimpleTopicVo;
import vip.doctordeng.bbs.service.ForumService;
import vip.doctordeng.bbs.service.ReplyService;
import vip.doctordeng.bbs.service.TopicService;
import vip.doctordeng.bbs.service.UserService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description:
 *
 * @author Doctor邓
 * @since 2017/4/9 9:49
 */
@Controller
@RequestMapping("/manage")
public class ManageController {
    private final static Logger logger = Logger.getLogger(ManageController.class);
    @Resource
    private ReplyService replyService;
    @Resource
    private UserService userService;
    @Resource
    private ForumService forumService;
    @Resource
    private TopicService topicService;

    @RequestMapping("/apply/best")
    public String applyBest(HttpServletRequest request,
                            String currPage,
                            String pageSize) {
        if (RequestUtil.getUser(request) == null) return "redirect:/user/login";

        if (RequestUtil.getUser(request).getUser_type() != UserConstant.USER_TYPE_ADMIN) {
            PointUtil.initToPoint(request,
                    "权限不足", PointConstant.POINT_ICO_WARNING, "返回主页", "index");
            return "point/point";
        }

        if (StringUtils.isEmpty(currPage)) currPage = "1";
        if (StringUtils.isEmpty(pageSize)) pageSize = "7";

        Integer user_id = ((UserEntity) request.getSession().getAttribute("user")).getUser_id();
        Page<SimpleTopicVo> page = topicService.queryApplyBestTopic(Integer.parseInt(currPage),
                Integer.parseInt(pageSize));
        request.setAttribute("page", page);
        return "manage/manage_applybest";
    }

    @RequestMapping("/addNotice")
    public String addNotice(HttpServletRequest request) {
        if (RequestUtil.getUser(request) == null) return "redirect:/user/login";

        if (RequestUtil.getUser(request).getUser_type() != 2) {
            PointUtil.initToPoint(request,
                    "权限不足", PointConstant.POINT_ICO_WARNING, "返回主页", "index");
            return "point/point";
        }

        return "manage/manage_notice";
    }

    @RequestMapping("/doAddNotice")
    public String doAddNotice(HttpServletRequest request,
                              String topic_title,
                              String topic_content) {
        if (RequestUtil.getUser(request) == null) return "redirect:/user/login";

        if (RequestUtil.getUser(request).getUser_type() != UserConstant.USER_TYPE_ADMIN) {
            PointUtil.initToPoint(request,
                    "权限不足", PointConstant.POINT_ICO_WARNING, "返回主页", "index");
            return "point/point";
        }

        logger.info("title:" + topic_title);
        logger.info("content:" + topic_content);
        if (StringUtils.isEmpty(topic_title) || StringUtils.isEmpty(topic_content)) {
            request.setAttribute("error_add_notice", "标题和内容不能为空!");
            return "manage/manage_notice";
        }

        if (topic_title.length() > 50 || topic_title.length() < 6) {
            request.setAttribute("error_add_notice", "标题长度在 6 ~ 50 字节内!");
            return "manage/manage_notice";
        }

        if (topic_content.length() < 10) {
            request.setAttribute("error_add_notice", "内容至少为 10 字节");
            return "manage/manage_notice";
        }

        UserEntity userEntity = RequestUtil.getUser(request);
        boolean addNoticeResult = topicService.addNotice(topic_title, topic_content, userEntity.getUser_id());

        if (!addNoticeResult) {
            PointUtil.initToPoint(request,
                    "抱歉!操作失败", PointConstant.POINT_ICO_ERROR, "返回", "manage/addNotice");
            return "point/point";
        }

        return "redirect:index";
    }

    @RequestMapping("/user/power")
    public String userPower(HttpServletRequest request,
                            String keywords,
                            String currPage,
                            String pageSize) {
        if (RequestUtil.getUser(request) == null) return "redirect:/user/login";

        if (RequestUtil.getUser(request).getUser_type() != UserConstant.USER_TYPE_ADMIN) {
            PointUtil.initToPoint(request,
                    "权限不足", PointConstant.POINT_ICO_WARNING, "返回主页", "index");
            return "point/point";
        }

        if (keywords == null) keywords = "";
        if (StringUtils.isEmpty(currPage)) currPage = "1";
        if (StringUtils.isEmpty(pageSize)) pageSize = "10";

        Page<UserEntity> page = userService.queryUserByKeywords(keywords,
                Integer.parseInt(currPage),
                Integer.parseInt(pageSize));
        request.setAttribute("page", page);
        request.setAttribute("keywords", keywords);
        return "manage/manage_power";
    }

    @RequestMapping("/user/power/update")
    @ResponseBody
    public Map<String, String> updateUserPower(HttpServletRequest request,
                                               String type,
                                               String user_id) {
        request.getSession(false);
        Map<String, String> resultMap = new HashMap<>();

        UserEntity userEntity = RequestUtil.getUser(request);

        if (null == userEntity) {
            resultMap.put("resultCode", "1");
            resultMap.put("resultMessage", "登录超时, 请重新登录!");
            return resultMap;
        }

        if (userEntity.getUser_type() != UserConstant.USER_TYPE_ADMIN) {
            resultMap.put("resultCode", "1");
            resultMap.put("resultMessage", "权限不足!");
            return resultMap;
        }

        if(!checkUserStatus(type) || StringUtils.isEmpty(user_id)) {
            resultMap.put("resultCode", "1");
            resultMap.put("resultMessage", "无效的请求!");
            return resultMap;
        }

        boolean updateResult = false;
        if(UserConstant.USER_STATUS_NORMAL == Integer.parseInt(type)) {
            updateResult = userService.recoveryUser(Integer.parseInt(user_id));
        } else if (UserConstant.USER_STATUS_LIMIT_POST == Integer.parseInt(type)) {
            updateResult = userService.limitedUserPost(Integer.parseInt(user_id));
        }else if (UserConstant.USER_STATUS_LIMIT_REPLY == Integer.parseInt(type)) {
            updateResult = userService.limitedUserReply(Integer.parseInt(user_id));
        }else if (UserConstant.USER_STATUS_INVALID == Integer.parseInt(type)) {
            updateResult = userService.cancelUser(Integer.parseInt(user_id));
        }else if (UserConstant.USER_STATUS_LIMIT_REPLY_POST == Integer.parseInt(type)) {
            updateResult = userService.limitedUserReplyAndPost(Integer.parseInt(user_id));
        }

        if (!updateResult) {
            resultMap.put("resultCode", "1");
            resultMap.put("resultMessage", "操作失败!");
            return resultMap;
        }
        return resultMap;
    }

    @RequestMapping("/addForum")
    public String addForum(HttpServletRequest request){
        if (RequestUtil.getUser(request) == null) return "redirect:/user/login";

        if (RequestUtil.getUser(request).getUser_type() != UserConstant.USER_TYPE_ADMIN) {
            PointUtil.initToPoint(request,
                    "权限不足", PointConstant.POINT_ICO_WARNING, "返回主页", "index");
            return "point/point";
        }

        List<ForumEntity> forums =  forumService.queryAllForum();

        request.setAttribute("forums", forums);
        return "manage/manage_forum";
    }

    private boolean checkUserStatus(final String user_status) {
        if (StringUtils.isEmpty(user_status)) return false;

        int userStatus = -1;
        try {
            userStatus = Integer.parseInt(user_status);
        } catch (Exception e) {
            return false;
        }

        if (-1 == userStatus) return false;

        if (UserConstant.USER_STATUS_NORMAL == userStatus
                || UserConstant.USER_STATUS_INVALID == userStatus
                || UserConstant.USER_STATUS_LIMIT_POST == userStatus
                || UserConstant.USER_STATUS_LIMIT_REPLY == userStatus
                || UserConstant.USER_STATUS_LIMIT_REPLY_POST == userStatus) return true;

        return false;
    }
}

