package org.cloud.learn;


import java.sql.*;

/**
 * Created by tappe on 6/11/2017.
 */
public class PersonService    {

    //test
    public static void main(String[] args) throws SQLException {

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        String url="jdbc:mysql://23.106.148.167:3306/mysql?useUnicode=true&characterEncoding=utf8&allowMultiQueries=true";
        String name="root";

        String pwd="ysysljj";
        Connection dri=null;
        try {
             dri = DriverManager.getConnection(url, name, pwd);
            System.out.println(dri);
//            dri.prepareStatement("insert into test_table values (12,'Tom') ").execute();

            PreparedStatement ps = dri.prepareStatement("select count(*) aa from test_table ");

            ResultSet rs = ps.executeQuery();

            rs.next();

            System.out.println(rs.getString("aa"));




        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(dri!=null){
                dri.close();
            }
        }


    }
}
