package vip.doctordeng.bbs.pojo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @ClassName:  TopicModule   
 * @Description:TODO 帖子实体类
 * @author: DoctorDeng
 * @date:   2017年2月27日 下午9:39:46   
 *
 */
@Data
@NoArgsConstructor
public class TopicEntity {
	private Integer  topic_id;
	private String   topic_introduction;
	private String   topic_title;
	private String   topic_content;
	/**
	 * 帖子类型。
	 * 0：普通贴。1 精华帖。2 公告贴。
	 */
	private Integer  topic_type;
	// 帖子浏览数量。每次浏览都算一次，即使是同一用户
	private Integer  topic_view_num;
	/**
	 * 帖子状态。0 正常； 1 被删除。
	 */
	private Integer  topic_status;
	private Integer  topic_good_num;
	// 帖子所属板块 id
	private Integer  forum_id;
	// 发表帖子用户 id
	private Integer  user_id;
	private java.sql.Timestamp reply_time;
	// 帖子申精状态, 0 正在申精， 1 申精被拒绝，2 申精通过
	private String prop1;
	private String prop2;
	private String prop3;
	private String prop4;
	private String prop5;
	private String prop6;
	private String prop7;
	private String prop8;
	private String prop9;
	private String prop10;
}
