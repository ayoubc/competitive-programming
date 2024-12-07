import java.io.*;
import java.util.*;


public class Main {
    static int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0};
    static int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1};
    static InputReader in;
    static PrintWriter out;
    static int seek;
    public static void main(String[] args){

        InputStream is;
        try {
            is = new FileInputStream(".\\src\\input\\in.txt");
        } catch (Exception e) {
            is = System.in;
        }
        in = new InputReader(is);
        out = new PrintWriter(System.out);

        String line = null;
        List<String> lines = new ArrayList<>();
        while ((line = in.readLine()) != null) lines.add(line);
        seek = 0;
        out.println(part2(lines));
        out.close();
    }

    private static long part1(List<String> lines) {
        List<Long> seeds = Arrays.stream(lines.get(seek).split(" ")).skip(1).map(Long::parseLong).toList();
        seek += 3;
        List<MapRange>[] mappers = new List[7];
        for (int i=0;i<7;i++) {
            mappers[i] = readRanges(lines);
        }
        long ans = Long.MAX_VALUE;
        for (Long seed: seeds) {
            ans = Math.min(ans, findLocation(seed, mappers));
        }
        // 111627841
        return ans;
    }
    private static long findLocation(long seed, List<MapRange>[] mappers) {
        long seedLocation = seed;
        for (int i=0;i<7;i++) {
            seedLocation = findMapValue(seedLocation, mappers[i]);
        }
        return seedLocation;
    }
    private static long part2(List<String> lines) {
        String[] tmp = lines.get(seek).split(" ");

        List<Range> seeds = new ArrayList<>();
        for (int i=1;i<tmp.length;i+=2) seeds.add(new Range(tmp[i], tmp[i+1]));

        seek += 3;
        List<MapRange>[] mappers = new List[7];
        for (int i=0;i<7;i++) {
            mappers[i] = readRanges(lines);
            Collections.sort(mappers[i]);
        }
        long ans = Long.MAX_VALUE;
        for (Range seedRange: seeds) {
            List<Range> locations = Arrays.asList(seedRange);
            for (List<MapRange> mapper: mappers) {
                List<Range> cur = new ArrayList<>();
                for (Range range: locations) {
                    cur.addAll(getMapValues(range, mapper));
                }
                locations = cur;
            }
            for(Range range: locations) {
                ans = Math.min(ans, range.start);
            }
        }
        // 69323688
        return ans;
    }
    public static List<Range> getMapValues(Range range, List<MapRange> mapper) {
        List<Range> res = new ArrayList<>();
        long s = range.start;
        long l = range.length;
        for (MapRange mapRange: mapper) {
            if (l <= 0) break;
            if (s < mapRange.source.start) {
                long numEle = Math.min(mapRange.source.start - s, l);
                res.add(new Range(s, numEle));
                s = mapRange.source.start;
                l -= numEle;
            }
            else if (s <= mapRange.source.getEnd()) {
                long start = mapRange.getMapValue(s);
                long numEle = Math.min(mapRange.destination.getEnd() - start + 1, l);
                res.add(new Range(start, numEle));
                s = mapRange.source.getEnd() + 1;
                l -= numEle;
            }
        }
        if (l > 0) res.add(new Range(s, l));
        return res;
    }
    static List<MapRange> readRanges(List<String> lines) {
        List<MapRange> res = new ArrayList<>();
        while (seek < lines.size()) {
            String line = lines.get(seek);
            if (line.isEmpty()) break;
            res.add(new MapRange(line.split(" ")));
            seek ++;
        }
        seek += 2;
        return res;
    }
    static long findMapValue(long val, List<MapRange> mapper) {
        for (MapRange range: mapper) {
            if (range.IsInSourceRange(val)) {
                return range.getMapValue(val);
            }
        }
        return val;
    }
    static class Range {
        long start;
        long length;
        public Range(long s, long l) {
            start = s;
            length = l;
        }
        public Range(String s, String l) {
            this(Long.parseLong(s), Long.parseLong(l));
        }
        public boolean isInRange(long val) {
            long diff = val - this.start;
            return diff >= 0 && diff < length;
        }
        public long getEnd() {
            return start + length - 1;
        }
        @Override
        public String toString() {
            return "[ " + start + " " + length + " ]";
        }
    }
    static class MapRange implements Comparable<MapRange> {
        Range source;
        Range destination;
        long length;
        public MapRange(String[] strs) {
            length = Long.parseLong(strs[2]);
            destination = new Range(Long.parseLong(strs[0]), length);
            source = new Range(Long.parseLong(strs[1]), length);
        }
        public long getMapValue(long source) {
            long diff = source - this.source.start;
            return this.destination.start + diff;
        }
        public boolean IsInSourceRange(long source) {
            return this.source.isInRange(source);
        }
        @Override
        public int compareTo(MapRange other) {
            return Long.compare(source.start, other.source.start);
        }
    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }
        public String readLine() {
            try {
                return reader.readLine();
            } catch (IOException ex) {
                return null;
            }
        }
    }
}
