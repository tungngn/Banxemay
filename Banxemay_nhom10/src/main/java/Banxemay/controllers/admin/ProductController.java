package Banxemay.controllers.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import Banxemay.models.CategoryModels;
import Banxemay.models.ProductModel;
import Banxemay.models.Seller;
import Banxemay.services.CategoryServiceImpl;
import Banxemay.services.ICategoryService;
import Banxemay.services.IProductService;
import Banxemay.services.ProductServiceImpl;
import Banxemay.utils.Constant;
import Banxemay.utils.UploadUtils;

@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 10, maxFileSize = 1024 * 1024 * 50, maxRequestSize = 1024 * 1024 * 50)

@WebServlet(urlPatterns = { "/admin/product/listproduct", "/admin/product/findprobycate", "/admin/product/admin-insertpro","/admin/product/delete", "/admin/product/update" })
public class ProductController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	IProductService proService = new ProductServiceImpl();
	ICategoryService cateService = new CategoryServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI().toString();
		if (url.contains("listproduct")) {

			List<ProductModel> list = proService.findAll();
			req.setAttribute("listpro", list);
			String setActiveHeader = "product";
			req.setAttribute("setActiveHeader", setActiveHeader);
			RequestDispatcher rd = req.getRequestDispatcher("/views/product/listProduct.jsp");
			rd.forward(req, resp);

		} else if (url.contains("findprobycate")) {
			int id = Integer.parseInt(req.getParameter("cateID"));

			List<ProductModel> list1 = proService.findProductByCategory(id);
			req.setAttribute("listpro", list1);

			RequestDispatcher rd = req.getRequestDispatcher("/views/product/listProduct.jsp");
			rd.forward(req, resp);

		} else if (url.contains("admin-insertpro")) {
			List<CategoryModels> list = cateService.findAll();
			req.setAttribute("list", list);
			RequestDispatcher rd = req.getRequestDispatcher("/views/product/addProduct.jsp");
			rd.forward(req, resp);
		}
			
		else if(url.contains("update")) {
			int id = Integer.parseInt(req.getParameter("id"));
			ProductModel model = proService.findOne(id);
			req.setAttribute("pro", model);
			RequestDispatcher rd = req.getRequestDispatcher("/views/product/updateProduct.jsp");
			rd.forward(req, resp);
			
		} else if (url.contains("delete")) {
			delete(req, resp);
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI().toString();
		if (url.contains("admin-insertpro")) {
			insert(req, resp);
			List<ProductModel> list = proService.findAll();
			req.setAttribute("listpro", list);

			RequestDispatcher rd = req.getRequestDispatcher("/views/product/listProduct.jsp");
			rd.forward(req, resp);

		}else if(url.contains("update")) {
			update(req,resp);
		}

	}
	
	protected void productPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String cateID = req.getParameter("cateID");
		String sellerid = req.getParameter("sellerid");
		String indexPage = req.getParameter("index");
		
		//Phân trang
		//Khởi tạo trang đầu
		if (indexPage == null) {
			indexPage = "1";
		}
		if (cateID == null) {
			cateID = "0";
		}
		if (sellerid == null) {
			sellerid = "0";
		}
		int indexp = Integer.parseInt(indexPage);
		
		//Get data từ DAO
		int countP = proService.countAll();
		int countCID = proService.countCID(Integer.parseInt(cateID));
		int countSID = proService.countSell(Integer.parseInt(sellerid));
		
		//chia trang cho count
		int endPage = countP/3;
		if(countP % 3 != 0) {
			endPage ++;
		}
		
		if(Integer.parseInt(cateID)==0 && Integer.parseInt(sellerid)==0) {
			List<ProductModel> listproduct = proService.findAllPage(indexp-1);
			req.setAttribute("listproduct", listproduct);
			req.setAttribute("countproductAll", countP);
			
		} else if(Integer.parseInt(cateID)==0 && Integer.parseInt(sellerid)==0) {
			List<ProductModel> listproduct = proService.findAllByCID(Integer.parseInt(cateID), indexp-1);
			req.setAttribute("listproduct", listproduct);
			req.setAttribute("countproductAll", countCID);
			
		}else if(Integer.parseInt(cateID)==0 && Integer.parseInt(sellerid)==0) {
			List<ProductModel> listproduct = proService.findAllBySeller(Integer.parseInt(sellerid), indexp-1);
			req.setAttribute("listproduct", listproduct);
			req.setAttribute("countproductAll", countSID);
		}
		// lay du lieu va day len view
		List<CategoryModels> cateList = cateService.findAll();
		req.setAttribute("cateList", cateList);
		
		List<Seller> sellerList = sellerService.findAll();
		req.setAttribute("sellerList", sellerList);
		
		//Truyền lên JSP
			req.setAttribute("endPage", endPage);
			req.setAttribute("tag", indexp);
			req.setAttribute("cateID", cateID);
			req.setAttribute("sellid", sellerid);
			
		req.getRequestDispatcher("/views/product/listProduct.jsp").forward(req, resp);
	}

	private void insert(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");

		ProductModel model = new ProductModel();
		try {
			// lay du lieu tu jsp bang beanUtils
			BeanUtils.populate(model, req.getParameterMap());
			// xu ly truong image
			if (req.getPart("imageLink").getSize() != 0) {
				String fileName = "" + System.currentTimeMillis();
				model.setImageLink(UploadUtils.processUpload("imageLink", req, Constant.DIR + "\\product\\", fileName));
			}
			model.setCategory(cateService.findOne(model.getCategoryID()));

			proService.insert(model);

			// thong bao
			req.setAttribute("product", model);
			req.setAttribute("message", "Add successful");

		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("error", "Add fails");
		}

		// resp.sendRedirect(req.getContextPath() + "/listproduct");

	}
	
	
	private void update(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		//thiet lap ngon ngu
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
						
		//nhan du lieu tu form
		String productName = req.getParameter("productName");
		String imageLink = req.getParameter("imageLink");
		String desc = req.getParameter("desc");
		int price = Integer.parseInt(req.getParameter("price"));
		int categoryID = Integer.parseInt(req.getParameter("categoryID"));
		int sellerID = Integer.parseInt(req.getParameter("sellerID"));
		int amount = Integer.parseInt(req.getParameter("amount"));
		int stoke = Integer.parseInt(req.getParameter("stoke"));
		int id = Integer.parseInt(req.getParameter("productID"));
						
		//Dua du lieu vao model
		ProductModel model = new ProductModel();
		model.setProductID(id);
		model.setProductName(productName);
		model.setDesc(desc);
		model.setPrice(price);
		model.setCategoryID(categoryID);
		model.setSellerID(sellerID);
		model.setAmount(amount);
		model.setStoke(stoke);
		model.setImageLink(imageLink);
						
		//goi phuong thuc insert trong services
		proService.update(model);
						
		//tra ve view (chuyen trang)
		resp.sendRedirect(req.getContextPath() + "/admin/product/listproduct");
		
	}

	private void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		int id = Integer.parseInt(req.getParameter("id"));
		try {
			proService.delete(id);
			req.setAttribute("message", "Xoá thành công");
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("error", "Thất bại");
		}
		RequestDispatcher rd = req.getRequestDispatcher("listproduct");
		rd.forward(req, resp);

	}
	
}
