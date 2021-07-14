package User.Web.Servlet;

import User.Service.UserService;
import User.Service.UserServiceImpl;
import User.domain.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet(name = "testServlet", value = "/updateServlet")
public class updateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("test_update");
        //1.设置编码
        request.setCharacterEncoding("utf-8");
        //2.获取参数
        Map<String,String[]> map = request.getParameterMap();
        //3.封装对象
        User user = new User();
        try {
            BeanUtils.populate(user,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        //4.调用service保存数据到数据库
        UserService service = new UserServiceImpl();
        service.updateUser(user);

        //5.跳转到UserListServlet
        response.sendRedirect(request.getContextPath()+"/findByPageServlet");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
