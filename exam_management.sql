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

 Date: 08/06/2023 22:09:13
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
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of table_admin
-- ----------------------------
INSERT INTO `table_admin` VALUES (1, 'timer', '123546', 'xsz');

-- ----------------------------
-- Table structure for table_class
-- ----------------------------
DROP TABLE IF EXISTS `table_class`;
CREATE TABLE `table_class`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '考场号',
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '考场名称',
  `capacity` int NOT NULL COMMENT '考场容量',
  `campus` int NOT NULL COMMENT '所在校区',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of table_class
-- ----------------------------
INSERT INTO `table_class` VALUES (1, 'abcd', 8900, 1);
INSERT INTO `table_class` VALUES (2, 'bagb', 42300, 2);
INSERT INTO `table_class` VALUES (3, '二号实验楼', 100, 1);
INSERT INTO `table_class` VALUES (4, '花津校区2060301', 123, 1);
INSERT INTO `table_class` VALUES (5, '花津校区2060302', 123, 1);
INSERT INTO `table_class` VALUES (6, '花津校区2060404', 123, 1);
INSERT INTO `table_class` VALUES (7, 'abadf', 123123, 3);
INSERT INTO `table_class` VALUES (8, 'fqfw', 120, 2);
INSERT INTO `table_class` VALUES (9, '1qwd', 200, 2);
INSERT INTO `table_class` VALUES (10, 'fcq', 2001, 2);
INSERT INTO `table_class` VALUES (11, 'asd', 200, 1);

-- ----------------------------
-- Table structure for table_course
-- ----------------------------
DROP TABLE IF EXISTS `table_course`;
CREATE TABLE `table_course`  (
  `courseid` int(10) UNSIGNED ZEROFILL NOT NULL COMMENT '课程代码',
  `coursename` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '课程名称',
  PRIMARY KEY (`courseid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of table_course
-- ----------------------------
INSERT INTO `table_course` VALUES (0007110140, '大学计算机基础');
INSERT INTO `table_course` VALUES (0057110140, '计算机导论');

-- ----------------------------
-- Table structure for table_export
-- ----------------------------
DROP TABLE IF EXISTS `table_export`;
CREATE TABLE `table_export`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '序号',
  `teacher` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '教师姓名',
  `stuid` bigint NOT NULL COMMENT '学号',
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '考场批号',
  `admission` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `course` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `begin` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `end` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `room` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `major` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 39 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

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
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `courseid`(`courseid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16672 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of table_stuinfo
-- ----------------------------

-- ----------------------------
-- Table structure for table_test
-- ----------------------------
DROP TABLE IF EXISTS `table_test`;
CREATE TABLE `table_test`  (
  `testdate` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `teststart` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of table_test
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
