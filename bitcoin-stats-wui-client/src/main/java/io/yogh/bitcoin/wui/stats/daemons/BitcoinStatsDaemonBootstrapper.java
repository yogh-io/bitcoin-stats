package io.yogh.bitcoin.wui.stats.daemons;

import com.google.inject.Inject;

import io.yogh.gwt.wui.daemon.DaemonBootstrapperImpl;
import io.yogh.gwt.wui.daemon.ExceptionDaemon;
import io.yogh.gwt.wui.dev.DevelopmentObserver;

public class BitcoinStatsDaemonBootstrapper extends DaemonBootstrapperImpl {
  @Inject
  public BitcoinStatsDaemonBootstrapper(final ExceptionDaemon exceptionDaemon, final DevelopmentObserver observer) {
    super(exceptionDaemon, observer);
  }

  @Override
  public void init(final Runnable complete) {
    super.init(complete);
  }
}
