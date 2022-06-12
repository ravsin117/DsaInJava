import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
public class graph{
    public static ArrayList<Integer> bfsAlgo(int v, ArrayList<ArrayList<Integer>>adj){
        ArrayList<Integer> bfs = new ArrayList<>();
        boolean visited[] = new boolean[v+1];
        LinkedList<Integer>que = new LinkedList<>();
        for(int i = 0 ; i<=v ;i++){
            if(!visited[i]){
                que.addLast(i);
                visited[i]=true;
                while(!que.isEmpty()){   // unill  queu is not empty this loop runs
                    Integer it = que.removeFirst();
                    bfs.add(it);
                    for(Integer child :adj.get(it)){
                        if(visited[child]==false){
                            visited[child]=true;
                            que.addLast(child);
                        }
                    }
                }
            }
        }
        return bfs;

    }
    public static ArrayList<Integer>bfsalgo1(int v , ArrayList<ArrayList<Integer>>adj){
        ArrayList<Integer>bfs = new ArrayList<>();
        boolean visited[] = new boolean[v+1];
        LinkedList<Integer>que = new LinkedList<>();
        for(int i = 1 ; i <=v ;i++){
            if(visited[i]==false){
                que.addLast(i);
                visited[i] = true;
                while(!que.isEmpty()){
                    Integer node = que.poll();
                    bfs.add(node);
                    for(Integer it : adj.get(node)){
                        if(visited[it]==false){
                            visited[it]= true;
                            que.addLast(it);
                        }
                    }
                }
            }
        }
        return bfs;
    }
    
    public static Arraylist<Intger> dfsAlgo(int i,boolean vis[], ArrayList<ArrayList<Integer>> adj,ArrayList<Integer>storedfs){
        storeDfs.add(i);
        vis[i]=true;
        for(Integer it:adj.get(i)){
            if(vis[it]==false){
                // vis[it]=true;
                dfsAlgo(it, vis, adj, storedfs);
            }
        }
         
    }
    public static ArrayList<Integer> dfgGraph(int v, ArrayList<ArrayList<Integer>>adj){
        ArrayList<Integer>storeDfs= new Arraylist<>();
        bolean vis[] = new boolean[n+1];
        for(int i = 1; i <=v ;i++){
            if(vis[i]==0){
                dfsAlgo(i, vis, adj, storeDfs);
            }
        }
        return storeDfs;
    }

    // cycle detection using bfs
    public class Node {
        int first ;
        int parent;
        Node(int first, int second){
            this.first = first;
            this.second = second;
        }
    }
    public static boolean checkforCycleBfs(ArrayList<ArrayList<Integer>>adj, int s, boolean vis[]){
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(s,-1));
        vis[s]=true;
        while(!q.isEmpty()){
            int node = q.peek().first;
            int par = q.peek().second;
            q.remove();
            for(Intger it:adj.get(node)){
                if(vis[it]==false){
                    vis[it]=true;
                    q.add(new Node(it,node));  // noe its being visited therefor it is child and node is parent 
                }else{
                    if(it!=par) return true; // if it is visited already but its not par of node
                }
            } 
        }
    }
    public static boolean isCycle(int v , ArryList<ArrayList<Integer>>adj){
        boolean vis[] = new boolean [v+1];
        Arrays.fill(vis,false);

        for(int i = 1; i <=v ;i++){
            if(vis[i]==false){
                if(checkforCycleBfs(adj,i, vis))
                return true;
            }
        }
        return false;
    }

    //cycle detection using dfs
    public static boolean isCycleDFs(int v , ArrayList<ArrayList<Integer>>adj){

        boolean vis [] = new boolean[v+1];
        Arrays.fill(vis,false);
        for(int i = 1; i <=v ;i++){
            if(vis[i]==false){
                if(checkForCycleDfs(i ,-1, adj,vis))
                return true;
            }
        }
        return false;
    }
    public static boolean checkForCycleDfs(int i , int parent , ArrayList<ArrayList<Integer>> adj, boolean []vis){
        vis[i]= true;
        for(Integer it:adj.get(i)){
            if(vis[it]==false){
                if(checkForCycleDfs(it,i , adj , vis)) return true;
            }else{
                if(it!=parent) return true;
            }
        }
        return false;
    }

    //bipartitie graph-bfs
    public static boolean bfsCheckforBpt(ArrayList<ArrayList<Integer>>adj , int node , int [] color){
        Queue<Integer>q = new LinkedList<>();
        q.add(node);
        color[node]=1;
        while(!q.isEmpty()){
            Integer parent = q.poll();
            for(Integer child :adj.get(parent)){
                if(color[child]==-1){
                    color[child] = 1-color[parent];
                    q.add(child);
                }else{
                    if(color[child]== color[parent]){
                        return false;
                    }                    
                }
            }
        }
        return true;

    }
    //bipartitie graph-dfs
    public static boolean dfsCheckforBpt(ArrayList<ArrayList<Integer>>adj , int node , int [] color){
        if(color[node]==-1){
            color[node]=1;
        }
        for(Integer child:adj.get(node)){
            if(color[child]==-1){
                color[child] = 1-color[node];
                if(!dfsCheckforBpt(adj,child,color)) return false;
            }else{
                if(color[child]==color[node])
                return false;
            }
        }
        return true;
    }

    //cycle checking with modidfied dfs-> self dfs

    public static boolean checkcycle(ArrayList<ArrayList<Integer>> adj , int node , int [] vis , int dfs[]){
        vis[node] = 1;
        dfs[node] = 1;
        for(Integer it :adj.get(node)){
            if(vis[it]==0){
                if(checkcycle(adj,it,vis,dfs)==true){
                    return true;
                }
            }else{
                if(dfs[node]==1){
                    return true;
                }
            }
        }
        dfs[node] = 0;
        return false;
    }

    

}