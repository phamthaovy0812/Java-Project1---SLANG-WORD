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
    public static void WriteHistoryFile(String path, String input, String res)
    {
        try{
            FileWriter fw= new FileWriter(path,true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("search: "+input+" Result: "+res+'\n');
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
        if(!dic.containsKey(slang))
        {
            System.out.println("Can't find this Slang in this Dictionary!");
            String res="Slang Unvailable!";
            WriteHistoryFile(path, slang,res);
        }
        else{
            System.out.println("This slang is: "+slang+", mean: "+dic.get(slang));
            WriteHistoryFile(path, slang,dic.get(slang));
        }
    } 

    public static void FindFromDefinition(String path,HashMap<String,String>dic,String definition )
    {
        boolean check=false;
        String res="";
        for (String i:dic.keySet())
        {
            String def=dic.get(i);
           
            if(def.contains(definition))
            {
                System.out.println("slang: "+i+'\n');
                res=res +" "+ i;
                check=true;
            }
        }  
        if (check==true)
        {
            WriteHistoryFile(path, definition,res);
        }
        if (check==false)
        {
            res="No slang!";
            WriteHistoryFile(path, definition,res);
            System.out.println(res);
        }
    }

    public static void PrintHistory (String path)
    {
        
        try{
        
            FileReader fr=new FileReader(path);
            BufferedReader bfr = new BufferedReader(fr);
            String line=bfr.readLine();
            
            while(line != null){
                System.out.println(line);
                line=bfr.readLine();
            }
            fr.close();
            bfr.close();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }

    public static HashMap AddSlang(HashMap<String,String>dic,String slang)
    {
        Scanner sc= new Scanner(System.in);
        if(dic.containsKey(slang))
        {
            System.out.println("This slang is availble in this Dictionary. Press 1 to OverWrite this Slang and 0 to Cancel!");
            int check= sc.nextInt();
            if (check==1)
            {
                System.out.print("Enter definition of this slang: ");
                sc.nextLine();
                String definition= sc.nextLine();
                dic.put(slang, definition);
                System.out.println("Complete OverWrite! New Slang is: "+slang+", mean: "+definition);
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
            System.out.println("Complete Add New Slang! New Slang is: "+slang+", mean: "+definition);
        }
        
        return dic;

    }
    public static HashMap EditSlang(HashMap<String,String>dic,String slang)
    {
        Scanner sc= new Scanner(System.in);
        if(dic.containsKey(slang))
        {
            System.out.println("Press 1 to Edit this Slang, 0 to Cancel!");
            int check= sc.nextInt();
            if (check==1)
            {
                System.out.print("Enter definition of this slang: ");
                sc.nextLine();
                String definition= sc.nextLine();
                dic.put(slang, definition);
                System.out.println("Complete Edit!");
            }
            else
            {
                System.out.println("Cancel!");
            }  
        }
        else{
            System.out.println("Error: This Slang is unvailable in this Dictionary!");
        }
        
        return dic;

    }
    public static HashMap DeleteSlang(HashMap<String,String>dic,String slang)
    {
        Scanner sc= new Scanner(System.in);
        if(dic.containsKey(slang))
        {
            System.out.println("Press 1 to Delete this Slang, 0 to Cancel!");
            int check= sc.nextInt();
            if (check==1)
            {
              
                dic.remove(slang);
                System.out.println("Complete Delete this Slang!");
            }
            else
            {
                System.out.println("Cancel!");
            }  
        }
        else{
            System.out.println("Error: This Slang is unvailable in this Dictionary!");
        }
        
        return dic;

    }
    public static void RandomSlang(HashMap<String,String>dic)
    {
        Set<String> keySet = dic.keySet();
        List<String> keyList = new ArrayList<>(keySet);

        int size = keyList.size();
        int index = new Random().nextInt(size);
        String randomKey = keyList.get(index);
        String randomValue = dic.get(randomKey);
        System.out.println("Random Slang is: "+randomKey+", mean: "+ randomValue);
    }

    public static void QuizWithSlang(HashMap<String,String>dic)
    {
        Scanner sc= new Scanner(System.in);
        Set<String> keySet = dic.keySet();
        List<String> keyList = new ArrayList<>(keySet);

        int size = keyList.size();
        int index_res = new Random().nextInt(size);
        int a1=new Random().nextInt(size);
        if (a1==index_res)
        {
            a1=new Random().nextInt(size);
        }
        int a2=new Random().nextInt(size);
        if (a1==a2|a2==index_res)
        {
            a2=new Random().nextInt(size);
        }
        int a3=new Random().nextInt(size);
        if (a2==a3|a1==a3|a3==index_res)
        {
            a3=new Random().nextInt(size);
        }
        String key = keyList.get(index_res);
        String value_res = dic.get(key);

        String a1_key=keyList.get(a1);
        String a1_value = dic.get(a1_key);

        String a2_key=keyList.get(a2);
        String a2_value = dic.get(a2_key);

        String a3_key=keyList.get(a3);
        String a3_value = dic.get(a3_key);

        System.out.print("What is Definition of this Slang: "+key+" ?\n"+"1. "+ a1_value+"\n2. "+a2_value+"\n3. "+value_res +"\n4. "+a3_value+"\n\nPlease choose Answer:");
        int choose=sc.nextInt();
        if (choose==3)
        {
            System.out.println("Congratulation! This is Right Answer!");
        }
        else{
            System.out.println("Oh No! This is Wrong Answer!");
        }
    }

    public static void QuizWithDefinition(HashMap<String,String>dic)
    {
        Scanner sc= new Scanner(System.in);
        Set<String> keySet = dic.keySet();
        List<String> keyList = new ArrayList<>(keySet);

        int size = keyList.size();
        int index_res = new Random().nextInt(size);
        int a1=new Random().nextInt(size);
        if (a1==index_res)
        {
            a1=new Random().nextInt(size);
        }
        int a2=new Random().nextInt(size);
        if (a1==a2|a2==index_res)
        {
            a2=new Random().nextInt(size);
        }
        int a3=new Random().nextInt(size);
        if (a2==a3|a1==a3|a3==index_res)
        {
            a3=new Random().nextInt(size);
        }
        String key = keyList.get(index_res);
        String value_res = dic.get(key);

        String a1_key=keyList.get(a1);
        String a1_value = dic.get(a1_key);

        String a2_key=keyList.get(a2);
        String a2_value = dic.get(a2_key);

        String a3_key=keyList.get(a3);
        String a3_value = dic.get(a3_key);
        

        System.out.print("What is Slang which Definition is : "+value_res+" ?\n"+"1. "+ a1_key+"\n2. "+a2_key+"\n3. "+ a3_key+"\n4. "+key+"\n\nPlease choose Answer:");
        int choose=sc.nextInt();
        if (choose==4)
        {
            System.out.println("Congratulation! This is Right Answer!");
        }
        else{
            System.out.println("Oh No! This is Wrong Answer!");
        }
       

    }
    public static void main(String args[])
    {
        Scanner sc= new Scanner(System.in);
        HashMap <String,String> dictionary=new HashMap<String,String>();
        dictionary=ReadFile("slang.txt");
        
        int choose=1;
        System.out.println("--- WELCOME TO SLANG DICTIONARY PROGRAMMING ---");
        while ( choose!=0)
        {
            System.out.println("\nPlease choose 1 option:\n1. Search by slang word.\n2. Search by definition.\n3. Show history - list of searched slang words.\n4. Add a new slang words.\n5. Edit a slang word.\n6. Delete a slang word.\n7. Reset the original slang words list.\n8. Random 1 slang word (On this day slang word).\n9. Quiz (the program displays 1 random slang word).\n10. Quiz (the program displays 1 random definition).");
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
                    System.out.println("\n---Search by slang word---");
                    System.out.print("Enter slang:");
                    sc.nextLine();
                    String slang=sc.nextLine();
                    FindFromSlang("history.txt",dictionary,slang);
                    break;
                }
                case 2:
                {
                    System.out.println("\n---Search by definition---");
                    System.out.print("Enter definition:");
                    sc.nextLine();
                    String definition=sc.nextLine();
                    FindFromDefinition("history.txt",dictionary,definition);
                    break;
                }
                case 3:
                {
                    System.out.println("\n---Show history - list of searched slang words---\n");
                    PrintHistory("history.txt");
                    break;
                }
                case 4:
                {
                    System.out.println("\n---Add a new slang words---");
                    System.out.print("Enter slang:");
                    sc.nextLine();
                    String slang=sc.nextLine();
                    dictionary=AddSlang(dictionary,slang);
                    break;
                }
                case 5:
                {
                    System.out.println("\n---Edit a slang word---");
                    System.out.print("Enter slang:");
                    sc.nextLine();
                    String slang=sc.nextLine();
                    dictionary=EditSlang(dictionary,slang);
                    break;
                }
                case 6:
                {
                    System.out.println("\n---Delete a slang word---");
                    System.out.print("Enter slang:");
                    sc.nextLine();
                    String slang=sc.nextLine();
                    dictionary=DeleteSlang(dictionary,slang);
                    break;
                }
                case 7:
                {
                    System.out.println("\n---Reset the original slang words list---");
                    HashMap <String,String> reset=new HashMap<String,String>();
                    reset=ReadFile("slang.txt");
                    System.out.println("\nComplete Reset!. Reset Slang Dictionary:\n");
                    Print(reset);
                    break;
                }
                case 8:
                {
                    System.out.println("\n---Random 1 slang word (On this day slang word)---\n");
                    RandomSlang(dictionary);
                    break;
                }
                case 9:
                {
                    System.out.println("\n---Quiz (the program displays 1 random slang)---\n");
                    QuizWithSlang(dictionary);
                    break;
                }
                case 10:
                {
                    System.out.println("\n---Quiz (the program displays 1 random definition)---\n");
                    QuizWithDefinition(dictionary);
                    break;
                }
            }

            System.out.println("\nPlease enter 0 if you want to EXIT/ 1 if you dont want.");
            System.out.print("Your choose is: ");
            choose=sc.nextInt();
            System.out.println("---------------------------------------------------------");
        }
        System.out.println("\nThank you for using program! Have a nice day!");
        
     
    }
  
}
 