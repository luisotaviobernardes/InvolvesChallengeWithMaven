package com.luis.otavio;

import com.luis.otavio.helpers.Console;
import com.luis.otavio.resource.CityResource;
import com.luis.otavio.resource.strategy.api.CityIOStrategy;
import com.luis.otavio.resource.strategy.impl.WithKnownHeaderPositionCityIOStrategyImpl;
import com.luis.otavio.services.interfaces.api.InterfaceService;
import com.luis.otavio.utils.Bootstrap;

import java.util.List;

public class App {
  private static InterfaceService interfaceService;

  public static void main(String[] args) {
    if (!Bootstrap.initialize()) {
      Console.error("application failed to initialize");
    } else {
      App.interfaceService = Bootstrap.injectInterfaceService();

      while(interfaceService.isRunning()) {
        interfaceService.run();
      }
    }
  }
}
