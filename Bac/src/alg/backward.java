package alg;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Stack;
 
public class backward
{
    private int numberOfNodes;
    private Stack<Integer> stack;
    public int T, tnow;
    public int time_windows[][];
    public int stay_time[];
   /* public int time, cost;
    
    
    public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}
*/
	public backward()
    {
        stack = new Stack<Integer>();
    }
    
    public int getNumberOfNodes() {
		return numberOfNodes;
	}

	public void setNumberOfNodes(int numberOfNodes) {
		this.numberOfNodes = numberOfNodes;
	}

	public Stack<Integer> getStack() {
		return stack;
	}

	public void setStack(Stack<Integer> stack) {
		this.stack = stack;
	}

	public int getT() {
		return T;
	}

	public void setT(int t) {
		T = t;
	}

	public int getTnow() {
		return tnow;
	}

	public void setTnow(int tnow) {
		this.tnow = tnow;
	}

	public int[][] getTime_windows() {
		return time_windows;
	}

	public void setTime_windows(int[][] time_windows) {
		this.time_windows = time_windows;
	}

	public int[] getStay_time() {
		return stay_time;
	}

	public void setStay_time(int[] stay_time) {
		this.stay_time = stay_time;
	}

	public static void main(String... arg)
    {
        int number_of_nodes;
        Scanner scanner = null;
        try
        {
            System.out.println("Enter the number of nodes in the graph");
            scanner = new Scanner(System.in);    // ??? ???????? ??? ??
            number_of_nodes = scanner.nextInt(); 
            
            int adjacency_matrix[][] = new int[number_of_nodes + 1][number_of_nodes + 1];
            System.out.println("Enter Departure Time in your schedule");
            int T = scanner.nextInt();
            int stay_time[]= new int[number_of_nodes+1]; 
            System.out.println("Enter the stay time at nodes");
            for (int z = 1; z <=  number_of_nodes; z++)
            {
            	 stay_time[z] = scanner.nextInt();
            }
            int time_windows[][]= new int[number_of_nodes+1][2+1];     // size...
            System.out.println("Enter the time windows");
        
            for (int x = 1; x <= number_of_nodes; x++)
            {
                  
                for (int y = 1; y <= 2; y++)
                {
                   time_windows[x][y] = scanner.nextInt();
                }
           
            }   

            
         
            System.out.println("Enter the adjacency matrix");
            
            for (int i = 1; i <= number_of_nodes; i++)
            {
                for (int j = 1; j <= number_of_nodes; j++)
                {
                    adjacency_matrix[i][j] = scanner.nextInt();
                }
            }
               for (int i = 1; i <= number_of_nodes; i++)
              {
                for (int j = 1; j <= number_of_nodes; j++)
                {
                    if (adjacency_matrix[i][j] == 1 && adjacency_matrix[j][i] == 0)
                    {
                        adjacency_matrix[j][i] = 1;          // ??????? ??? ???? ??.( ????? ????? ???? ????)
                    }
                }
            }                      // matrix ??? ??
            
            System.out.println("The citys are visited as follows");
           
    
            backward travel = new backward();
            travel.tsp(adjacency_matrix, time_windows, T, stay_time);
      
            }
         catch (InputMismatchException inputMismatch)
         {
             System.out.println("Wrong Input format");   // ????? ??? ??? ???? ??????, ???α???? ???? ??.
         }
        scanner.close();
    }             
 
