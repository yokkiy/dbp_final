package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Connect.Connect;
import Connect.ConnectDAO;
import Doppel.Doppel;
import Doppel.DoppelDAO;
import Magia.Magia;
import Magia.MagiaDAO;

/**
 * Servlet implementation class Controller
 */
@WebServlet( "/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("UTF-8");
		if(request.getParameter("check").equals("girl")){
			
			getServletContext().getRequestDispatcher("/magicalGirlManager").forward(request, response);
		}else if(request.getParameter("check").equals("girl1")){
			getServletContext().getRequestDispatcher("/magicalGirlManager").forward(request, response);
		}else{
			
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		if(request.getParameter("check").equals("sinki")){//新規登録画面
			getServletContext().getRequestDispatcher("/magicalGirlManager").forward(request, response);
			
		} else if(request.getParameter("check").equals("girl")){
			
			getServletContext().getRequestDispatcher("/magicalGirlManager").forward(request, response);
		}else if(request.getParameter("check").equals("serch")){
			getServletContext().getRequestDispatcher("/magicalGirlManager").forward(request, response);
		}else if(request.getParameter("check").equals("attribute")){
			getServletContext().getRequestDispatcher("/magicalGirlManager").forward(request, response);
		}else if(request.getParameter("check").equals("rarity")){
			getServletContext().getRequestDispatcher("/magicalGirlManager").forward(request, response);
		}else if(request.getParameter("check").equals("abc")){
			if(request.getParameter("d").equals("Connect")){
				Connect c = new Connect();
				ConnectDAO dao = new ConnectDAO();
				c.setName(request.getParameter("a"));
				c.setName(request.getParameter("b"));
				c.setGirl(request.getParameter("c"));
				dao.add(c);
			}else if(request.getParameter("d").equals("Magia")){
				Magia c = new Magia();
				MagiaDAO dao = new MagiaDAO();
				c.setName(request.getParameter("a"));
				c.setName(request.getParameter("b"));
				c.setGirl(request.getParameter("c"));
				dao.add(c);
			}else if(request.getParameter("d").equals("Doppel")){
				Doppel c = new Doppel();
				DoppelDAO dao = new DoppelDAO();
				c.setName(request.getParameter("a"));
				c.setName(request.getParameter("b"));
				c.setGirl(request.getParameter("c"));
				dao.add(c);
			}
		}else if(request.getParameter("check").equals("delete")){
			List<Connect>list1=new ArrayList<>();
			ConnectDAO dao1= new ConnectDAO();
			List<Magia>list2=new ArrayList<>();
			MagiaDAO dao2= new MagiaDAO();
			List<Doppel>list3=new ArrayList<>();
			DoppelDAO dao3 = new DoppelDAO();
			list1 = dao1.getList();
			list2 = dao2.getList();
			list3 = dao3.getList();
			request.setAttribute("list1", list1);
			request.setAttribute("list2", list2);
			request.setAttribute("list3", list3);
			getServletContext().getRequestDispatcher("/delete.jsp").forward(request, response);
		}else if(request.getParameter("check").equals("add")){
			getServletContext().getRequestDispatcher("/add.jsp").forward(request, response);
		}else if(request.getParameter("check").equals("del")){
			if(request.getParameter("aa")!=null){
				ConnectDAO dao = new ConnectDAO();
				String list[] = request.getParameterValues("aa");
				for(int i =0;i<list.length;i++){
				dao.delete(list[i]);
				}
			}
            if(request.getParameter("bb")!=null){
            	MagiaDAO dao = new MagiaDAO();
				String list[] = request.getParameterValues("bb");
				for(int i =0;i<list.length;i++){
				dao.delete(list[i]);
				}
			}
            if(request.getParameter("cc")!=null){
            	DoppelDAO dao = new DoppelDAO();
				String list[] = request.getParameterValues("cc");
				System.out.println(request.getParameter("cc"));
				for(int i =0;i<list.length;i++){
				dao.delete(list[i]);
				}
			}
            List<Connect>list1=new ArrayList<>();
			ConnectDAO dao1= new ConnectDAO();
			List<Magia>list2=new ArrayList<>();
			MagiaDAO dao2= new MagiaDAO();
			List<Doppel>list3=new ArrayList<>();
			DoppelDAO dao3 = new DoppelDAO();
			list1 = dao1.getList();
			list2 = dao2.getList();
			list3 = dao3.getList();
			request.setAttribute("list1", list1);
			request.setAttribute("list2", list2);
			request.setAttribute("list3", list3);
			getServletContext().getRequestDispatcher("/delete.jsp").forward(request, response);
		}else if(request.getParameter("check").equals("get")) {
			getServletContext().getRequestDispatcher("/magicalGirlManager").forward(request, response);
		}else if(request.getParameter("check").equals("get1")) {
			getServletContext().getRequestDispatcher("/magicalGirlManager").forward(request, response);
		}else if(request.getParameter("check").equals("girl1")){
			getServletContext().getRequestDispatcher("/magicalGirlManager").forward(request, response);
		}else{
			
		}
	}

}
