/**
 * Created by Administrator on 15.02.2017.
 */
//package com.example.databse;


import java.sql.*;

public class Tag_8 {


    Statement aussage = null;
    Connection con = null;
/*
        aussage.executeUpdate("UPDATE pkw SET ps=200,vmax=220 WHERE seriennummer=25");

        aussage.executeUpdate("DELETE FROM pkw WHERE seriennummer=25");

        aussage.executeUpdate("DROP TABLE IF EXISTS pkw");
*/

    Tag_8() {
        /*
        super("pkw Verwaltung");
        int width = 300;
        int height = 300;
        this.setLayout(new GridLayout(1, 2));
        */

        buildApp();
        connectToDB();
        createDB();
        closeDBConn();
        connectToDB();
        fillDB();
        closeDBConn();
    }


    private void buildApp() {


    }

    private void fillDB() {
        String ort = "jdbc:hsqldb:file:d:/java/hsqldb/data";
        //  con = DriverManager.getConnection(ort, "SA", "");
        //Statement aussage = con.createStatement(); // read only
        //  aussage = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);


        String[] farben = {"blau", "lila", "grün", "weiss", "schwarz"};
        for (int i = 1; i <= 100; i++) {
            int Farbe = (int) (Math.random() * 5);
            int ps = (int) (Math.random() * 90);
            int vmax = (int) (Math.random() * 120);
            int tank = (int) (Math.random() * 80);
            int seriennummer = (int) (Math.random() * 5687);
            try {
                aussage.executeUpdate("INSERT INTO pkw VALUES (" + i + "," + ps + "," + vmax + "," + tank + ",'" + farben[Farbe] + "'," + seriennummer + ")");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    private void createDB() {
        try {
            aussage.executeUpdate("DROP TABLE IF EXISTS pkw");
            aussage.executeUpdate("CREATE TABLE pkw(ID INTEGER PRIMARY KEY ,ps INTEGER,vmax INTEGER,tank INTEGER,farbe VARCHAR (30),seriennummer INTEGER NOT NULL)");
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }


    private void closeDBConn() {
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    private void connectToDB() {
        try {
            Class.forName("org.hsqldb.jdbcDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            log("Treiber nicht gefunden");
        }

        String ort = "jdbc:hsqldb:file:d:/java/hsqldb/data";
        //String ort = "jdbc:hsqldb:file:d:/java/hsqldb/data;shutdown=true;ifexists=true";


        try {
            con = DriverManager.getConnection(ort, "SA", "");
            //Statement aussage = con.createStatement(); // read only
            aussage = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            //aussage.executeUpdate("CREATE TABLE pkw(ID INTEGER PRIMARY KEY ,ps INTEGER,vmax INTEGER,tank INTEGER,farbe VARCHAR (30),seriennummer INTEGER NOT NULL)");



/*
            aussage.executeUpdate("CREATE TABLE pkw(ID INTEGER PRIMARY KEY ,ps INTEGER,vmax INTEGER,tank INTEGER,farbe VARCHAR (30),seriennummer INTEGER NOT NULL)");

            aussage.executeUpdate("INSERT INTO pkw VALUES (1,80,160,50,'lila',25)");

            aussage.executeUpdate("UPDATE pkw SET ps=200,vmax=220 WHERE seriennummer=25");

            aussage.executeUpdate("DELETE FROM pkw WHERE seriennummer=25");

            aussage.executeUpdate("DROP TABLE IF EXISTS pkw");

*/


            //ResultSet res = aussage.executeQuery("SELECT * FROM customer");
        } catch (SQLException e) {
            e.printStackTrace();
        }





           /* ResultSetMetaData md = res.getMetaData();
            int anzSp = md.getColumnCount();

            for (int i = 1; i <= anzSp; i++) {
                log(md.getColumnName(i));
            }

            while (res.next()) {
                if (res.next()) {
                /*
                    for (int i = 1; i <= anzSp; i++) {
                        log(res.getString(i) + "\t");
                                       }

                    log(res.getString("ID") + " " + res.getString("FIRSTNAME") + " " + res.getString("LASTNAME") + " " + res.getString("STREET") + " " + res.getString("CITY"));
                }
            }
   */


    }


    public static void main(String[] args) {
        new Tag_8();
    }

    private void log(String str) {
        System.out.println(str);

    }

}