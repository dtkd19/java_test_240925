package fishing;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAOImpl implements UserDAO {

	
	private Connection conn;
	
	private PreparedStatement pst;
	
	private String query="";
	
	
	public UserDAOImpl() {
		DatabaseConnection dbc = DatabaseConnection.getInstance();
		conn = dbc.getConnection();
	}
	
	
	@Override
	public int signUpUser(User u) {
		System.out.println(" 회원가입 DAOImpl 확인 성공!!");
		
		query = "insert into userlist (user_id, passwd, nickname) values (?, ?, ?)";
		
		try {
			pst = conn.prepareStatement(query);
			
			pst.setString(1, u.getUser_id());
			pst.setString(2, u.getPasswd());
			pst.setString(3, u.getNickname());
			
			return pst.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println(" 회원가입 DAOImpl 확인 실패... ");
			e.printStackTrace();
		}
	
		return 0;
	}


	@Override
	public User loginUser(String id, String pw) {
		System.out.println(" 로그인 DAOImpl 확인 성공 ");
		
		query = "select * from userlist where user_id = ? AND passwd = ?";
		
		try {
			pst = conn.prepareStatement(query);
			pst.setString(1, id);
			pst.setString(2, pw);
			
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()) {
				User u = new User();
				u.setNum(rs.getInt("num"));
                u.setUser_id(rs.getString("user_id"));
                u.setPasswd(rs.getString("passwd"));
                u.setNickname(rs.getString("nickname"));
                u.setFishrod(rs.getString("fishrod"));
                u.setMoney(rs.getInt("money"));
                u.setBait(rs.getInt("bait"));              
                return u;
			}
			
			
		} catch (SQLException e) {
			System.out.println("로그인 다오임플 실패");
			e.printStackTrace();
		}
		
			
		return null;
	}


	@Override
	public boolean userIdExists(String id) {
		  String query = "SELECT COUNT(*) FROM userlist WHERE user_id = ?";
		    try {
		        pst = conn.prepareStatement(query);
		        pst.setString(1, id);
		        ResultSet rs = pst.executeQuery();
		        
		        if (rs.next()) {
		        	return rs.getInt(1) > 0;
		        }
		        
		    } catch (SQLException e) {
		        System.out.println("아이디 중복 체크 실패...");
		        e.printStackTrace();
		    }
		    return false;
	}

}
