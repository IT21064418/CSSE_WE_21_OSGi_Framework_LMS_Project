package studentmanagement_subscriber;

import java.util.ArrayList;
import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;

import studentmanagement_publisher.IStudentManagement_Services;
import studentmanagement_publisher.Student;


public class Subscriber_Activator implements BundleActivator {
	
	private ServiceReference studentmanagement_reference;
	private ServiceRegistration studentManagementReg;
	private IStudentManagement_Services studentservice;
	
	Scanner sc = new Scanner(System.in);
	
	public void start(BundleContext context) throws Exception {
		 	
		System.out.println("Student management system loaded.");
		studentManagementReg = context.registerService(this.getClass().getName(), this, null);
		studentmanagement_reference = context.getServiceReference(IStudentManagement_Services.class.getName());
		studentservice = (IStudentManagement_Services) context.getService(studentmanagement_reference);
		
	    studentservice.startService();

	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("Student management system ended.");
		context.ungetService(studentmanagement_reference);
	}
	
	public void displayMenu() {
		
		try {
			
		    char menuinput = 'X';
		    do{
		      
		      studentservice.displayMenu();
		      
		      int choice,indexNo,std_year;
		      String student_name,degree_program;
		    
		      System.out.print("SELECT THE NO:");
		      choice = sc.nextInt();
		      char input='X';
		      do{
		  
		        if(choice == 1){

		          
		    	  ArrayList<Student> studentlist = studentservice.viewStudents();
		    	  for (int i = 0; i < studentlist.size(); i++){
			          	System.out.print("Enter the Index No:");
			          	indexNo = sc.nextInt();
		    		    Student student = studentlist.get(i);
		    		    if(indexNo==student.getStd_id()) {
		    		      System.out.println("Index No Already Exists");
		    		      break;
		    		    }
		    		    else {
		  		          System.out.print("Enter the Student Name:");
				          student_name = sc.next();
				          System.out.print("Enter the Degree Program:");
				          degree_program = sc.next();
				          sc.nextLine();
				          System.out.print("Enter the year:");
				          std_year = sc.nextInt();
				          
				          studentservice.Addstudents(indexNo, student_name, degree_program, std_year);
				          System.out.println("Successfully Completed");
				          System.out.println("---------------------------------");
				          break;
				         
		    		    } 
		    		}
		    	  
		          System.out.print("DO YOU WISH TO CONTINUE:");
		          input=sc.next().charAt(0);
		          
		          System.out.print("DO YOU WISH GO TO MAIN MENU:");
		          menuinput = sc.next().charAt(0);


		      }
		      else if(choice == 2){
		    	  ArrayList<Student> studentlist = studentservice.viewStudents();
		    	  for (int i = 0; i < studentlist.size(); i++){
		    		    Student student = studentlist.get(i);
		    		    System.out.println("Student Index: "+ student.getStd_id());
		    		    System.out.println("Student Name: "+ student.getStd_name());
		    		    System.out.println("Degree Program: "+ student.getStd_degreeprogram());
		    		    System.out.println("Year: "+ student.getStd_year());
		    		    System.out.println("---------------------------------");
		    		}
		          System.out.print("DO YOU WISH GO TO MAIN MENU:");
		          menuinput = sc.next().charAt(0);
		          System.out.println("---------------------------------");
		      }
		      else if(choice == 3){
				  System.out.println("Enter the Student Index to delete: ");
				  int index = sc.nextInt();
		    	  ArrayList<Student> studentlist = studentservice.viewStudents();
		    	  for (int i = 0; i < studentlist.size(); i++) {
		    		  
		    		    Student student = studentlist.get(i);
		    		    if(index==student.getStd_id()) {
			    		    System.out.println("Student Index: "+ student.getStd_id());
			    		    System.out.println("Student Name: "+ student.getStd_name());
			    		    System.out.println("Degree Program: "+ student.getStd_degreeprogram());
			    		    System.out.println("Year: "+ student.getStd_year());
			    		    System.out.println("---------------------------------");
			    		    System.out.print("Are You Sure Want To Delete:");
			    		    char delete = sc.next().charAt(0);
			    		    if(delete=='Y' || delete=='y') {
			    		    	studentservice.removestudent(index);
			    		    	System.out.println("Successfully Completed");
			    		    }
		    		    }
		    		}
		          System.out.print("DO YOU WISH TO CONTINUE:");
		          input=sc.next().charAt(0);
		          System.out.print("DO YOU WISH GO TO MAIN MENU:");
		          menuinput = sc.next().charAt(0);
		          System.out.println("---------------------------------");
		      }
		      else if(choice == 4){
		          System.out.print("Enter the Index No:");
		          indexNo = sc.nextInt();
		    	  studentservice.updatestudentdetails(indexNo);
		          System.out.print("DO YOU WISH TO CONTINUE:");
		          input=sc.next().charAt(0);
		          System.out.print("DO YOU WISH GO TO MAIN MENU:");
		          menuinput = sc.next().charAt(0);
		          System.out.println("---------------------------------");
		    	  
		      }
		      else if(choice == 5) {
		    	  System.out.println("Thank You For Using Our LMS System");
		    	  break;
		      }
		      else{
		        System.out.println("Invalid Selection Please Input");
		        System.out.print("DO YOU WISH GO TO MAIN MENU:");
		        menuinput = sc.next().charAt(0);
		        System.out.println("---------------------------------");
		      }
		        
		      if(choice == 5) {
		    	  
		    	 break; 
		    	  
		      }
		        
		    }while(input=='Y' || input=='y');
		      
		      if(choice == 5) {
		    	  
		    	 break; 
		    	  
		      }
		      
		    }while(menuinput=='Y' || menuinput=='y');
			
		}catch (Exception e){
			System.out.println(e);
		}
		
	}

}
