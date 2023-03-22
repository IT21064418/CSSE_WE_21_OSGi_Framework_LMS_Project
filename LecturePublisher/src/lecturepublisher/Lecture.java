package lecturepublisher;

public class Lecture {
	
	private String lectureName;
	private String module;
	private String moduleCode;
	private String Lecturer;
	private int duration;
	
	public Lecture(String lectureName, String module, String moduleCode, String lecturer, int duration) {
		
		this.lectureName = lectureName;
		this.module = module;
		this.moduleCode = moduleCode;
		this.Lecturer = lecturer;
		this.duration = duration;
		
	}

	public String getLectureName() {
		
		return lectureName;
		
	}

	public void setLectureName(String lectureName) {
		
		this.lectureName = lectureName;
		
	}

	public String getModule() {
		
		return module;
		
	}

	public void setModule(String module) {
		
		this.module = module;
		
	}

	public String getModuleCode() {
		
		return moduleCode;
		
	}

	public void setModuleCode(String moduleCode) {
		
		this.moduleCode = moduleCode;
		
	}

	public String getLecturer() {
		
		return Lecturer;
		
	}

	public void setLecturer(String lecturer) {
		
		Lecturer = lecturer;
		
	}

	public int getDuration() {
		
		return duration;
		
	}

	public void setDuration(int duration) {
		
		this.duration = duration;
		
	}
	
	
	
	

}
