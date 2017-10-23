package statisticstools;

import java.lang.Math;
import java.util.*;
import javax.swing.*;

public class Methods implements StatisticsTools {

  public double[] generateRandom1DArray(int numberOfRows, double range1, double range2) {
  	double[] array = new double[numberOfRows];

  	for(int i = 0; i < numberOfRows; i++) {
  	    array[i] = (Math.random() * range2 - range1) + range1;
  	}

  	return array;
  }

  public double[][] generateRandom2DArray(int numberOfRows, int numberOfColumns, double range1, double range2) {
  	double[][] array = new double[numberOfRows][numberOfColumns];

  	for (int i = 0; i < numberOfRows; i++) {
      for (int j = 0; j < numberOfColumns; j++) {
        array[i][j] = (Math.random() * range2 - range1) + range1;
      }
    }
    return array;
  }

  public double average1DArray(double[] x) {
  	double sum = 0;
  	int arrayLength = x.length;

  	for(int i = 0; i < arrayLength; i++) {
      sum += x[i];
  	}

    return sum / arrayLength;
  }

  public double average2DArray(double[][] x, int columnOrder) {
  	double sum = 0;
  	int arrayLength = x.length;

  	for (int i = 0; i < arrayLength; i++) {
      sum += x[i][columnOrder];
  	}

    return sum / arrayLength;
  }

  public double standardDiv1DArray(double[] x) {
  	double sum = 0;
  	double avg = average1DArray(x);
  	int size = x.length;
  	
  	for (int i = 0; i < size; i++) {
      sum += Math.pow(avg - x[i], 2);
  	}

    return Math.sqrt(sum / size);
  }

  public double standardDiv2DArray(double[][] x, int columnOrder) {
  	double sum = 0;
  	double avg = average2DArray(x, columnOrder);
  	int size = x.length;
  	
  	for (int i = 0; i < size; i++) {
      sum += Math.pow(avg - x[i][columnOrder], 2);
  	}

  	return Math.sqrt(sum / size);
  }

  public double[] confidenceInterval1DArray(double[] x, double zScore) {
  	double avg = average1DArray(x);
  	double std = standardDiv1DArray(x);
  	double meanOfError = zScore * std / Math.sqrt(x.length);
  	double[] result = new double[2];

  	result[0] = avg - meanOfError;
  	result[1] = avg + meanOfError;
  	
  	return result;
  }

  public double[] confidenceInterval2DArray(double[][] x, double zScore, int columnOrder) {
  	double avg = average2DArray(x, columnOrder);
  	double std = standardDiv2DArray(x, columnOrder);
  	double meanOfError = zScore * std / Math.sqrt(x.length);
  	double[] result = new double[2];

  	result[0] = avg - meanOfError;
  	result[1] = avg + meanOfError;
  	
  	return result;
  }

  public void print1DArray(double[] array) {

  	for(int i = 0; i < array.length; i++) {
  	    System.out.printf(i + ": %.15f\n", array[i]);
  	}
  }

  public void print2DArray(double[][] array) {
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

  public double combinationCal(ArrayList<Double> array) {
    for (int i = 0; i < array.size(); i++){
      System.out.print(array.get(i) + " ");
    }
    System.out.print("\n\n");

    double result = 0;
    List<List<Double>> resultArray = new ArrayList<List<Double>>();

    resultArray = combinationCal_helper(array);

    for(List<Double> i: resultArray) {
      for(double j: i) {
        System.out.print(j + " ");
      }
      System.out.print("\n");
    }

    return result;
  }

  public  List<List<Double>> combinationCal_helper(ArrayList<Double> array) {
    ArrayList<Double> temp = new ArrayList<Double>(array);
    List<List<Double>> result = new ArrayList<List<Double>>();

    if (array.size() <= 1) {
      result.add(array);
      return result;
    } else {
      double x = temp.get(0);
      temp.remove(0);
      List<List<Double>> nullResult = combinationCal_helper(temp);
      List<List<Double>> addResult = combinationCal_helper(temp);

      for(List<Double> i: addResult) {
        i.add(x);
      }

      addResult.addAll(nullResult);
      return addResult;
    }
  }

  public void drawHistogram(String title, double[] values, double x_start, double x_end, double x_interval, int y_start, int y_end, int y_interval) {
  	JFrame frame = new JFrame("Histogram");
  	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  	DrawHistogram tools = new DrawHistogram(title, values, x_start, x_end, x_interval, y_start, y_end, y_interval);
  	frame.add(tools);
  	frame.setSize(1000,500);
  	frame.setVisible(true);
  }
}
