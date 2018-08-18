package io.yogh.bitcoin.wui.stats;

import com.google.gwt.core.client.GWT;
import com.google.inject.Inject;

import io.yogh.bitcoin.wui.stats.place.LandingPlace;
import io.yogh.gwt.wui.activity.Activity;
import io.yogh.gwt.wui.activity.ActivityMapper;
import io.yogh.gwt.wui.place.ApplicationPlace;
import io.yogh.gwt.wui.place.DefaultPlace;
import io.yogh.gwt.wui.place.Place;

public class BitcoinStatsActivityMapper implements ActivityMapper {
  private final BitcoinStatsActivityFactory factory;

  @Inject
  public BitcoinStatsActivityMapper(@DefaultPlace final ApplicationPlace place, final BitcoinStatsActivityFactory factory) {
    this.factory = factory;
  }

  @Override
  public Activity<?> getActivity(final Place place) {
    Activity<?> presenter = null;

    presenter = tryGetActivity(place);

    if (presenter == null) {
      GWT.log("Presenter is null: Place ends up nowhere. " + place);
      throw new RuntimeException("No Presenter found for place " + place);
    }

    return presenter;
  }

  private Activity<?> tryGetActivity(final Place place) {
    Activity<?> presenter = null;

    if (place instanceof LandingPlace) {
      presenter = factory.createLandingPresenter((LandingPlace) place);
    }

    return presenter;
  }
}
