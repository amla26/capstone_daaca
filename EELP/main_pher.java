package Bound;



import java.util.Scanner;

import java.util.List;


// import capstoneAnt.node;

 public class main_pher
 {	 
	 public static void main( String args[])
	 {int source , destination,number_vertices,number_edges;
	 
	 //Scanner inp1;
		//inp1 = new Scanner(System.in);
		/* Read number of vertices and edges */
	//System.out.println("Enter the number of vertices of graph");
	//String var = inp1.nextLine();
		number_vertices=31;//Integer.valueOf(var);
		//System.out.println("Enter the number of edges of graph");
		//String var1 = inp1.nextLine();
			//number_edges=Integer.valueOf(var1);	
     
     
    
     /* Initialise the nodes */
	 node[] n=new node[number_vertices];
	 for(int i=0;i<number_vertices;i++)
	 {
		 n[i]=new node(i);
	 }
     
            graph_represent new_graph = new graph_represent(n);

         /* Hardcoded value of edges */
        
             new_graph.setEdge(n[0], n[1]);
             new_graph.setEdge(n[0], n[9]);
             new_graph.setEdge(n[0], n[4]);
             new_graph.setEdge(n[0], n[24]);
             new_graph.setEdge(n[1], n[2]);
             new_graph.setEdge(n[1], n[3]);
             new_graph.setEdge(n[2], n[7]);
             new_graph.setEdge(n[2], n[8]);
             new_graph.setEdge(n[3], n[5]);
             new_graph.setEdge(n[3], n[6]);
             
             new_graph.setEdge(n[4], n[5]);
             new_graph.setEdge(n[4], n[19]);
             new_graph.setEdge(n[4], n[22]);
             new_graph.setEdge(n[4], n[23]);
             new_graph.setEdge(n[4], n[24]);
             new_graph.setEdge(n[5], n[13]);
             new_graph.setEdge(n[6], n[7]);
             new_graph.setEdge(n[6], n[12]);
             new_graph.setEdge(n[7], n[11]);
             new_graph.setEdge(n[8], n[9]);
             new_graph.setEdge(n[8], n[10]);
           
             new_graph.setEdge(n[9], n[18]);
             new_graph.setEdge(n[10], n[11]);
             new_graph.setEdge(n[10], n[17]);
             new_graph.setEdge(n[11], n[15]);
             new_graph.setEdge(n[12], n[13]);
             new_graph.setEdge(n[12], n[15]);
             new_graph.setEdge(n[13], n[14]);
             new_graph.setEdge(n[14], n[19]);
             new_graph.setEdge(n[14], n[16]);
             new_graph.setEdge(n[14], n[15]);
             new_graph.setEdge(n[16], n[17]);
             new_graph.setEdge(n[17], n[18]);
             new_graph.setEdge(n[18], n[19]);
             new_graph.setEdge(n[18], n[20]);
             new_graph.setEdge(n[19], n[20]);
             new_graph.setEdge(n[19], n[21]);
             new_graph.setEdge(n[19], n[22]);
             new_graph.setEdge(n[20], n[21]);
             new_graph.setEdge(n[20], n[30]);
             new_graph.setEdge(n[21], n[22]);
             new_graph.setEdge(n[21], n[23]);
             new_graph.setEdge(n[21], n[30]);
             new_graph.setEdge(n[23], n[24]);
             new_graph.setEdge(n[23], n[25]);
             new_graph.setEdge(n[23], n[28]);
             new_graph.setEdge(n[23], n[29]);
             new_graph.setEdge(n[23], n[30]);
             new_graph.setEdge(n[24], n[25]);
             new_graph.setEdge(n[24], n[26]);
             new_graph.setEdge(n[25], n[26]);
             new_graph.setEdge(n[25], n[28]);
             new_graph.setEdge(n[26], n[27]);
             new_graph.setEdge(n[27], n[28]);
             new_graph.setEdge(n[29], n[30]);             
             
             
             
             
         /* Prints the adjacency List representing the graph.*/
         System.out.println ("The Adjacency List for the input graph \n");
         System.out.println();
         System.out.println("-----------------------------------------------------");
         for (int i = 0 ; i < number_vertices ; i++)
         {
             System.out.print(i+"->");
             List<node> edgeList = new_graph.getEdge(n[i]);
             for (int j = 1 ; ; j++ )
             {
                 if (j != edgeList.size())
                 {
                     System.out.print(edgeList.get(j - 1 ).id+"->");
                 }else
                 {
                     System.out.print(edgeList.get(j - 1 ).id);
                     break;
                 }						 
             }
             System.out.println();					
          }
         System.out.println("---------------------------------------------------------");
         List<node>[] node_list=new List[number_vertices];
       
         for(int i=0;i<number_vertices;i++)
         {
        	node_list[i]=new_graph.Adjacency_List.get(n[i]);
         }
         for(int i=0;i<number_vertices;i++)
         {
        n[i].E_real_dist=new struct_1[node_list[i].size()];
        for(int j=0;j<node_list[i].size();j++)
        {
        	n[i].E_real_dist[j]=new struct_1();
        	
        }
         }
         
         
         //System.out.println("Enter the edge distance between nodes");
         for(int i=0;i<number_vertices;i++)
         {
        	 for(int j=0;j<node_list[i].size();j++)
        	 {
        		 //System.out.println("Enter the edge distance between"+i+"and"+node_list[i].get(j).id);
        		 n[i].E_real_dist[j].value=10E-2;
        	 }
         }
      
   /* Initialize initial energy and routing table for each node */
         for(int i=0;i<number_vertices;i++)
         {
        	 
        	 n[i].init_routing_table(node_list[i]);
        	 
         }
         
         
	
		 int next_hop,number_node,no_neigh,no_transmit;
		 /* Initialise nodes equal to the number of vertices in the graph */

		 
		 
		 /*node.initialise_network()*/
		 
		 
		 /* **Initialise the node variables,energy and routing table** */
		 
			
			
			System.out.println("The network has been initialized");
			System.out.println();
/*
for(int i=0;i<node_list[0].size();i++)
{
	System.out.println("energy"+n[0].r.E_est[i].value);
	System.out.println("Edash_dist"+n[0].r.Edash_dist[i].value);
	System.out.println("eta"+n[0].r.eta[i].value);
	System.out.println("p"+n[0].r.p[i].value);
	
	
}
*/
Scanner inp2;
inp2=new Scanner(System.in);
			 //Select for how long the transmissions will go on 
			System.out.println("Enter the total number of transmissions");
			String  var2 = inp2.nextLine();
			no_transmit=Integer.valueOf(var2);
			
			
			
			
			int round=0;
			
			
			// here is where transmission starts
			
			while(no_transmit>0)
			{	 int track[];
			int path_l=0;
			int header[];
			header=new int[100];
		     track=new int[400];
		     int count=0;
		     int recent=0;
				//System.out.println("Select source node");
				//String var3=inp2.nextLine();
				source=0; //Integer.valueOf(var3);
				//System.out.println("The first source selected is node"+source);
				//System.out.println("Select destination node");
				//String var4=inp2.nextLine();
				destination=30; //Integer.valueOf(var4);
				// Select next node based on maximum probability
				  double p_temp1[]=new double[node_list[source].size()];
				
				for(int j=0;j<node_list[source].size();j++)
				 {
					 while(n[source].send[j].value!=0)
						{	
							n[source].r.E_est[j].value=n[source].r.E_est[j].value-(node.E_tx_elec*node.k+node.e_amp*node.k*n[source].E_real_dist[j].value*n[source].E_real_dist[j].value);
							n[source].send[j].value--;
						}
						while(n[source].recieve[j].value!=0)
						{
							n[source].r.E_est[j].value=n[source].r.E_est[j].value-node.E_rx_elec*node.k;
							//System.out.println("This point"+node.E_rx_elec*node.k+"and"+n[source].r.E_est[j].value);
							n[source].recieve[j].value--;
						}
						//System.out.println("newly evaluated estimation energy by node"+source+"for node index"+j+"is"+n[source].r.E_est[j].value);
						n[source].e2[j].value=n[source].r.E_est[j].value/node.E_init;
						//System.out.println("newly evaluated e2 by node"+source+"for node index"+j+"is"+n[source].e2[j].value);
						n[source].r.Edash_dist[j].value=n[source].r.E_dist[j].value/n[source].e2[j].value*n[source].e1;
						//System.out.println("newly evaluated Edash by node"+source+"for node index"+j+"is"+n[source].r.Edash_dist[j].value);
						n[source].r.eta[j].value=1/n[source].r.Edash_dist[j].value;
													 
				 }
				 for(int j=0;j<node_list[source].size();j++)
					{	
							p_temp1[j]=(Math.pow(n[source].r.eta[j].value,node.alpha)*Math.pow(n[source].pheromone[j].value,node.beta))/node.sum;
						//	System.out.println("Newly evaluated p value for node"+source+"is"+p_temp1[j]+"for node index"+j);
					}
				double max1=-10000.0;
				int m=0;
				for(int i=0;i<node_list[source].size();i++)
				{
					if(max1<p_temp1[i])
						{max1=p_temp1[i];
						m=i;}
				}
				next_hop=node_list[source].get(m).id;
				
				track[++count]=next_hop;
				header[recent]=next_hop;
				recent=recent+1;
				
				//System.out.println("header is"+header[recent]);
				
				//System.out.println("Source node "+source +"selected"+node_list[source].get(m).id);
				
				// Update send and recieve arrays to help in evaluating energy later 
				
				n[source].recieve[m].value++; 
				// E_cur updation /
				
				
				// Update current energy 
				
			n[source].E_curr=n[source].E_curr-(node.E_tx_elec*node.k+node.e_amp*node.k*n[source].E_real_dist[m].value*n[source].E_real_dist[m].value);
			//System.out.println("Updated current energy is"+n[source].E_curr);
			
			
			//n[].evaluate_remaining_energy();
			
			//Update send array for the next hop node
			int i=0;
			for(;i<node_list[next_hop].size();i++)
			{
				if(node_list[next_hop].get(i).id==source)
					break;
			}
			
			/* Increment send of destination for source node */
			
			n[next_hop].send[i].value++;
			
			
				
			
			// Evaluate index of source node for hop node 
			
					
			/*n[n[source].recieve[next_hop].id].send[source].value++;
			int id_next=n[0].recieve[next_hop].id;
			n[id_next].send[0].value=1;
			n[id_next].evaluate_remaining_energy();*/
			
		 //Carry out transmission
		
		  
		 while(next_hop != destination)
		 {	/* Evaluate energy and update routing table and then select next node according to max p */
			 double  max=-1000.0;
			 for(int j=0;j<node_list[next_hop].size();j++)
			 {
				 while(n[next_hop].send[j].value!=0)
					{	
						n[next_hop].r.E_est[j].value=n[next_hop].r.E_est[j].value-(node.E_tx_elec*node.k+node.e_amp*node.k*n[next_hop].E_real_dist[j].value*n[next_hop].E_real_dist[j].value);
						n[next_hop].send[j].value--;
					}
					while(n[next_hop].recieve[j].value!=0)
					{
						n[next_hop].r.E_est[j].value=n[next_hop].r.E_est[j].value-node.E_rx_elec*node.k;
						n[next_hop].recieve[j].value--;
					}
					//System.out.println("newly evaluated estimation energy by node"+next_hop+"for node index"+j+"is"+n[next_hop].r.E_est[j].value);
					n[next_hop].e2[j].value=n[next_hop].r.E_est[j].value/node.E_init;
					//System.out.println("newly evaluated e2 by node"+next_hop+"for node index"+j+"is"+n[next_hop].e2[j].value);
					n[next_hop].r.Edash_dist[j].value=n[next_hop].r.E_dist[j].value/n[next_hop].e2[j].value*n[next_hop].e1;
					//System.out.println("newly evaluated Edash by node"+next_hop+"for node index"+j+"is"+n[next_hop].r.Edash_dist[j].value);
					n[next_hop].r.eta[j].value=1/n[next_hop].r.Edash_dist[j].value;
												 
			 }
			  double p_temp[]=new double[node_list[next_hop].size()];
			 for(int j=0;j<node_list[next_hop].size();j++)
				{	
						p_temp[j]=(Math.pow(n[next_hop].r.eta[j].value,node.alpha)*Math.pow(n[next_hop].pheromone[j].value,node.beta))/node.sum;
						//System.out.println("Newly evaluated p value for node"+next_hop+"is"+p_temp[j]+"for node index"+j);
				}
				
		 /* Find node with maximum probablity */
			 
			 int r=0;
			 /*
			 for(int h=0;h<recent;h++)
			 {
				 System.out.println("Headrer nodes are"+header[h]);
				 
			 }
			 */
			 
		 for(int k=0 ;k<node_list[next_hop].size();k++)
		 {	int yes=1;
			 for(int g=0;g<=recent;g++)
				 
		 	 {
			 if(node_list[next_hop].get(k).id==header[g])
		 		 {
		 	 	yes=0;
		 	 	}
		 	 }
			 if(yes==1)
			 {if(max<p_temp[k])
			 	{max=p_temp[k];
			 	 r=k;}
			 }
			 
		 }
		
		 
		 source=next_hop;
		 //System.out.println("Source node was"+source);
		 next_hop=node_list[source].get(r).id;
		 //System.out.println("New hop node is"+next_hop);
		 header[recent++]=next_hop;
		 track[++count]=next_hop;
		 
		 /* Update current energy of hop node */
		 
		 n[source].E_curr=n[source].E_curr-(node.E_tx_elec*node.k+node.e_amp*node.k*n[source].E_real_dist[r].value);
		// System.out.println("Updated current energy of source"+source+"is "+n[source].E_curr);
		 n[source].recieve[r].value++;
		 int source_in=0;
		 for(;source_in<node_list[next_hop].size();source_in++)
		 {
			 if(node_list[next_hop].get(source_in).id==source)
			 break;
		 }
		 n[next_hop].send[source_in].value++;
		 
		 if(round%node.round_update==0&&round!=0) 
		 {	 System.out.println();	
			 
			
		 for(int j=0;j<number_vertices;j++)
		 {
			 n[j].adjust_pheromones(node_list[j].size());
			 
		 }
		 for(int j=0;j<number_vertices;j++)
		 {
			 n[j].update_routing_table(node_list[j]);
		 }
		 }
	 
	 }
	 round++;
	 no_transmit--;
	 
	 track[++count]=100;
	 int l=0;
	 System.out.println();
	 System.out.println("----------------------------------------------------------------");
	 while(track[l]!=100)
	 {
		 System.out.print(track[l]+"->");
		 l++;
	 }
	 System.out.println();
	 System.out.println("----------------------------------------------------------------");
	 
	 System.out.println("Energy of nodes after round:"+round);
	 System.out.println();
	 
	for(int k=0;k<31;k++)
	{
		System.out.println("node: "+n[k].id+" -> "+n[k].E_curr);
		
	}
		 
	  
	 }
 }
 }
     
 
 
 

