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

 Date: 03/06/2023 21:11:17
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
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of table_admin
-- ----------------------------
INSERT INTO `table_admin` VALUES (1, 'timer', '123546', '袁兴龙');

-- ----------------------------
-- Table structure for table_class
-- ----------------------------
DROP TABLE IF EXISTS `table_class`;
CREATE TABLE `table_class`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '考场号',
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '考场名称',
  `capacity` int NOT NULL COMMENT '考场容量',
  `campus` int NOT NULL COMMENT '所在校区',
  `state` int NOT NULL COMMENT '安排状态',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of table_class
-- ----------------------------
INSERT INTO `table_class` VALUES (1, 'abcd', 89, 1, 0);
INSERT INTO `table_class` VALUES (2, 'bagb', 423, 2, 0);
INSERT INTO `table_class` VALUES (3, '二号实验楼', 100, 1, 0);
INSERT INTO `table_class` VALUES (4, '花津校区2060301', 123, 1, 0);
INSERT INTO `table_class` VALUES (5, '花津校区2060302', 123, 1, 0);
INSERT INTO `table_class` VALUES (6, '花津校区2060404', 123, 1, 0);
INSERT INTO `table_class` VALUES (7, 'abadf', 123123, 3, 0);
INSERT INTO `table_class` VALUES (8, 'fqfw', 120, 2, 0);
INSERT INTO `table_class` VALUES (9, '1qwd', 200, 2, 0);
INSERT INTO `table_class` VALUES (10, 'fcq', 2001, 2, 0);
INSERT INTO `table_class` VALUES (11, 'asd', 200, 1, 0);

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
  `teachername` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '教师姓名',
  `stuid` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '学号',
  `testid` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '考场批号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

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
) ENGINE = InnoDB AUTO_INCREMENT = 85 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of table_stuinfo
-- ----------------------------
INSERT INTO `table_stuinfo` VALUES (1, 20112001262, 'xsz', '软件工程', ' pinf', 1234567891, '理工科', 1, 0);
INSERT INTO `table_stuinfo` VALUES (2, 18110904051, '朱先坡', '英语（非师范）', '王杨', 0057110140, '理工类', 2, 0);
INSERT INTO `table_stuinfo` VALUES (3, 18111003036, '张瑞', '运动训练', '赵诚', 0057110140, '理工类', 2, 0);
INSERT INTO `table_stuinfo` VALUES (4, 19110101373, '韦柳娜', '戏剧影视文学', '杨杨', 0057110140, '理工类', 2, 0);
INSERT INTO `table_stuinfo` VALUES (5, 19110402026, '屈琦', '物流管理', '王正东', 0057110140, '理工类', 2, 0);
INSERT INTO `table_stuinfo` VALUES (6, 19110601027, '任昊', '雕塑', '徐辰晨', 0057110140, '理工类', 2, 0);
INSERT INTO `table_stuinfo` VALUES (7, 19110601055, '周齐英', '绘画', '徐辰晨', 0057110140, '理工类', 2, 0);
INSERT INTO `table_stuinfo` VALUES (8, 19110602014, '方远', '产品设计', '王正东', 0057110140, '理工类', 2, 0);
INSERT INTO `table_stuinfo` VALUES (9, 19110602033, '刘晴', '工艺美术', '徐辰晨', 0057110140, '理工类', 2, 0);
INSERT INTO `table_stuinfo` VALUES (10, 19111003006, '郭悦梅', '运动训练', '周文', 0057110140, '理工类', 2, 0);
INSERT INTO `table_stuinfo` VALUES (11, 19111003049, '刘宇轩', '运动训练', '周文', 0057110140, '理工类', 2, 0);
INSERT INTO `table_stuinfo` VALUES (12, 20110301163, '石婉妤', '法学', '朱皖宁', 0057110140, '理工类', 3, 0);
INSERT INTO `table_stuinfo` VALUES (13, 21110102091, '李承懿', '中国语言文学类', '倪天娇', 0057110140, '理工类', 3, 0);
INSERT INTO `table_stuinfo` VALUES (14, 21110401158, '潘显慧', '人力资源管理', '陶涛', 0057110140, '理工类', 3, 0);
INSERT INTO `table_stuinfo` VALUES (15, 22110101001, '孙启明', '汉语言文学', '郑明', 0057110140, '理工类', 3, 0);
INSERT INTO `table_stuinfo` VALUES (16, 22110101002, '钱文曦', '汉语言文学', '郑明', 0057110140, '理工类', 3, 0);
INSERT INTO `table_stuinfo` VALUES (17, 22110101003, '魏馨', '汉语言文学', '郑明', 0057110140, '理工类', 3, 0);
INSERT INTO `table_stuinfo` VALUES (18, 22110101004, '姚欣然', '汉语言文学', '郑明', 0057110140, '理工类', 3, 0);
INSERT INTO `table_stuinfo` VALUES (19, 22110101005, '冯玲莉', '汉语言文学', '郑明', 0057110140, '理工类', 3, 0);
INSERT INTO `table_stuinfo` VALUES (20, 22110101006, '王茹瑾', '汉语言文学', '郑明', 0057110140, '理工类', 3, 0);
INSERT INTO `table_stuinfo` VALUES (21, 22110101007, '陈丽', '汉语言文学', '郑明', 0057110140, '理工类', 3, 0);
INSERT INTO `table_stuinfo` VALUES (22, 18110502001, '卜晓祺', '音乐表演', '腾莉', 0057110140, '理工类', 1, 0);
INSERT INTO `table_stuinfo` VALUES (23, 19110502005, '陈硕', '音乐表演', '丁新涛', 0057110140, '理工类', 1, 0);
INSERT INTO `table_stuinfo` VALUES (24, 19110502010, '黄举', '音乐表演', '丁新涛', 0057110140, '理工类', 1, 0);
INSERT INTO `table_stuinfo` VALUES (25, 19110502011, '黄馨玥', '音乐表演', '丁新涛', 0057110140, '理工类', 1, 0);
INSERT INTO `table_stuinfo` VALUES (26, 19110502019, '孙淼', '音乐表演', '丁新涛', 0057110140, '理工类', 1, 0);
INSERT INTO `table_stuinfo` VALUES (27, 19110502020, '唐连智', '音乐表演', '丁新涛', 0057110140, '理工类', 1, 0);
INSERT INTO `table_stuinfo` VALUES (28, 19110502021, '汪超', '音乐表演', '丁新涛', 0057110140, '理工类', 1, 0);
INSERT INTO `table_stuinfo` VALUES (29, 19110502025, '吴习伟', '音乐表演', '丁新涛', 0057110140, '理工类', 1, 0);
INSERT INTO `table_stuinfo` VALUES (30, 19110502044, '耿浩翔', '音乐表演', '丁新涛', 0057110140, '理工类', 1, 0);
INSERT INTO `table_stuinfo` VALUES (31, 19110503028, '石梓坤', '舞蹈表演', '薛峰', 0057110140, '理工类', 1, 0);
INSERT INTO `table_stuinfo` VALUES (32, 19110503030, '谢慧怡', '舞蹈表演', '薛峰', 0057110140, '理工类', 1, 0);

-- ----------------------------
-- Table structure for table_test
-- ----------------------------
DROP TABLE IF EXISTS `table_test`;
CREATE TABLE `table_test`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `testdate` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `teststart` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of table_test
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
