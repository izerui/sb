/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50621
Source Host           : localhost:3306
Source Database       : dead

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2016-06-11 14:16:56
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for catalog
-- ----------------------------
DROP TABLE IF EXISTS `catalog`;
CREATE TABLE `catalog` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(64) DEFAULT NULL,
  `folder` varchar(64) DEFAULT NULL,
  `deep` int(1) unsigned DEFAULT '0',
  `pid` int(11) DEFAULT NULL,
  `pidPath` varchar(255) DEFAULT NULL,
  `sum` int(11) DEFAULT NULL,
  `status` int(1) DEFAULT '0',
  `sort` int(11) DEFAULT '0',
  `createDate` datetime DEFAULT NULL,
  `createBy` varchar(64) DEFAULT NULL,
  `updateDate` datetime DEFAULT NULL,
  `updateBy` varchar(64) DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of catalog
-- ----------------------------
INSERT INTO `catalog` VALUES ('1', '算法', '0', '1', '0', '0', '1', '0', null, '2016-06-05 12:09:39', null, '2016-06-05 12:09:39', null, null);
INSERT INTO `catalog` VALUES ('2', 'Java', '0', '1', '0', '0', '1', '0', null, '2016-06-05 12:09:40', null, '2016-06-05 12:09:40', null, null);
INSERT INTO `catalog` VALUES ('3', 'Android', '2', '2', '2', '2', '0', '0', null, '2016-06-05 12:09:00', null, '2016-06-05 12:09:00', null, null);
INSERT INTO `catalog` VALUES ('4', '网站动态', '2', '2', '2', '2', '0', '0', null, '2016-06-05 12:09:00', null, '2016-06-05 12:09:00', null, null);
INSERT INTO `catalog` VALUES ('5', 'Solr', '2', '2', '2', '2', '0', '0', null, '2016-06-05 12:09:00', null, '2016-06-05 12:09:00', null, null);
INSERT INTO `catalog` VALUES ('6', 'SVN', '2', '2', '2', '2', '0', '0', null, '2016-06-05 12:09:00', null, '2016-06-05 12:09:00', null, null);
INSERT INTO `catalog` VALUES ('7', 'log4j', '2', '2', '2', '2', '0', '0', null, '2016-06-05 12:09:00', null, '2016-06-05 12:09:00', null, null);
INSERT INTO `catalog` VALUES ('8', 'Maven', '2', '2', '2', '2', '0', '0', null, '2016-06-05 12:09:00', null, '2016-06-05 12:09:00', null, null);
INSERT INTO `catalog` VALUES ('9', 'Ant', '2', '2', '2', '2', '0', '0', null, '2016-06-05 12:09:00', null, '2016-06-05 12:09:00', null, null);
INSERT INTO `catalog` VALUES ('10', '贪心', '1', '2', '1', '1', '0', '0', null, '2016-06-05 12:09:00', null, '2016-06-05 12:09:00', null, null);
INSERT INTO `catalog` VALUES ('11', '动态规划', '1', '2', '1', '1', '0', '0', null, '2016-06-05 12:09:00', null, '2016-06-05 12:09:00', null, null);
INSERT INTO `catalog` VALUES ('12', 'JSTL', '2', '2', '2', '2', '0', '0', null, '2016-06-05 12:09:00', null, '2016-06-05 12:09:00', null, null);
INSERT INTO `catalog` VALUES ('13', '搜索', '1', '2', '1', '1', '0', '0', null, '2016-06-05 12:09:00', null, '2016-06-05 12:09:00', null, null);
INSERT INTO `catalog` VALUES ('14', 'Commons', '2', '2', '2', '2', '0', '0', null, '2016-06-05 12:09:00', null, '2016-06-05 12:09:00', null, null);
INSERT INTO `catalog` VALUES ('15', 'jQuery', '10', '3', '10', '10', '0', '0', null, '2016-06-05 12:09:00', null, '2016-06-05 12:09:00', null, null);
INSERT INTO `catalog` VALUES ('16', 'JS', '10', '3', '10', '10', '0', '0', null, '2016-06-05 12:09:00', null, '2016-06-05 12:09:00', null, null);
INSERT INTO `catalog` VALUES ('18', '其他', '10', '3', '10', '10', '0', '0', null, '2016-06-05 12:09:00', null, '2016-06-05 12:09:00', null, null);
INSERT INTO `catalog` VALUES ('19', 'CSS', '10', '3', '10', '10', '0', '0', null, '2016-06-05 12:09:00', null, '2016-06-05 12:09:00', null, null);
INSERT INTO `catalog` VALUES ('20', 'Oracle', '1', '2', '1', '1', '0', '0', null, '2016-06-05 12:09:00', null, '2016-06-05 12:09:00', null, null);
INSERT INTO `catalog` VALUES ('21', 'MongoDB', '1', '2', '1', '1', '0', '0', null, '2016-06-05 12:09:00', null, '2016-06-05 12:09:00', null, null);
INSERT INTO `catalog` VALUES ('22', 'IOS', '21', '3', '21', '21', '0', '0', null, '2016-06-05 12:09:00', null, '2016-06-05 12:09:00', null, null);
INSERT INTO `catalog` VALUES ('23', 'elasticsearch', '20', '3', '20', '20', '0', '0', null, '2016-06-05 12:09:00', null, '2016-06-05 12:09:00', null, null);
INSERT INTO `catalog` VALUES ('24', '大数据', '0', '1', '0', '0', '0', '0', null, '2016-06-05 12:09:00', null, '2016-06-05 12:09:00', null, null);
INSERT INTO `catalog` VALUES ('25', 'IM', '0', '0', '0', '0', '0', '0', '0', '2016-06-05 12:09:00', null, '2016-06-05 12:09:00', null, null);
