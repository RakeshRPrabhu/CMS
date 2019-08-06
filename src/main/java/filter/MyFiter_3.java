package filter;

import org.springframework.stereotype.*;

import javax.servlet.*;
import java.io.*;

@Component
public class MyFiter_3 implements Filter {


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        System.out.println("Filter 3 is called");
        chain.doFilter(request, response);
    }
}
