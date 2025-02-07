package linearsearch.searchfirstnegativenumber;

public class SearchFirstNegativeNumber {
    public static void main(String[] args) {
        int[] array= {1,2,1,-4,-5};
        int index= search(array);
        if(index==-1){
            System.out.println("Negative Number not found in the given array");
        }
        else {
            System.out.println("First negative number found at this index: " + index);
        }
    }
    private static int search(int[] arr){
        int length= arr.length;
        for(int i=0; i<length; i++){
            if(arr[i]<0){
                return i;
            }
        }
        return -1;
    }
}
