package Database;

import com.mysql.cj.protocol.Resultset;

import java.sql.*;
import java.text.SimpleDateFormat;

public class Car_ParkDAO {

//    ------------------입 차 -------------------------

    // 차량번호 입력 후 Car_Park 테이블에 입차 시간 및 Cars의 기본키를 가져와서 외래키 데이터로 같이 추가, 주차가능 공간 -1  수정
    public static void updateCarPark() {

        // 사용자가 입력한 차 번호의 Cars_ID 값 가져오기
        ResultSet available_space; // 주차가능개수를 위한 전체 행 개수 가져오기
        int space = 0;
        int Cars_ID = CarsDAO.outCars_ID();

        try {
            Connection con;
            Statement pstmt = null;
            PreparedStatement pstmt2 = null;

            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Mini_Project?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Asia/Seoul", "root", "gustjr12");

            // 현재 주차된 차량 개수 변수로 가져오기
            String sql = "SELECT COUNT(*) FROM Car_Park";
            pstmt = con.prepareStatement(sql);
            available_space = pstmt.executeQuery(sql);

            while (available_space.next()) {
                space = available_space.getInt(1);
            }

            // 주차가능공간 - 현재 주차된 차량 개수, 입력한 차량번호의 Cars_Id를 외래키로 같이 등록
            String sql2 = "INSERT INTO Car_Park (Available_Space, Cars_ID) VALUES (100 - ?, ?);";
            pstmt2 = con.prepareStatement(sql2);

            pstmt2.setInt(1, space);
            pstmt2.setInt(2, Cars_ID);

            pstmt2.executeUpdate();

            pstmt.close();
            con.close();
            System.out.println("정상 입차처리되었습니다.");
            System.out.println("현재 주차가능 공간 : " + (100 - space));
        } catch (SQLException e) {
            System.out.println("오류 : " + e);
        } catch (ClassNotFoundException e) {
            System.out.println("드라이버가 존재하지 않습니다." + e);
        }
    }


    //    ------------------출 차 -------------------------

    // 입력한 차량번호의 입차시간 가져오기
    public static Timestamp getInTime() {
        int num = CarsDAO.outCars_ID();
//        int num = 1;

        ResultSet in_time;
        Timestamp result = null;

        try {
            Connection con;
            PreparedStatement pstmt = null;

            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Mini_Project?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Asia/Seoul", "root", "gustjr12");
            String sql = "SELECT In_Time FROM Car_Park WHERE Cars_ID = ?";
            pstmt = con.prepareStatement(sql);

            pstmt.setInt(1, num);

            in_time = pstmt.executeQuery();

            while (in_time.next()) {
                result = in_time.getTimestamp("In_Time");
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

    // 결제를 위해 출차시간을 현재시간으로 수정
    public static void updateOuttime() {
        int Cars_ID = CarsDAO.outCars_ID();

        try {
            Connection con;
            PreparedStatement pstmt = null;

            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Mini_Project?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Asia/Seoul", "root", "gustjr12");
            String sql = "UPDATE Car_Park SET Out_Time = CURRENT_TIME WHERE Cars_ID = ?";
            pstmt = con.prepareStatement(sql);

            pstmt.setInt(1, Cars_ID);

            pstmt.executeUpdate();

            pstmt.close();
            con.close();
            System.out.println("결제를 위해 현재시각을 출차시간으로 설정합니다.");
        } catch (SQLException e) {
            System.out.println("오류 : " + e);
        } catch (ClassNotFoundException e) {
            System.out.println("드라이버가 존재하지 않습니다." + e);
        }
    }

    // 출차시간 가져오기
    public static Timestamp getOutTime() {
        int num = CarsDAO.outCars_ID();
//        int num = 1;
        ResultSet out_time;
        Timestamp result = null;

        try {
            Connection con;
            PreparedStatement pstmt = null;

            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Mini_Project?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Asia/Seoul", "root", "gustjr12");
            String sql = "SELECT Out_Time FROM Car_Park WHERE Cars_ID = ?";
            pstmt = con.prepareStatement(sql);

            pstmt.setInt(1, num);

            out_time = pstmt.executeQuery();

            while (out_time.next()) {
                result = out_time.getTimestamp("Out_Time");
            }
            System.out.println("출차시간 : " + result);

            pstmt.close();
            con.close();

        } catch (SQLException e) {
            System.out.println("오류 : " + e);
        } catch (ClassNotFoundException e) {
            System.out.println("드라이버가 존재하지 않습니다." + e);
        }
        return result;
    }

    // 결제완료 후 출차된 차량의 데이터 삭제
    public static void deleteCar() {
        int num = CarsDAO.outCars_ID();

        try {
            Connection con;
            PreparedStatement pstmt = null;

            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Mini_Project?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Asia/Seoul", "root", "gustjr12");
            String sql = "DELETE FROM Car_Park WHERE Cars_ID = ?";
            pstmt = con.prepareStatement(sql);

            pstmt.setInt(1, num);

            pstmt.executeUpdate();

            pstmt.close();
            con.close();
            System.out.println("데이터가 정상적으로 삭제되었습니다.");
        } catch (SQLException e) {
            System.out.println("오류 : " + e);
        } catch (ClassNotFoundException e) {
            System.out.println("드라이버가 존재하지 않습니다." + e);
        }
    }

    // ------------------ 현재 주차 가능 공간 가져오기 ----------------

    public static int getSpace() {
        ResultSet available_space; // 주차가능개수를 위한 전체 행 개수 가져오기
        int space = 0;

        try {
            Connection con;
            Statement pstmt = null;
            PreparedStatement pstmt2 = null;

            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Mini_Project?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Asia/Seoul", "root", "gustjr12");

            // 현재 주차된 차량 개수 변수로 가져오기
            String sql = "SELECT COUNT(*) FROM Car_Park";
            pstmt = con.prepareStatement(sql);
            available_space = pstmt.executeQuery(sql);

            while (available_space.next()) {
                space = available_space.getInt(1);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return space;
    }


    }


