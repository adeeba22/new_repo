import java.sql.*;

public class Ecommerce {
    private static Connection con;

    /*
     * TODO 1: Provide username and password for your Oracle database
     * */
    private void setupDB() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String url = "jdbc:oracle:thin:@localhost:1521:orcl";
            String username = "sys as sysdba"; //Provide username for your database
            String password = "oracle"; //provide password for your database

            con = DriverManager.getConnection(url, username, password);

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void printOrderDetails(String customerName) throws Exception {
        /*
         * TODO 2: Print space-separated OrderId, ProductName, Price, Quantity for the given customer.
         *  Each order details row from the table should be printed on the new line.
         *  SELECT query format is shown below for the exercise:
         *  SELECT * FROM table_name WHERE column_name = customer_value
         */
        String p = "SELECT * FROM ORDERDETAILS WHERE CUSTOMERNAME=?";
        ResultSet result = null;
        try {
            PreparedStatement ps = con.prepareStatement(p);
            ps.setString(1,customerName);
            result = ps.executeQuery();
            while (result.next()) {
                int orderId = result.getInt(1);
                String prodName = result.getString(2);
                int price = result.getInt(3);
                int quantity = result.getInt(4);
                System.out.println(orderId + " " + prodName + " " + price + " " + quantity);
            }


        } catch (Exception e) {
            System.out.println("Query not executed");
            e.printStackTrace();
        }

    }

    public static void main(String args[]) {
        Ecommerce ecommerce = new Ecommerce();
        try {
            ecommerce.setupDB();
            //String customerName = "Bob";
            // uncomment below line and comment above line to test sample test case 2
          String customerName = "Katie";

            ecommerce.printOrderDetails(customerName);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }

    }
}  