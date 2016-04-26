package jChart;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Panel;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import org.jfree.data.category.DefaultCategoryDataset;

public class Display {

	public static final int width = 800;
	public static final int height = 650;

	public static JFrame frame;
	public static JTextField textField;
	public static Panel panel;
	public static JLabel insert;
	public static DefaultCategoryDataset dataset = new DefaultCategoryDataset();
	public static JButton sort;
	public static JComboBox comboBox;
	public static JButton statistic;
	public static JButton clear;
	public static JButton deleteAll;
	public static JLabel insertedNumbers;
	public static JLabel sortNum;
	public static JLabel sortLabel;
	
	public static JPanel viewPanel;
	public static JPanel helpPanel;
	
	public static JButton back;
	
	private static JScrollPane sortNumbers;
	
	private static JTextPane help;
	private String text;
	private ImageIcon ic;

	private JScrollPane scrollNumbers;

	public Display() {
		init();
		Engine.init();
	}

	public void init() {

		frame = new JFrame("Синтез и анализ на алгоритми");
		
		panel = new Panel();
		panel.setBounds(10, 180, 780, 460);
		panel.setLayout(new BorderLayout(0, 0));

		insertedNumbers = new JLabel("Въведени числа:");
		insertedNumbers.setHorizontalAlignment(SwingConstants.CENTER);
		insertedNumbers.setFont(new Font("Dialog", Font.BOLD, 14));
		insertedNumbers.setBounds(12, 20, 240, 36);
		insertedNumbers.setVisible(true);

		insert = new JLabel("");
		insert.setHorizontalAlignment(SwingConstants.CENTER);

		scrollNumbers = new JScrollPane();
		scrollNumbers.setViewportView(insert);
		scrollNumbers.setBounds(10, 66, 240, 36);
		scrollNumbers.setVisible(true);

		textField = new JTextField();
		textField.setBounds(10, 120, 240, 36);
		textField.setColumns(10);
		textField.setFocusable(true);
		textField.setVisible(true);

		statistic = new JButton("Статистика");
		statistic.setBounds(10, 120, 240, 36);
		statistic.setVisible(false);
		
		sortLabel = new JLabel("Сортирани числа:");
		sortLabel.setFont(new Font("Dialog", Font.BOLD, 14));
		sortLabel.setHorizontalAlignment(SwingConstants.CENTER);
		sortLabel.setBounds(340, 20, 230, 36);
		sortLabel.setVisible(true);
		
		sortNum = new JLabel("");
		sortNum.setHorizontalAlignment(SwingConstants.CENTER);
		
		sortNumbers = new JScrollPane();
		sortNumbers.setViewportView(sortNum);
		sortNumbers.setBounds(340, 66, 230, 36);
		sortNumbers.setVisible(true);
		
		String[] str = { "Quick sort", "Heap sort", "Merge sort", "Insertion sort", "Selection sort",
				"Bubble sort", "Odd-even sort", "Cocktail sort", "Cycle sort", "Shell sort" };
		comboBox = new JComboBox(str);
		comboBox.setSelectedIndex(0);
		comboBox.setBounds(340, 120, 230, 36);
		comboBox.setVisible(true);

		sort = new JButton("Сортирай");
		sort.setBounds(665, 120, 125, 36);
		sort.setVisible(true);

		clear = new JButton("Изчисти");
		clear.setBounds(665, 66, 125, 36);
		clear.setVisible(true);

		deleteAll = new JButton("Нулирай");
		deleteAll.setBounds(665, 12, 125, 36);
		deleteAll.setVisible(true);
		
		try {
			frame.setIconImage(ImageIO.read(ResourceLoader.load("resources/sort.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			ic = new ImageIcon(ImageIO.read(ResourceLoader.load("resources/back.png")));
			
			
			back = new JButton();
			back.setIcon(ic);
			back.setBounds(width/2, 10, ic.getIconWidth(), ic.getIconHeight());
			back.setVisible(true);
			
			back.setOpaque(false);
			back.setBorderPainted(false);
			back.setContentAreaFilled(false);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		text = new String("Това е помщно меню.\n"
				+ "Програмата показва различни методи за сортиране.\n"
				+ "Въвеждането става чрез натискането на копчето 'Enter' в текстовото поле.\n"
				+ "Позволено е въвеждането само на целочислени числа.\n"
				+ "След въвеждането на числата се избира даден алгоритъм за сортиране и се натиска бутона 'Сортирай'.\n"
				+ "Появява се бутон 'Статистика', който показва времето за изпълнение на алгоритъма.\n"
				+ "За да се изпробва нов алгоритъм, трябва да се натисне бутона 'Изчисти'\n"
				+ "Бутона 'Нулирай' позволява въвеждането на нова редица от числа.\n\n\n\n\n\n\n\n\n\n\n"
				+ "Александър Николаев Ковачев\n"
				+ "50 група, 501214024, ФКСУ");
		
		help = new JTextPane();
		help.setText(text);
		help.setBounds(0, 50 + ic.getIconHeight(), width, height);
		help.setEditable(false);
		help.setBackground(null);
		help.setBorder(javax.swing.BorderFactory.createEmptyBorder());
  
        SimpleAttributeSet bSet = new SimpleAttributeSet();
        StyleConstants.setAlignment(bSet, StyleConstants.ALIGN_CENTER);
        StyleConstants.setFontSize(bSet, 18);
		StyledDocument doc = help.getStyledDocument();
        doc.setParagraphAttributes(0, doc.getLength(), bSet, false);
		
		helpPanel = new JPanel();
		helpPanel.setBounds(0, 0, width, height);
		helpPanel.setLayout(null);
		helpPanel.setVisible(false);
		helpPanel.add(back);
		helpPanel.add(help);
		
		viewPanel = new JPanel();
		viewPanel.setBounds(0, 0, 800, 170);
		viewPanel.setLayout(null);
		viewPanel.add(textField);
		viewPanel.add(sort);
		viewPanel.add(comboBox);
		viewPanel.add(clear);
		viewPanel.add(deleteAll);
		viewPanel.add(insertedNumbers);
		viewPanel.add(scrollNumbers);
		viewPanel.add(sortLabel);
		viewPanel.add(sortNumbers);
		viewPanel.add(statistic);
		
		frame.getContentPane().add(viewPanel);
		frame.getContentPane().add(panel);
		frame.getContentPane().add(helpPanel);
		
		frame.setMinimumSize(new Dimension(width, height));
		frame.setPreferredSize(new Dimension(width, height));
		frame.setFocusable(true);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		frame.setVisible(true);
	}
}
