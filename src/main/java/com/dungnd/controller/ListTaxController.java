package com.dungnd.controller;

import com.dungnd.dao.UserTaxDao;
import com.dungnd.dao.impl.UserTaxDaoImpl;
import com.dungnd.model.UserTax;
import com.dungnd.util.Constant;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;

@WebServlet(urlPatterns = {"/home", "/list-taxes"})
public class ListTaxController extends javax.servlet.http.HttpServlet {

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        Integer year = Integer.valueOf(request.getParameter("select-year"));
        Integer month = Integer.valueOf(request.getParameter("select-month"));

        request.setAttribute("cyear", year);
        request.setAttribute("cmonth", month);


        UserTaxDao userTaxDao = new UserTaxDaoImpl();

        List<UserTax> userTaxes = userTaxDao.findUserTaxesByMonth(month, year, Constant.GET_ALL_USER_TAXES);

        request.setAttribute("userTaxes", userTaxes);

        // get years
        List<Integer> years = userTaxDao.getYears();

        request.setAttribute("years", years);

        request.getRequestDispatcher("/tax-list.jsp").forward(request, response);

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        UserTaxDao userTaxDao = new UserTaxDaoImpl();

        int currentMonth = Calendar.getInstance().get(Calendar.MONTH);
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);

        int prevMonth = (currentMonth == 0) ? 12 : currentMonth;

        request.setAttribute("cmonth", prevMonth);

        List<UserTax> userTaxes = userTaxDao.findUserTaxesByMonth(prevMonth,currentYear,Constant.GET_ALL_USER_TAXES);

        request.setAttribute("userTaxes", userTaxes);

        // get years
        List<Integer> years = userTaxDao.getYears();

        request.setAttribute("years", years);

        request.getRequestDispatcher("/tax-list.jsp").forward(request,response);

    }
}
