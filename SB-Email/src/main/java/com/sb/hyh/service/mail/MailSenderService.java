package com.sb.hyh.service.mail;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import freemarker.template.Template;
import freemarker.template.TemplateException;

@Service
public class MailSenderService {
	@Value("${spring.mail.from}")
	private String username;
	@Autowired
	public JavaMailSender mailSender;
	@Autowired
	private FreeMarkerConfigurer freeMarkerConfigurer;

	public void sendMail() throws MessagingException {
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		// 设置utf-8或GBK编码,否则邮件会有乱码,true表示为multipart邮件
		MimeMessageHelper message = new MimeMessageHelper(mimeMessage, true, "utf-8");
		message.setFrom(username);
		message.setTo("hongyh@conac.cn");
		// 主题
		message.setSubject("This is the message subject");
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", username);
		// 参数true表示启用html格式
		// 内容
		message.setText(getMailHtml(map, "MailTemplate.ftl"), true);
		mailSender.send(mimeMessage);
	}

	public String getMailHtml(Map<?, ?> map, String templateName) {
		String htmlText = null;
		try {
			Template tpl = freeMarkerConfigurer.getConfiguration().getTemplate(templateName);
			htmlText = FreeMarkerTemplateUtils.processTemplateIntoString(tpl, map);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TemplateException e) {
			e.printStackTrace();
		}
		return htmlText;
	}
}