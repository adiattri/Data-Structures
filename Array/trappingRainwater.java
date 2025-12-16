import java.util.*;

public class trappingRainwater {
    public static int trappedRainWater(int height[]){
        //calculate max left height
        int leftMax[] = new int[height.length];
        leftMax[0] = height[0];
        for(int i =1; i<height.length; i++){
            leftMax[i] = Math.max(height[i], leftMax[i-1]);
        }
        //calculate max right height

        int rightMax[] = new int[height.length];
        rightMax[height.length-1] = height[height.length-1];
        for(int i = height.length-2; i>=0; i--){
            rightMax[i] = Math.max(height[i], rightMax[i+1]);
        }

        int trappedWater = 0;

        for(int i =0; i<height.length; i++){
            int waterLevel = Math.min(leftMax[i], rightMax[i]);
            trappedWater += waterLevel - height[i];
        }

        return trappedWater;


        //loop
        //find min of max left and right height which is waterlevel
        //trapped water = waterlevel - height[i]



    }
    public static void main(String[] args) {

    }
}
