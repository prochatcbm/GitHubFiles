package com.example.databse;

/**
 * Created by Administrator on 09.02.2017.
 */

import java.sql.*;


public final class dbconnect {
    private Connection conn;

    public dbconnect() {
        conn = null;
        try {
            String userName = "root";
            String password = "";
            String url = "jdbc:mysql://localhost:3306";
            //Class.forName ("com.mysql.jdbc.Driver").newInstance ();
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection(url, userName, password);
        } catch (Exception e) {
            System.out.println("Exception found in connection"+e);
        }
    }

    public Connection getConnection() {
        return conn;
    }

    public void closeConnection() {
        try {
            conn.close();
            System.out.println("Connection closed");

        } catch (Exception e) {
            System.out.println("Connection close error");
        }
    }


    public String getNamenFromDB() {
        String name = "nix";
        try {
            Statement stt = conn.createStatement();
            stt.execute("USE javatestdb");

            ResultSet res = stt.executeQuery("SELECT * FROM people WHERE lname = 'Bloggs'");
            //System.out.println(res.getString("fname") + " " + res.getString("lname"));

            String foundType="";

            while(res.next()){

                if(res.next()) {

                    //foundType = res.getString(1);
                    name=res.getString("fname") + " " + res.getString("lname");
                }
            }

           // System.out.println(foundType);

/*

            while (res.next()) {
                 System.out.println(res.getString("fname") + " " + res.getString("lname"));
              // name = res.getString("fname") + " " + res.getString("lname");
                // System.out.println(name);
            }

*/


        } catch (Exception e) {
            e.printStackTrace();
        }
        return name;
    }


    public void createDB() {

        try {


            Statement stt = conn.createStatement();


            stt.execute("CREATE DATABASE IF NOT EXISTS javatestdb");
            stt.execute("USE javatestdb");

            /**
             * Create an example table
             */
            stt.execute("DROP TABLE IF EXISTS people");
            stt.execute("CREATE TABLE people (" +
                    "id BIGINT NOT NULL AUTO_INCREMENT,"
                    + "fname VARCHAR(25),"
                    + "lname VARCHAR(25),"
                    + "PRIMARY KEY(id)"
                    + ")");

            /**
             * Add entries to the example table
             */
            stt.execute("INSERT INTO people (fname, lname) VALUES" +
                    "('Joe', 'Bloggs'), ('Mary', 'Bloggs'), ('Jill', 'Hill')");

            /**
             * Query people entries with the lname 'Bloggs'
             */
            ResultSet res = stt.executeQuery("SELECT * FROM people WHERE lname = 'Bloggs'");

            /**
             * Iterate over the result set from the above query
             */
            while (res.next()) {
                System.out.println(res.getString("fname") + " " + res.getString("lname"));
            }
            System.out.println("");

            /**
             * Same as the last query, but using a prepared statement.
             * Prepared statements should be used when building query strings
             * from user input as they protect against SQL injections
             */
            PreparedStatement prep = conn.prepareStatement("SELECT * FROM people WHERE lname = ?");
            prep.setString(1, "Bloggs");

            res = prep.executeQuery();
            while (res.next()) {
                System.out.println(res.getString("fname") + " " + res.getString("lname"));
            }

            /**
             * Free all opened resources
             */
            res.close();
            stt.close();
            prep.close();
            conn.close();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}