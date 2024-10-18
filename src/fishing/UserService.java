package fishing;

public interface UserService {
	
	int signUp(User u);

	User login(String id, String pw);

	boolean isUserIdExists(String id);
	
}
