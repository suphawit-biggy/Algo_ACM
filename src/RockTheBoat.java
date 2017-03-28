import java.util.*; 											//import function.

public class RockTheBoat {										//RockTheBoat class.
	public static int putInBoat(int r, int t, int b, int w, ArrayList<Integer> p) {		//putInBoat method.
		//r = remaining weight
		//t = total passengers
		//b = times 0f shipping
		//w = total weight
		//p = ArrayList of passengers's weight
		if (p.size() == 0)										
			return b;											

		int a = -1;												

		for (int i = 0; i < p.size(); i++) {					//loop until last element of ArrayList p
			ArrayList<Integer> q = new ArrayList<Integer>(p);	//
			int s = p.get(i);									//
			int ret;											//
			if (s <= r) {										//outer if element p <= The remaining weight
				q.remove(i);									//
				ret = putInBoat(r - s, t + 1, b, w, q);			//
			} else {											//outer else (element p > The remaining weight)
				if (t > 0) {									//inner if total passengers > 0
					q.remove(i);								//
					ret = putInBoat(w - s, 1, b + 1, w, q);		//
				} else {										//else
					return b;									//
				}												//end inner else.
			}													//end outer else.
			if (a > ret || a == -1)								
				a = ret;										
		}
		return a;

	}
	
	public static void main(String args[]) {					//main method.
		String line;											//declare line(string) for store input from keyboard.
		int w;													//the total weight that a boat can carry in kilograms.
		int n;													//number of passengers weights.
		ArrayList<Integer> p;									//declare ArrayList p(integer) for passengers weights.

		Scanner input = new Scanner(System.in); 				//scan input from keyboard.sd

		while (true) {											//while if true.
			System.out.print("total weight : ");
			line = input.nextLine();							//set total weight = input from keyboard.
			if (line.isEmpty())									//if line is empty.
				continue;
			if (line.equals("00000")) 							//if line = "00000" (The end of the input is marked by a line with five zeros (00000).
				break;											//break out.
			w = Integer.parseInt(line);							//convert line(string) to w(integer).
			System.out.print("Passengers�Eweights : ");
			String[] tokens = input.nextLine().split("\\s+");	//declare array of string(Passengers�Eweights) = input separated by a space.
			n = tokens.length;									//separated each n(passengers�Eweights) to array.
			p = new ArrayList<Integer>();						//declare p call ArrayList.
			for (int i = 0; i < n; i++)							//for i=0 to n.
				p.add(Integer.valueOf(tokens[i]));				//add each n(passengers�Eweights) to ArrayList.
			Collections.sort(p);								//sorting ArrayList(p) by collections sort.

			int s = p.get(0);									//s = first element of p
			p.remove(0);										//array p remove first element
			if (s <= w) {										//first element of p <= total weigh
				output("" + putInBoat(w - s, 1, 1, w, p));		//call output method but in arguments are call putInBoad method.
			}													//end if.
		}														//end while.
		output("00000");										//call output method.
	}

	public static void output(String m) {						//output method.
		System.out.println(m);									//print m.
	}
}