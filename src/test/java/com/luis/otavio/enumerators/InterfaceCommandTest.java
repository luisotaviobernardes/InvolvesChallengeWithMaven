package com.luis.otavio.enumerators;

import junit.framework.TestCase;

public class InterfaceCommandTest extends TestCase {

  public void testShouldFindAValidCountDespiteNoLowerCase() {
    String argument = "QUIT";
    InterfaceCommand expected = InterfaceCommand.EXIT;

    InterfaceCommand result = InterfaceCommand.getByCommand(argument);
    assertEquals("Command should be of exit type", expected, result);
  }

  public void testShouldFindAValidExitCommandOnString() {
    String argument = "exit";
    InterfaceCommand expected = InterfaceCommand.EXIT;

    InterfaceCommand result = InterfaceCommand.getByCommand(argument);
    assertEquals("Command should be of exit type", expected, result);
  }

  public void testShouldFindAValidHelpCommandOnString() {
    String argument = "help";
    InterfaceCommand expected = InterfaceCommand.HELP;

    InterfaceCommand result = InterfaceCommand.getByCommand(argument);
    assertEquals("Command should be of help type", expected, result);
  }

  public void testShouldFindAValidQueryCommandOnString() {
    String argument = "query";
    InterfaceCommand expected = InterfaceCommand.QUERY;

    InterfaceCommand result = InterfaceCommand.getByCommand(argument);
    assertEquals("Command should be of query type", expected, result);
  }

  public void testShouldNotFindAValidCommandWhenStringDoesNotHaveOne() {
    String argument = "ewufewfiewfys";
    InterfaceCommand expected = InterfaceCommand.INVALID;

    InterfaceCommand result = InterfaceCommand.getByCommand(argument);
    assertEquals("Command should be of invalid type", expected, result);
  }

  public void testShouldNotFindAValidCommandWhenStringIsEmpty() {
    String argument = "";
    InterfaceCommand expected = InterfaceCommand.INVALID;

    InterfaceCommand result = InterfaceCommand.getByCommand(argument);
    assertEquals("Command should be of invalid type", expected, result);
  }

  public void testShouldNotFindAValidCommandWhenStringIsNull() {
    String argument = null;
    InterfaceCommand expected = InterfaceCommand.INVALID;

    InterfaceCommand result = InterfaceCommand.getByCommand(argument);
    assertEquals("Command should be of invalid type", expected, result);
  }
}
