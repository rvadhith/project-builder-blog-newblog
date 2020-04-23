package controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Blog;
import model.User;

@WebServlet(urlPatterns= {"/blog"})
public class BlogController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public BlogController() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd=this.getServletContext().getRequestDispatcher("/WEB-INF/views/blogView.jsp");
		rd.forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String blogDetails = request.getParameter("selectedAnswers");
		
		//Splitting the string and obtaining respective values
		String detailsOfBlog[]=blogDetails.split(",");
	    String blogTitle = detailsOfBlog[0];
	    String blogDescription = detailsOfBlog[1];
	    LocalDate date = LocalDate.now();
		
	    //Creation of object blog and setting values
		Blog blog = new Blog(blogTitle, blogDescription, date);
		blog.setTitle(blogTitle);
		blog.setDescription(blogDescription);
		blog.setPostedOn(date);
		
		//Printing the data to console
		System.out.println("Blog Title: " + blogTitle);
		System.out.println("Blog Description: " + blogDescription);
		System.out.println("Posted on: " + date);

		
		if(blog!=null) {
			request.setAttribute("blog", blog);
			//request.setAttribute("user",user);
			RequestDispatcher rd=this.getServletContext().getRequestDispatcher("/WEB-INF/views/blogView.jsp");
			rd.forward(request, response);
		}
		
	}

}
