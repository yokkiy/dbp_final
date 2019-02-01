package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Connect.ConnectDAO;
import Doppel.DoppelDAO;
import Magia.MagiaDAO;
import magicalGirl.magicalGirl;
import magicalGirl.magicalGirlDAO;

/**
 * Servlet implementation class magicalGirlManager
 */
@WebServlet("/magicalGirlManager")

public class magicalGirlManager extends HttpServlet {
	private static final long serialVersionUID = 1L;
    magicalGirl magicalgirl; 
    magicalGirlDAO magicalgirldao;
   
  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public magicalGirlManager() {
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
			List<magicalGirl> list = new ArrayList<>();
			
			magicalGirl mg1 = new magicalGirl();
			magicalGirl mg2 = new magicalGirl();
			
			mg1.setID(Integer.parseInt(request.getParameter("ID")));
			
			magicalGirlDAO dao = new magicalGirlDAO();
			mg2 = dao.getMG1(mg1);
			list = dao.getlist(mg1);
			
			request.setAttribute("magicalGirlList", list);
			
			ConnectDAO cdao = new ConnectDAO();
			cdao.getConnect(mg2);
			request.setAttribute("cdao", cdao.getConnect(mg2));
			DoppelDAO ddao = new DoppelDAO();
			ddao.getDoppel(mg2);
			request.setAttribute("ddao", ddao.getDoppel(mg2));
			MagiaDAO mdao = new MagiaDAO();
			mdao.getMagia(mg2);
		    request.setAttribute("mdao", mdao.getMagia(mg2));
			
			getServletContext().getRequestDispatcher("/record.jsp").forward(request, response);
		}else if(request.getParameter("check").equals("girl1")){
			magicalGirlDAO dao = new magicalGirlDAO();
			List<magicalGirl>list=new ArrayList<>();
			list = dao.hasList();
			request.setAttribute("list", list);
			getServletContext().getRequestDispatcher("/have.jsp").forward(request, response);
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
		getServletContext().getRequestDispatcher("/uploadData.jsp").forward(request, response);
		
	}else if(request.getParameter("check").equals("touroku")) {
		
		if(request.getParameter("name")!=null||request.getParameter("rarity")!=null||
				request.getParameter("attribute")!=null||request.getParameter("connect")!=null
				 ||request.getParameter("magia")!=null||
				 request.getParameter("card")!=null){
		
			magicalgirl = new magicalGirl();
			magicalgirldao = new magicalGirlDAO();
			magicalgirl.setName(request.getParameter("name"));
	 magicalgirl.setCard(request.getParameter("card"));
			magicalgirl.setAttribute(request.getParameter("attribute"));
			magicalgirl.setRarity(request.getParameter("rarity"));
			magicalgirl.setConnect(request.getParameter("connect"));
			magicalgirl.setDoppel(request.getParameter("doppel"));
			magicalgirl.setMagia(request.getParameter("magia"));
			magicalgirldao.addM(magicalgirl);
			getServletContext().getRequestDispatcher("/uploadData.jsp").forward(request, response);
			
		}else{

			
			request.setAttribute("message", "入力されていない項目があります");
			getServletContext().getRequestDispatcher("/uploadData.jsp").forward(request, response);
		}
		
	}else if(request.getParameter("check").equals("girl")){
		List<magicalGirl> list = new ArrayList<>();
	
		magicalGirl mg1 = new magicalGirl();
		magicalGirl mg2 = new magicalGirl();
		
		mg1.setID(Integer.parseInt(request.getParameter("ID")));
		
		magicalGirlDAO dao = new magicalGirlDAO();
		mg2 = dao.getMG1(mg1);
		list = dao.getlist(mg1);
		
		request.setAttribute("magicalGirlList", list);
		
		ConnectDAO cdao = new ConnectDAO();
		cdao.getConnect(mg2);
		request.setAttribute("cdao", cdao.getConnect(mg2));
		DoppelDAO ddao = new DoppelDAO();
		ddao.getDoppel(mg2);
		request.setAttribute("ddao", ddao.getDoppel(mg2));
		MagiaDAO mdao = new MagiaDAO();
		mdao.getMagia(mg2);
	    request.setAttribute("mdao", mdao.getMagia(mg2));
		
		getServletContext().getRequestDispatcher("/record.jsp").forward(request, response);
	}else if(request.getParameter("check").equals("serch")){
		List<magicalGirl> list = new ArrayList<>();
		magicalGirlDAO dao = new magicalGirlDAO();
		list = dao.serchMID(request.getParameter("keyword"));
		request.setAttribute("Afterlist", list);
		getServletContext().getRequestDispatcher("/serchList.jsp").forward(request, response);
	}else if(request.getParameter("check").equals("attribute")){
		
		List<magicalGirl> list = new ArrayList<>();
		magicalGirlDAO dao = new magicalGirlDAO();
		list = dao.serchA(request.getParameter("attribute"));
		request.setAttribute("Afterlist", list);
		getServletContext().getRequestDispatcher("/serchList.jsp").forward(request, response);
	}else if(request.getParameter("check").equals("rarity")){
		
		List<magicalGirl> list = new ArrayList<>();
		magicalGirlDAO dao = new magicalGirlDAO();
		list = dao.serchR(request.getParameter("rarity"));
		request.setAttribute("Afterlist", list);
		getServletContext().getRequestDispatcher("/serchList.jsp").forward(request, response);
	}else if(request.getParameter("check").equals("get")){
		List<magicalGirl>list=new ArrayList<>();
		magicalGirlDAO dao = new magicalGirlDAO();
		list = dao.NothasList();
		request.setAttribute("list", list);
		getServletContext().getRequestDispatcher("/update.jsp").forward(request, response);
		
	}else if(request.getParameter("check").equals("get1")) {
		
		if(request.getParameter("mg")!=null){
			String[] list = request.getParameterValues("mg");
			magicalGirlDAO dao = new magicalGirlDAO();
			
			for(int i=0;i<list.length;i++){
				dao.changeFlag(Integer.parseInt(list[i]));
			}
		}
		List<magicalGirl>list=new ArrayList<>();
		magicalGirlDAO dao = new magicalGirlDAO();
		list = dao.NothasList();
		request.setAttribute("list", list);
		getServletContext().getRequestDispatcher("/update.jsp").forward(request, response);
	}else if(request.getParameter("check").equals("girl1")){
		magicalGirlDAO dao = new magicalGirlDAO();
		List<magicalGirl>list=new ArrayList<>();
		list = dao.hasList();
		request.setAttribute("list", list);
		getServletContext().getRequestDispatcher("/have.jsp").forward(request, response);
	}else{
		
	}
	
	
	}

}
