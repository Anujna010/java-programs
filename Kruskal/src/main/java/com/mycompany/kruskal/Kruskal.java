

package com.mycompany.kruskal;
import java.util.*;
public class Kruskal {
    int find(int V,int[] parent){
        while(parent[V]!=V)
            V=parent[V];
        return V;
    }
    void union(int i,int j,int[] parent){
        if(i<j)
            parent[j]=i;
        else
            parent[i]=j;
    }
    void kruskal(int n,int[][] cost){
        int[] parent=new int[10];
        int[][] t=new int[10][20];
        int i,j,mincost=0;
        int count=0,min,k=0,u=0,v=0;
        for(i=1;i<=n;i++)
            parent[i]=i;
        while(count<n){
            min=99;
            for(i=1;i<=n;i++)
                for(j=1;j<=n;j++)
                    if(cost[i][j]<min&&cost[i][j]!=0)
                    {
                        min=cost[i][j];
                        u=i;
                        v=j;
                    }
            if(min==99)
                break;
            i=find(u,parent);
            j=find(v,parent);
            if(i!=j){
                t[k][0]=u;
                t[k][1]=v;
                mincost+=min;
                count++;
                k++;
                union(i,j,parent);
            }
            cost[u][v]=cost[v][u]=99;
        }
        if(count==n-1){
            System.out.println("cost of spanning tree:"+mincost);
            System.out.println("edges of the spanning tree:");
            for(i=0;i<=n-2;i++)
                System.out.println(t[i][0]+" "+t[i][1]);
        }
        else
            System.out.println("spanning tree does not exist!!");
    }

    public static void main(String[] args) {
        int n,i,j;
        int[][] cost=new int[10][10];
        Kruskal k=new Kruskal();
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the total no.of nodes:");
        n=sc.nextInt();
        System.out.println("enter the cost matrix:");
        for(i=1;i<=n;i++)
            for(j=1;j<=n;j++)
                cost[i][j]=sc.nextInt();
        k.kruskal(n, cost);
    }
}
