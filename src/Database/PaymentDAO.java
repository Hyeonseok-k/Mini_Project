package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PaymentDAO {

    //    ------------------결제 로그 등록 -------------------------

    public static void addLog() {
        int num = CarsDAO.outCars_ID();

        try {
            Connection con;
            PreparedStatement pstmt = null;

            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Mini_Project?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Asia/Seoul", "root", "gustjr12");
            String sql = "INSERT INTO Payment (Cars_ID) VALUES (?)";
            pstmt = con.prepareStatement(sql);

            pstmt.setInt(1, num);

            pstmt.executeUpdate();

            pstmt.close();
            con.close();
            System.out.println("데이터가 정상적으로 추가되었습니다.");
        } catch (SQLException e) {
            System.out.println("오류 : " + e);
        } catch (ClassNotFoundException e) {
            System.out.println("드라이버가 존재하지 않습니다." + e);
        }
    }
}
