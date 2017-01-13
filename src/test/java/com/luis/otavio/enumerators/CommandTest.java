package com.luis.otavio.enumerators;

import junit.framework.TestCase;

public class CommandTest extends TestCase {

  public void testShouldFindAValidCountDespiteNoLowerCase() {
    String argument = "COUNT no_accents";
    Command expected = Command.COUNT;

    Command result = Command.getInString(argument);
    assertEquals("Command should be of count type", expected, result);
  }

  public void testShouldFindAValidCountCommandOnString() {
    String argument = "count no_accents";
    Command expected = Command.COUNT;

    Command result = Command.getInString(argument);
    assertEquals("Command should be of count type", expected, result);
  }

  public void testShouldFindAValidSelectCommandOnString() {
    String argument = "select no_accents";
    Command expected = Command.SELECT;

    Command result = Command.getInString(argument);
    assertEquals("Command should be of select type", expected, result);
  }

  public void testShouldFindAValidDistinctCommandOnString() {
    String argument = "distinct no_accents";
    Command expected = Command.DISTINCT;

    Command result = Command.getInString(argument);
    assertEquals("Command should be of distinct type", expected, result);
  }

  public void testShouldFindAValidFilterCommandOnString() {
    String argument = "filter no_accents";
    Command expected = Command.FILTER;

    Command result = Command.getInString(argument);
    assertEquals("Command should be of filter type", expected, result);
  }

  public void testShouldFindAValidOrderCommandOnString() {
    String argument = "order no_accents";
    Command expected = Command.ORDER;

    Command result = Command.getInString(argument);
    assertEquals("Command should be of order type", expected, result);
  }

  public void testShouldNotFindAValidCommandWhenStringDoesNotHaveOne() {
    String argument = "ewufewfiewfy no_accents";
    Command expected = Command.INVALID;

    Command result = Command.getInString(argument);
    assertEquals("Command should be of invalid type", expected, result);
  }

  public void testShouldNotFindAValidCommandWhenStringIsEmpty() {
    String argument = "";
    Command expected = Command.INVALID;

    Command result = Command.getInString(argument);
    assertEquals("Command should be of invalid type", expected, result);
  }

  public void testShouldNotFindAValidCommandWhenStringIsNull() {
    String argument = null;
    Command expected = Command.INVALID;

    Command result = Command.getInString(argument);
    assertEquals("Command should be of invalid type", expected, result);
  }
}
