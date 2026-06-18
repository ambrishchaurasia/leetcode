class Solution {
    public double angleClock(int hour, int minutes) {
        if(hour==12)
        hour=0;
        double hDegree=((hour-0)*30)+(0.5*minutes);
        double mDegree=minutes*6;
        double d1= Math.abs(mDegree-hDegree);
        double d2=Math.abs(d1-360.0);
        return Math.min(d1,d2);
    }
}