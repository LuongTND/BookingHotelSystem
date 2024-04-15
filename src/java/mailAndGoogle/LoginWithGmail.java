/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package mailAndGoogle;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import dao.UserDao;
import dbcontext.DBContext;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.User;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Form;
import org.apache.http.client.fluent.Request;

/**
 *
 * @author admin
 */
@WebServlet(name = "LoginWithGmail", urlPatterns = {"/LoginWithGmail"})
public class LoginWithGmail extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        UserDao dao = new UserDao();
        String authCode = request.getParameter("code");
        String accessToken = getToken(authCode);
        GoogleUserDto googleUser = getUserInfo(accessToken);
        HttpSession session = request.getSession();
        String userEmail = googleUser.getEmail();
        String email = googleUser.getEmail();
        String takeUseNameFromEmail = googleUser.getEmail();
        String[] words = takeUseNameFromEmail.split("@");
        String userName = words[0];
        
        
        User existingUser = dao.checkEmailExist(userEmail);

    if (existingUser == null) {
        // Email does not exist, add a new account and login
        User acc = new User(1, null, null, null, email, null, userName, null, 1);
        dao.addAccountLoginWithGoogle(acc);
        session.setAttribute("userA", acc);
        response.sendRedirect("addAccountEmail.jsp");
    } else {
        // Email already exists, display a message
        String fullName = existingUser.getFullName();
        String username= existingUser.getUserName();
        String password = existingUser.getPass();
//        String message = "This email is already in use. Are you "+username+"(" + fullName +")"+ "?";
  //      session.setAttribute("message", message);
          session.setAttribute("fullname", fullName);
            session.setAttribute("username", username);
            if (password != null)
            {
        response.sendRedirect("loginGGExist.jsp");
            } else {
                session.setAttribute("userA", existingUser);
                response.sendRedirect("customer_home.jsp");
            }
    }
        
        
//        User acctakeEmail = dao.getAccountByEmail(email);
//        // SendEmail sm = new SendEmail();
//       
//               session.setAttribute("fullname",  acctakeEmail.getFullName());
//               
//               session.setAttribute("usernamegge",  acctakeEmail.getUserName());
           

    }

    public static String getToken(String code) throws ClientProtocolException, IOException {
        // call api to get token
        String response = Request.Post(Constants.GOOGLE_LINK_GET_TOKEN)
                .bodyForm(Form.form().add("client_id", Constants.GOOGLE_CLIENT_ID)
                        .add("client_secret", Constants.GOOGLE_CLIENT_SECRET)
                        .add("redirect_uri", Constants.GOOGLE_REDIRECT_URI).add("code", code)
                        .add("grant_type", Constants.GOOGLE_GRANT_TYPE).build())
                .execute().returnContent().asString();

        JsonObject jobj = new Gson().fromJson(response, JsonObject.class);
        String accessToken = jobj.get("access_token").toString().replaceAll("\"", "");
        return accessToken;
    }

    public static GoogleUserDto getUserInfo(final String accessToken) throws ClientProtocolException, IOException {
        String link = Constants.GOOGLE_LINK_GET_USER_INFO + accessToken;
        String response = Request.Get(link).execute().returnContent().asString();

        GoogleUserDto googlePojo = new Gson().fromJson(response, GoogleUserDto.class);

        return googlePojo;
    }

    private void saveUserToDatabase(String email) {
        Connection conn = DBContext.getConnection();
        try {
            String query = "INSERT INTO Account (UserName,Pass,FullName,Gender,City,Email,Phone,IDRole) VALUES (null,null,null,null,null,?,null,1)"; //insert into Account(UserName,Pass,FullName,Gender,City,Email,Phone,IDRole) values(?,?,?,?,?,?,?,?)";

            try ( PreparedStatement statement = conn.prepareStatement(query)) {

                statement.setString(1, email);

                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
////        String authUrl = "https://accounts.google.com/o/oauth2/auth" + "?client_id=" +Constants.GOOGLE_CLIENT_ID + "&redirect_uri=" + Constants.GOOGLE_REDIRECT_URI
////                + "&scope=https://www.googleapis.com/auth/userinfo.email&response_type=code";
        // String authUrl = "https://accounts.google.com/o/oauth2/auth" +"?scope=email" + "&redirect_uri=" + Constants.GOOGLE_REDIRECT_URI +"&response_type=code"+ "&client_id=" +Constants.GOOGLE_CLIENT_ID+"&approval_prompt=force";
//String authUrl ="https://accounts.google.com/o/oauth2/auth?scope=email&redirect_uri=http://localhost:8080/G2HotelV1/LoginWithGmail&response_type=code&client_id=111005015612-bqerf1kq54orha4bq60mdv1cl4js24v0.apps.googleusercontent.com&approval_prompt=force";     
        // response.sendRedirect(authUrl);
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
