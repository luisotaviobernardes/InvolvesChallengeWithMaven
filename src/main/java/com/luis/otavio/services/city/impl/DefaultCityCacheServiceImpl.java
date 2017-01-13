package com.luis.otavio.services.city.impl;

import com.luis.otavio.helpers.Console;
import com.luis.otavio.models.City;
import com.luis.otavio.resource.CityResource;
import com.luis.otavio.resource.strategy.api.CityIOStrategy;
import com.luis.otavio.services.city.api.CityCacheService;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class DefaultCityCacheServiceImpl implements CityCacheService {
  private CityIOStrategy strategy;
  private List<City> cache;

  private DefaultCityCacheServiceImpl(CityIOStrategy strategy, List<City> cache) {
    this.strategy = strategy;
    this.cache = cache;
  }

  private static DefaultCityCacheServiceImpl create(CityIOStrategy strategy, List<City> cache) {
    return new DefaultCityCacheServiceImpl(strategy, cache);
  }

  public static DefaultCityCacheServiceImpl create(CityIOStrategy strategy) {
    return DefaultCityCacheServiceImpl.create(strategy, Collections.emptyList());
  }

  private static List<City> build(List<CityResource> resources) {
    Console.message(" (building cache) ");
    return resources.stream().filter(res -> res.isValid).map(City::create).collect(Collectors.toList());
  }

  @Override
  public List<City> get() {
    if (this.cache.isEmpty()) {
      this.cache = DefaultCityCacheServiceImpl.build(this.strategy.process());
    }

    return this.cache;
  }
}