import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void showMenu() {
        System.out.println("_______________Menu_____________");
        System.out.println("1. Danh sách sinh viên");
        System.out.println("2. Thêm sinh viên");
        System.out.println("3. Chỉnh sửa  sinh viên");
        System.out.println("4. Xóa sinh viên");
        System.out.println("5 Sắp xếp ");
        System.out.println("6. Đọc từ file");
        System.out.println("7. Ghi từ file");
        System.out.println("8 Exit");
        System.out.println("__________________________________");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer choose = null;
        boolean exit = false;
        StudentManager studentManager = new StudentManager();
        int studentId;
        showMenu();
        while (true) {
            choose = scanner.nextInt();
            switch (choose) {
                case 1:
                    studentManager.show();
                    break;
                case 2:
                    studentManager.add();
                    break;
                case 3:
                    studentId = studentManager.inputId();
                    studentManager.edit(studentId);
                    break;
                case 4:
                    studentId = studentManager.inputId();
                    studentManager.delete(studentId);
                    break;
                case 5: {
                    System.out.println("___Sắp Xếp sinh viên theo điểm trung bình___");
                    System.out.println("1. Sắp xếp điểm trung bình tăng dần");
                    System.out.println("2. Sắp xếp điểm trung bình giảm dần");
                    System.out.println("3. Thoát");
                    int choice = scanner.nextInt();
                    switch (choice) {
                        case 1:
                            studentManager.sortStudentByGPA();
                            break;
                        case 2:
                            studentManager.sortStudentByGPA2();
                            break;
                        case 3:
                            showMenu();
                            break;
                    }
                }
                case 6:
                    studentManager.students = studentManager.readerAndWrite.reader();
                    System.out.println("đọc file thành công ");
                    break;
                case 7:
                    studentManager.readerAndWrite.write(studentManager.students);
                    System.out.println("Ghi file thành công");
                    break;
                case 8:
                    System.out.println("Good bye ^_^");
                    exit = true;
                default:
                    break;
            }
            if (exit) {
                break;
            }
            showMenu();
        }
    }
}