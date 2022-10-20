
package com.mycompany.tspnew;
import java.util.*;
public class TSPNEW {
    int[][] d;
    int[] visited,finaltour;
    int n,cost;
    void read(){
        int i,j;
        Scanner sc=new Scanner(System.in);
        System.out.println("enter no.of cities:");
        n=sc.nextInt()+1;
        d=new int[n][n];
        System.out.println("enter the distance matrix:");
        for(i=1;i<n;i++)
            for(j=1;j<n;j++)
                d[i][j]=sc.nextInt();
        visited=new int[n];
        finaltour=new int[n];
        for(i=1;i<n;i++){
            visited[i]=0;
            finaltour[i]=i;
        }
    }
    void find_optimal_path(){
        cost=tsp_dp(1,finaltour);
        System.out.println("\ntraversal path using dynamic programming");
        for(int i=1;i<n;i++)
            System.out.print(finaltour[i]+"->");
        System.out.println(1);
        System.out.println("mincost="+cost);
    }
    int tsp_dp(int start,int[] tour){
        int i,j,k;
        int mincost,ccost,t;
        int[] temp=new int[n];
        int[] mintour=new int[n];
        if(start==n-2){
            return d[tour[n-2]][tour[n-1]]+d[tour[n-1]][1];
        }
        mincost=99;
        for(i=start+1;i<n;i++){
            for(j=1;j<n;j++)
                temp[j]=tour[j];
            temp[start+1]=tour[i];
            temp[i]=tour[start+1];
            if(d[tour[start]][tour[i]]+(ccost=tsp_dp(start+1,temp))<mincost){
                mincost=d[tour[start]][tour[i]]+ccost;
                for(k=1;k<n;k++)
                    mintour[k]=temp[k];
            }
            else
                t=d[tour[start]][tour[i]]+ccost;
        }
        for(i=1;i<n;i++)
            tour[i]=mintour[i];
        return mincost;
    }
    public static void main(String[] args) {
        TSPNEW t=new TSPNEW();
        t.read();
        t.find_optimal_path();
    }
}
