import statisticstools.Methods;
import java.lang.Math;
import java.util.*;

public class test {
  public static void main(String[] args) {
  	/*double[] x = new double[100];
  	
  	Methods a = new Methods();

  	x = a.generateRandom1DArray(100, 0, 10);
  	
  	a.print1DArray(x);
  	a.drawHistogram("Histogram 1", x, 0, 10, 1, 0, 20, 1);*/

    Methods method = new Methods();

    ArrayList<Double> x = new ArrayList<Double>(); //Double.parseDouble(int)
    x.add(4.0);
    x.add(3.0);
    x.add(2.0);
    x.add(1.0);

    System.out.println(method.combinationCal(x));
  }
}
