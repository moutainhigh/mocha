# ************************************************************
# Sequel Pro SQL dump
# Version 4541
#
# http://www.sequelpro.com/
# https://github.com/sequelpro/sequelpro
#
# Host: 39.105.44.178 (MySQL 5.7.22)
# Database: ark
# Generation Time: 2018-09-03 12:45:55 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table a_order
# ------------------------------------------------------------

DROP TABLE IF EXISTS `a_order`;

CREATE TABLE `a_order` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(200) NOT NULL DEFAULT '' COMMENT '用户ID',
  `tid` varchar(200) NOT NULL DEFAULT '' COMMENT '导入的订单ID',
  `user_nickname` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '用户昵称',
  `receiver_name` varchar(200) NOT NULL DEFAULT '' COMMENT '收货人名称',
  `receiver_mobile` varchar(100) NOT NULL DEFAULT '' COMMENT '收货人手机号',
  `product_name` varchar(200) NOT NULL DEFAULT '' COMMENT '商品名称',
  `product_sku` varchar(100) DEFAULT '' COMMENT '商品SKU',
  `product_price` bigint(20) NOT NULL COMMENT '商品价格，单位为分',
  `payment` bigint(20) NOT NULL COMMENT '实际支付金额，单位为分',
  `created` datetime NOT NULL COMMENT '订单创建时间',
  `pay_time` datetime DEFAULT NULL COMMENT '付款时间',
  `receiver_address` varchar(500) NOT NULL DEFAULT '' COMMENT '收货地址',
  `shipping_type` varchar(50) NOT NULL DEFAULT '' COMMENT '配送',
  `buyer_msg` varchar(1000) DEFAULT NULL COMMENT '买方备注信息',
  `trade_msg` varchar(1000) DEFAULT NULL COMMENT '卖方备注信息',
  `youzan_status` varchar(50) NOT NULL DEFAULT '' COMMENT '有赞的订单状态;主订单状态 WAIT_BUYER_PAY （等待买家付款）； WAIT_CONFIRM（待确认，包含待成团、待接单等等。即：买家已付款，等待成团或等待接单）； WAIT_SELLER_SEND_GOODS（等待卖家发货，即：买家已付款）； WAIT_BUYER_CONFIRM_GOODS (等待买家确认收货，即：卖家已发货) ； TRADE_SUCCESS,TRADE_BUYER_SIGNED（买家已签收以及订单成功）； TRADE_CLOSED（交易关闭）；TRADE_CLOSED_BY_USER (买家退款)',
  `order_valid_status` int(255) NOT NULL DEFAULT '1' COMMENT '主订单有效状态;有效、无效（订单与续费订单总天数完成后未续费则变成无效,续费订单无状态）：有效，2：无效  默认：有效',
  `renew_order_parent_id` bigint(255) DEFAULT '0' COMMENT '续费订单的父订单id，如果不是续费订单则为0',
  `order_type` int(255) DEFAULT NULL COMMENT '订单类型：1：新购订单，2：续费订单',
  `order_period_type` int(11) DEFAULT NULL COMMENT '订单周期类型，1、按月，2、按日',
  `update_date` datetime DEFAULT NULL COMMENT '修改订单时间',
  `order_start_send_date` datetime DEFAULT NULL COMMENT '订单开始配送时间',
  `initial_order_day` int(255) DEFAULT NULL COMMENT '初始下单的天数',
  `renew_later_day` int(255) DEFAULT NULL COMMENT '续费后总天数（初始下单天数+续费天数，续费订单此字段为0）',
  `item_count` int(11) DEFAULT '0',
  `admin_msg` varchar(1000) DEFAULT NULL COMMENT '管理后台备注信息',
  `last_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;



# Dump of table coupon
# ------------------------------------------------------------

DROP TABLE IF EXISTS `coupon`;

CREATE TABLE `coupon` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `code` varchar(50) DEFAULT NULL COMMENT '优惠码',
  `image_path` varchar(200) DEFAULT NULL COMMENT '优惠码海报图片地址',
  `image_md5` varchar(100) DEFAULT NULL COMMENT '优惠码海报图片文件MD5',
  `receiver_name` varchar(200) DEFAULT NULL COMMENT '收货人名称',
  `receiver_mobile` varchar(100) DEFAULT NULL COMMENT '收货人手机号',
  `receiver_address` varchar(500) DEFAULT NULL COMMENT '收货地址',
  `created` datetime DEFAULT NULL COMMENT '创建时间',
  `user_id` varchar(200) DEFAULT NULL COMMENT '用户ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;



# Dump of table export_history
# ------------------------------------------------------------

DROP TABLE IF EXISTS `export_history`;

CREATE TABLE `export_history` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created` datetime DEFAULT NULL,
  `file_name` varchar(100) DEFAULT NULL,
  `file_path` varchar(1000) DEFAULT NULL,
  `file_md5` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;



# Dump of table holiday_info
# ------------------------------------------------------------

DROP TABLE IF EXISTS `holiday_info`;

