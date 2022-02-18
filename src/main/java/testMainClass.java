
public class testMainClass {

    public static void main(String[] args) {
        short a = 16968;
        short b = 5243;
        long c = ((a & 0xFFFF) << 16 | (b & 0xFFFF));
        //((bb.getShort() & 0xFFFF) << 16) | (bb.getShort() & 0xFFFF);
        //changes for test
        System.out.println("INT IS : " + c);
        System.out.println("TEST");
    }

}
