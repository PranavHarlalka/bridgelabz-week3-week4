class Log {
    String accountId;
    String data;

    public Log(String accountId, String data) {
        this.accountId = accountId;
        this.data = data;
    }
}

public class P5_AccountIDLookupInTransactionLogs {

    public static int linearSearchFirst(Log[] logs, String targetId) {
        for (int i = 0; i < logs.length; i++) {
            if (logs[i].accountId.equals(targetId)) return i;
        }
        return -1;
    }

    public static int linearSearchLast(Log[] logs, String targetId) {
        int lastIndex = -1;
        for (int i = 0; i < logs.length; i++) {
            if (logs[i].accountId.equals(targetId)) lastIndex = i;
        }
        return lastIndex;
    }

    public static int[] binarySearchExactAndCount(Log[] sortedLogs, String targetId) {
        int first = findBound(sortedLogs, targetId, true);
        if (first == -1) return new int[] {-1, 0, 0};

        int last = findBound(sortedLogs, targetId, false);
        int count = last - first + 1;

        return new int[] {first, count, 0};
    }

    private static int findBound(Log[] sortedLogs, String targetId, boolean isFirst) {
        int low = 0, high = sortedLogs.length - 1;
        int result = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int cmp = sortedLogs[mid].accountId.compareTo(targetId);
            if (cmp == 0) {
                result = mid;
                if (isFirst) high = mid - 1;
                else low = mid + 1;
            } else if (cmp < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return result;
    }
}