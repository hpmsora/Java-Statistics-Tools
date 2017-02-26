import java.lang.Math;

class StatisticsTools {

    public static void main (String[] args){

	double[][] x = new double[100][3];

	x = generateRandomArray(100, 3, 0, 1);

	printArray(x);
    }
    
    public static double averageArray(double[][] x, int columnOrder) {
	double result = 0;

	return result;
    }

    public static double[][] generateRandomArray(int numberOfRows, int numberOfColumns, double range1, double range2) {
	double[][] array = new double[numberOfRows][numberOfColumns];

	for (int i = 0; i < numberOfRows; i++) {
	    for (int j = 0; j < numberOfColumns; j++) {
		array[i][j] = (Math.random() * range2 - range1) + range1;
	    }
	}

	return array;
    }

    public static void printArray(double[][] array) {
	int numberOfColumns = array[0].length;
	int numberOfRows = array.length;

	for (int i = 0; i < numberOfRows; i++) {
	    System.out.print("[ ");
	    for (int j = 0; j < numberOfColumns; j++) {
		System.out.print(array[i][j] + "\t");
	    }
	    System.out.print(" ]\n");
	}
    }
}
