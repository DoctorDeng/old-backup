package vip.doctordeng.bbs.pojo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @ClassName:  UserModule   
 * @Description:TODO 用户实体类
 * @author: DoctorDeng
 * @date:   2017年2月27日 下午9:39:59   
 *
 */
@Data
@NoArgsConstructor
public class UserEntity {
	private Integer user_id;
	private String  user_account;
	private String  user_password;
	private String  user_name;
	private String  user_introduction;
	/**
	 * 用户性别,0 无即未设置；1 男；2 女；
	 */
	private Integer user_sex;
	private String  user_ico_url;
	private String  user_email;
	// 用户积分
	private Integer user_integal;
	/**
	 * 用户类型。0 新注册未激活账号；1 普通已激活账号用户；2 管理员；
	 */
	private Integer user_type;
	/**
	 * 用户账号状态。0 正常；1 被删除，账号无效；2 用户无法发帖；3 无法回复；4 无法回复和发帖
	 */
	private Integer user_status;
	private java.sql.Timestamp user_register_time;
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
