import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class NewClass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManager manager = new StudentManager();

        System.out.print("Nhap so luong sinh vien ");
        int soLuongHocSinh = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < soLuongHocSinh; i++) {
            System.out.println("nhap thong tin cho sinh vien thu " + (i + 1));
            System.out.print("ID: ");
            int id = scanner.nextInt();
            scanner.nextLine(); 
            System.out.print("Ten: ");
            String name = scanner.nextLine();
            System.out.print("Diem: ");
            double diem = scanner.nextDouble();
            manager.addStudent(new Student(id, name, diem));
        }

        int choice;
        do {
            System.out.println("Menu:");
            System.out.println("1. Hien thi danh sach sinh vien");
            System.out.println("2. Them sinh vien");
            System.out.println("3. Sua thong tin sinh vien");
            System.out.println("4. Xoa sinh vien");
            System.out.println("5. Tim kiem sinh vien theo ID");
            System.out.println("6. Thoat");
            System.out.print("Chon: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    manager.displayStudents();
                    break;
                case 2:
                    System.out.print("Nhap ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Nhap ten: ");
                    String name = scanner.nextLine();
                    System.out.print("Nhap diem: ");
                    double diem = scanner.nextDouble();
                    manager.addStudent(new Student(id, name, diem));
                    break;
                case 3:
                    System.out.print("Nhap ID cua sinh vien can sua: ");
                    id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Nhap ten moi: ");
                    name = scanner.nextLine();
                    System.out.print("Nhap diem moi: ");
                    diem = scanner.nextDouble();
                    manager.editStudent(id, name, diem);
                    break;
                case 4:
                    System.out.print("Nhap ID cua sinh vien can xoa: ");
                    id = scanner.nextInt();
                    manager.deleteStudent(id);
                    break;
                case 5:
                    System.out.print("Nhap ID cua sinh vien can tim: ");
                    id = scanner.nextInt();
                    Student found = manager.findStudent(id);
                    if (found != null) {
                        System.out.println(found);
                    } else {
                        System.out.println("Khong tim thay siinh vien voi ID " + id);
                    }
                    break;
                case 6:
                    System.out.println("Thoat chuong trinh. ");
                    break;
                default:
                    System.out.println("Lua chon khong hop le.");
            }
        } while (choice != 7);

        scanner.close();
    }
}

class Student {
    private int id;
    private String name;
    private double diem;
    private String rank;

    public Student(int id, String name, double diem) {
        this.id = id;
        this.name = name;
        this.diem = diem;
        this.rank = xepHang(diem);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDiem() {
        return diem;
    }

    public void setDiem(double diem) {
        this.diem = diem;
        this.rank = xepHang(diem); 
    }

    public String getRank() {
        return rank;
    }

    private String xepHang(double diem) {
        if (diem < 5.0) {
            return "That Bai";
        } else if (diem < 6.5) {
            return "Trung binh";
        } else if (diem < 7.5) {
            return "Tot";
        } else if (diem < 9.0) {
            return "Rat tot";
        } else {
            return "Xuat sac";
        }
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Diem: " + diem + ", Rank: " + rank;
    }
}

class StudentManager {
    private ArrayList<Student> students;

    public StudentManager() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void editStudent(int id, String name, double diem) {
        for (Student student : students) {
            if (student.getId() == id) {
                student.setName(name);
                student.setDiem(diem);
                return;
            }
        }
        System.out.println("Khong tim thay sinh vien voi ID " + id);
    }

    public void deleteStudent(int id) {
        students.removeIf(student -> student.getId() == id);
    }

    public void sortStudents() {
        Collections.sort(students, Comparator.comparingDouble(Student::getDiem).reversed());
    }

    public Student findStudent(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    public void displayStudents() {
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
