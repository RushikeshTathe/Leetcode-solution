class Solution {
    public int totalFruit(int[] fruits) {
        HashMap <Integer,Integer> map=new HashMap<>();
        int  maxFruits=0;
        int b1=-1;
        int b2=-1;
        int freqB1=0;
        int freqB2=0;

        int left=0;
        int right=0;
        while(right<fruits.length){
            if(fruits[right]==b1 || b1==-1){
                b1=fruits[right];
                freqB1++;
                right++;
            }
             else if(fruits[right]==b2 || b2==-1){
                b2=fruits[right];
                  freqB2++;
                right++;
            }
            else{
                while((b1!=-1 && b2!=-1) && (freqB1>0 && freqB2>0)){
                    if(fruits[left]==b1){
                        freqB1--;
                    }
                    if(fruits[left]==b2){
                        freqB2--;
                    }
                   
                    left++;
                }
                if(freqB1==0){
                    b1=fruits[right];
                }
                else if(freqB2==0){
                    b2=fruits[right];
                }
                
            }
            maxFruits=Math.max(maxFruits,right-left);

        }
        return maxFruits;
    }
}