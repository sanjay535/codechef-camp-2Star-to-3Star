package codechef_camp;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

/*
1
6
2
5
2 3
0 5
3 7
5 11
12 15
13 17

 */
public class CheatingTime {
  static class Pair{
    int f,s;
    Pair(int f, int s){
      this.f=f;
      this.s=s;
    }
  }
  public static void solve(Pair p[], int n, int k, int f){
    Stack<Pair> stack=new Stack<>();
    for (int i = 0; i < n; i++) {
      if(stack.isEmpty()){
        stack.push(p[i]);
      }
      else{
        Pair top=stack.peek();
        if(top.s>p[i].f){
          Pair topE=stack.pop();
          stack.push(new Pair(Math.min(topE.f, p[i].f),Math.max(topE.s, p[i].s)));
        }else{
          stack.push(p[i]);
        }
      }
    }

    long totalInvTime=0;
//    System.out.println("after merge");
    for(Pair item:stack){
//      System.out.println(item.f+" "+item.s);
      totalInvTime+=(long)(item.s-item.f);
    }
    long totalNonInvTime=f-totalInvTime;
    if(totalNonInvTime>=k){
      System.out.println("YES");
    }else{
      System.out.println("NO");
    }
  }
  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    int t=sc.nextInt();
    while (t-->0){
      int n=sc.nextInt();
      int k=sc.nextInt();
      int f=sc.nextInt();
      Pair p[]=new Pair[n];
      for (int i = 0; i < n; i++) {
        p[i]=new Pair(sc.nextInt(), sc.nextInt());
      }
      Arrays.sort(p, (p1,p2)->p1.s-p2.s);
//      for (int i = 0; i < n; i++) {
//        System.out.println(p[i].f+" "+p[i].s);
//      }
      solve(p, n, k, f);
    }
  }
}
