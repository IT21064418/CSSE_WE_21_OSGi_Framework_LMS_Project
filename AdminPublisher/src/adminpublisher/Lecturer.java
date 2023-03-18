package adminpublisher;

public class Lecturer {
	private int lecturer_id;
	private String lec_name;
	private String lec_email;
	private String lec_contactno;
	

	public Lecturer(int lecturer_id, String lec_name, String lec_email, String lec_contactno) {
		super();
		this.lecturer_id = lecturer_id;
		this.lec_name = lec_name;
		this.lec_email = lec_email;
		this.lec_contactno = lec_contactno;
	}


	public int getLecturer_id() {
		return lecturer_id;
	}


	public String getLec_name() {
		return lec_name;
	}


	public String getLec_email() {
		return lec_email;
	}


	public String getLec_contactno() {
		return lec_contactno;
	}


	public void setLecturer_id(int lecturer_id) {
		this.lecturer_id = lecturer_id;
	}


	public void setLec_name(String lec_name) {
		this.lec_name = lec_name;
	}


	public void setLec_email(String lec_email) {
		this.lec_email = lec_email;
	}


	public void setLec_contactno(String lec_contactno) {
		this.lec_contactno = lec_contactno;
	}

	
	
	

}
