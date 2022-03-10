package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) throws ParseException{
		
		Scanner sc = new Scanner(System.in);
		Map<String,Integer> candidates = new HashMap<>();
		System.out.print("Enter file full path: ");
		String path = sc.next();
		
		
		try(BufferedReader br = new BufferedReader(new FileReader(path))){
			
			String line = br.readLine();
			while(line != null) {
				String[] candidate = line.split(",");
				String nameCandidate = candidate[0];
				Integer votes = Integer.parseInt(candidate[1]);
				if(candidates.containsKey(nameCandidate)) {
					int oldVotes = candidates.get(nameCandidate);
					candidates.put(nameCandidate, votes + oldVotes);
				}
				else {
					candidates.put(nameCandidate, votes);
				}
				
				
				line = br.readLine();
			}
			
			for(String key : candidates.keySet()) {
				System.out.println(key + ": " + candidates.get(key));
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		sc.close();
	}

}
