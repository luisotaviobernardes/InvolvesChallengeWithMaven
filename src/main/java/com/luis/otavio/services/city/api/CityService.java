package com.luis.otavio.services.city.api;

import com.luis.otavio.resource.Procedure;
import java.util.List;

public interface CityService {
  List<String> query(Procedure procedure);
}