    public void tsp(int adjacencyMatrix[][], int timewindow[][], int tnow, int staytime[])
    {
       this.time_windows = timewindow;
       this.tnow = tnow;
       this.stay_time=staytime;
       
       numberOfNodes = adjacencyMatrix[1].length - 1;
        
        int[] visited = new int[numberOfNodes + 1];
        
        
		
        
        
       
        //System.out.println("Enter total Day in your schedule");
        int D = 3;
              
        //int time_windowday[][] = null;
        int[][] time_windowday = new int[D+1][3];
        
 //System.out.println("Enter the Day time windows");
        
        for (int d = 1; d <= D ; d++)
        //int d=1;
        //while(d<=D)
        {
              
            //for (int j = 1; j <= 2; j++)
            //{
        	time_windowday[d][1] = 540;
        	time_windowday[d][2] = 1260;
            //}
        }
        
        tnow=time_windowday[D][2];
        
        //last node
       // int lgettime=0, lexcesstime=0;
        //if(tnow>=time_windowday[D][1]&&tnow<=time_windowday[D][2]&&visited[numberOfNodes] == 0){
       
        	/*if(tnow<=time_windows[numberOfNodes][1]){
            	
        		lgettime=time_windows[numberOfNodes][1]-tnow;
            	
            }
            int outtime = tnow;
            if(outtime>time_windows[numberOfNodes][2]){
            	lexcesstime = time_windows[numberOfNodes][2]-outtime;
            }*/
        
            //tnow=tnow+staytime[numberOfNodes]+lgettime-lexcesstime;
        
       // Sum=Sum+adjacencyMatrix[dst][numberOfNodes]+staytime[numberOfNodes];
       // tnow=tnow-staytime[numberOfNodes]-lgettime-lexcesstime;    //마지막 도착시간    
        visited[numberOfNodes] = 1;
        stack.push(1);
        stack.push(numberOfNodes);        
        System.out.print(numberOfNodes+"\n");
        //}
        
        
        int element, dst = 0, i/*,j*/;
        int min = Integer.MAX_VALUE;
        //int Min = Integer.MAX_VALUE;
        //@SuppressWarnings("unused")
		int /*Sum = staytime[1] ,*/ Sum_waiting = 0, Sum_excesstime=0, totalMin=0, t/*, S*/;
        boolean minFlag = false;
        
        int lastnode= numberOfNodes;
        int place = lastnode-D;
        
        //for(int d =1; d<=D; d++){
        int d=D;
        while(1<=d){
        	//if(stack.isEmpty()){
        		//t= Min + min+tnow + staytime[dst]+gettime+excesstime;//(이동시간 최소+ 현재 시간+ 도착노드 staytime - 초과된 시간)
                //S =/* Min + */min+Sum + staytime[dst];
                //Sum_waiting=Sum_waiting+gettime;
                //Sum_excesstime = Sum_excesstime+ excesstime;
                //totalMin=totalMin+adjacencyMatrix[element][dst];
                
              /*
                System.out.print(gettime+"\t");
                System.out.print(Sum_waiting+"\t");
                System.out.print(excesstime+"\t");
                System.out.print(Sum_excesstime+"\t");
                System.out.print(totalMin+"\t");
                
                tnow = t;
                //Sum = S;
                System.out.print(Sum+"\t");
                System.out.print(tnow+"\t");
            }
            */
            
        while (!stack.isEmpty() )
        {   
            element = stack.peek();
            min = Integer.MAX_VALUE;
           // Min = Integer.MAX_VALUE;
            i = 2;
            //j=1;
            while (i <= place)
            {                       
               /* System.out.println("adj : "+adjacencyMatrix[element][i]);
                System.out.println("tnow : "+tnow);
                System.out.println("timewindow1: "+time_windows[i][1]);
                System.out.println("timewindow2: "+time_windows[i][2]); */
            	if(tnow>=time_windowday[d][1]&&tnow<=time_windowday[d][2]){
            	 if(time_windows[i][1]< time_windows[i][2]){
            	if (adjacencyMatrix[i][element] > 1 
                		&& tnow-adjacencyMatrix[i][element]-staytime[i]>= (time_windows[i][1]/*-9999*/) 
                				&& tnow-adjacencyMatrix[i][element] <= time_windows[i][2]/*+9999*/ 
                						&& visited[i] == 0)
                {
            		
                    if (min > (adjacencyMatrix[i][element]))
                    {
                        min = (adjacencyMatrix[i][element]);
                        dst = i;
                        minFlag = true;

                        
                    } 

                }       // 1?? ???κ??? 7?? ?????? ?? ??, ???? ???? ?????? ???? edge?? ????.
               
                            	 }
                else if ((adjacencyMatrix[i][element] > 1 
                        && tnow-adjacencyMatrix[i][element]-staytime[i]>= (time_windows[i][1]-9999) 	
                        		&& visited[i] == 0)
                              || (tnow-adjacencyMatrix[i][element]<= time_windows[i][2]+9999 
                            		  && visited[i] == 0
                            				  && adjacencyMatrix[i][element] > 1) 
                                    )
                  {
                     
                      if (min > (adjacencyMatrix[i][element]))
                      {
                          min = (adjacencyMatrix[i][element]);
                          dst = i;
                          minFlag = true;

                          
                      } 

                     

                  }       // 1번 노드로부터 7번 노드까지 갈 때, 가장 적은 값으로 적은 edge를 선택.
                 
            	 
            	 
            	} //day timewindow
            	i++;
            	/*else{
            		d++;
                	tnow= time_windowday[d][1];
            	}*/
            } 
            if (minFlag)
            {   
            	int /*Min=min/*-adjacencyMatrix[dst][numberOfNodes],*/arrivaltime=tnow-adjacencyMatrix[dst][element]-staytime[i];
            			//int gettime=0, excesstime=0;
            	int gettime=0, excesstime=0;
            	 if(time_windows[dst][1]< time_windows[dst][2]){
            	if(arrivaltime<=time_windows[dst][1]){
            		
            		gettime=time_windows[dst][1]-arrivaltime; 		
            	    		
            	    		
            	}
            	int outtime = arrivaltime + staytime[dst];
            	if(outtime>time_windows[dst][2]){
            		excesstime = time_windows[dst][2]-outtime;
            	}
            	 }
            	 else{
            		 if(arrivaltime<=time_windows[dst][1]
            		    		&&arrivaltime>=time_windows[dst][2])
            		 {
            			 gettime=time_windows[dst][1]-arrivaltime; 
            		    	System.out.println("gettime"+gettime);
            		    }
            		 
                 	int outtime = arrivaltime + staytime[dst];
                 	if(outtime>time_windows[dst][2]
                 			&&arrivaltime<=time_windows[dst][1]){
                 		excesstime = time_windows[dst][2]-outtime;
                 		System.out.println("excesstime"+excesstime);
                 		
                 	}
            	 }
            	
                visited[dst] = 1;
                stack.push(dst);
                System.out.print(dst + "\t");
                //System.out.print(stack.size()-1+"stack size-1 \t" );
                
                t= /*Min +*/ tnow - min - staytime[dst]-gettime-excesstime;//(이동시간 최소+ 현재 시간+ 도착노드 staytime - 초과된 시간)
                //S =/* Min + */min+Sum + staytime[dst];
                Sum_waiting=Sum_waiting+gettime;
                Sum_excesstime = Sum_excesstime+ excesstime;
                totalMin=totalMin+adjacencyMatrix[dst][element];
                
                System.out.print(gettime+"\t");
                System.out.print(Sum_waiting+"\t");
                System.out.print(excesstime+"\t");
                System.out.print(Sum_excesstime+"\t");
                System.out.print(totalMin+"\t");
                
                tnow = t;// 도착시간
                //Sum = S;
                //System.out.print(Sum+"\t");
                System.out.print(tnow+"\t");
                minFlag = false;
                continue;
                // sum
                
            } //minFlag
            
              stack.pop(); //stack?? ???  System.out.print("\n");
              
        } //while stack
        
        if(lastnode>place+1){
        lastnode= lastnode-1;
        visited[lastnode] = 1;
        totalMin=totalMin+adjacencyMatrix[lastnode][dst];
        tnow= tnow-adjacencyMatrix[lastnode][dst];
        System.out.print((lastnode)+"\n");
        dst=lastnode;
        }
        int count=0;
        for(int a=2; a<=place; a++ ){
        	if(visited[a] == 0){
            	count=count+1;}
            	//System.out.print(a +"\t");              
            }
        if(count>0){
    stack.push(lastnode);
	}
        if(d==1){
        visited[1] = 1;
        System.out.print(1 + "\t");
        totalMin=totalMin+adjacencyMatrix[1][dst];
        tnow= tnow+adjacencyMatrix[1][dst];
        
        }
        
    /*System.out.print("Total travel time is : ");//총 여행시간
    System.out.print(Sum);
    System.out.print("\n");*/
    System.out.print("Total transportation time is : ");//총 이동시간
    System.out.print(totalMin);
    System.out.print("\n");
    System.out.print("travel end time is : ");//총 여행 끝나는 시간
    System.out.print(tnow);
    System.out.print("\n");
    System.out.print("Total waiting time is : ");
    System.out.print(Sum_waiting);
    System.out.print("\n");
    
    System.out.print("Total excess time is : ");
    System.out.print(Sum_excesstime);
    System.out.print("\n");
    System.out.print("Day is : ");
    System.out.print(d);
    System.out.print("\n");
    System.out.print("You can't go to : ");
    for(int a=1; a<=numberOfNodes; a++ ){
        if(visited[a] == 0){
          	System.out.print(a +"\t");
          	
          }
        }
        
    
    d=d-1;
    if(d>=1){
	tnow= time_windowday[d][2];
	totalMin=0;
        }
        }
        
        
      //System.out.print("\n"); 
        /*visited[numberOfNodes] = 1;
        tnow= tnow-adjacencyMatrix[1][dst];
        System.out.print(numberOfNodes+"\n");*/
        
        //firstnode
       // int fgettime=0, fexcesstime=0;
        //if(tnow>=time_windowday[D][1]&&tnow<=time_windowday[D][2]&&visited[1] == 0){
        /*if(time_windows[numberOfNodes][1]< time_windows[numberOfNodes][2]){
        if (adjacencyMatrix[dst][numberOfNodes] > 1 
        		&& tnow + adjacencyMatrix[dst][numberOfNodes]>= (time_windows[numberOfNodes][1]-9999) 
        				&& tnow + adjacencyMatrix[dst][numberOfNodes] + staytime[numberOfNodes]<= time_windows[numberOfNodes][2]+9999*/ 
        						//if( visited[numberOfNodes] == 0){
        	
        	/*if(tnow-adjacencyMatrix[1][dst]-staytime[1]<=time_windows[1][1]){
            	
        		lgettime=time_windows[1][1]-tnow+adjacencyMatrix[1][dst]+staytime[1];
            	
            }
            int outtime = tnow + staytime[1];
            if(outtime>time_windows[1][2]){
            	lexcesstime = time_windows[1][2]-outtime;
            }*/
        
            //tnow=tnow+staytime[numberOfNodes]+lgettime-lexcesstime;
        //visited[numberOfNodes] = 1;
        //Sum=Sum+adjacencyMatrix[dst][numberOfNodes]+staytime[numberOfNodes];
        //tnow=tnow+adjacencyMatrix[dst][numberOfNodes]+staytime[numberOfNodes]+lgettime+lexcesstime;
        //totalMin=totalMin+adjacencyMatrix[dst][numberOfNodes];
       // System.out.print(numberOfNodes+"\n");
       // }
        
        /*else  if ((adjacencyMatrix[dst][numberOfNodes] > 1 
        		&& tnow + adjacencyMatrix[dst][numberOfNodes]>= (time_windows[numberOfNodes][1]-9999) 
        		&& visited[numberOfNodes] == 0)
				|| (adjacencyMatrix[dst][numberOfNodes] > 1
						&&tnow + adjacencyMatrix[dst][numberOfNodes] + staytime[numberOfNodes]<= time_windows[numberOfNodes][2]+9999 
						&& visited[numberOfNodes] == 0))
						{    
        	
        	if(tnow<=time_windows[numberOfNodes][1]
            		&&tnow>=time_windows[numberOfNodes][2]){
            	
        		lgettime=time_windows[numberOfNodes][1]-tnow;
            	System.out.println("lgettime"+lgettime);
            }
            int outtime = tnow + staytime[numberOfNodes];
            if(outtime>time_windows[numberOfNodes][2]
            		&&tnow<=time_windows[numberOfNodes][1]){
            	lexcesstime = time_windows[numberOfNodes][2]-outtime;
            	System.out.println("lexcesstime"+lexcesstime);
            	
            }
            
            //tnow=tnow+staytime[numberOfNodes]+lgettime-lexcesstime;
		visited[numberOfNodes] = 1;
		Sum=Sum+adjacencyMatrix[dst][numberOfNodes]+staytime[numberOfNodes];
		tnow=tnow+adjacencyMatrix[dst][numberOfNodes]+staytime[numberOfNodes]+lgettime-lexcesstime;
		totalMin=totalMin+adjacencyMatrix[dst][numberOfNodes];
		System.out.print(numberOfNodes+"\n");
		}*/
       // int count=0;
       /*for(int a=1; a<=numberOfNodes; a++ ){
        	
            if(visited[a] == 1){
            	count=count+1;}
            
            	//System.out.print(a +"\t");
              
            }
        if(count==numberOfNodes){
          	d=D+1;
        
        }*/
        //}
        
    		/*d++;
        	tnow= time_windowday[d][1];
    	
        stack.push(dst);*/

        /*
        System.out.print("\n");
        System.out.print("Total distance is : ");
        System.out.print(Sum+adjacencyMatrix[dst][numberOfNodes]);
        System.out.print("\n");
        System.out.print("Total waiting time is : ");
        System.out.print(Sum_waiting);
        */
       /* System.out.print("Total travel time is : ");//총 여행시간
        System.out.print(Sum);
        System.out.print("\n");*/
        /*System.out.print("Total transportation time is : ");//총 이동시간
        System.out.print(totalMin);
        System.out.print("\n");
        System.out.print("travel end time is : ");//총 여행 끝나는 시간
        System.out.print(tnow);
        System.out.print("\n");
        System.out.print("Total waiting time is : ");
        System.out.print(Sum_waiting);
        System.out.print("\n");
        
        System.out.print("Total excess time is : ");
        System.out.print(Sum_excesstime);
        System.out.print("\n");
        System.out.print("Day is : ");
        System.out.print(d);
        System.out.print("\n");
        System.out.print("You can't go to : ");
        for(int a=1; a<=numberOfNodes; a++ ){
            if(visited[a] == 0){
              	System.out.print(a +"\t");
              	
              }
            }*/
        //}//for day
    } //tsp
    
  
}//class