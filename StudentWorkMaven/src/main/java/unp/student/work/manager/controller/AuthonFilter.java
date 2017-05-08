package unp.student.work.manager.controller;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//权限验证过滤器
@WebFilter(dispatcherTypes = {DispatcherType.REQUEST }
,urlPatterns = { "/*" })
public class AuthonFilter implements Filter {

	private String logPage="/login.jsp";
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		String request_uri = req.getRequestURI();
		String contextPath = req.getContextPath();
		String uri = request_uri.substring(contextPath.length());
		if (req.getSession().getAttribute("user") == null) {
			if (uri.equals(logPage) || request_uri.indexOf("css/") > 0
					|| request_uri.indexOf("images/") > 0
					|| request_uri.indexOf("scripts/") > 0
					|| uri.equals("/user/verifyUser.action")) {
				chain.doFilter(request, response);
				return;
			}
			else
			{
				res.sendRedirect("login.jsp");
			}
		}
		else chain.doFilter(request, response);


	}

	public void destroy() {
		// TODO Auto-generated method stub

	}

}
