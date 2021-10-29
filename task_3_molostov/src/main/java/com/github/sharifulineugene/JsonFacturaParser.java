package com.github.sharifulineugene;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class JsonFacturaParser implements Closeable {
    private final static Pattern pattern = Pattern.compile("\\{.*\"factures\"\\s*:\\s*\\[\\s*(.*)\\s*].*}");
    private BufferedReader br;

    public JsonFacturaParser(){
        try {
            br = new BufferedReader(new FileReader("task_3_molostov/src/main/resources/input.json"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public JsonFacturaParser(String filePath) {
        try {
            br = new BufferedReader(new FileReader(filePath));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public List<Factura> getListFactures() {
        List<String> list = listJsonFactures();
        return list.stream().map(FacturaMapper::stringToFactura).filter(Objects::nonNull).collect(Collectors.toList());
    }

    private List<String> listJsonFactures() {
        String allLines = br.lines().collect(Collectors.joining(""));
        Matcher matcher = pattern.matcher(allLines);
        if(matcher.matches()) {
            allLines = matcher.group(1);
            String[] arr = allLines.split("},");
            for(int i = 0; i < arr.length-1; ++i) {
                arr[i] += "}";
            }
            return new ArrayList<String>(Arrays.asList(arr)).stream()
                    .map(String::strip).collect(Collectors.toList());
        }
        throw new RuntimeException("Can not parse json");
    }

    @Override
    public void close() throws IOException {
        br.close();
    }
}
