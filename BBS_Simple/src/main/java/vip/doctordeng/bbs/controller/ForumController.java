package vip.doctordeng.bbs.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import vip.doctordeng.bbs.common.RequestUtil;
import vip.doctordeng.bbs.common.constant.UserConstant;
import vip.doctordeng.bbs.pojo.entity.UserEntity;
import vip.doctordeng.bbs.result.Error;
import vip.doctordeng.bbs.result.Message;
import vip.doctordeng.bbs.service.ForumService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description:
 *
 * @author Doctor邓
 * @since 2017/4/22 19:57
 */
@Controller
@RequestMapping("/forum")
public class ForumController {
    private final static Logger logger = Logger.getLogger(ForumController.class);
    @Resource
    private ForumService forumService;

    @RequestMapping("/addForum")
    @ResponseBody
    public Map<String, String> addForum(HttpServletRequest request,
                                        String forum_id,
                                        String forum_name,
                                        String forum_introduction) {
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

       /* if (StringUtils.isEmpty(forum_id)) {*/
        Message message = forumService.checkForum(forum_name, null);
        if (message.hasErrors()) {
            List<Error> errors = message.getErrors();
            resultMap.put("resultCode", "1");
            resultMap.put("resultMessage", errors.get(0).getErrorMessage());
            return resultMap;
        }
       /* }*/

        boolean addForumResult = forumService.addForum(forum_name.trim(), forum_introduction,null);

        if (!addForumResult) {
            resultMap.put("resultCode", "1");
            resultMap.put("resultMessage", "添加失败, 请稍后重试!");
            return resultMap;
        }

        return resultMap;
    }
}
