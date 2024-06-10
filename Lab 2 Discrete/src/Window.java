
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
import javax.swing.AbstractButton;
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
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.UIManager;
import java.awt.Font;

	public class Window {

		private JFrame frame;
		private JLabel resultLabel;
		/**
		 * Launch the application.
		 */
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						Window window = new Window();
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
		public Window() {
			initialize();
		}

		/**
		 * Initialize the contents of the frame.
		 */
		private void initialize() {
			frame = new JFrame();
			frame.getContentPane().setBackground(new Color(255, 250, 240));
			frame.setBackground(new Color(255, 255, 255));
			frame.setTitle("Вторая лабораторная работа ");
			frame.setBounds(100, 100, 451, 399);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().setLayout(null);
			
			JTextArea textArea = new JTextArea();
			textArea.setTabSize(6);
			textArea.setForeground(new Color(0, 0, 0));
			textArea.setFont(new Font("Monospaced", Font.PLAIN, 16));
			textArea.setBackground(new Color(255, 255, 255));
			textArea.setBounds(183, 23, 226, 159);
			frame.getContentPane().add(textArea);
			
			JButton btnNewButton = new JButton("<html> Выполнить <br> операции </html>");
			btnNewButton.setForeground(new Color(0, 0, 0));
			btnNewButton.setBackground(new Color(255, 255, 255));
			btnNewButton.setToolTipText("");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnNewButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					//AbstractButton textArea;
					ArrayOperation operations = new ArrayOperation (textArea.getText());//?
	 
					if (operations.validate()) {
				        	resultLabel.setText("<html>Отлично!<br>"
				          + (operations.isReflexive() ? "Матрица рефлексивна.<br>" : "Матрица не рефлексивна.<br>")
				          + (operations.isSymmetric() ? "Матрица симметрична.<br>" : "Матрица не симметрична.<br>")
				          + (operations.isAntisymmetric() ? "Матрица кососимметрична.<br>" : "Матрица не кососимметрична.<br>")
				          + (operations.isTransitive() ? "Матрица транзитивна.<br>" : "Матрица не транзитивна.<br>")
				          + "</html>");
				    } else {
				        resultLabel.setText("Ошибка матрицы");
				    }
				}
			});
			
			btnNewButton.setBounds(10, 39, 131, 106);
			frame.getContentPane().add(btnNewButton);
			resultLabel = new JLabel("");
			resultLabel.setForeground(new Color(0, 0, 0));
			resultLabel.setBackground(Color.BLACK);
			resultLabel.setVerticalAlignment(SwingConstants.TOP);
			resultLabel.setToolTipText("");
			resultLabel.setBounds(10, 193, 415, 156);
			frame.getContentPane().add(resultLabel);
			
			
		}
	}

