package Database;

import java.sql.*;

public class Employees_DAO {

    //    ------------------ 직원차량 조회 -------------------------

    // 1. Emp_ID 리턴
    public static int outempID() {
        // 홈페이지에서 입력한 차 번호로 받아와야함.
        String inputnum = Employees_DTO.getEmpCar_number();
        ResultSet emp_ID;
        int result = 0;

        try {
            Connection con;
            PreparedStatement pstmt = null;

            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Mini_Project?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Asia/Seoul", "root", "gustjr12");
            String sql = "SELECT Emp_ID FROM Employees WHERE EmpCar_Number = ?";
            pstmt = con.prepareStatement(sql);

            pstmt.setString(1, inputnum);

            emp_ID = pstmt.executeQuery();

            while (emp_ID.next()) {
                result = emp_ID.getInt("Emp_ID");
            }

            pstmt.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("오류 : " + e);
        } catch (ClassNotFoundException e) {
            System.out.println("드라이버가 존재하지 않습니다." + e);
        }
        return result;
    }

    // 2. Emp_Name 리턴
    public static String outEmpName() {
        // 홈페이지에서 입력한 직원차 번호로 받아옴.
        String inputnum = Employees_DTO.getEmpCar_number();
        ResultSet emp_ID;
        String result = "";

        try {
            Connection con;
            PreparedStatement pstmt = null;

            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Mini_Project?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Asia/Seoul", "root", "gustjr12");
            String sql = "SELECT Emp_name FROM Employees WHERE EmpCar_Number = ?";
            pstmt = con.prepareStatement(sql);

            pstmt.setString(1, inputnum);

            emp_ID = pstmt.executeQuery();

            while (emp_ID.next()) {
                result = emp_ID.getString("Emp_name");
            }

            pstmt.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("오류 : " + e);
        } catch (ClassNotFoundException e) {
            System.out.println("드라이버가 존재하지 않습니다." + e);
        }
        return result;
    }


    //    ------------------ 직원차량 등록 -------------------------

    public static void addEmp() {
        String emp_name = Employees_DTO.getEmp_name();
        String empcar_number = Employees_DTO.getEmpCar_number();

        try {
            Connection con;
            PreparedStatement pstmt = null;

            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Mini_Project?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Asia/Seoul", "root", "gustjr12");
            String sql = "INSERT INTO Employees (Emp_name, EmpCar_Number) VALUES (?, ?)";
            pstmt = con.prepareStatement(sql);

            pstmt.setString(1, emp_name);
            pstmt.setString(2, empcar_number);
            pstmt.executeUpdate();

            pstmt.close();
            con.close();
            System.out.println("데이터가 DB에 정상적으로 추가되었습니다.");
        } catch (
                SQLException e) {
            System.out.println("오류 : " + e);
        } catch (ClassNotFoundException e) {
            System.out.println("드라이버가 존재하지 않습니다." + e);
        }
    }

    //    ------------------ 직원차량정보 수정 -------------------------

    public static void updateEmp() {
        int emp_ID = Employees_DTO.getEmp_ID();
        String emp_name = Employees_DTO.getEmp_name();
        String empcar_number = Employees_DTO.getEmpCar_number();

        try {
            Connection con;
            PreparedStatement pstmt = null;

            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Mini_Project?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Asia/Seoul", "root", "gustjr12");
            String sql = "UPDATE Employees SET Emp_name = ?, EmpCar_Number = ? WHERE Emp_ID = ?";
            pstmt = con.prepareStatement(sql);

            pstmt.setString(1, emp_name);
            pstmt.setString(2, empcar_number);
            pstmt.setInt(3, emp_ID);
            pstmt.executeUpdate();

            pstmt.close();
            con.close();
            System.out.println("데이터가 DB에 정상적으로 추가되었습니다.");
        } catch (SQLException e) {
            System.out.println("오류 : " + e);
        } catch (ClassNotFoundException e) {
            System.out.println("드라이버가 존재하지 않습니다." + e);
        }
    }

//    ------------------ 직원차량 삭제 -------------------------
public static void deleteEmp() {
    String empcar_number = Employees_DTO.getEmpCar_number();

    try {
        Connection con;
        PreparedStatement pstmt = null;

        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Mini_Project?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Asia/Seoul", "root", "gustjr12");
        String sql = "DELETE FROM Employees WHERE Empcar_Number = ?";
        pstmt = con.prepareStatement(sql);

        pstmt.setString(1, empcar_number);
        pstmt.executeUpdate();

        pstmt.close();
        con.close();
        System.out.println("데이터가 DB에 정상적으로 삭제되었습니다.");
    } catch (
            SQLException e) {
        System.out.println("오류 : " + e);
    } catch (ClassNotFoundException e) {
        System.out.println("드라이버가 존재하지 않습니다." + e);
    }
}
}
