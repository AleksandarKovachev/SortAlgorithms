package jChart;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.WindowConstants;
import javax.swing.JList;
import javax.swing.JLabel;

public class Statistic {
	public static JFrame frame;
	public static final int width = 260;
	public static final int height = 318;
	
	private JLabel lblQuickSorting;
	private JLabel lblHeapSort;
	private JLabel lblMergeSort;
	private JLabel lblInsertionSort;
	private JLabel lblSelectionSort;
	private JLabel lblBubbleSort;
	private JLabel lblOddevenSort;
	private JLabel lblCocktailSort;	
	private JLabel lblCycleSort;	
	private JLabel lblShellSort;
	
	public static JLabel quicSorting = new JLabel("........");
	public static JLabel heapSort = new JLabel("........");
	public static JLabel mergeSort = new JLabel("........");
	public static JLabel insertionSort = new JLabel("........");
	public static JLabel selectionSort = new JLabel("........");
	public static JLabel bubbleSort = new JLabel("........");
	public static JLabel oddevenSort = new JLabel("........");
	public static JLabel cocktailSort = new JLabel("........");
	public static JLabel cycleSort = new JLabel("........");
	public static JLabel shellSort = new JLabel("........");

	public Statistic() {
		init();
	}

	private void init() {
		frame = new JFrame("Статистика");
		frame.setVisible(true);
		frame.setPreferredSize(new Dimension(width, height));
		frame.setResizable(false);
		frame.setFocusable(true);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);

		lblQuickSorting = new JLabel("Quick sorting:");
		lblQuickSorting.setBounds(12, 30, 110, 15);
		
		quicSorting.setBounds(130, 30, 118, 15);
		frame.getContentPane().add(quicSorting);

		lblHeapSort = new JLabel("Heap sort:");
		lblHeapSort.setBounds(12, 57, 110, 15);
		
		heapSort.setBounds(130, 57, 118, 15);
		frame.getContentPane().add(heapSort);

		lblMergeSort = new JLabel("Merge sort:");
		lblMergeSort.setBounds(12, 84, 110, 15);	
		
		mergeSort.setBounds(130, 84, 118, 15);
		frame.getContentPane().add(mergeSort);

		lblInsertionSort = new JLabel("Insertion sort:");
		lblInsertionSort.setBounds(12, 111, 110, 15);
		
		insertionSort.setBounds(130, 111, 118, 15);
		frame.getContentPane().add(insertionSort);

		lblSelectionSort = new JLabel("Selection sort:");
		lblSelectionSort.setBounds(12, 138, 110, 15);
		
		selectionSort.setBounds(130, 138, 118, 15);
		frame.getContentPane().add(selectionSort);

		lblBubbleSort = new JLabel("Bubble sort:");
		lblBubbleSort.setBounds(12, 165, 110, 15);
		
		bubbleSort.setBounds(130, 165, 118, 15);
		frame.getContentPane().add(bubbleSort);

		lblOddevenSort = new JLabel("Odd-even sort:");
		lblOddevenSort.setBounds(12, 192, 110, 15);
		
		oddevenSort.setBounds(130, 192, 118, 15);
		frame.getContentPane().add(oddevenSort);

		lblCocktailSort = new JLabel("Cocktail sort:");
		lblCocktailSort.setBounds(12, 219, 110, 15);
		
		cocktailSort.setBounds(130, 219, 118, 15);
		frame.getContentPane().add(cocktailSort);

		lblCycleSort = new JLabel("Cycle sort:");
		lblCycleSort.setBounds(12, 246, 110, 15);
		
		cycleSort.setBounds(130, 246, 118, 15);
		frame.getContentPane().add(cycleSort);

		lblShellSort = new JLabel("ShellSort:");
		lblShellSort.setBounds(12, 273, 110, 15);
		
		shellSort.setBounds(130, 273, 118, 15);
		frame.getContentPane().add(shellSort);
		
		frame.getContentPane().add(lblQuickSorting);
		frame.getContentPane().add(lblHeapSort);
		frame.getContentPane().add(lblMergeSort);
		frame.getContentPane().add(lblInsertionSort);
		frame.getContentPane().add(lblSelectionSort);
		frame.getContentPane().add(lblBubbleSort);
		frame.getContentPane().add(lblOddevenSort);
		frame.getContentPane().add(lblCocktailSort);
		frame.getContentPane().add(lblCycleSort);
		frame.getContentPane().add(lblShellSort);
		frame.pack();
	}
}
