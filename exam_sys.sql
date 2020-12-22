/*
Navicat MySQL Data Transfer

Source Server         : exam_sys
Source Server Version : 50730
Source Host           : localhost:3306
Source Database       : exam_sys

Target Server Type    : MYSQL
Target Server Version : 50730
File Encoding         : 65001

Date: 2020-12-20 17:43:25
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `info`
-- ----------------------------
DROP TABLE IF EXISTS `info`;
CREATE TABLE `info` (
  `message` varchar(255) NOT NULL,
  `time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of info
-- ----------------------------
INSERT INTO `info` VALUES ('哈哈', '2020-12-19 22:10:11');
INSERT INTO `info` VALUES ('adadaf', '2020-12-19 22:18:23');

-- ----------------------------
-- Table structure for `t_admin`
-- ----------------------------
DROP TABLE IF EXISTS `t_admin`;
CREATE TABLE `t_admin` (
  `username` char(10) NOT NULL,
  `password` char(40) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of t_admin
-- ----------------------------
INSERT INTO `t_admin` VALUES ('admin', '21232f297a57a5a743894ae4a801fc3');

-- ----------------------------
-- Table structure for `t_exam`
-- ----------------------------
DROP TABLE IF EXISTS `t_exam`;
CREATE TABLE `t_exam` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` char(20) CHARACTER SET utf8 NOT NULL,
  `starttime` datetime NOT NULL,
  `autostart` tinyint(1) NOT NULL,
  `exampaper` tinyint(1) DEFAULT '0',
  `started` tinyint(1) NOT NULL DEFAULT '0',
  `finished` tinyint(1) NOT NULL DEFAULT '0',
  `archived` tinyint(1) NOT NULL DEFAULT '0',
  `cleaned` tinyint(1) NOT NULL DEFAULT '0',
  `teacher` varchar(10) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`) USING BTREE,
  KEY `exam_owner` (`teacher`),
  CONSTRAINT `exam_owner` FOREIGN KEY (`teacher`) REFERENCES `t_teacher` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of t_exam
-- ----------------------------
INSERT INTO `t_exam` VALUES ('3', 'fff', '2020-12-06 11:11:11', '0', '0', '0', '0', '1', '1', 'aaa');
INSERT INTO `t_exam` VALUES ('4', 'ggg', '2020-12-06 11:11:11', '0', '0', '0', '0', '1', '1', 'ccc');
INSERT INTO `t_exam` VALUES ('5', 'ca', '2020-12-06 11:11:11', '0', '0', '0', '0', '1', '1', 'ccc');
INSERT INTO `t_exam` VALUES ('6', 'vv', '2020-12-06 11:11:11', '0', '0', '0', '0', '1', '1', 'ccc');
INSERT INTO `t_exam` VALUES ('7', 'hh', '2020-12-06 11:11:11', '0', '0', '0', '0', '1', '1', 'ccc');
INSERT INTO `t_exam` VALUES ('8', 'tt', '2020-12-06 11:11:11', '0', '0', '0', '0', '1', '1', 'ccc');
INSERT INTO `t_exam` VALUES ('9', 'q', '2020-12-06 11:11:11', '0', '0', '0', '0', '1', '1', 'ccc');
INSERT INTO `t_exam` VALUES ('10', 'k', '2020-12-05 11:11:11', '0', '0', '0', '0', '1', '1', 'ccc');
INSERT INTO `t_exam` VALUES ('11', 'gaa', '2020-12-04 11:11:11', '0', '0', '1', '0', '0', '0', 'ccc');
INSERT INTO `t_exam` VALUES ('12', 'czc', '2020-12-06 11:11:11', '0', '0', '0', '0', '0', '0', 'ccc');
INSERT INTO `t_exam` VALUES ('13', '你好', '2020-12-12 12:12:12', '0', '0', '0', '0', '0', '0', 'ccc');

-- ----------------------------
-- Table structure for `t_student`
-- ----------------------------
DROP TABLE IF EXISTS `t_student`;
CREATE TABLE `t_student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `number` char(10) CHARACTER SET utf8 NOT NULL,
  `username` char(10) CHARACTER SET utf8 NOT NULL,
  `class` char(10) CHARACTER SET utf8 DEFAULT NULL,
  `ip` char(20) CHARACTER SET utf8 DEFAULT NULL,
  `submittime` datetime DEFAULT NULL,
  `logged` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `名字` (`number`),
  KEY `class_owner` (`class`),
  CONSTRAINT `class_owner` FOREIGN KEY (`class`) REFERENCES `t_exam` (`name`) ON DELETE SET NULL ON UPDATE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=83 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of t_student
-- ----------------------------
INSERT INTO `t_student` VALUES ('72', 'aaaaaa', 'aaa', 'gaa', '0:0:0:0:0:0:0:1', null, '1');
INSERT INTO `t_student` VALUES ('73', 'bbbbb', 'aaa', 'gaa', null, '2020-12-09 12:41:24', '1');
INSERT INTO `t_student` VALUES ('74', 'cccc', 'awf', 'gaa', '0:0:0:0:0:0:0:1', '2020-12-09 15:13:01', '1');
INSERT INTO `t_student` VALUES ('75', 'ddddd', 'awf', 'gaa', '0:0:0:0:0:0:0:1', null, '1');
INSERT INTO `t_student` VALUES ('76', 'dae', 'faw', 'gaa', null, '2020-12-08 23:29:02', '1');
INSERT INTO `t_student` VALUES ('77', 'adadaf', 'awf', 'gaa', '0:0:0:0:0:0:0:1', null, '1');
INSERT INTO `t_student` VALUES ('78', 'afaa', 'awf', 'gaa', null, null, '1');
INSERT INTO `t_student` VALUES ('79', 'fawaaw', 'a', 'gaa', null, null, '0');
INSERT INTO `t_student` VALUES ('80', 'aa', 'aa', null, null, null, '0');
INSERT INTO `t_student` VALUES ('81', 'bb', 'bb', 'czc', null, null, '0');
INSERT INTO `t_student` VALUES ('82', 'f', '哈哈哈', 'czc', null, null, '0');

-- ----------------------------
-- Table structure for `t_teacher`
-- ----------------------------
DROP TABLE IF EXISTS `t_teacher`;
CREATE TABLE `t_teacher` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` char(10) CHARACTER SET utf8 DEFAULT NULL,
  `password` char(40) CHARACTER SET utf8 DEFAULT NULL,
  `fullname` char(10) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of t_teacher
-- ----------------------------
INSERT INTO `t_teacher` VALUES ('1', 'aaa', '9df62e693988eb4e1e1444ece0578579', 'fff');
INSERT INTO `t_teacher` VALUES ('4', 'aaab', '9df62e693988eb4e1e1444ece0578579', 'fff');
INSERT INTO `t_teacher` VALUES ('5', 'aaabb', '9df62e693988eb4e1e1444ece0578579', 'fff');
INSERT INTO `t_teacher` VALUES ('8', 'fawga', '9df62e693988eb4e1e1444ece0578579', 'ggafwa');
INSERT INTO `t_teacher` VALUES ('9', 'ccc', '47bce5c74f589f4867dbd57e9ca9f88', 'daw');
INSERT INTO `t_teacher` VALUES ('10', 'fa', '9df62e693988eb4e1e1444ece0578579', 'fa');
INSERT INTO `t_teacher` VALUES ('12', 'dkh', '9df62e693988eb4e1e1444ece0578579', null);
INSERT INTO `t_teacher` VALUES ('14', 'ff', '9df62e693988eb4e1e1444ece0578579', 'aw');
INSERT INTO `t_teacher` VALUES ('17', 'cca', '5a89924ad353f0f0d5b7bf6ee8e0909b', 'cca');
INSERT INTO `t_teacher` VALUES ('19', 'lrt', '9e3efeadd3f706053b91cb81a4f48c7', 'lrt');
INSERT INTO `t_teacher` VALUES ('20', 'ww', 'ad57484016654da87125db86f4227ea3', 'ww');
INSERT INTO `t_teacher` VALUES ('21', 'www', 'ad57484016654da87125db86f4227ea3', 'ww');
INSERT INTO `t_teacher` VALUES ('22', '', 'd41d8cd98f0b24e980998ecf8427e', '');
INSERT INTO `t_teacher` VALUES ('23', 'fffaw', '47bce5c74f589f4867dbd57e9ca9f88', '??');
INSERT INTO `t_teacher` VALUES ('24', 'wwwf', '4124bca9335c27f86f24ba207a4912', '你好');
