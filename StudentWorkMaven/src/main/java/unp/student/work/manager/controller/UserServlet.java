package unp.student.work.manager.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;

import unp.student.work.manager.dao.GroupStudentDao;
import unp.student.work.manager.dao.impl.GroupStudentDaoImpl;;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/User")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		GroupStudentDao userDao=new GroupStudentDaoImpl();
		String type=request.getParameter("type");
		switch (type) {
		case "1":
			String userName=request.getParameter("userName");
			String password=request.getParameter("password");
			HttpSession session=request.getSession();
			boolean flag=userDao.validate(userName, password);
			boolean flags=userDao.studentquanxian(userName, password);
			Integer quanxian = 0;
			if (flag) {
				
				session.setAttribute("user", userName);
				if(flags){
					quanxian = 1;
					session.setAttribute("qx", 1);
				}
				else
					session.setAttribute("qx", 0);
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}else{
				boolean flagt=userDao.teacherquanxian(userName, password);
				if(flagt){
					quanxian = 2;
					session.setAttribute("qx", quanxian);
					session.setAttribute("user", userName);
					request.getRequestDispatcher("index.jsp").forward(request, response);
				}
				else{
				request.getRequestDispatcher("login.jsp").forward(request, response);
				}
			}
			break;

		case "2":
			request.getSession().removeAttribute("user");
			request.getRequestDispatcher("login.jsp").forward(request, response);
			break;
		default:
			break;
		}
		
		

		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
