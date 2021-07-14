package User.Web.Filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@WebFilter("/*")
public class SensitiveFilter implements Filter {
    //敏感词汇集合
    private List<String> list = new ArrayList<String>();
    public void init(FilterConfig config) throws ServletException {
        try {
            System.out.println("读取文件");
            //初始化，添加配置文件
            //1. 获取文件路径
            ServletContext context = config.getServletContext();
            String realPath = context.getRealPath("敏感词汇.txt");
            //2.读取文件
            System.out.println(realPath);
            BufferedReader buffer = new BufferedReader(new FileReader(realPath));
            //3.文件中每一行添加到 list 集合
            String line = null;
            while((line = buffer.readLine()) != null){
                System.out.println(line);
                list.add(line);
            }
            buffer.close();
            System.out.println(list);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        //1.创建代理对象，增强 getParameter方法
        ServletRequest Proxy_request = (ServletRequest) Proxy.newProxyInstance(request.getClass().getClassLoader(), request.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if(method.getName().equals("findUserByPage")){
                    System.out.println("findUserByPage");
                }

                //增强 getParameter 方法
                if(method.getName().equals("getParameter")){

                    String o = (String) method.invoke(request, args);
                    if(o!=null){
                        for(String str: list){
                            if(o.contains(str)){
                                o = o.replaceAll(str, "***");
                            }
                        }
                    }
                    return o;
                }
                //增强 getParameterMap 方法
                if(method.getName().equals("getParameterMap")){
                    Map<String, String[]> values = (Map<String, String[]>) method.invoke(request, args);
                    if(values!=null){
                        Set<String> keySet = values.keySet();
                        for(String key:keySet){
                            String value = values.get(key)[0];

                            for(String str:list){
                                if(value.contains(str)){
                                    value = value.replaceAll(str,"***");

                                }
                            }
                            //替换敏感词汇，敏感词汇写入数据库以 ***
                            //values.get(key)[0] = value;
                        }

                    }

                    return values;
                }


                return method.invoke(request,args);
            }
        });

        chain.doFilter(Proxy_request, response);
    }
}
