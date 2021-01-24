import java.io.*;
import java.util.*;
 
class Bully{

    static int n;
    static int priority[] = new int[100];
    static int alive[] = new int[100];
    static int elected;
     
    public static void main(String args[])throws IOException
    {
        Random rand = new Random();
        System.out.println("Enter the number of process");
        
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
         
        for(int i=0;i<n;i++)
        {
            alive[i] = rand.nextInt(2);
            priority[i] = rand.nextInt(100);
            System.out.println("Process " + i + " Alive " + alive[i] + " Priority " + priority[i]);
        }
        
        System.out.println("Which process will initiate election?");
         
        elect(in.nextInt());
        System.out.println("Final coordinator is "+elected);
    }
     
    static void elect(int p)
    {
        elected = p;

        for(int i=0; i<n; i++)
        {
            if(priority[p]<priority[i])
            {
                System.out.println("Election message is sent from " + p + " to " + i);
                if(alive[i]==1) elect(i);
            }
        }
    }
}