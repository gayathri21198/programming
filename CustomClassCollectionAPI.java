import java.util.*;
class CustomClassCollectionApi{
	public static void main(String[] args) throws ConcurrentModificationException {
		 System.out.println("Enter the input arguments of the list");
		Scanner s=new Scanner(System.in);
		List list= new ArrayList();
		char quit='Y';
			String id,brand,colour;
			int hddsize,ramsize;
			while(quit=='Y')
			{
				System.out.println("Enter the computer ID");
				id=s.next();
				System.out.println("Enter the brand");
				brand=s.next();
				System.out.println("Enter the colour");
				colour=s.next();
				System.out.println("Enter the hddsize");
				hddsize=s.nextInt();
				System.out.println("Enter the RAMsize");
				ramsize=s.nextInt();
				list.add(new Computer(id,brand,colour,hddsize,ramsize));
				System.out.print(" Enter Another Record? (Y/N)");
				String word = s.next();
                word = word.toUpperCase();
                quit= word.charAt(0);
			}
            //Display all the elements of the list 
			 System.out.println("the contents of the list are : " + list);
			 System.out.println("Enter the choice 1.Search 2.remove 3.update");
			 int choice=s.nextInt();
		switch(choice)
		{
	         case 1:             //Search for the computer based on id,brand,colour,hddsize,RAMsize
              System.out.println("Enter the choice by which you want to search 1.id 2.brand 3.colour 4.hddsize 5.ramsize");
              int ch=s.nextInt();
              if(ch==1)      //search by id
              {
                  System.out.println("Enter the ID to be searched");
                  String id1=s.next();
                  for(Object obj : list)
                  {
                  	
                  	if(obj instanceof Computer)
                  	{
                  		
                  		System.out.println("id ex is "+((Computer)obj).getid());
                  		if(id1.equals(((Computer)obj).getid()))
                  			System.out.println(obj);
                  	}
                  }

              }

              if(ch==2)
              {
              	System.out.println("Enter the brand to be searched");
              	String brand1=s.next();
              	for(Object obj : list)
              	{
              		if(obj instanceof Computer)
              		{
              			if(brand1.equals(((Computer)obj).getbrand()))
              				System.out.println(obj);
              		}
              	}
              }

              if(ch==3)
              {
              	System.out.println("Enter the colour to be searched");
              	String colour1=s.next();
              	for(Object obj : list)
              	{
              		if(obj instanceof Computer)
              		{
              			if(colour1.equals(((Computer)obj).getcolour()))
              				System.out.println(obj);
              		}
              	}
              }

              if(ch==4)
              {
              	System.out.println("Enter the hddsize to be searched");
              	int hddsize1=s.nextInt();
              	for(Object obj : list)
              	{
              		if(obj instanceof Computer)
              		{
              			if(hddsize1==((Computer)obj).gethddsize())
              				System.out.println(obj);
              		}
              	}
              }

              if(ch==5)
              {
              	System.out.println("Enter the ramsize to be searched");
              	int ramsize1=s.nextInt();
              	for(Object obj : list)
              	{
              		if(obj instanceof Computer)
              		{
              			if(ramsize1==((Computer)obj).getramsize())
              				System.out.println(obj);
              		}
              	}
              }
      

              case 2:
              System.out.println("Enter the ID of the computer to be deleted");
              String id2=s.next();
              for(Object obj : list)
              {
              	// System.out.println("for");
              	if(obj instanceof Computer)
              	{
              		if(id2.equals(((Computer)obj).getid()))
              			// System.out.println("it");
              			list.remove(obj);
              		
              	}
              	System.out.println("the contents of the list are : "+list);                      
              }
             break;


            default:
            System.out.println("there is no computer");
            break;

      
		}

		
	}
}

class Computer{
	private String brand,colour,id;
	private int hddsize,ramsize;

	Computer(String id,String brand,String colour,int hddsize,int ramsize)
	{
		this.id=id;
		this.brand=brand;
		this.colour=colour;
		this.hddsize=hddsize;
		this.ramsize=ramsize;
	}

	public String getid()
	{
		return this.id;
	}

	public String getbrand()
	{
		return this.brand;
	}

	public String getcolour()
	{
		return this.colour;
	}

	public Integer gethddsize()
	{
		return this.hddsize;
	}

	public Integer getramsize()
	{
		return this.ramsize;
	} 

	@Override
	public String toString()
	{
		return "Computer :(" +this.getid() + "," + this.getbrand() + "," + this.getcolour() + "," + this.gethddsize() + "," + this.getramsize() + ")";
	}

	

}
