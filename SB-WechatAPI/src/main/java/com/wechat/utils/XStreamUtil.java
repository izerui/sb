package com.wechat.utils;

import java.io.Writer;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;

public class XStreamUtil {
    private static String PREFIX_CDATA = "<![CDATA[";
    private static String SUFFIX_CDATA = "]]>";

    /**
     * 全部转化
     */
    public static XStream initXStream() {
        return new XStream(new XppDriver() {
            @Override
            public HierarchicalStreamWriter createWriter(Writer out) {
                return new PrettyPrintWriter(out) {
                    protected void writeText(QuickWriter writer, String text) {
                        // if (text.startsWith(PREFIX_CDATA) &&
                        // text.endsWith(SUFFIX_CDATA)) {
                        writer.write(PREFIX_CDATA + text + SUFFIX_CDATA);
                        // } else {
                        // super.writeText(writer, text);
                        // }
                    }
                };
            }
        });
    }

    /**
     * 支持某一字段可以加入CDATA标签,如果需要某一字段使用原文,就需要在String类型的text的头加上 "<![CDATA["和结尾处加上
     * "]]>"标签， 以供XStream输出时进行识别
     * @param isAddCDATA 是否支持CDATA标签
     */
    public static XStream initXStream(boolean isAddCDATA) {
        XStream xstream = null;
        if (isAddCDATA) {
            xstream = new XStream(new XppDriver() {
                @Override
                public HierarchicalStreamWriter createWriter(Writer out) {
                    return new PrettyPrintWriter(out) {
                        protected void writeText(QuickWriter writer, String text) {
                            if (text.startsWith(PREFIX_CDATA) && text.endsWith(SUFFIX_CDATA)) {
                                writer.write(text);
                            } else {
                                super.writeText(writer, text);
                            }
                        }
                    };
                }
            });
        } else {
            xstream = new XStream();
        }
        return xstream;
    }
}
