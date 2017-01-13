package com.luis.otavio.services.command.api;

import com.luis.otavio.resource.Procedure;

public interface CommandService {
  String SEPARATOR = ",";
  String OPERATOR = "&&";

  Procedure interpret(String argument);
}
