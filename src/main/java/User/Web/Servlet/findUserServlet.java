package User.Web.Servlet;

import User.Service.UserService;
import User.Service.UserServiceImpl;
import User.domain.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "findUserServlet", value = "/findUserServlet")
public class findUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //1.获取id
        String id = request.getParameter("id");
    //2.调用service查询
        UserService service = new UserServiceImpl();
        User user = service.findUserById(id);
    //3.将user存入request
        request.setAttribute("user",user);
    //4.转发页面到update.jsp
        System.out.println("test_find");
        request.getRequestDispatcher("update.jsp").forward(request,response);
        //request.getRequestDispatcher("list.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
