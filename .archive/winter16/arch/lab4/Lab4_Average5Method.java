public class Lab4_Average5Method {
  public static void main(String args[]) {
    int a = Integer.parseInt(args[0]);
    int b = Integer.parseInt(args[1]);
    int c = Integer.parseInt(args[2]);
    int d = Integer.parseInt(args[3]);
    int e = Integer.parseInt(args[4]);
    Lab4_Average5Method avg = new Lab4_Average5Method();
    double average = avg.average5(a,b,c,d,e);

    System.out.println(average);
  }

  public double average5(int a, int b, int c, int d, int e) {
    return (a + b + c + d + e) / 5.0;
  }
}
