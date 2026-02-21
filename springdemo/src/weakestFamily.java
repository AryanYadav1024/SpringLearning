import java.util.*;
public class weakestFamily {
    public static void main(String[] args) {
        /*
          5 3
          1 2
          2 3
          4 5
        */
        Scanner sc = new Scanner(System.in);
        int ns = sc.nextInt();
        int np = sc.nextInt();
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i<ns;i++){
            adjList.add(new ArrayList<>());
        }
        for(int i = 0;i<np;i++){
            int u = sc.nextInt() - 1;
            int v = sc.nextInt() - 1;
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
        boolean[] visited = new boolean[ns];
        System.out.println(weakestFamilyMembers(adjList,visited));
    }
    static int weakestFamilyMembers(ArrayList<ArrayList<Integer>> adjList,boolean[] visited){
        Queue<Integer> q = new LinkedList<>();
        int min = Integer.MAX_VALUE;
        for(int i = 0;i<visited.length;i++){
            int count = 1;
            if(!visited[i]){
                visited[i] = true;
                q.offer(i);
                while(!q.isEmpty()){
                    int curr = q.poll();
                    for(int v:adjList.get(curr)){
                        if(!visited[v]){
                            visited[v] = true;
                            q.offer(v);
                            count++;
                        }
                    }
                }
                min = Math.min(min,count);
            }

        }
        return min;
    }
}
