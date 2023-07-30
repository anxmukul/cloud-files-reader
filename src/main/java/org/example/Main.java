package org.example;
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello and welcome!");
        ReadFromS3Buckets s3Obj = new ReadFromS3Buckets();
        s3Obj.readFileFromCloud();
    }
}