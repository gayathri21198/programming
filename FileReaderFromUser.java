import java.util.*;
import java.io.*;
class FileReaderFromUser{
	public static void main(String[] args)throws IOException{
		//creation of Directory:
         Scanner s=new Scanner(System.in);
  //       System.out.println("Enter the path where the directory is stored : ");
  //       String path=s.next();
  //       System.out.println("Enter the desired name of the directory : ");
  //       path=path+s.next();
  //       File dir1=new File(path);
  //       dir1.mkdir();

		
  //     // file write operation:
		// char [] arr =new char[100];
		// int size=0;
		// File file=new File(dir1, "Gayathri.txt");
		// FileWriter fw = new FileWriter(file);
		// fw.write("Hello\nJAVA!!\nThis is a text document\nused for learning JAVA FileHandling");
		// fw.flush();
		// fw.close();

	  //filename read from user:
		System.out.println("Enter the filename to be read ");
		String fileName = s.nextLine();
		s.nextLine();
		File file2 = new File(fileName);
		if(file2.exists())
        System.out.println("The file " +fileName+ " exists");
        else
        System.out.println("The file " +fileName+ " does not exist");
 
        if(file2.exists()){
        if(file2.canRead())
        System.out.println("The file " +fileName+ " is readable");
        else
        System.out.println("The file " +fileName+ " is not readable");
 
        if(file2.canWrite())
        System.out.println("The file " +fileName+ " is writeable");
        else
        System.out.println("The file " +fileName+ " is not writeable");
 
        System.out.println("The file type is: " +fileName.substring(fileName.indexOf('.')+1));
 
        System.out.println("The Length of the file:" +file2.length());
	    }
	}
}


