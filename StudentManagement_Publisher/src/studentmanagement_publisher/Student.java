	package studentmanagement_publisher;

public class Student {
	private int std_id;
	private String std_name;
	private String std_degreeprogram;
	private int std_year;
	
	public Student(int std_id, String std_name, String std_degreeprogram, int std_year) {
		super();
		this.std_id = std_id;
		this.std_name = std_name;
		this.std_degreeprogram = std_degreeprogram;
		this.std_year = std_year;
	}

	public int getStd_id() {
		return std_id;
	}

	public void setStd_id(int std_id) {
		this.std_id = std_id;
	}

	public String getStd_name() {
		return std_name;
	}

	public void setStd_name(String std_name) {
		this.std_name = std_name;
	}

	public String getStd_degreeprogram() {
		return std_degreeprogram;
	}

	public void setStd_degreeprogram(String std_degreeprogram) {
		this.std_degreeprogram = std_degreeprogram;
	}

	public int getStd_year() {
		return std_year;
	}

	public void setStd_year(int std_year) {
		this.std_year = std_year;
	}
}
