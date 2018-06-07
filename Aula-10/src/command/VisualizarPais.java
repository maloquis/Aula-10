/**
 * 
 */
/**
 * @author Rafael Silva
 *
 */
package command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Pais;
import service.PaisService;

public class VisualizarPais implements Command {

	@Override
	public void executar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String pId = request.getParameter("id");
		String pNome = request.getParameter("nome");
		String pArea = request.getParameter("area");
		String pPopulacao = request.getParameter("populacao");
		 long populacao = -1;
	      double area = -1;		   	
	      int id = -1;
	      
	      try {
	         id = Integer.parseInt(pId);
	         populacao = Long.parseLong(pPopulacao);
	         area = Double.parseDouble(pArea);
	      } catch (NumberFormatException e) {
	      
	      }

	      Pais pais = new Pais();
	      pais.setId(id);
	      pais.setNome(pNome);
	      pais.setPopulacao(populacao);
	      pais.setArea(area);
	      PaisService cs = new PaisService();
	     
	      RequestDispatcher view = null; 

		pais = cs.carregar(pais.getId());
		request.setAttribute("pais", pais);
		view = request.getRequestDispatcher("VisualizarPais.jsp");

		view.forward(request, response);

	}

}
