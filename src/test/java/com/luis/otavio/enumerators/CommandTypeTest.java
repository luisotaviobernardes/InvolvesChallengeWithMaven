package com.luis.otavio.enumerators;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CommandTypeTest extends TestCase {

  public void testShouldReturnTrueWhenListIsEmpty() {
    List<CommandType> types =  Collections.emptyList();
    Boolean result = CommandType.validate(types);

    assertTrue("Result should return true", result);
  }

  public void testShouldReturnTrueWhenListHasOnlyOneOfEachType() {
    List<CommandType> types = new ArrayList<>();
    types.add(CommandType.DISPLAY);
    types.add(CommandType.DISTINCT);
    types.add(CommandType.ORDER);
    Boolean result = CommandType.validate(types);

    assertTrue("Result should return true", result);
  }

  public void testShouldReturnFalseWhenListHasTwoOnOneOfTheTypes() {
    List<CommandType> types = new ArrayList<>();
    types.add(CommandType.DISPLAY);
    types.add(CommandType.DISPLAY);
    types.add(CommandType.DISTINCT);
    types.add(CommandType.ORDER);
    Boolean result = CommandType.validate(types);

    assertFalse("Result should return true", result);
  }
}
