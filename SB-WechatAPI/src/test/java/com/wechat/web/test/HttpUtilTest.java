package com.wechat.web.test;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.junit.Test;

import com.wechat.po.AccessToken;
import com.wechat.utils.DataInit;
import com.wechat.utils.WeChatUtil;

import net.sf.json.JSONObject;

public class HttpUtilTest {
    // public static void main(String[] args) {
    // try {
    // String result = HttpUtil.translate("my name is laobi");
    // // String result = WeixinUtil.translateFull("");
    // System.out.println(result);
    // } catch (Exception e) {
    // e.printStackTrace();
    // }
    // }

    /**
     * 获取token
     */
    // @Test
    public void testGetAccessToken()
            throws ParseException, IOException, KeyManagementException, NoSuchAlgorithmException {
        AccessToken token = WeChatUtil.getAccessTokenByCustomSSL();
        System.out.println("票据" + token.getToken());
        System.out.println("有效时间" + token.getExpiresIn());
    }

    /**
     * 上传图片
     */
    // @Test
    public void testUploadImage() throws KeyManagementException, NoSuchAlgorithmException, ClientProtocolException,
            IOException, NoSuchProviderException {
        AccessToken token = WeChatUtil.getAccessTokenByCustomSSL();
        System.out.println("票据" + token.getToken());
        System.out.println("有效时间" + token.getExpiresIn());
        String path = "D:/imooc.jpg";

        String mediaId = WeChatUtil.upload(path, token.getToken(), "image");
        System.out.println(mediaId);
        // JdmO1EGkXzIjNkhuQEvz5ZnCFDOrKHP4_R2JL8vPdhi6jxN3SLZkjm33bYNFyjJt
    }

    /**
     * 上传音频：音乐或者语音
     */
    // @Test
    public void testUploadVoice() throws KeyManagementException, NoSuchAlgorithmException, ClientProtocolException,
            IOException, NoSuchProviderException {
        AccessToken token = WeChatUtil.getAccessTokenByCustomSSL();
        System.out.println("票据" + token.getToken());
        System.out.println("有效时间" + token.getExpiresIn());
        String path = "D:/Mr.DADA.mp3";

        String mediaId = WeChatUtil.upload(path, token.getToken(), "voice");
        System.out.println(mediaId);

        // EHSSotTdJ09Lt8iJQa4xNKsJ1DcYKVSoNoWl5JbrYkeoOHWrFY6dQyMglItUo1cV
    }

    /**
     * 菜单创建
     */
    @Test
    public void test() throws KeyManagementException, NoSuchAlgorithmException, ClientProtocolException, IOException {
        AccessToken token = WeChatUtil.getAccessTokenByCustomSSL();
        System.out.println("票据" + token.getToken());
        System.out.println("有效时间" + token.getExpiresIn());

        String menu = JSONObject.fromObject(DataInit.initMenu()).toString();
        int result = WeChatUtil.createMenu(token.getToken(), menu);
        if (result == 0) {
            System.out.println("创建菜单成功");
        } else {
            System.out.println("错误码:" + result);
        }
    }
}
