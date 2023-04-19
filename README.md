# JavaWeb

![image-20230411155107020](README.assets/image-20230411155107020.png)

![image-20230411155130487](README.assets/image-20230411155130487.png)


> 双击public\tlias\nginx-1.22.0-tlias\nginx.exe即可启动前端服务
[api文档](public/api接口文档.md)
sql准备：
```sql
/*
 Navicat Premium Data Transfer

 Source Server         : 127.0.0.1
 Source Server Type    : MySQL
 Source Server Version : 80025
 Source Host           : localhost:3306
 Source Schema         : tlias

 Target Server Type    : MySQL
 Target Server Version : 80025
 File Encoding         : 65001

 Date: 13/04/2023 08:41:43
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for dept
-- ----------------------------
DROP TABLE IF EXISTS `dept`;
CREATE TABLE `dept`  (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `name` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '部门名称',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `name`(`name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '部门表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dept
-- ----------------------------
INSERT INTO `dept` VALUES (1, '学工部', '2023-03-24 11:32:40', '2023-03-24 11:32:40');
INSERT INTO `dept` VALUES (2, '教研部', '2023-03-24 11:32:40', '2023-03-24 11:32:40');
INSERT INTO `dept` VALUES (3, '咨询部', '2023-03-24 11:32:40', '2023-03-24 11:32:40');
INSERT INTO `dept` VALUES (6, '就业部', '2023-03-24 15:55:30', '2023-03-24 15:55:30');
INSERT INTO `dept` VALUES (8, '销售部', '2023-03-24 15:58:47', '2023-03-24 15:58:47');
INSERT INTO `dept` VALUES (11, '人事部', '2023-04-10 15:11:49', '2023-04-10 15:11:49');

