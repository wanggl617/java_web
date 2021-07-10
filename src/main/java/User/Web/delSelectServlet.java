package User.Web;

import User.Service.UserService;
import User.Service.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "delSelectServlet", value = "/delSelectServlet")
public class delSelectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //request.getParameterValues:获取前台表单多个标签同名name对应的所有value值
        String[] uids = request.getParameterValues("uid");

        UserService service = new UserServiceImpl();
        service.deleSelectUser(uids);
        response.sendRedirect(request.getContextPath()+"/findByPageServlet");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
