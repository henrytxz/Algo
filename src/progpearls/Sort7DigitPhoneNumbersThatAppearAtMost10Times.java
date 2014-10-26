package progpearls;

import gayle.bitmanipulation.Bit;

/**
 * Created by henry on 10/26/2014.
 */
public class Sort7DigitPhoneNumbersThatAppearAtMost10Times {
    int a[] = new int[new Double(Math.pow(10,7)/32).intValue()];
    int count[] = new int[a.length*4];

    /*   will use the type FourBit
         this is a problem that deals with memory constraint so use half a byte instead of a whole byte
     */
//    class FourBit {
//        int b0,b1,b2,b3;
//        FourBit()

        int getCount(int number) {
            int arrayIndex = number*4/32;
            int bitMask = count[arrayIndex];
            int beginBit = (number*4)%32;
            int count = 0;
            for (int i=0; i!=4; i++) {
                if (Bit.getBit(bitMask, beginBit+i)) {
                    count += Math.pow(2,i);
                }
            }
            return count;
        }

        void incrementCount(int number) {
            int arrayIndex = number*4/32;
            int bitToIncrement = (number*4)%32;
            while (Bit.getBit(count[arrayIndex], bitToIncrement)) {
                count[arrayIndex] = Bit.clearBit(count[arrayIndex], bitToIncrement);
                bitToIncrement++;
            }
            count[arrayIndex] = Bit.setBit(count[arrayIndex], bitToIncrement);
        }
//    }

}
