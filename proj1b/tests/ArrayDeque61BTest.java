import deque.ArrayDeque61B;

import deque.Deque61B;
import deque.LinkedListDeque61B;
import jh61b.utils.Reflection;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;

import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assertWithMessage;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ArrayDeque61BTest {

     @Test
     @DisplayName("ArrayDeque61B has no fields besides backing array and primitives")
     void noNonTrivialFields() {
         List<Field> badFields = Reflection.getFields(ArrayDeque61B.class)
                 .filter(f -> !(f.getType().isPrimitive() || f.getType().equals(Object[].class) || f.isSynthetic()))
                 .toList();

         assertWithMessage("Found fields that are not array or primitives").that(badFields).isEmpty();
     }

     @Test
    public void getTest() {
         ArrayDeque61B<Integer> arr = new ArrayDeque61B<>();
         assertThat(arr.size()).isEqualTo(0);
         assertThat(arr.isEmpty()).isTrue();

         arr.addFirst(0);
         arr.addFirst(7);
         arr.addFirst(6);
         arr.addLast(1);
         arr.addLast(2);

         assertThat(arr.isEmpty()).isFalse();
         assertThat(arr.get(-1)).isEqualTo(null);
         assertThat(arr.get(8888)).isEqualTo(null);
         assertThat(arr.size()).isEqualTo(5);

         assertThat(arr.get(0)).isEqualTo(6);
         assertThat(arr.get(1)).isEqualTo(7);
         assertThat(arr.get(2)).isEqualTo(0);
         assertThat(arr.get(arr.size() - 1)).isEqualTo(2);

     }

     @Test
    public void toListTest() {
         ArrayDeque61B<Integer> arr = new ArrayDeque61B<>();

         assertThat(arr.toList()).containsExactly().inOrder();

         arr.addLast(0);
         arr.addLast(1);
         arr.addLast(2);
         arr.addFirst(9);

         assertThat(arr.toList()).containsExactly(9, 0, 1, 2).inOrder();
         assertThat(arr.toList().toString()).isEqualTo("[9, 0, 1, 2]");
     }

     @Test
    public void removeTest() {
         ArrayDeque61B<Integer> arr = new ArrayDeque61B<>();
         arr.addFirst(0);
         arr.addFirst(7);
         arr.addFirst(6);
         arr.addLast(1);
         arr.addLast(2);

         assertThat(arr.removeFirst()).isEqualTo(6);
         assertThat(arr.removeFirst()).isEqualTo(7);

         assertThat(arr.toList()).containsExactly(0, 1, 2).inOrder();

         arr.removeLast();

         assertThat(arr.toList()).containsExactly(0, 1).inOrder();
     }

     @Test
    public void resizeUpTest() {
         ArrayDeque61B<Integer> arr = new ArrayDeque61B<>();
         arr.addLast(0);
         arr.addLast(1);
         arr.addLast(2);
         arr.addLast(3);
         arr.addLast(4);
         arr.addLast(5);
         arr.addLast(6);

         assertThat(arr.size()).isEqualTo(7);

         arr.addLast(7);
         arr.addLast(8);
         arr.addLast(9);
         arr.addFirst(10);
         arr.addFirst(11);
         arr.addFirst(12);

         assertThat(arr.size()).isEqualTo(13);

         assertThat(arr.get(0)).isEqualTo(12);
         assertThat(arr.get(arr.size() - 1)).isEqualTo(9);
     }

    @Test
    public void resizeDownTest() {
        ArrayDeque61B<Integer> arr = new ArrayDeque61B<>();
        arr.addLast(1);
        arr.addLast(1);
        arr.addLast(1);
        arr.addLast(1);
        arr.addLast(1);
        arr.addLast(1);
        arr.addLast(1);
        arr.addLast(1);
        arr.addLast(1);
        arr.addLast(1);
        arr.addLast(1);
        arr.addLast(1);
        arr.addLast(1);
        arr.addLast(1);
        arr.addLast(1);
        arr.addLast(1);
        arr.addLast(1);
        arr.addLast(1);
        arr.removeLast();
        arr.removeLast();
        arr.removeLast();
        arr.removeLast();
        arr.removeLast();
        arr.removeLast();
        arr.removeLast();
        arr.removeLast();
        arr.removeLast();
        arr.removeLast();
        arr.removeLast();
        arr.removeLast();
        arr.removeLast();
        arr.removeLast();
        arr.removeLast();
        arr.removeLast();
        arr.removeLast();
        arr.removeLast();
        assertThat(arr.size()).isEqualTo(0);
        arr.removeLast();
        assertThat(arr.size()).isEqualTo(0);
    }

     @Test
    public void iteratorTest() {
         Deque61B<Integer> arr = new ArrayDeque61B<>();
         Iterator<Integer> iterator = arr.iterator();

         assertThat(iterator.hasNext()).isFalse();

         arr.addLast(0);
         assertThat(iterator.hasNext()).isTrue();

         arr.addLast(1);
         iterator.next();
         assertThat(iterator.hasNext()).isTrue();
         iterator.next();
         assertThat(iterator.hasNext()).isFalse();

     }

    @Test
    public void testEqualDeques61B() {
        Deque61B<String> lld1 = new ArrayDeque61B<>();
        Deque61B<String> lld2 = new ArrayDeque61B<>();

        lld1.addLast("front");
        lld1.addLast("middle");
        lld1.addLast("back");

        lld2.addLast("front");
        lld2.addLast("middle");
        lld2.addLast("back");

        assertThat(lld1.equals(lld2)).isTrue();

        lld2.addLast("111");

        assertThat(lld1.equals(lld2)).isFalse();

        Deque61B<String> lld3 = new LinkedListDeque61B<>();
        lld3.addLast("front");
        lld3.addLast("middle");
        lld3.addLast("back");

        assertThat(lld1.equals(lld3)).isTrue();
    }

    @Test
    public void testToString() {
        Deque61B<String> lld1 = new ArrayDeque61B<>();

        lld1.addLast("front");
        lld1.addLast("middle");
        lld1.addLast("back");

        assertThat(lld1.toString()).isEqualTo("[front, middle, back]");
    }

    @Test
    public void testTriggerResizeAndAccess() {
        ArrayDeque61B<Integer> arr = new ArrayDeque61B<>();
        // 初始容量为8，isFull() 在 size==7 时扩容
        for (int i = 0; i < 100; i++) {
            arr.addLast(i);
        }
        // 检查所有元素是否都能正确访问
        for (int i = 0; i < 100; i++) {
            assertEquals(i, arr.get(i));
        }
    }

    @Test
    public void testAddRemoveAlternating() {
        ArrayDeque61B<Integer> arr = new ArrayDeque61B<>();
        // 连续 add/remove，反复触发扩容和收缩
        for (int round = 0; round < 20; round++) {
            for (int i = 0; i < 15; i++) {
                arr.addLast(i);
            }
            for (int i = 0; i < 15; i++) {
                assertEquals(i, arr.removeFirst());
            }
        }
        assertTrue(arr.isEmpty());
    }

    @Test
    public void testAddFirstResize() {
        ArrayDeque61B<Integer> arr = new ArrayDeque61B<>();
        // 连续 addFirst 触发多次扩容
        for (int i = 0; i < 50; i++) {
            arr.addFirst(i);
        }
        for (int i = 0; i < 50; i++) {
            assertEquals(49 - i, arr.get(i));
        }
    }

    @Test
    public void addAndRemoveTest() {
         Deque61B<Integer> arr = new ArrayDeque61B<>();
         arr.addLast(1);
         arr.addLast(1);
         arr.removeLast();
         arr.removeLast();
         arr.addFirst(1);
         arr.removeFirst();
    }
}
