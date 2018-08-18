package io.yogh.bitcoin.wui.stats;

import io.yogh.bitcoin.wui.stats.place.LandingPlace;
import io.yogh.bitcoin.wui.stats.ui.landing.LandingActivity;

public interface BitcoinStatsActivityFactory {
  LandingActivity createLandingPresenter(LandingPlace place);
}