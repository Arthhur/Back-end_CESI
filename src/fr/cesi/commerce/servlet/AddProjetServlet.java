package fr.cesi.commerce.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.cesi.commerce.dao.jpa.DaoFactory;
import fr.cesi.commerce.dao.jpa.JpaCommentaireDao;
import fr.cesi.commerce.dao.jpa.JpaProjetDao;
import fr.cesi.commerce.dao.jpa.JpaRoleDao;
import fr.cesi.commerce.dao.jpa.JpaServiceDao;
import fr.cesi.commerce.entity.Projet;
import fr.cesi.commerce.entity.Role;
import fr.cesi.commerce.entity.Service;

/**
 * Servlet implementation class AddCategoryServlet
 */
@WebServlet("/addProjet")
public class AddProjetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProjetServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String description = request.getParameter("description") ;
		String titre = request.getParameter("titre") ;
		
		String date = request.getParameter("date") ;
		
		Long id = Long.parseLong(request.getParameter("service")) ;
		Projet projet = new Projet() ;
		JpaServiceDao serviceDao= (JpaServiceDao)DaoFactory.getServiceDao() ;
		Service service = serviceDao.findServiceById(id) ;
		projet.setDeadline(date);
		projet.setDescription(description);
		projet.setTitre(titre);
		projet.setService(service);
		
		JpaProjetDao projetDao = (JpaProjetDao)DaoFactory.getProjetDao() ;
		projetDao.addProjet(projet) ;
		ServletContext context = getServletContext();
		RequestDispatcher dispatcher = context.getRequestDispatcher("/listProjet.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
