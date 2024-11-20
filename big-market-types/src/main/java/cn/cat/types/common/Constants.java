package cn.cat.types.common;

public class Constants {
    public final static String SPLIT = ",";
    public final static String COLON = ":";
    public final static String SPACE = " ";
    public final static String UNDERLINE = "_";

    public static class RedisPrefix {
        public static String STRATEGY = "big_market:strategy:";
        public static String STRATEGY_ARMORY = "big_market:strategy:armory:";
        public static String STRATEGY_RAFFLE = "big_market:strategy:raffle:";
        public static String STRATEGY_RULE_TREE = "big_market:strategy:rule_tree:";
        public static String STRATEGY_CONSUME_QUEUE = "big_market:strategy:consume_queue:";
        public static String RAFFLE_ACTIVITY = "big_market:raffle_activity:";
        public static String RAFFLE_ACTIVITY_ACCOUNT = "big_market:raffle_award:account:";
        public static String ACTIVITY_SKU = "big_market:activity:sku:";
    }

    public static class RedisKey {
        public static String ACTIVITY_KEY = RedisPrefix.RAFFLE_ACTIVITY + "big_market_activity_key_";
        public static String ACTIVITY_SKU_KEY = RedisPrefix.RAFFLE_ACTIVITY + "big_market_activity_sku_key_";
        public static String ACTIVITY_COUNT_KEY = RedisPrefix.RAFFLE_ACTIVITY + "big_market_activity_count_key_";

        public static String STRATEGY_KEY = RedisPrefix.STRATEGY + "big_market_strategy_key_";
        public static String STRATEGY_AWARD_KEY = RedisPrefix.STRATEGY_RAFFLE + "big_market_strategy_award_key_";
        public static String STRATEGY_AWARD_LIST_KEY = RedisPrefix.STRATEGY_ARMORY + "big_market_strategy_award_list_key_";
        public static String STRATEGY_RATE_TABLE_KEY = RedisPrefix.STRATEGY_ARMORY + "big_market_strategy_rate_table_key_";
        public static String STRATEGY_RATE_RANGE_KEY = RedisPrefix.STRATEGY_ARMORY + "big_market_strategy_rate_range_key_";
        public static String RULE_TREE_VO_KEY = RedisPrefix.STRATEGY_RULE_TREE + "rule_tree_vo_key_";
        public static String STRATEGY_AWARD_COUNT_KEY = RedisPrefix.STRATEGY_ARMORY + "strategy_award_count_key_";
        public static String STRATEGY_AWARD_COUNT_QUEUE_KEY = RedisPrefix.STRATEGY_CONSUME_QUEUE + "strategy_award_count_queue_key";

        public static String ACTIVITY_SKU_COUNT_QUEUE_KEY = RedisPrefix.ACTIVITY_SKU + "activity_sku_count_queue_key";
        public static String ACTIVITY_SKU_STOCK_COUNT_KEY = RedisPrefix.ACTIVITY_SKU + "activity_sku_stock_count_key_";

    }
}
