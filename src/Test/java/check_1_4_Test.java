
import Lesson_6.Methods;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class check_1_4_Test {
    Methods methods;

    private int[] aa;
    private boolean flag;

    @Parameterized.Parameters
    public static Collection<Object []> data() {
        int[] a1 = {1,1,4,1};
        int[] a2 = {4,1,4,1};
        int[] a3 = {4,1,4,4,4,1,4,1};
        int[] a4 = {4,1};
        int[] a5 = {1,1,4,3,1};
        int[] a6 = {1,2,3,1};
        int[] a7 = {1};
        int[] a8 = {0};
        int[] a9 = {1,1,1,1,1};
        int[] a10 = {};

        return Arrays.asList(new Object[][] {
                {a1,true},
                {a2,true},
                {a3,true},
                {a4,true},
                {a5,false},
                {a6,false},
                {a7,true},
                {a8,false},
                {a9,true},
                {a10,false}
        });
    }

    public check_1_4_Test(int [] aa, boolean flag) {
        this.aa = aa;
        this.flag = flag;
    }

    @Test
    public void massTestAdd() {
        System.out.println("Start");
        Assert.assertEquals(flag, methods.check_1_4(aa));
        System.out.println("End");
    }

    @Before
    public void init() {
        methods = new Methods();
    }

}
