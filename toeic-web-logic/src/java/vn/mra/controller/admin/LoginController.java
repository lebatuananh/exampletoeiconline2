package vn.mra.controller.admin;

import org.apache.log4j.Logger;
import vn.mra.command.UserCommand;
import vn.mra.core.dto.UserDTO;
import vn.mra.core.web.utils.FormUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/login.html")
public class LoginController extends HttpServlet {
    private final Logger log = Logger.getLogger(this.getClass());
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rd=request.getRequestDispatcher("/views/web/login.jsp");
        rd.forward(request,response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        UserCommand userCommand= FormUtils.populate(UserCommand.class,request);
        UserDTO pojo=userCommand.getPojo();
        RequestDispatcher rd=request.getRequestDispatcher("/views/web/login.jsp");
        rd.forward(request,response);
    }
}