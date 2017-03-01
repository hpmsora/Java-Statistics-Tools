import java.lang.Math;

class StatisticsTools {

    public static void main (String[] args){

	double[][] x = new double[100][3];

	x = generateRandom2DArray(100, 3, 0, 1);

	print2DArray(x);

	System.out.println("Avg 1 : " + average2DArray(x, 0) + "2 : " + average2DArray(x, 1) + "3: " + average2DArray(x,2));

	System.out.println("Std 1 : " + standardDiv2DArray(x, 0) + "2 : " + standardDiv2DArray(x, 1) + "3: " + standardDiv2DArray(x,2));
	
	double[] y = new double[100];

	y = generateRandom1DArray(100, 0, 1);

	print1DArray(y);

	System.out.println("Avg: " + average1DArray(y));
	
	System.out.println("Std: " + standardDiv1DArray(y));	
    }

    public static double average1DArray(double[] x) {
	double sum = 0;
	int arrayLength = x.length;

	for(int i = 0; i < arrayLength; i++) {
	    sum += x[i];
	}

	return sum / arrayLength;
    }
    
    public static double average2DArray(double[][] x, int columnOrder) {
	double sum = 0;
	int arrayLength = x.length;

	for (int i = 0; i < arrayLength; i++) {
	    sum += x[i][columnOrder];
	}
	
	return sum / arrayLength;
    }

    public static double[] generateRandom1DArray(int numberOfRows, double range1, double range2) {
	double[] array = new double[numberOfRows];

	for(int i = 0; i < numberOfRows; i++) {
	    array[i] = (Math.random() * range2 - range1) + range1;
	}

	return array;
    }

    public static double[][] generateRandom2DArray(int numberOfRows, int numberOfColumns, double range1, double range2) {
	double[][] array = new double[numberOfRows][numberOfColumns];

	for (int i = 0; i < numberOfRows; i++) {
	    for (int j = 0; j < numberOfColumns; j++) {
		array[i][j] = (Math.random() * range2 - range1) + range1;
	    }
	}

	return array;
    }

    public static double standardDiv1DArray(double[] x) {
	double sum = 0, avg;

	avg = average1DArray(x);
	
	for (int i = 0; i < x.length; i++) {
	    sum += Math.pow(avg - x[i], 2);
	}

	return Math.sqrt(sum);
    }

    public static double standardDiv2DArray(double[][] x, int columnOrder) {
	double sum = 0, avg;
	
	avg = average2DArray(x, columnOrder);

	for (int i = 0; i < x.length; i++) {
	    sum += Math.pow(avg - x[i][columnOrder], 2);
	}

	return Math.sqrt(sum);
    }

    public static void print1DArray(double[] array) {

	for(int i = 0; i < array.length; i++) {
	    System.out.printf(i + ": %.15f\n", array[i]);
	}
    }

    public static void print2DArray(double[][] array) {
	int numberOfColumns = array[0].length;
	int numberOfRows = array.length;

	for (int i = 0; i < numberOfRows; i++) {
	    System.out.print(i + ": [ ");
	    for (int j = 0; j < numberOfColumns; j++) {
		System.out.printf("%.16f\t", array[i][j]);
	    }
	    System.out.print(" ]\n");
	}
    }
}
