import java.sql.*;

class UpdateUser {
    private static Connection con;

    /*
     * TODO 1: Provide username and password for your Oracle database
     * */
    private void setupDB(){
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String url = "jdbc:oracle:thin:@localhost:1521:orcl";
            String username = "sys as sysdba"; //Provide username for your database
            String password = "oracle"; //provide password for your database

            con = DriverManager.getConnection(url, username, password);
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    public void updatePhoneNumber(String userName, String phoneNumber) throws Exception {
        /*
         * TODO 2: Update the phoneNumber of the specified user.
         *  Update query format is shown below:
         *  UPDATE table_name SET column_name = column_value WHERE filter_column_name = filter_column_value
         */
        String p = "UPDATE Users SET PhoneNumber='"+phoneNumber+"' WHERE UserName ='"+userName+"'";
        int result = 0;
        try {
            PreparedStatement ps = con.prepareStatement(p);
            //ps.setString(1,phoneNumber);
            result = ps.executeUpdate();

            }
         catch (Exception e) {
            System.out.println("Query not executed");
            e.printStackTrace();
        }

    }

    public void printUsers() throws Exception {
        Statement stmt = con.createStatement();
        String query = "SELECT * FROM Users";
        ResultSet resultSet = stmt.executeQuery(query);
        while (resultSet.next()){
            System.out.println(resultSet.getInt(1) + " "
                    + resultSet.getString(2)
                    + " " + resultSet.getString(3));
        }
    }

    public static void main(String args[]){
        UpdateUser testUser = new UpdateUser();
        try{
            testUser.setupDB();

            //String customerToUpdate = "Nikita"; String updateNumberTo = "9865321470";
            // uncomment below line and comment above line to test sample test case 2
           String customerToUpdate = "Rahul"; String updateNumberTo = "8965321407";

            testUser.updatePhoneNumber(customerToUpdate, updateNumberTo);
            testUser.printUsers();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            if(con != null){
                try {
                    con.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }

    }
}  