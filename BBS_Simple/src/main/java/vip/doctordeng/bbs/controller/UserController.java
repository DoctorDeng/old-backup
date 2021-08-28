package vip.doctordeng.bbs.controller;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import vip.doctordeng.bbs.common.FileUtil;
import vip.doctordeng.bbs.common.PointUtil;
import vip.doctordeng.bbs.common.RequestUtil;
import vip.doctordeng.bbs.common.constant.PointConstant;
import vip.doctordeng.bbs.common.constant.UserConstant;
import vip.doctordeng.bbs.common.enums.FileTypeEnum;
import vip.doctordeng.bbs.common.page.Page;
import vip.doctordeng.bbs.pojo.entity.ForumEntity;
import vip.doctordeng.bbs.pojo.entity.UserEntity;
import vip.doctordeng.bbs.pojo.vo.SimpleTopicVo;
import vip.doctordeng.bbs.service.ForumService;
import vip.doctordeng.bbs.service.TopicService;
import vip.doctordeng.bbs.service.UserService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description:
 *
 * @author Doctor邓
 * @since 2017/4/9 9:51
 */
@Controller
@RequestMapping("/user")
public class UserController {
    private final String KEY_REGISTER_ERROR = "registerError";
    private Logger logger = Logger.getLogger(UserController.class);
    @Resource
    private UserService userService;
    @Resource
    private ForumService forumService;
    @Resource
    private TopicService topicService;

    @RequestMapping("/login")
    public String login() {
        return "user/user_login";
    }

    @RequestMapping("/doLogin")
    public String doLogin(String user_account, String user_password, HttpServletRequest request) {
        if (StringUtils.isEmpty(user_account)
                || StringUtils.isEmpty(user_password)) {
            request.setAttribute("message_login", "用户名或密码为空!");
            return "user/user_login";
        }

        UserEntity user = userService.getUserByAccountAndPassword(user_account, user_password);
        if (user == null) {
            request.setAttribute("message_login", "用户名或密码错误!");
            return "user/user_login";
        }

        if (UserConstant.USER_STATUS_INVALID == user.getUser_status()) {
            PointUtil.initToPoint(request,
                    "账号已被管理员注销!", PointConstant.POINT_ICO_ERROR, "返回主页", "index");
            return "point/point";
        }

        request.getSession().setAttribute("user", user);
        return "redirect:/index";
    }

    @RequestMapping("/register")
    public String register() {
        return "user/user_register";
    }

    @RequestMapping("/doRegister")
    public ModelAndView doRegister(String user_email, String user_password, String user_confirm_password, String user_account) {
        ModelAndView modelAndView = new ModelAndView();
        if (StringUtils.isEmpty(user_account)
                || StringUtils.isEmpty(user_email)
                || StringUtils.isEmpty(user_password)
                || StringUtils.isEmpty(user_confirm_password)) {
            modelAndView.addObject(KEY_REGISTER_ERROR, "输入信息不完整");
            modelAndView.setViewName("user/user_register");
            return modelAndView;
        }

        if (!user_password.equals(user_confirm_password)) {
            modelAndView.addObject(KEY_REGISTER_ERROR, "两次输入密码不同！");
            modelAndView.setViewName("user/user_register");
            return modelAndView;
        }

        boolean registerResult = userService.registerUser(user_account, user_password, user_email);

        if (!registerResult) {
            modelAndView.addObject(KEY_REGISTER_ERROR, "账号或邮箱已存在！");
            modelAndView.setViewName("user/user_register");
            return modelAndView;
        }
        PointUtil.initToPoint(modelAndView,
                "注册成功", PointConstant.POINT_ICO_SUCCESS, "登录", "user/login");

        modelAndView.setViewName("point/point");
        return modelAndView;
    }

    @RequestMapping("/loginOut")
    public String doLoginOut(HttpServletRequest request) {
        request.getSession().removeAttribute("user");
        return "redirect:/index";
    }

    @RequestMapping("/setting")
    public String userSet(HttpServletRequest request) {
        if (request.getSession().getAttribute("user") == null) return "redirect:/user/login";
        return "user/user_set";
    }

