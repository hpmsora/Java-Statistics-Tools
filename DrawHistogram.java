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
	super.paintComponent(g);
	this.setBackground(Color.WHITE);

	g.setColor(Color.BLUE);
	g.fillRect(25, 25, 100, 30);

	g.setColor(new Color(190,81,215));
	g.drawString(_title, 25, 120);
    }
}
