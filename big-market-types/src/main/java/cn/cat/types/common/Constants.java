package cn.cat.types.common;

public class Constants {
    public final static String SPLIT = ",";
    public final static String COLON = ":";
    public final static String SPACE = " ";
    public final static String UNDERLINE = "_";

    public static class RedisPrefix {
        public static String STRATEGY = "strategy:";
        public static String STRATEGY_ARMORY = "strategy_armory:";
        public static String STRATEGY_RAFFLE = "strategy_raffle:";
        public static String STRATEGY_RULE_TREE = "strategy_rule_tree:";
        public static String STRATEGY_CONSUME_QUEUE = "strategy_consume_queue:";
    }

    public static class RedisKey {
        public static String STRATEGY_KEY = RedisPrefix.STRATEGY + "big_market_strategy_key_";
        public static String STRATEGY_AWARD_KEY = RedisPrefix.STRATEGY_RAFFLE + "big_market_strategy_award_key_";
        public static String STRATEGY_AWARD_LIST_KEY = RedisPrefix.STRATEGY_ARMORY + "big_market_strategy_award_list_key_";
        public static String STRATEGY_RATE_TABLE_KEY = RedisPrefix.STRATEGY_ARMORY + "big_market_strategy_rate_table_key_";
        public static String STRATEGY_RATE_RANGE_KEY = RedisPrefix.STRATEGY_ARMORY + "big_market_strategy_rate_range_key_";
        public static String RULE_TREE_VO_KEY = RedisPrefix.STRATEGY_RULE_TREE + "rule_tree_vo_key_";
        public static String STRATEGY_AWARD_COUNT_KEY = RedisPrefix.STRATEGY_ARMORY + "strategy_award_count_key_";
        public static String STRATEGY_AWARD_COUNT_QUEUE_KEY = RedisPrefix.STRATEGY_CONSUME_QUEUE + "strategy_award_count_queue_key";

    }
}
