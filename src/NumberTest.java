import static org.junit.jupiter.api.Assertions.*;

class NumberTest {

    private Number number;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {

    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        number = null;
    }

    @org.junit.jupiter.api.Test
    void getDenary() {
        number = new Number(68);
        assertEquals(68, number.getDenary());
        number = new Number(-68);
        assertEquals(-68, number.getDenary());
    }

    @org.junit.jupiter.api.Test
    void setDenary() {
        number = new Number(68);
        number.setDenary(-68);
        assertEquals(-68, number.getDenary());
    }

    @org.junit.jupiter.api.Test
    void getSignedBinaryPositive() {
        number = new Number(68);
        assertEquals("01000100", number.getSignedBinary());
    }

    @org.junit.jupiter.api.Test
    void getSignedBinaryNegative() {
        number = new Number(-68);
        assertEquals("10111100", number.getSignedBinary());
    }

    @org.junit.jupiter.api.Test
    void getHexadecimalPositive() {
        number = new Number(68);
        assertEquals("44", number.getHexadecimal());
    }

    @org.junit.jupiter.api.Test
    void getHexadecimalNegative() {
        number = new Number(-68);
        assertEquals("BC", number.getHexadecimal());
    }

    @org.junit.jupiter.api.Test
    void testToStringPositive() {
        number = new Number(68);
        assertEquals("Number{denary=68 binary=01000100 hexadecimal=44}", number.toString());
    }

    @org.junit.jupiter.api.Test
    void testToStringPositiveTwo() {
        number = new Number(148);
        assertEquals("Number{denary=148 binary=010010100 hexadecimal=94}", number.toString());
    }

    @org.junit.jupiter.api.Test
    void testToStringNegative() {
        number = new Number(-68);
        assertEquals("Number{denary=-68 binary=10111100 hexadecimal=BC}", number.toString());
    }

    @org.junit.jupiter.api.Test
    void testToStringNegativeTwo() {
        number = new Number(-148);
        assertEquals("Number{denary=-148 binary=101101100 hexadecimal=16C}", number.toString());
    }

//    @org.junit.jupiter.api.Test
//    void testNegatePositive() {
//        number = new Number(68);
//        number.negate();
//        assertEquals("Number{denary=-68 binary=10111100 hexadecimal=BC}", number.toString());
//    }
//
//    @org.junit.jupiter.api.Test
//    void testNegateNegative() {
//        number = new Number(-68);
//        number.negate();
//        assertEquals("Number{denary=68 binary=01000100 hexadecimal=44}", number.toString());
//    }

}