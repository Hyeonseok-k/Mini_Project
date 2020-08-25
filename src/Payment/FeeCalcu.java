package Payment;

import Database.Car_ParkDAO;

import java.lang.management.ManagementFactory;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class FeeCalcu {

    public static long timeCal() {
        // 주차장 이용시간 계산 메소드
        Timestamp inTime = Car_ParkDAO.getInTime();
        Timestamp outTime = Car_ParkDAO.getOutTime();

        Date dateInTime = inTime;
        Date dateOutTime = outTime;
        long calDate = dateInTime.getTime() - dateOutTime.getTime();
        long calDateTime = calDate / 1000; // 소요시간을 초단위로 계산
        calDateTime = Math.abs(calDateTime);

        System.out.println("이용시간 : " + (calDateTime / 60) + "시간 " + (calDateTime % 60) + "분");
        return calDateTime;
    }

    // 주차요금 계산 메소드 (1분당 1000원)
    public static int feeCal() {
        int Fee = (int) timeCal() * 1000;
        System.out.println("주차요금 : " + Fee + "원");
        return Fee;
    }
}





