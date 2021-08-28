package vip.doctordeng.bbs.pojo.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Description:
 *
 * @author Doctor邓
 * @since 2017/4/9 18:32
 */
@Data
@NoArgsConstructor
public class SimpleTopicVo {
    private Integer topic_id;
    private String topic_title;
    private Integer forum_id;
    private String forum_name;
    private Integer view_num;
    private Integer reply_num;
    private String publish_time;
    // 帖子类型。0 普通贴。1 精华贴；2 公告贴；
    private Integer topic_type;
    // 帖子申精状态, 0 正在申精， 1 申精被拒绝，2 申精通过,其他没有申精
    private String prop1;

    public static SimpleTopicVo convert(Map map) {
        SimpleTopicVo simpleTopicVo = new SimpleTopicVo();
        if (null != map.get("topic_id")) simpleTopicVo.setTopic_id(Integer.parseInt(map.get("topic_id").toString()));
        if (null != map.get("topic_title"))
            simpleTopicVo.setTopic_title(StringUtils.stripToEmpty(map.get("topic_title").toString()));
        if (null != map.get("forum_id")) simpleTopicVo.setForum_id(Integer.parseInt(map.get("forum_id").toString()));
        if (null != map.get("forum_name")) simpleTopicVo.setForum_name(map.get("forum_name").toString());
        if (null != map.get("view_num")) simpleTopicVo.setView_num(Integer.parseInt(map.get("view_num").toString()));
        if (null != map.get("reply_num")) simpleTopicVo.setReply_num(Integer.parseInt(map.get("reply_num").toString()));
        if (null != map.get("publish_time")) simpleTopicVo.setPublish_time(map.get("publish_time").toString());
        if (null != map.get("topic_type"))
            simpleTopicVo.setTopic_type(Integer.parseInt(map.get("topic_type").toString()));
        if (null != map.get("prop1")) simpleTopicVo.setProp1(map.get("prop1").toString());

        return simpleTopicVo;
    }

    public static List<SimpleTopicVo> covertList(List<Map> maps) {
        List<SimpleTopicVo> simpleTopicVos = new ArrayList<>();
        if (maps == null) return null;

        for (int i = 0, len = maps.size(); i < len; i++) {
            SimpleTopicVo simpleTopicVo = convert(maps.get(i));
            simpleTopicVos.add(simpleTopicVo);
        }

        return simpleTopicVos;
    }
}
