package com.jake.solution;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class N0355_DesignTwitter {

    // TODO optimize
    public static class Twitter {

        private Map<Integer, Set<Integer>> followed = new HashMap<Integer, Set<Integer>>();
        private Deque<int[]> news = new ArrayDeque<int[]>();

        public Twitter() {

        }

        public void postTweet(int userId, int tweetId) {
            news.addFirst(new int[] { userId, tweetId });
        }

        public List<Integer> getNewsFeed(int userId) {
            Set<Integer> followees = followed.get(userId);
            if (followees == null) {
                followees = Collections.emptySet();
            }
            List<Integer> result = new ArrayList<Integer>();

            Iterator<int[]> it = news.iterator();
            int count = 10;
            while (count > 0 && it.hasNext()) {
                int[] post = it.next();
                if (post[0] == userId || followees.contains(post[0])) {
                    result.add(post[1]);
                    count--;
                }
            }
            return result;
        }

        public void follow(int followerId, int followeeId) {
            if (!followed.containsKey(followerId)) {
                followed.put(followerId, new HashSet<Integer>());
            }
            followed.get(followerId).add(followeeId);
        }

        public void unfollow(int followerId, int followeeId) {
            if (followed.containsKey(followerId)) {
                followed.get(followerId).remove(followeeId);
            }
        }
    }
}
