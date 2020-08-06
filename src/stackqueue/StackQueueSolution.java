package stackqueue;

import java.util.*;

public class StackQueueSolution {

    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    private static final int EMPTY = Integer.MAX_VALUE;
    private static final int GATE = 0;
    private static final List<int[]> DIRECTIONS = Arrays.asList(
            new int[] { 1,  0},
            new int[] {-1,  0},
            new int[] { 0,  1},
            new int[] { 0, -1}
    );

    public void wallsAndGates(int[][] rooms) {
        int m = rooms.length;
        if (m == 0) return;
        int n = rooms[0].length;
        Queue<int[]> q = new LinkedList<>();
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (rooms[row][col] == GATE) {
                    q.add(new int[] { row, col });
                }
            }
        }
        while (!q.isEmpty()) {
            int[] point = q.poll();
            int row = point[0];
            int col = point[1];
            for (int[] direction : DIRECTIONS) {
                int r = row + direction[0];
                int c = col + direction[1];
                if (r < 0 || c < 0 || r >= m || c >= n || rooms[r][c] != EMPTY) {
                    continue;
                }
                rooms[r][c] = rooms[row][col] + 1;
                q.add(new int[] { r, c });
            }
        }
    }

    public Node helper(Node node, Map<Node,Node> visited) {
        if (null == node)
            return node;
        if (visited.containsKey(node))
            return visited.get(node);
        Node ret = new Node();
        ret.val = node.val;
        ret.neighbors = new ArrayList<>();
        visited.put(node,ret);
        for (Node n : node.neighbors){
            ret.neighbors.add(helper(n,visited));
        }
        return ret;
    }

    public Node cloneGraph(Node node) {
        Map<Node,Node>map = new HashMap<>();
        return helper(node,map);
    }

    public int[][] updateMatrix(int[][] matrix) {
        //从 0 开始出发
        Queue<int []> queue = new ArrayDeque<>();
        int m = matrix.length;
        int n = matrix[0].length;
        boolean [][]visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0){
                    queue.add(new int[]{i,j});
                }
            }
        }
        while (!queue.isEmpty()){
            int []point = queue.poll();
            int row = point[0];
            int col = point[1];

            for (int[] direction : DIRECTIONS) {
                int r = row + direction[0];
                int c = col + direction[1];
                if (r < 0 || c < 0 || r >= m || c >= n||matrix[r][c]== 0 || visited[r][c]) {
                    continue;
                }
                matrix[r][c] = matrix[row][col] + 1;
                visited[r][c] = true;
                queue.add(new int[] { r, c });
            }
        }

        return matrix;
    }

    public List<String> buildArray(int[] target, int n) {
        List<String>list = new ArrayList<>();
        int index = 0;
        for (int i = 1; i <= n ; i++) {
            if (index == target.length){
                break;
            }
            if (i == target[index]){
                index++;
                list.add("Push");
            }else{
                list.add("Push");
                list.add("Pop");
            }
        }
        return list;
    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int N = rooms.size();
        boolean []visited = new boolean[N];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for (int j = 0; j< N; j++){
            List<Integer> list = rooms.get(j);
            if (list.isEmpty()){
                visited[j] = true;
            }
        }

        while (!stack.empty()){
            int i = stack.pop();
            visited[i] = true;
            for (int j : rooms.get(i)){
                if (! visited[j]) {
                    stack.push(j);
                }
            }
        }
        for (int k = 0; k < N; k ++){
            if (!visited[k]){
                return false;
            }
        }
        return true;
    }
}
