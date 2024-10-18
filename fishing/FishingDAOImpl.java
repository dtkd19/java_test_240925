package fishing;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

//import fishing.DatabaseConnection;

public class FishingDAOImpl implements FishingDAO {
	
	private Connection conn;
	private PreparedStatement pst;
	private String query="";
	
	public FishingDAOImpl() {
		DatabaseConnection dbc = DatabaseConnection.getInstance();
		conn = dbc.getConnection();
	}

	@Override
	public int addFish(int num, String fish_name, int fish_size) {
//		System.out.println("FishingDAOImple의 addFish 접근 성공.");
		int fish_no = 0;
		// fish_no 구하는 쿼리
		query = "SELECT fish_no FROM fish WHERE fish_name = ?";
		
		try {
			pst = conn.prepareStatement(query);
			pst.setString(1, fish_name);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				fish_no = rs.getInt("fish_no");
				
				query = "INSERT INTO inventory (num, fish_no, fish_size) VALUES (?, ?, ?)";
				
				try {
					pst = conn.prepareStatement(query);
					pst.setInt(1, num);
					pst.setInt(2, fish_no);
					pst.setInt(3, fish_size);
					return pst.executeUpdate();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Error in FishingDAO addFish()");
		return 0;
	}

	@Override
	public Map<String, Integer> getResult(int num) {
//		System.out.println("FishingDAOImple의 add 접근 성공.");
		query = "select f.fish_name as 'fish_name', count(i.fish_no) as 'count' from inventory i " +
				"inner join fish f on i.fish_no = f.fish_no " +
				"where num = ? " +
				"group by i.fish_no " +
				"order by i.fish_no ";
		
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1, num);
			ResultSet rs = pst.executeQuery();
			Map<String, Integer> fishMap = new HashMap<>();
			while (rs.next()) {
				fishMap.put(rs.getString("fish_name"), rs.getInt("count"));
			}
			return fishMap;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Error in FishingDAO getResult()");
		return null;
	}
	
	@Override
	public boolean isBaitReady(int num) {
		int baitNum = 0;
		query = "SELECT bait FROM userlist WHERE num = ?";
		
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1, num);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				baitNum = rs.getInt("bait");
				if(0 < baitNum) {
					return true;
				} else {
					return false;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}
	
	@Override
	public int consumeBait(int num) {
//		System.out.println("FishingDAOImple의 add 접근 성공.");
		
		query = "UPDATE userlist SET bait = bait - 1 WHERE num = ?";
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1, num);
			return pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
		
	}
	
	@Override
	public User displayNicknameBait(int num) {
		query = "SELECT nickname, bait FROM userlist WHERE num = ?";
		
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1, num);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				User u = new User(rs.getString("nickname"), rs.getInt("bait"));
				return u;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public User getUser(int num) {
		query = "SELECT * FROM userlist WHERE num = ?";
		
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1, num);
			
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
			System.out.println("유저 정보 가져오기 실패");
			e.printStackTrace();
		}
		return null;
	}
	
}
