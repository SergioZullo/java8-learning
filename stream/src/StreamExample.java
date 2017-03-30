import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class StreamExample {

	public List<String> initStrings(){
		List<String> list = new ArrayList<>();
		list.add("test1");
		list.add("test2");
		list.add("test3");
		list.add("test4");
		list.add("test5");
		list.add("test6");
		list.add("test7");
		list.add("test8");
		list.add("test9");
		list.add("test10");
		
		return list;
	}
	
	public List<Integer> initInt(){
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		list.add(7);
		list.add(8);
		list.add(9);
		list.add(10);
		list.add(11);
		list.add(12);
		
		return list;
	}
	
	public List<User> initUsers(){
		List<User> list = new ArrayList<>();
		list.add(new User("Sergio", "Zullo", 34));
		list.add(new User("Simon", "Bolivar", 55));
		list.add(new User("Pippo", "Baudo", 77));
		list.add(new User("Simon", "Bolivar", 55));
		list.add(new User("Pippi", "Calzelunge", 5));
		list.add(new User("Lion", "Bold", 15));
		list.add(new User("Sparkling", "Water", 1));
		list.add(new User("", "", 0));
		list.add(new User("Simon", "Bolivar", 55));
		list.add(new User("Lioness", "Bold", 34));
		list.add(new User("He", "Won", 99));
		
		return list;
	}
	
	
	public static void main(String[] args) {
		StreamExample example = new StreamExample();
		List<Integer> initInt = example.initInt();
		List<String> initStrings = example.initStrings();
		List<User> initUsers = example.initUsers();
		
		//print ints
		initInt.stream().forEach(System.out::print);
		System.out.println("-----------------------");
		//filter int between 5 and 10
		initInt.stream().filter((i) ->  i > 5 && i < 10).forEach(System.out::print);
		System.out.println("-----------------------");
		//max 
		System.out.println(initInt.stream().max((a, b) -> a.compareTo(b)).get());
		//sum all 
		System.out.println(initInt.stream().mapToInt((i) -> i).sum());
		System.out.println("-----------------------");
		
		
		
		
		
		//filter people with age > 18
		initUsers.stream().filter( u -> u != null && u.getAge() > 18).forEach(System.out::println);
		System.out.println("-----------------------");
		//grouping by age and print as Set
		initUsers.stream().collect(Collectors.groupingBy(u -> u.getAge(), Collectors.toSet())).values().forEach(System.out::println);;
		System.out.println("-----------------------");
		//get the oldest
		System.out.println(initUsers.stream().collect(Collectors.maxBy(Comparator.comparingInt(u -> u.getAge()))).get());
		
		
		
	}
	
}
