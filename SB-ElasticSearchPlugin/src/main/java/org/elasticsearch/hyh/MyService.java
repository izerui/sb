package org.elasticsearch.hyh;

import org.elasticsearch.common.inject.Inject;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.indices.IndicesService;

public class MyService {

    /**
     * Settings setting 系统配置项 IndicesService indicesService 操作索引服务对象
     */
    @Inject
    public MyService(Settings setting, IndicesService indicesService) {
        System.out.println("正在加载插件");
    }
}