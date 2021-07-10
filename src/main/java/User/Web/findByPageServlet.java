package User.Web;

import User.Service.UserService;
import User.Service.UserServiceImpl;
import User.domain.PageBean;
import User.domain.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "findByPageServlet", value = "/findByPageServlet")
public class findByPageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        //1.获取请求参数
        String currentPage = request.getParameter("currentPage");
        String rows = request.getParameter("rows");
        //初始页面 都为空
        if(currentPage == null || "".equals(currentPage) ){
            currentPage = "1";
            rows = "12";
        }
        //将获取到的 条件进行封装
        Map<String, String[]> condition = request.getParameterMap();
        //2.调用service 查询  PageBean
        UserService service = new UserServiceImpl();
        PageBean<User> pageBean =  service.findUserByPage(currentPage,rows,condition);

      //  System.out.println(pageBean);
        //3.将 PageBean存入 request
        request.setAttribute("pageBean",pageBean);
        // 存一下 查询 条件，为了跳转之后进行显示
        request.setAttribute("condition",condition);
        //4.转发（携带数据要转发）
        System.out.println("____________");
        System.out.println(pageBean.toString());
        request.getRequestDispatcher("/list.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    this.doGet(request,response);
    }
}
