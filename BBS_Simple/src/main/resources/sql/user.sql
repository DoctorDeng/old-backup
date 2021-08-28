/*
Navicat MySQL Data Transfer

Source Server         : 我的MySql
Source Server Version : 50713
Source Host           : 119.29.223.16:3306
Source Database       : bbs

Target Server Type    : MYSQL
Target Server Version : 50713
File Encoding         : 65001

Date: 2017-07-27 21:08:43
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户 id',
  `user_account` varchar(20) NOT NULL COMMENT '用户账号',
  `user_password` varchar(40) NOT NULL COMMENT '用户密码',
  `user_name` varchar(20) NOT NULL COMMENT '用户名称',
  `user_introduction` varchar(100) DEFAULT '' COMMENT '用户个人介绍',
  `user_sex` tinyint(4) DEFAULT '0' COMMENT '用户性别,0 无即未设置；1 男；2 女',
  `user_ico_url` varchar(255) NOT NULL DEFAULT '' COMMENT '用户头像地址',
  `user_email` varchar(20) NOT NULL DEFAULT '' COMMENT '用户邮箱',
  `user_register_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '用户账号注册时间',
  `user_integal` smallint(6) NOT NULL DEFAULT '0' COMMENT '用户积分',
  `user_type` tinyint(4) NOT NULL DEFAULT '1' COMMENT '用户类型。0 新注册未激活账号；1 普通已激活账号用户；2 管理员；',
  `user_status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '用户账号状态。0 正常；1 被删除，账号无效；2 用户无法发帖；3 用户无法回复;4 无法发别和回复',
  `prop1` varchar(255) DEFAULT NULL COMMENT '0 正在申精 1 申精失败 2 申精成功',
  `prop2` varchar(255) DEFAULT NULL,
  `prop3` varchar(255) DEFAULT NULL,
  `prop4` varchar(255) DEFAULT NULL,
  `prop5` varchar(255) DEFAULT NULL,
  `prop6` varchar(255) DEFAULT NULL,
  `prop7` varchar(255) DEFAULT NULL,
  `prop8` varchar(255) DEFAULT NULL,
  `prop9` varchar(255) DEFAULT NULL,
  `prop10` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `UK_user_user_account` (`user_account`) USING BTREE,
  UNIQUE KEY `UK_user_user_email` (`user_email`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', '21232f297a57a5a743894a0e4a801fc3', '管理员', '管理员 ', '1', '', 'admin@qq.com', '2017-05-22 17:20:41', '0', '2', '0', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `user` VALUES ('8', '123456', 'e10adc3949ba59abbe56e057f20f883e', '路人甲2', 'sdfsdfsdf', '2', 'upload/user/ico/ae37f48d-1fd2-47f0-9687-5fccf2c15491.jpg', '123456@qq.com', '2017-05-19 22:09:02', '0', '1', '0', null, null, null, null, null, null, null, null, null, null);
