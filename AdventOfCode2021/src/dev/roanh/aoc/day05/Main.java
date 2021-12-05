package dev.roanh.aoc.day05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main{
	private static List<Line> lines;
	private static int[][] grid = new int[1000][1000];

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(ClassLoader.getSystemResourceAsStream("dev/roanh/aoc/day05/input")));
		lines = in.lines().map(Line::new).collect(Collectors.toList());
		in.close();
		
		silverStar();
		goldStar();
	}
	
	private static void silverStar(){
		for(Line line : lines){
			if(line.x1 == line.x2){
				for(int i = Math.min(line.y1, line.y2); i <= Math.max(line.y1, line.y2); i++){
					grid[line.x1][i]++;
				}
			}else if(line.y1 == line.y2){
				for(int i = Math.min(line.x1, line.x2); i <= Math.max(line.x1, line.x2); i++){
					grid[i][line.y1]++;
				}
			}
		}
		
		int total = 0;
		for(int i = 0; i < grid.length; i++){
			for(int j = 0; j < grid.length; j++){
				if(grid[i][j] > 1){
					total++;
				}
			}
		}
		
		System.out.println("Silver star: " + total);
	}

	private static void goldStar(){
		// TODO Auto-generated method stub
		
	}

	private static class Line{
		private int x1;
		private int y1;
		private int x2;
		private int y2;
		
		private Line(String data){
			String[] parts = data.split("[ ,]");
			x1 = Integer.parseInt(parts[0]);
			y1 = Integer.parseInt(parts[1]);
			x2 = Integer.parseInt(parts[3]);
			y2 = Integer.parseInt(parts[4]);
		}
	}
}
