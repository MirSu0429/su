/*
Navicat MySQL Data Transfer

Source Server         : my
Source Server Version : 50725
Source Host           : localhost:3306
Source Database       : leopaard

Target Server Type    : MYSQL
Target Server Version : 50725
File Encoding         : 65001

Date: 2019-05-24 22:04:06
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for lb_register
-- ----------------------------
DROP TABLE IF EXISTS `lb_register`;
CREATE TABLE `lb_register` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `tel` varchar(20) DEFAULT NULL,
  `car_type` varchar(50) DEFAULT NULL,
  `car_number` varchar(10) DEFAULT NULL,
  `shop_id` bigint(20) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `is_come` int(2) DEFAULT '0',
  `come_time` datetime DEFAULT NULL,
  `status` int(2) DEFAULT '1',
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of lb_register
-- ----------------------------
INSERT INTO `lb_register` VALUES ('1', '张三', '213', '背驰', '123123', '1', '2019-05-31 23:12:04', null, '1', '2019-05-23 16:44:30', '0', null);
INSERT INTO `lb_register` VALUES ('2', '李四', '115', '宝马', '1111111', '1', '2019-05-22 22:00:21', null, '1', '2019-05-23 16:44:31', '0', null);
INSERT INTO `lb_register` VALUES ('3', '王五', '110', '阿忠', '125552', '1', '2019-05-22 22:25:54', null, '1', '2019-05-23 16:44:31', '0', null);
INSERT INTO `lb_register` VALUES ('12', 'aaa', '15225107693', 's', '豫A345D2', null, '2019-05-23 05:24:21', null, '1', '2019-05-23 16:44:32', '0', null);
INSERT INTO `lb_register` VALUES ('13', 'WW', '15225107691', 'DASD', '豫DSSDSD', null, '2019-05-23 16:54:54', null, '0', null, '1', null);
INSERT INTO `lb_register` VALUES ('14', 'WW', '15225107691', 'DASD', '豫DSSDSD', null, '2019-05-23 16:54:59', null, '0', null, '1', null);
INSERT INTO `lb_register` VALUES ('15', 'a', '15225107693', 'a', '的aaaaaa', null, '2019-05-23 17:01:56', null, '0', null, '1', null);

-- ----------------------------
-- Table structure for lb_shop
-- ----------------------------
DROP TABLE IF EXISTS `lb_shop`;
CREATE TABLE `lb_shop` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `shop_name` varchar(50) DEFAULT NULL,
  `shop_tel` varchar(20) DEFAULT NULL,
  `shop_address` varchar(200) DEFAULT NULL,
  `shop_manager` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of lb_shop
-- ----------------------------

-- ----------------------------
-- Table structure for sys_job
-- ----------------------------
DROP TABLE IF EXISTS `sys_job`;
CREATE TABLE `sys_job` (
  `id` varchar(100) NOT NULL,
  `job_name` varchar(255) NOT NULL COMMENT '描述任务',
  `cron` varchar(255) NOT NULL COMMENT '任务表达式',
  `status` tinyint(1) NOT NULL COMMENT '状态:0未启动false/1启动true',
  `clazz_path` varchar(255) NOT NULL COMMENT '任务执行方法',
  `job_desc` varchar(255) DEFAULT NULL COMMENT '其他描述',
  `create_by` varchar(255) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_by` varchar(255) DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_job
-- ----------------------------
INSERT INTO `sys_job` VALUES ('55147ebdf2f611e7a4fe201a068c6482', '测试定时demo1', '0/5 * * * * ?', '0', 'com.su.job.HelloJob', '测试定时demo1', 'acfc0e9232f54732a5d9ffe9071bf572', '2018-01-07 12:30:00', 'acfc0e9232f54732a5d9ffe9071bf572', '2019-01-21 08:59:45');
INSERT INTO `sys_job` VALUES ('c8a736817ee04319ad10e8a43fa2ccdc', 'ceshi', '1-2 * * * * ? ', '0', 'com.su.job.HelloJob', null, null, '2019-01-28 06:28:17', null, null);
