//very good que thsi is directed graph so comparing with parent and checking vis[] is not enough
//here ex [1,0][2,0][1,2] now for 1 we should complete 0 first ohk for 2 also then for 1 2 should complete so 0 ->2->1 not a cycle 
//vis[f,t,f] as 0 [t,t,f] then for 1 2 required [t,t,t] i is already visited but graph is like 0->1
  // |
  // 2->1 

// so approach is to check pathvis for each path follwed by dfs like after one branch is complete before moving back to another branch we make false to last elemnt of current brancch 
// if vis[1] == true pathVis[1] == true then cycle found 
// if vis[1] == true but pathvis[]== false means that elemnt seen in another branch
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        boolean []vis= new boolean[numCourses];
         boolean []pathVis= new boolean[numCourses];

         // craete adj list of size numCourses 
        ArrayList<ArrayList<Integer>> adj =new ArrayList<>();
           for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        // add nextCourses list 
          for (int i = 0; i < prerequisites.length; i++) {
        int nextCourses = prerequisites[i][0];
        int par = prerequisites[i][1];

        adj.get(par).add(nextCourses);
        }

        for (int i = 0; i < numCourses; i++) {
            if (vis[i]==false) {
                if (dfs(i, pathVis, adj, vis)) return false;
            }
        }
        return true;
    }
    public boolean dfs(int nextCourses,boolean[] pathVis,ArrayList<ArrayList<Integer>> adj,boolean[]vis){
        //marked visited 
        pathVis[nextCourses]=true;
         vis[nextCourses]=true;

        List <Integer> neighbours=adj.get(nextCourses);
        for(int i=0;i<neighbours.size();i++){
            int neighbour=neighbours.get(i);

            if(vis[neighbour]==false){
              if(dfs(neighbour,pathVis,adj,vis)) return true;     
             }
            else if(pathVis[neighbour]){
            return true;
             }
            
        }
        //backtrack
        pathVis[nextCourses]=false;
    
    return false;   
    }
}