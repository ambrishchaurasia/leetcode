class Solution {
    public int singleNumber(int[] nums) {
        int bits_jinki_count_is_1=0;
        int bits_jinki_count_is_2=0;
        for(int i:nums)
        {
            bits_jinki_count_is_1=(bits_jinki_count_is_1 ^ i )& ~bits_jinki_count_is_2;
            bits_jinki_count_is_2=(bits_jinki_count_is_2 ^ i )& ~bits_jinki_count_is_1;
            
        }
        return bits_jinki_count_is_1;
    }
}