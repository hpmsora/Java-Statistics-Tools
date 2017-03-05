import statisticstools.Methods;
import java.lang.Math;

public class test {
    public static void main(String[] args) {
	double[] x = new double[100];
	
	Methods a = new Methods();

	x = a.generateRandom1DArray(100, 0, 10);
	
	a.print1DArray(x);
	a.drawHistogram("Histogram 1", x, 0, 10, 1, 0, 20, 1);
    }
}
