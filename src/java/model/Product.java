/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Djole
 */
public class Product {

    private String id;
    private String name;
    private String brand;
    private String model;
    private String price;
    private String quantity;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    // Metod za prikaz svih prozivoda
    public static String allProducts() throws ClassNotFoundException {
        // StringBuilder za kreiranje odgovora
        StringBuilder all_products = new StringBuilder();
        Class.forName("com.mysql.jdbc.Driver");

        try (java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/webshop", "root", "mysqluservezbanje");) {
            Statement st = conn.createStatement();
            // sql upit
            st.executeQuery("select product_id,product_name, product_brand, product_model, product_price, quantity from products");
            // preuzimanje rezultata u rs
            ResultSet rs = st.getResultSet();

            //kroz prolazak petlje upisuju se svi proizvodi u all_proizvode string
            while (rs.next()) {
                all_products.append("Id: ");
                all_products.append(rs.getString("product_id"));
                all_products.append("\t ");
                all_products.append("Name: ");
                all_products.append(rs.getString("product_name"));
                all_products.append("\t ");
                all_products.append("Brand: ");
                all_products.append(rs.getString("product_brand"));
                all_products.append("\t ");
                all_products.append("Model: ");
                all_products.append(rs.getString("product_model"));
                all_products.append("\t  ");
                all_products.append("Price: ");
                all_products.append(rs.getString("product_price"));
                all_products.append("\t ");
                all_products.append("Quantity: ");
                all_products.append(rs.getString("quantity"));
                all_products.append("\n");
                all_products.append("----------------------------------------------------------------------------------------------------");
                all_products.append("\n");
            }
        } catch (SQLException ex) {
            all_products.append(ex.getMessage());
        }
        return all_products.toString();
    }

    // Metod za unos proizvoda u bazu
    public void addProduct() throws ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");

        try (java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/webshop", "root", "mysqluservezbanje");) {
            //provera da li su uneti podaci
            if ((name != null && !(name.isEmpty())) && (brand != null && !(brand.isEmpty())) && (model != null && !(model.isEmpty())) && (price != null && !(price.isEmpty())) && (quantity != null && !(quantity.isEmpty()))) {

                Statement st = conn.createStatement();
                // Unos podataka u bazu
                st.execute("insert into products(product_name,product_brand,product_model,product_price,quantity) values('" + name + "','" + brand + "','" + model + "'," + price + "," + quantity + ");");
            }
        } catch (SQLException ex) {
            System.out.println("Error in database connection: \n" + ex.getMessage());
        }
    }

    public void deleteProduct() throws ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");

        try (java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/webshop", "root", "mysqluservezbanje");) {
            //provera da li su uneti podaci
            if (id != null && !(id.isEmpty())) {

                Statement st = conn.createStatement();
                // Unos podataka u bazu
                st.execute("delete from products where product_id=" + id + ";");
            }
        } catch (SQLException ex) {
            System.out.println("Error in database connection: \n" + ex.getMessage());
        }
    }

    public void editProduct() throws ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");

        try (java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/webshop", "root", "mysqluservezbanje");) {
            //provera da li su uneti podaci
            if (id != null && !(id.isEmpty())) {

                if ((name != null && !(name.isEmpty())) && (brand != null && !(brand.isEmpty())) && (model != null && !(model.isEmpty())) && (price != null && !(price.isEmpty())) && (quantity != null && !(quantity.isEmpty()))) {
                    Statement st = conn.createStatement();
                    st.execute("update products set product_name='" + name + "', product_brand='" + brand + "', product_model='" + model + "', product_price='" + price + "', quantity='" + quantity + "' where product_id=" + id + ";");
                } else if (name != null && !(name.isEmpty())) {
                    Statement st = conn.createStatement();
                    st.execute("update products set product_name='" + name + "' where product_id=" + id + ";");
                } else if (brand != null && !(brand.isEmpty())) {
                    Statement st = conn.createStatement();
                    st.execute("update products set product_brand='" + brand + "' where product_id=" + id + ";");
                } else if (model != null && !(model.isEmpty())) {
                    Statement st = conn.createStatement();
                    st.execute("update products set product_model='" + model + "' where product_id=" + id + ";");
                } else if (price != null && !(price.isEmpty())) {
                    Statement st = conn.createStatement();
                    st.execute("update products set product_price='" + price + "' where product_id=" + id + ";");
                } else if (quantity != null && !(quantity.isEmpty())) {
                    Statement st = conn.createStatement();
                    st.execute("update products set quantity='" + quantity + "' where product_id=" + id + ";");
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error in database connection: \n" + ex.getMessage());
        }
    }

    public boolean buyProduct() throws ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");

        try (java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/webshop", "root", "mysqluservezbanje");) {
            //provera da li su uneti podaci
            if ((id != null && !(id.isEmpty())) && ((quantity != null && !(quantity.isEmpty())))) {

                Statement st = conn.createStatement();
                // Unos podataka u bazu
//                st.execute("select quanatity from products where product_id=" + id + ";");
//                ResultSet rs = st.getResultSet();
                System.out.println("metoda buyProduct() je primila zahtev za id: " + id + " i kolicinu: " + quantity + ".");

                st.execute("select quantity from products where product_id='" + id + "';");

                ResultSet rs = st.getResultSet();
                rs.next();
                int stock = rs.getInt("quantity");
                int sub = stock - Integer.parseInt(quantity);

                if (sub >= 0) {

                    st.execute("update products set quantity=" + sub + " where product_id=" + id + ";");Statement st1 = conn.createStatement();
                    st1.execute("SELECT loginId FROM logger ORDER BY i DESC LIMIT 1;");
ResultSet rs1 = st1.getResultSet();
                    rs1.next();
                    int current_user_id = rs1.getInt("loginId");
                    Statement st2 = conn.createStatement();
                    st2.execute("select items_bought from users where user_id=" + current_user_id + ";");ResultSet rs2 = st2.getResultSet();
                    rs2.next();
                    int old_itmes_bought = rs2.getInt("items_bought");
                    int new_items_bought = old_itmes_bought + Integer.parseInt(quantity);
                    Statement st3 = conn.createStatement();
                    st3.execute("update users set items_bought=" + new_items_bought + " where user_id=" + current_user_id + ";");
                    return true;

                } else {
                    return false;
                }

            } else {
                return false;
            }
        } catch (SQLException ex) {
            System.out.println("Error in database connection: \n" + ex.getMessage());
            return false;
        }
    }

}
