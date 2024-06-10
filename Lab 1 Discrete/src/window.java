
import java.awt.EventQueue;

import javax.swing.JFrame;


	import java.awt.EventQueue;
	import javax.swing.JFrame;
	import javax.swing.JButton;
	import java.awt.BorderLayout;
	import java.awt.event.ActionListener;
	import java.awt.event.ActionEvent;
	import javax.swing.JTextField;
	import java.awt.GridLayout;
	import javax.swing.JLabel;
	import javax.swing.JCheckBox;
	import javax.swing.BoxLayout;
	import net.miginfocom.swing.MigLayout;
	import java.awt.CardLayout;
	import javax.swing.JPanel;
	import javax.swing.SwingConstants;
	import javax.swing.JTextPane;
	import javax.swing.JTextArea;
	import com.jgoodies.forms.factories.DefaultComponentFactory;
	import java.awt.event.MouseAdapter;
	import java.awt.event.MouseEvent;
	import java.awt.Color;

	public class window {

		private JFrame frame;
		private JTextField inputArrayA;
		private JTextField inputArrayB;
		private JLabel resultLabel;
		/**
		 * Launch the application.
		 */
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						window window = new window();
						window.frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}

		/**
		 * Create the application.
		 */
		public window() {
			initialize();
		}

		/**
		 * Initialize the contents of the frame.
		 */
		private void initialize() {
			frame = new JFrame();
			frame.getContentPane().setBackground(new Color(65, 105, 225));
			frame.setBackground(new Color(255, 255, 255));
			frame.setTitle("Первая лабораторная работа ");
			frame.setBounds(100, 100, 451, 399);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().setLayout(null);
			
			inputArrayA = new JTextField();
			inputArrayA.setBackground(new Color(245, 255, 250));
			inputArrayA.setBounds(128, 71, 219, 27);
			frame.getContentPane().add(inputArrayA);
			inputArrayA.setColumns(10);
			
			inputArrayB = new JTextField();
			inputArrayB.setBackground(new Color(245, 255, 250));
			inputArrayB.setColumns(10);
			inputArrayB.setBounds(128, 109, 219, 26);
			frame.getContentPane().add(inputArrayB);
			
			JButton btnNewButton = new JButton("Выполнить операциии");
			btnNewButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					arrayOperation operations = new arrayOperation (inputArrayA.getText(),inputArrayB.getText());
	 
					if (operations.validate()) {
						resultLabel.setText("<html>Объединение: " + operations.union() + 
										"<br/> <html>Пересечение: " + operations.intersection() +
										"<br/> <html>Дополнение A/B: " + operations.additionA()+ 
										"<br/> <html>Дополнение B/A: " + operations.additionB()+
										"<br/> <html>Семмитрическая разность: " + operations.unionAB()+
										"</html>");
					}
					
					else {
						resultLabel.setText("Ошибка обработки массивов");
					}
				}
			});
			
			btnNewButton.setBounds(128, 162, 219, 29);
			frame.getContentPane().add(btnNewButton);
			
			JLabel lblArrayA = new JLabel("Множество А");
			lblArrayA.setBounds(6, 76, 120, 16);
			frame.getContentPane().add(lblArrayA);

			JLabel lblArrayB = new JLabel("Множество Б");
			lblArrayB.setBounds(6, 114, 120, 16);
			frame.getContentPane().add(lblArrayB);

			
			resultLabel = new JLabel("");
			resultLabel.setVerticalAlignment(SwingConstants.TOP);
			resultLabel.setToolTipText("");
			resultLabel.setBounds(6, 267, 439, 98);
			frame.getContentPane().add(resultLabel);
		}
	}

