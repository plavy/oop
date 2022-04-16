package hr.fer.oop;


public class FunTest {

  @SuppressWarnings("deprecation")
  public static void main(String[] args) {
    String redni;

    int i;
    Integer i1;
    Integer i2;

    redni = " 1";
    i = 9;
    i1 = Integer.valueOf("9");
    System.out.println(redni + ": " + (i == i1));

    redni = " 2";
    i1 = new Integer("9");
    i2 = Integer.parseInt("9");
    System.out.println(redni + ": " + (i1 == i2));

    redni = " 3";
    i1 = Integer.valueOf(9);
    i2 = Integer.parseInt("9", 10);
    System.out.println(redni + ": " + (i1 == i2));

    redni = " 4";
    i = new Integer(9);
    i1 = new Integer(9);
    System.out.println(redni + ": " + (i == i1));

    redni = " 5";
    i = Integer.valueOf("9", 10);
    i1 = Integer.valueOf("9", 10);
    System.out.println(redni + ": " + (i == i1));

    redni = " 6";
    i1 = Integer.valueOf("128");
    i2 = Integer.valueOf("128", 10);
    System.out.println(redni + ": " + (i1 == i2));
    double d;
    Double d1;
    Double d2;

    redni = " 7";
    d1 = Double.parseDouble("0");
    d2 = Double.parseDouble("-0");
    System.out.println(redni + ": " + (d1 == d2));

    redni = " 8";
    d1 = Double.parseDouble("10");
    d2 = Double.valueOf(10);
    System.out.println(redni + ": " + (d1 == d2));

    redni = " 9";
    d1 = Double.valueOf(0);
    d2 = Double.valueOf("-0");
    System.out.println(redni + ": " + (d1.equals(d2)));

    redni = "10";
    d = Double.parseDouble("0");
    d1 = Double.parseDouble("-0");
    System.out.println(redni + ": " + (d == d1));

    redni = "11";
    d = Double.valueOf("0");
    d1 = Double.valueOf(-0);
    System.out.println(redni + ": " + (d1.equals(d)));

    redni = "12";
    d1 = Double.NaN;
    d2 = Double.NaN;
    System.out.println(redni + ": " + (d1 == d2));

    redni = "13";
    System.out.println(redni + ": " + (Double.NaN == Double.NaN));

    redni = "14";
    d1 = Double.NaN;
    d2 = Double.NaN;
    System.out.println(redni + ": " + (d1.equals(d2)));

    redni = "15";
    i1 = Integer.parseInt("1024");
    d1 = Double.parseDouble("1024");
    System.out.println(redni + ": " + (i1 == d1.intValue()));

    redni = "16";
    i1 = Integer.valueOf(-0);
    d1 = Double.valueOf(0.1);
    System.out.println(redni + ": " + (i1 == Integer.valueOf(d1.intValue())));

  }
}
