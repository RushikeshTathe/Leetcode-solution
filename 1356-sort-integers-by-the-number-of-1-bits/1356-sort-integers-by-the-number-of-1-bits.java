class Solution {
    public int[] sortByBits(int[] arr) {
        int n=arr.length;
        int [] newarr=new int[n];
        for(int i=0;i<n;i++){
            int num=arr[i];
            int cnt=0;
            while(num>0){
                if((num & 1) ==0) {num =num>>1;}
                else {cnt++;
                     num=num>>1;}
            }
            newarr[i]=cnt;
        }
        for(int i=0;i<n-1;i++){
            for(int j=i;j<n;j++){
             if(newarr[j]<newarr[i]){
                int temp=newarr[j];
                newarr[j]=newarr[i];
                newarr[i]=temp;
                 temp=arr[j];
                arr[j]=arr[i];
                arr[i]=temp;
             }
            else if(newarr[j]==newarr[i]){
                if(arr[i]>arr[j]){
                    int temp=arr[j];
                    arr[j]=arr[i];
                    arr[i]=temp;

                    temp=newarr[j];
                    newarr[j]=newarr[i];
                    newarr[i]=temp;
                }
            }
            }
           //sort newarr along with arr 

        }
        return arr;
    }
}