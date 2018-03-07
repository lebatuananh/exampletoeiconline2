package vn.mra.controller.admin;

import org.apache.log4j.Logger;
import vn.mra.command.UserCommand;
import vn.mra.core.dto.UserDTO;
import vn.mra.core.service.UserService;
import vn.mra.core.service.impl.UserServiceImpl;
import vn.mra.core.web.common.WebConstant;
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
        UserService userService=new UserServiceImpl();
        try {
            if (userService.isUserExist(pojo) != null) {
                if (userService.findRoleByUser(pojo) != null && userService.findRoleByUser(pojo).getRoleDTO() != null) {
                    if (userService.findRoleByUser(pojo).getRoleDTO().getName().equals(WebConstant.ROLE_ADMIN)) {
                        response.sendRedirect("/admin-home.html");
                    } else if (userService.findRoleByUser(pojo).getRoleDTO().getName().equals(WebConstant.ROLE_USER)) {
                        response.sendRedirect("/home.html");
                    }
                }
            }
        } catch (NullPointerException e){
            log.error(e.getMessage(),e);
            request.setAttribute(WebConstant.ALERT,WebConstant.TYPE_ERROR);
            request.setAttribute(WebConstant.MESSAGE_RESPONE,"Tên hoặc mật khẩu đăng nhập không đúng");
            RequestDispatcher rd=request.getRequestDispatcher("/views/web/login.jsp");
            rd.forward(request,response);
        }
    }
}