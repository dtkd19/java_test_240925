package jdbcStudent;

import java.util.List;

public interface Service {

	int insert(Student s);

	List<Student> getList();

	Student getInfo(int no);

	int update(Student s);

	int delete(int no);


}
