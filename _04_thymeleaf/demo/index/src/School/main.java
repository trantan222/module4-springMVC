package School;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class main {
    public static void main(String[] args) {
        StudentManager studentManager = new StudentManager("students.txt");
        studentManager.load();

        JFrame frame = new JFrame("Student Management System");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel, studentManager);

        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel, StudentManager studentManager) {
        panel.setLayout(null);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(10, 20, 80, 25);
        panel.add(nameLabel);

        JTextField nameText = new JTextField(20);
        nameText.setBounds(100, 20, 165, 25);
        panel.add(nameText);

        JLabel idLabel = new JLabel("ID:");
        idLabel.setBounds(10, 50, 80, 25);
        panel.add(idLabel);

        JTextField idText = new JTextField(20);
        idText.setBounds(100, 50, 165, 25);
        panel.add(idText);

        JButton addButton = new JButton("Add");
        addButton.setBounds(10, 80, 80, 25);
        panel.add(addButton);

        JTextArea textArea = new JTextArea();
        textArea.setBounds(10, 110, 300, 100);
        panel.add(textArea);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameText.getText();
                String id = idText.getText();
                Student student = new Student(name, id);
                studentManager.addStudent(student);
                textArea.setText("");
                for (Student s : studentManager.getStudents()) {
                    textArea.append(s.toString() + "\n");
                }
            }
        });
    }
}

