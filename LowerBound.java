package codechef_camp;

public class LowerBound {
  private static int lowerBound(int a[], int key){
    int l=0,h=a.length-1;
    while (h-l>1){
      int mid=(l+h)/2;
      if(key>a[mid]){
        l=mid+1;
      }else{
        h=mid;
      }
    }
    if(a[l]>=key){
      return l;
    }
    if(a[h]>=key)
      return h;
    return -1;
  }
  public static void main(String[] args) {
    int a[]={3,4,5,7,7,7,9,23};
    System.out.println(lowerBound(a, 8));
  }
}
