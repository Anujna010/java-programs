

package com.mycompany.prims;
import java.util.*;
public class Prims {
    void prim(int[][] cost,int n){
        int[] near=new int[n+1];
        int[][] t=new int[10][2];
        int mincost=0,i,j=0,k=0,l=0,min;
        min=99;
        for(i=1;i<=n;i++)
            for(j=1;j<=n;j++)
                if(cost[i][j]<min&&cost[i][j]!=0)
                {
                    min=cost[i][j];
                    k=i;
                    l=j;
                }
        mincost=cost[k][l];
        t[1][0]=k;
        t[1][1]=l;
        for(i=1;i<=n;i++)
            if(cost[i][k]<cost[i][l])
                near[i]=k;
            else
                near[i]=l;
        near[k]=near[l]=0;
        for(i=2;i<=n-1;i++)
        {
            min=99;
            for(k=1;k<=n;k++)
                if(near[k]!=0&&cost[k][near[k]]<min)
                {
                    min=cost[k][near[k]];
                    j=k;
                }
            t[i][0]=j;
            t[i][1]=near[j];
            mincost+=cost[j][near[j]];
            near[j]=0;
            for(k=1;k<=n;k++)
                if(near[k]!=0&&cost[k][j]<cost[k][near[k]])
                    near[k]=j;
        }
        System.out.println("cost of spanning tree:"+mincost);
        System.out.println("edges of spanning tree:");
        for(i=1;i<=n;i++)
            System.out.println(t[i][0]+" "+t[i][1]);
        
    }

    public static void main(String[] args) {
        int i,j,n;
        int[][] cost=new int[20][20];
        Scanner sc=new Scanner(System.in);
        Prims p=new Prims();
        System.out.println("enter the no.of nodes:");
        n=sc.nextInt();
        System.out.println("enter the cost matrix:");
        for(i=1;i<=n;i++)
            for(j=1;j<=n;j++)
                cost[i][j]=sc.nextInt();
        for(i=1;i<=n;i++)
        {
            int count=0;
            for(j=1;j<=n;j++){
                if(cost[i][j]==99)
                    count++;
            }
            if(count==n-1){
                System.out.println("spanning tree does not exist!!");
                System.exit(0);
            }
        }
        p.prim(cost,n);
    }
}
