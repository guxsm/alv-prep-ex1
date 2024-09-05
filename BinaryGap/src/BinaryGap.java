/*
    Binary Gap (BG)

    A Binary Gap within a positive integer N is any maximal sequence of consecutive zeros
    that is surrounded by ones at both ends in the binary representation of N.

    Example
        9 -> 1001 : BG={2}, MAX(BG)=2
        529 -> 1000010001 : BG={4,3}, MAX(BG)=4
        20 -> 10100 : BG={1}, MAX(BG)=1
        15 -> 1111 : BG={}, MAX(BG)=0
        32 -> 100000 : BG={}, MAX(BG)=0

    Constraints
        N is positive
        N is in a range of [1,...2147483647]
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class BinaryGap {
    public static void main(String[] args) throws Exception {
        new BinaryGap().start(200);        
    }

    private void start(int number) {
        List<Integer> binGAP = new ArrayList<>();
        List<Integer> myBinary = converToBinary(number);
        int i=0,j=0,gap=0;
    
        while(i<myBinary.size()) {
            if(myBinary.get(i)==1) {
                j++;
                while(j<myBinary.size()) {
                    if(myBinary.get(j)==0) {
                        gap++;
                    } else if(gap>0){
                        binGAP.add(gap);
                        gap=0;                    
                    }
    
                    j++;
                    i=j;
                }
            }
            i++;
        }
    
        print(number, myBinary, binGAP);
     }
    
     private void print(int number, List<Integer> binary, List<Integer> binGAP) {
        System.out.println("Decimal: " + number);
        System.out.println("Binary: " + binary);

        if(binGAP.size()>0) {
            System.out.println("Number of GAPs: " + binGAP.size());
            System.out.println("MAX GAP: " + Collections.max(binGAP));    
        } else 
            System.out.println("No GAPs where founded!");        
     }
    
     private List<Integer> converToBinary(int number) {    
        List<Integer> binary = new ArrayList<>();
        
        while(number>0) {
            binary.add(0,number%2);
            number = number/2;
        }           
            
        return binary;
     }
}
