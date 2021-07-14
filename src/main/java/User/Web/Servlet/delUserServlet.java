package User.Web.Servlet;

import User.Service.UserService;
import User.Service.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "delUserServlet", value = "/delUserServlet")
public class delUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取ID
        String id = request.getParameter("id");
        //2.调用service 删除
        UserService service = new UserServiceImpl();
        service.deleteUser(id);

        //3.跳转到查询所有的Servlet
        response.sendRedirect(request.getContextPath()+"/findByPageServlet");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
