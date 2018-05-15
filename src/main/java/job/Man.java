package job;

import job.utils.BossUtils;
import job.utils.StatusUtils;

import java.util.Scanner;

import static java.lang.System.out;

/**
 * Created by xiaoyue26 on 17/9/30.
 */
public class Man {
    public static void println(String line) {
        System.out.println(line);
    }

    public static void println() {
        System.out.println();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String line;
        while (true) {
            System.out.println("waiting your cmd :");
            line = sc.nextLine();
            switch (line) {
                case "status":
                    println(StatusUtils.getBossStatus());
                    break;
                case "":
                    break;
                case "exit":
                    return;
                default:
                    System.out.println("unknown cmd :" + line);
            }


        }

    }
}
