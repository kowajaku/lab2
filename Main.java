package com.company;

public class Main {

    public static void main(String[] args) {
        double[][] t={{2,1}, {-1,4}};
        Matrix A=new Matrix(t);


        Matrix B=new Matrix(new double[][] {{1,3},{-2,0},{5,-3}});
        System.out.println(A.toString());
        System.out.println(B.toString());

        /*Matrix C=A.mul(B);
        System.out.println(C.toString());
        Matrix D=A.mul(B);
        System.out.println(D.toString());
        A.frobenius();*/
        /*Matrix r = Matrix.random(3,3);
        System.out.println(r.toString());*/
        Matrix a=Matrix.eye(2);
        System.out.println(a.toString());
        //System.out.println();
        //A.transposition();
        //System.out.println(A.toString());
        //A.sub(10);
        //System.out.println(A.toString());
        //A.add(100);
        //System.out.println(A.toString());*/
        //A.mul(2);
        //System.out.println(A.toString());
        //A.div(2);
        //System.out.println(A.toString());*/
        //A.dot(B);
        //System.out.println(A.toString());

        System.out.println(A.div(B));
    }
}
