import java.util.*;
import java.io.*;
class ReplaceString{
	public static void main(String[] args) {

    
        modifyFile("C:/java programs/Gayathri.txt", "Hello", "Hi");
         
        System.out.println("done");
    
		
	}

	static void modifyingthestring(String path,String old, String replce)
	{
		File tobemodified = new File(path);
		String old = "";
		BufferedReader reader = null;
		FileWriter writer = null;
		try
		{
			reader = new BufferedReader(new File(tobemodified));
			String line = reader.readLine();
			while(line!=null)
			{
				old = old + line + System.lineSeparator();
                 
                line = reader.readLine();
			}
			String replace = old.replaceAll(oldString, newString);
             
           
             
            writer = new FileWriter(tobemodified);
             
            writer.write(replace);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                
                 
                reader.close();
                 
                writer.close();
            } 
            catch (IOException e) 
            {
                e.printStackTrace();
            }
        }
    }
     
    
}
		
	
