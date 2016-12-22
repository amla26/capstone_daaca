package Bound;

import java.util.List;

public class node
{	int id;
	int no_neighbours;
	static double sum;
	double E_curr;
	static final int alpha=2;
	static final int beta=2;
	static final int E_init=1000;
	static final double E_tx_elec=50E-9; /* 50nJperbit */
	static final double E_rx_elec=100E-9; /* 100nJperbit */
	static final double e_amp=100E-4; /* Jperbitperm2 */
	final double rho_value=0.2;
	static final int round_update=2;
	struct_1  E_real_dist[];
	double times[];
	struct_1 pheromone[];
	struct_1 send[];
	struct_1 recieve[];
	static final int k=4098;
	double e1;
	struct_1 e2[];
	int msg;

	//static graph_represent new_graph;
	
	routing_table r;
	node(int i)
	{
		id=i;
		msg = 0;
		
				
	}
	
		
	void init_routing_table(List<node> n)
	{	
	r=new routing_table(n.size());		
	 
	 //times=new double[n.size()];
	 pheromone=new struct_1[n.size()];
	 send=new struct_1[n.size()];
	 recieve=new struct_1[n.size()];
	 e2=new struct_1[n.size()];
	 
	 
	 for(int j=0;j<n.size();j++)
			
		{
		 
			pheromone[j]=new struct_1();
			send[j]=new struct_1();
			recieve[j]=new struct_1();
			e2[j]=new struct_1();
		
		}			
	
	for(int j=0;j<n.size();j++)
	{		
			E_curr=E_init;
			e1=E_curr/E_init;
			r.E_est[j].id=n.get(j).id;
			r.E_dist[j].id=n.get(j).id;
			r.Edash_dist[j].id=n.get(j).id;
			r.eta[j].id=n.get(j).id;
			r.E_est[j].value=E_init;
			//System.out.println("Estimated energy is"+r.E_est[j].value);
			e2[j].value=r.E_est[j].value/E_init;
			r.E_dist[j].value=E_tx_elec*k+e_amp*k*E_real_dist[j].value;
			r.Edash_dist[j].value=r.E_dist[j].value/e1*e2[j].value;
			
			/* initialise estimation energy of neighbour nodes */
		//	x=((E_init-r.E_est[j].value)/times[j])*(times[j]+1);
		//	r.E_est[j].value=E_init-x;
			r.eta[j].value=1/r.Edash_dist[j].value;
			pheromone[j].id=n.get(j).id;
			pheromone[j].value=0.8;
			
		
		
	}
	 sum=0;
	/* Initialising probability element of routing table */
	
	for(int i=0;i<n.size();i++)
		
	{
		sum=sum+Math.pow(r.eta[i].value,alpha)*Math.pow(pheromone[i].value,beta);
		//System.out.println("Sum is"+sum);
	}
	for(int j=0;j<n.size();j++)
	{	
	
			
			r.p[j].id=n.get(j).id;
			
			r.p[j].value=(Math.pow(r.eta[j].value,alpha)*Math.pow(pheromone[j].value,beta))/sum;
			
		}
		//System.out.println("init_routing complete");
	}
	
	
	
		
	
	
	
	
	int select_hop(int n)
	{
		double max=r.p[0].value;
		int j=0;
		for(int i=0;i<n;i++)
		{
			if(max<r.p[i].value)
				{max=r.p[i].value;
			j=i;}
		}
		return j;
		
	}
	
	void update_routing_table(List<node> n)
	{	
		double sum=0.0;
		//System.out.println("n is"+n.size());
		for(int i=0;i<n.size();i++)
		{
			r.E_est[i].value=n.get(i).E_curr;
			//System.out.println("Value of current energy for node"+n.get(i).id+"is"+n.get(i).E_curr);
			e2[i].value=r.E_est[i].value/E_init;
			r.Edash_dist[i].value=r.E_dist[i].value/e1*e2[i].value;
			r.eta[i].value=1/r.Edash_dist[i].value;
			
			sum=sum+Math.pow(r.eta[i].value,alpha)*Math.pow(pheromone[i].value,beta);
					
		}
		for(int i=0;i<n.size();i++)
		{
			r.p[i].value=(Math.pow(r.eta[i].value,alpha)*Math.pow(pheromone[i].value,beta))/sum;
		}
		
	}
		
	void adjust_pheromones(int n)
	{
		int k;
		    double max=-10000.0;
		    int s=0;
			for(k=0;k<n;k++)
			{
			if(max<(r.E_est[k].value))
				{max=r.E_est[k].value;
				s=k;}
			}
			// Evaporate pheromones of all neighbours
			for(int j=0;j<n;j++)
			{	pheromone[j].value = (1-rho_value)*pheromone[j].value;
			if(pheromone[j].value < 0.4)
				pheromone[j].value = 0.4;
				else if (pheromone[j].value>0.9)
					pheromone[j].value = 0.9;
				
				
			}
			// Deposit pheromones only on the path to neighbour with the highest energy
			
			
			pheromone[s].value=pheromone[s].value+pheromone[s].value;
			if(pheromone[s].value < 0.4)
				pheromone[s].value = 0.4;
				else if (pheromone[s].value>0.9)
				pheromone[s].value = 0.9;
				
			
}
}


