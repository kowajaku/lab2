package com.company;

import java.util.Random;

public class Matrix {

    double[]data;
    int rows;
    int cols;
    double[][] matrix;

    Matrix(int rows, int cols){
        this.rows = rows;
        this.cols = cols;
        data = new double[rows*cols];
        matrix = new double[rows][];
        for(int i=0;i<rows;i++)
        {
            matrix[i]=new double[cols];//dowiazanie kolumn
        }

    }
    Matrix(double[][] d) {
        this.rows = d.length;
        this.cols = d[0].length;
        matrix = new double[rows][];
        for (int i = 0; i < rows; i++)
        {
            matrix[i] = new double[cols];
        }

        for (int i = 0; i < rows; i++) {
            matrix[i] = d[i];
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = d[i][j];
            }
        }
    }
    double[][] asArray()
    {
        return matrix;
    }
    double get(int r,int c)
    {
        if(r>0&&r<rows&&c>0&&c<cols) return matrix[r][c];//zwracanie a^rc
        return -1;
    }
    void set (int r,int c, double value)
    {
        if(r>0&&r<rows&&c>0&&c<cols)
        {
            this.matrix[r][c]=value;
        }
    }
    public String toString(){
        StringBuilder buf = new StringBuilder();
        buf.append("[");
        for(int i=0;i<rows;i++){
            buf.append("[");
            for(int j=0;j<cols;j++)
            {
                buf.append(matrix[i][j]);
                buf.append(" ");
            }
            buf.append("]\n");
        }
        buf.append("]");
        return buf.toString();
    }
    void reshape(int newRows,int newCols){
        if(rows*cols != newRows*newCols) {
            throw new RuntimeException(String.format("%d x %d matrix can't be reshaped to %d x %d", rows, cols, newRows, newCols));
        }
        double[][] matrix2=new double [newRows][];

        for (int i = 0; i < newRows; i++)
        {
            matrix2[i] = new double[newCols];
        }
        for(int i=0;i<cols;i++)
        {
            for(int j=0;j<rows;j++)
            {
                matrix2[i][j]=matrix[i][j];
            }
        }
        this.cols=newCols;
        this.rows=newCols;
        matrix=matrix2;
    }
    int[] shape()
    {
        int [] tab=new int [2];
        tab[0]=this.rows;
        tab[1]=this.cols;
        return tab;
    }
    Matrix add(Matrix m)
    {
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
            {
                matrix[i][j]+=m.matrix[i][j];
            }
        }
        return this;
    }
    Matrix sub(Matrix m)
    {
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
            {
                matrix[i][j]-=m.matrix[i][j];
            }
        }
        return this;
    }
    Matrix mul(Matrix m)
    {
        double[][] result=new double [rows][];
        for (int i = 0; i < rows; i++)
        {
            result[i] = new double[cols];
        }
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
            {
                result[i][j]=0;
            }
        }
        if(cols!=m.rows)return null;

        for(int i=0;i<rows;i++)
        {

            for(int j=0;j<cols;j++){

                for(int k=0;k<m.rows;k++)
                {
                    result[i][j]+=matrix[i][k]*m.matrix[k][j];
                }

            }

        }
        return new Matrix(result);
    }
    public void transposition()
    {
        double[][] result=new double [cols][];
        for (int i = 0; i < cols; i++)
        {
            result[i] = new double[rows];
        }
        for(int i=0;i<cols;i++)
        {
            for(int j=0;j<rows;j++)
            {
                result[i][j]=matrix[j][i];
            }

        }
        int tmp=this.rows;
        this.rows=this.cols;
        this.cols=tmp;
        matrix=result;
    }
    public Matrix div(Matrix m) {
        Matrix div = new Matrix(rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(m.get(i, j)==0) return null;
                div.set(i, j, this.get(i, j) / m.get(i, j));
            }
        }
        return div;
    }
    Matrix sub(double d) {

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] -= d;
            }
        }
        return this;
    }
    Matrix add(double d) {

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] += d;
            }
        }
        return this;
    }
    Matrix mul(double d) {
        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {
                matrix[i][j] = matrix[i][j] * d;
            }
        }
        return this;
    }
    Matrix div(double d)
    {
        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {
                matrix[i][j] = matrix[i][j] / d;
            }
        }
        return this;
    }
    Matrix dot(Matrix m)
    {
        double[][] result=new double [rows][];
        for (int i = 0; i < rows; i++)
        {
            result[i] = new double[cols];
        }
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
            {
                result[i][j]=0;
            }
        }
        if(cols!=m.rows)return null;

        for(int i=0;i<rows;i++)
        {

            for(int j=0;j<cols;j++){

                for(int k=0;k<m.rows;k++)
                {
                    result[i][j]+=matrix[i][k]*m.matrix[k][j];
                }

            }

        }
        return new Matrix(result);
    }


    public double frobenius() {
        double result=0;

        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
            {
                result+=matrix[i][j]*matrix[i][j];
            }
        }
        System.out.println(result);
        return result;


    }
    public static Matrix random(int rows, int cols){
        Matrix m = new Matrix(rows,cols);
        Random r = new Random();

        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
            {
                m.set(i,j,r.nextDouble());
            }
        }
        return m;
    }
    public static Matrix eye(int n){
        Matrix m = new Matrix(n,n);
        int tmp=0;
        for(int i=0;i<n;i++)
        {
            m.matrix[i][i]=1;
        }
        return m;
    }



}
