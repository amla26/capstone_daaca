package Bound;

import java.util.HashMap;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

 public class graph_represent 
{
   /* Makes use of Map collection to store the adjacency list for each vertex.*/
    public  Map<node, List<node>> Adjacency_List;	
    
     
   
   /*
    * Initializes the map to with size equal to number of vertices in a graph
    * Maps each vertex to a given List Object 
    */
    public graph_represent(node n1[])
    {	 
    	
        Adjacency_List = new HashMap<node, List<node>>();	
        for (int i = 0 ; i <n1.length; i++)
        { n1[i]=new node(i);
        	
            Adjacency_List.put(n1[i], new LinkedList<node>());
        }
    }
    
    int number_neighbours(int i)
    {
    	List <node> slist=Adjacency_List.get(i);
    	return slist.size();
    }
 
 
    /* Adds nodes in the Adjacency list for the corresponding vertex */
    public void setEdge(node source , node destination)
    {	
       if (source.id > Adjacency_List.size() || destination.id > Adjacency_List.size())
       {
           System.out.println("the vertex entered in not present ");
           return;
       }
       List<node> slist = Adjacency_List.get(source);
       slist.add(destination);
       List<node> dlist = Adjacency_List.get(destination);
       dlist.add(source);
   }
 
   /* Returns the List containing the vertex joining the source vertex */		
    public List<node> getEdge(node source)
    {
        if (source.id > Adjacency_List.size())
        {
            System.out.println("the vertex entered is not present");
            return null;
        }
        return Adjacency_List.get(source);
    }
    
   public Boolean isPresent(node n,node v)
    {	
    	
    	List <node> plist=Adjacency_List.get(n);
    	for(int i=0;i<plist.size();i++)
    	{if(plist.get(i).equals(v))
    	return true;}
    	return false; 	 
    	 
    
    	 
    }
}	
    



