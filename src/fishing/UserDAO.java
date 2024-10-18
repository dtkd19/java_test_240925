package fishing;

public interface UserDAO {


	int signUpUser(User u);

	User loginUser(String id, String pw);

	boolean userIdExists(String id);

}
