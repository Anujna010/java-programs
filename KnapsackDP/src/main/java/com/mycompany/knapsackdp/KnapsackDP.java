
package com.mycompany.knapsackdp;
import java.util.*;
public class KnapsackDP {
    public void calculate(int[] wt,int[] val,int W,int n){
        int i,j;
        int[][] F=new int[n+1][W+1];
        for(i=0;i<=n;i++){
            for(j=0;j<=W;j++){
                if(i==0||j==0)
                    F[i][j]=0;
                else{
                    if(j<wt[i])
                        F[i][j]=F[i-1][j];
                    else
                        F[i][j]=Math.max((F[i-1][j-wt[i]]+val[i]),F[i-1][j]);
                }
            }
        }
        System.out.println("optimal solution="+F[n][W]);
        if(F[n][W]==0)
            System.out.println("no optimal subset");
        else{
            System.out.println("optimal subset:\n");
            for(i=n;i>0&&W>0;i--)
            {
                if(F[i][W]!=F[i-1][W])
                {
                    System.out.println(i+" ");
                    W=W-wt[i];
                }
            }
        }
            
    }
    

    public static void main(String[] args) {
        int i,n;
        Scanner sc=new Scanner(System.in);
        KnapsackDP k=new KnapsackDP();
        System.out.println("enter the no.of items:");
        n=sc.nextInt();
        int[] wt=new int[n+1];
        int[] val=new int[n+1];
        System.out.println("enter the weight for "+n+" items:");
        for(i=1;i<=n;i++)
            wt[i]=sc.nextInt();
        System.out.println("enter the profit/value for "+n+" items:");
        for(i=1;i<=n;i++)
            val[i]=sc.nextInt();
        System.out.println("enter the knapsack capacity:");
        int W=sc.nextInt();
        k.calculate(wt, val, W, n);
    }
}
