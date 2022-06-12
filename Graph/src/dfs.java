import java.util.ArrayList;
import java.util.Stack;
public class dfs {
	 static ArrayList<Integer> dfsOfGraph (int V, ArrayList < ArrayList < Integer >> adj)
	 {
		 ArrayList <Integer> ans = new ArrayList ();
		 Stack <Integer> stack = new Stack ();
		 boolean [] visited = new boolean [V+1];

		 for (int i=1; i<=V; i++)
		 {
			 if (visited[i] == false)
			 {
				 visited [i] = true;
				 stack.add(i);
			 }
			 while (!stack.isEmpty())
			 {
				 Integer Node = stack.pop();
				 ans.add(Node);
				 for (Integer edge : adj.get(Node))
				 {
					 if (visited[edge] == false)
					 {
						 visited [edge] = true;
						 stack.add(edge);
					 }
				 }
			 }
		 }
		 return ans;
	 }
	public static void main(String[] args) {
		int nodeSize = 7;
        ArrayList < ArrayList < Integer >> adj = new ArrayList < > ();
        for (int i = 0; i <=nodeSize; i++) {
            adj.add(new ArrayList <> ());
        }
        adj.get(1).add(2);
        adj.get(2).add(1);
        
        adj.get(2).add(4);
        adj.get(4).add(2);
        
        adj.get(2).add(7);
        adj.get(7).add(2);
        
        adj.get(3).add(5);
        adj.get(5).add(3);
        
        adj.get(4).add(6);
        adj.get(6).add(4);
       
        adj.get(4).add(7);
        adj.get(7).add(4);
        
        adj.get(5).add(3);
        adj.get(3).add(5);
        
        adj.get(7).add(6);
        adj.get(6).add(7);
        ArrayList <Integer> list = dfsOfGraph (nodeSize, adj);
        System.out.println(list);
	}
}