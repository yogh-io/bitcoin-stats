package io.yogh.bitcoin.wui;

import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.inject.ImplementedBy;

import io.yogh.bitcoin.wui.stats.ui.ApplicationRootViewImpl;

/**
 * Main Application Display interface.
 */
@ImplementedBy(ApplicationRootViewImpl.class)
public interface ApplicationRootView extends IsWidget, AcceptsOneWidget {}
