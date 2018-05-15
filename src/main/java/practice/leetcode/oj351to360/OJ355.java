package practice.leetcode.oj351to360;

import java.util.*;

/**
 * @author xiaoyue26
 */
public class OJ355 {
    static class Twitter {

        private final Map<Integer, List<Integer>> userTweetsMap;
        private final Map<Integer, Set<Integer>> followMap;
        private final Map<Integer, Integer> tweetsTimeMap;
        private int timeStamp = 0;

        public Twitter() {
            userTweetsMap = new HashMap<>();
            followMap = new HashMap<>();
            tweetsTimeMap = new HashMap<>();
        }

        public void postTweet(int userId, int tweetId) {
            List<Integer> old = userTweetsMap.getOrDefault(userId, new LinkedList<>());
            old.add(tweetId);
            userTweetsMap.put(userId, old);
            tweetsTimeMap.put(tweetId, timeStamp++);
        }

        // pre -> after
        public void follow(int followerId, int followeeId) {
            Set<Integer> old = followMap.getOrDefault(followerId, new HashSet<>());
            old.add(followeeId);
            followMap.put(followerId, old);
        }

        public static class Tweet {
            public int tid;
            public int ts;

            public Tweet(int tid, int ts) {
                this.tid = tid;
                this.ts = ts;
            }

            public static class TweetComparator implements Comparator<Tweet> {
                @Override
                public int compare(Tweet o1, Tweet o2) {
                    return o1.ts - o2.ts;
                }
            }
        }

        // 需要维持时间顺序
        public List<Integer> getNewsFeed(int userId) {
            Set<Integer> vids = followMap.getOrDefault(userId, new HashSet<>());
            List<int[]> buff = new ArrayList<>();// 可以用最大堆代替
            vids.add(userId);
            for (Integer vid : vids) {
                List<Integer> tids = userTweetsMap.getOrDefault(vid, new ArrayList<>());
                for (Integer tid : tids) {
                    Integer time = tweetsTimeMap.getOrDefault(tid, -1);
                    buff.add(new int[]{tid, time});
                }
            }


            buff.sort((x,y)->y[1]-x[1]);
            List<Integer> res = new ArrayList<>(10);
            for (int i = 0; i < 10 && i < buff.size(); i++) {
                res.add(buff.get(i)[0]);
            }
            return res;
        }

        public void unfollow(int followerId, int followeeId) {
            Set<Integer> old = followMap.getOrDefault(followerId, new HashSet<>());
            old.remove(followeeId);
            followMap.put(followerId, old);
        }
    }


    public static void main(String[] args) {
        Twitter twitter = new Twitter();

        // User 1 posts a new tweet (id = 5).
        twitter.postTweet(1, 5);

        // User 1's news feed should return a list with 1 tweet id -> [5].
        System.out.println(twitter.getNewsFeed(1));// [5]

        // User 1 follows user 2.
        twitter.follow(1, 2);

        // User 2 posts a new tweet (id = 6).
        twitter.postTweet(2, 6);

        // User 1's news feed should return a list with 2 tweet ids -> [6, 5].
        // Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
        System.out.println(twitter.getNewsFeed(1));// [6,5]

        // User 1 unfollows user 2.
        twitter.unfollow(1, 2);

        // User 1's news feed should return a list with 1 tweet id -> [5],
        // since user 1 is no longer following user 2.
        System.out.println(twitter.getNewsFeed(1));// [5]
    }
}
