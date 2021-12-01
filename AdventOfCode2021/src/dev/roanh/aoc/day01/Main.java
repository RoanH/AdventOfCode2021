package dev.roanh.aoc.day01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main{
	private static List<Integer> data = new ArrayList<Integer>();

	public static void main(String[] args){
		Scanner in = new Scanner(ClassLoader.getSystemResourceAsStream("dev/roanh/aoc/day01/input"));
		
		while(in.hasNext()){
			data.add(Integer.parseInt(in.nextLine()));
		}
		
		silverStar();
	}
	
	private static void silverStar(){
		int increment = 0;
		for(int i = 1; i < data.size(); i++){
			if(data.get(i) > data.get(i - 1)){
				increment++;
			}
		}
		System.out.println("Silver star: " + increment);
	}
}
