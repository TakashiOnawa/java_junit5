package tddbc;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ClosedRangeTest {

    @Test
    public void 上端点が1で下端点が1の閉区間オブジェクトは生成できる() {
        ClosedRange actual = new ClosedRange(1, 1);
        // 検証
        assertNotNull(actual);
    }

    @Test
    public  void 上端点が1で下端点が2の閉区間オブジェクトは生成できない() {
        // 検証
        assertThrows(IllegalArgumentException.class, () -> {
            new ClosedRange(2, 1);
        });
    }
}
