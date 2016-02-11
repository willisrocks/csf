import java.math.*;

public class h11A {
  public static void main(String[] argv) {
    
    FractionA x,y,z,a,b;
    
    System.out.println("Welcome to the wild word of fractions!");
    System.out.println("I am going to make two fractions");
    System.out.println("The first fraction x, will be 2/3");
    x = new FractionA("2","3");
    System.out.println("The second fraction y, will be 9/8");
    y = new FractionA("9","8");
    System.out.println("I will now print out fraction x");
    System.out.println(x);
    System.out.println("Pretty Cool, huh?");
    System.out.println("Let's invert x");
    x.invert();
    System.out.println("This has changed x to the fraction: "+x);
    System.out.println("Let's invert x again!");
    x.invert();
    System.out.println("This has changed x back to the fraction: "+x);
    System.out.println("Now I will multiply fraction x by y");
    x.mult(y);
    System.out.println("This has changed x to the fraction: "+x);
    System.out.println("It's obviously not simplified");
    System.out.println("Let's multiply again by fraction y");
    x.mult(y);
    System.out.println("This has now changed x to the fraction: "+x);
    System.out.println("Let's look at this as a decimal number");
    System.out.println("To 7 digits, the decimal value is "+x.toBigDecimal(7));
    System.out.println();
    System.out.println("Ok, now I will make a fraction z using an overloaded constructor");
    z = new FractionA();
    System.out.println("This gives z the value: "+z);
    System.out.println("We can also change the value of z");
    System.out.println("I'll set it to 4/3");
    z.setFractionA("4","3");
    System.out.println("This gives z the value: "+z);
    System.out.println("Setting is smart though....");
    System.out.println("We will try to set z to 4/0 (a no-no)");
    z.setFractionA("4","0");
    System.out.println("This still leaves z with the value:");
    System.out.println(z);
    System.out.println("Let's try adding z to y");
    y.add(z);
    System.out.println("This has changed y to the fraction:");
    System.out.println(y);
    System.out.println("We can make addition a little smart too...");
    System.out.println("Lets make a fraction a, 2/3 and a fraction b, 4/3");
    a = new FractionA("2","3");
    b = new FractionA("4","3");
    System.out.println("Let's try adding b to a");
    a.add(b);
    System.out.println("This has (smartly - yet unsimplified) changed a to the fraction:");
    System.out.println(a);
    System.out.println();
    System.out.println("OK -- let's go for a little static action!");
    System.out.println("Lets set a to, 2/3 and b to 1/5");
    a.setFractionA("2","3");
    b.setFractionA("1","5");
    System.out.println("Now lets set z to the multiplication of a and b");
    z = FractionA.mult(a,b);
    System.out.println("So now z is equal to:");
    System.out.println(z);
    System.out.println("Now lets set z to the addition of a and b");
    z = FractionA.add(a,b);
    System.out.println("So now z is equal to:");
    System.out.println(z);
    System.out.println("BUT.... we didn't change a and b by which are still:");
    System.out.println(a);
    System.out.println(b);
    System.out.println();
    System.out.println("That was some hard work.");
    System.out.println("But now let's really go for it!!");
    System.out.println("Let's calculate E to 100 terms");
    z = FractionA.calcE(100);
    System.out.println("As a fraction this is:");
    System.out.println(z);
    System.out.println();
    System.out.println("Didn't see that coming!");
    System.out.println("To 20 digits, we computed E as:");
    System.out.println(z.toBigDecimal(20));
    System.out.println("Math.E gives E a value of:");
    System.out.println(Math.E);                  
    System.out.println("Who needs the Math class!?!?!?!?");
    System.out.println();
    System.out.println("Why stop now?!?");
    System.out.println("Let's calculate PI to 10000 terms using the Leibniz formula");
    z = FractionA.calcPI_L(10000);
    System.out.println("As a fraction we get:");
    System.out.println(z);
    System.out.println();
    System.out.println("That was HYUGE!");
    System.out.println("To 20 digits, we computed PI as:");
    System.out.println(z.toBigDecimal(20));
    System.out.println("Math.PI gives PI a value of:");
    System.out.println(Math.PI);
    System.out.println("Our formula obviously converges VERY slowly!");
    System.out.println();
    System.out.println("But we can do better");
    System.out.println("Let's calculate PI with only 100 terms using the Nilakantha formula");
    z = FractionA.calcPI_N(100);
    System.out.println("As a fraction we get:");
    System.out.println(z);
    System.out.println();
    System.out.println("To 20 digits, we computed PI as:");
    System.out.println(z.toBigDecimal(20));
    System.out.println("Math.PI gives PI a value of:");
    System.out.println(Math.PI);
    System.out.println("That formula converges much faster!");
    
    System.out.println("FractionAs are AWESOME!!!!!");
    System.out.println();
    System.out.println("Those fractions got really big!");
    System.out.println("Let's simplify fractions");
    System.out.println("All we have to do is divide the numerator");
    System.out.println("and the denominator by their GCD -- cake!");
    System.out.println("Let's make a pretty big fraction");
    x = new FractionA("2629935","14902965");
    System.out.println("The fraction is "+x);
    System.out.println("To 20 digits, this fraction = "+x.toBigDecimal(20));
    System.out.println("Now let's simplify it!");
    x.simplify();
    System.out.println("Simplified, the fraction is "+x);
    System.out.println("To 20 digits, this fraction = "+x.toBigDecimal(20));
    System.out.println("The two numbers are the same -- it worked!!");
    System.out.println("I made it to the end!!");
    System.out.print("By the way, the total number of fractions we created today is: ");
    System.out.println(FractionA.numberOfFractionAs);
    System.out.println();
    System.out.println("Thank you for learning about fractions and enjoy your day!");
    

    // ***** Want to go the extra mile and show the power of fractions?
    // ***** Use fractions to compute the sine and cosine of an angle in radians 
    // ***** Demonstrate them working! You can do it!! You are here to learn!!
  }
}