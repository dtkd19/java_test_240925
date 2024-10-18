package jdbcStudent;

import java.util.List;

public class StuSvcImpl implements Service {
	
	
	private DAO dao;
	
	
	public StuSvcImpl() {
		dao = new StuDaoImpl();
	}


	@Override
	public int insert(Student s) {
		
//		System.out.println("추가 서비스 임플 성공");
		
		return dao.insertStu(s);
	}


	@Override
	public List<Student> getList() {
//		System.out.println(" 학생목록 서비스 임플 성공");
		
		
		return dao.getStuList();
	}


	@Override
	public Student getInfo(int no) {
//		System.out.println(" 학생 정보 찾기 서비스 임플 성공 ");
		return dao.getStuInfo(no);
	}


	@Override
	public int update(Student s) {
//		System.out.println(" 학생 정보 수정 서비스 임플 성공 ");
		return dao.updateInfo(s);
	}


	@Override
	public int delete(int no) {
//		System.out.println(" 학생 삭제 서비스 임플 성공");
		return dao.deleteStu(no);
	}
	
	
	

}
