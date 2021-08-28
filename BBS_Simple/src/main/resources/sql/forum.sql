/*
Navicat MySQL Data Transfer

Source Server         : 我的MySql
Source Server Version : 50713
Source Host           : 119.29.223.16:3306
Source Database       : bbs

Target Server Type    : MYSQL
Target Server Version : 50713
File Encoding         : 65001

Date: 2017-07-27 21:08:11
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for forum
-- ----------------------------
DROP TABLE IF EXISTS `forum`;
CREATE TABLE `forum` (
  `forum_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '板块主键',
  `forum_name` varchar(20) NOT NULL COMMENT '板块名称',
  `forum_introduction` varchar(100) DEFAULT '' COMMENT '板块介绍',
  `user_id` int(11) DEFAULT NULL COMMENT '板块版主 id ',
  `forum_parent_id` int(11) DEFAULT '0' COMMENT '板块父板块 id',
  `forum_status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '板块状态。0 正常，1 被删除。',
  `prop1` varchar(255) DEFAULT '1' COMMENT '板块类型, 0 系统板块，1 普通板块',
  `prop2` varchar(255) DEFAULT NULL,
  `prop3` varchar(255) DEFAULT NULL,
  `prop4` varchar(255) DEFAULT NULL,
  `prop5` varchar(255) DEFAULT NULL,
  `prop6` varchar(255) DEFAULT NULL,
  `prop7` varchar(255) DEFAULT NULL,
  `prop8` varchar(255) DEFAULT NULL,
  `prop9` varchar(255) DEFAULT NULL,
  `prop10` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`forum_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of forum
-- ----------------------------
INSERT INTO `forum` VALUES ('1', '公告板块', '公告板块', null, null, '0', '0', null, null, null, null, null, null, null, null, null);
INSERT INTO `forum` VALUES ('2', '测试板块二', '测试板块二', null, null, '0', '1', null, null, null, null, null, null, null, null, null);
INSERT INTO `forum` VALUES ('3', '测试板块三', '测试板块三', null, null, '0', '1', null, null, null, null, null, null, null, null, null);
INSERT INTO `forum` VALUES ('4', '测试板块一', '测试板块一', null, null, '0', '1', null, null, null, null, null, null, null, null, null);
INSERT INTO `forum` VALUES ('10', '测试板', '', null, null, '0', '1', null, null, null, null, null, null, null, null, null);
