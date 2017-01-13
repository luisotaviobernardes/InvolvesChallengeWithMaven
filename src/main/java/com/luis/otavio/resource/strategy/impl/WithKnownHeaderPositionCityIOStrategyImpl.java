package com.luis.otavio.resource.strategy.impl;

import com.luis.otavio.enumerators.LayoutField;
import com.luis.otavio.helpers.CSVReader;
import com.luis.otavio.helpers.Console;
import com.luis.otavio.helpers.LongHelper;
import com.luis.otavio.helpers.StringHelper;
import com.luis.otavio.resource.CityResource;
import com.luis.otavio.resource.strategy.api.CityIOStrategy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WithKnownHeaderPositionCityIOStrategyImpl implements CityIOStrategy {
  private static final String DEFAULT_SEPARATOR = ",";

  private String path;
  private String separator;
  private Map<String, Integer> mapping;

  private WithKnownHeaderPositionCityIOStrategyImpl(String path, Map<String, Integer> mapping, String separator) {
    this.path = path;
    this.mapping = mapping;
    this.separator = separator;
  }

  public static WithKnownHeaderPositionCityIOStrategyImpl create(String path) {
    return new WithKnownHeaderPositionCityIOStrategyImpl(
      path, WithKnownHeaderPositionCityIOStrategyImpl.mapDefaultLayoutPositions(), DEFAULT_SEPARATOR
    );
  }

  @Override
  public List<CityResource> process() {
    return CSVReader.read(this.path).stream().map(this::build).collect(Collectors.toList());
  }

  // so we wont have problems in case our array is copied by half :)
  private String tryToFetchFromArray(String[] array, int position) {
    try {
      return array[position];
    } catch(Exception ex) {
      Console.error("error trying to parse an line in csv, stack: ");
      ex.printStackTrace();
      return StringHelper.EMPTY;
    }
  }

  private CityResource build(String line) {
    String[] info = line.split(this.separator);

    /* logic was prone to crash if someone would mess with the csv or the copy ended half way :)
    Long ibge = LongHelper.parse(info[LayoutField.IBGE.getPosition()]);
    String uf = info[LayoutField.UF.getPosition()];
    String name = info[LayoutField.NAME.getPosition()];
    Boolean isCapital = Boolean.valueOf(info[LayoutField.IS_CAPITAL.getPosition()]);
    String longitude = info[LayoutField.LONGITUDE.getPosition()];
    String latitude = info[LayoutField.LATITUDE.getPosition()];
    String nameNoAccents = info[LayoutField.NAME_NO_ACCENTS.getPosition()];
    String alternativeNames = info[LayoutField.ALTERNATIVE_NAMES.getPosition()];
    String microRegion = info[LayoutField.MICROREGION.getPosition()];
    String mesoRegion = info[LayoutField.MESOREGION.getPosition()];
    */

    Long ibge = LongHelper.parse(this.tryToFetchFromArray(info, LayoutField.IBGE.getPosition()));
    String uf = this.tryToFetchFromArray(info, LayoutField.UF.getPosition());
    String name = this.tryToFetchFromArray(info, LayoutField.NAME.getPosition());
    Boolean isCapital = Boolean.valueOf(this.tryToFetchFromArray(info, LayoutField.IS_CAPITAL.getPosition()));
    String longitude = this.tryToFetchFromArray(info, LayoutField.LONGITUDE.getPosition());
    String latitude = this.tryToFetchFromArray(info, LayoutField.LATITUDE.getPosition());
    String nameNoAccents = this.tryToFetchFromArray(info, LayoutField.NAME_NO_ACCENTS.getPosition());
    String alternativeNames = this.tryToFetchFromArray(info, LayoutField.ALTERNATIVE_NAMES.getPosition());
    String microRegion = this.tryToFetchFromArray(info, LayoutField.MICROREGION.getPosition());
    String mesoRegion = this.tryToFetchFromArray(info, LayoutField.MESOREGION.getPosition());

    return LongHelper.isValid(ibge)
      ? CityResource.create(ibge, uf, name, isCapital, longitude, latitude, nameNoAccents, alternativeNames, microRegion, mesoRegion)
      : CityResource.empty();
  }

  private static Map<String, Integer> mapDefaultLayoutPositions() {
    Map<String, Integer> result = new HashMap<>();

    LayoutField.getAll().stream().map(set -> result.put(set.getName(), set.getPosition()));
    return result;
  }
}
