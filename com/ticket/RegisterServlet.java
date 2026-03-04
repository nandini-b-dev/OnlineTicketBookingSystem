// Source code is decompiled from a .class file using FernFlower decompiler (from Intellij IDEA).
package com.ticket;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({"/register"})
public class RegisterServlet extends HttpServlet {
   public RegisterServlet() {
   }

   protected void doPost(HttpServletRequest var1, HttpServletResponse var2) throws ServletException, IOException {
      String var3 = var1.getParameter("name");
      String var4 = var1.getParameter("email");
      String var5 = var1.getParameter("password");

      try {
         Connection var6 = DBConnection.getConnection();
         String var7 = "insert into users(name,email,password) values(?,?,?)";
         PreparedStatement var8 = var6.prepareStatement(var7);
         var8.setString(1, var3);
         var8.setString(2, var4);
         var8.setString(3, var5);
         var8.executeUpdate();
         var2.sendRedirect("login.html");
      } catch (Exception var9) {
         var9.printStackTrace();
      }

   }
}

