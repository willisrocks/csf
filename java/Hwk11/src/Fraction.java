import java.math.*;
import java.math.BigInteger;
import java.util.InputMismatchException;

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

  Fraction(BigInteger n, BigInteger d) {
    numberOfFractions++;
    if (d != BigInteger.ZERO) {
      num = n;
      den = d;
    } else {
      num = BigInteger.ZERO;
      den = BigInteger.ONE;
    }
  }
  
  public BigInteger getNum() {
    return num;
  }
  
  public BigInteger getDen() {
    return den;
  }
  
  public void invert() {
    BigInteger tmp = this.num;

    this.num = this.den;
    this.den = tmp;
  }
  
  public void setFraction(String n, String d) {
    if (Integer.parseInt(d) != 0) {
      setFraction(new BigInteger(n), new BigInteger(d));
    }
  }

  public void setFraction(BigInteger n, BigInteger d) {
    if (d != BigInteger.ZERO) {
      this.num = n;
      this.den = d;
    }
  }

  public void setFraction(int n, int d) {
    if (d != 0) {
      setFraction(Integer.toString(n), Integer.toString(d));
    }
  }
  
  public void mult(Fraction x) {
    setFraction(this.num.multiply(x.num),this.den.multiply(x.den));
  }
  
  public void add(Fraction x) {
    BigInteger n;
    BigInteger d;
    n = this.num;
    n = n.multiply(x.den);
    n = n.add(this.den.multiply(x.num));
    d = this.den.multiply(x.den);
    setFraction(n,d);
  }
  
  public static Fraction mult(Fraction x,Fraction y) {
    BigInteger n = x.num.multiply(y.num);
    BigInteger d = x.den.multiply(y.den);

    return new Fraction(n,d);
  }
  
  public static Fraction add(Fraction x,Fraction y) {
    Fraction tmpx = new Fraction(x.num, x.den);
    Fraction tmpy = new Fraction(y.num, y.den);
    tmpx.add(tmpy);

    return new Fraction(tmpx.num, tmpx.den);
  }
  
  public static Fraction calcE(int terms) {
    Fraction sum = new Fraction(BigInteger.ONE, BigInteger.ONE);
    BigInteger tmp;

    for (int i = 1; i <= terms; i++) {
      tmp = Fraction.fact(i);
      Fraction tmpf = new Fraction(BigInteger.ONE, tmp);
      sum.add(tmpf);

    }
    return sum;
  }
  
  // Uses the Leibniz formula
  public static Fraction calcPI_L(int terms) {
    Fraction pi = new Fraction("0", "1");
    BigInteger d = new BigInteger("1");

    for (int i=0; i < terms; i++) {
      Fraction t = new Fraction(BigInteger.ONE, d);
      if (i % 2 == 0) {
        // pi + 1/d
        pi = Fraction.add(pi, t);
      } else {
        // pi - 1/d
        pi = Fraction.add(pi, Fraction.mult(new Fraction("-1", "1"), t));
      }
      d = d.add(new BigInteger("2"));
    }
    // pi = pi * 4
    pi = Fraction.mult(pi, new Fraction("4","1"));

    return pi;
  }
  
  // Uses the Nilakantha formula
  public static Fraction calcPI_N(int terms) {
    Fraction pi = new Fraction("3", "1");
    Fraction sign = new Fraction("1", "1");

    for (int i=2; i <= terms*2; i+=2) {
      // calculate the denominator
      BigInteger d = new BigInteger(Integer.toString(i)); // d = i
      // d = d * (d + 1) * (d + 2)
      d = d.multiply(d.add(BigInteger.ONE)).multiply(d.add(BigInteger.ONE.add(BigInteger.ONE)));
      // convert to fraction 4/d
      Fraction t = new Fraction(new BigInteger("4"), d);
      // multiply t by sign
      t.mult(sign);
      // update pi
      pi.add(t);
      // toggle sign
      sign.mult(new Fraction("-1","1"));
    }

    return pi;
  }
  
  public void simplify() {
    BigInteger n = this.num;
    BigInteger d = this.den;
    BigInteger gcd = Fraction.gcd(n,d);
    n = n.divide(gcd);
    d = d.divide(gcd);
    this.setFraction(n,d);
  }
  
  // Helper methods
  
  public BigDecimal toBigDecimal(int digits) {
    BigDecimal bigDecX = new BigDecimal(num);
    BigDecimal bigDecY = new BigDecimal(den);
    return bigDecX.divide(bigDecY,digits,BigDecimal.ROUND_UP);
  }

  public String toString() {
    return this.num + "/" + this.den;
  }

  public static BigInteger fact(int n) {
    BigInteger x = new BigInteger(Integer.toString(n));
    if ((x.signum() == 0) || x.equals(BigInteger.ONE)) {
      return BigInteger.ONE;
    } else {
      return x.multiply(fact(x.subtract(BigInteger.ONE)));
    }
  }

  public static BigInteger fact(BigInteger x) {
    //BigInteger x = new BigInteger(Integer.toString(n));
    if ((x.signum() == 0) || x.equals(BigInteger.ONE)) {
      return BigInteger.ONE;
    } else {
      return x.multiply(fact(x.subtract(BigInteger.ONE)));
    }
  }

  public static BigInteger gcd(BigInteger p, BigInteger q) {
    if (q.equals(BigInteger.ZERO)) {
      return p;
    } else {
      return gcd(q, p.mod(q));
    }
  }

} // end Fraction class

