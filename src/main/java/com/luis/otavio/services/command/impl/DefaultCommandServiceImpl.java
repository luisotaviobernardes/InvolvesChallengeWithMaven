package com.luis.otavio.services.command.impl;

import com.luis.otavio.resource.Procedure;
import com.luis.otavio.services.command.api.CommandService;

public class DefaultCommandServiceImpl implements CommandService {
  private DefaultCommandServiceImpl() { }

  public static DefaultCommandServiceImpl create() {
    return new DefaultCommandServiceImpl();
  }

  @Override
  public Procedure interpret(String argument) {
    return Procedure.create(argument);
  }
}