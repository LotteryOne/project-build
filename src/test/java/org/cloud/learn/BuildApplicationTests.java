package org.cloud.learn;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.*;

/*@RunWith(SpringRunner.class)
@SpringBootTest*/
public class BuildApplicationTests {

	@Test
	public void contextLoads() {
	}


	@Test
	public void testSql(){



		try{
			Class.forName("com.mysql.jdbc.Driver");

			String url="jdbc:mysql://23.106.148.167:3306/mysql";
			String name="root";
			String pwd="ysysljj";

			Connection conn = DriverManager.getConnection(url, name, pwd);


			System.out.println(conn);


			PreparedStatement ps = conn.prepareStatement("select * from person");

//			ps.execute();
			ResultSet rs = ps.executeQuery();

			rs.next();

			System.out.println(rs.getString(2));

			if(ps!=null)ps.close();















			if(conn!=null){
				conn.close();
			}

		}catch (Exception e){
			e.printStackTrace();
		}



	}




}
