package spark;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.AnalysisException;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

/**
 * Created by dell on 2020/5/15.
 */
public class demo {
    public static void main(String[] args) throws AnalysisException {

        SparkConf conf = new SparkConf();
        conf.set("spark.serializer", "org.apache.spark.serializer.KryoSerializer");
        conf.set("spark.port.maxRetries", "512");
        conf.registerKryoClasses(new Class[]{SparkDemo.class});

        conf.setMaster("local[*]");
        conf.setAppName("Demo");
        // JavaSparkContext jsc = new JavaSparkContext(conf);
        SparkSession spark = SparkSession.builder().config(conf).getOrCreate();


        String path = "F:\\pycharm_workspce\\dai_github\\algorithm\\datafountain\\competitions_352\\datasets\\train\\train_sales_data.csv";

        Dataset<Row> dataset = spark.read().format("csv").option("header", "true").load(path);
        path = "F:\\pycharm_workspce\\dai_github\\algorithm\\datafountain\\competitions_352\\datasets\\train\\train_search_data.csv";
        Dataset<Row> dataset1 = spark.read().format("csv").option("header", "true").load(path);
        // dataset.show();
        String outpath = "F:\\pycharm_workspce\\dai_github\\algorithm\\datafountain\\competitions_352\\datasets\\train\\test.csv";
        dataset.write().mode("overwrite").format("csv").option("header", "true").save(outpath);
        dataset.createTempView("temp");
        dataset1.createTempView("temp2");
        dataset.select("mode").where("mode='3c974920a76ac9c1'");


        spark.close();

    }
}
