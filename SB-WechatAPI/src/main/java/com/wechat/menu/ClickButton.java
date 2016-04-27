package com.wechat.menu;

/**
 * Click类型菜单
 */
public class ClickButton extends Button {
    // 用于判断哪个菜单
    private String key;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
