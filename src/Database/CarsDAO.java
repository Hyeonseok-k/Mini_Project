package Database;

import java.sql.*;
import java.util.ArrayList;

public class CarsDAO {

//    ------------------입 차 -------------------------

    // 차량번호 입력후 Cars 테이블에 데이터 추가 메소드
    public static void addCar() {
        String num = CarsDTO.getCar_Number();
        boolean isEmpCar = CarsDTO.is_Employees_car();

        try {
            Connection con;
            PreparedStatement pstmt = null;

            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Mini_Project?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Asia/Seoul", "root", "gustjr12");
            String sql = "INSERT INTO Cars (Car_Number, is_employees_Car) VALUES (?, ?)";
            pstmt = con.prepareStatement(sql);

            pstmt.setString(1, num);
            pstmt.setBoolean(2, isEmpCar);

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

    // 직원차량조회
    public static int enterEmpCar() {
        // 홈페이지에서 입력한 차 번호로 받아와야함.
        String num = CarsDTO.getCar_Number();
        ResultSet Cars_ID;
        int result = 0;

        try {
            Connection con;
            PreparedStatement pstmt = null;

            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Mini_Project?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Asia/Seoul", "root", "gustjr12");
            String sql = "SELECT EXISTS(SELECT EmpCar_Number FROM Employees WHERE EmpCar_Number = ?) AS SUCCESS";
            pstmt = con.prepareStatement(sql);

            pstmt.setString(1, num);

            Cars_ID = pstmt.executeQuery();

            while (Cars_ID.next()) {
                result = Cars_ID.getInt("SUCCESS");
            }
            System.out.println(result);
            pstmt.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("오류 : " + e);
        } catch (ClassNotFoundException e) {
            System.out.println("드라이버가 존재하지 않습니다." + e);
        }
        return result;
    }

    // 이미 입차된 차량인지 확인
    public static int isExist() {
        int carNum = outCars_ID();
        ResultSet Cars_ID;
        int result = 0;

        try {
            Connection con;
            PreparedStatement pstmt = null;

            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Mini_Project?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Asia/Seoul", "root", "gustjr12");
            String sql = "SELECT EXISTS(SELECT Cars_ID FROM Car_Park WHERE Cars_ID = ?) AS SUCCESS";
            pstmt = con.prepareStatement(sql);

            pstmt.setInt(1, carNum);

            Cars_ID = pstmt.executeQuery();

            while (Cars_ID.next()) {
                result = Cars_ID.getInt("SUCCESS");
            }
            System.out.println(result);
            pstmt.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("오류 : " + e);
        } catch (ClassNotFoundException e) {
            System.out.println("드라이버가 존재하지 않습니다." + e);
        }
        return result;
    }




    //    ------------------출 차 -------------------------
    // 사용자가 입력한 차량번호로 Cars_ID를 찾아 리턴
    public static int outCars_ID() {
        // 홈페이지에서 입력한 차 번호로 받아와야함.
        String num = CarsDTO.getCar_Number();
        ResultSet Cars_ID;
        int result = 0;

        try {
            Connection con;
            PreparedStatement pstmt = null;

            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Mini_Project?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Asia/Seoul", "root", "gustjr12");
            String sql = "SELECT Cars_ID FROM Cars WHERE Car_Number = ?";
            pstmt = con.prepareStatement(sql);

            pstmt.setString(1, num);

            Cars_ID = pstmt.executeQuery();

            while (Cars_ID.next()) {
                result = Cars_ID.getInt("Cars_ID");
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



}








