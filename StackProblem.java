package codechef_camp;

import java.util.ArrayList;
import java.util.Scanner;

/*
https://www.codechef.com/MP2TO302/problems/STACKS
 */
public class StackProblem {
  public static int upperBound(ArrayList<Integer> a, int key){
    if(a.size()==0)
      return -1;
    int l=0,h=a.size()-1;
    while (h-l>1){
      int mid=(l+h)/2;
      if(key>=a.get(mid)){
        l=mid+1;
      }else{
        h=mid;
      }
    }
    if(a.get(l)>key){
      return l;
    }
    if(a.get(h)>key)
      return h;
    return -1;
  }

  public static void solve(int a[], int n){
    ArrayList<Integer> stack=new ArrayList<>();
    for(int i=0;i<n;i++){
      int upper=upperBound(stack, a[i]);
      if(upper==-1){
        stack.add(a[i]);
      }else{
        stack.set(upper,a[i]);
      }
    }
    StringBuilder ans=new StringBuilder();
    ans.append(stack.size()).append(" ");
    for(int item:stack){
      ans.append(item).append(" ");
    }
    ans.append("\n");
    System.out.println(ans);
  }
  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    StringBuilder sb=new StringBuilder();
    int t=sc.nextInt();
    while (t-->0){
      int n=sc.nextInt();
      int a[]=new int[n];
      for(int i=0;i<n;i++){
        a[i]=sc.nextInt();
      }
      solve(a, n);
    }
  }
}
