package dev.roanh.aoc.day04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main{
	private static List<Integer> nums;
	private static List<Board> boards = new ArrayList<Board>();

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(ClassLoader.getSystemResourceAsStream("dev/roanh/aoc/day04/input")));
		
		nums = Arrays.stream(in.readLine().split(",")).map(Integer::parseInt).collect(Collectors.toList());
		
		Board board = null;
		String line;
		while((line = in.readLine()) != null){
			if(line.isEmpty()){
				board = new Board();
			}
			
			for(int i = 0; i < 5; i++){
				board.data[i] = Arrays.stream(in.readLine().split(" +")).filter(s->!s.isEmpty()).mapToInt(Integer::parseInt).toArray();
			}
			
			boards.add(board);
		}
		
		in.close();
		
		silverStar();
		goldStar();
	}

	private static void silverStar(){
		for(int num : nums){
			boards.forEach(board->board.mark(num));
			
			Optional<Board> complete = boards.stream().filter(Board::isComplete).findAny();
			if(complete.isPresent()){
				System.out.println("Silver star: " + (num * complete.get().unmarkedSum()));
				break;
			}
		}
	}

	private static void goldStar(){
		// TODO Auto-generated method stub
		
	}
	
	private static class Board{
		private int[][] data = new int[5][];
		private boolean[][] called = new boolean[5][5];
		
		private void mark(int num){
			for(int i = 0; i < data.length; i++){
				for(int j = 0; j < data[i].length; j++){
					if(data[i][j] == num){
						called[i][j] = true;
					}
				}
			}
		}
		
		private boolean isComplete(){
			for(int i = 0; i < called.length; i++){
				boolean row = true;
				boolean col = true;
				for(int j = 0; j < called.length; j++){
					row &= called[i][j];
					col &= called[j][i];
				}
				
				if(row || col){
					return true;
				}
			}
			return false;
		}
		
		private int unmarkedSum(){
			int sum = 0;
			for(int i = 0; i < data.length; i++){
				for(int j = 0; j < data[i].length; j++){
					if(!called[i][j]){
						sum += data[i][j];
					}
				}
			}
			return sum;
		}
	}
}
