package statisticstools;

import java.awt.*;
import javax.swing.*;

public class DrawHistogram extends JPanel {

    private String _title = "";
    private double[] _values;
    private double _x_start, _x_end, _x_interval, _y_start, _y_end, _y_interval;

    public DrawHistogram(String title, double[] values, double x_start, double x_end, double x_interval, double y_start, double y_end, double y_interval) {
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
	
	super.paintComponent(g);
	this.setBackground(Color.WHITE);

	g.setColor(Color.BLUE);
	g.fillRect(25, 25, 100, 30);

	g.setColor(new Color(190,81,215));
	g.drawString(_title, 25, 120);
	
	for (int i = 0; i < calcArray.length; i++) {
	    System.out.println("Order " + i + " : " + calcArray[i]); 
	}
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
