package User.Web.Servlet; /**
 * @title 阳光正好，微风不燥
 * @data 2021/6/8
 */

import User.Service.UserService;
import User.Service.UserServiceImpl;
import User.domain.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserlistServlet", value = "/UserlistServlet")
public class UserlistServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("test");
        //1.调用UserService完成查询
        UserService service =new UserServiceImpl();
        List<User> users = service.findAll();
        //2.存入域对象
        request.setAttribute("users",users);
        //3.转发
        request.getRequestDispatcher("list.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
