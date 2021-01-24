import java.util.*;
import java.io.*;

public class RicartAgrawala {

    public static List<Process> processes, cs_list;
    public static Process current; 

    public static class Process {
        int id;
        int timestamp;
        Process(int id, int timestamp) {
            this.id = id;
            this.timestamp = timestamp;
        }
    }

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        
		System.out.println("Enter the number of process:");
		int n = Integer.parseInt(sc.nextLine());

        processes = new ArrayList<>();
        for(int i=0;i<n;i++) {
            processes.add(new Process(i, rand.nextInt(10000)));
            System.out.println("Process " + processes.get(i).id + " Timestamp " + processes.get(i).timestamp);
        }

		System.out.println("\nEnter the number of process who want to enter CS:");
        String s = sc.nextLine();

        cs_list = new ArrayList<>();
        for(String str: s.split(" ")) {
            cs_list.add(processes.get(Integer.parseInt(str)));
        }

        System.out.println("");

        for(Process p: new ArrayList<>(cs_list)) {
            Thread t1 = new Thread(new Runnable() {
                public void run()
                {
                    enter_cs(p);
                }});  
            t1.start();
        }

        sc.close();
    }
    
    public static void enter_cs(Process process) {
        List<String> replies = new ArrayList<>();
        
        for(Process p: processes) 
            if (p.id != process.id)
                request(p, process, replies);

        while(replies.size()!=processes.size()-1);

        current = process;
        System.out.println(process.id + " Process entered CS");
        System.out.println(process.id + " Process left CS\n");

        release(process);
    }

    public static void request(Process p, Process process, List<String> replies) {
        while (current==p);
        while (cs_list.contains(p)) {
            if (p.timestamp > process.timestamp) {
                replies.add("REPLY");
                return;
            }
        }
        replies.add("REPLY");
    }

    public static void release(Process process) {
        current = null;
        cs_list.remove(process);
    }

}