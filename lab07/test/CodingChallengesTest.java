import org.antlr.v4.runtime.tree.Tree;
import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assertWithMessage;

public class CodingChallengesTest {

    @Test
    public void testMissingNumber() {
        int[] array1 = {0, 1, 3, 4, 5};
        assertThat(CodingChallenges.missingNumber(array1)).isEqualTo(2);

        int[] array2 = {2, 3, 0, 1, 5};
        assertThat(CodingChallenges.missingNumber(array2)).isEqualTo(4);
    }

    @Test
    public void testIsPermutation() {
	    String s1 = "caonimabi";
        String s2 = "nimacaobi";
        assertThat(CodingChallenges.isPermutation(s1, s2)).isEqualTo(true);

        String s3 = "wocaonima";
        assertThat(CodingChallenges.isPermutation(s1, s3)).isEqualTo(false);

        String s4 = "caocaocaocaocao";
        String s5 = "caonimibi";

        assertThat(CodingChallenges.isPermutation(s1, s4)).isEqualTo(false);
        assertThat(CodingChallenges.isPermutation(s1, s5)).isEqualTo(false);
    }
}
