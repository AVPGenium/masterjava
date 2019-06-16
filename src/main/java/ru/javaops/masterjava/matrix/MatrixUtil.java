package ru.javaops.masterjava.matrix;

import com.sun.xml.internal.ws.api.FeatureListValidator;
import ru.javaops.masterjava.service.MailService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 * gkislin
 * 03.07.2016
 */
public class MatrixUtil {

    // TODO implement parallel multiplication matrixA*matrixB
    public static int[][] concurrentMultiply(int[][] matrixA, int[][] matrixB, ExecutorService executor) throws InterruptedException, ExecutionException {
        final int matrixSize = matrixA.length;
        final int[][] matrixC = new int[matrixSize][matrixSize];
        // для определения размера "куска" желательно знать максимальное физическое количество ядер/нитей на устройстве
        int slices = matrixSize/250 < 1 ? 1 : matrixSize/250;
        List<Future<Integer>> futures = new ArrayList<>();
        for (int slice = 0; slice < slices; slice++ )
        {
            int finalSlice = slice;
            futures.add(executor.submit(() -> {
                int[] bColumn = new int[matrixSize];
                // идем по столбцам матрицы B
                for (int i = finalSlice; i < matrixSize; i+=slices) {
                    //транспонирование столбца матрицы B в вектор
                    multRowOnColumn(matrixA, matrixB, matrixSize, matrixC, bColumn, i);
                }
                return finalSlice;
            }));
        }
        for (Future<Integer> future : futures) {
            Integer mailResult;
            try {
                mailResult = future.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        return matrixC;
    }

    //slow
    public static int[][] singleThreadMultiply2(int[][] matrixA, int[][] matrixB) {
        final int matrixSize = matrixA.length;
        final int[][] matrixC = new int[matrixSize][matrixSize];

        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                int sum = 0;
                for (int k = 0; k < matrixSize; k++) {
                    sum += matrixA[i][k] * matrixB[k][j];
                }
                matrixC[i][j] = sum;
            }
        }
        return matrixC;
    }

    // TODO optimize by https://habrahabr.ru/post/114797/
    public static int[][] singleThreadMultiply(int[][] matrixA, int[][] matrixB) {
        final int matrixSize = matrixA.length;
        final int[][] matrixC = new int[matrixSize][matrixSize];

        // для того, чтобы избежать считывания элементов матрицы B по столбцам - транспонируем ее (будем использовать кэш)
        // недостаток: много циклов. оптимизируем: транспонируем не всю матрицу, а столбы в том месте, где они конкретно нужны
//        double BT[][] = new double[matrixSize][matrixSize];
//        for (int i = 0; i < matrixSize; i++) {
//            for (int j = 0; j < matrixSize; j++) {
//                BT[j][i] = matrixB[i][j];
//            }
//        }

        // столбец матрицы B (который транспонируем)
        int[] bColumn = new int[matrixSize];
        // идем по столбцам матрицы B
        for (int i = 0; i < matrixSize; i++) {
            multRowOnColumn(matrixA, matrixB, matrixSize, matrixC, bColumn, i);
        }
        return matrixC;
    }

    private static void multRowOnColumn(int[][] matrixA, int[][] matrixB, int matrixSize, int[][] matrixC, int[] bColumn, int i) {
        //транспонирование столбца матрицы B в вектор
        for (int k = 0; k < matrixSize; k++) {
            bColumn[k] = matrixB[k][i];
        }
        // идем по строка матрицы A
        for (int j = 0; j < matrixSize; j++) {
            int[] aRow = matrixA[j];
            int sum = 0;
            for (int k = 0; k < matrixSize; k++) {
                sum += aRow[k] * bColumn[k];
            }
            matrixC[j][i] = sum; //?
        }
    }

    public static int[][] create(int size) {
        int[][] matrix = new int[size][size];
        Random rn = new Random();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = rn.nextInt(10);
            }
        }
        return matrix;
    }

    public static boolean compare(int[][] matrixA, int[][] matrixB) {
        final int matrixSize = matrixA.length;
        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                if (matrixA[i][j] != matrixB[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
