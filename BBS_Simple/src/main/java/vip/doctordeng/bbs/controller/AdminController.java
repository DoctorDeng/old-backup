package vip.doctordeng.bbs.controller;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import vip.doctordeng.bbs.common.FileUtil;
import vip.doctordeng.bbs.common.PointUtil;
import vip.doctordeng.bbs.common.RequestUtil;
import vip.doctordeng.bbs.common.constant.PointConstant;
import vip.doctordeng.bbs.common.enums.FileTypeEnum;
import vip.doctordeng.bbs.pojo.entity.UserEntity;
import vip.doctordeng.bbs.service.UserService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 *
 * @author Doctor邓
 * @since 2017/4/9 9:49
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    private static final Logger logger = Logger.getLogger(AdminController.class);
    @Resource
    private UserService userService;

    @RequestMapping("/setting")
    public String setting(HttpServletRequest request){
        if (RequestUtil.getUser(request) == null) return "redirect:/user/login";

        if (RequestUtil.getUser(request).getUser_type() != 2) {
            PointUtil.initToPoint(request,
                    "权限不足", PointConstant.POINT_ICO_WARNING, "返回主页", "/index");
            return "point/point";
        }
        return "admin/admin_set";
    }

    @RequestMapping(value = "/doSetting", method = RequestMethod.POST)
    public String doUserSet(@RequestParam(value = "user_ico_url", required = false) MultipartFile icoFile,
                            String user_name,
                            String user_sex,
                            String user_introduction,
                            String user_password,
                            HttpServletRequest request) {

        UserEntity userEntity = RequestUtil.getUser(request);
        if (null == userEntity) return "redirect:/user/login";

        if (RequestUtil.getUser(request).getUser_type() != 2) {
            PointUtil.initToPoint(request,
                    "权限不足", PointConstant.POINT_ICO_WARNING, "返回主页", "index");
            return "point/point";
        }

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
                logger.info("管理员 ID：" + userEntity.getUser_id() + " 上传头像失败");
                uploadResult = false;
            } finally {
                if (!StringUtils.isEmpty(filePath)) {
                    userMap.put("user_ico_url", filePath);
                }
            }
        }

        if (!uploadResult) {
            PointUtil.initToPoint(request,
                    "更改个人信息失败", PointConstant.POINT_ICO_ERROR, "返回", "admin/setting");
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
        return "redirect:/admin/setting";
    }

}
