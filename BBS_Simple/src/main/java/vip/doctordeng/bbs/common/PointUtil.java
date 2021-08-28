package vip.doctordeng.bbs.common;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.ModelAndView;
import vip.doctordeng.bbs.common.constant.PointConstant;

import javax.servlet.http.HttpServletRequest;

/**
 * Description:
 *
 * @author Doctor邓
 * @since 2017/4/18 13:00
 */
public class PointUtil {
    public static void initToPoint(HttpServletRequest request,
                               String point_text,
                               String point_ico,
                               String point_button,
                               String point_url){
        if (StringUtils.isEmpty(point_ico))    point_ico    = PointConstant.POINT_ICO_SUCCESS;
        if (StringUtils.isEmpty(point_button)) point_button = "返回";
        if (StringUtils.isEmpty(point_url))    point_url    = "index";

        request.setAttribute("point_text", point_text);
        request.setAttribute("point_ico", point_ico);
        request.setAttribute("point_button", point_button);
        request.setAttribute("point_url", point_url);

    }

    public static void initToPoint(ModelAndView modelAndView,
                               String point_text,
                               String point_ico,
                               String point_button,
                               String point_url){
        if (StringUtils.isEmpty(point_ico))    point_ico    = PointConstant.POINT_ICO_SUCCESS;
        if (StringUtils.isEmpty(point_button)) point_button = "返回";
        if (StringUtils.isEmpty(point_url))    point_url    = "index";

        modelAndView.addObject("point_text",point_text);
        modelAndView.addObject("point_ico",point_ico);
        modelAndView.addObject("point_button",point_button);
        modelAndView.addObject("point_url",point_url);
    }
}
