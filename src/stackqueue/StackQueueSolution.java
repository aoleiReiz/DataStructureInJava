package stackqueue;

public class StackQueueSolution {

    private boolean isValid(int i, int j, int r, int c, int [][]rooms){
       return i >=0 && i < r && j >= 0 && j < c && rooms[i][j]!= -1;
    }
    public int BFS(int [][]rooms, int i, int j, int count){
        if (rooms [i][j] == 0){
            return count;
        }else if (rooms [i][j] != 2147483647){
            return count + rooms[i][j];
        }
        int [][]directions = {{1,0},{-1,0},{0,1},{0,-1}};
        for (int k = 0; k < 4; k++) {
            int x = i + directions[k][0];
            int y = j + directions[k][1];
            if (isValid(x,y, rooms.length, rooms[0].length,rooms)){
                int c = BFS(rooms,x,y,count + 1);
                if (c < rooms[i][j]){
                    rooms[i][j] = c;
                }
            }
        }
        return rooms[i][j];
    }
    public void wallsAndGates(int[][] rooms) {
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[i].length; j++) {
                if (rooms[i][j] == 2147483647){
                    BFS(rooms, i, j, 0);
                }
            }
        }
    }
}
