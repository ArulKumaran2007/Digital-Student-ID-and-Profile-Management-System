import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

class Student {
    String id, name, course, batch, bloodGroup;

    Student(String id, String name, String course, String batch, String bloodGroup) {
        this.id = id;
        this.name = name;
        this.course = course;
        this.batch = batch;
        this.bloodGroup = bloodGroup;
    }

    public String toString() {
        return id + "  " + name + "  " + course + "  " + batch + "  " + bloodGroup;
    }
}

public class StudentIDSystem extends JFrame implements ActionListener {

    JTextField idField, nameField, courseField, batchField, bloodField;
    JTextArea display;
    JButton addBtn, showBtn;

    ArrayList<Student> list = new ArrayList<>();

    StudentIDSystem() {

        setTitle("Digital Student ID System");

        setLayout(new FlowLayout());

        add(new JLabel("Student ID"));
        idField = new JTextField(15);
        add(idField);

        add(new JLabel("Name"));
        nameField = new JTextField(15);
        add(nameField);

        add(new JLabel("Course"));
        courseField = new JTextField(15);
        add(courseField);

        add(new JLabel("Batch"));
        batchField = new JTextField(15);
        add(batchField);

        add(new JLabel("Blood Group"));
        bloodField = new JTextField(15);
        add(bloodField);

        addBtn = new JButton("Add Student");
        showBtn = new JButton("Show Students");

        add(addBtn);
        add(showBtn);

        display = new JTextArea(10,30);
        add(new JScrollPane(display));

        addBtn.addActionListener(this);
        showBtn.addActionListener(this);

        setSize(400,400);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==addBtn) {

            Student s = new Student(
                    idField.getText(),
                    nameField.getText(),
                    courseField.getText(),
                    batchField.getText(),
                    bloodField.getText()
            );

            list.add(s);

            JOptionPane.showMessageDialog(this,"Student Added");
        }

        if(e.getSource()==showBtn) {

            display.setText("");

            for(Student s : list) {
                display.append(s.toString()+"\n");
            }

        }
    }

    public static void main(String[] args) {
        new StudentIDSystem();
    }
}