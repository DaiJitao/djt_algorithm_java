package spark;

import com.alibaba.fastjson.JSONObject;
import org.apache.spark.Accumulator;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.*;
import org.apache.spark.broadcast.Broadcast;
import scala.Tuple2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * Created by dell on 2020/4/26.
 */
public class SparkDemo {
    public static void main(String[] args) {
        SparkConf conf = new SparkConf();
        conf.set("spark.serializer", "org.apache.spark.serializer.KryoSerializer");
        conf.set("spark.port.maxRetries", "512");
        conf.registerKryoClasses(new Class[]{SparkDemo.class});

        conf.setMaster("local[*]");
        conf.setAppName("Demo");
        JavaSparkContext jsc = new JavaSparkContext(conf);
        JavaRDD<String> lines = jsc.textFile("G:\\新华网项目\\实体词热词\\禅道bug\\111test.txt");
        final Accumulator<Integer> blankLines = jsc.accumulator(0);

        JavaPairRDD<String, Integer> keyData = lines.mapPartitionsToPair(new PairFlatMapFunction<Iterator<String>, String, Integer>() {
            public Iterator<Tuple2<String, Integer>> call(Iterator<String> stringIterator) throws Exception {
                List<Tuple2<String, Integer>> tuple2s = new ArrayList<Tuple2<String, Integer>>(100);
                while (stringIterator.hasNext()){
                    JSONObject jsonObject = JSONObject.parseObject(stringIterator.next());
                    tuple2s.add(new Tuple2<String, Integer>(jsonObject.getString("content"), 1));

                }
                return tuple2s.iterator();
            }
        });

        System.out.println(keyData.first());

        jsc.close();

    }
}
