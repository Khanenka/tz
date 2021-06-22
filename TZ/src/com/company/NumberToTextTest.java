package com.company;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NumberToTextTest {

  private static long billion;
  private static long million;
  private static long thousand;
  private static long toThousand;
  private static long units;
  private static long decimal;
  private static long hundreds;
  private static final String[][] sampleText = {
      {"", "од", "дв", "три", "четыре", "пять", "шесть", "семь", "восемь", "девять"},
      {"", "десять ", "двадцать ", "тридцать ", "сорок ", "пятьдесят ", "шестьдесят ", "семьдесят ",
          "восемьдесят ", "девяносто "},
      {"", "сто ", "двести ", "триста ", "четыреста ", "пятьсот ", "шестьсот ", "семьсот ",
          "восемьсот ", "девятьсот "}};
  private static final String[] sample11to19 = {"десять ", "одинадцать ", "двенадцать ",
      "тринадцать ", "четырнадцать ", "пятнадцать ",
      "шестнадцать ", "семнадцать ", "восемьнадцать ", "девятнадцать ", "девятнадцать "};

  private static final String[][] textMillion = {{"", "", "", ""},
      {"миллиардов ", "миллионов ", "тысяч ", ""},
      {"миллиард ", "миллион ", "тысяча ", ""},
      {"миллиарда ", "миллиона ", "тысячи ", ""},
      {"миллиардов ", "миллионов ", "тысяч ", ""}};

  int etalonLong = 1_234_567_891;
  int numericalValue = 891;
  String numText = "";
  int index = 0;

  private static long numberMax = 999999999999L;

  String etalonStr = "один миллиард двести тридцать четыре миллиона пятьсот шестьдесят семь тысяч восемьсот девяносто один";

  @Test
  public void outputEtalonLongAndNotNull() {

    System.out.println(etalonLong + "Test output Etalon Long Not Null");
    assertNotNull(etalonLong);
  }

  @Test
  public void outputNull() {
    System.out.println("test for null");
    String zero = null;
    if (zero == null) {
      System.out.println("ноль");
    }
    assertNull(zero);
  }

  @Test
  public void diapozon() {
    String numText = "Число выходит за рамки указанного диапазона";
    if (etalonLong < -numberMax || etalonLong > numberMax) {
      assertEquals(etalonLong, numText);

    }
  }

  @Test
  public void minus() {

    String numText;
    if (etalonLong < 0) {
      numText = "минус ";
      etalonLong = -etalonLong;
      assertEquals(-etalonLong, -etalonLong);

    }
  }

  @Test
  public void MinusText() {
    String numText;
    if (etalonLong < 0) {
      numText = "минус ";
      etalonLong = -etalonLong;

      assertEquals(numText + etalonStr, etalonStr);
    }
  }

  @Test
  public void divisoinThousandAndMore() {

    billion = (int) (etalonLong / 1_000_000_000);
    million = (int) (etalonLong - (billion * 1_000_000_000)) / 1_000_000;
    thousand = (int) (etalonLong - (billion * 1_000_000_000) - (million * 1_000_000)) / 1000;
    toThousand = (int) (etalonLong % 1000);
    assertEquals(1, billion);
    assertEquals(234, million);
    assertEquals(567, thousand);
    assertEquals(891, toThousand);

  }

  @Test
  public void divisoinHundredsAndLess() {

    long numericalValue = 891;
    System.out.println(hundreds = numericalValue / 100);
    System.out.println(decimal = (numericalValue - (hundreds * 100)) / 10);
    System.out.println(units = numericalValue % 10);
  }

  @Test
  public void searchHundredsAndDecimal() {
    String numText = "";

    hundreds = numericalValue / 100;
    decimal = (numericalValue - (hundreds * 100)) / 10;
    units = numericalValue % 10;
    if (decimal == 1) {
      numText = sampleText[2][(int) hundreds] + sample11to19[(int) units];
      System.out.println(numText);
    } else {
      numText =
          sampleText[2][(int) hundreds] + sampleText[1][(int) decimal] + sampleText[0][(int) units];
      System.out.println(numText);
    }
  }
  @Test
  public void searchEndingUnits() {



    units = numericalValue % 10;
    if (index == 2) {
      if (units == 1 && decimal != 1) {
        numText = numText + "на ";
        System.out.println(numText);
      } else if (units == 2 & decimal != 1) {
        numText = numText + "е ";
        System.out.println(numText);
      }
      if (units > 1 && decimal != 1) {
        numText = numText + " ";
        System.out.println(numText);
      }
    } else {
      if (units == 1 && decimal != 1) {
        numText = numText + "ин ";
        System.out.println(numText);
      }
      if (units == 2 & decimal != 1) {
        numText = numText + "а ";
        System.out.println(numText);
      }if (units != 0 & decimal != 1) {
        numText = numText + " ";
        System.out.println(numText);
      }
    }
  }

  @Test
  public void searchDegree(){
   int indexA = 0;

    if (numericalValue != 0) {
      if (units == 0 || decimal == 1) {
        indexA = 1;
        System.out.println(numText = numText + textMillion[indexA][index]);
      } else if (units == 1) {
        indexA = 2;
        System.out.println(numText = numText + textMillion[indexA][index]);
      } else if (units > 1 & units < 5) {
        indexA = 3;
        System.out.println(numText = numText + textMillion[indexA][index]);
      } else {
        indexA = 4;
        System.out.println(numText = numText + textMillion[indexA][index]);
      }
    }
  }



}