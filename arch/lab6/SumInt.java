public class sumInt {
  public static void main (String[] args) {
    // Handle input
    if (args.length < 1) {
      System.out.println("Integer required: java sumInt <int>");
      return;
    }
    int n = Integer.parseInt(args[0]);
    if (n < 1) {
      System.out.println("Please enter a positive number");
      return;
    }
    // Run loop
    int i = 1;
    while (i <= n) {
      System.out.println(i);
      i++;
    }
    return;
  }
}
