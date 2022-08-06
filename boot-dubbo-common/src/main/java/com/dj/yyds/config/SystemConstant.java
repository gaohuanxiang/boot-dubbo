package com.dj.yyds.config;

public class SystemConstant {
	// 37 待审批 38 已拒绝39 已支付 40 待支付
	// 33经理 34 管理员 35 普通用户ONE
	/**
	 * 32 级别
	 */
	public static final Integer BASE_DATA_RANK_ID = 32;
	/**
	 * 36 报销单状态
	 */
	public static final Integer BASE_DATA_STATUS = 36;
	/**
	 * 38 已拒绝
	 */
	public static final Integer BASE_DATA_TB = 38;
	/**
	 * 41 收支项目
	 */
	public static final Integer BASE_DATA_Project = 41;
	/**
	 * 35 普通用户
	 */
	public static final Integer BASE_DATA_CONSUMER_ID = 35;
	/**
	 * 33 经理
	 */
	public static final Integer BASE_DATA_MANAGER_ID = 33;
	/**
	 * one
	 */
	public static final Integer ONE = 1;
	/**
	 * ZERO
	 */
	public static final Integer ZERO = 0;
	/**
	 * 3 分页的 数据 ，每页展示几条数据
	 */
	public static final Integer LIMIT_SIZE = 3;
	/**
	 * 40 待支付
	 *
	 */
	public static final Integer UNPAID = 40;
	/**
	 * 37 待审批
	 *
	 */
	public static final Integer APPROVAL_PENDING = 37;
	/**
	 * 提交报销单
	 */
	public static final String SUBMIT = "提交报销单";
	/**
	 * 经理代提交
	 */
	public static final String TO_SUBMIT = "经理代提交";
	/**
	 * 默认通过
	 */
	public static final String DEFAULT_YES = "默认通过";
	/**
	 * 审核已通过
	 */
	public static final String YES = "审核已通过";
	/**
	 * 审核未通过
	 */
	public static final String NO = "审核未通过";
	/**
	 * 支付报销费用
	 */
	public static final String DEFRAYMENT = "支付报销费用";
	/**
	 * 请填写报销金额
	 */
	public static final String PAY_PRICE = "请填写报销金额";
	/**
	 * 用户名密码等不能为空
	 */
	public static final String NAME_AND_PWD_NOTNULL = "用户名密码等不能为空";
	/**
	 * 用户名重复
	 */
	public static final String REPETITION = "用户名重复";
	/**
	 * 用户名密码错误
	 */
	public static final String ERROR = "用户名密码错误";
	/**
	 * 47 报销单支付方式
	 */
	public static final Integer PAY = 47;
	/**
	 * "F:\\upload\\"
	 * 路劲
	 */
	public static final String URLS = "F:\\upload\\";
	/**
	 * "yyyyMMddHHmmss"
	 * 时间格式
	 */
	public static final String TIMEFORMAT = "yyyyMMddHHmmss";
}
