package studentapp;

import java.util.ArrayList;
import java.util.List;

class Student {
    String name;
    String group;
    int course;
    List<Integer> grades;

    // Конструктор для инициализации объекта Student
    public Student(String name, String group, int course, List<Integer> grades) {
        this.name = name;
        this.group = group;
        this.course = course;
        this.grades = grades;
    }

    // Метод для подсчёта среднего балла
    public double getAverageGrade() {
        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return (double) sum / grades.size();
    }

    // Метод для перевода студента на следующий курс
    public void promoteToNextCourse() {
        course++;
    }

    // Метод для удаления студентов со средним баллом < 3
    public static void removeLowGradeStudents(List<Student> students) {
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            if (student.getAverageGrade() < 3) {
                students.remove(i);
                i--; // Смещаем индекс на один назад, чтобы не пропустить следующий элемент
            } else {
                student.promoteToNextCourse();
            }
        }
    }

    // Метод для вывода студентов, находящихся на определённом курсе
    public static void printStudents(List<Student> students, int course) {
        for (Student student : students) {
            if (student.course == course) {
                System.out.println(student.name);
            }
        }
    }

    // Тестирование программы
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();

        // Добавляем студентов в список
        students.add(new Student("Kirill", "BAS-1", 1, List.of(4, 3, 5)));
        students.add(new Student("Ivan", "BAS-2", 1, List.of(2, 2, 2)));
        students.add(new Student("Amina", "BAS-1", 2, List.of(3, 4, 3)));
        students.add(new Student("Sabr", "BAS-2", 1, List.of(5, 4, 5)));
        students.add(new Student("Anya", "BAS-1", 1, List.of(2, 4, 5)));
        // Удаляем студентов со средним баллом < 3 и переводим остальных на следующий курс
        Student.removeLowGradeStudents(students);

        // Печатаем студентов, находящихся на 2 курсе
        Student.printStudents(students, 2);
    }
}
