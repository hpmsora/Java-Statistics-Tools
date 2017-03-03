import statisticstools.Methods;
import java.lang.Math;

public class test {
    public static void main(String[] args) {
	double[][] x = new double[100][3];

	Methods a = new Methods();
	
	x = a.generateRandom2DArray(100, 3, 0, 1);
	a.print2DArray(x);
    }
}
