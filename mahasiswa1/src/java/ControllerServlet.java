/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author intel
 */
public class ControllerServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
    private siswaDAO siswaDAO;
 
    public void init() {
        String jdbcURL = getServletContext().getInitParameter("jdbcURL");
        String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
        String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
 
        siswaDAO = new siswaDAO(jdbcURL, jdbcUsername, jdbcPassword);
 
    }
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();
 
        try {
            switch (action) {
            case "/new":
                showNewForm(request, response);
                break;
            case "/insert":
                insertsiswa(request, response);
                break;
            case "/delete":
                deletesiswa(request, response);
                break;
            case "/edit":
                showEditForm(request, response);
                break;
            case "/update":
                updatesiswa(request, response);
                break;
            default:
                listsiswa(request, response);
                break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }
    
    
  private void listsiswa(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Siswa> listsiswa = siswaDAO.listAllsiswa();
        request.setAttribute("listsiswa", listsiswa);
        RequestDispatcher dispatcher = request.getRequestDispatcher("siswalist.jsp");
        dispatcher.forward(request, response);
    }
 
    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("siswaform.jsp");
        dispatcher.forward(request, response);
    }
 
    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        Double nim = Double.parseDouble(request.getParameter("nim"));
        Siswa existing= siswaDAO.getsiswa(nim);
        RequestDispatcher dispatcher = request.getRequestDispatcher("siswaform.jsp");
        request.setAttribute("nama", existing);
        dispatcher.forward(request, response);
 
    }
 
    private void insertsiswa(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
      
        String nama = request.getParameter("nama");
         Double  ipk = Double.parseDouble(request.getParameter("ipk"));
 
        Siswa newBook = new Siswa (nama,ipk);
        siswaDAO.insertsiswa(newBook);
        response.sendRedirect("list");
    }
 
    private void updatesiswa(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
       Double  nim = Double .parseDouble(request.getParameter("nim"));
        String nama = request.getParameter("nama");
       
        Double  ipk = Double.parseDouble(request.getParameter("ipk"));
 
        Siswa book = new Siswa(nim,nama,ipk);
        siswaDAO.updatesiswa(book);
        response.sendRedirect("list");
    }
 
    private void deletesiswa(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        double nim= Double.parseDouble(request.getParameter("nim"));
 
        Siswa book = new Siswa(nim);
        siswaDAO.deletesiswa(book);
        response.sendRedirect("list");
 
    }

}