CREATE TABLE `holiday_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `day_date` datetime DEFAULT NULL COMMENT '日期',
  `holiday` int(11) DEFAULT NULL COMMENT '是否是假期，1 代表 是；2 代表 否',
  `name_desc` varchar(50) DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;



# Dump of table modify_count_history
# ------------------------------------------------------------

DROP TABLE IF EXISTS `modify_count_history`;

CREATE TABLE `modify_count_history` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `order_id` bigint(20) DEFAULT NULL,
  `modify_user` varchar(50) DEFAULT NULL,
  `modify_msg` varchar(50) DEFAULT NULL,
  `modify_time` datetime DEFAULT NULL,
  `modify_count` int(11) DEFAULT NULL,
  `before_count` int(11) DEFAULT NULL,
  `after_count` int(11) DEFAULT NULL,
  `from_type` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;



# Dump of table modify_order_history
# ------------------------------------------------------------

DROP TABLE IF EXISTS `modify_order_history`;

CREATE TABLE `modify_order_history` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `order_id` bigint(20) DEFAULT NULL,
  `modify_user` varchar(50) DEFAULT NULL,
  `modify_from` int(11) DEFAULT NULL,
  `modify_time` datetime DEFAULT NULL,
  `before_order_info` varchar(2000) DEFAULT NULL,
  `after_order_info` varchar(2000) DEFAULT NULL,
  `before_delay_info` varchar(500) DEFAULT NULL,
  `after_delay_info` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;



# Dump of table order_delay
# ------------------------------------------------------------

DROP TABLE IF EXISTS `order_delay`;

CREATE TABLE `order_delay` (
  `delay_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '订单延期id',
  `order_id` bigint(11) NOT NULL COMMENT '原始订单id,只能是初始下单的订单id，续费订单延迟时也是原始订单id',
  `order_delay_date` datetime DEFAULT NULL COMMENT '订单延期的日期，指定的某一天',
  PRIMARY KEY (`delay_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='订单延期';



# Dump of table permission_info
# ------------------------------------------------------------

DROP TABLE IF EXISTS `permission_info`;

CREATE TABLE `permission_info` (
  `permissionid` varchar(60) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '权限id',
  `name` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '权限名称',
  `descritpion` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '介绍',
  `url` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '访问url',
  `roleid` varchar(60) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '角色id',
  `pid` varchar(60) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '父节点id',
  `createbyid` varchar(60) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '创建人',
  `lastmodifybyid` varchar(60) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '最后修改人',
  `lastmodifydate` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `createdate` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`permissionid`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC;



# Dump of table product_catalog
# ------------------------------------------------------------

DROP TABLE IF EXISTS `product_catalog`;

CREATE TABLE `product_catalog` (
  `catalogid` varchar(60) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '产品类别id',
  `catalogname` varchar(60) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '产品类别名称',
  `isenable` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '是否启用',
  `orderno` int(2) DEFAULT NULL COMMENT '显示排序',
  `createdate` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `createbyid` varchar(60) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '创建人',
  `lastmodifydate` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `lastmodifybyid` varchar(60) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '最后修改人'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;



# Dump of table role_info
# ------------------------------------------------------------

DROP TABLE IF EXISTS `role_info`;

CREATE TABLE `role_info` (
  `roleid` varchar(60) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '角色id',
  `rolename` varchar(60) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '角色名称',
  `isenable` varchar(60) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '是否启用',
  `createdate` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `createbyid` varchar(60) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '创建人',
  `lastmodifydate` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `lastmodifybyid` varchar(60) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '最后修改人',
  PRIMARY KEY (`roleid`) USING BTREE,
  UNIQUE KEY `rolename_index` (`rolename`) USING BTREE COMMENT '角色名称'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC;



# Dump of table send_msg
# ------------------------------------------------------------

DROP TABLE IF EXISTS `send_msg`;

CREATE TABLE `send_msg` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(200) DEFAULT NULL COMMENT '用户ID',
  `tid` varchar(200) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `mobile` varchar(50) DEFAULT NULL,
  `send_date` datetime DEFAULT NULL COMMENT '消息发送日期',
  `type` int(11) DEFAULT NULL,
  `success` int(11) DEFAULT NULL,
  `error_info` varchar(500) DEFAULT NULL,
  `send_reason` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;



# Dump of table sync_info
# ------------------------------------------------------------

DROP TABLE IF EXISTS `sync_info`;

CREATE TABLE `sync_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created` datetime DEFAULT NULL,
  `last_order_date` datetime DEFAULT NULL,
  `last_order_tid` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;



# Dump of table user_info
# ------------------------------------------------------------

DROP TABLE IF EXISTS `user_info`;

CREATE TABLE `user_info` (
  `userid` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户id',
  `loginname` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '登录账号',
  `nickname` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户名',
  `password` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '密码（md5）',
  `wechatid` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '微信号',
  `wechatheadimg` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '微信头像',
  `openid` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '微信唯一标示',
  `sex` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '性别(男/女)',
  `phone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '电话号码',
  `isenable` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '是否启用（启用/禁用）',
  `region` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '地区',
  `roleid` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '角色id',
  `createdate` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `createbyid` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '创建人',
  `lastmodifybyid` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '最后修改人',
  `lastmodifydate` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `usertype` varchar(20) NOT NULL COMMENT '用户类型(manage/wechat)',
  PRIMARY KEY (`userid`) USING BTREE,
  UNIQUE KEY `loginname_index` (`loginname`) USING BTREE COMMENT '登录账号',
  UNIQUE KEY `openid_index` (`openid`) USING BTREE COMMENT 'openid'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;



# Dump of table zego_live_info
# ------------------------------------------------------------

DROP TABLE IF EXISTS `zego_live_info`;

CREATE TABLE `zego_live_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created` datetime DEFAULT NULL,
  `stream_sid` varchar(100) DEFAULT NULL,
  `rtmp_url` varchar(2000) DEFAULT NULL,
  `hls_url` varchar(2000) DEFAULT NULL,
  `hdl_url` varchar(2000) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;




/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
