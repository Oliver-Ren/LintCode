/**
 * Uses the property of modular arithemic.
 */
class Solution {
    /**
     * @param key: A String you should hash
     * @param HASH_SIZE: An integer
     * @return an integer
     */
    public int hashCode(char[] key,int HASH_SIZE) {
        // preconditon: key is not null
        if (key == null) throw new NullPointerException();
        // precondition: HASH_SIZE > 0;
        if (HASH_SIZE <= 0) throw new IllegalArgumentException();

        int hashValue = 0;
        long base = 1;

        for (int i = key.length - 1; i >= 0; i--) {
            char c = key[i];
            long temp = (base * c) % HASH_SIZE;
            hashValue = (hashValue + temp) % HASH_SIZE;
            base = (base * 33) % HASH_SIZE;
        }

        return hashValue;

    }
};
