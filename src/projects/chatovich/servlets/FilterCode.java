package projects.chatovich.servlets;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import java.io.IOException;

/**
 * Filter for encodings
 */

/*@WebFilter(urlPatterns = {"*//*"},
        initParams = {
                @WebInitParam(name = "encoding", value = "UTF-8", description = "Encoding Param")})*/

public class FilterCode implements Filter {

    private String code;

    public void init(FilterConfig fConfig) throws ServletException {
        code = fConfig.getInitParameter("encoding");
        if (code==null)
            code="UTF-8";
    }

    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        String codeResponse = response.getCharacterEncoding();
        // установка кодировки ответа из параметров фильтра, если не установлена
        if (code != null && !code.equalsIgnoreCase(codeResponse)) {
            response.setCharacterEncoding(code);
        }

        String codeRequest = request.getCharacterEncoding();
        // установка кодировки запроса из параметров фильтра, если не установлена
        if (code != null && !code.equalsIgnoreCase(codeRequest)) {
            request.setCharacterEncoding(code);
        }
        //обработка прочих фильтров
        chain.doFilter(request, response);
    }

    public void destroy() {
        code = null;
    }
}
