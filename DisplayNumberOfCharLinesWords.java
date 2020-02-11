import java.io.*;
import java.util.*;

class DisplayNumberOfCharLinesWords{
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

	 // Display the number of characters:
		int ch;
		int charcount=0;
		File file1 = new File(dir1,"Gayathri.txt");
		FileReader fr = new FileReader(file1);
		while((ch=fr.read())!=-1)
		{
			charcount++;
			System.out.print((char)ch);
		}
		System.out.println("total number of characters : " +charcount);
		
		// Display the number of lines: 
        LineNumberReader num = null;
        num=new LineNumberReader(new FileReader(file1));
        System.out.print("Line : " + num.getLineNumber());
        num.setLineNumber(0);
		String line = null;
		int linecount=0 ;

		while((line=num.readLine())!=null)
		{
            linecount++;
            System.out.println("Line" + num.getLineNumber()+":"+line);
		}
		System.out.println("total number of lines : " + linecount);

		try{
                if(num!=null)
        
                  num.close();
        
            }

            catch(IOException e)
            {
                System.out.println("Error" + e.getMessage());
            }
          
           // Display the number of words:

        FileInputStream fis = new FileInputStream(file1);
		InputStreamReader in = new InputStreamReader(fis);
		BufferedReader br = new BufferedReader(in);
		int wordcount=0;
		String data;
		while((data=br.readLine())!=null)
		{
            String[] words= data.split(" ");
            wordcount=wordcount+words.length;
		}
		System.out.println("Total number of words : "+wordcount);
		br.close();
		fr.close();
	}
}


