//import java.io.*;
//import java.util.ArrayList;
//
//public class ReaderAndWrite {
//    public void write(ArrayList<Student> students) {
//        File file = new File("student.csv");
//        try {
//            FileWriter fileWriter = new FileWriter(file);
//            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
//            for (Student s : students) {
//                bufferedWriter.write(s.write());
//                bufferedWriter.newLine();
//            }
//            bufferedWriter.close();
//            fileWriter.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//
//    }
//
//    public void reader(ArrayList<Student> students) {
//        File file = new File("student.csv");
//        try {
//            FileReader fileReader = new FileReader(file);
//            BufferedReader bufferedReader = new BufferedReader(fileReader);
//            String str = bufferedReader.readLine();
//            while (str != null) {
//                String[] arr = str.split(" ");
//                int id = Integer.parseInt(arr[0]);
//                String name = arr[1];
//                byte age = Byte.parseByte(arr[2]);
//                String sex = arr[3];
//                String address = arr[4];
//                double Gpa = Double.parseDouble(arr[6]);
//
//                for (Student st: students) {
//                    if(st.getName().equals(name)){
//                       students.add(new Student(id,name,age,sex,address,Gpa));
//                    }
//                }
//                str = bufferedReader.readLine();
//            }
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }catch (ArrayIndexOutOfBoundsException e){
//            e.printStackTrace();
//        }
//    }
//}