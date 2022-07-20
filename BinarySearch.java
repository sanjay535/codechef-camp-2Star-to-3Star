package codechef_camp;

public class BinarySearch {
  private static int binarySearch(int a[], int key){
    int l=0,h=a.length-1;
    while (h-l>1){
      int mid=(l+h)/2;
      if(a[mid]<key){
        l=mid+1;
      }else{
        h=mid;
      }
    }
    if(a[l]==key)
      return l;
    if(a[h]==key)
      return h;
    return -1;
  }
  public static void main(String[] args) {
    int a[]={2,3,7,7,10,30,45};
    System.out.println(binarySearch(a, 3));
  }
}
