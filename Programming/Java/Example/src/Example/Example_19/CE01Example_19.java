package Example.Example_19;

/*
 * DB (Database) 란?
 * - 데이터를 체계화하여 통합하고 관리하는 데이터의 집합을 의미한다. (+ 즉, DB 를 활용하면 데이터를
 * 구조화 시켜서 관리하는 것이 가능하다.)
 *
 * SQLite 란?
 * - 
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Example 19 (DB)
 */
public class CE01Example_19 {
	/** 초기화 */
	public static void start(String[] args) {
		/*
		 * DriverManager 클래스란?
		 * - DB 드라이버를 관리하고 연결을 제어하는 역할을 수행하는 클래스를 의미한다. (+ 즉, 
		 * DriverManager 클래스를 활용하면 SQLite 와 같은 DB 를 손쉽게 제어하는 것이 가능하다.)
		 *
		 * Connection 클래스란?
		 * - DB 를 제어하는 역할을 수행하는 클래스를 의미한다. (+ 즉, Connection 클래스를 활용하면
		 * DB 에 SQL 구문을 실행하는 등의 작업을 처리하는 것이 가능하다.)
		 */
		try(Connection oSQLite = DriverManager.getConnection("jdbc:sqlite:P_E01Example_19_01.db")) {
			/*
			 * Statement 클래스란?
			 * - SQL 구문을 실행하고 실행에 대한 결과를 제어하는 역할을 수행하는 클래스를 의미한다. (+ 즉,
			 * Statement 클래스를 활용하면 DB 에 테이블을 생성하는 등의 명령을 실행하는 것이 가능하다.)
			 */
			try(Statement oStatement = oSQLite.createStatement()) {
				/*
				 * execute 메서드란?
				 * - SQL 구문을 실행하는 역할을 수행하는 메서드를 의미한다. (+ 즉, execute 메서드를 활용하면
				 * DB 에 SQL 구문을 전달해서 실행 시키는 것이 가능하다.)
				 */
				oStatement.execute("CREATE TABLE IF NOT EXISTS UserTable (ID TEXT PRIMARY KEY, Password TEXT)");
			}
			
			String oSQL_Insert = "INSERT OR IGNORE INTO UserTable(ID, Password) VALUES(?, ?)";
			
			/*
			 * PreparedStatement 클래스란?
			 * - 미리 컴파일 된 SQL 구문을 실행하고 실행에 대한 결과를 제어하는 역할을 수행하는 클래스를 의미한다.
			 * (+ 즉, PreparedStatement 클래스를 활용하면 Statement 클래스보다 좀 더 빠르게 SQL 구문을
			 * 처리하는 것이 가능하다.)
			 */
			try(PreparedStatement oStatement = oSQLite.prepareStatement(oSQL_Insert)) {
				oStatement.setString(1, "회원 A");
				oStatement.setString(2, "1234");
				
				/*
				 * executeUpdate 메서드란?
				 * - execute 메서드와 같이 SQL 구문을 실행하는 역할을 수행하는 메서드를 의미한다.
				 *
				 * 단, executeUpdate 메서드는 execute 메서드와 달리 ? 구문으로 데이터를 바인딩하는 SQL 구문을
				 * 처리하는 것이 가능하다. (+ 즉, executeUpdate 메서드는 데이터와 SQL 구문을
				 * 동적으로 바인딩하는 기능을 제공한다는 것을 알 수 있다.)
				 */
				oStatement.executeUpdate();
				
				oStatement.setString(1, "회원 B");
				oStatement.setString(2, "1234");
				
				oStatement.executeUpdate();
			}
			
			try(Statement oStatement = oSQLite.createStatement()) {
				String oSQL_Select = "SELECT * FROM MemberTable";
				
				/*
				 * ResultSet 클래스란?
				 * - SQL 구문 중 SELECT 명령문을 실행 한 결과를 제어하는 역할을 수행하는 클래스를 의미한다. (+ 즉,
				 * ResultSet 클래스를 활용하면 DB 로부터 가져온 데이터의 필드를 가져오는 것이 가능하다.)
				 *
				 * executeQuery 메서드란?
				 * - SQL 구문 중 SELECT 명령문을 실행하고 실행에 대한 결과를 반환하는 메서드를 의미한다. (+ 즉,
				 * executeQuery 메서드를 활용하면 DB 로부터 데이터를 가져오는 것이 가능하다.)
				 */
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
