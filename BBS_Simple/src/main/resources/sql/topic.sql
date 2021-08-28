/*
Navicat MySQL Data Transfer

Source Server         : 我的MySql
Source Server Version : 50713
Source Host           : 119.29.223.16:3306
Source Database       : bbs

Target Server Type    : MYSQL
Target Server Version : 50713
File Encoding         : 65001

Date: 2017-07-27 21:08:33
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for topic
-- ----------------------------
DROP TABLE IF EXISTS `topic`;
CREATE TABLE `topic` (
  `topic_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '帖子 id',
  `topic_introduction` varchar(150) DEFAULT NULL COMMENT '帖子介绍',
  `topic_title` varchar(150) NOT NULL DEFAULT '' COMMENT '帖子标题',
  `topic_publish_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '帖子发布时间',
  `topic_content` text NOT NULL COMMENT '帖子内容',
  `topic_type` tinyint(4) NOT NULL DEFAULT '0' COMMENT '帖子类型。0 普通贴。1 精华贴；2 公告贴；',
  `topic_view_num` int(11) NOT NULL DEFAULT '0' COMMENT '帖子被查看数',
  `topic_status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '帖子状态。0 正常； 1 被删除。',
  `topic_good_num` int(11) NOT NULL DEFAULT '0' COMMENT '帖子点赞数',
  `user_id` int(11) NOT NULL COMMENT '帖子用户 id',
  `forum_id` int(11) NOT NULL,
  `prop1` varchar(255) DEFAULT NULL COMMENT '帖子申精状态，0 正在申精，1 申精被拒绝，2 申精通过，其他没有申精',
  `prop2` varchar(255) DEFAULT NULL,
  `prop3` varchar(255) DEFAULT NULL,
  `prop4` varchar(255) DEFAULT NULL,
  `prop5` varchar(255) DEFAULT NULL,
  `prop6` varchar(255) DEFAULT NULL,
  `prop7` varchar(255) DEFAULT NULL,
  `prop8` varchar(255) DEFAULT NULL,
  `prop9` varchar(255) DEFAULT NULL,
  `prop10` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`topic_id`),
  KEY `PK_topic_user_id` (`user_id`),
  KEY `PK_topic_forum_id` (`forum_id`),
  CONSTRAINT `PK_topic_forum_id` FOREIGN KEY (`forum_id`) REFERENCES `forum` (`forum_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `PK_topic_user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of topic
-- ----------------------------
INSERT INTO `topic` VALUES ('2', '', '测试发别父', '2017-04-22 10:09:44', '测试发别父', '1', '0', '0', '0', '8', '2', '2', null, null, null, null, null, null, null, null, null);
INSERT INTO `topic` VALUES ('3', '', '测试帖子二', '2017-04-22 10:09:49', '测试帖子二', '1', '0', '0', '0', '8', '3', '2', null, null, null, null, null, null, null, null, null);
INSERT INTO `topic` VALUES ('4', '', '测试帖子三', '2017-04-22 10:09:49', '测试帖子三', '1', '0', '0', '0', '8', '4', '2', null, null, null, null, null, null, null, null, null);
INSERT INTO `topic` VALUES ('5', '', '测试帖子4', '2017-04-22 10:09:50', '测试帖子4', '1', '0', '0', '0', '8', '2', '2', null, null, null, null, null, null, null, null, null);
INSERT INTO `topic` VALUES ('6', '', '测试帖子五', '2017-04-22 10:11:16', '测试帖子五', '1', '0', '0', '0', '8', '2', '2', null, null, null, null, null, null, null, null, null);
INSERT INTO `topic` VALUES ('7', '', '测试帖子6', '2017-04-22 10:17:24', '测试帖子6', '1', '0', '0', '0', '8', '2', '2', null, null, null, null, null, null, null, null, null);
INSERT INTO `topic` VALUES ('8', '', '测试帖子 7 ', '2017-04-21 19:28:12', '测试帖子 7 ', '0', '0', '0', '0', '8', '2', '0', null, null, null, null, null, null, null, null, null);
INSERT INTO `topic` VALUES ('9', '', '测试帖子 8', '2017-04-22 10:17:43', '测试帖子 8', '0', '0', '0', '0', '8', '2', '1', null, null, null, null, null, null, null, null, null);
INSERT INTO `topic` VALUES ('10', '', '测试帖子9', '2017-04-21 19:26:51', '测试帖子9', '0', '0', '0', '0', '8', '3', '0', null, null, null, null, null, null, null, null, null);
INSERT INTO `topic` VALUES ('11', '', '测试帖子10 士大夫卡了 ', '2017-04-21 19:21:46', '测试帖子10 士大夫卡了 ', '0', '0', '0', '0', '8', '2', '0', null, null, null, null, null, null, null, null, null);
INSERT INTO `topic` VALUES ('12', '', '测试帖子 11', '2017-04-22 10:11:31', '测试帖子 11', '0', '0', '0', '0', '8', '2', '1', null, null, null, null, null, null, null, null, null);
INSERT INTO `topic` VALUES ('13', '', '测试士大夫是打发士大夫', '2017-04-21 19:17:28', '测试士大夫是打发士大夫', '0', '0', '0', '0', '8', '2', '0', null, null, null, null, null, null, null, null, null);
INSERT INTO `topic` VALUES ('14', '', '211221', '2017-04-22 13:33:22', '<p>121212121212</p>', '2', '0', '0', '0', '1', '1', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `topic` VALUES ('15', '', '测试发帖23948932', '2017-05-21 16:43:41', '测试发帖23948932', '1', '0', '0', '0', '8', '2', '2', null, null, null, null, null, null, null, null, null);
INSERT INTO `topic` VALUES ('16', '', '测试帖子哈哈哈', '2017-05-21 16:58:44', '测试帖子哈哈哈', '0', '0', '0', '0', '8', '4', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `topic` VALUES ('17', '', '123123123123123', '2017-05-21 17:00:56', '<p><b>asdf</b><img src=\"http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/f2/wg_thumb.gif\"></p><p><u>sdf</u></p><blockquote><p>sdfsdf</p></blockquote><p><font size=\"7\">asd</font></p><p><font size=\"7\">ds</font></p><p><br></p>', '0', '0', '0', '0', '8', '2', null, null, null, null, null, null, null, null, null, null);
