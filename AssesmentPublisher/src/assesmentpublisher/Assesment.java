package assesmentpublisher;

public class Assesment {
	
	private String assesmentDisc;
	private String startDate;
	private String deadLine;
	private String assesmentName;
		
	public Assesment( String assesmentDisc, String startDate, String deadLine, String assesmentName) {
		
		this.assesmentDisc = assesmentDisc;
		this.startDate = startDate;
		this.deadLine = deadLine;
		this.assesmentName = assesmentName;
		
	}
	
	public String getAssesmentDisc() {
		
		return assesmentDisc;
		
	}
	
	public void setAssesmentDisc(String assesmentDisc) {
		
		this.assesmentDisc = assesmentDisc;
		
	}
	
	public String getStartDate() {
		
		return startDate;
		
	}
	
	public void setStartDate(String startDate) {
		
		this.startDate = startDate;
		
	}
	
	public String getDeadLine() {
		
		return deadLine;
		
	}
	
	public void setDeadLine(String deadLine) {
		
		this.deadLine = deadLine;
		
	}
	
	public String getAssesmentName() {
		
		return assesmentName;
		
	}
	
	public void setAssesmentName(String assesmentName) {
		
		this.assesmentName = assesmentName;
		
	}
	
	

}

