// Source code is decompiled from a .class file using FernFlower decompiler (from Intellij IDEA).
package com.ticket;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({"/login"})
public class LoginServlet extends HttpServlet {
   public LoginServlet() {
   }

   protected void doPost(HttpServletRequest var1, HttpServletResponse var2) throws ServletException, IOException {
      String var3 = var1.getParameter("email");
      String var4 = var1.getParameter("password");

      try {
         Connection var5 = DBConnection.getConnection();
         String var6 = "select * from users where email=? and password=?";
         PreparedStatement var7 = var5.prepareStatement(var6);
         var7.setString(1, var3);
         var7.setString(2, var4);
         ResultSet var8 = var7.executeQuery();
         if (var8.next()) {
            var2.sendRedirect("booking.html");
         } else {
            var2.getWriter().println("Invalid Login");
         }
      } catch (Exception var9) {
         var9.printStackTrace();
      }

   }
}

