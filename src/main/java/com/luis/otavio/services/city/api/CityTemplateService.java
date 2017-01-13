package com.luis.otavio.services.city.api;

import com.luis.otavio.enumerators.LayoutField;
import com.luis.otavio.models.City;
import java.util.List;

public interface CityTemplateService {
  List<String> display(List<City> cities, List<LayoutField> displayable);
  List<String> count(List<City> cities, String placeholder);
}
