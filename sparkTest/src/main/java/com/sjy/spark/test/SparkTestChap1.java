package com.sjy.spark.test;

import org.apache.spark.SparkConf;
import org.apache.spark.sql.SQLContext;
import org.apache.spark.sql.SparkSession;

public class SparkTestChap1 {
    public static void main(String[] args) {
        SparkConf conf = new SparkConf();
        SparkSession session = new SparkSession.Builder()
                .config(conf)
                .appName("RunModifyiedFilm:yuanhuan02@maoyan.com")
                .enableHiveSupport().getOrCreate();
        SQLContext sqlContext = session.sqlContext();

    }
}
