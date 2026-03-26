package com.alkawallet.controller;

import com.alkawallet.model.Wallet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/wallet")
public class WalletServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Wallet wallet = (Wallet) session.getAttribute("wallet");
        
        if (wallet == null) {
            wallet = new Wallet(1000.0); // Initial balance for demo
            session.setAttribute("wallet", wallet);
        }
        
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Wallet wallet = (Wallet) session.getAttribute("wallet");
        
        String action = request.getParameter("action");
        String amountStr = request.getParameter("amount");
        
        if (wallet != null && amountStr != null) {
            try {
                double amount = Double.parseDouble(amountStr);
                if ("deposit".equals(action)) {
                    wallet.deposit(amount);
                } else if ("withdraw".equals(action)) {
                    if (!wallet.withdraw(amount)) {
                        request.setAttribute("error", "Fondos insuficientes");
                    }
                }
            } catch (NumberFormatException e) {
                request.setAttribute("error", "Monto inválido");
            }
        }
        
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
