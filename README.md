# Java-Statistics-Tools
Simple Statistics Tools Written in Java

by Won Yong Ha


```java
import statisticstools.Methods;
```

```java
Methods method = new Methods();
```

StatisticsTools.java
```java
public double[] generateRandom1DArray(int numberOfRows, double range1, double range2);
public double[][] generateRandom2DArray(int numberOfRows, int numberOfColumns, double range1, double range2);
public double average1DArray(double[] x);
public double average2DArray(double[][] x, int columnOrder);
public double standardDiv1DArray(double[] x);
public double standardDiv2DArray(double[][] x, int columnOrder);
public double[] confidenceInterval1DArray(double[] x, double zScore);
public double[] confidenceInterval2DArray(double[][] x, double zScore, int columnOrder);
public void print1DArray(double[] array);
public void print2DArray(double[][] array);
public void drawHistogram(String title, double[] values, double x_start, double x_end, double x_interval, int y_start, int y_end, int y_interval);
public void combinationCal(double[] array);
```

Usage of Makefile
```Makefile
make update   //Update the statisticstools package
make test     //Test the test.javafile
make clean    //Remove all class file on parents folder
```