package vip.doctordeng.bbs.common;

import vip.doctordeng.bbs.pojo.entity.UserEntity;

import javax.servlet.http.HttpServletRequest;

/**
 * Description:
 *
 * @author Doctor邓
 * @since 2017/4/22 10:24
 */
public class RequestUtil {
    public static <T> T getSessionAttribute(final String name, HttpServletRequest request) {
        return (T) request.getSession().getAttribute(name);
    }

    public static UserEntity getUser(HttpServletRequest request) {
        return getSessionAttribute("user", request);
    }
}
