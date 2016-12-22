
class struct_1
{
	int id;
	double value;
}

public class routing_table
{
	
	struct_1 E_dist[];
	struct_1 Edash_dist[];	
	struct_1 E_est[];
		struct_1 eta[];
	struct_1 p[];
	
	routing_table(int n)
	{
		E_dist=new struct_1[n];
		Edash_dist=new struct_1[n];
		E_est=new struct_1[n];
		 eta=new struct_1[n];
		 p=new struct_1[n];
		 for(int i=0;i<n;i++)
		 {
			 E_dist[i]=new struct_1();
			 Edash_dist[i]=new struct_1();
				E_est[i]=new struct_1();
				 eta[i]=new struct_1();
				 p[i]=new struct_1();
		 }
		 
		 
		
		
		
	}
	 
}
