// me soch raha hu ki hum arr iterate karenge then for each position we look lefy right bigger value if it has 
// then small of (left, right) -that position value
//[1,0,2] 1 smaller adj 1-0 =1 litre 
//if adj is not bigger than current so keep increasing or decresing right and left respesctively until find greter than current if not find then increse current position 
// [3,2,1,3] here 2 has left side bigger than 2 and right side smaller then increase right++ now right is 3 
// but also we calculate diff between left right here position of left is 0 adn right is 3 diff =3-0 -1;
// now 3,2,3 left right smallest is 3  then total litre store is 3-2*diff = 2 
//then current ++ now left side of 1 is 2 which is bigger right side 3 bigger smaller is 2 and diff =1 totallitre=2-1 *1 =1  so total water store =2+1 

// suppose right side is bigger 
//[3,0,1,3]
// left-- until left bigger than 1 smae as above 
//but suppose [3,2,1,1,3] at index 1 value 2 using this method it store 3 litre and at 1 it store 2 litre but after one more increment again we go to 1 now we cant agaoin do same process like previous 1 
//lets take easy example [3,1,1,1,3] were for all 1 index left and right is 3 same so we cant do add process thrice for 3 1`s 
class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int total = 0;

            // Find tallest bar on the left
            int leftMax[] = new int[n];
            int rightMax[]=new int [n];
            leftMax[0]=height[0];
            for (int left = 1; left <n; left++) {
                leftMax[left] = Math.max(leftMax[left-1], height[left]);
            }

            // Find tallest bar on the right
            rightMax[n-1] = height[n-1];
            for (int right = n-2; right >=0; right--) {
                rightMax[right] = Math.max(rightMax[right+1], height[right]);
            }
            
            for (int i = 0; i < n; i++) {
            // Water stored at current index
            int leftBar=leftMax[i];
            int rightBar=rightMax[i];
            int level = Math.min(leftBar, rightBar);

            if (level > height[i]) {
                total += level - height[i];
            }
        }

        return total;
    }
}