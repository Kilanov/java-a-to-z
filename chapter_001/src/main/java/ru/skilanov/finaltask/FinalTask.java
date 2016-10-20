package ru.skilanov.finaltask;

public class FinalTask {
    public boolean contains(String origin, String sub) {

        char[] originChar = origin.toCharArray();
        char[] subChar = sub.toCharArray();

        int count = 0;

        for (int i = 0; i < originChar.length; i++) {
            for (int j = 0; j < subChar.length; j++) {
                if (originChar[i] == subChar[j]) {
                    count++;
                }
            }
            if (count == subChar.length && subChar.length <= originChar.length) {
                return true;
            }
        }
        return false;
    }
}