import Lesson_6.Methods;
import org.junit.*;

public class MethodsTest {
    Methods methods;

    @Before
    public void init() {
        System.out.println("init");
        methods = new Methods();
    }

    //  Вариант через assertArrayEquals
    @Test
    public void testMethods1() {
        int[] ar1 = {1, 3, 4, 5, 6, 8, 3, 5, 4, 1};
        int[] res1 = {1};
        Assert.assertArrayEquals(res1, methods.conTrim(ar1));
    }

    @Test
    public void testMethods2() {
        int[] ar1 = {0, 3, 4, 5, 6, 8, 3, 5, 3, 1};
        int[] res1 = {5, 6, 8, 3, 5, 3, 1};
        Assert.assertArrayEquals(res1, methods.conTrim(ar1));
    }

    //  Вариант через assertEquals
    @Test
    public void testMethods3() {
        int[] ar1 = {0, 3, 6, 5, 4, 8, 3, 5, 3, 1};
        int[] res1 = {8, 3, 5, 3, 1};
        Assert.assertArrayEquals(res1, methods.conTrim(ar1));
    }

    //  Проверка на ошибку
    @Test(expected = RuntimeException.class)
    public void testCalcDiv() {
        int[] ar1 = {0, 3, 6, 5, 1, 8, 3, 5, 3, 1};
        Assert.assertEquals(0, methods.conTrim(ar1));
    }

    @After
    public void shutdown() {
        System.out.println("end");
    }

}