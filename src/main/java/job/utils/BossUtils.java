package job.utils;

/**
 * Created by xiaoyue26 on 17/9/30.
 */
public class BossUtils {

    public static String getBossStatus() {
        String sql = "SELECT a.*\n" +
                "      ,b.id as player_id\n" +
                "      ,b.command as thread_cmd\n" +
                "      ,b.cur_job\n" +
                "      ,b.done_job_json\n" +
                "      ,b.create_time\n" +
                "      ,b.update_time\n" +
                "FROM boss_config AS a\n" +
                "JOIN player_config AS b\n" +
                "  ON a.id=b.boss_id\n" +
                "AND a.status!='done'\n" +
                "ORDER BY a.create_time,b.create_time";


        return null;
    }

}
