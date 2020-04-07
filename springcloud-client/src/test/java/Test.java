/**
 * @auther:zh
 * @date:2020/3/19
 */

public class Test {


    public static void main(String[] args) {
        Test t = new Test();
        t.testAll();

    }

    public void testAll() {
//        Integer total = 0;
//        int yu = total % 5;
        for (int i = 26; i < 10000; i++) {
            boolean a = test(i, 1);
            if (a) {
                System.out.println(i);
            }
  /*          int yu = i % 5;
            int total = i;
            if (yu == 1) {
                int yu2 = (total - total / 5 - 1) % 5;
                total = (total - total / 5 - 1);
                if (yu2 == 1) {
                    int yu3 = (total - total / 5 - 1) % 5;
                    total = (total - total / 5 - 1);
                    if (yu3 == 1) {
                        int yu4 = (total - total / 5 - 1) % 5;
                        total = (total - total / 5 - 1);
                        if (yu4 == 1) {
                            int yu5 = (total - total / 5 - 1) % 5;
                            if (yu5 == 1) {
                                System.out.println(i);
                            }
                        }
                    }
                }
            }*/
        }
    }

    public boolean test(int total, int times) {

        int yu = total % 5;
        if (times == 5) {
            if (yu == 1) {
                return true;
            } else {
                return false;
            }
        } else {
            if (yu == 1) {
                times++;
                return test(total - total / 5 - 1, times);
            } else {
                return false;
            }
        }
    }
}
