class Solution {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int aliceTotal = 0;
        int bobTotal = 0;
        // Calculating total candies of Alice and Bob
        for(int candy : aliceSizes){
            aliceTotal += candy;
        }
        for(int candy : bobSizes){
            bobTotal += candy;
        }

        //Checking the candies of both side
        int m = aliceSizes.length;
        int n = bobSizes.length;

        for(int i =0; i<m; i++){
            for(int j = 0; j<n; j++){
                int x = aliceSizes[i];// Candies that Alice will exchanges
                int y = bobSizes[j];// Candies that Bob will exchange

                if(aliceTotal -x + y == bobTotal - y+ x ){ 
                    return new int[]{x, y};
                }
            }
        }
        return new int[]{};
         
    }
}