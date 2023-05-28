class Solution {
  
    public static int findPeak(int[] nums,int s,int e){
        int mid = s + (e-s)/2;
        if((mid==0 || nums[mid-1] < nums[mid]) && (mid==nums.length-1 || nums[mid+1]<nums[mid])) return mid;
        if(mid-1>=0 && nums[mid-1]>nums[mid])
            return findPeak(nums,s,mid-1);
        return findPeak(nums,mid+1,e);
    }

    public static int findPeakElement(int[] nums) {
        return findPeak(nums,0,nums.length-1);
    }
    
    public static void main(String[] args) {
        int arr[] = {1,2,1,3,5,6,4};
        System.out.println(findPeakElement(arr));
    }
}
