package com.nmu.wrrv301.reelin;

import android.annotation.SuppressLint;
import android.os.StrictMode;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLConnection {
    private String instance = "reelindb.ceewhn8beyjo.eu-west-2.rds.amazonaws.com,1433";
    private String driver = "net.sourceforge.jtds.jdbc.Driver";
    private String db = "ReelIn";
    private String username = "ReelInUser";
    private String password = "reelin123";

    @SuppressLint("NewApi")
    public Connection CONN() {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                .permitAll().build();
        StrictMode.setThreadPolicy(policy);
        Connection conn = null;
        String connURL = null;

        try {
            Class.forName(driver);
            connURL = "jdbc:jtds:sqlserver://" + instance + ";"
                    +"databaseName=" + db + ";user=" + username + ";password="
                    +password + ";";
            conn = DriverManager.getConnection(connURL);
        } catch (SQLException se) {
            Log.e("ERROR", se.getMessage());
        } catch (ClassNotFoundException e) {
            Log.e("ERROR", e.getMessage());
        } catch (Exception e) {
            Log.e("ERROR", e.getMessage());
        }

        return conn;
    }
}
