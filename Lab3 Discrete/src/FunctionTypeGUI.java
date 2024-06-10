import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.awt.Font;
import java.awt.Color;

public class FunctionTypeGUI {

    private JFrame frame;
    private JTextField inputField;
    private JButton processButton;
    private JTextArea resultArea;
    private JTextField textField;
    private JTextField textField_1;

    private void showError(String errorMessage) {
        resultArea.setText(errorMessage);
    }

    public FunctionTypeGUI() {
        frame = new JFrame("Function Type Checker");
        frame.getContentPane().setBackground(Color.ORANGE);
        frame.setSize(541, 373);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        inputField = new JTextField();
        inputField.setFont(new Font("Tahoma", Font.PLAIN, 18));
        inputField.setBounds(114, 136, 335, 40);

        processButton = new JButton(" ПУСК");
        processButton.setForeground(new Color(0, 0, 0));
        processButton.setBackground(new Color(255, 255, 255));
        processButton.setBounds(156, 201, 245, 30);
        processButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = inputField.getText();
                String numbers = textField_1.getText(); // Получаем числа из textField_1
                String letters = textField.getText(); // Получаем буквы из textField

                HashMap<Integer, Character> dictionary = new HashMap<>();

                // Создаем отображение чисел из textField_1 на буквы из textField
                String[] numberArray = numbers.split(" ");
                String[] letterArray = letters.split(" ");
                
                HashSet<Integer> seenNumbers = new HashSet<>();
                for (String pair : input.split(" ")) {
                    int number = Integer.parseInt(pair.substring(0, pair.length() - 1));
                    char value = pair.charAt(pair.length() - 1);
                    if (!seenNumbers.add(number)) {
                        showError("Ошибка: Не функция!");
                        return;
                    }
                    dictionary.put(number, value);
                }
                boolean isInjection = checkInjection(dictionary, numberArray, letterArray);
                boolean isSurjection = checkSurjection(dictionary, numberArray, letterArray);
                boolean isBijection = checkBijection(dictionary, numberArray, letterArray);
                
                if (isBijection) {
                    resultArea.setText(" Результат: Биекция");
                } else if (isSurjection) {
                    resultArea.setText(" Результат: Сюръекция");
                } else if (isInjection) {
                    resultArea.setText(" Результат: Инъекция");
                } else {
                    resultArea.setText(" Функция не имеет свойств");
                }
            }
        });

        resultArea = new JTextArea();
        resultArea.setFont(new Font("Arial", Font.PLAIN, 18));
        resultArea.setBounds(10, 256, 505, 64);
        resultArea.setEditable(false);

        frame.getContentPane().add(inputField);
        frame.getContentPane().add(processButton);
        frame.getContentPane().add(resultArea);

        frame.getContentPane().setLayout(null);

        textField = new JTextField();
        textField.setFont(new Font("Tahoma", Font.PLAIN, 18));
        textField.setBounds(114, 87, 335, 40);
        frame.getContentPane().add(textField);

        textField_1 = new JTextField();
        textField_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        textField_1.setBounds(114, 36, 335, 40);
        frame.getContentPane().add(textField_1);

        JLabel lblNewLabel = new JLabel("Множество A");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel.setBounds(10, 50, 94, 14);
        frame.getContentPane().add(lblNewLabel);

        JLabel lblB = new JLabel("Множество B");
        lblB.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblB.setBounds(10, 101, 94, 14);
        frame.getContentPane().add(lblB);

        JLabel lblB_1 = new JLabel("Пары AB");
        lblB_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblB_1.setBounds(20, 144, 64, 26);
        frame.getContentPane().add(lblB_1);
        frame.setVisible(true);
    }

    public boolean checkInjection(HashMap<Integer, Character> map, String[] numberArray, String[] letterArray) {
        //количество букв больше, чем количество чисел
        if (letterArray.length <= numberArray.length) {
            return false;
        }
        HashSet<Character> seenValues = new HashSet<>();
        HashSet<Integer> seenKeys = new HashSet<>();
        for (Map.Entry<Integer, Character> entry : map.entrySet()) {
            if (!seenKeys.add(entry.getKey()) || !seenValues.add(entry.getValue())) {
                return false; // Если ключ или значение уже встречались ранее, то это не инъекция
            }
        }
        return true; 
    }

    public boolean checkSurjection(HashMap<Integer, Character> map, String[] numberArray, String[] letterArray) {
        // количество букв меньше, чем количество чисел
        if (letterArray.length >= numberArray.length) {
            return false;
        }
        HashSet<Character> seenValues = new HashSet<>();
        HashSet<Integer> seenNumbers = new HashSet<>();
        for (Map.Entry<Integer, Character> entry : map.entrySet()) {
            char value = entry.getValue();
            int key = entry.getKey();
            if (!seenValues.add(value)) {
                continue; // Пропускаем, если значение уже встречалось ранее
            } 
            if (!seenNumbers.add(key)) {
                return false; // Если хотя бы одно численное значение повторяется в парах, это не сюръекция
            }
        }  
        
        // Проверка, что у каждой буквы есть соответствующее численное значение
        HashSet<Character> uniqueLetters = new HashSet<>();
        for (String letter : letterArray) {
            uniqueLetters.add(letter.charAt(0));
        }
        for (char letter : uniqueLetters) {
            boolean foundMatch = false;
            for (Map.Entry<Integer, Character> entry : map.entrySet()) {
                if (entry.getValue() == letter) {
                    foundMatch = true;
                    break;
                }
            }
            if (!foundMatch) {
                return false; // Если для какой-то буквы нет соответствующего численного значения, это не сюръекция
            }
        }
        return true; 
    }
    
    public boolean checkBijection(HashMap<Integer, Character> map, String[] numberArray, String[] letterArray) {
        // Проверка, что количество чисел равно количеству букв
        if (numberArray.length != letterArray.length) {
            return false;
        }
        // Проверка на равенство множеств чисел и букв
        HashSet<Integer> numbersSet = new HashSet<>();
        HashSet<Character> lettersSet = new HashSet<>();
        for (String number : numberArray) {
            numbersSet.add(Integer.parseInt(number));
        }
        for (String letter : letterArray) {
            lettersSet.add(letter.charAt(0));
        }
        if (!numbersSet.equals(map.keySet()) || !lettersSet.equals(new HashSet<>(map.values()))) {
            return false;
        }
      //   Проверка, что каждому числу соответствует уникальная буква
        HashSet<Character> seenValues = new HashSet<>();
        for (char value : map.values()) {
            if (!seenValues.add(value)) {
                return false; // Если значение повторяется, это не биекция
            }
        }
        return true;
    }
    
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new FunctionTypeGUI();
            }
        });
    }
}
