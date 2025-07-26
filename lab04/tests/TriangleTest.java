import org.junit.Rule;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.concurrent.TransferQueue;

import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assertWithMessage;
public abstract class TriangleTest {

    /** For autograding purposes; do not change this line. */
    abstract Triangle getNewTriangle();

    /* ***** TESTS ***** */

    // FIXME: Add additional tests for Triangle.java here that pass on a
    //  correct Triangle implementation and fail on buggy Triangle implementations.

    @Test
    public void test1() {
        // TODO: stub for first test
        Triangle t = getNewTriangle();
        boolean actual;

        actual = t.sidesFormTriangle(1, 1, 1);
        assertThat(actual).isEqualTo(true);

        actual = t.sidesFormTriangle(3, 4, 5);
        assertThat(actual).isEqualTo(true);

        actual = t.sidesFormTriangle(1, 2, 1);
        assertThat(actual).isEqualTo(false);

        actual = t.sidesFormTriangle(1, 3, 1);
        assertThat(actual).isEqualTo(false);

        actual = t.sidesFormTriangle(1, 1, 2);
        assertThat(actual).isEqualTo(false);

        actual = t.sidesFormTriangle(1, 1, 3);
        assertThat(actual).isEqualTo(false);

        actual = t.sidesFormTriangle(2, 1, 1);
        assertThat(actual).isEqualTo(false);

        actual = t.sidesFormTriangle(3, 1, 1);
        assertThat(actual).isEqualTo(false);

        // remember that you'll have to call on Triangle methods like
        // t.functionName(arguments), where t is a Triangle object

    }

    @Test
    public void test2() {
        Triangle t = getNewTriangle();
        boolean actual;

        actual = t.pointsFormTriangle(0, 0, 1, 0, 0, 1);
        assertThat(actual).isEqualTo(true);

        actual = t.pointsFormTriangle(0, 0, 3, 0, 1, 1);
        assertThat(actual).isEqualTo(true);

        actual = t.pointsFormTriangle(0, 0, 1, 0, 2, 0);
        assertThat(actual).isEqualTo(false);

        actual = t.pointsFormTriangle(0, 0, 0, 3, 0, 1);
        assertThat(actual).isEqualTo(false);

        actual = t.pointsFormTriangle(0, 0, 3, 3, 1, 1);
        assertThat(actual).isEqualTo(false);
    }

    @Test
    public void test3() {
        Triangle t = getNewTriangle();
        String actual;

        actual = t.triangleType(1, 2, 3);
        assertThat(actual).isEqualTo("Scalene");

        actual = t.triangleType(5, 6, 2);
        assertThat(actual).isEqualTo("Scalene");

        actual = t.triangleType(4, 5, 3);
        assertThat(actual).isEqualTo("Scalene");

        actual = t.triangleType(5, 5, 11);
        assertThat(actual).isEqualTo("Isosceles");

        actual = t.triangleType(6, 4, 4);
        assertThat(actual).isEqualTo("Isosceles");

        actual = t.triangleType(2, 3, 3);
        assertThat(actual).isEqualTo("Isosceles");

        actual = t.triangleType(4, 4, 4);
        assertThat(actual).isEqualTo("Equilateral");

        actual = t.triangleType(3, 3, 3);
        assertThat(actual).isEqualTo("Equilateral");

    }

    @Test
    public void test4() {
        Triangle t = getNewTriangle();
        int actual;

        actual = t.squaredHypotenuse(2, 3);
        assertThat(actual).isEqualTo(13);

        actual = t.squaredHypotenuse(3, 3);
        assertThat(actual).isEqualTo(18);

        actual = t.squaredHypotenuse(4, 3);
        assertThat(actual).isEqualTo(25);

    }
}
