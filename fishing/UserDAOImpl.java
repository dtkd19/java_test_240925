package fishing;

import java.sql.Connection;
import java.sql.PreparedStatement; // 기빈 추가
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List; // 기빈 끝

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
//		System.out.println(" 회원가입 DAOImpl 확인 성공!!");
		
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
//		System.out.println(" 로그인 DAOImpl 확인 성공 ");
		
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
	
	// 기빈 시작
	@Override
	public User userInfo(int num) {
		query = "select * from userlist where num = ?";
		
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1, num);
			// 아이디 닉네임 낚시대 돈 떡밥
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				User u = new User(rs.getString("user_id"),
								  rs.getString("nickname"),
								  rs.getString("fishrod"),
								  rs.getInt("money"),
								  rs.getInt("bait"));
				return u;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
	}

	@Override
	public int userBait(User u) {
		System.out.println(" 떡밥개수 "+u.getBaitCnt()+" 떡밥값 "+u.getBaitPrice()+" 누구? "+ u.getNum());
		query =   "update userlist set bait = bait + ?, money = money - ? "
				+ "where num = ?";
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1, u.getBaitCnt());
			pst.setInt(2, u.getBaitPrice());
			pst.setInt(3, u.getNum());
			return pst.executeUpdate();
		} catch (SQLException e) {
			System.out.println("bait update error");
			e.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public int userRod(User u) {
		System.out.println(u.getNum() +" "+u.getFishrod()+""+ u.getCost());
		
		query =   "update userlist set fishrod = ?, money = money - ? "
				+ "where num = ?";
		try {
			pst = conn.prepareStatement(query);
			pst.setString(1, u.getFishrod());
			pst.setInt(2, u.getCost());
			pst.setInt(3, u.getNum());
			return pst.executeUpdate();
		} catch (SQLException e) {
			System.out.println("fishrod update error");
			e.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public int userOneMoney(User u) {
		System.out.println(u.getNum() + " " + u.getSellNum());
		
		query =   "update userlist "
				+ "set money = money + ("
				+ "select if(i.fish_size > f.default_size,"
				+ 			"(i.fish_size-f.default_size)*1000 + price, price) as finalprice "
				+ 			"from inventory as i "
				+ 			"inner join fish as f "
				+ 			"on i.fish_no = f.fish_no "
				+ 			"where i.inven_id = ? ) "
				+ "where num = ? ";
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1, u.getSellNum());
			pst.setInt(2, u.getNum());
			return pst.executeUpdate();
		} catch (SQLException e) {
			System.out.println("money plus error");
			e.printStackTrace();
		}
		
		return 0;
	}


	@Override
	public int userAllMoney(User u) {
		System.out.println(u.getNum());
		
		query =   "update userlist "
				+ "set money = money + ("
				+ "select sum(if(i.fish_size > f.default_size,"
				+ 			"(i.fish_size-f.default_size)*1000 + price, price)) as finalprice "
				+ 			"from inventory as i "
				+ 			"inner join fish as f "
				+ 			"on i.fish_no = f.fish_no "
				+ 			"group by i.num "
				+ 			"having i.num = ? ) "
				+ "where num = ? ";
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1, u.getNum());
			pst.setInt(2, u.getNum());
			return pst.executeUpdate();
		} catch (SQLException e) {
			System.out.println("money plus error");
			e.printStackTrace();
		}
		return 0;
	}


	@Override
	public boolean compMoney(User u1) {
		System.out.println(u1.getCost() + "" + u1.getNum());			//	낚시대 가격
		
		query = "select if(money < ?, 0, 1) as bool from userlist where num = ? ";
		// 잔고가 낚싯대 가격보다 작으면 0 출력 아니면 1
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1, u1.getCost());
			pst.setInt(2, u1.getNum());
		
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				int res = rs.getInt("bool");
				if(res == 0) {
					return false;
				}
			}
		} catch (SQLException e) {
			System.out.println("money compare error");
			e.printStackTrace();
		}
		return true;
	}
	
	@Override
	public List<Inventory> userInven(int num) {
//		System.out.println("인벤토리 데이터 DAOImpl 확인 성공 " + num);
		query =   "select i.inven_id, i.num, i.fish_no, f.fish_name, i.fish_size from inventory as i "
				+ "inner join fish as f "
				+ "on i.fish_no = f.fish_no "
				+ "where i.num = ?";
		List<Inventory> list = new ArrayList<>();
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1, num);
			
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				list.add(new Inventory(rs.getInt("inven_id"),
									   rs.getString("fish_name"),
									   rs.getInt("fish_size")));
			}
			return list;
		} catch (SQLException e) {
			System.out.println("list error");
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public int sellOne(Inventory i) {							// delete from inventory where
		System.out.println(i.getNum()+ " " + i.getSellno());
		query =   "delete from inventory "
				+ "where num = ? and inven_id = ?";
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1, i.getNum());
			pst.setInt(2, i.getSellno());
			return pst.executeUpdate();
		} catch (SQLException e) {
			System.out.println("inven sell fish error");
			e.printStackTrace();
		}
		
		
		return 0;
	}
	
	@Override
	public int sellAll(Inventory i) {
		System.out.println(i.getNum());
		query =   "delete from inventory "
				+ "where num = ?";
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1, i.getNum());
			return pst.executeUpdate();
		} catch (SQLException e) {
			System.out.println("inven sell fish error");
			e.printStackTrace();
		}
		return 0;
	}
	
	@Override
    public boolean compRod(User u2) {
        System.out.println(u2.getNum()+" " + u2.getFishrod());
        query = "select if(fishrod = ?, 0, 1) as bool from userlist where num = ?";
        try {
            pst = conn.prepareStatement(query);
            pst.setString(1, u2.getFishrod());
            pst.setInt(2, u2.getNum());
            
            ResultSet rs = pst.executeQuery();
            if(rs.next()) {
                int res = rs.getInt("bool");
                if(res == 0) {
                    return false;
                }
            }
        } catch (SQLException e) {
            System.out.println("fishrod compare error");
            e.printStackTrace();
        }
        return true;
    }
	
	@Override
    public List<Inventory> userRank(int num) {
        // TODO Auto-generated method stub
        query = "select i.num as num, f.fish_name as fishname, max(i.fish_size) as fishmax "
                + "from inventory as i "
                + "inner join fish as f "
                + "on i.fish_no = f.fish_no "
                + "group by i.num, f.fish_name "
                + "having i.num = ?";
        List<Inventory> list = new ArrayList<>();
        try {
            pst = conn.prepareStatement(query);
            pst.setInt(1, num);
            
            ResultSet rs = pst.executeQuery();
            while(rs.next()) {
                list.add(new Inventory(rs.getString("fishname"),
                           rs.getInt("fishmax")));
            }
            return list;
        } catch (SQLException e) {
            System.out.println("ranking error");
            e.printStackTrace();
        }
        
        return null;
    }
	
	// 기빈 끝

}