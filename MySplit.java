import java.util.Scanner;
class MySplit{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the input string");
        String input= sc.nextLine();
        System.out.println("enter the delimiter");
        String delim=sc.nextLine();
        String [] output=new String[input.length()];
        output=split(input,delim);
        for(String val:output)
        {
            if(val.equals(null)){
                continue;
            }
            else{
                System.out.println(val);
            }
        }
    }

        public static String[] split(String in,String del)
        {
            String temp=new String ();
            String output=new String[in.length()];
            int index=0;
            for(i=0;i<in.length()-del.length()+1;i++)
            {
                if(in.substring(i,i+del.length()).equals(del))
                {
                    output[index]=temp;
                    temp="";
                    index++;
                    i+=del.length()-1;
                }
                else{
                    temp+=in.substring(i,i+1);
                }
            }
            temp=in.substring(in.length()-del.length()+1,in.length());
            output[index]=temp;
            return output;
        }

        
    }
