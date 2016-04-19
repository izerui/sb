package org.elasticsearch.plugin.hyh;

import java.util.Collection;

import org.elasticsearch.common.collect.ImmutableList;
import org.elasticsearch.common.inject.Module;
import org.elasticsearch.hyh.MyModule;

public class MyPlugin extends org.elasticsearch.plugins.AbstractPlugin {
    // 插件Module
    private static final Collection<Class<? extends Module>> modules = ImmutableList
            .<Class<? extends Module>> of(MyModule.class);

    public String name() {
        // 插件名字
        return "Hongyh-Plugin";
    }

    public String description() {
        // 插件描述
        return "My First Plugin";
    }

    @Override
    public Collection<Class<? extends Module>> modules() {
        return modules;
    }
}