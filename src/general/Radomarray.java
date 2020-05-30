package general;
import java.util.ArrayList;
import java.util.Collections;
public class Radomarray {

        public static int[] random(int num, int select) {
            ArrayList<Integer> list = new ArrayList<Integer>();

            // listに値を入れる。この段階では昇順
            for(int i = 0 ; i <= num ; i++) {
                list.add(i);
            }

            // シャッフルして、順番を変える
            Collections.shuffle(list);

            // シャッフルした結果を表示させる

            int[] sel = new int[select];
            for (int i = 0; i<select; i++) {
            	sel[i] = list.get(i);
            }
            return sel;
        }


}
