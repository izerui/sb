package org.elasticsearch.hyh;

import org.elasticsearch.common.inject.AbstractModule;

public class MyModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(MyService.class).asEagerSingleton();
    }
}