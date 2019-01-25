package base;

import java.util.UUID;

/**
 * Created By Intellij IDEA
 *
 * @Author PercyG
 * @Since 2019/1/25
 * Description:
 * Modified:
 */
public class UuidDemo {
    public static void main(String[] args) {
        for(int i = 0; i < 3; i++){
            String uuid = UUID.randomUUID().toString();
            System.out.println(uuid);
            System.out.println(uuid.replaceAll("-", ""));
        }
    }
}
