package Banxemay.controllers.admin;

import java.io.IOException;
import java.util.List;



import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Banxemay.models.CategoryModels;
import Banxemay.services.CategoryServiceImpl;
import Banxemay.services.ICategoryService;

@WebServlet(urlPatterns = {"/admin/category/findAll", "/admin/category/add", "/admin/category/update", "/admin/category/delete"})
public class CategoryController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	//goi cac phuong thuc trong service
	ICategoryService cateService = new CategoryServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String url = req.getRequestURI().toString();
		if(url.contains("findAll")) {
			String setActiveHeader = "categories";
			req.setAttribute("setActiveHeader", setActiveHeader);
			findAll(req,resp);
			
		}else if (url.contains("add")) {
			RequestDispatcher rd = req.getRequestDispatcher("/views/category/addCategory.jsp");
			rd.forward(req, resp);
			
		}else if(url.contains("update")) {
			int id = Integer.parseInt(req.getParameter("id"));
			CategoryModels model = cateService.findOne(id);
			req.setAttribute("cate", model);
			RequestDispatcher rd = req.getRequestDispatcher("/views/category/updateCategory.jsp");
			rd.forward(req, resp);
			
		}else if(url.contains("delete")) {
			delete(req,resp);
		}
			
		
	}
	
	private void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		int id = Integer.parseInt(req.getParameter("id"));
		try {
			cateService.delete(id);
			req.setAttribute("message", "Xoá thành công");
		}catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("error", "Thất bại");
		}
		RequestDispatcher rd = req.getRequestDispatcher("findAll");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI().toString();
		if(url.contains("add")) {
			insert(req,resp);
		}else if(url.contains("update")) {
			update(req,resp);
		}
		
	}

	private void update(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		//thiet lap ngon ngu
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
						
		//nhan du lieu tu form
		String cateName = req.getParameter("cateName");
		String image = req.getParameter("image");
		int id = Integer.parseInt(req.getParameter("cateID"));
						
		//Dua du lieu vao model
		CategoryModels model = new CategoryModels();
		model.setCateID(id);
		model.setCateName(cateName);
		model.setImage(image);
						
		//goi phuong thuc insert trong services
		cateService.update(model);
						
		//tra ve view (chuyen trang)
		resp.sendRedirect(req.getContextPath() + "/admin/category/findAll");
		
	}

	private void insert(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		//thiet lap ngon ngu
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
				
		//nhan du lieu tu form
		String cateName = req.getParameter("cateName");
		String image = req.getParameter("image");
				
		//Dua du lieu vao model
		CategoryModels model = new CategoryModels();
		model.setCateName(cateName);
		model.setImage(image);
				
		//goi phuong thuc insert trong services
		cateService.insert(model);
				
		//tra ve view (chuyen trang)
		resp.sendRedirect(req.getContextPath() + "/admin/category/findAll");
	}

	private void findAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<CategoryModels> list = cateService.findAll();

		// đẩy DL ra view
		req.setAttribute("list", list);

		// view nhận DL
		RequestDispatcher rd = req.getRequestDispatcher("/views/category/listCategory.jsp");
		rd.forward(req, resp);
	}

}
