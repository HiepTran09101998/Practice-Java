package Praction;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class studentViews {
    int n;
    final int sen = 4;
    Scanner input = new Scanner(System.in);
    studentController uc = new studentController();
    ArrayList<student> studentsLíst = new ArrayList<>();

    public static void main(String[] args) {
        studentViews views = new studentViews();
        views.studentsview();
    }

    public void menu() {
        System.out.println("1.Add student records");
        System.out.println("2.Display sutdent records");
        System.out.println("3.Save");
        System.out.println("4.Exit");
    }

    public void studentsview() {
        studentViews views = new studentViews();
        views.menu();

        n = input.nextInt();
        while (n != sen) {
            switch (n) {
                case 1:
                    views.addStudents();
                    break;
                case 2:
                    views.displayStudents();
                    break;
                case 3:
                    views.saveStudents();
            }
            views.menu();
            n = input.nextInt();
        }
        System.out.println("Stop...");
    }

    public void addStudents() {
        System.out.println("Enter Student ID: ");
        String id = input.nextLine();

        System.out.println("Enter Student Name: ");
        String name = input.nextLine();

        System.out.println("Enter Student Address: ");
        String address = input.nextLine();

        System.out.println("Enter Student Phone: ");
        String phone = input.next();

        student students = new student(id, name, address, phone);
        studentsLíst.add(new student(students.getId(), students.getName(), students.getAddress(), students.getPhone()));
        System.out.println("Add Success");
    }

    public void displayStudents() {
        System.out.println("List Students");
        Iterator<student> StudentsIterator =  studentsLíst.iterator();
        while (StudentsIterator.hasNext()){
            student st1 = StudentsIterator.next();
            System.out.println(st1);
        }
    }

    public void saveStudents() {
        Iterator<student> StudentsIterator = studentsLíst.iterator();
        while (StudentsIterator.hasNext()) {
            student st1 = StudentsIterator.next();
            uc.insertStudent(st1);
        } uc.selectStudent();
    }
}
