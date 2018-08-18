package io.yogh.bitcoin.wui.stats.dev;

import com.google.gwt.core.client.GWT;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.binder.EventBinder;
import com.google.web.bindery.event.shared.binder.EventHandler;
import com.google.web.bindery.event.shared.binder.GenericEvent;

import io.yogh.gwt.wui.command.AbstractCommand;
import io.yogh.gwt.wui.command.PlaceChangeCommand;
import io.yogh.gwt.wui.command.SimpleGenericCommand;
import io.yogh.gwt.wui.dev.AbstractLogger;
import io.yogh.gwt.wui.dev.DevelopmentObserver;
import io.yogh.gwt.wui.event.NotificationEvent;
import io.yogh.gwt.wui.event.PlaceChangeEvent;
import io.yogh.gwt.wui.event.SimpleGenericEvent;

@Singleton
public class BitcoinStatsDevelopmentObserver extends AbstractLogger implements DevelopmentObserver {
  interface DevelopmentObserverMonitorImplEventBinder extends EventBinder<BitcoinStatsDevelopmentObserver> {}

  private final DevelopmentObserverMonitorImplEventBinder EVENT_BINDER = GWT.create(DevelopmentObserverMonitorImplEventBinder.class);
  private final EventBus eventBus;

  @Inject
  public BitcoinStatsDevelopmentObserver(final EventBus eventBus) {
    this.eventBus = eventBus;
  }

  @Override
  public void init() {
    EVENT_BINDER.bindEventHandlers(this, eventBus);

    log("initialized development observer.");
  }

  @EventHandler(handles = { PlaceChangeCommand.class })
  public void onSimpleGenericCommand(@SuppressWarnings("rawtypes") final SimpleGenericCommand e) {
    log(e.getClass().getSimpleName(), e.getValue());
  }

  // @EventHandler(handles = {})
  public void onSimpleGenericCommand(@SuppressWarnings("rawtypes") final AbstractCommand e) {
    log(e.getClass().getSimpleName());
  }

  // @EventHandler(handles = {})
  public void onSimpleGenericCommand(final GenericEvent e) {
    log(e.getClass().getSimpleName());
  }

  @EventHandler(handles = { NotificationEvent.class, PlaceChangeEvent.class })
  public void onSimpleGenericEvent(@SuppressWarnings("rawtypes") final SimpleGenericEvent e) {
    log(e.getClass().getSimpleName(), e.getValue());
    brbr();
  }
}
