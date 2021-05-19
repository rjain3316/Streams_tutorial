import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.testng.Assert;
import org.testng.annotations.Test;



public class Test1 {

	// Count the number of names starting with alphabet A in list
	//@Test
	public void regular() {
	ArrayList<String> names=new ArrayList<String>();
	names.add("Abhi");
	names.add("Roo");
	names.add("So");
	names.add("Adam");
	names.add("Harshu");
	int n=0;
	for(int i=0;i<names.size();i++)
	{
		String name=names.get(i);
		if(name.startsWith("A"))
		{
			System.out.println(name);
			n++;
		}
	}
	System.out.println("Total number of names start with A are = "+n);
	
	}
	
	//@Test
	public void StreamFilter()
	{
		List<String> names=Arrays.asList("Abhi","Roo","So","Adam","Harshu");
		long n=names.stream().filter(s->s.startsWith("A")).count();           //count of names starts with A
		System.out.println(n);
		
		//print names starts with A
		names.stream().filter(s->s.startsWith("A")).forEach(s->System.out.println("Names which starts with A  = "+s));
		
		//print names in sorted order
		names.stream().sorted().forEach(s->System.out.println(s));
		
		// we can create stream with stream package
		
		long d=Stream.of("Abhijeet","Don","Alekhya","Adam","Ram").filter(s->
		{
			s.startsWith("A");     //if action part is in multiple lines so you can define in curly braces
			return false;          // so here terminal operation count won't work
		}).count();
		System.out.println("value of d is = "+d);
		
		//print all the names of the arraylist where name length>4
		names.stream().filter(s->s.length()>4).forEach(s->System.out.println("The name which length is greater then 4  is= "+s));
	}
	
	
	@Test
	public void streamMap()
	{
		//print names in upper case which have last letter 'a'
		Stream.of("Abhijeet","Don","Alekhya","Adam","Rama").filter(s->s.endsWith("a")).map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		
		//print names in uppercase and sorted which have first letter 'A'
		List<String> names=Arrays.asList("Abhi","Roo","So","Adam","Harshu","Aasu");
		names.stream().filter(s->s.startsWith("A")).sorted().map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		
		//Merging two different list
		ArrayList<String> names1=new ArrayList<String>();
		names1.add("Akash");
		names1.add("Meenak");
		names1.add("Aka");
		names1.add("Bhanu");
		names1.add("Bhuvan");
		
		Stream<String> newStream=Stream.concat(names.stream(), names1.stream());
		//print all names from the merged list in sorted order
		newStream.sorted().forEach(s->System.out.println(s));
		
		//check the 'Adam' present in the list and give ans in the form of true and false
		boolean flag=newStream.anyMatch(s->s.equalsIgnoreCase("Adam"));
		System.out.println(flag);
		//Assert.assertTrue(flag);
	}
	
}
