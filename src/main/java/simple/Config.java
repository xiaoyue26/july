package simple;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by xiaoyue26 on 17/11/16.
 */
public class Config {
    List<String> pre = new ArrayList<>();
    List<String> cmd = new ArrayList<>();
    String start = null;
    String end = null;
    int step = 1;
    int poolSize = 10;
    int threshold = 365;
    /*private static final List<String> keywords = Arrays.asList(
            "pre"
            , "cmd"
            , "start"
            , "end"
            , "step"
            , "pool_size"
            , "thredshold"
    );*/

    private void log(String line) {
        System.out.println(line);
    }

    public boolean isValid() {
        if (cmd.size() <= 0) {
            log("empty cmd");
            return false;
        }
        if (!DtUtils.isValid(start)) {
            log(String.format("invalid start: %s", start));
            return false;
        }

        if (!DtUtils.isValid(end)) {
            log(String.format("invalid end: %s", end));
            return false;
        }

        int days;
        try {
            days = DtUtils.dtDiff(start, end);
        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }
        if (days > threshold) {
            log(String.format("[start(%s),end(%s)] days over thredhold(%d)", start, end, threshold));
            return false;
        }

        return true;
    }

    public void add(String key, String value) {
        key = key.toLowerCase();
        value = value.trim();
        switch (key) {
            case "pre":
                pre.add(value);
                break;
            case "cmd":
                cmd.add(value);
                break;
            case "start":
                start = value;
                break;
            case "end":
                end = value;
                break;
            case "step":
                step = Integer.valueOf(value);
                break;
            case "pool_size":
                poolSize = Integer.valueOf(value);
                break;
            case "thredshold":
                threshold = Integer.valueOf(value);
                break;
            default:
                log(String.format("oops:%s %s", key, value));
                break;
        }
    }

    public void printStatus() {
        log(String.format("pre: %s", pre));
        log(String.format("cmd: %s", cmd));
        log(String.format("start: %s", start));
        log(String.format("end: %s", end));
        log(String.format("step: %d", step));
        log(String.format("pool_size: %d", poolSize));
        log(String.format("threshold: %d", threshold));
    }
}
