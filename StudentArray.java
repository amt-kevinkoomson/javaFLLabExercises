import java.util.Arrays;
import java.util.Objects;

public class StudentArray {
    public String[] students;
    public StudentArray(String[] students){
        this.students = students;
    }

    public void addStudent(String student) {
        String[] newStudents = Arrays.copyOf( students, students.length+1);
        newStudents[newStudents.length -1] =  student;
        students = newStudents;
    }

    public void searchStudent (String search) {
        for(String student : students) {
            if (Objects.equals(search, student)) {
                System.out.println(student + " found\n");
            }
        }
    }

    public void deleteStudent (String student) {
        int index = findStudent(student);
        if(index!=-1){
            String[] newStudents = new String[students.length - 1];
            for(int i = 0; i<(students.length - 1); i++) {
                if(i==index) continue;
                newStudents[i] = students[i];
            }
            students=newStudents;
        } else System.out.println("not found");
    }

    public int findStudent (String student) {
        for(int i = 0; i < students.length; i++) {
            if (Objects.equals(students[i], student)) {
                System.out.println(student + " found\n");
                return i;
            }
        }
        System.out.println(student + " not found\n");
        return -1;
    }

    public void printStudents () {
        for(String student : students) {
            System.out.println(student);
        }
        System.out.println("\n");
    }

    public static void main(String...args){
        StudentArray studentArray = new StudentArray(new String[]{"Kevin", "Nana", "Jane", "John", "Yoyo"});
        // find student
//        System.out.println(studentArray.findStudent("Joe"));
        // add student
//        studentArray.addStudent("Joe");
        // print students
//        studentArray.printStudents();
        // remove student
        studentArray.deleteStudent("Yoyo");
        // print students
        studentArray.printStudents();
    }
}
