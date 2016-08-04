package controller;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.validation.Valid;
import model.UserLoginModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/user_login")
public class UserLoginController {

    @RequestMapping(method = RequestMethod.GET)
    public String initUser(ModelMap usermodelMap) {
        usermodelMap.put("info", "Hello User");
        return "user_login";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String submitUser(ModelMap usermodelMap, @ModelAttribute("userloginModel") @Valid UserLoginModel userloginModel) {
        System.out.println("in submit" + userloginModel);
        String username = userloginModel.getUserName();
        String password = userloginModel.getPassword();
        System.out.println("uneo si username:" + username);
        System.out.println("uneo si password:" + password);
        if (username != null && !username.isEmpty() && password != null && !password.isEmpty()) {
            try (java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/webshop", "root", "mysqluservezbanje");) {

                Statement st = conn.createStatement();
                st.execute("select user_id from users where username='" + username + "' and password='" + password + "';");
                ResultSet rs = st.getResultSet();
                if (rs.next()) {
                    usermodelMap.put("userInfo", userloginModel.getUserName());
                    System.out.println(usermodelMap);
                    int id_logger = rs.getInt("user_id");
                    st.execute("insert into logger (loginId) values(" + id_logger + ");");
                    return "shopping";
                } else {
                    usermodelMap.put("error", "Invalid UserName / Password");
                    return "user_login";
                }
            } catch (SQLException ex) {
                System.out.println("Error in database connection: \n" + ex.getMessage());
                return "user_login";
            }
        } else {
            usermodelMap.put("error", "Invalid UserName / Password");
            return "user_login";
        }
    }
}
