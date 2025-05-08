package Example.Example_19;

/*
 * 데이터 베이스 (Database) 란?
 * -
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Example 19 (데이터 베이스)
 */
public class CE01Example_19 {
	/** 초기화 */
	public static void start(String[] args) {
		/*
		 * DriverManager 클래스란?
		 * -
		 */
		try(Connection oSQLite = DriverManager.getConnection("jdbc:sqlite:P_E01Example_19_01.db")) {
			/*
			 * Statement 클래스란?
			 * -
			 */
			try(Statement oStatement = oSQLite.createStatement()) {
				oStatement.execute("CREATE TABLE IF NOT EXISTS MemberTable (Name TEXT PRIMARY KEY, PNumber TEXT)");
			}
			
			String oSQL_Insert = "INSERT OR IGNORE INTO MemberTable(Name, PNumber) VALUES(?, ?)";
			
			try(PreparedStatement oStatement = oSQLite.prepareStatement(oSQL_Insert)) {
				oStatement.setString(1, "회원 C");
				oStatement.setString(2, "1234");
				
				oStatement.executeUpdate();
				
				oStatement.setString(1, "회원 D");
				oStatement.setString(2, "1234");
				
				oStatement.executeUpdate();
			}
			
			try(Statement oStatement = oSQLite.createStatement()) {
				String oSQL_Select = "SELECT * FROM MemberTable";
				
				try(ResultSet oResult = oStatement.executeQuery(oSQL_Select)) {
					System.out.println("=====> 모든 회원 정보 <=====");
					
					while(oResult.next()) {
						System.out.printf("이름 : %s\n", oResult.getString(1));
						System.out.printf("전화번호 : %s\n\n", oResult.getString(2));
					}
				}
			}
		} catch(Exception oException) {
			oException.printStackTrace();
		}
	}
}
