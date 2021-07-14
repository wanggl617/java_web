package User.Web.Filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter("/*")
public class LoginFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
        System.out.println("登录验证过滤器");
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        //0.强制转换
        HttpServletRequest req = (HttpServletRequest)request;
        //1.获取请求资源的路径
        String uri = req.getRequestURI();
        //2.判断是否包含登录相关资源路径 (也包括前端的资源css，图片等）
        if(uri.contains("login.jsp") || uri.contains("LoginServlet") || uri.contains("/css/") || uri.contains("/js/") || uri.contains("/image/") || uri.contains("check")){
            chain.doFilter(request, response);//是登录相关资源，放行
        }
        else{
            //不是登录相关资源，验证是否登录
        //3.从 session 中获取user
            Object user = req.getSession().getAttribute("user");
            if(user != null){
                chain.doFilter(request,response);
            }
            else{
                req.setAttribute("login_msg","尚未登录");
                req.getRequestDispatcher("/login.jsp").forward(req,response);
            }
        }

    }
}
