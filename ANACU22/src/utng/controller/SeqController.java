package utng.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utng.dom.PropDOM;
import utng.model.Prop;

/**
 * Servlet implementation class SeqController
 */
@WebServlet("/SeqController")
public class SeqController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Prop prop;
	private List<Prop> props;
	private PropDOM propDOM;
	private List<String> ids = new ArrayList<String>();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SeqController() {
        super();
        prop = new Prop();
        props = new ArrayList<>();
        propDOM = new PropDOM();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("btn_save")!=null) {
			prop.setPk(request.getParameter("pk"));
			prop.setPv(request.getParameter("pv"));
			prop.setDesc(request.getParameter("desc"));
			try {
				prop.setSeq(Integer.parseInt(request.getParameter("seq")));
			}catch(NumberFormatException e) {
				prop.setSeq(0);
			}
			/*if(licor.getId()=="") {
				int id=1;
				String newId="";
				for(Licor l: licores) {
					newId ="lcr"+String.format("%05d",id++);
					if(!newId.equals(l.getId())) {
						licor.setId(newId);
						continue;
					}
				}*/
				if(prop.getId()=="") {
					
					String newId = "sp"+String.format("%03d",1);
					prop.setId(newId);
					if(props.size()>0) {
						ids.clear();
						for(Prop p: props) {
							ids.add(p.getId());
						}
						for(int i=0; i<=ids.size(); i++) {
							newId = "sp"+String.format("%03d",i+1);
							if(!ids.contains(newId)) {
								prop.setId(newId);
								break;
							}
						}
					}
				
				propDOM.add(prop);
			}else {
				propDOM.update(prop);
			}
			props= propDOM.getProps();
			request.setAttribute("props", props);
			request.getRequestDispatcher("prop_list.jsp").forward(request, response);
	}else if(request.getParameter("btn_new")!=null) {
		prop = new Prop();
		request.getRequestDispatcher(
				"prop_form.jsp").forward(request, response);
	}else if(request.getParameter("btn_edit")!=null) {
		try {
			String id = request.getParameter("id"); 
			prop = propDOM.findById(id);
		}catch(Exception e) {
			prop = new Prop();
		}
		request.setAttribute("prop", prop);
		request.getRequestDispatcher("prop_form.jsp").forward(request, response);
	}else if(request.getParameter("btn_delete")!=null) {
		try {
			String id = request.getParameter("id");
			propDOM.delete(id);
			props=propDOM.getProps();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		request.setAttribute("props", props);
		request.getRequestDispatcher("prop_list.jsp").forward(request, response);
		
	}else {
		props = propDOM.getProps();
		request.setAttribute("props", props);
		request.getRequestDispatcher("prop_list.jsp").forward(request, response);
	}
		
	}		
		
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
