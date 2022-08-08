import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class DAOClass {
	/*
+---------------+-------------+------+-----+---------+-------+
| Field         | Type        | Null | Key | Default | Extra |
+---------------+-------------+------+-----+---------+-------+
| Rollno        | int         | NO   | PRI | NULL    |       |
| StudentName   | varchar(10) | NO   |     | NULL    |       |
| Standard      | varchar(2)  | NO   |     | NULL    |       |
| Date_Of_Birth | date        | YES  |     | NULL    |       |
| Fees          | double(9,2) | YES  |     | NULL    |       |
+---------------+-------------+------+-----+---------+-------+


| Rollno | StudentName | Standard | Date_Of_Birth | Fees     |
+--------+-------------+----------+---------------+----------+
|   4756 | RAMESH      | X        | 1995-04-21    | 57483.00 |
|   5634 | SUDHA       | V        | 2000-10-10    |  5647.00 |
|   5675 | RITU        | V        | 2000-07-05    |  6788.00 |
	 
	 
	 */
	private Connection conn = null;
	PreparedStatement pstmt = null;
	
	public DAOClass() {
		conn = DBUtil.getConnection();
	}
	
	public boolean insert(int rollno, String name, String sta, String dob, int fee) {		
		String sql = "INSERT INTO Student VALUES(?, ?, ?, ?, ?)"; //Inserting data in Student table
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, rollno);
			pstmt.setString(2, name);
			pstmt.setString(3, sta);
			pstmt.setString(4, dob);
			pstmt.setInt(5, fee);
			pstmt.executeUpdate();
			
			return true;
		} catch (SQLException e) {
			return false;
		}
	}

	
	public boolean display(int rollno) {
		String sql = "SELECT * FROM Student WHERE rollno = ?";//Fetching Data from table where roll no = ?;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, rollno);
			ResultSet rs = pstmt.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			
			while (rs.next()) {
				StringBuilder sb = new StringBuilder();
				
				for (int i = 1; i <= rsmd.getColumnCount(); i++) {
					String colName = rsmd.getColumnName(i);
					
					sb.append(rs.getObject(colName));
					if (i != rsmd.getColumnCount()) sb.append(", ");
				}
				System.out.println(sb);
			}
			
			return true;
		} catch (SQLException e) {
			return false;
		}
	}

	public boolean display() {
		String sql = "SELECT * FROM Student";//Fetch whole table if Roll no. is not given
		
		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			
			while (rs.next()) {
				StringBuilder sb = new StringBuilder();
				
				for (int i = 1; i <= rsmd.getColumnCount(); i++) {
					String colName = rsmd.getColumnName(i);
					
					sb.append(rs.getObject(colName));
					if (i != rsmd.getColumnCount()) sb.append(", ");
				}
				
				System.out.println(sb);
			}
			
			return true;
		} catch (SQLException e) {
			return false;
		}
	}
}