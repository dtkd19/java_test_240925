package student;

public class Subject {
	private String su_code;
	private String su_name;
	private int su_point;
	private int su_time;
	private String su_proName;
	private String timetable;
	private String su_place;
	
	
	public Subject() {
		
	}


	public Subject(String su_code, String su_name, int su_point, int su_time, String su_proName, String timetable,
			String su_place) {
		this.su_code = su_code;
		this.su_name = su_name;
		this.su_point = su_point;
		this.su_time = su_time;
		this.su_proName = su_proName;
		this.timetable = timetable;
		this.su_place = su_place;
	}
	
	public void insertSubject(String su_code, String su_name, int su_point, int su_time, String su_proName, String timetable,
			String su_place) {
		this.su_code = su_code;
		this.su_name = su_name;
		this.su_point = su_point;
		this.su_time = su_time;
		this.su_proName = su_proName;
		this.timetable = timetable;
		this.su_place = su_place;
	}

	
	

	@Override
	public String toString() {
		return "Subject [su_code=" + su_code + ", su_name=" + su_name + ", su_point=" + su_point + ", su_time="
				+ su_time + ", su_proName=" + su_proName + ", timetable=" + timetable + ", su_place=" + su_place + "]";
	}


	public String getSu_code() {
		return su_code;
	}


	public void setSu_code(String su_code) {
		this.su_code = su_code;
	}


	public String getSu_name() {
		return su_name;
	}


	public void setSu_name(String su_name) {
		this.su_name = su_name;
	}


	public int getSu_point() {
		return su_point;
	}


	public void setSu_point(int su_point) {
		this.su_point = su_point;
	}


	public int getSu_time() {
		return su_time;
	}


	public void setSu_time(int su_time) {
		this.su_time = su_time;
	}


	public String getSu_proName() {
		return su_proName;
	}


	public void setSu_proName(String su_proName) {
		this.su_proName = su_proName;
	}


	public String getTimetable() {
		return timetable;
	}


	public void setTimetable(String timetable) {
		this.timetable = timetable;
	}


	public String getSu_place() {
		return su_place;
	}


	public void setSu_place(String su_place) {
		this.su_place = su_place;
	}
	
	
	
	
}
