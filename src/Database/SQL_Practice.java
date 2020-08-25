package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQL_Practice {
    public static void main(String[] args) {
        // Connnection 레퍼런스 타입은 java.sql.Connection 클래스
        Connection con;

        try {
            // 1) 해당 클래스를 메모리에 로드, 해당 클래스가 존재하는지 여부를 확인하는 용도
            Class.forName("com.mysql.jdbc.Driver");

            // 2) 해당 드라이버의 클래스를 이용하여 DB 접속
            // "해당드라이버의 클래스: //호스트주소:포트/데이터베이스명?useUnicode~", "아이디", "패스워드"
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Mini_Project?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "gustjr12");

            // 3) DB에 명령어를 전달할 수 있는 객체 생성
            java.sql.Statement stmt = con.createStatement();

            // 4) 쿼리문장이 실행된 결과를 ResultSet 객체의 참조변수에 담아준다.
            java.sql.ResultSet rs = stmt.executeQuery("INSERT INTO Cars (Car_Number) VALUES (9999)");

            // 5) 결과를 가져와서 자료의 처음부터 마지막까지를 화면에 보여준다
//            for (int n = 1; n <= 2; n++) {
//                rs.beforeFirst();

//            while (rs.next()) {
//                System.out.println(rs.getString("Car_Number") + "\t" +
//                        rs.getString("is_Employees_Car"));
//            }
//            System.out.println("--------------------------");
////            }
            con.close();

//            System.out.println("연결 성공");
//            con.close();
        } catch (SQLException e) {
            System.out.println("오류 : " + e);
        } catch (ClassNotFoundException e) {
            System.out.println("드라이버가 존재하지 않습니다." + e);
        }
    }
}
