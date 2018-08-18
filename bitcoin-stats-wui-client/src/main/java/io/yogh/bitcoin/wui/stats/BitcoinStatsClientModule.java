package io.yogh.bitcoin.wui.stats;

import com.google.gwt.inject.client.AbstractGinModule;
import com.google.gwt.inject.client.assistedinject.GinFactoryModuleBuilder;
import com.google.gwt.place.shared.PlaceHistoryHandler.Historian;

import io.yogh.bitcoin.wui.stats.component.BitcoinStatsPlaceNavigation;
import io.yogh.bitcoin.wui.stats.component.PlaceNavigation;
import io.yogh.bitcoin.wui.stats.daemons.BitcoinStatsDaemonBootstrapper;
import io.yogh.bitcoin.wui.stats.dev.BitcoinStatsDevelopmentObserver;
import io.yogh.bitcoin.wui.stats.history.BitcoinStatsPlaceHistoryMapper;
import io.yogh.bitcoin.wui.stats.place.LandingPlace;
import io.yogh.gwt.wui.activity.ActivityMapper;
import io.yogh.gwt.wui.daemon.DaemonBootstrapper;
import io.yogh.gwt.wui.dev.DevelopmentObserver;
import io.yogh.gwt.wui.history.HTML5Historian;
import io.yogh.gwt.wui.history.PlaceHistoryMapper;
import io.yogh.gwt.wui.place.ApplicationPlace;
import io.yogh.gwt.wui.place.DefaultPlace;

public class BitcoinStatsClientModule extends AbstractGinModule {
  @Override
  protected void configure() {
    bind(ApplicationPlace.class).annotatedWith(DefaultPlace.class).to(LandingPlace.class);
    bind(Historian.class).to(HTML5Historian.class);

    // Bind components
    bind(PlaceNavigation.class).to(BitcoinStatsPlaceNavigation.class);

    bind(ActivityMapper.class).to(BitcoinStatsActivityMapper.class);
    bind(PlaceHistoryMapper.class).to(BitcoinStatsPlaceHistoryMapper.class);
    bind(DaemonBootstrapper.class).to(BitcoinStatsDaemonBootstrapper.class);
    bind(DevelopmentObserver.class).to(BitcoinStatsDevelopmentObserver.class);

    install(new GinFactoryModuleBuilder().build(BitcoinStatsActivityFactory.class));
  }
}
