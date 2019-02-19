package com.edu.agh.CSV;

import com.edu.agh.CSV.ProcessBase;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProcessCSV extends ProcessBase {




    @Override
    void processFile() {
        getColumns(0, csv.get(0).size() - 1);
        getSum();
    }


    private void getColumns(int... columns) {

        Iterator iter = csv.iterator();
        while (iter.hasNext()) {
            List<String> row = (List) iter.next();
            ArrayList<String> util = new ArrayList<>();
            for (int e : columns) {
                util.add(row.get(e));
            }
            resultColumns.add(util);
        }

    }

    private int getSum(){

        int sum = 0;

        try{
            Iterator iterator = csv.iterator();
            while(iterator.hasNext()){
               ArrayList <String> s = (ArrayList<String>) iterator.next();
               sum += Integer.parseInt(s.get(s.size() - 1));
            }

        }catch(NumberFormatException e){
            e.printStackTrace();
            sum = -1;
        }
        System.out.println("SUM: " + sum );
        return sum;
    }




}
