package model;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class User {

    private String id;
    private String username;
    private String password;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Metod za prikaz svih utisaka
    public static String allUsers() throws ClassNotFoundException {
        // StringBuilder za kreiranje odgovora
        StringBuilder all_users = new StringBuilder();
        Class.forName("com.mysql.jdbc.Driver");

        try (java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/webshop", "root", "mysqluservezbanje");) {
            Statement st = conn.createStatement();
            // sql upit
            st.executeQuery("select user_id,username, password, items_bought from users");
            // preuzimanje rezultata u rs
            ResultSet rs = st.getResultSet();

            //kroz prolazak petlje upisuju se svi utisci u all_users string
            while (rs.next()) {
                all_users.append("Id: ");
                all_users.append(rs.getString("user_id"));
                all_users.append("\t ");
                all_users.append("Username: ");
                all_users.append(rs.getString("username"));
                all_users.append("\t\t ");
                all_users.append("Password: ");
                all_users.append(rs.getString("password"));
                all_users.append("\t\t ");
                all_users.append("Items bought: ");
                all_users.append(rs.getString("items_bought"));
                all_users.append("\n");
            }
        } catch (SQLException ex) {
            all_users.append(ex.getMessage());
        }
        return all_users.toString();
    }

    // Metod za unos utisaka u bazu
    public void addUser() throws ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");

        try (java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/webshop", "root", "mysqluservezbanje");) {
            //provera da li su uneti podaci
            if (username != null && !(username.isEmpty()) && password != null && !(password.isEmpty())) {

                Statement st = conn.createStatement();
                // Unos podataka u bazu
                st.execute("insert into users (username,password,items_bought) values ('" + username + "','" + password + "'," + 0 + ");");
            }
        } catch (SQLException ex) {
            System.out.println("Error in database connection: \n" + ex.getMessage());
        }
    }

    public void deleteUser() throws ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");

        try (java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/webshop", "root", "mysqluservezbanje");) {
            //provera da li su uneti podaci
            if (id != null && !(id.isEmpty())) {

                Statement st = conn.createStatement();
                // Unos podataka u bazu
                st.execute("delete from users where user_id=" + id + ";");
            }
        } catch (SQLException ex) {
            System.out.println("Error in database connection: \n" + ex.getMessage());
        }
    }

    public void editUser() throws ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");

        try (java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/webshop", "root", "mysqluservezbanje");) {
            //provera da li su uneti podaci
            if (id != null && !(id.isEmpty())) {

                if ((username != null && !(username.isEmpty())) && (password != null && !(password.isEmpty()))) {
                    Statement st = conn.createStatement();
                    st.execute("update users set username='" + username + "', password='" + password + "' where user_id=" + id + ";");
                } else if (password != null && !(password.isEmpty())) {
                    Statement st = conn.createStatement();
                    st.execute("update users set password='" + password + "' where user_id=" + id + ";");
                } else {
                    if (username != null && !(username.isEmpty())) {
                        Statement st = conn.createStatement();
                        st.execute("update users set username='" + username + "' where user_id=" + id + ";");
                    }
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error in database connection: \n" + ex.getMessage());
        }
    }

}
