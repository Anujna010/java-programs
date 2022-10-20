

package com.mycompany.floyd;
import java.util.*;
public class Floyd {
    void flyd(int[][] w,int n){
        int i,j,k;
        for(k=1;k<=n;k++)
            for(i=1;i<=n;i++)
                for(j=1;j<=n;j++)
                    w[i][j]=Math.min(w[i][j],w[i][k]+w[k][j]);
    }
    public static void main(String[] args) {
        int i,j,n;
        int a[][]=new int[10][10];
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the no.of vertices:");
        n=sc.nextInt();
        System.out.println("enter the weight matrix:");
        for(i=1;i<=n;i++)
            for(j=1;j<=n;j++)
                a[i][j]=sc.nextInt();
        Floyd f=new Floyd();
        f.flyd(a,n);
        System.out.println("the shortest path matrix is:");
        for(i=1;i<=n;i++){
            for(j=1;j<=n;j++)
                System.out.print(a[i][j]+" ");
            System.out.println();
        }
    }
}
