package jdbcStudent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StuDaoImpl implements DAO {
	
	private Connection conn;
	
	private PreparedStatement pst;
	
	private String query = "";
	
	public StuDaoImpl() {
		
		DatabaseConnection dbc = DatabaseConnection.getInstance();
		
		conn = dbc.getConnection();
		
	}

	@Override
	public int insertStu(Student s) {
		
//		System.out.println(" 추가 dao 임플 성공");
		
		query = "insert into student(s_no,s_name,s_btday,s_tel,s_addr) values(?,?,?,?,?)"; 
		
		try {
			pst = conn.prepareStatement(query);
			
			pst.setString(1, s.getS_no());
			pst.setString(2, s.getS_name());
			pst.setString(3, s.getS_btday());
			pst.setString(4, s.getS_tel());
			pst.setString(5, s.getS_addr());
			
			
			return pst.executeUpdate();
			
			
		} catch (SQLException e) {
//			System.out.println("추가 다오임플 에러");
			e.printStackTrace();
		}

		return 0;
	}

	@Override
	public List<Student> getStuList() {
		
//		System.out.println("학생 목록 다오임플 성공");
		
		query = "select * from student";
		
		List<Student> list = new ArrayList<>();
		
		try {
			pst = conn.prepareStatement(query);
			
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				list.add(new Student(rs.getString("s_no"), rs.getString("s_name")));
			}
			
			return list;
			
			
		} catch (SQLException e) {
//			System.out.println(" 학생목록 다오임플 실패 ");
			e.printStackTrace();
		}
		
	
		
		return null;
	}

	@Override
	public Student getStuInfo(int no) {
		
//		System.out.println("학생 정보찾기 다오임플 성공");
		
		query = "select * from student where no = ? ";
		
		
		try {
			pst = conn.prepareStatement(query);
			
			pst.setInt(1, no);
			
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()) {
				Student s = new Student(rs.getInt("no"),
						rs.getString("s_no"),
						rs.getString("s_name"),
						rs.getString("s_btday"),
						rs.getString("s_tel"),
						rs.getString("s_addr"),
						rs.getString("regdate"));
				
				return s;
			}
			
			
		} catch (SQLException e) {
//			System.out.println("학생 정보찾기 다오임플 실패");
			e.printStackTrace();
		}
		

		return null;
		
		
	}

	@Override
	public int updateInfo(Student s) {
//		System.out.println("업데이트 다오 임플 성공");
		
		query = "update student set s_no=?, s_name=?, s_btday=?, s_tel=?, s_addr=? where no =?";
		
		try {
			pst = conn.prepareStatement(query);
			
			pst.setString(1, s.getS_no());
			pst.setString(2, s.getS_name());
			pst.setString(3, s.getS_btday());
			pst.setString(4, s.getS_tel());
			pst.setString(5, s.getS_addr());
			pst.setInt(6, s.getNo());
			
			return pst.executeUpdate();
			
		} catch (SQLException e) {
//			System.out.println("업데이트 다오 임플 실패");
			e.printStackTrace();
		}
			
		
		return 0;
	}

	@Override
	public int deleteStu(int no) {
//		System.out.println(" 학생 삭제 다오임플 성공");
		
		query = "delete from student where no = ?";
		
		try {
			pst = conn.prepareStatement(query);
			
			pst.setInt(1, no);
			
			return pst.executeUpdate();
			
		} catch (SQLException e) {
//			System.out.println(" 학생 삭제 다오임플 실패 ");
			e.printStackTrace();
		}
		
		
		
		
		return 0;
	}


	
	
	
	
	
}
