package dev.roanh.aoc.day02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

public class Main{
	private static List<String> lines;
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(ClassLoader.getSystemResourceAsStream("dev/roanh/aoc/day02/input")));
		lines = in.lines().collect(Collectors.toList());
		in.close();
		
		silverStar();
		goldStar();
	}

	private static void silverStar(){
		int dist = 0;
		int depth = 0;
		
		for(String line : lines){
			String[] args = line.split(" ");
			switch(args[0]){
			case "forward":
				dist += Integer.parseInt(args[1]);
				break;
			case "down":
				depth += Integer.parseInt(args[1]);
				break;
			case "up":
				depth -= Integer.parseInt(args[1]);
				break;
			default:
				throw new RuntimeException("What?");
			}
		}
		
		System.out.println("Silver star: " + (dist * depth));
	}
	
	private static void goldStar(){
		int dist = 0;
		int aim = 0;
		int depth = 0;
		
		for(String line : lines){
			String[] args = line.split(" ");
			switch(args[0]){
			case "forward":
				int value = Integer.parseInt(args[1]);
				dist += value;
				depth += value * aim;
				break;
			case "down":
				aim += Integer.parseInt(args[1]);
				break;
			case "up":
				aim -= Integer.parseInt(args[1]);
				break;
			default:
				throw new RuntimeException("What?");
			}
		}
		
		System.out.println("Gold star: " + (dist * depth));
	}
}
