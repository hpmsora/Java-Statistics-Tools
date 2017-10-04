package statisticstools;

import java.awt.*;
import javax.swing.*;

public class DrawHistogram extends JPanel {

  private String _title = "";
  private double[] _values;
  private double _x_start, _x_end, _x_interval;
  private int _y_start, _y_end, _y_interval;

  public DrawHistogram(String title, double[] values, double x_start, double x_end, double x_interval, int y_start, int y_end, int y_interval) {
		_title = title;
		_values = values;
		_x_start = x_start;
		_x_end = x_end;
		_x_interval = x_interval;
		_y_start = y_start;
		_y_end = y_end;
		_y_interval = y_interval;
  }

  public void paintComponent(Graphics g) {
		int[] calcArray = calculateArray();
		int calcArraySize = calcArray.length;
		int graphInterval = (int) Math.ceil(800 / (double) calcArraySize);
		
		super.paintComponent(g);
		this.setBackground(Color.WHITE);

		for (int i = 0; i < calcArraySize; i++) {
			g.setColor(Color.BLACK);
			g.fillRect(100 + graphInterval * i, 400 - calcArray[i] * 400 / ((_y_end - _y_start) / _y_interval), graphInterval, calcArray[i] * 400 / ((_y_end - _y_start) / _y_interval));
		}
		    
		g.setColor(Color.BLACK);
		g.drawString(_title, 50, 30);
	}

	public int[] calculateArray() {
		int[] result = new int[(int) ((_x_end - _x_start) / _x_interval)];
		double currentValue, currentX;
		int order;
		
		for (int i = 0; i < _values.length; i++) {
	    currentValue = _values[i];
	    currentX = _x_start;
	    order = 0;

	    while (currentX < _x_end) {
				if(currentValue >= currentX && currentValue < (currentX + _x_interval)) {
					result[order] += 1;
					break;
				}
				currentX += _x_interval;
				order++;
			}
		}
		return result;
	}
}
