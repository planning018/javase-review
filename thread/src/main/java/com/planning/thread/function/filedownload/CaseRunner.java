package com.planning.thread.function.filedownload;


import com.planning.thread.utils.Debug;

public class CaseRunner {

    public static void main(String[] args) throws Exception {
        if (0 == args.length) {
            args = new String[] { "https://park.zunmi.cn", "2", "3" };  // todo 去哪边找个东西下载
        }
        main0(args);
    }

    public static void main0(String[] args) throws Exception {
        final int argc = args.length;
        BigFileDownloader downloader = new BigFileDownloader(args[0]);

        // 下载线程数
        int workerThreadsCount = argc >= 2 ? Integer.valueOf(args[1]) : 2;
        long reportInterval = argc >= 3 ? Integer.valueOf(args[2]) : 2;

        Debug.info("downloading %s%nConfig:worker threads:%s,reportInterval:%s s.",
                args[0], workerThreadsCount, reportInterval);

        downloader.download(workerThreadsCount, reportInterval * 1000);
    }
}