-- ----------------------------
-- Table structure for emp
-- ----------------------------
DROP TABLE IF EXISTS `emp`;
CREATE TABLE `emp`  (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `username` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户名',
  `password` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '123456' COMMENT '密码',
  `name` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '姓名',
  `gender` tinyint UNSIGNED NOT NULL COMMENT '性别, 说明: 1 男, 2 女',
  `image` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '图像',
  `job` tinyint UNSIGNED NULL DEFAULT NULL COMMENT '职位, 说明: 1 班主任,2 讲师, 3 学工主管, 4 教研主管, 5 咨询师',
  `entrydate` date NULL DEFAULT NULL COMMENT '入职时间',
  `dept_id` int UNSIGNED NULL DEFAULT NULL COMMENT '部门ID',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `username`(`username`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 23 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '员工表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of emp
-- ----------------------------
INSERT INTO `emp` VALUES (1, 'jinyong', '123456', '金庸', 1, '1.jpg', 4, '2000-01-01', 2, '2023-03-24 11:32:41', '2023-03-24 11:32:41');
INSERT INTO `emp` VALUES (2, 'zhangwuji', '123456', '张无忌', 1, '2.jpg', 2, '2015-01-01', 2, '2023-03-24 11:32:41', '2023-03-24 11:32:41');
INSERT INTO `emp` VALUES (3, 'yangxiao', '123456', '杨逍', 1, '3.jpg', 2, '2008-05-01', 2, '2023-03-24 11:32:41', '2023-03-24 11:32:41');
INSERT INTO `emp` VALUES (4, 'weiyixiao', '123456', '韦一笑', 1, '4.jpg', 2, '2007-01-01', 2, '2023-03-24 11:32:41', '2023-03-24 11:32:41');
INSERT INTO `emp` VALUES (5, 'changyuchun', '123456', '常遇春', 1, '5.jpg', 2, '2012-12-05', 2, '2023-03-24 11:32:41', '2023-03-24 11:32:41');
INSERT INTO `emp` VALUES (6, 'xiaozhao', '123456', '小昭', 2, '6.jpg', 3, '2013-09-05', 1, '2023-03-24 11:32:41', '2023-03-24 11:32:41');
INSERT INTO `emp` VALUES (7, 'jixiaofu', '123456', '纪晓芙', 2, '7.jpg', 1, '2005-08-01', 1, '2023-03-24 11:32:41', '2023-03-24 11:32:41');
INSERT INTO `emp` VALUES (8, 'zhouzhiruo', '123456', '周芷若', 2, '8.jpg', 1, '2014-11-09', 1, '2023-03-24 11:32:41', '2023-03-24 11:32:41');
INSERT INTO `emp` VALUES (9, 'dingminjun', '123456', '丁敏君', 2, '9.jpg', 1, '2011-03-11', 1, '2023-03-24 11:32:41', '2023-03-24 11:32:41');
INSERT INTO `emp` VALUES (10, 'zhaomin', '123456', '赵敏', 2, '10.jpg', 1, '2013-09-05', 1, '2023-03-24 11:32:41', '2023-03-24 11:32:41');
INSERT INTO `emp` VALUES (11, 'luzhangke', '123456', '鹿杖客', 1, '11.jpg', 5, '2007-02-01', 3, '2023-03-24 11:32:41', '2023-03-24 11:32:41');
INSERT INTO `emp` VALUES (12, 'hebiweng', '123456', '鹤笔翁', 1, '12.jpg', 5, '2008-08-18', 3, '2023-03-24 11:32:41', '2023-03-24 11:32:41');
INSERT INTO `emp` VALUES (13, 'fangdongbai', '123456', '方东白', 1, '13.jpg', 5, '2012-11-01', 3, '2023-03-24 11:32:41', '2023-03-24 11:32:41');
INSERT INTO `emp` VALUES (14, 'zhangsanfeng', '123456', '张三丰', 1, '14.jpg', 2, '2002-08-01', 2, '2023-03-24 11:32:41', '2023-03-24 11:32:41');
INSERT INTO `emp` VALUES (18, 'linpingzhi', '123456', '林平之', 1, 'https://web-framew', 1, '2022-09-18', 1, '2023-04-06 11:46:18', '2023-04-06 11:46:18');
INSERT INTO `emp` VALUES (21, 'linpingzhiee1', '123456', '林平之ee1', 1, 'https://web-framew', 1, '2022-09-18', 1, '2023-04-06 11:49:51', '2023-04-06 16:30:53');
INSERT INTO `emp` VALUES (22, 'chenyouliang3', '123456', '陈友来3', 1, '', 1, '2023-04-05', 1, '2023-04-06 11:53:30', '2023-04-06 16:28:57');
INSERT INTO `emp` VALUES (23, 'zhao', '123456', '赵晓兰', 2, '', 2, '2023-04-11', 6, '2023-04-12 11:37:18', '2023-04-12 11:37:18');

-- ----------------------------
-- Table structure for operate_log
-- ----------------------------
DROP TABLE IF EXISTS `operate_log`;
CREATE TABLE `operate_log`  (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `operate_user` int UNSIGNED NULL DEFAULT NULL COMMENT '操作人ID',
  `operate_time` datetime NULL DEFAULT NULL COMMENT '操作时间',
  `class_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '操作的类名',
  `method_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '操作的方法名',
  `method_params` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '方法参数',
  `return_value` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '返回值',
  `cost_time` bigint NULL DEFAULT NULL COMMENT '方法执行耗时, 单位:ms',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '操作日志表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of operate_log
-- ----------------------------
INSERT INTO `operate_log` VALUES (1, 1, '2023-04-10 15:11:49', 'com.flowerchar.tliaswebmanagement.controller.DeptController', 'add', '[Dept(id=null, name=人事部, createTime=null, updateTime=null)]', '{\"code\":1,\"msg\":\"success\"}', 15);
INSERT INTO `operate_log` VALUES (2, 1, '2023-04-12 11:37:18', 'com.flowerchar.tliaswebmanagement.controller.EmpController', 'save', '[Emp(id=null, username=zhao, password=null, name=赵晓兰, gender=2, image=, job=2, entrydate=2023-04-11, deptId=6, createTime=null, updateTime=null)]', '{\"code\":1,\"msg\":\"success\"}', 74);

SET FOREIGN_KEY_CHECKS = 1;

```

