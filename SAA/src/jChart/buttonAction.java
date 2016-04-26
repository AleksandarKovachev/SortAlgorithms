package jChart;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JComboBox;

public class buttonAction implements ActionListener {

	public static Boolean sorted = false;

	public static void setSorted(Boolean sorted) {
		buttonAction.sorted = sorted;
	}

	public void actionPerformed(ActionEvent e) {
		if (!Engine.numbers.isEmpty()) {
			String msg = (String) Display.comboBox.getSelectedItem();

			switch (msg) {
			case "Quick sort":
				if (!sorted) {
					SortAlgorithms.quickSorting(Engine.numbers);
					Display.textField.setVisible(false);
					Display.statistic.setVisible(true);
					sorted = true;
				}
				break;

			case "Merge sort":
				if (!sorted) {
					SortAlgorithms.mergeSorting(Engine.numbers);
					Display.textField.setVisible(false);
					Display.statistic.setVisible(true);
					sorted = true;
				}
				break;

			case "Bubble sort":
				if (!sorted) {
					SortAlgorithms.bubbleSorting(Engine.numbers);
					Display.textField.setVisible(false);
					Display.statistic.setVisible(true);
					sorted = true;
				}
				break;
			case "Heap sort":
				if (!sorted) {
					SortAlgorithms.heapSorting(Engine.numbers);
					Display.textField.setVisible(false);
					Display.statistic.setVisible(true);
					sorted = true;
				}
				break;
			case "Insertion sort":
				if (!sorted) {
					SortAlgorithms.insertionSorting(Engine.numbers);
					Display.textField.setVisible(false);
					Display.statistic.setVisible(true);
					sorted = true;
				}
				break;
			case "Selection sort":
				if (!sorted) {
					SortAlgorithms.selectionSort(Engine.numbers);
					Display.textField.setVisible(false);
					Display.statistic.setVisible(true);
					sorted = true;
				}
				break;
			case "Odd-even sort":
				if (!sorted) {
					SortAlgorithms.oddEvenSorting(Engine.numbers);
					Display.textField.setVisible(false);
					Display.statistic.setVisible(true);
					sorted = true;
				}
				break;
			case "Cocktail sort":
				if (!sorted) {
					SortAlgorithms.cocktailSorting(Engine.numbers);
					Display.textField.setVisible(false);
					Display.statistic.setVisible(true);
					sorted = true;
				}
				break;
			case "Cycle sort":
				if (!sorted) {
					SortAlgorithms.cycleSorting(Engine.numbers);
					Display.textField.setVisible(false);
					Display.statistic.setVisible(true);
					sorted = true;
				}
				break;
			case "Shell sort":
				if (!sorted) {
					SortAlgorithms.shellSorting(Engine.numbers);
					Display.textField.setVisible(false);
					Display.statistic.setVisible(true);
					sorted = true;
				}
				break;
			default:
				break;

			}
		}
	}
}
