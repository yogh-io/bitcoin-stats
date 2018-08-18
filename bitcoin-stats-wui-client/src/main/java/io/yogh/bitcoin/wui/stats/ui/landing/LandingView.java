package io.yogh.bitcoin.wui.stats.ui.landing;

import com.google.inject.ImplementedBy;

import io.yogh.bitcoin.wui.stats.ui.landing.LandingView.Presenter;
import io.yogh.gwt.wui.activity.View;

@ImplementedBy(LandingViewImpl.class)
public interface LandingView extends View<Presenter> {
  public interface Presenter extends View.Presenter {}
}
