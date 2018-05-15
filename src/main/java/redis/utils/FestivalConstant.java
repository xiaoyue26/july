package redis.utils;

/**
 * Created by xiaoyue26 on 18/1/9.
 */
public interface FestivalConstant {
    //获得活动某一天的签到信息
    String SIGNIN_DATE_FORD = "SIGNIN_DATE_FORD";
    String SIGNUP = "SIGNUP";
    //获得某用户在指定活动中的签到情况
    String SIGNIN_DATE_FORU = "SIGNIN_DATE_FORU";
    String ANSQUESTION = "ANSQUESTION";
    String GROWTH = "GROWTH";
    int BEGIN_INDEX = 0;//最后一个的id

    int BEGINNUM = 0;//
    int LIMIT = 4;//一页中包含的消息数量

    int PHASE_CHUZHONG = 1;
    int PHASE_GAOZHONG = 2;

    long DEFALUTDATE = 0;

    int FESTIVAL_AVAILABLE = 1;

    int LRU_CACHE_SIZE = 10000;
    int TTL = 60;

    int SEVENDAY = 604800;

    String QUESTION_RULE_NAME = "Question";
    String GROWTH_RULE_NAME = "growth";
    String LEADER_PATH = "/ape-rush-festival/leader";
    int AWARD_AVAILABLE = 0;
}
