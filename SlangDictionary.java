import java.io.*;
import java.util.*;

public class SlangDictionary{
    public static void main(String args[])
    {
        Scanner sc= new Scanner(System.in);
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
        

    }
}
 