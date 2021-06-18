public class Lab4 {

        public int bigDiff(int[] nums) {
            int max = nums[0];
            int min = nums[0];
            for(int i =0;i<nums.length;i++)
            {
                if(nums[i]<min)
                    min = nums[i];
                if (nums[i]>max)
                    max=nums[i];
            }
            return (max-min);
        }

    public static void main(String[] args) {
            new Lab4().bigDiff(new int[]{1,2,3,4});
    }


}


