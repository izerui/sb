package com.sb.hyh.persistence.entity;

/**
 * 用于封装restful的结果
 */
public class ResultPojo {
	/**
	 * CODE_SUCCESS
	 */
	public static final String CODE_SUCCESS = "1000";
	/**
	 * CODE_FAILURE
	 */
	public static final String CODE_FAILURE = "2000";
	/**
	 * MSG_SUCCESS
	 */
	public static final String MSG_SUCCESS = "SUCCESS";
	/**
	 * MSG_FAILURE
	 */
	public static final String MSG_FAILURE = "FAIL";

	/**
	 * 校验重复
	 */
	public static final String CODE_CHECK_REPEAT = "1101";
	/**
	 * 邮件绑定（已绑定）
	 */
	public static final String CODE_MAIL_BINDED = "1102";
	/**
	 * 邮件修改成功
	 */
	public static final String CODE_MAIL_RESET = "1103";
	/**
	 * 邮件修改（已修改）
	 */
	public static final String CODE_MAIL_RESETED = "1104";
	/**
	 * 安存证据保全回调接口传过来的id在系统中不存在
	 */
	public static final String CODE_CERT_UPDATE_NOID = "1201";
	/**
	 * 重置密码原密码验证错误
	 */
	public static final String CODE_RESET_PWD_SIGN_FAIL = "2100";
	/**
	 * 修改关键词次数超过上限
	 */
	public static final String CODE_CHECK_KEYWORD_UPDATED_COUNT = "2101";
	/**
	 * 参数为空错误CODE：2001
	 */
	public static final String RET_CODE_PARAM_ERR_2001 = "2001";
	/**
	 * 参数TLD为空错误CODE：2002
	 */
	public static final String RET_CODE_PARAM_ERR_2002 = "2002";
	/**
	 * 参数TLD不存在错误CODE：2003
	 */
	public static final String RET_CODE_PARAM_ERR_2003 = "2003";
	/**
	 * 域名不存在或取得失败：3001
	 */
	public static final String RET_CODE_PARAM_ERR_3001 = "3001";
	/**
	 * 参数为空错误MSG：参数不能为空
	 */
	public static final String RET_MSG_PARAM_ERR_2001 = "参数不能为空";
	/**
	 * 商标持有者不存在CODE：4001
	 */
	public static final int RET_CODE_PARAM_ERR_4001 = 4001;
	/**
	 * 参数为空错误MSG：商标持有者不存在
	 */
	public static final String RET_MSG_PARAM_ERR_4001 = "商标持有者不存在";
	/**
	 * 结果code
	 */
	private String code;
	/**
	 * 消息提示
	 */
	private String msg;
	/**
	 * 真正结果
	 */
	private Object result;

	public ResultPojo() {
	}

	public ResultPojo(String code, String msg, Object result) {
		super();
		this.code = code;
		this.msg = msg;
		this.result = result;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}
}
