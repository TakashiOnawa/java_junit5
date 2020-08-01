package tddbc;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ClosedRangeTest {

    @Nested
    public class 整数閉区間オブジェクトは下端点が上端点以下の閉区間を作ることができる {
        @Test
        public void 下端点が1で上端点が1の閉区間オブジェクトは生成できる() {
            // 実行、検証
            assertNotNull(new ClosedRange(1, 1));
        }

        @Test
        public void 下端点が1で上端点が2の閉区間オブジェクトは生成できる() {
            // 実行、検証
            assertNotNull(new ClosedRange(1, 2));
        }

        @Test
        public  void 下端点が2で上端点が1の閉区間オブジェクトは生成できない() {
            // 実行、検証
            assertThrows(IllegalArgumentException.class, () -> {
                new ClosedRange(2, 1);
            });
        }
    }

    @Nested
    public class 数閉区整間オブジェクトは指定した整数を含むかどうかを判定できる {

        private ClosedRange closedRange;

        @BeforeEach
        public void beforeEach () {
            closedRange = new ClosedRange(1, 2);
        }

        @Test
        public void 下端点が1で上端点が2の閉区間オブジェクトは0を含まない() {
            // 実行、検証
            assertFalse(closedRange.in(0));
        }

        @Test
        public void 下端点が1で上端点が2の閉区間オブジェクトは1を含む() {
            // 実行、検証
            assertTrue(closedRange.in(1));
        }

        @Test
        public void 下端点が1で上端点が2の閉区間オブジェクトは2を含む() {
            // 実行、検証
            assertTrue(closedRange.in(2));
        }

        @Test
        public void 下端点が1で上端点が2の閉区間オブジェクトは3を含まない() {
            // 実行、検証
            assertFalse(closedRange.in(3));
        }
    }

    @Nested
    public class 整数閉区間オブジェクトは別の整数閉区間オブジェクトと等価かどうか判定できる {

        private ClosedRange closedRange;

        @BeforeEach
        public void beforeEach () {
            closedRange = new ClosedRange(1, 2);
        }

        @Test
        public void 下端点が1で上端点が2の閉区間オブジェクトは下端点が1で上端点が2の閉区間オブジェクトと等価である() {
            // 実行、検証
            assertTrue(closedRange.equals(new ClosedRange(1, 2)));
        }

        @Test
        public void 下端点が1で上端点が2の閉区間オブジェクトは下端点が1で上端点が1の閉区間オブジェクトと等価ではない() {
            // 実行、検証
            assertFalse(closedRange.equals(new ClosedRange(1, 1)));
        }
    }

    @Nested
    public class 整数閉区間オブジェクトは文字列表現を返せる {
        @Test
        public void 下端点が1で上端点が2の閉区間オブジェクトは文字列表現を返す() {
            ClosedRange closedRange = new ClosedRange(1, 2);
            // 実行、検証
            assertEquals("[1,2]", closedRange.toString());
        }
    }

    @Test
    public void 下端点が1で上端点が4の閉区間オブジェクトは下端点が2で上端点が3の閉区間オブジェクトを含む() {
        // 準備
        ClosedRange closedRange = new ClosedRange(1, 4);
        // 実行、検証
        assertTrue(closedRange.in(new ClosedRange(2, 3)));
    }

    @Test
    public void 下端点が1で上端点が4の閉区間オブジェクトは下端点が1で上端点が4の閉区間オブジェクトを含む() {
        // 準備
        ClosedRange closedRange = new ClosedRange(1, 4);
        // 実行、検証
        assertTrue(closedRange.in(new ClosedRange(1, 4)));
    }

    @Test
    public void 下端点が1で上端点が4の閉区間オブジェクトは下端点が0で上端点が4の閉区間オブジェクトを含まない() {
        // 準備
        ClosedRange closedRange = new ClosedRange(1, 4);
        // 実行、検証
        assertFalse(closedRange.in(new ClosedRange(0, 4)));
    }

    @Test
    public void 下端点が1で上端点が4の閉区間オブジェクトは下端点が1で上端点が5の閉区間オブジェクトを含まない() {
        // 準備
        ClosedRange closedRange = new ClosedRange(1, 4);
        // 実行、検証
        assertFalse(closedRange.in(new ClosedRange(0, 5)));
    }
}
