package com.lottery.front.control;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.lottery.model.User;
import com.lottery.service.UserService;
import com.lottery.utils.CurrentUserUtils;
import com.lottery.utils.ServiceException;

@RestController
public class UserLControl {
	private Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private UserService userService;

	/**
	 * find all users
	 */
	@ResponseBody
	@RequestMapping("/list")
	public List<User> findAll() {
		return userService.findAll();
	}

	/**
	 * 登录成功后跳转页面
	 */
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(User user, RedirectAttributes redirect) {
		logger.info("登陆账号:" + user.getAccount() + " 密码:" + user.getPassword());
		try {
			user = userService.login(user);
		} catch (ServiceException e) {
			logger.debug(e.getMessage());
			redirect.addFlashAttribute("err_code", e.getMessage());
			redirect.addFlashAttribute("user", user);
			return "redirect:/login";
		}
		// 放进全局session
		CurrentUserUtils.getInstance().serUser(user);
		return "redirect:user/home";
	}

	// 用户注册
	public void register() {

	}

	// ---------------登陆后功能

	// 账号记录（日期，金额，操作金额，操作后金额，类型）
	public void accountInfo() {

	}

	// 下注记录（参考交易情况）
	// 交易情况：有效投注，奖金收入，盈亏
	// 彩种，期号，类型，号码，投注金额，中奖金额，购买时间，状态
	public void bet() {

	}
}
