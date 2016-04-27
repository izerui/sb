package com.wechat.utils;

import java.io.IOException;
import java.io.InputStream;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.thoughtworks.xstream.XStream;
import com.wechat.po.AccessToken;
import com.wechat.po.Image;
import com.wechat.po.ImageMessage;
import com.wechat.po.Music;
import com.wechat.po.MusicMessage;
import com.wechat.po.News;
import com.wechat.po.NewsMessage;
import com.wechat.po.TextMessage;

import net.sf.json.JSONObject;

/**
 * 消息封装类
 */
public class WeChatUtil {
    /**
     * 文本消息
     */
    public static final String MESSAGE_TEXT = "text";
    /**
     * 图文消息
     */
    public static final String MESSAGE_NEWS = "news";
    /**
     * 图片消息
     */
    public static final String MESSAGE_IMAGE = "image";
    /**
     * 语音消息
     */
    public static final String MESSAGE_VOICE = "voice";
    /**
     * 音乐
     */
    public static final String MESSAGE_MUSIC = "music";
    /**
     * 视频消息
     */
    public static final String MESSAGE_VIDEO = "video";
    /**
     * 链接消息
     */
    public static final String MESSAGE_LINK = "link";
    /**
     * 地理位置消息
     */
    public static final String MESSAGE_LOCATION = "location";
    /**
     * 事件推送
     */
    public static final String MESSAGE_EVNET = "event";
    /**
     * 关注
     */
    public static final String MESSAGE_SUBSCRIBE = "subscribe";
    /**
     * 取消关注
     */
    public static final String MESSAGE_UNSUBSCRIBE = "unsubscribe";
    /**
     * 菜单点击
     */
    public static final String MESSAGE_CLICK = "CLICK";
    /**
     * 菜单点击
     */
    public static final String MESSAGE_VIEW = "VIEW";
    public static final String MESSAGE_SCANCODE = "scancode_push";

    private static final String APPID = "wxaeabb742b5df2951";
    private static final String APPSECRET = "d4624c36b6795d1d99dcf0547af5443d";

    private static final String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
    public static final String UPLOAD_URL = "https://api.weixin.qq.com/cgi-bin/media/upload?access_token=ACCESS_TOKEN&type=TYPE";
    private static final String CREATE_MENU_URL = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";
    private static final String QUERY_MENU_URL = "https://api.weixin.qq.com/cgi-bin/menu/get?access_token=ACCESS_TOKEN";
    private static final String DELETE_MENU_URL = "https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=ACCESS_TOKEN";

    /**
     * xml转为map集合
     */
    public static Map<String, String> xmlToMap(HttpServletRequest request) throws IOException, DocumentException {
        Map<String, String> map = new HashMap<String, String>();
        SAXReader reader = new SAXReader();
        InputStream ins = request.getInputStream();
        Document doc = reader.read(ins);
        Element root = doc.getRootElement();
        List<Element> list = root.elements();
        for (Element e : list) {
            map.put(e.getName(), e.getText());
        }
        ins.close();
        return map;
    }

    /**
     * 文本消息对象转为xml
     */
    public static String textMessageToXml(TextMessage textMessage) {
        XStream xstream = XStreamUtil.initXStream();
        xstream.alias("xml", textMessage.getClass());
        return xstream.toXML(textMessage);
    }

    /**
     * 图文消息转为xml
     */
    public static String newsMessageToXml(NewsMessage newsMessage) {
        XStream xstream = XStreamUtil.initXStream();
        xstream.alias("xml", newsMessage.getClass());
        xstream.alias("item", new News().getClass());
        return xstream.toXML(newsMessage);
    }

    /**
     * 图片消息转为xml
     */
    public static String imageMessageToXml(ImageMessage imageMessage) {
        XStream xstream = XStreamUtil.initXStream();
        xstream.alias("xml", imageMessage.getClass());
        return xstream.toXML(imageMessage);
    }

    /**
     * 音乐消息转为xml
     */
    public static String musicMessageToXml(MusicMessage musicMessage) {
        XStream xstream = XStreamUtil.initXStream();
        xstream.alias("xml", musicMessage.getClass());
        return xstream.toXML(musicMessage);
    }

    /**
     * 组装文本消息
     */
    public static String initText(String toUserName, String fromUserName, String content) {
        TextMessage text = new TextMessage();
        text.setFromUserName(toUserName);
        text.setToUserName(fromUserName);
        text.setMsgType(WeChatUtil.MESSAGE_TEXT);
        text.setCreateTime(new Date().getTime());
        text.setContent(content);
        return textMessageToXml(text);
    }

