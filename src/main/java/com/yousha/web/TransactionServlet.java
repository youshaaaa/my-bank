package com.yousha.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yousha.context.Application;
import com.yousha.model.Transaction;
import com.yousha.service.TransactionService;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

public class TransactionServlet extends HttpServlet {

    private ObjectMapper objectMapper;
    private TransactionService transactionService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Application.class);

        this.objectMapper = ctx.getBean(ObjectMapper.class);
        this.transactionService = ctx.getBean(TransactionService.class);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getRequestURI().equalsIgnoreCase("/")) {
            response.setContentType("text/html; charset=UTF-8");
            response.getWriter().print(
                    "<html>\n" +
                            "<body>\n" +
                            "<h1>MY BANK</h1>\n" +
                            "<p>Make some transactions at <b>transaction/</b></p>\n" +
                            "</body>\n" +
                            "</html>");
        }
        else if (request.getRequestURI().equalsIgnoreCase("/transactions")) {
            response.setContentType("application/json; charset=UTF-8");
            response.getWriter().print(
                    objectMapper.writeValueAsString(transactionService.findAll())
                     );
        }
        else {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if(request.getRequestURI().equalsIgnoreCase("/transactions")){
            Double amount = Double.parseDouble(request.getParameter("amount"));
            String reference = request.getParameter("reference");
            Transaction transaction = transactionService.create(amount,reference);
            String json = objectMapper.writeValueAsString(transaction);
            response.getWriter().print(json);
        } else {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
    }
}
