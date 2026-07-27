class Solution {
    public int shipWithinDays(int[] weights, int days) {
        //weights = [1,2,3,4,5,6,7,8,9,10], days = 5
        int totalWeight = 0;
        int maxWeight = 0;

        for(int i = 0; i < weights.length; i++){
            totalWeight+= weights[i];
            maxWeight = Math.max(maxWeight, weights[i]);
        }

        int left = maxWeight;  // we need ship with capacity of atleast maxWeight
        int right = totalWeight;  // we need ships to carry totalweight

        while(left < right){
            int mid = left + (right-left)/2;  //consider ship with capacity mid to carry all the weights 
            
            if(isPossible(weights, days, mid)){
                right = mid; // if found we search in left search space
            }else{
                left = mid+1;
            }

        }
        return left;
    }


    private boolean isPossible(int[] weights, int days, int capacity ){
        int daysNeeded = 1;
        int currentLoad = 0;

        for( int weight : weights){
            currentLoad = currentLoad + weight;
            if(currentLoad > capacity){
                daysNeeded++;
                currentLoad = weight;
            }
        }

        return daysNeeded <= days;
    }
}