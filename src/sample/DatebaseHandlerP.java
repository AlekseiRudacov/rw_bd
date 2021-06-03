package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatebaseHandlerP extends Configs {
    Connection dbConnection;

    public Connection getDbConnection()
            throws ClassNotFoundException, SQLException {
        String connectionsString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName;

        Class.forName("com.mysql.jdbc.Driver");

        dbConnection = DriverManager.getConnection(connectionsString, dbUser, dbPass);
        return dbConnection;
    }

    public void addThePassenger(
            String start_data_passenger,
            String start_time_passenger,

            String where_from,
            String where_,

            String train_number,

            String start_time_train,
            String stop_time_train,

            String end_data_trip1,
            String end_time_trip1){
        String insert = "INSERT INTO " + ConstP.RW_TABLE_P + "(" +
                ConstP.RW_START_DATA_PASSENGERS + "," +
                ConstP.RW_START_TIME_PASSENGERS + "," +

                ConstP.RW_WHERE_FROM + "," +
                ConstP.RW_WHERE_ + "," +

                ConstP.RW_TRAIN_NUMBER + "," +


                ConstP.RW_START_TIME_TRAIN + "," +
                ConstP.RW_STOP_TIME_TRAIN + "," +

                ConstP.RW_END_DATA_TRIP1 + "," +
                ConstP.RW_END_TIME_TRIP1 + ")" +
                "VALUES(?,?,?,?,?,?,?,?,?)";



        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setString(1, start_data_passenger);
            prSt.setString(2, start_time_passenger);

            prSt.setString(5, where_from);
            prSt.setString(6, where_);

            prSt.setString(7, train_number);

            prSt.setString(13, start_time_train);
            prSt.setString(14, stop_time_train);

            prSt.setString(15, end_data_trip1);
            prSt.setString(16, end_time_trip1);

            prSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
