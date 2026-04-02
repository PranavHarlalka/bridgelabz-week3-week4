public class P6_RiskThresholdBinaryLookup {

    public static int linearSearchThreshold(int[] bands, int target) {
        for (int i = 0; i < bands.length; i++) {
            if (bands[i] == target) return i;
        }
        return -1;
    }

    public static int binaryFloor(int[] sortedBands, int target) {
        int low = 0, high = sortedBands.length - 1;
        int floor = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (sortedBands[mid] == target) return sortedBands[mid];
            if (sortedBands[mid] < target) {
                floor = sortedBands[mid];
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return floor;
    }

    public static int binaryCeiling(int[] sortedBands, int target) {
        int low = 0, high = sortedBands.length - 1;
        int ceiling = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (sortedBands[mid] == target) return sortedBands[mid];
            if (sortedBands[mid] > target) {
                ceiling = sortedBands[mid];
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ceiling;
    }
}