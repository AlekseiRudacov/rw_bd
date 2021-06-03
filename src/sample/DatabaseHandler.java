package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.net.*;

public class DatabaseHandler extends Configs{
    Connection dbConnection;

    public Connection getDbConnection()
            throws ClassNotFoundException, SQLException{
       // String connectionString = "jdbc:mysql://" + dbHost + ":"
               // + dbPort + "/" + dbName + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
         Class.forName("com.mysql.jdbc.Driver");

         String connectionString = "jdbc:mysql://localhost/rw_bd";
         dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);

         return dbConnection;
    }

    public void addTheTrip(
            int rw_id,
            String start_data_trip,
            String start_time_trip,
            String start_data_work,
            String start_time_work,
            String where_from,
            String where_,
            String train_number,
            String train_long,
            String start_section_A,
            String start_section_B,
            String end_section_A,
            String end_section_B,
            String end_data_work,
            String end_time_work,
            String end_data_trip,
            String end_time_trip){
        String insert = "INSERT INTO " + Const.RW_TABLE + "(" +
                Const.RW_ID + "," +
                Const.RW_START_DATA_TRIP + "," +
                Const.RW_START_TIME_TRIP + "," +
                Const.RW_START_DATA_WORK + "," +
                Const.RW_START_TIME_WORK + "," +
                Const.RW_WHERE_FROM + "," +
                Const.RW_WHERE_ + "," +
                Const.RW_TRAIN_NUMBER + "," +
                Const.RW_TRAIN_LONG + "," +
                Const.RW_START_SECTION_A + "," +
                Const.RW_START_SECTION_B + "," +
                Const.RW_END_SECTION_A + "," +
                Const.RW_END_SECTION_B + "," +
                Const.RW_END_DATA_WORK + "," +
                Const.RW_END_TIME_WORK + "," +
                Const.RW_START_DATA_TRIP + "," +
                Const.RW_END_TIME_TRIP + ")" +
               // "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                "VALUES(1,sdf,wefwe,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";


        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setString(1, start_data_trip);
            prSt.setString(2, start_time_trip);

            prSt.setString(3, start_data_work);
            prSt.setString(4, start_time_work);

            prSt.setString(5, where_from);
            prSt.setString(6, where_);

            prSt.setString(7, train_number);
            prSt.setString(8, train_long);

            prSt.setString(9, start_section_A);
            prSt.setString(10, start_section_B);

            prSt.setString(11, end_section_A);
            prSt.setString(12, end_section_B);

            prSt.setString(13, end_data_work);
            prSt.setString(14, end_time_work);

          //  prSt.setString(15, end_data_trip);
            ///prSt.setString(16, end_time_trip);

            prSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
/*
    String start_data_trip
    String start_time_trip
    String start_data_work
    String start_time_work
    String where_from
    String where_
    String train_number
    String train_long
    String start_section_A
    String start_section_B
    String end_section_A
    String end_section_B
    String end_data_work
    String end_time_work
    String end_data_trip
    String end_time_trip
 */