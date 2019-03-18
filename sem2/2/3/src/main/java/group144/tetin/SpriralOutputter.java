package group144.tetin;

/** Class represents spiral writer as string */
abstract class SpriralOutputter {
    public String getPrintSpiral(int[][] matrix){
        String answer = "";
        int num = matrix.length;
        int step = 0;
        int index1 = num / 2;
        int index2 = num / 2;
        answer += matrix[index1][index2] + " ";

        while (index1 != 0 || index2 != num - 1) {
            step++;
            for (int j = 0; j < step; j++) {
                index2--;
                answer += matrix[index1][index2] + " ";
            }

            for (int j = 0; j < step; j++) {
                index1++;
                answer += matrix[index1][index2] + " ";
            }

            step++;
            for (int j = 0; j < step; j++) {
                index2++;
                answer += matrix[index1][index2] + " ";
            }

            for (int j = 0; j < step; j++) {
                index1--;
                answer += matrix[index1][index2] + " ";
            }
        }

        for (int j = 0; j < step; j++) {
            index2--;
            answer += matrix[index1][index2] + " ";
        }

        return answer;
    }

}