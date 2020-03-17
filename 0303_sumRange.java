class NumArray {
    public int[] f;
    public NumArray(int[] nums) {
        if(nums.length!=0){
            int n=nums.length;
            f=new int[n+1];
            f[0]=0;
            for(int i=1;i<=n;i++){
                f[i]=f[i-1]+nums[i-1];
            }
        }
    }
    
    public int sumRange(int i, int j) {
        return f[j+1]-f[i];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */