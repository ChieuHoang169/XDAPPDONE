package com.example.xdapp.ui.calendar;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.example.xdapp.R;

public class PageTileFragmentDirections {
  private PageTileFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionPageTileFragmentToTile1Fragment() {
    return new ActionOnlyNavDirections(R.id.action_pageTileFragment_to_tile1Fragment);
  }
}
