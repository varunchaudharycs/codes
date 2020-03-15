// CHECKERS - O's play, can only go up, needs a blank spot after removing X- get's additional chance.
// Find - Maximum number of X that can be cut in a single chance for O
// TIME - O(N)

import java.io.*;
import java.util.*;

class wf_checkersmaxpawns {

	char player1 = 'O', player2 = 'X', blank = '.';
	public static void main(String[] args)throws IOException {

		String[] inp0 = {".....", ".....", ".....", "...X.", "....O"};
 		String[] inp1 = {"..X...", "......", "....X.", ".X....", "..X.X.", "...O.."};
		String[] inp2 = {"X....", ".X...", "..O..", "...X.", "....."};
		String[] inp3 = {"..........", "..........", "..........", "..........", ".....X....", "..........", ".X...X....", "..........", "...X.X....", "....O....."};

		wf_checksmaxpawns obj = new wf_checksmaxpawns();
		System.out.println(obj.findPosAndResult(inp0));
		System.out.println(obj.findPosAndResult(inp1));
		System.out.println(obj.findPosAndResult(inp2));
		System.out.println(obj.findPosAndResult(inp3));
	}

	public int findPosAndResult(String[] board) {

		int N = board.length;
		int row = -1;
		int col = -1;
		for(int i = 0; i < N; i++) {
			int idx = board[i].indexOf(player1);
			if(idx >= 0) {
				row = i;
				col = idx;
				break;
			}
		}
		wf_checksmaxpawns obj = new wf_checksmaxpawns();
		return obj.findMaxPawns(board, row, col, 0);
	}

	public int findMaxPawns(String board[], int row, int col, int maxPawns) {

		// board corner cases
		if(row < 2) return maxPawns;
		   
		int left_helper = maxPawns, right_helper = maxPawns;
		// DIAGONAL LEFT
		if(col - 2 >= 0)
			if(board[row - 1].charAt(col - 1) == player2
			   && board[row - 2].charAt(col - 2) == blank)
					left_helper = findMaxPawns(board, row - 2, col - 2, maxPawns + 1);
			   
		// DIAGONAL RIGHT
		if(col + 2 < board.length)
			if(board[row - 1].charAt(col + 1) == player2
			   && board[row - 2].charAt(col + 2) == blank)
					left_helper = findMaxPawns(board, row - 2, col + 2, maxPawns + 1);
			   
		// max of possible moves
		return Math.max(left_helper, right_helper);
	}
}
