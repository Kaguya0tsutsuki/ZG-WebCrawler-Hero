package tiss

import com.opencsv.CSVWriter


class Connect {

    static void connect(List<String[]> list)throws IOException{

        CSVWriter writer = new CSVWriter(new FileWriter(new File('./downloads','Version.csv')))

        for(String[] row: list){
            writer.writeNext(row)
        }
        writer.close()

    }
}
