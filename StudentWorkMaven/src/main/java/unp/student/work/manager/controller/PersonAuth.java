package unp.student.work.manager.controller;

import java.util.Map;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class PersonAuth extends AbstractInterceptor  //权限检查拦截器继承AbstractInterceptor类
{
    public String intercept(ActionInvocation invocation)throws Exception
	{
		ActionContext ctx = invocation.getInvocationContext();  //通过ActionInvocation取得当前请求的ActionContext实例
		Map<String, Object> session = ctx.getSession();
		String studentid = (String)session.get("studentid");  //取出session中属性为studentid的值
		if(studentid == null)  //如果为空，则返回failure 跳转到登陆界面
		{
			//System.out.println("拦截器中发现user==null");
			return "failure";
		}
		else	//如果不为空，则放行，进入UserAction验证username
		{
			//System.out.println("拦截器中发现studentid不为空！！！！！！");
			return invocation.invoke();  //放行
		}		
    }
}