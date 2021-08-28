package vip.doctordeng.bbs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import vip.doctordeng.bbs.pojo.entity.ForumEntity;
import vip.doctordeng.bbs.pojo.vo.SimpleTopicVo;
import vip.doctordeng.bbs.service.ForumService;
import vip.doctordeng.bbs.service.TopicService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Description:
 *
 * @author Doctor邓
 * @since 2017/4/15 10:08
 */
@Controller
public class MainController {
    @Resource
    private ForumService forumService;
    @Resource
    private TopicService topicService;
    @RequestMapping("/index")
    public String index(HttpServletRequest request){
        List<ForumEntity> forums = forumService.queryAllForum();
        List<SimpleTopicVo> notices = topicService.queryAllNotice();
        List<SimpleTopicVo> bests = topicService.queryNewBestSimpleTopic();
        List<SimpleTopicVo> news  = topicService.queryNewSimpleTopic();

        request.setAttribute("topics_new", news);
        request.setAttribute("topics_best", bests);
        request.setAttribute("forums", forums);
        request.setAttribute("notices", notices);
        return "index";
    }
}
