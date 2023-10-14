package School;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StudentManager {
    private List<Student> students;
    private String filename;

    public StudentManager(String filename) {
        this.filename = filename;
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
        save();
    }

    public List<Student> getStudents() {
        return students;
    }

    private void save() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(students);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void load() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            students = (List<Student>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void printAllStudents() {
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
