package io.yogh.bitcoin.wui.stats.history;

import com.google.gwt.core.client.GWT;

import io.yogh.bitcoin.wui.stats.place.LandingPlace;
import io.yogh.gwt.wui.history.PlaceHistoryMapper;
import io.yogh.gwt.wui.place.ApplicationPlace;

public class BitcoinStatsPlaceHistoryMapper implements PlaceHistoryMapper {
  private static final String LANDING = "landing";

  private static final String SEPERATOR = ":";

  @Override
  public String getToken(final ApplicationPlace value) {
    String token = "";

    if (value instanceof LandingPlace) {
      token = LANDING + SEPERATOR + new LandingPlace.Tokenizer().getToken((LandingPlace) value);
    }

    return token;
  }

  @Override
  public ApplicationPlace getPlace(final String token) {
    final String[] tokens = token.split(SEPERATOR, 2);

    ApplicationPlace place;

    GWT.log("Token split: " + tokens[0] + " >> " + tokens[1]);

    switch (tokens[0]) {
    case LANDING:
      place = new LandingPlace.Tokenizer().getPlace(tokens[1]);
      break;
    default:
      place = null;
    }

    return place;
  }
}
