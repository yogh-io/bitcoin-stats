package io.yogh.bitcoin.wui.stats.ui.landing;

import com.google.inject.Inject;

import io.yogh.bitcoin.wui.stats.ui.landing.LandingView.Presenter;
import io.yogh.gwt.wui.activity.EventActivity;

public class LandingActivity extends EventActivity<Presenter, LandingView> implements Presenter {
  @Inject
  public LandingActivity(LandingView view) {
    super(view);
  }
  
  @Override
  public Presenter getPresenter() {
    return this;
  }

}
