class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        //1) first thing i notice if negative elemnt is on leftmost it never affect arr means any -ve elemnt only remove left positive 
        // so we can enter positive element in stack while iterate from left to right 
        //is -ve elemnt appears check st.peek>0 or not 
        // if yes st.pop() untill you find st.peek<=0
        Stack <Integer> st=new Stack<>();
        for(int i=0;i<asteroids.length;i++){
            if(asteroids[i]>0){
                st.push(asteroids[i]);
            }
            else{

             while( !st.isEmpty() && st.peek()>0 && asteroids[i]*(-1)>st.peek()){
              st.pop();
                 }
            if(st.isEmpty()|| st.peek()<0){
                st.push(asteroids[i]);
            }
            else if(asteroids[i]*(-1)==st.peek()){
                 st.pop();
                  }

            else if(st.peek()>0 && asteroids[i]*(-1)<st.peek()){
                  continue;
                  }
           }
        }
                    
        int [] ans=new int [st.size()];
         for(int i=ans.length-1;i>=0;i--){
            ans[i]=st.pop();
           }
        return ans;
    }
}