package io.yogh.bitcoin.wui;

import com.google.gwt.inject.client.AbstractGinModule;
import com.google.inject.Singleton;
import com.google.web.bindery.event.shared.EventBus;

import io.yogh.gwt.wui.event.CommandEventBus;

public class ApplicationClientModule extends AbstractGinModule {
  @Override
  protected void configure() {
    bind(EventBus.class).to(CommandEventBus.class).in(Singleton.class);
  }
}
