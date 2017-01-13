package com.luis.otavio.utils;

import com.luis.otavio.helpers.Console;
import com.luis.otavio.resource.strategy.api.CityIOStrategy;
import com.luis.otavio.resource.strategy.impl.WithKnownHeaderPositionCityIOStrategyImpl;
import com.luis.otavio.services.city.api.CityCacheService;
import com.luis.otavio.services.city.api.CityService;
import com.luis.otavio.services.city.api.CityTemplateService;
import com.luis.otavio.services.city.impl.DefaultCityCacheServiceImpl;
import com.luis.otavio.services.city.impl.DefaultCityServiceImpl;
import com.luis.otavio.services.city.impl.DefaultTemplateServiceImpl;
import com.luis.otavio.services.command.api.CommandService;
import com.luis.otavio.services.command.impl.DefaultCommandServiceImpl;
import com.luis.otavio.services.interfaces.api.InterfaceService;
import com.luis.otavio.services.interfaces.impl.DefaultInterfaceServiceImpl;

import static java.util.Objects.isNull;

public class Bootstrap {
  private static final String DEFAULT_PATH = "./resources/cities.csv";
  private static Bootstrap INJECTOR_INSTANCE;
  /**
   * I like to use guice (https://github.com/google/guice) for this.
   * Handles all system injections.
   **/

  private String path;
  public CityIOStrategy strategy;
  private CityCacheService cache;
  private CityTemplateService cityTemplateService;
  private CityService cityService;
  private CommandService command;
  private InterfaceService interfaces;

  private Bootstrap(String path, CityIOStrategy strategy, CityCacheService cache, CityTemplateService cityTemplateService, CityService cityService, CommandService command, InterfaceService interfaces) {
    this.path = path;
    this.strategy = strategy;
    this.cache = cache;
    this.cityTemplateService = cityTemplateService;
    this.cityService = cityService;
    this.command = command;
    this.interfaces = interfaces;
  }

  private static Bootstrap create(String path, CityIOStrategy strategy, CityCacheService cache, CityTemplateService cityTemplateService, CityService cityService, CommandService command, InterfaceService interfaces) {
    return new Bootstrap(path, strategy, cache, cityTemplateService, cityService, command, interfaces);
  }

  public static Boolean initialize() {
    Console.message(" (injecting dependencies) ");
    Bootstrap.build();
    return Bootstrap.isValid();
  }

  public static InterfaceService injectInterfaceService() {
    if (!Bootstrap.isValid()) {
      Bootstrap.initialize();
    }

    return INJECTOR_INSTANCE.interfaces;
  }

  private static Boolean isValid() {
    return (!isNull(INJECTOR_INSTANCE));
  }

  private static void build() {
    CityIOStrategy strategy = WithKnownHeaderPositionCityIOStrategyImpl.create(DEFAULT_PATH);
    CityCacheService cache = DefaultCityCacheServiceImpl.create(strategy);
    CityTemplateService cityTemplateService = DefaultTemplateServiceImpl.create();
    CityService cityService = DefaultCityServiceImpl.create(cache, cityTemplateService);
    CommandService commandService = DefaultCommandServiceImpl.create();

    INJECTOR_INSTANCE = Bootstrap.create(
      DEFAULT_PATH,
      strategy,
      cache,
      cityTemplateService,
      cityService,
      commandService,
      DefaultInterfaceServiceImpl.create(commandService, cityService)
    );
  }
}