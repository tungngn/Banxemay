package Banxemay.controllers.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Banxemay.models.CategoryModels;
import Banxemay.models.ProductModel;
import Banxemay.services.CategoryServiceImpl;
import Banxemay.services.ICategoryService;
import Banxemay.services.IProductService;
import Banxemay.services.IUserService;
import Banxemay.services.ProductServiceImpl;
import Banxemay.services.UserServiceImpl;

@WebServlet(urlPatterns = {"/user/home","/user/listprocate","/user/detail","/user/login","/user/register","/user/forgotpass","/user/waiting","/user/verifycode"})
public class HomeController extends HttpServlet {

	
	private static final long serialVersionUID = 1L;
	ICategoryService cateService = new CategoryServiceImpl();
	IProductService proService = new ProductServiceImpl();
	IUserService userService = new UserServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURL().toString();
		if(url.contains("home")) {
//			List<ProductModel> listProducts = proService.findAll();
			List<ProductModel> listTop10Product = proService.find10Top();
//			req.setAttribute("listpro", list1);
			req.setAttribute("listpro", listTop10Product);
			String title = "Sản phẩm nổi bật";
			req.setAttribute("title", title);
			String setActiveHeader = "home";
			req.setAttribute("setActiveHeader", setActiveHeader);
		}else if(url.contains("listprocate")) {
			
			int id = Integer.parseInt(req.getParameter("cateID"));
			
			List<ProductModel> list2 = proService.findProductByCategory(id);
			req.setAttribute("listpro", list2);
			req.setAttribute("setactive", id);
			String title = "Danh sách sản phẩm";
			req.setAttribute("title", title);
			
		}else if(url.contains("detail")) {
			
			int id = Integer.parseInt(req.getParameter("id"));
			ProductModel product = proService.findOne(id);
			req.setAttribute("product", product);
			req.getRequestDispatcher("/views/users/detail.jsp").forward(req, resp);
			
		}
		
		List<CategoryModels> list = cateService.findAll();
		req.setAttribute("listcate", list);
		
		List<ProductModel> countCID = proService.count();
		req.setAttribute("countCID", countCID);
		
		req.getRequestDispatcher("/views/users/home.jsp").forward(req, resp);
		
	}

}
