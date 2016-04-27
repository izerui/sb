package com.wechat.utils;

import java.util.ArrayList;
import java.util.List;

import com.wechat.menu.Button;
import com.wechat.menu.ClickButton;
import com.wechat.menu.Menu;
import com.wechat.menu.ViewButton;
import com.wechat.po.Image;
import com.wechat.po.Music;
import com.wechat.po.News;

public class DataInit {
    /**
     * 主菜单
     */
    public static String menuText() {
        StringBuffer sb = new StringBuffer();
        sb.append("欢迎您的关注，请按照菜单提示进行操作：\n\n");
        sb.append("1、课程介绍\n");
        sb.append("2、慕课网介绍\n");
        sb.append("3、图片推送\n");
        sb.append("4、音乐推送\n");
        sb.append("5、词组翻译\n");
        sb.append("6、历史上的今天\n\n");
        sb.append("回复？调出此菜单。");
        return sb.toString();
    }

    public static String firstMenu() {
        StringBuffer sb = new StringBuffer();
        sb.append("介绍微信公众号开发，主要涉及公众号介绍、编辑模式介绍、开发模式介绍等");
        return sb.toString();
    }

    public static String secondMenu() {
        StringBuffer sb = new StringBuffer();
        sb.append(
                "慕课网是垂直的互联网IT技能免费学习网站。以独家视频教程、在线编程工具、学习计划、问答社区为核心特色。在这里，你可以找到最好的互联网技术牛人，也可以通过免费的在线公开视频课程学习国内领先的互联网IT技术。");
        sb.append(
                "慕课网课程涵盖前端开发、PHP、Html5、Android、iOS、Swift等IT前沿技术语言，包括基础课程、实用案例、高级分享三大类型，适合不同阶段的学习人群。以纯干货、短视频的形式为平台特点，为在校学生、职场白领提供了一个迅速提升技能、共同分享进步的学习平台。");
        return sb.toString();
    }

    public static String threeMenu() {
        StringBuffer sb = new StringBuffer();
        sb.append("词组翻译使用指南\n\n");
        sb.append("使用示例：\n");
        sb.append("翻译足球\n");
        sb.append("翻译中国足球\n");
        sb.append("翻译football\n\n");
        sb.append("回复？显示主菜单。");
        return sb.toString();
    }

    /**
     * 图文消息的组装
     */
    public static List<News> newsMessageData() {
        // 多图文
        List<News> newsList = new ArrayList<News>();
        News news = new News();
        news.setTitle("慕课网介绍");
        news.setDescription(
                "慕课网是垂直的互联网IT技能免费学习网站。以独家视频教程、在线编程工具、学习计划、问答社区为核心特色。在这里，你可以找到最好的互联网技术牛人，也可以通过免费的在线公开视频课程学习国内领先的互联网IT技术。慕课网课程涵盖前端开发、PHP、Html5、Android、iOS、Swift等IT前沿技术语言，包括基础课程、实用案例、高级分享三大类型，适合不同阶段的学习人群。");
        news.setPicUrl("http://hongyh.ngrok.cc/image/imooc.jpg");
        news.setUrl("www.imooc.com");
        News news2 = new News();
        news2.setTitle("慕课网介绍2");
        news2.setDescription(
                "慕课网是垂直的互联网IT技能免费学习网站。以独家视频教程、在线编程工具、学习计划、问答社区为核心特色。在这里，你可以找到最好的互联网技术牛人，也可以通过免费的在线公开视频课程学习国内领先的互联网IT技术。慕课网课程涵盖前端开发、PHP、Html5、Android、iOS、Swift等IT前沿技术语言，包括基础课程、实用案例、高级分享三大类型，适合不同阶段的学习人群。");
        news2.setPicUrl("http://hongyh.ngrok.cc/image/imooc.jpg");
        news2.setUrl("www.imooc.com");
        newsList.add(news);
        newsList.add(news2);
        return newsList;
    }

    /**
     * 组装菜单
     */
    public static Menu initMenu() {
        Menu menu = new Menu();
        ClickButton button11 = new ClickButton();
        button11.setName("click点击");
        button11.setType("click");
        button11.setKey("11");

        ViewButton button21 = new ViewButton();
        button21.setName("view视图");
        button21.setType("view");
        button21.setUrl("https://www.baidu.com");

        ClickButton button31 = new ClickButton();
        button31.setName("扫码事件");
        button31.setType("scancode_push");
        button31.setKey("31");

        ClickButton button32 = new ClickButton();
        button32.setName("地理位置");
        button32.setType("location_select");
        button32.setKey("32");

        Button button = new Button();
        button.setName("其他功能");
        button.setSub_button(new Button[] { button31, button32 });

        menu.setButton(new Button[] { button11, button21, button });
        return menu;
    }

    public static Image ImageinitImageMessageData() {
        Image image = new Image();
        image.setMediaId("JdmO1EGkXzIjNkhuQEvz5ZnCFDOrKHP4_R2JL8vPdhi6jxN3SLZkjm33bYNFyjJt");
        return image;
    }

    public static Music initMusicMessageData() {
        Music music = new Music();
        music.setThumbMediaId("EHSSotTdJ09Lt8iJQa4xNKsJ1DcYKVSoNoWl5JbrYkeoOHWrFY6dQyMglItUo1cV");
        music.setTitle("see you again");
        music.setDescription("速7片尾曲");
        music.setMusicUrl("http://hongyh.ngrok.cc/mp3/Mr.DADA.mp3");
        music.setHQMusicUrl("http://hongyh.ngrok.cc/mp3/Mr.DADA.mp3");
        return music;
    }
}
