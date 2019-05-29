package testcases;


import java.sql.SQLException;
import java.util.List;

public class TestDbConn {

	public static void main(String[] args) throws SQLException {
		DbManager.setMysqlDbConnection();
		String stm = "select Tutorial_author from Selenium;";
		List<String> result = DbManager.getMysqlQuery(stm);
		System.out.println(result.get(0));
		System.out.println(result.get(1));
		DbManager.closeConnection();
	}
}
