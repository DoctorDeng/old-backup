package vip.doctordeng.bbs.pojo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @ClassName:  ReplyModule   
 * @Description:TODO 帖子回复实体类
 * @author: DoctorDeng
 * @date:   2017年2月27日 下午9:39:26   
 *
 */
@Data
@NoArgsConstructor
public class ReplyEntity {
	private Integer reply_id;
	private Integer topic_id;
	private String  reply_content;
	private Integer user_id;
	private Integer reply_user_id;
	private Integer reply_status;
	private java.sql.Timestamp reply_time;
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
