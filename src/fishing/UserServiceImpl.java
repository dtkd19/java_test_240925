package fishing;

public class UserServiceImpl implements UserService {

	private UserDAO dao;
	
	public UserServiceImpl() {
		dao = new UserDAOImpl();
	}
	
	
	@Override
	public int signUp(User u) {
		System.out.println(" 회원가입 서비스 에러 확인 성공 ");
		
		return dao.signUpUser(u);
	}


	@Override
	public User login(String id, String pw) {
		System.out.println("로그인 서비스 에러 확인 성공");
		return dao.loginUser(id,pw);
	}

	@Override
	public boolean isUserIdExists(String id) {
		// TODO Auto-generated method stub
		return dao.userIdExists(id);
	}

	
}
