package fishing;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// 건희 것 복붙
public class StateDAOImpl implements StateDAO {
	private Connection conn;
	private PreparedStatement pst;
	private String query = "";
	
	public StateDAOImpl() {
		DatabaseConnection dbc = DatabaseConnection.getInstance();
		conn = dbc.getConnection();
	}

	@Override
	public State printSpot(String spot) {
//		System.out.println("printId DAOImpl success");
		query = "select state_name, enter_fee from state where state_id = ?;";
		try {
			pst = conn.prepareStatement(query);
			pst.setString(1, spot);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				State s = new State(rs.getString("state_name"), rs.getInt("enter_fee"));
				return s;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void getCalc(String spot, int num) {
//		System.out.println("getCalc DAOImpl success");
		query = "update userlist u set u.money = u.money - (SELECT s.enter_fee FROM state s WHERE s.state_id = ?) WHERE u.num = ?;";
		try {
			pst = conn.prepareStatement(query);
			pst.setString(1, spot);
			pst.setInt(2, num);
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}