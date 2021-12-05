package dev.roanh.aoc.day03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

public class Main{
	private static List<Integer> lines;
	private static int length;
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(ClassLoader.getSystemResourceAsStream("dev/roanh/aoc/day03/input")));
		lines = in.lines().peek(i->length = i.length()).map(i->Integer.parseInt(i, 2)).collect(Collectors.toList());
		in.close();
		
		System.out.println(lines.size());
		
		silverStar();
		goldStar();
	}

	private static void silverStar(){
		int gamma = 0;
		
		for(int i = 0; i < length; i++){
			int one = 0;
			for(int num : lines){
				if((num & (1 << i)) > 0){
					one++;
				}
			}
			if(one > Math.floorDiv(lines.size(), 2)){
				gamma |= (1 << i);
			}else if(one == lines.size() / 2){
				System.err.println("neither is most common");
			}
		}
		
		System.out.println("Silver star: " + (gamma * (~gamma & 0b111111111111)));
	}

	private static void goldStar(){
		// TODO Auto-generated method stub
		
	}
}
