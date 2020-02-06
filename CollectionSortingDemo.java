import java.util.*;
class CollectionSortingDemo{
	public static void main(String[] args) {
		System.out.println("Enter the input arguments of the list");
		Scanner s=new Scanner(System.in);
		List list= new ArrayList();
		char quit='Y';
			String fullname;
			int age;
			while(quit=='Y')
			{
				System.out.println("Enter the name");
				fullname=s.nextLine();
				System.out.println("Enter the age");
				age=s.nextInt();
				list.add(new Student(fullname,age));
				System.out.print(" Enter Another Record? (Y/N)");
				String word = s.next();
				s.nextLine();
                word = word.toUpperCase();
                quit= word.charAt(0);
			}
			System.out.println("the contents of the list are : " + list);
			System.out.println("enter the choice to sort the input 1.firstname 2.lastname 3.age");
			int choice=s.nextInt();
			if(choice==1)
			{
				Collections.sort(list,new CustomComparator());
				System.out.println("the contents of the list after sorting are : "+list);
			}

			if(choice==2)
			{
               Collections.sort(list,new CustomComparator1());
				System.out.println("the contents of the list after sorting are : "+list);
			}

			if(choice==3)
			{
				Collections.sort(list,new CustomComparator2());
				System.out.println("the contents of the list after sorting are : "+list);
			}	
	}
}

class CustomComparator implements Comparator{
	@Override
	public int compare(Object e1 , Object e2)
	{
		return ((Student)e1).getFirstname().compareTo (((Student)e2).getFirstname());
	}
}

class CustomComparator1 implements Comparator{
	@Override
	public int compare(Object e3,Object e4)
	{
		return ((Student)e3).getLastname().compareTo (((Student)e4).getLastname());
	}
}

class CustomComparator2 implements Comparator{
	@Override
	public int compare(Object e5,Object e6)
	{
		return ((Student)e5).getAge().compareTo (((Student)e6).getAge());
	}
}
class Student
{
	private String fullname;
	private int  age;
	String lastname = "";
    String firstname= "";
	Student(String fullname,int age)
	{
		this.fullname=fullname;
		this.age=age;
    
    if(fullname.split(" ").length>1){

       lastname = fullname.substring(fullname.lastIndexOf(" ")+1);
       //this.lastname=lastname;
       firstname = fullname.substring(0, fullname.lastIndexOf(' '));
    }
     else{
       firstname = fullname;
    }

	}

	public String getFullname()
	{
		return this.fullname;
	}

	public String getFirstname()
	{
		return this.firstname;
	}
	public String getLastname()
	{
		return this.lastname;
	}
	public Integer getAge()
	{
		return this.age;
	}

	

	@Override
	public String toString()
	{
       return "Student : "+ this.getFullname()+ " "+ "Age : " + this.getAge();
	}
}

