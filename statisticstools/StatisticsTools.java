package statisticstools;
interface StatisticsTools {
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
}
