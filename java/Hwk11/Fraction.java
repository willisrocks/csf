import java.math.*;

public class Fraction {
  
  public static int numberOfFractions=0;
  
  private BigInteger num;
  private BigInteger den;
  
  Fraction() {
    numberOfFractions++;
    num = new BigInteger("0");
    den = new BigInteger("1");
  }
  
  Fraction(String n, String d) {
    numberOfFractions++;
    if (!d.equals("0")) {
      num = new BigInteger(n);
      den = new BigInteger(d);
    }
    else {
      num = new BigInteger("0");
      den = new BigInteger("1");
    }
  }
  
  public BigInteger getNum() {
    return num;
  }
  
  public BigInteger getDen() {
    return den;
  }
  
  public void invert() {
  }
  
  Fraction(BigInteger n, BigInteger d) {
  }
  
  public void setFraction(String n, String d) {
  }
  
  public void mult(Fraction x) {
  }
  
  public void add(Fraction x) {
  }
  
  public static Fraction mult(Fraction x,Fraction y) {
    return new Fraction();
  }
  
  public static Fraction add(Fraction x,Fraction y) {
    return new Fraction();
  }
  
  public static Fraction calcE(int terms) {
    return new Fraction();
  }
  
  // Uses the Leibniz formula
  public static Fraction calcPI_L(int terms) {
    return new Fraction();
  }
  
  // Uses the Nilakantha formula
  public static Fraction calcPI_N(int terms) {
    return new Fraction();
  }
  
  public void simplify() {
  }
  
  // Helper methods
  
  public BigDecimal toBigDecimal(int digits) {
    BigDecimal bigDecX = new BigDecimal(num);
    BigDecimal bigDecY = new BigDecimal(den);
    return bigDecX.divide(bigDecY,digits,BigDecimal.ROUND_UP);
  }
  
  // Change to private here.
  public static BigInteger fact(int x) {
    return new BigInteger("1");
  } 
  
  public static BigInteger gcd(BigInteger p, BigInteger q) {
    return new BigInteger("1");
  }
}

