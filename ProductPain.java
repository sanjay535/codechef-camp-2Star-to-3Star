package codechef_camp;

import java.util.ArrayList;
import java.util.Scanner;

/*
https://www.codechef.com/problems/PRDTPAIN
 */
public class ProductPain {
  public static int lowerBound(ArrayList<Integer> a, int key){
    int l=0,h=a.size()-1;
    while (h-l>1){
      int mid=(l+h)/2;
      if(key>a.get(mid)){
        l=mid+1;
      }else{
        h=mid;
      }
    }
    if(a.get(l)>=key){
      return l;
    }
    if(a.get(h)>=key)
      return h;
    return -1;
  }

  public static int upperBound(ArrayList<Integer> a, int key){
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

  public static long solve(int a[], int n){
    ArrayList<Integer> sub=new ArrayList<>();
    long ans=0;
    for(int i=0;i<n;i++){
      sub.clear();
      for(int j=i;j<n;j++){
        sub.add(a[j]);
        if(sub.size()>=3){
          int l=0,m=sub.size()-1;
          int avg=(sub.get(l)+sub.get(m))/2;
          int pos1=upperBound(sub, avg);
          int pos2=lowerBound(sub, avg);
          int pos3=pos2-1;
          long ele=0;
          if(pos1>=l && pos1<=m){
            long cal=(long)(sub.get(pos1)-sub.get(l))*(sub.get(m)-sub.get(pos1));
            ele=Math.max(ele, cal);
          }
          if(pos2>=l && pos2<=m){
            long cal=(long)(sub.get(pos2)-sub.get(l))*(sub.get(m)-sub.get(pos2));
            ele=Math.max(ele, cal);
          }
          if(pos3>=l && pos3<=m){
            long cal=(long)(sub.get(pos3)-sub.get(l))*(sub.get(m)-sub.get(pos3));
            ele=Math.max(ele, cal);
          }
          ans+=ele;

        }
      }
    }
    return ans;
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
      long ans=solve(a, n);
      sb.append(ans).append("\n");
    }
    System.out.println(sb);
  }
}
