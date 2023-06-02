/*
 Navicat MySQL Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80033
 Source Host           : localhost:3306
 Source Schema         : exam_management

 Target Server Type    : MySQL
 Target Server Version : 80033
 File Encoding         : 65001

 Date: 02/06/2023 12:39:33
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for table_admin
-- ----------------------------
DROP TABLE IF EXISTS `table_admin`;
CREATE TABLE `table_admin`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `password` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of table_admin
-- ----------------------------
INSERT INTO `table_admin` VALUES (1, 'timer', '123546', '袁兴龙');

-- ----------------------------
-- Table structure for table_class
-- ----------------------------
DROP TABLE IF EXISTS `table_class`;
CREATE TABLE `table_class`  (
  `roomid` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '考场号',
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '考场名称',
  `capacity` int NOT NULL COMMENT '考场容量',
  `campus` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '所在校区',
  `state` int NOT NULL COMMENT '安排状态',
  PRIMARY KEY (`roomid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of table_class
-- ----------------------------
INSERT INTO `table_class` VALUES ('20112001262', '二号实验楼', 100, '1', 0);

-- ----------------------------
-- Table structure for table_course
-- ----------------------------
DROP TABLE IF EXISTS `table_course`;
CREATE TABLE `table_course`  (
  `courseid` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '课程代码',
  `coursename` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '课程名称',
  PRIMARY KEY (`courseid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of table_course
-- ----------------------------

-- ----------------------------
-- Table structure for table_export
-- ----------------------------
DROP TABLE IF EXISTS `table_export`;
CREATE TABLE `table_export`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '序号',
  `teachername` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '教师姓名',
  `stuid` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '学号',
  `testid` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '考场批号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of table_export
-- ----------------------------

-- ----------------------------
-- Table structure for table_stuinfo
-- ----------------------------
DROP TABLE IF EXISTS `table_stuinfo`;
CREATE TABLE `table_stuinfo`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `stuid` bigint(11) UNSIGNED ZEROFILL NOT NULL COMMENT '学生学号',
  `sname` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '学生姓名',
  `major` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '学科',
  `teacher` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '老师姓名',
  `courseid` int(10) UNSIGNED ZEROFILL NOT NULL COMMENT '课程代码',
  `subcategory` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '学科类别',
  `campus` int(1) UNSIGNED ZEROFILL NOT NULL COMMENT '校区',
  `state` int(1) UNSIGNED ZEROFILL NOT NULL COMMENT '安排状态',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of table_stuinfo
-- ----------------------------
INSERT INTO `table_stuinfo` VALUES (2, 20112001262, 'xsz', '软件工程', '胡桂银', 0000123456, '理工科', 1, 0);
INSERT INTO `table_stuinfo` VALUES (3, 20112033001, 'Xiaogou', '兽医', '阿萨德', 1223456789, '农学', 1, 0);

-- ----------------------------
-- Table structure for table_test
-- ----------------------------
DROP TABLE IF EXISTS `table_test`;
CREATE TABLE `table_test`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `testdate` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `teststart` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of table_test
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
