import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class StudentManager {
    ArrayList<Student> students = new ArrayList<>();
    ReaderAndWrite readerAndWrite = new ReaderAndWrite();
    Scanner scanner = new Scanner(System.in);

    public void add() {
        int id = (students.size() > 0) ? (students.size() + 1) : 1;
        System.out.println("student id + " + id);
        String name = inputName();
        byte age = inputAge();
        String address = inputAddress();
        String sex = inputSex();
        double gpa = inputGpa();
        Student student = new Student(id, name, age, sex, address, gpa);
        students.add(student);

    }

    private double inputGpa() {
        System.out.print("Nhập điểm số trung bình  :");
        while (true) {
            try {
                Double gpa = Double.parseDouble((scanner.nextLine()));
                if (gpa < 0 && gpa > 10) {
                    throw new NumberFormatException();
                }
                return gpa;
            } catch (NumberFormatException ex) {
                System.out.print("Không hợp lệ ! Vui lòng nhập lại điểm");
            }
        }
    }

    private String inputSex() {
        System.out.println("Nhập giới tính :  ");
        return scanner.nextLine();
    }

    private String inputAddress() {
        System.out.println("Nhập địa chỉ :");
        return scanner.nextLine();
    }


    private byte inputAge() {
        System.out.println("Nhập tuổi :");
        while (true) {
            try {
                byte age = Byte.parseByte((scanner.nextLine()));
                if (age < 0 && age > 100) {
                    throw new NumberFormatException();
                }
                return age;
            } catch (NumberFormatException ex) {
                System.out.print("không hợp lệ! Nhập tuổi học sinh vào một lần nữa:");
            }
        }
    }

    private String inputName() {
        System.out.println("Nhập tên :");
        return scanner.nextLine();
    }

    public void edit(int id) {
        boolean isExited = false;
        int size = students.size();
        for (int i = 0; i < size; i++) {
            if (students.get(i).getId() == id) {
                isExited = true;
                students.get(i).setName(inputName());
                students.get(i).setAge(inputAge());
                students.get(i).setSex(inputSex());
                students.get(i).setAddress(inputAddress());
                students.get(i).setGpg(inputGpa());
                break;
            }
        }
        if (!isExited) {
            System.out.printf("id = %d không tồn tại .\n", id);
        } else {
        }
    }

    public void delete(int id) {
        Student student = null;
        int size = students.size();
        for (int i = 0; i < size; i++) {
            if (students.get(i).getId() == id) {
                student = students.get(i);
                break;
            }
        }
        if (student != null) {
            students.remove(student);
        } else {
            System.out.printf("id = %id ntn existed.\n", id);
        }
    }

    public void sortStudentByName() {
        Collections.sort(students, new SortStudentByName());
    }

    public int inputId() {
        System.out.print("nhập id : ");
        while (true) {
            try {
                int id = Integer.parseInt(scanner.nextLine());
                return id;
            } catch (NumberFormatException ex) {
                System.out.print("không hợp lệ! Nhập ID sinh vào một lần nữa:");
            }
        }
    }

    public void sortStudentByGPA() {
        Collections.sort(students, new SortStudentByGPA());
    }

    public void sortStudentByGPA2() {
        Collections.sort(students, new SortStudentByGPA2());
    }

    public void show() {
        System.out.println("________________________________DANH SÁCH HỌC SINH______________________________________");
        System.out.printf("%-12s%-12s%-12s%-14s%-14s%s\n", "ID", "Tên", "Tuổi", "Giới tính", "Địa chỉ", "Điểm trung bình");
        for (Student st : students) {
            System.out.println("_______________________________________________________________________________________");
            System.out.printf("%-12s%-12s%-12s%-15s%-16s%s\n", st.getId(), st.getName(), st.getAge(), st.getSex(), st.getAddress(), st.getGpa());
        }
    }

    public void writes() {
        for (Student student : students) {
           System.out.println(student);
      }

  }
}

