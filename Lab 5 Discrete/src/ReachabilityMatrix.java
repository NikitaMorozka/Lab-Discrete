import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class ReachabilityMatrix extends JFrame {
	
    public ReachabilityMatrix() {
        setTitle("Матрица достижимости");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Запрос размера матрицы
        int size = Integer.parseInt(JOptionPane.showInputDialog("Введите размер матрицы:"));

        // Создание панели для размещения матриц
        JPanel panel = new JPanel(new GridLayout(2, 1));

        // Создание матрицы смежности
        int[][] adjacencyMatrix = new int[size][size];

        // Ввод элементов матрицы смежности
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                adjacencyMatrix[i][j] = Integer.parseInt(JOptionPane.showInputDialog("Элемент [" + i + "][" + j + "]:"));
            }
        }
        // Создание матрицы достижимости
        int[][] reachabilityMatrix = findReachabilityMatrix(adjacencyMatrix);

        // Отображение матриц смежности и достижимости
        panel.add(createMatrixPanel("Исходная матрица смежности", adjacencyMatrix));
        panel.add(createMatrixPanel("Матрица достижимости", reachabilityMatrix));

        add(panel);
        setSize(400, 400); // Устанавливаем размер окна
        setResizable(true);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // Функция для создания панели с отображением матрицы
    private JPanel createMatrixPanel(String title, int[][] matrix) {
        JPanel matrixPanel = new JPanel(new GridLayout(matrix.length, matrix[0].length));
        matrixPanel.setBorder(BorderFactory.createTitledBorder(title));

        // Заполнение панели элементами матрицы
        for (int[] row : matrix) {
            for (int value : row) {
                JLabel label = new JLabel(String.valueOf(value));
                label.setHorizontalAlignment(SwingConstants.CENTER);
                matrixPanel.add(label);
            }
        }
        return matrixPanel;
    }

    // Функция для нахождения матрицы достижимости
    private int[][] findReachabilityMatrix(int[][] adjacencyMatrix) {
        int size = adjacencyMatrix.length;
        int[][] reachabilityMatrix = new int[size][size];

        // Инициализация матрицы достижимости
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                reachabilityMatrix[i][j] = adjacencyMatrix[i][j];
            }
        }

        // Поиск путей достижимости через промежуточные вершины
        for (int k = 0; k < size; k++) {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (reachabilityMatrix[i][k] == 1 && reachabilityMatrix[k][j] == 1)
                        reachabilityMatrix[i][j] = 1;
                }
            }
        }

        return reachabilityMatrix;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ReachabilityMatrix::new);
    }
}
