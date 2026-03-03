class Solution {
    // Changed method name to maxSubarrayXOR to match the driver code
    public int maxSubarrayXOR(int[] arr, int k) {
        int n = arr.length;
        int current_xor = 0;
        
        // Step 1: Compute the XOR sum of the very first window of size k
        for (int i = 0; i < k; i++) {
            current_xor ^= arr[i];
        }
        
        int max_xor = current_xor;
        
        // Step 2: Slide the window across the rest of the array
        for (int i = k; i < n; i++) {
            current_xor ^= arr[i - k]; // Remove the element going out of the window
            current_xor ^= arr[i];     // Add the new element coming into the window
            
            max_xor = Math.max(max_xor, current_xor);
        }
        
        return max_xor;
    }
}