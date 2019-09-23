import java.util.*;
public class Transaction_Student{
    int s_id;
    int b_id;
    int issue_day;
    int issue_month;
    int issue_year;
    int status;
    static int total;
    Transaction_Student(){
        status=0;
        total=1;
    }
    static inc_tot(){
        total=total+1;
    }
}
public class Transaction_Employee{
    int e_id;
    int b_id;
    int issue_day;
    int issue_month;
    int issue_year;
}
public class Admin {
	public int admin_id;
	public String admin_pass;
    int s_id=1;
    int e_id=1;
    int b_id=1;
	Scanner s=new Scanner(System.in);
    public void Add_Student( Student ob) {
        System.out.println("Enter Student Details:(Name And Reg-No)");
        ob.name=s.next();
        ob.reg_no=s.nextInt();
        ob.S_id=s_id;
        s_id++;
        ob.password=ob.name;
        System.out.println("Your Id is Your Reg no and Password is Your Name");
	}
	
	public void Add_Employee(Employee ob) {
	    System.out.println("Enter Employee Details:(Name And Emp-No)");
        ob.name=s.next();
        ob.Emp_no=s.nextInt();
        ob.E_id=e_id;
        e_id++;
        System.out.println("Your Id is Your Employee no and Password is Your Name");
	}
	
	public void Add_Book(Book ob) {
         System.out.println("Enter Book Details:(Book ISBN, Book name,Author name and total no of book available)");
        ob.book_isbn=s.nextInt();
        ob.book_name=s.next();
        ob.Author_name=s.next();
        ob.total_no_of_book_available=s.nextInt();
        ob.book_id=b_id;
        b_id++;
        ob.inc_book_count();
	}
}


public class Book {
	public int book_id;
	public int book_isbn;
	public String book_name;
	public String Author_name;
	public int total_number_of_book_available;
    static int num_book;
	
	public void Delete_book() {
	book_id=0;
    num_book=1;
	}
    static void  inc_book_count(){
        num_book=num_book+1;
    }
    public void Decrement_book_quantity() {
	total_no_of_book_available-=1;
	}
	
	public void check_book_avalability() {
	if(total_no_of_book_available==0){
        System.out.println("Book Not Available");
    }
    else if(total_no_of_book_available>0){
        System.out.println("No of Book Available:"+total_no_of_book_available);
    }
	}
    public int check_book_avalability_for_issue() {
	if(total_no_of_book_available==0){
        return 0;
    }
    else if(total_no_of_book_available>0){
        return 1;
    }
	}
    public void view_book() {
        System.our.println("Book ISBN\tBook Name\t Author Name\tNo of Book Available");
        System.out.println(book_isbn+"\t"+book_name+"\t"+Author_name+"\t"+total_no_of_book_available);
    }
    
}


public class Student {
	public int S_id;
	public String name;
	public int reg_no;
	public String password;
    int limit;
    Student(){
        limit=3;
    }
    Scanner s=new Scanner(System.in);
	public void issue_book(Book ob,Transaction_Student ob1) {
        int isbn;
        int flag;
        ob.view_book();
        System.our.println("Enter the Book ISBN Number to Issue");
        isbn=s.nextInt();
        if(ob.book_isbn==isbn){
            flag=ob.check_book_avalability_for_issue();
        }
        if(flag==1){
            if(this.limit!=0){
                ob1.s_id=this.S_id;
                ob1.b_id=ob.book_id;
                System.out.println("Enter Issue Date(Day<space>Month<space>Year)");
                ob1.issue_day=s.nextInt();
                ob1.issue_month=s.nextInt();
                ob1.issue_year=s.nextInt();
                ob.Decrement_book_quantity();
                this.limit=this.limit-1;
                ob1.status=1;
                ob1.inc_tot();
                System.out.println("Book Issued Successfully");
        }
        else if(this.limit==0){
                System.out.println("MAXIMUM limit Reached..Cannot Issue");
            }
        }
        else if(flag==0){
            System.out.println("Book Not Available!! Cannot Issue");
        }
	}
	
	public void return_book(Book ob,Transaction_Student ob1) {
        /* int b[]=new b[3];
        System.out.println("Books Issued By:"+this.name);
        for(int i=1;i<=ob1.total;i++){
            if(this.S_id==ob1[i].s_id && ob1[i].status==1 ){
                b[i]=b_id;
            }
        }
        System.our.println("Book ISBN\tBook Name\t Author Name\tNo of Book Available");
        for(int i=1;i<=b.length;i++){
            for(int j=1;j<=ob.num_book;j++){
                if(ob[j].book_id==b[i]){
                    System.out.println(book_isbn+"\t"+book_name+"\t"+Author_name+"\t"+total_no_of_book_available);
                 }   
            }  
        }
        System.out.println("Enter The ISBN Number of the book You want to return");
        int isbn=s.nextInt();
        for(int k=1;k<=b.length;k++){
            for(int j=1;j<=ob.num_book;j++){
                if(ob.book_id==b[k]){

            }
        } */
        
	}
	
	public void renew_book() {
	
	}
	
	public void pay_fine() {
	
	}
	
	public void student_login() {
	
	}
}


public class Employee {
	public int E_id;
	public String name;
	public int Emp_no;
	public String password;
	public void add_student() {
	
	}
	
	public void Issue_book() {
	
	}
	
	public void Return_book() {
	
	}
	
	public void renew_book() {
	
	}
	
	public void pay_fine() {
	
	}
	
	public void emp_login() {
	
	}
}



