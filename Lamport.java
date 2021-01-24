import java.util.*;
import java.io.*;

public class Lamport {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int p, i, j;
		
		System.out.println("Enter the number of process:");
		p = sc.nextInt();

		int events[] = new int[p + 1];
		List<String>[] event_instructions = new ArrayList[p + 1];
		Map<String, Integer>[] event_map = new HashMap[p + 1];
		List<Integer>[] response = new ArrayList[p + 1];
		int[] timestamp = new int[p + 1];
		int max_events = Integer.MIN_VALUE;

		System.out.println("Enter the no of events per process:");
		for (i = 1; i <= p; i++) {
			events[i] = sc.nextInt();
			max_events = Math.max(max_events, events[i]);
		}

		System.out.println("Enter events types:");
		for (i = 1; i <= p; i++) {
			System.out.println("For process:" + i);
			event_instructions[i] = new ArrayList<String>();
			event_map[i] = new HashMap<>();
			response[i] = new ArrayList<>();
			for (j = 1; j <= events[i]; j++) {
				System.out.println("For event:" + j);
				event_instructions[i].add(sc.next());
			}
		}

		System.out.println("Process Events:");
		for (i = 1; i <= p; i++) {
			System.out.print("P" + i + " : ");
			for (j = 1; j <= events[i]; j++) {
				System.out.print(event_instructions[i].get(j - 1) + " ");
			}
			System.out.println();
		}

		boolean check = true;
		while (check) {
			check = false;
			for (i = 1; i <= p; i++) {
				if (event_instructions[i].size() > 0) {
					check = true;
					String e = event_instructions[i].get(0);
					if (e.equals("x")) {
						response[i].add(++timestamp[i]);
						event_instructions[i].remove(0);
					} else if (e.charAt(0) == 's') {
						event_map[i].put(e, ++timestamp[i]);
						response[i].add(timestamp[i]);
						event_instructions[i].remove(0);
					} else if (e.charAt(0) == 'r') {
						if (event_map[e.charAt(1) - '0'].containsKey("s" + i)) {
							timestamp[i] = Math.max(timestamp[i], event_map[e.charAt(1) - '0'].get("s" + i));
							response[i].add(++timestamp[i]);
							event_instructions[i].remove(0);
						}
					} else {
						System.out.println("Wrong Input");
						return;
					}
				}
			}

		}

		System.out.println("Logical Clock Value:");
		for (i = 1; i <= p; i++) {
			System.out.print("P" + i + " : ");
			for (j = 1; j <= events[i]; j++) {
				System.out.print(response[i].get(j-1) + " ");
			}
			System.out.println();
		}
	}

}