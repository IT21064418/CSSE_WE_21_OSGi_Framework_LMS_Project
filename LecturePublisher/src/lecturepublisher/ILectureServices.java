package lecturepublisher;

import java.util.ArrayList;

public interface ILectureServices {
	
	public void startService();
	public ArrayList<Lecture> viewAllLectures();
	public int addLecture(String lectureName, String module, String moduleCode, String lecturer, int duration);
	public int removeLecture(int index);
	public int updateLecture(int index);
	public void displayMenu();

}
