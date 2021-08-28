package vip.doctordeng.bbs.pojo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @ClassName:  ForumModule   
 * @Description:TODO 板块实体类
 * @author: DoctorDeng  
 * @date:   2017年2月27日 下午9:37:34   
 *
 */
@Data
@NoArgsConstructor
public class ForumEntity {
	private Integer forum_id;
	private String  forum_name;
	private String  forum_introduction;
	private Integer user_id;
	private Integer forum_parent_id;
	/**
	 * 板块状态: 0 正常。1 被删除；
	 */
	private Integer forum_status;
	private String  prop1;
	private String  prop2;
	private String  prop3;
	private String  prop4;
	private String  prop5;
	private String  prop6;
	private String  prop7;
	private String  prop8;
	private String  prop9;
	private String  prop10;

	public ForumEntity(final Integer forum_parent_id, final String forum_name, final String forum_introduction) {
		this.forum_name = forum_name;
		this.forum_parent_id = forum_parent_id;
		this.forum_introduction = forum_introduction;
	}
}
