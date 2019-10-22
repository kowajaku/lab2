package com.company;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;
public class MatrixTest {
    private Matrix matrix1 = new Matrix(new double[][]{
            {1, 2, 3},
            {5, 6, 7},
            {9, 10, 11},
    });
    private Matrix matrix2 = new Matrix(new double[][]{
            {13, 14, 15},
            {17, 18, 19},
            {21, 22, 23},
    });
    @Test
    public void asArray() {
        assertArrayEquals(
                new double[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}},
                matrix1.asArray()
                //matrix2.asArray()


        );
    }

    @Test
    public void get() {
        assertEquals(7.0, matrix1.get(1, 2),2);
        assertEquals(23,matrix2.get(2,2),2);

    }

    @Test
    public void set() {
        assertEquals(7.0, matrix1.get(1, 2),2);
        matrix1.set(1, 2, 5);
        assertEquals(5.0, matrix1.get(1, 2),2);
        matrix2.set(2,2,5);
        assertEquals(5.0,matrix2.get(2,2),2);
        matrix2.set(3,3,5);
        assertEquals(3,matrix2.get(3,3),5);


    }

    @Test
    public void testToString() {
        String s= "[[1.0,2.3,4.56], [12.3,  45, 21.8]]";
        s= s.replaceAll("(\\[|\\]|\\s)+","");
        String[] t = s.split("(,)+");
        for(String x:t){
            System.out.println(String.format("\'%s\'",x ));
        }

        double[]d=new double[t.length];
        for(int i=0;i<t.length;i++) {
            d[i] = Double.parseDouble(t[i]);
        }

        double arr[][]=new double[1][];
        arr[0]=d;

        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                System.out.println(arr[i][j]);
            }
        }
    }

    @Test
    public void reshape() {
        assertEquals(3, matrix1.asArray().length);
        matrix1.asArray();
        matrix1.reshape(3, 3);
        assertEquals(3, matrix1.asArray().length);
        //fail("To nie dziala");
    }
    @Test
    public void reshape2()
    {
        assertEquals(3,matrix2.asArray().length);
        matrix2.asArray();
        matrix2.reshape(3,3);
        assertEquals(3,matrix2.asArray().length);
        //fail("To nie dziala");
    }

    @Test
    public void shape() {
        assertArrayEquals(new int[]{1, 1}, new Matrix(1, 1).shape());
        //assertArrayEquals(new int[]{2, 2}, matrix1.shape());
        //assertArrayEquals(new int[]{2,3}, matrix1.shape());
        //assertArrayEquals(new int[]{1,3}, matrix1.shape());
        //assertArrayEquals(new int[]{2,2}, matrix1.shape());

    }

    @Test
    public void add() {
        /*assertArrayEquals(

                matrix1.add(matrix2).asArray(),
                matrix2.add(matrix1).asArray()
        );*/
        assertArrayEquals(
                new double[][]{{5,5,5}, {5,5,5}, {5,5,5}},
                matrix1.add(matrix2).asArray()
        );

    }

    @Test
    public void sub() {
        assertArrayEquals(
                new double[][]{{2,1},{2,2}},
                matrix1.asArray()
                //matrix1.sub(matrix2).asArray()
        );
        assertArrayEquals(
                new double[][]{{1,1}, {1,1}},
                matrix1.asArray()
                //matrix2.sub(matrix1).asArray()
        );
    }

    @Test
    public void mul() {
    }

    @Test
    public void transposition() {





    }

    @Test
    public void testSub() {
    }

    @Test
    public void testAdd() {
    }

    @Test
    public void testMul() {
    }

    @Test
    public void div() {
    }

    @Test
    public void dot() {
    }

    @Test
    public void frobenius() {
    }
}