    @RequestMapping(value = "/doSetting", method = RequestMethod.POST)
    public String doUserSet(@RequestParam(value = "user_ico_url", required = false) MultipartFile icoFile,
                            String user_name,
                            String user_sex,
                            String user_introduction,
                            String user_password,
                            HttpServletRequest request) {

        UserEntity userEntity = (UserEntity) request.getSession().getAttribute("user");
        if (null == userEntity) return "redirect:/user/login";

        Map userMap = new HashMap();
        userMap.put("user_id", userEntity.getUser_id());
        userMap.put("user_name", user_name);
        userMap.put("user_introduction", user_introduction);

        if (!StringUtils.isEmpty(user_sex)) {
            userMap.put("user_sex", Integer.parseInt(user_sex));
        }
        if (!StringUtils.isEmpty(user_password)) {
            userMap.put("user_password", user_password);
        }

        boolean uploadResult = true;
        if (null != icoFile) {
            String filePath = "";
            try {
                filePath = FileUtil.uploadFileByMVC(icoFile, request, FileTypeEnum.UserIco);
            } catch (IOException e) {
                logger.info("用户 ID：" + userEntity.getUser_id() + " 上传头像失败");
                uploadResult = false;
            } finally {
                if (!StringUtils.isEmpty(filePath)) {
                    userMap.put("user_ico_url", filePath);
                }
            }
        }

        if (!uploadResult) {
            PointUtil.initToPoint(request,
                    "更改个人信息失败", PointConstant.POINT_ICO_ERROR, "返回", "user/setting");
            return "point/point";
        }

        boolean updateResult = userService.updateUserInfo(userMap);

        if (!updateResult) {
            PointUtil.initToPoint(request,
                    "更改个人信息失败", PointConstant.POINT_ICO_ERROR, "返回", "user/setting");
            return "point/point";
        }

        userEntity.setUser_name(user_name);
        userEntity.setUser_introduction(user_introduction);
        userEntity.setUser_sex(Integer.parseInt(user_sex));
        if (null != userMap.get("user_sex")) {
            userEntity.setUser_sex((Integer) userMap.get("user_sex"));
        }
        if (null != userMap.get("user_ico_url")) {
            userEntity.setUser_ico_url(userMap.get("user_ico_url").toString());
        }
        request.getSession().setAttribute("user", userEntity);
        return "redirect:/user/setting";
    }

    @RequestMapping("/post")
    public String addTopic(HttpServletRequest request) {
        if (RequestUtil.getUser(request) == null) {
            PointUtil.initToPoint(request,
                    "未登录, 请登录!", PointConstant.POINT_ICO_ERROR, "登录", "user/login");
            return "point/point";
        }

        UserEntity userEntity = RequestUtil.getUser(request);
        if (UserConstant.USER_STATUS_LIMIT_REPLY_POST == userEntity.getUser_status() ||
                UserConstant.USER_STATUS_LIMIT_POST == userEntity.getUser_status()) {
            PointUtil.initToPoint(request,
                    "无此权限!", PointConstant.POINT_ICO_ERROR, "返回主页", "index");
            return "point/point";
        }

        List<ForumEntity> forums = forumService.queryAllForum();
        request.setAttribute("forums", forums);
        return "/user/user_post";
    }

    @RequestMapping("/topics")
    public String userTopics(HttpServletRequest request,
                             String currPage,
                             String pageSize) {
        if (request.getSession().getAttribute("user") == null) return "redirect:/user/login";

        if (StringUtils.isEmpty(currPage)) currPage = "1";
        if (StringUtils.isEmpty(pageSize)) pageSize = "10";

        Integer user_id = ((UserEntity) request.getSession().getAttribute("user")).getUser_id();
        Page<SimpleTopicVo> page = topicService.querySimpleTopicByUser(user_id,
                Integer.parseInt(currPage),
                Integer.parseInt(pageSize));

        request.setAttribute("page", page);
        return "user/user_topics";
    }

    @RequestMapping("/records/apply/best")
    public String userApplyBestRecords(HttpServletRequest request,
                                       String currPage,
                                       String pageSize) {
        if (request.getSession().getAttribute("user") == null) return "redirect:/user/login";

        if (StringUtils.isEmpty(currPage)) currPage = "1";
        if (StringUtils.isEmpty(pageSize)) pageSize = "10";

        Integer user_id = ((UserEntity) request.getSession().getAttribute("user")).getUser_id();
        Page<SimpleTopicVo> page = topicService.queryUserApplyBestTopic(user_id,
                Integer.parseInt(currPage),
                Integer.parseInt(pageSize));
        request.setAttribute("page", page);

        return "user/user_applybest_records";
    }
}
