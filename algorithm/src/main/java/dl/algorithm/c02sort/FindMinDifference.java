package dl.algorithm.c02sort;

import java.util.List;
import java.util.stream.Collectors;

public class FindMinDifference {
    public int findMinDifference(List<String> timePoints) {
        List<Integer> sorted = timePoints.stream().map(this::toMin)
                .sorted()
                .collect(Collectors.toList());
        int l = sorted.size();
        int ans = 24 * 60 - (sorted.get(l - 1) - sorted.get(0));
        for (int i = 0; i < sorted.size() - 1; i++) {
            ans = Math.min(sorted.get(i + 1) - sorted.get(i), ans);
        }
        return ans;
    }

    public int toMin(String timePoint) {
        String[] split = timePoint.split(":");
        return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
    }
}
