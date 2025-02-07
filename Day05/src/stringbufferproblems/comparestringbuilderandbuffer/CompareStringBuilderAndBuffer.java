package stringbufferproblems.comparestringbuilderandbuffer;

public class CompareStringBuilderAndBuffer {
    public static void main(String[] args) {
        String str= "hello";
        StringBuffer stringBuffer= new StringBuffer();
        long startTime= System.nanoTime();
        for(int i=0; i<1000000; i++){
            stringBuffer.append(str);
        }
        long endTime= System.nanoTime();
        System.out.println("Total Time taken by StringBuffer is: " + (endTime-startTime));

        StringBuilder stringBuilder= new StringBuilder();
        startTime= System.nanoTime();
        for(int i=0; i<1000000; i++){
            stringBuilder.append(str);
        }
        endTime= System.nanoTime();
        System.out.println("Total Time taken by StringBuilder is: " + (endTime-startTime));
    }
}
