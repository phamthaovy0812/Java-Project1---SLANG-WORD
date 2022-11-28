import java.io.*;
import java.util.*;

public class SlangDictionary{
    public static HashMap ReadFile(String path)
    {
        HashMap <String,String> dictionary= new HashMap<String,String>();
        try{
            FileInputStream fis = new FileInputStream(path);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader bfr = new BufferedReader(isr);
            String line = bfr.readLine();
            while(line != null){
                String []arr = line.split("`");
                if(arr.length == 2){
                    dictionary.put(arr[0],arr[1]); 
                }
                line = bfr.readLine();
            }
            fis.close();
            isr.close();
            bfr.close();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return dictionary;
    }
    public static void WriteToFile(String path,HashMap<String,String>dic)
    {
        try{
            FileWriter fw= new FileWriter(path);
            for (String i : dic.keySet()) {
                fw.write( i + "`" + dic.get(i)+"\n");
              }
            
            fw.close();
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    public static void WriteHistoryFile(String path, String key, String value)
    {
        try{
            FileWriter fw= new FileWriter(path,true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(key +'`'+ value+'\n');
            bw.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    public static void Print(HashMap<String,String> hm)
    {
        for (String i: hm.keySet())
        {
            System.out.println("key: " + i + " value: " + hm.get(i));
        }
    }
    public static void FindFromSlang (String path,HashMap<String,String>dic,String slang)
    {
        boolean check=dic.containsKey(slang);
        if(check==false)
        {
            System.out.println("Can't find this slang in this Dictionary!");
        }
        else{
            System.out.println("This slang is: "+slang+", mean: "+dic.get(slang));
            WriteHistoryFile(path, slang,dic.get(slang));
          
        }
    } 

    public static void FindFromDefinition(String path,HashMap<String,String>dic,String definition )
    {
       
        for(Map.Entry< String, String> temp : dic.entrySet())
        {
            String key=temp.getKey();
            String value=temp.getValue();
            String[]check=value.split("|");
            for(String a:check)
            {System.out.println("slang: "+key+"mean: "+value+'\n');
                if(a==definition)
                {
                    System.out.println("slang: "+key+"mean: "+value+'\n');
                    WriteHistoryFile(path, key, value);
                }
            }
            
        }
      
    }
    public static void PrintHistory (String path)
    {
        HashMap<String,String> his=ReadFile(path);
        Print(his);
    }

    public static HashMap AddSlang(HashMap<String,String>dic,String slang)
    {
        Scanner sc= new Scanner(System.in);
        if(dic.containsKey(slang))
        {
            System.out.println("This slang is availble in this Dictionary. Press 1 to OverWrite this Slang, 2 to Duplicate and 0 to Cancel!");
            int check= sc.nextInt();
            if (check==1)
            {
                System.out.print("Enter definition of this slang: ");
                String definition= sc.nextLine();
                dic.put(slang, definition);
                System.out.println("Complete OverWrite!");
            }
            else if(check==2)
            {
                System.out.println("Duplicate!");

            }
            else
            {
                System.out.println("Cancel!");
            }  
        }
        else{
            System.out.print("Enter definition of this slang: ");
            String definition= sc.nextLine();
            dic.put(slang, definition);
            System.out.println("Complete Add New Slang!");
        }
        
        return dic;

    }


    public static void main(String args[])
    {
        Scanner sc= new Scanner(System.in);
        HashMap <String,String> dictionary=new HashMap<String,String>();
        dictionary=ReadFile("test.txt");
        //FindFromDefinition("history.txt",dictionary,"Maniacal");
        //FindFromSlang("history.txt",dictionary,">:D");
        //PrintHistory("history.txt");
        


        
        
        /* 
        int choose=1;
        System.out.println("--- WELCOME TO SLANG DICTIONARY PROGRAMMING ---");
        while ( choose!=0)
        {
            System.out.println("\nPlease choose 1 option:\n1. Search by slang word.\n2. Search by definition.\n3. Show history - list of searched slang words\n4. Add a new slang words.\n5. Edit a slang word.\n6. Delete a slang word.\n7. Reset the original slang words list.\n8. Random 1 slang word (On this day slang word).\n9. Quiz (the program displays 1 random slang word).\n10. Quiz (the program displays 1 random definition).");
            System.out.print("\nYour option is: ");
            int option =sc.nextInt();
            while (option<1||option>10)
            {
                System.out.println("Error! Please enter right number (1-10) to use this program. Thank you!");
                System.out.print("Your option is: ");
                option=sc.nextInt();
            }
            switch(option)
            {
                case 1:
                {
                    System.out.println("hihi");
                    break;
                }
                case 2:
                {
                    System.out.println("hihi");
                    break;
                }
                case 3:
                {
                    System.out.println("hihi");
                    break;
                }
                case 4:
                {
                    System.out.println("hihi");
                    break;
                }
                case 5:
                {
                    System.out.println("hihi");
                    break;
                }
                case 6:
                {
                    System.out.println("hihi");
                    break;
                }
                case 7:
                {
                    System.out.println("hihi");
                    break;
                }
                case 8:
                {
                    System.out.println("hihi");
                    break;
                }
                case 9:
                {
                    System.out.println("hihi");
                    break;
                }
                case 10:
                {
                    System.out.println("hihi");
                    break;
                }
            }

            System.out.println("Please enter 0 if you want to EXIT/ 1 if you dont want.");
            System.out.print("Your choose is: ");
            choose=sc.nextInt();
            System.out.println("---------------------------------------------------------");
        }
        System.out.println("\nThank you for using program! Have a nice day!");
        
     */
    }
  
}
 