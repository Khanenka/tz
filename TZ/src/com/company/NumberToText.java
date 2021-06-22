package com.company;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class NumberToText {


  private static int billion;
  private static int million;
  private static int thousand;
  private static int toThousand;
  private static long value;
  private static long numberMax = 999999999999L;
  private static String numText;

  //private  int index ;
  private static int indexA;
  private static int units;
  private static int decimal;
  private static int hundreds;

  private static final String[][] digits = {
      {"", "од", "дв", "три", "четыре", "пять", "шесть", "семь", "восемь", "девять"},
      {"", "десять ", "двадцать ", "тридцать ", "сорок ", "пятьдесят ", "шестьдесят ", "семьдесят ",
          "восемьдесят ", "девяносто "},
      {"", "сто ", "двести ", "триста ", "четыреста ", "пятьсот ", "шестьсот ", "семьсот ",
          "восемьсот ", "девятьсот "}};

  private static final String[] value11to19 = {"десять ", "одинадцать ", "двенадцать ",
      "тринадцать ", "четырнадцать ", "пятнадцать ",
      "шестнадцать ", "семнадцать ", "восемьнадцать ", "девятнадцать ", "девятнадцать "};

  private static final String[][] textMillion = {{"", "", "", ""},
      {"миллиардов ", "миллионов ", "тысяч ", ""},
      {"миллиард ", "миллион ", "тысяча ", ""},
      {"миллиарда ", "миллиона ", "тысячи ", ""},
      {"миллиардов ", "миллионов ", "тысяч ", ""}};

  public static String WordsToText(long number) {
    value = number;

    numText = "";
    if (value < -numberMax || value > numberMax) {
      return numText = "Число выходит за рамки указанного диапазона";
    }
    if (value == 0) {
      return numText = "ноль ";
    }
    if (number < 0) {
      numText = "минус ";
      value = -value;
    }

// разбиваем число на миллиарды,миллионы,тысячи и единицы
    billion = (int) (value / 1_000_000_000);
    million = (int) (value - (billion * 1_000_000_000)) / 1_000_000;
    thousand = (int) (value - (billion * 1_000_000_000) - (million * 1_000_000)) / 1000;
    toThousand = (int) (value % 1000);

    // составляем число текстом
    numText = numText + divisoinThousandAnd(billion, 0) + divisoinThousandAnd(million, 1) + divisoinThousandAnd(
        thousand, 2) + divisoinThousandAnd(toThousand, 3);
    return numText;

  }

  static String divisoinThousandAnd(int numericalValue, int index) {

    hundreds = numericalValue / 100;//сотни
    decimal = (numericalValue - (hundreds * 100)) / 10;//десятые
    units = numericalValue % 10;//единицы

//  число без степени
    numText = "";
    if (decimal == 1) {
      numText = digits[2][hundreds] + value11to19[units];//сотни 10<=x>=19
    } else {
      numText = digits[2][hundreds] + digits[1][decimal]
          + digits[0][units];//сотни и десятки и единицы без окончания
    }

    if (index == 2) {
      if (units == 1 && decimal != 1) {//од..НА
        numText = numText + "на ";
      } else if (units == 2 & decimal != 1) {
        numText = numText + "е ";//дв..Е
      }
      if (units > 1 && decimal != 1) {
        numText = numText + " ";//" "пятьдесят четыре
      }
    } else {
      if (units == 1 && decimal != 1) {// тридцать оди..ИН
        numText = numText + "ин ";
      }
      if (units == 2 & decimal != 1) {// двадцать дв..А
        numText = numText + "а ";
      }
      if (units != 0 & decimal != 1) {
        numText = numText + " ";//" "пятьдесят четыре
      }
    }

    // дописываем степень числа
    indexA = 0;
    if (numericalValue != 0) {
      if (units == 0 || decimal == 1) {
        indexA = 1;//"миллиардов ", "миллионов ", "тысяч ", ""
      } else if (units == 1) {
        indexA = 2;//"миллиард ", "миллион ", "тысяча ", ""
      } else if (units > 1 & units < 5) {
        indexA = 3;//"миллиарда ", "миллиона ", "тысячи ", ""
      } else {
        indexA = 4;//"миллиардов ", "миллионов ", "тысяч ", ""
      }
    }
    numText = numText + textMillion[indexA][index];//массив значений
    return numText;
  }
}


class NumberToTextMain {

  public void numberToTextMain() throws IOException {
    long number = 0;// введенное число

    Scanner in = new Scanner(System.in);

    do {
      System.out.print(
          "Введите целое число в диапазоне -999 999 999 999 до 999 999 999 999, для выхода введите 0: ");
    } while (number != 0);
    try {

      number = (long) in.nextDouble();
      System.out.println(NumberToText.WordsToText(number));


    } catch (InputMismatchException exception) {
      System.out.println("Ошибка,Введено не целое число!!");


    }
    System.out.println("Введено не целое число/Ноль/ Работа программы завершена");

  }


  public static void main(String[] args) throws IOException {
    NumberToTextMain numberToTextMain = new NumberToTextMain();
    numberToTextMain.numberToTextMain();
  }
}
