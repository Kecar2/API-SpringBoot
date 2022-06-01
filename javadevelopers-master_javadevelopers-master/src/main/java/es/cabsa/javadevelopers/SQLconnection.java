package es.cabsa.javadevelopers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLconnection {

	Connection cn;
	Statement st;
	ResultSet rs;

	public SQLconnection() throws SQLException {
		try {
			Class.forName("org.h2.Driver");
			cn = DriverManager.getConnection("jdbc:h2:~/test", "sa", "password");
			st = cn.createStatement();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void prueba() {
		try {
			rs = st.executeQuery("SELECT * FROM ANIMALS");
			while (rs.next()) {

				System.out.println("ID: " + rs.getInt("id") + "\t" + "name: " + rs.getString("name") + "\t" + "legs: "
						+ rs.getInt("legs"));
				// System.out.println("idAnimalExcluded: " + rs.getInt("idAnimalExcluded"));
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

}
