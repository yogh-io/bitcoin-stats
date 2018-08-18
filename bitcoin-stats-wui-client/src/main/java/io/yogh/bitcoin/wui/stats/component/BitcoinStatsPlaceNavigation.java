package io.yogh.bitcoin.wui.stats.component;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.google.inject.Inject;

import io.yogh.bitcoin.wui.i18n.M;
import io.yogh.bitcoin.wui.resources.R;
import io.yogh.bitcoin.wui.stats.place.LandingPlace;
import io.yogh.gwt.wui.place.ApplicationPlace;
import io.yogh.gwt.wui.place.PlaceController;

public class BitcoinStatsPlaceNavigation extends PlaceNavigation<String> {
  private final Map<String, ApplicationPlace> places = new HashMap<>();

  @Inject
  public BitcoinStatsPlaceNavigation(final PlaceController placeController) {
    super(placeController);

    places.put(LandingPlace.class.getSimpleName(), new LandingPlace());

    buildButtons();
  }

  @Override
  protected Collection<String> getPlaces() {
    return places.keySet();
  }

  @Override
  protected String getBackgroundColor(final String thing) {
    return R.colors().placeBackgroundColor(thing);
  }

  @Override
  protected String getFaceColor(final String thing) {
    return R.colors().placeFontColor(thing);
  }

  @Override
  protected String getText(final String thing) {
    return M.messages().placeButtonText(thing);
  }

  @Override
  protected ApplicationPlace getPlace(final String thing) {
    return places.get(thing);
  }
}
