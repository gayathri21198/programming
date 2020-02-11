import java.io.*;
import java.util.*;

class FileReadAndDisplay{
	public static void main(String[] args) throws IOException{
		//creation of Directory:
        Scanner s=new Scanner(System.in);
        System.out.println("Enter the path where the directory is stored : ");
        String path=s.next();
        System.out.println("Enter the desired name of the directory : ");
        path=path+s.next();
        File dir1=new File(path);
        dir1.mkdir();

		
      // file write operation:
		char [] arr =new char[100];
		int size=0;
		File file=new File(dir1, "Gayathri.txt");
		FileWriter fw = new FileWriter(file);
		fw.write("Hello\nJAVA!!\nThis is a text document\nused for learning JAVA FileHandling");
		fw.flush();
		fw.close();

	// File read operation:
		// int ch;
		// File file1=new File(dir1,"Gayathri.txt");
		// FileReader fr = new FileReader(file1);
		// while((ch=fr.read())!=-1)
		// {
        //   System.out.print((char)ch);
		// }
		// fr.close();

	// Reading the file and dispalying the line number before each line:
        LineNumberReader num=null;
        File file1=new File(dir1,"Gayathri.txt");
        num = new LineNumberReader(new FileReader(file1));
        System.out.print("Line : " + num.getLineNumber());
        num.setLineNumber(0);
        String line = null;
        while((line=num.readLine())!=null)
        {
        	System.out.println("Line" + num.getLineNumber() + ":" +line);
        }
        
        
            try{
                if(num!=null)
        
                  num.close();
        
            }

            catch(IOException e)
            {
                System.out.println("Error" + e.getMessage());
            }
        	

        
        



	}
}      
