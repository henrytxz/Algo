package progpearls;

import gayle.bitmanipulation.Bit;

/**
 * not complete, but done in the sense that I tried out getCount and incrementCount and their test pass
 */
public class Sort7DigitPhoneNumbersThatAppearAtMost10Times {
    int a[] = new int[new Double(Math.pow(10,7)/32).intValue()];
    int count[] = new int[a.length*4];  // 3 bits can count 8, 4 bits will take care of 10, with 6 to spare

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

}
