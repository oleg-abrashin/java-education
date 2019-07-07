package model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Random;
import java.util.TreeMap;
import java.util.TreeSet;

import dto.Person;

public class Finance {
	
	HashSet<Person> community = new HashSet<>();
	HashMap<Person, HashSet<Person>> creditors = new HashMap<>();

	private static Random gen = new Random();
	public void fill(int n) {
		ArrayList<Person> fullList = new ArrayList<>();
		for (int i=65; i< 91; i++) {		
			for(int j=0; j<26; j++) {	
				fullList.add(new Person(Character.toString((char)i)));
			}
		}
	
		Person creditor = null;
		for(Person p : fullList) {			
			do {
				creditor = fullList.get(gen.nextInt(fullList.size()));
			}while(creditor == p);
			p.setCreditor(creditor);
		}
		
		while(community.size() < n) {
			community.add(fullList.get(gen.nextInt(fullList.size())));
		}
	}
	
	public void findSuperCreditor() {
		HashSet<Person> debtorsSet = null;
		Person key = null;
		for (Person p: community) {
			key = p.getCreditor();
			debtorsSet = creditors.get(key); 
			if (debtorsSet == null)debtorsSet = new HashSet<Person>();
			debtorsSet.add(p);
			creditors.put(key, debtorsSet);
		}
		
		Comparator<Entry<Person, HashSet<Person>>> sizeComparator = 
				((e1, e2) -> e1.getValue().size() - e2.getValue().size());
		Comparator<Entry<Person, HashSet<Person>>> nameComparator = 
				(e1,e2)->e1.getKey().getName().compareTo(e2.getKey().getName());
		Comparator<Entry<Person, HashSet<Person>>> creditorNameComparator = 
				(e1,e2)->e1.getKey().getCreditor().getName().compareTo(e2.getKey().getCreditor().getName());
		Comparator<Entry<Person, HashSet<Person>>> comparator =
					sizeComparator
					.thenComparing(nameComparator)
					.thenComparing(creditorNameComparator);
									
		TreeSet<Entry<Person,HashSet<Person>>> result = new TreeSet<>(comparator);
		result.addAll(creditors.entrySet());
		System.out.println(creditors.size());
		
		System.out.println(result.last().getKey() +"; "+ result.last().getValue().size()+" debtors");
	}

}
