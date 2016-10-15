package ru.skilanov.arrayduplicate;

/**
 * This class delete duplicate values.
 */
public class Duplicate {

    /**
     * This method count and delete duplicate values.
     */
    public String[] duplicateDeleting(String[] value) {
        int counting = 0;

        /**
         * Making copy of the array.
         */
        String[] array = new String[value.length];
        for (int i = 0; i < value.length; i++) {
            array[i] = value[i];
        }

        /**
         * Algorithm of duplicates finding.
         */
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i].equals(array[j])) {
                    array[j] = null;
                    counting++;
                }
            }
        }

        /**
         * Deleting duplicate values.
         */
        String[] result = new String[array.length - counting];
        int j = 0;
        for (int i = 0; i < value.length; i++) {
            if (array[i] != null) {
                result[j++] = value[i];
            }
        }
        return result;
    }
}