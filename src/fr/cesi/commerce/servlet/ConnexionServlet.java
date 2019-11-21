package fr.cesi.commerce.servlet;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.jersey.api.client.Client;

import fr.cesi.commerce.dao.jpa.DaoFactory;
import fr.cesi.commerce.entity.Employe;

/**
 * Servlet implementation class InscriptionServlet
 */
@WebServlet("/connexion")
public class ConnexionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConnexionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*HttpServletRequest httpRequest = (HttpServletRequest) request ;
		HttpSession session = request.getSession();
		String user = request.getParameter("nom") ;
		String pass = request.getParameter("pass") ;
		
		JpaEmployeDao empDao = (JpaEmployeDao)DaoFactory.getEmployeDao() ;
		Employe e = empDao.connexionEmp(user, pass) ;
		
		if(e == null) {
			HttpServletResponse res = (HttpServletResponse) response;	
			res.sendRedirect( httpRequest.getContextPath() + "/connexion.jsp" );
		}
		else {
			session.setAttribute("user", user);
			HttpServletResponse res = (HttpServletResponse) response;	
			res.sendRedirect( httpRequest.getContextPath() + "/index.jsp" );
		}*/
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