    /**
     * 组装图文消息
     */
    public static String initNewsMessage(String toUserName, String fromUserName, List<News> newsList) {
        NewsMessage newsMessage = new NewsMessage();
        newsMessage.setToUserName(fromUserName);
        newsMessage.setFromUserName(toUserName);
        newsMessage.setCreateTime(new Date().getTime());
        newsMessage.setMsgType(WeChatUtil.MESSAGE_NEWS);
        newsMessage.setArticles(newsList);
        newsMessage.setArticleCount(newsList.size());
        return WeChatUtil.newsMessageToXml(newsMessage);
    }

    /**
     * 组装图片消息
     */
    public static String initImageMessage(String toUserName, String fromUserName, Image image) {
        ImageMessage imageMessage = new ImageMessage();
        imageMessage.setFromUserName(toUserName);
        imageMessage.setToUserName(fromUserName);
        imageMessage.setMsgType(MESSAGE_IMAGE);
        imageMessage.setCreateTime(new Date().getTime());
        imageMessage.setImage(image);
        return imageMessageToXml(imageMessage);
    }

    /**
     * 组装音乐消息
     */
    public static String initMusicMessage(String toUserName, String fromUserName, Music music) {
        MusicMessage musicMessage = new MusicMessage();
        musicMessage.setFromUserName(toUserName);
        musicMessage.setToUserName(fromUserName);
        musicMessage.setMsgType(MESSAGE_MUSIC);
        musicMessage.setCreateTime(new Date().getTime());
        musicMessage.setMusic(music);
        return musicMessageToXml(musicMessage);
    }

    /**
     * 获取accessToken
     */
    public static AccessToken getAccessToken() throws ParseException, IOException {
        AccessToken token = new AccessToken();
        String url = ACCESS_TOKEN_URL.replace("APPID", APPID).replace("APPSECRET", APPSECRET);
        JSONObject jsonObject = HttpUtil.doGetStr(url);
        if (jsonObject != null) {
            token.setToken(jsonObject.getString("access_token"));
            token.setExpiresIn(jsonObject.getInt("expires_in"));
        }
        return token;
    }

    /**
     * 获取accessToken
     */
    public static AccessToken getAccessTokenByCustomSSL()
            throws KeyManagementException, NoSuchAlgorithmException, ClientProtocolException, IOException {
        AccessToken token = new AccessToken();
        String url = ACCESS_TOKEN_URL.replace("APPID", APPID).replace("APPSECRET", APPSECRET);
        JSONObject jsonObject = HttpUtil.customSSL(url);
        if (jsonObject != null) {
            token.setToken(jsonObject.getString("access_token"));
            token.setExpiresIn(jsonObject.getInt("expires_in"));
        }
        return token;
    }

    /**
     * 创建菜单
     */
    public static int createMenu(String token, String menu) throws ParseException, IOException {
        int result = 0;
        String url = CREATE_MENU_URL.replace("ACCESS_TOKEN", token);
        JSONObject jsonObject = HttpUtil.doPostStr(url, menu);
        if (jsonObject != null) {
            result = jsonObject.getInt("errcode");
        }
        return result;
    }

    /**
     * 菜单查询
     */
    public static JSONObject queryMenu(String token) throws ParseException, IOException {
        String url = QUERY_MENU_URL.replace("ACCESS_TOKEN", token);
        JSONObject jsonObject = HttpUtil.doGetStr(url);
        return jsonObject;
    }

    /**
     * 菜单删除
     */
    public static int deleteMenu(String token) throws ParseException, IOException {
        String url = DELETE_MENU_URL.replace("ACCESS_TOKEN", token);
        JSONObject jsonObject = HttpUtil.doGetStr(url);
        int result = 0;
        if (jsonObject != null) {
            result = jsonObject.getInt("errcode");
        }
        return result;
    }

    /**
     * 上传文件
     */
    public static String upload(String filePath, String accessToken, String type)
            throws KeyManagementException, NoSuchAlgorithmException, NoSuchProviderException, IOException {
        // 参数替换
        String url = WeChatUtil.UPLOAD_URL.replace("ACCESS_TOKEN", accessToken).replace("TYPE", type);
        return HttpUtil.upload(url, filePath, accessToken, type);
    }
}
