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
                    new double[][]{{1, 2, 3}, {5, 6, 7}, {9, 10, 11}},
                    matrix1.asArray()
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
    public void shape() {
        Matrix A=new Matrix(1,1);

        assertArrayEquals(new int[]{1, 1}, A.shape());
        assertArrayEquals(new int[]{3,3}, matrix1.shape());
        assertArrayEquals(new int[]{3,3}, matrix2.shape());

    }

    @Test
    public void add() {
        Matrix A=new Matrix(new double[][]{{5,5,5}, {5,5,5}, {5,5,5}});
        Matrix B=new Matrix(new double[][]{{5,5,5}, {5,5,5}, {5,5,5}});
        A.add(B);
        assertArrayEquals(
                new double[][]{{10,10,10}, {10,10,10}, {10,10,10}},
                A.matrix
        );

    }

    @Test
    public void sub() {
        Matrix A=new Matrix(new double[][]{
                {1, 2, 3},
                {5, 6, 7},
                {9, 10, 11},
        });
        A.sub(matrix1);

        assertArrayEquals(

                new double[][]{{0,0,0},{0,0,0},{0,0,0}},
                A.asArray()
                //matrix1.sub(matrix2).asArray()
        );
        /*assertArrayEquals(
                new double[][]{{1,1}, {1,1}},
                matrix1.asArray()
                //matrix2.sub(matrix1).asArray()
        );*/
    }

    @Test
    public void mul() {
        Matrix A=new Matrix(new double[][]{
                {1, 1, 1},
                {1, 1, 1},
                {1, 1, 1},
        });
        Matrix B=new Matrix(new double[][]{
                {1, 1, 1},
                {1, 1, 1},
                {1, 1, 1},
        });
        //A.mul(B);
        assertArrayEquals(
          new double [][]{{3,3,3},{3,3,3},{3,3,3}},
          A.mul(B).asArray()

        );


    }

    @Test
    public void transposition() {
        Matrix B=new Matrix(new double[][]{
                {1, 1, 1},
                {1, 1, 1},

        });
        B.transposition();
        assertArrayEquals(
                new double[][]{{1,1},{1,1},{1,1}},
                B.asArray()

        );





    }

    @Test
    public void testSub() {
        Matrix B=new Matrix(new double[][]{
                {1, 1, 1},
                {1, 1, 1},

        });
        assertArrayEquals(
               new double[][]{{0,0,0},{0,0,0}},
                (B.sub(1)).asArray()
        );

    }

    @Test
    public void testAdd() {
        Matrix B=new Matrix(new double[][]{
                {1, 1, 1},
                {1, 1, 1},

        });
        assertArrayEquals(
                new double[][]{{2,2,2},{2,2,2}},
                B.add(1).asArray()
        );
    }

    @Test
    public void testMul() {
        Matrix B=new Matrix(new double[][]{
                {1, 1, 1},
                {1, 1, 1},

        });
        assertArrayEquals(
                new double[][]{{2,2,2},{2,2,2}},
                B.mul(2).asArray()
        );
    }

    @Test
    public void div() {
        Matrix B=new Matrix(new double[][]{
                {4, 4, 4},
                {4, 4, 4},

        });
        assertArrayEquals(
                new double[][]{{2,2,2},{2,2,2}},
                B.div(2).asArray()
        );
    }

    @Test
    public void dot() {
        Matrix A=new Matrix(new double[][]{
                {4, 4},
                {4, 4},
                {4, 4},

        });
        Matrix B=new Matrix(new double[][]{
                {4, 4, 4},
                {4, 4, 4},

        });
        assertArrayEquals(
                new double[][]{{32,32},{32,32},{32,32}},
                A.dot(B).asArray()
        );
    }

    @Test
    public void frobenius() {
        Matrix B=new Matrix(new double[][]{
                {1, 1, 1},
                {1, 1, 1},

        });
        assertEquals(
                6.0,
                B.frobenius(),
                0.0
        );

    }
    @Test
    public void eye()
    {

        Matrix B=new Matrix(new double[][]{
                {2, 0},
                {0, 2},

        });
        assertArrayEquals(
                new double[][]{{1,0},{0,1}},
                B.eye(2).asArray()

        );
    }
    @Test
    public void test_dot() {
        Matrix A = new Matrix(new double[][]{
                {1, 1, 1},
                {1, 1, 1},
                {1, 1, 1},
        });
        Matrix B = new Matrix(new double[][]{
                {1, 1, 1},
                {1, 1, 1},
                {1, 1, 1},
        });
        assertArrayEquals(
                new double[][]{{3,3,3}, {3,3,3}, {3,3,3}},
                A.dot(B).asArray()
        );
    }


}

