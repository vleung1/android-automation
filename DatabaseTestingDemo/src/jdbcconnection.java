import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbcconnection {

	public static void main(String[] args) throws SQLException {

		String host = "localhost";
		String port = "3306";

		Connection con = DriverManager.getConnection(
				"jdbc:mysql://" + host + ":" + port + "/qadbdemo2" + "?useSSL=false", "root", "password");
		Statement s = con.createStatement();
		ResultSet rs = s.executeQuery("select * from credentials where scenario='chrome';");

		while (rs.next()) {

			System.out.println(rs.getString("username"));
			System.out.println(rs.getString("password"));

		}

	}

}
