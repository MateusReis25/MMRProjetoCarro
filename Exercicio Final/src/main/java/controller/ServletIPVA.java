package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.DaoIPVA;
import model.IPVA;


/**
 * Servlet implementation class ServletPimpolhos
 */
@WebServlet("/ServletIPVA")
public class ServletIPVA extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private DaoIPVA dao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletIPVA() {
        super();
        // TODO Auto-generated constructor stub
        this.dao = new DaoIPVA();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
		String optionIpva = request.getParameter("optionIpva");
		if (optionIpva == null) {
			optionIpva = "Opção Invalida";
		}
		switch(optionIpva) {
		case ("insertFormIpva"):
			showInsertUserIpva(request, response);
		break;
		case ("updateFormIpva"):
			showUpdateUserIpva(request, response);
		break;
		case ("atualizarIpva"):
			updateUserIpva(request, response);
		break;
		case ("deleteIpva"):
			deleteUserIpva(request, response);
		break;
		case ("insertIpva"):
			insertUserIpva(request, response);
		break;
		default:
			selectAllUsersIpva(request, response);
		}
	
	}
	
	private void showInsertUserIpva(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.getRequestDispatcher("formIpva.jsp").forward(request, response);
	}
	
	private void showUpdateUserIpva(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		Integer id = Integer.parseInt(request.getParameter("cod_ipva"));
		IPVA ipva = this.dao.recuperarIpva(id);
		request.setAttribute("ipva", ipva);
		request.getRequestDispatcher("formIpva.jsp").forward(request, response);
	}
	
	private void insertUserIpva(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		Integer anoBack = Integer.parseInt(request.getParameter("anoIpva"));
		
		if (anoBack != null) {
			if (!anoBack.equals("")){
			IPVA ipva = new IPVA(anoBack);
			this.dao.inserirIpva(ipva);
			}
		}
		response.sendRedirect("ServletIPVA");
	}
	
	private void selectAllUsersIpva(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		request.setAttribute("listIpva", this.dao.exibirIpva());
		request.getRequestDispatcher("indexIpva.jsp").forward(request, response);
	}
	
	private void deleteUserIpva(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idBack = request.getParameter("cod_ipva");
		if (idBack != null) {
			if (!idBack.equals("")){
			Integer id = Integer.parseInt(idBack);
			this.dao.deletarIpva(id);
			}
		}
		response.sendRedirect("ServletIPVA");
	}
	
	private void updateUserIpva(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String idBack = request.getParameter("cod_ipva");
		Integer anoBack = Integer.parseInt(request.getParameter("anoIpva"));
		
		if ((idBack != null) && (anoBack != null)) { 
			if (!anoBack.equals("")){
				Integer id = Integer.parseInt(idBack);
				IPVA ipva = new IPVA (anoBack);
				ipva.setCod_ipva(id);
				this.dao.atualizarIpva(ipva);
			}
			
		}
		response.sendRedirect("ServletIPVA");
	}
	
	
}