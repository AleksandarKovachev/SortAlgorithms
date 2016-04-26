package jChart;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;

public class Engine {

	public static ArrayList<Integer> numbers;
	public static JFreeChart chart;
	public static Boolean isCharacter = false;

	public static void init() {

		numbers = new ArrayList<Integer>();

		Display.frame.addKeyListener(new HelpMenu());

		Display.textField.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}

			@Override
			public void keyPressed(KeyEvent e) {
				int keyCode = e.getKeyCode();
				char ch = e.getKeyChar();

				new HelpMenu().keyPressed(e);

				if (keyCode == KeyEvent.VK_ENTER) {
					if (Display.insert.getText().equals("")) {
						try {
							numbers.add(Integer.parseInt(Display.textField.getText()));
							isCharacter = false;
						} catch (NumberFormatException e1) {
							isCharacter = true;
							JOptionPane.showMessageDialog(Display.frame, "Моля, въведете число.", "Съобщение",
									JOptionPane.PLAIN_MESSAGE);
						}
						if (!isCharacter)
							Display.insert.setText(Display.textField.getText());
					} else if (!Display.textField.getText().equals("")) {
						try {
							numbers.add(Integer.parseInt(Display.textField.getText()));
							isCharacter = false;
						} catch (NumberFormatException e1) {
							isCharacter = true;
							JOptionPane.showMessageDialog(Display.frame, "Моля, въведете число.", "Съобщение",
									JOptionPane.PLAIN_MESSAGE);
						}
						if (!isCharacter)
							Display.insert.setText(Display.insert.getText() + ", " + Display.textField.getText());
					}
					Display.textField.setText("");

					if (!buttonAction.sorted)
						draw(numbers);
				}
			}
		});

		draw(numbers);

		Display.sort.addActionListener(new buttonAction());

		statistic();

		Display.clear.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (!numbers.isEmpty()) {
					draw(numbers);
					buttonAction.setSorted(false);
					SortAlgorithms.clear(SortAlgorithms.sortNumbers);
					Display.sortNum.setText("");
				}
			}
		});

		Display.deleteAll.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (!numbers.isEmpty() && buttonAction.sorted) {
					numbers.clear();
					SortAlgorithms.clear(SortAlgorithms.sortNumbers);
					draw(numbers);
					Display.textField.setVisible(true);
					Display.statistic.setVisible(false);
					Display.insert.setText("");
					Display.sortNum.setText("");
					buttonAction.sorted = false;

					Statistic.quicSorting.setText("........");
					Statistic.bubbleSort.setText("........");
					Statistic.cycleSort.setText("........");
					Statistic.cocktailSort.setText("........");
					Statistic.heapSort.setText("........");
					Statistic.insertionSort.setText("........");
					Statistic.selectionSort.setText("........");
					Statistic.mergeSort.setText("........");
					Statistic.shellSort.setText("........");
					Statistic.oddevenSort.setText("........");
				}
			}
		});

		Display.back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Display.panel.setVisible(true);
				Display.viewPanel.setVisible(true);
				Display.helpPanel.setVisible(false);
			}
		});
	}

	public static void draw(ArrayList<Integer> numbers) {
		Display.panel.removeAll();
		Display.panel.revalidate();
		Display.dataset.clear();
		for (int i = 0; i < numbers.size(); i++) {
			Display.dataset.addValue(numbers.get(i), "", i + "");
		}

		chart = ChartFactory.createBarChart("", "", "", Display.dataset, PlotOrientation.VERTICAL, false, false, false);
		chart.setBackgroundPaint(Color.WHITE);
		chart.getPlot().setBackgroundPaint(Color.WHITE);
		CategoryPlot catPlot = chart.getCategoryPlot();
		catPlot.setRangeGridlinePaint(Color.BLACK);

		ChartPanel chartPanel = new ChartPanel(chart);

		Display.panel.add(chartPanel, BorderLayout.CENTER);
		Display.panel.validate();
		Display.panel.repaint();
	}

	public static void statistic() {
		Display.statistic.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Statistic();
			}
		});
	}
}
