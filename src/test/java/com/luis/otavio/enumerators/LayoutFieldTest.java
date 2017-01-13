package com.luis.otavio.enumerators;

import junit.framework.TestCase;

public class LayoutFieldTest extends TestCase {

  public void testShouldFindAValidIbgeDespiteNoLowerCase() {
    String argument = "IBGE_ID 1032412";
    LayoutField expected = LayoutField.IBGE;

    LayoutField result = LayoutField.getInString(argument);
    assertEquals("Command should be of ibge type", expected, result);
  }

  public void testShouldFindAValidIbgeOnString() {
    String argument = "ibge_id 3123123";
    LayoutField expected = LayoutField.IBGE;

    LayoutField result = LayoutField.getInString(argument);
    assertEquals("Command should be of ibge type", expected, result);
  }

  public void testShouldFindAValidUfOnString() {
    String argument = "uf SC";
    LayoutField expected = LayoutField.UF;

    LayoutField result = LayoutField.getInString(argument);
    assertEquals("Command should be of uf type", expected, result);
  }

  public void testShouldFindAValidNameOnString() {
    String argument = "name Florianópolis";
    LayoutField expected = LayoutField.NAME;

    LayoutField result = LayoutField.getInString(argument);
    assertEquals("Command should be of name type", expected, result);
  }

  public void testShouldFindAValidIsCapitalOnString() {
    String argument = "capital true";
    LayoutField expected = LayoutField.IS_CAPITAL;

    LayoutField result = LayoutField.getInString(argument);
    assertEquals("Command should be of capital type", expected, result);
  }

  public void testShouldFindAValidLongitudeOnString() {
    String argument = "lon 0.0000";
    LayoutField expected = LayoutField.LONGITUDE;

    LayoutField result = LayoutField.getInString(argument);
    assertEquals("Command should be of longitude type", expected, result);
  }

  public void testShouldFindAValidLatitudeOnString() {
    String argument = "lat 0.0000";
    LayoutField expected = LayoutField.LATITUDE;

    LayoutField result = LayoutField.getInString(argument);
    assertEquals("Command should be of latitude type", expected, result);
  }

  public void testShouldFindAValidNameNoAccentsOnString() {
    String argument = "no_accents Florianopolis";
    LayoutField expected = LayoutField.NAME_NO_ACCENTS;

    LayoutField result = LayoutField.getInString(argument);
    assertEquals("Command should be of no_accents type", expected, result);
  }

  public void testShouldFindAValidMicroregionOnString() {
    String argument = "microregion Florianopolis";
    LayoutField expected = LayoutField.MICROREGION;

    LayoutField result = LayoutField.getInString(argument);
    assertEquals("Command should be of microregion type", expected, result);
  }

  public void testShouldFindAValidMesoregionOnString() {
    String argument = "mesoregion Florianopolis";
    LayoutField expected = LayoutField.MESOREGION;

    LayoutField result = LayoutField.getInString(argument);
    assertEquals("Command should be of mesoregion type", expected, result);
  }

  public void testShouldFindAValidAlternativeNamesNoAccentsOnString() {
    String argument = "alternative_names Florianopolis";
    LayoutField expected = LayoutField.ALTERNATIVE_NAMES;

    LayoutField result = LayoutField.getInString(argument);
    assertEquals("Command should be of alternative_names type", expected, result);
  }

  public void testShouldNotFindAValidCommandWhenStringDoesNotHaveOne() {
    String argument = "euwfheuiwh 100131";
    LayoutField expected = LayoutField.INVALID;

    LayoutField result = LayoutField.getInString(argument);
    assertEquals("Command should be of invalid type", expected, result);
  }

  public void testShouldNotFindAValidCommandWhenStringIsEmpty() {
    String argument = "";
    LayoutField expected = LayoutField.INVALID;

    LayoutField result = LayoutField.getInString(argument);
    assertEquals("Command should be of invalid type", expected, result);
  }

  public void testShouldNotFindAValidCommandWhenStringIsNull() {
    String argument = null;
    LayoutField expected = LayoutField.INVALID;

    LayoutField result = LayoutField.getInString(argument);
    assertEquals("Command should be of invalid type", expected, result);
  }
}
