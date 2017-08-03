package com.fxiaoke.dbcloud.utils;

import com.google.common.base.CharMatcher;
import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import com.google.common.collect.Maps;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 内部工具类
 * Created by lirui on 2015/03/09 下午4:26.
 */
public class InnerUtil {
    public static final long ONE_HOUR = 60000L * 60;
    public static final long CHINA_OFFSET = 8 * ONE_HOUR;
    public static final Splitter LINE_SPLITTER = Splitter.on('\n').trimResults().omitEmptyStrings();
    public static final Splitter NORMAL_SPLITTER =
            Splitter.on(CharMatcher.anyOf(", \t\n;|")).trimResults().omitEmptyStrings();
    private static final Logger LOG = LoggerFactory.getLogger(InnerUtil.class);

    private InnerUtil() {
    }

    public static String getFirstNotNullMessage(Throwable e) {
        if (e == null)
            return null;
        String msg = e.getMessage();
        if (!Strings.isNullOrEmpty(msg))
            return msg;
        return getFirstNotNullMessage(e.getCause());
    }

    public static String getStackTrace(Throwable throwable) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        throwable.printStackTrace(pw);
        pw.close();
        return sw.toString();
    }

    public static Map<String, String> serverInfoToCharts(List<Map<?, ?>> items) {
        StringBuilder diskTotal = new StringBuilder(1024);
        StringBuilder diskUsed = new StringBuilder(1024);
        StringBuilder diskPercent = new StringBuilder(1024);
        StringBuilder waitTime = new StringBuilder(1024);
        StringBuilder userTime = new StringBuilder(1024);
        StringBuilder sysTime = new StringBuilder(1024);
        StringBuilder oneMinLoad = new StringBuilder(1024);
        StringBuilder fiveMinLoad = new StringBuilder(1024);
        StringBuilder fifteenMinLoad = new StringBuilder(1024);
        StringBuilder swapMegabyte = new StringBuilder(1024);
        StringBuilder memoryMegabyte = new StringBuilder(1024);
        StringBuilder memoryPercent = new StringBuilder(1024);
        StringBuilder swapPercent = new StringBuilder(1024);
        for (Map<?, ?> i : items) {
            Long stamp = (Long) i.get("stamp");
            diskTotal.append('[').append(stamp).append(',').append(String.format("%.2f", i.get("diskTotal"))).append("],");
            diskUsed.append('[').append(stamp).append(',').append(String.format("%.2f", i.get("diskUsed"))).append("],");
            diskPercent.append('[')
                    .append(stamp)
                    .append(',')
                    .append(String.format("%.2f", i.get("diskPercent")))
                    .append("],");
            waitTime.append('[').append(stamp).append(',').append(String.format("%.2f", i.get("waitTime"))).append("],");
            userTime.append('[').append(stamp).append(',').append(String.format("%.2f", i.get("userTime"))).append("],");
            sysTime.append('[').append(stamp).append(',').append(String.format("%.2f", i.get("sysTime"))).append("],");
            oneMinLoad.append('[').append(stamp).append(',').append(String.format("%.2f", i.get("oneMinLoad"))).append("],");
            fiveMinLoad.append('[')
                    .append(stamp)
                    .append(',')
                    .append(String.format("%.2f", i.get("fiveMinLoad")))
                    .append("],");
            fifteenMinLoad.append('[')
                    .append(stamp)
                    .append(',')
                    .append(String.format("%.2f", i.get("fifteenMinLoad")))
                    .append("],");
            swapMegabyte.append('[')
                    .append(stamp)
                    .append(',')
                    .append(String.format("%.2f", i.get("swapMegabyte")))
                    .append("],");
            memoryMegabyte.append('[')
                    .append(stamp)
                    .append(',')
                    .append(String.format("%.2f", i.get("memoryMegabyte")))
                    .append("],");
            memoryPercent.append('[')
                    .append(stamp)
                    .append(',')
                    .append(String.format("%.2f", i.get("memoryPercent")))
                    .append("],");
            swapPercent.append('[')
                    .append(stamp)
                    .append(',')
                    .append(String.format("%.2f", i.get("swapPercent")))
                    .append("],");
        }
        HashMap<String, String> m = Maps.newHashMap();
        m.put("diskTotal", trim(diskTotal));
        m.put("diskUsed", trim(diskUsed));
        m.put("diskPercent", trim(diskPercent));
        m.put("waitTime", trim(waitTime));
        m.put("userTime", trim(userTime));
        m.put("sysTime", trim(sysTime));
        m.put("oneMinLoad", trim(oneMinLoad));
        m.put("fiveMinLoad", trim(fiveMinLoad));
        m.put("fifteenMinLoad", trim(fifteenMinLoad));
        m.put("swapMegabyte", trim(swapMegabyte));
        m.put("memoryMegabyte", trim(memoryMegabyte));
        m.put("memoryPercent", trim(memoryPercent));
        m.put("swapPercent", trim(swapPercent));
        return m;
    }

    public static String trim(StringBuilder s) {
        if (s.length() > 0)
            return s.substring(0, s.length() - 1);
        return "";
    }
}
