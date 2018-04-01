// Queens.java
// Jia-hui Ma
// jma289
// pa5
// takes user input and prints out solutions to the n-queens problem


class Queens{

   public static void main( String[] args ){
     int[] board;
     int x, solutioncounter;
     long y;
     x = 0;
     solutioncounter = 0;
     boolean verbose = false;

     if (args.length<1 || args.length>2) {
       Usage();
     }
     else if (args.length==1) {
       verbose = false;
       try {
         x = Integer.parseInt(args[0]);
       }
       catch (NumberFormatException e) {
         Usage();
       }
     }
     else {
       try {
         x = Integer.parseInt(args[1]);
       }
       catch (NumberFormatException e) {
         Usage();
       }
       if (args[0].equals("-v")) {
       verbose = true;
       }
       else {
         Usage();
       }
     }

     board = new int[x+1];
     for (int i=1; i<=x; i++) {
       board[i] = i;
     }
     y = factorial(x);
     for (long i=0; i<y; i++) {
       if (isSolution(board)) {
         solutioncounter++;
         if (verbose) {
           printArray(board);
         }
       }
       nextPermutation(board);
     }
     System.out.println(x + "-Queens has " + (solutioncounter) + " solutions");
   }


   static int factorial(int n){
     int f = 1;
     for (int i=1; i<=n; i++) {
       f*=i;
     }
     return f;
   }

   static void nextPermutation (int[] A) {
     int pivot, j, successor;
     pivot = 0;
     j = A.length-1;
     successor = 0;
     for (int i=A.length-2; i>=1; i--) {
       if (A[i]<A[i+1]) {
         pivot = i;
         break;
       }
     }
     if (pivot==0) {
       reverse(A, 1);
       return;
     }
     for (int i=A.length-1; i>1; i--) {
       if (A[i]>A[pivot]) {
         successor = i;
         break;
       }
     }
     swap(A, pivot, successor);
     reverse(A, pivot+1);
     return;
   }

   static void reverse(int[] A, int pivot){
     int i, j;
     i = pivot;
     j = A.length-1;
     while (i<j) {
       swap(A, i, j);
       i++;
       j--;
     }
     return;
   }

   static void printArray (int[] A) {
     System.out.print("(");
     for (int i=1; i<A.length; i++) {
       if (i==A.length-1) {
         System.out.print(A[i]);
       }
       else {
         System.out.print(A[i] + ", ");
       }
     }
     System.out.println(")");
   }

   static void swap (int[]A, int x, int y) {
     int temp;
     temp = A[x];
     A[x] = A[y];
     A[y] = temp;
   }

   static void Usage () {
     System.err.println("Usage: Queens [-v] number");
     System.out.println("Option: -v verbose output, print all solutions");
     System.exit(1);
   }

   static boolean isSolution (int[] A) {
     int n = A.length;
     for (int i=1; i<n-1; i++) {
       for (int j=i+1; j<n; j++) {
         if (Math.abs(j-i)==Math.abs(A[i]-A[j])) {
           return false;
         }
       }
     }
     return true;
   }
}

