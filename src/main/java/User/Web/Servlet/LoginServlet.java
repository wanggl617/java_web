package User.Web.Servlet; /**
 * @title 阳光正好，微风不燥
 * @data 2021/6/9
 */

import User.Dao.LoginDao;
import User.domain.Login_User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        // request.getRequestDispatcher("index.jsp").forward(request,response);
        //获取验证码
        String user_checkcode = request.getParameter("checkcode");
        System.out.println("user_check:"+user_checkcode);
        HttpSession session = request.getSession();
        String checkcode=(String)session.getAttribute("checkcode");
        session.removeAttribute("checkcode");
        System.out.println("checkcode:"+checkcode);

        // System.out.println(equals);

        if(checkcode==null||!checkcode.equalsIgnoreCase(user_checkcode)){
            // request.getRequestDispatcher("index.jsp").forward(request,response);
            System.out.println("验证码错误");
            //验证码错误
            request.setAttribute("msg","验证码错误");//存储提示信息
            //转发到 登录
            request.getRequestDispatcher("login.jsp").forward(request,response);

        }else {
            System.out.println("验证码正确");
            Map<String, String[]> parameter = request.getParameterMap();
            Login_User loginUser = new Login_User();
            try {
                BeanUtils.populate(loginUser, parameter);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            System.out.println(loginUser.getUsername());
            LoginDao dao = new LoginDao();
            Login_User login = dao.login(loginUser);
//                String username = request.getParameter("username");
//                String password = request.getParameter("password");

            //   if (!("wang".equals(username)&&"123456".equals(password)))
            System.out.println("验证用户名密码");
            if(login==null)
            {

                //用户名密码错误
                System.out.println("用户名或密码错误");
                request.setAttribute("user_msg","用户名或密码错误");//存储错误信息
                //跳转到登陆页面
                request.getRequestDispatcher("login.jsp").forward(request,response);
            } else {
                //用户名密码正确
                System.out.println("用户名密码正确");
                session.setAttribute("user",login.getUsername());//由于重定向，两次访问，要用session存储
                //重定向到success.jsp
                response.sendRedirect(request.getContextPath()+"/index.jsp");
            }
        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
