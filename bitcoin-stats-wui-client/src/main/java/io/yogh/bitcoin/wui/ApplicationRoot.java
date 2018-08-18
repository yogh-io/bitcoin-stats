package io.yogh.bitcoin.wui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Document;
import com.google.inject.Inject;

import io.yogh.bitcoin.wui.resources.R;
import io.yogh.gwt.wui.activity.ActivityManager;
import io.yogh.gwt.wui.daemon.DaemonBootstrapper;
import io.yogh.gwt.wui.history.HistoryManager;
import io.yogh.gwt.wui.util.WebUtil;

/**
 * Root of the application logic.
 */
public class ApplicationRoot {
  @Inject private RootPanelFactory rootPanelFactory;

  @Inject private HistoryManager historyManager;

  @Inject private ActivityManager activityManager;

  @Inject private DaemonBootstrapper daemonBootstrapper;

  @Inject private ApplicationRootView appDisplay;

  /**
   * Starts the application.
   */
  public void startUp() {
    ApplicationGinjector.INSTANCE.inject(this);

    WebUtil.setAbsoluteRoot(GWT.getHostPageBaseURL());

    daemonBootstrapper.init(() -> finishStartup());
  }

  private void finishStartup() {
    activityManager.setPanel(appDisplay);
    rootPanelFactory.getPanel().add(appDisplay);

    historyManager.handleCurrentHistory();
  }

  /**
   * Hides the main application display, if attached.
   */
  public void hideDisplay() {
    if (appDisplay != null && appDisplay.asWidget().isAttached()) {
      // destroy panel. unrecoverable error
      appDisplay.asWidget().removeFromParent();
    }
  }
}