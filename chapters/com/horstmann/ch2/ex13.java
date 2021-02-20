package com.horstmann.ch2;

import com.opencsv.CSVReaderHeaderAware;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.Writer;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class ex13 {
    public static void main(String[] args) throws Exception {
//        List<MyBean> beans = new CsvToBeanBuilder(FileReader("yourfile.csv"))
//                .withType(Visitors.class).build().parse();
//        Writer writer = new FileWriter("yourfile.csv");
//        StatefulBeanToCsv beanToCsv = new StatefulBeanToCsvBuilder(writer).build();
//        beanToCsv.write(Collections.singletonList(beans));
//        writer.close();

        Map<String, String> values = new CSVReaderHeaderAware(new FileReader("C:\\Users\\alan0419\\Downloads\\"
                + "GRAYLOG_VFOM_7573a168-2922-42fb-b843-0ac03595bf10_13-01-21-09-07-36.999.csv")).readMap();
        Writer writer = new FileWriter("yourfile.csv");
        StatefulBeanToCsv beanToCsv = new StatefulBeanToCsvBuilder(writer).build();
        beanToCsv.write(Collections.singletonList(values));
        writer.close();
    }
}
