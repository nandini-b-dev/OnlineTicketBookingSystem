package com.ticket;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
   public DBConnection() {
   }

   public static Connection getConnection() {
      Connection var0 = null;

      try {
         Class.forName("com.mysql.cj.jdbc.Driver");
         var0 = DriverManager.getConnection("jdbc:mysql://localhost:3306/ticketdb", "root", "root");
      } catch (Exception var2) {
         var2.printStackTrace();
      }

      return var0;
   }
}

