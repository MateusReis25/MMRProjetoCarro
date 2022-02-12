package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Dao;
import model.Carro;

/**
 * Servlet implementation class ServletPimpolhos
 */
@WebServlet("/ServletCarro")
public class ServletCarro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private Dao dao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCarro() {
        super();
        // TODO Auto-generated constructor stub
        this.dao = new Dao();
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
		
		
		
		String option = request.getParameter("option");
		if (option == null) {
			option = "Opção Invalida";
		}
		switch(option) {
			case ("insertForm"):
				showInsertUser(request, response);
			break;
			case ("updateForm"):
				showUpdateUser(request, response);
			break;
			case ("update"):
				updateUser(request, response);
			break;
			case ("delete"):
				deleteUser(request, response);
			break;
			case ("insert"):
				insertUser(request, response);
			break;
			default:
				selectAllUsers(request, response);
		}
		
	}

	
	
	private void showInsertUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.getRequestDispatcher("form.jsp").forward(request, response);
	}
	
	private void showUpdateUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		Integer id = Integer.parseInt(request.getParameter("cod_veiculo"));
		Carro carro = this.dao.recuperarVeiculo(id);
		request.setAttribute("carro", carro);
		request.getRequestDispatcher("form.jsp").forward(request, response);
	}
	
	private void insertUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String modeloBack = request.getParameter("modelo");
		Integer anoBack = Integer.parseInt(request.getParameter("ano"));
		
		if ((modeloBack != null) && (anoBack != null)) {
			if (!modeloBack.equals("")){
				Carro carro = new Carro(modeloBack, anoBack);
				this.dao.inserir(carro);
	}
		}
		response.sendRedirect("ServletCarro");
	}
	
	private void selectAllUsers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		request.setAttribute("listUser", this.dao.exibir());
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
	
	private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idBack = request.getParameter("cod_veiculo");
		if (idBack != null) {
			Integer id = Integer.parseInt(idBack);
			this.dao.deletar(id);
		}
		response.sendRedirect("ServletCarro");
	}
	
	private void updateUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String idBack = request.getParameter("cod_veiculo");
		String modeloBack = request.getParameter("modelo");
		Integer anoBack = Integer.parseInt(request.getParameter("ano"));
		
		if ((modeloBack != null) && (idBack != null) && (anoBack != null)) {
			if (!modeloBack.equals("")){
				Integer id = Integer.parseInt(idBack);
				Carro carro = new Carro (modeloBack, anoBack);
				carro.setCod_veiculo(id);
				this.dao.atualizar(carro);
			}
		}
		response.sendRedirect("ServletCarro");
	
	}
	
	
	
	
}