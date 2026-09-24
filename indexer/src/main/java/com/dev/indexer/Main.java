package com.dev.indexer;

import java.util.Random;

public class Main {

    static void main(String[] args) {
        MinHash minHash=new MinHash(200, 20);
        String text1="I love apples, genuinely, I feel it is the best fruit there is";
        String text2="I like apples, but genuinely feel it is not as good";
        long[] text1Signature=minHash.computeSignature(text1);
        long[] text2Signature=minHash.computeSignature(text2);
        int matches=0;
        for(int i=0;i<text1Signature.length;i++) {
            if(text1Signature[i]==text2Signature[i]) {
                matches++;
            }
        }
        double estimatedJaccard = (double) matches / text1Signature.length;
        System.out.println("estimatedJaccard: " + estimatedJaccard);
    }
}
