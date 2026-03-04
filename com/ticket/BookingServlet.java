package com.ticket;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({"/book"})
public class BookingServlet extends HttpServlet {
   public BookingServlet() {
   }

   protected void doPost(HttpServletRequest var1, HttpServletResponse var2) throws ServletException, IOException {
      String var3 = var1.getParameter("name");
      String var4 = var1.getParameter("movie");
      String var5 = var1.getParameter("seats");

      try {
         Connection var6 = DBConnection.getConnection();
         String var7 = "insert into booking(name,movie,seats) values(?,?,?)";
         PreparedStatement var8 = var6.prepareStatement(var7);
         var8.setString(1, var3);
         var8.setString(2, var4);
         var8.setString(3, var5);
         var8.executeUpdate();
         var2.getWriter().println("Ticket Booked Successfully");
      } catch (Exception var9) {
         var9.printStackTrace();
      }

   }
}
