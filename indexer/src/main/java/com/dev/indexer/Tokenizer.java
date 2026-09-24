package com.dev.indexer;

import java.util.HashSet;
import java.util.Set;

public final class Tokenizer {

    public static Set<String> tokenize(String text, int length) {
        Set<String> result=new HashSet<String>();
        for(int i=0;i<text.length()-length;i++) {
            String token=text.substring(i,i+length);
            result.add(token);
        }
        return result;
    }
}
