package pack;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Register extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {

            String name = request.getParameter("na");
            String email = request.getParameter("em");
            String password = request.getParameter("pass");

            Student st = new Student();
            st.setName(name);
            st.setEmail(email);
            st.setPassword(password);

            if (Database.savedata(st) == 1) {
                out.println("Successful");
                RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                rd.include(request, response);
            } else {
                out.println("Unsuccessful");
                RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                rd.include(request, response);
            }

        } finally {
            out.close();
        }

    }

}
