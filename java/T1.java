import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;
public class T1 {
	public static void main(String[] args) {
		//checkPrime(12, 13, 9, 15);
//		minNum(4, Arrays.asList(1, 2, 3, 5, 8));
//		minNum(2, Arrays.asList(1, 2, 3));
//		minNum(650,Arrays.asList(10,82,112,134,178,206,229,238,278,293,335));
//		minNum(402,Arrays.asList(25,162,206,224,264,288,334,364,367,389,405,454,478,479,482,509,517,545,578,626,657,692,705,720,734,747));
		
//		System.out.println(carParkingRoof(Arrays.asList(2L,10L,8L,17L), 3));
//		System.out.println(carParkingRoof(Arrays.asList(6L,2L,12L,7L), 3));
		
		//System.out.println("9 "+requestsServed(new LinkedList<Integer>(Arrays.asList(1,2,2,3,4,5,6,6,13,16)),Arrays.asList(10,15)));
		//System.out.println("5 "+requestsServed(new LinkedList<Integer>(Arrays.asList(2,2,4,8,11,28,30)),Arrays.asList(0,5,5,15)));
		//System.out.println("17 "+requestsServed(new LinkedList<Integer>(Arrays.asList(0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1)),Arrays.asList(6,6,6,6)));
		
//		System.out.println("CTGAC".equals(dnaComplement("GTCAG")));
//		System.out.println("AAAACCCGGT".equals(dnaComplement("ACCGGGTTTT")));
//		System.out.println("GCAT".equals(dnaComplement("ATGC")));
//		System.out.println("TACGAT".equals(dnaComplement("ATCGTA")));
		
		System.out.println(getMostVisited(10, Arrays.asList(1, 5, 10, 3)) == 5);
		System.out.println(getMostVisited(5, Arrays.asList(1, 5)) == 1);
		System.out.println(getMostVisited(9, Arrays.asList(9,7,3,1)) == 3);
	}
	
	
	public static String dnaComplement(String s) {
		StringBuilder sb=new StringBuilder(s);  
		sb.reverse();  
		String result = sb.toString();  
		result = result.replace("A", "X");
		result = result.replace("T", "A");
		result = result.replace("X", "T");
		
		result = result.replace("C", "X");
		result = result.replace("G", "C");
		result = result.replace("X", "G");
		return result;
	    }
	
	public static int getMostVisited(int n, List<Integer> sprints) {
		TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
		for (int w = 1; w <= n; w++) {
			map.put(w, 0);
		}
		for (int i = 0; i <= sprints.size() - 2; i++) {
			int x = sprints.get(i);
			int y = sprints.get(i + 1);
			if (y > x) {
				for (int s = x; s <= y; s++) {
					map.put(s, map.get(s) + 1);

				}
			} else {
				for (int s = y; s <= x; s++) {
					map.put(s, map.get(s) + 1);
				}
			}
		}
		//Iterator<Integer> kset = map.descendingMap().descendingKeySet().iterator();
		Iterator<Integer> kset = map.keySet().iterator();
		int maxVal = 0;
		int maxKey = 0;
		while (kset.hasNext()) {
			Integer k = kset.next();
			Integer val = map.get(k);
			if (val > maxVal) {
				maxKey = k;
				maxVal = val;
			}
		}

		return maxKey;
	}

	 public static int requestsServed(List<Integer> timestamp, List<Integer> top) {
		 int retCount=0;
		 boolean moreTS = false;
		 Collections.sort(top);
		 Collections.sort(timestamp);
		 Collections.reverse(timestamp);
		 for(int p=0;p<top.size();p++) {
			 //int t = timestamp.size()-1; //start from behind
			 print(timestamp);
			 int t = 0; //start from front
			 while(timestamp.get(t)>top.get(p)) {
				 //t--;
				 System.out.println("  "+timestamp.get(t)+"  "+top.get(p));
				 t++;
			 }
			if (t < timestamp.size()) {
			if (timestamp.size() - t > 5) {  //more than 5 elements left out
				 for(int c=0;c<5;c++) {  // from t-5 to 5 elemets remove element at location t
					 ///remove items timestamp.remoe(t);
					 System.out.println("Removed(>5):"+timestamp.remove(t).toString());
					 retCount++;
					 System.out.println("RetCount(>5):"+retCount);
				 }
			 } else {
				 for(;t<timestamp.size();) {  // from t till size elements
					///remove items timestamp.remoe(t);
					 System.out.println("Removed(5):"+timestamp.remove(t).toString());
					 retCount++;
					 System.out.println("RetCount(5):"+retCount);
				 }
				 //moreTS = false;
			 }
//			if(!moreTS) {
//				break;
//			}
			System.out.println("Step RetCount:"+retCount);
		 }
		 }
		return retCount;
	 }
	private static void print(List<Integer> timestamp) {
		System.out.print("timestamp: ");
		timestamp.stream().forEach(t->System.out.print(t+","));
		System.out.println();
	}

	public static int minNum(int threshold, List<Integer> points) {
		boolean skip = true;
		int min = points.get(0);
		int max = points.get(0);
		int atleast = 0;
		for(int i=0;i<points.size();i++) {
			max = points.get(i);
			System.out.println("Threshold:" + (max - min)+ " Value:"+max+" Atleast:"+atleast+" Loc:"+i); 
			if (max - min >= threshold) {
				atleast++;
				break;
				
			} else {
				atleast++;
			} 
			if (i + 1 < points.size() && i + 2 < points.size() && points.get(i+1) < points.get(i + 2)) {
				i++; // next has more points
			}
			
//			if(skip) {
//				i++;
//				skip=false;
//			} else {
//			}
			
		}
		System.out.println(atleast);
		return atleast;

	}
	
	public static long carParkingRoof(List<Long> cars, int k) {    // Write your code here
	    Collections.sort(cars);
	    long i=cars.get(0);  // from first car
	    long j=cars.get(cars.size()-1); //from last car
	    long coveredCarsF=0;
	    long coveredCarsB=0;
	    long lengthF=0;
	    long lengthB=0;
	    while(coveredCarsF <= k && coveredCarsB <= k) {
	        if(cars.contains(i)) {
	            coveredCarsF++;
	        }
	        if(cars.contains(j)) {
	            coveredCarsB++;
	        }
	        lengthF++;
	        lengthB++;
	        i++;
	        j--;
	        if(coveredCarsF==k || coveredCarsB == k) {
	        	return lengthF < lengthB ? lengthF : lengthF;
	        }
	    }
	    return 0;
	    }
	public static void checkPrime(Integer... i) {
		for (int a = 0; a < i.length; a++) {
			boolean flag = true;
			for (int p = 2; p < i[a]; p++) {
				if (i[a] % p == 0) {
					flag = false;
				}
			}
			if (flag) {
				System.out.print(i[a]);
			}
		}
		
	}
}
