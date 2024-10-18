package jdbcStudent;

import java.util.List;

public interface DAO {

	int insertStu(Student s);

	List<Student> getStuList();

	Student getStuInfo(int no);

	int updateInfo(Student s);

	int deleteStu(int no);

}
