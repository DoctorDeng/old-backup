package vip.doctordeng.bbs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Description: 验证 Controller
 * 包括：验证码生成及验证，邮件验证码发送及验证
 *
 * @author Doctor邓
 * @since 2017/5/18 12:19
 */
@Controller
@RequestMapping("/validate")
public class ValidateController {

    @RequestMapping("/varifyCode.png")
    public String varifyCode(HttpServletRequest request, HttpServletResponse response) {
        return null;
    }
}
