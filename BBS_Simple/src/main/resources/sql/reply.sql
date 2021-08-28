/*
Navicat MySQL Data Transfer

Source Server         : 我的MySql
Source Server Version : 50713
Source Host           : 119.29.223.16:3306
Source Database       : bbs

Target Server Type    : MYSQL
Target Server Version : 50713
File Encoding         : 65001

Date: 2017-07-27 21:08:24
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for reply
-- ----------------------------
DROP TABLE IF EXISTS `reply`;
CREATE TABLE `reply` (
  `reply_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '回复 id',
  `topic_id` int(11) NOT NULL COMMENT '回复帖子 id',
  `reply_content` varchar(1000) NOT NULL COMMENT '回复内容',
  `reply_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '回复时间',
  `user_id` int(11) NOT NULL COMMENT '发表回复的用户 id',
  `reply_user_id` int(11) DEFAULT NULL COMMENT '回复的用户id',
  `relpy_status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '回复状态。0 正常。1 被删除；',
  `prop1` varchar(255) DEFAULT NULL,
  `prop2` varchar(255) DEFAULT NULL,
  `prop3` varchar(255) DEFAULT NULL,
  `prop4` varchar(255) DEFAULT NULL,
  `prop5` varchar(255) DEFAULT NULL,
  `prop6` varchar(255) DEFAULT NULL,
  `prop7` varchar(255) DEFAULT NULL,
  `prop8` varchar(255) DEFAULT NULL,
  `prop9` varchar(255) DEFAULT NULL,
  `prop10` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`reply_id`),
  KEY `PK_reply_reply_user_id` (`reply_user_id`),
  KEY `PK_reply_topic_id` (`topic_id`),
  KEY `PK_reply_user_id` (`user_id`),
  CONSTRAINT `PK_reply_topic_id` FOREIGN KEY (`topic_id`) REFERENCES `topic` (`topic_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `PK_reply_user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of reply
-- ----------------------------
INSERT INTO `reply` VALUES ('1', '9', '<p>sdsdfasdf</p>', '2017-04-24 20:02:19', '1', null, '0', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `reply` VALUES ('2', '9', '<p>sdfsdf</p>', '2017-04-24 20:05:04', '1', null, '0', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `reply` VALUES ('3', '9', '<ol><li>dfgsdfgsdfgsdfgsdfgggggggggggg</li><li>dfgd</li><li>dfg</li></ol>', '2017-04-24 20:09:29', '1', null, '0', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `reply` VALUES ('4', '9', '<ul><li><strong>dfgdfgsdfg</strong></li></ul>', '2017-04-24 20:09:43', '1', null, '0', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `reply` VALUES ('5', '9', '<p>asdfasdf</p>', '2017-04-24 20:11:04', '1', null, '0', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `reply` VALUES ('6', '9', '<p>asdfffffffff</p>', '2017-04-24 20:11:09', '1', null, '0', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `reply` VALUES ('7', '9', '<p>adsfffffffffffffffffff</p>', '2017-04-24 20:11:15', '1', null, '0', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `reply` VALUES ('8', '9', '<p>asdfffffffff</p>', '2017-04-24 20:11:34', '1', null, '0', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `reply` VALUES ('9', '9', '<p>你好</p>', '2017-05-18 15:00:59', '8', null, '0', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `reply` VALUES ('10', '14', '<p>是的</p>', '2017-05-18 15:01:53', '8', null, '0', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `reply` VALUES ('11', '15', '<p>第三方时代时代是的</p>', '2017-05-21 16:42:21', '8', null, '0', null, null, null, null, null, null, null, null, null, null);
