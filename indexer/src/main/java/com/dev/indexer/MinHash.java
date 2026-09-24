package com.dev.indexer;

import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;

import java.nio.charset.StandardCharsets;
import java.util.Random;
import java.util.Set;

public class MinHash {
    private final int numHashes;
    private final long[] a;
    private final long[] b;
    private static final long PRIME = (1L << 61) - 1;

    public MinHash(int numHashes, int seed) {
        this.numHashes = numHashes;
        this.a = new long[numHashes];
        this.b = new long[numHashes];
        Random rand = new Random(seed); // fixed seed = reproducible across runs/restarts
        for (int i = 0; i < numHashes; i++) {
            a[i] = 1 + rand.nextLong(PRIME - 1); // avoid a=0
            b[i] = rand.nextLong(PRIME);
        }
    }

    public long[] computeSignature(String text){
        return computeSignature(Tokenizer.tokenize(text,5));
    }
    public long[] computeSignature(Set<String> shingles) {
        long[] signature = new long[numHashes];
        HashFunction murmur=Hashing.murmur3_128();
        for(String shingle: shingles) {
            long x=murmur.hashString(shingle, StandardCharsets.UTF_8).asLong() & Long.MAX_VALUE;
            for(int i=0;i<numHashes;i++) {
                long h=(a[i]*x+b[i])%PRIME;
                signature[i]=Math.min(signature[i],h);
            }
        }
        return signature;
    }

}
