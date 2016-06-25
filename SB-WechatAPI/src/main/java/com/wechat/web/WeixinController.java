package com.wechat.web;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.DocumentException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wechat.utils.DataInit;
import com.wechat.utils.HttpUtil;
import com.wechat.utils.SignUtil;
import com.wechat.utils.TodayInHistoryService;
import com.wechat.utils.WeChatUtil;

@RestController
public class WeixinController {

	/**
	 * 接入验证
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		return "hello";
	}

	/**
	 * 接入验证
	 */
	@RequestMapping(value = "/verify", method = RequestMethod.GET)
	public String verify(@RequestParam String signature, @RequestParam String timestamp, @RequestParam String nonce,
			@RequestParam String echostr) {
		System.out.println(signature + "," + timestamp + "," + nonce + "," + "echostr");
		if (SignUtil.checkSignature(signature, timestamp, nonce)) {
			return echostr;
		}
		return null;
	}

	/**
	 * 消息的接收与响应
	 */
	@RequestMapping(value = "/verify", method = RequestMethod.POST)
	public String doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, DocumentException {
		// req.setCharacterEncoding("UTF-8");
		// resp.setCharacterEncoding("UTF-8");
		System.out.println("verify");
		Map<String, String> map = WeChatUtil.xmlToMap(req);
		String fromUserName = map.get("FromUserName");
		String toUserName = map.get("ToUserName");
		String msgType = map.get("MsgType");
		String content = map.get("Content");
		String message = "";

		if (WeChatUtil.MESSAGE_TEXT.equals(msgType)) {
			// TextMessage tm = new TextMessage();
			// tm.setFromUserName(toUserName);
			// tm.setToUserName(fromUserName);
			// tm.setMsgType(msgType);
			// tm.setCreateTime(new Date().getTime());
			// tm.setContent("您发送的消息是:" + content);
			// message = MessageUtil.textMessageToXml(tm);

			// 文本消息
			System.out.println("文本消息" + content);
			if ("1".equals(content)) {
				message = WeChatUtil.initText(toUserName, fromUserName, DataInit.firstMenu());
			} else if ("2".equals(content)) { // 图文消息
				message = WeChatUtil.initNewsMessage(toUserName, fromUserName, DataInit.newsMessageData());
			} else if ("3".equals(content)) { // 图片消息
				message = WeChatUtil.initImageMessage(toUserName, fromUserName, DataInit.ImageinitImageMessageData());
			} else if ("4".equals(content)) {
				message = WeChatUtil.initMusicMessage(toUserName, fromUserName, DataInit.initMusicMessageData());
			} else if ("5".equals(content)) {
				message = WeChatUtil.initText(toUserName, fromUserName, DataInit.threeMenu());
			} else if ("6".equals(content)) {
				message = WeChatUtil.initText(toUserName, fromUserName, TodayInHistoryService.getTodayInHistoryInfo());
			} else if ("?".equals(content) || "？".equals(content)) {
				message = WeChatUtil.initText(toUserName, fromUserName, DataInit.menuText());
			} else if (content.startsWith("翻译")) {
				String word = content.replaceAll("^翻译", "").trim();
				if ("".equals(word)) {
					message = WeChatUtil.initText(toUserName, fromUserName, DataInit.threeMenu());
				} else {
					message = WeChatUtil.initText(toUserName, fromUserName, HttpUtil.translate(word));
				}
			}
		} else if (WeChatUtil.MESSAGE_EVNET.equals(msgType)) {
			String eventType = map.get("Event");
			if (WeChatUtil.MESSAGE_SUBSCRIBE.equals(eventType)) { // 关注事件
				message = WeChatUtil.initText(toUserName, fromUserName, DataInit.menuText());
			} else if (WeChatUtil.MESSAGE_CLICK.equals(eventType)) { // 点击事件
				message = WeChatUtil.initText(toUserName, fromUserName, DataInit.menuText());
			} else if (WeChatUtil.MESSAGE_VIEW.equals(eventType)) { // view事件
				String url = map.get("EventKey");
				message = WeChatUtil.initText(toUserName, fromUserName, url);
			} else if (WeChatUtil.MESSAGE_SCANCODE.equals(eventType)) { // 扫码事件
				String key = map.get("EventKey");
				System.out.println("key:" + key);
				message = WeChatUtil.initText(toUserName, fromUserName, key);
			}
		} else if (WeChatUtil.MESSAGE_LOCATION.equals(msgType)) { // 定位事件
			String label = map.get("Label");
			message = WeChatUtil.initText(toUserName, fromUserName, label);
		}
		System.out.println("message:\n" + message);
		return message;
	}
}
