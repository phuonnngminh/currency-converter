class ArrayManipulationAndMissingNumberProblem {

    public int findTheMissingNumber(int[] array) {
        int n = array.length + 1;
        int sum = n * (n + 1) / 2;
        for (int num : array) {
            sum -= num;
        }
        return sum;
    }

    public static void main(String[] args) {
        ArrayManipulationAndMissingNumberProblem problem = new ArrayManipulationAndMissingNumberProblem();
        int[] array = {3, 7, 1, 2, 6 ,4};
        int missingNumber = problem.findTheMissingNumber(array);
        System.out.println("The missing number is: " + missingNumber);
        
    }
}
