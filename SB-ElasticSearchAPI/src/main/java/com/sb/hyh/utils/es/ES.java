package com.sb.hyh.utils.es;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.ImmutableSettings;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;

public class ES {
    public static Client getElasticSearch(String ipAddress) {
        Settings settings = ImmutableSettings.settingsBuilder().put("client.transport.ping_timeout", "10s")
                .put("client.transport.sniff", true)
                // 创建索引之后最多在n秒之内肯定能查到
                .put("index.refresh_interval", "1s").put("cluster.name", "elasticsearch").build();
        return new TransportClient(settings).addTransportAddress(new InetSocketTransportAddress(ipAddress, 9300));
    }
}
