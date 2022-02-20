package com.progressoft.tools;

import java.math.BigDecimal;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class NormalizerImp implements Normalizer {

    private final Calculator calculator;
    private final FileReader fileReader;
    private final FileWriter fileWriter;

    public NormalizerImp(Calculator calculator, FileReader fileReader, FileWriter fileWriter) {
        this.calculator = calculator;
        this.fileReader = fileReader;
        this.fileWriter = fileWriter;
    }

    private void checkParams(Path csvPath, Path destPath, String colToStandardize) {
        if (csvPath == null || destPath == null || colToStandardize == null )
            throw new IllegalArgumentException("source file not found");
    }

    private List<BigDecimal> getValueOfCols(List<List<String>> data , String colToStandardize ) {

        if (!data.get(0).contains(colToStandardize)) {
            throw new IllegalArgumentException("column " + colToStandardize + " not found");
        }

        int numberIndex = data.get(0).indexOf(colToStandardize);
        List<String> colData = new ArrayList<>();
        for (List<String> record : data) {
            colData.add(record.get(numberIndex));
        }

        List<BigDecimal> col = new ArrayList<>();
        colData.remove(0);
        for (int i = 0; i<=colData.size()-1; i++) {
            col.add(BigDecimal.valueOf(Double.parseDouble(colData.get(i))));
        }
        return col;
    }


    private ScoringSummary helper(Path csvPath, Path destPath, String colName, String type) {

        List<List<String>> result = fileReader.readFile(csvPath);
        List<BigDecimal> col = getValueOfCols(result,colName);

        BigDecimal mean = calculator.calculateMean(col);
        BigDecimal standardDeviation = calculator.calculateStandardDeviation(col);
        BigDecimal variance = calculator.calculateVariance(col);
        BigDecimal median = calculator.calculateMedian(col);
        BigDecimal min = calculator.calculateMinValue(col);
        BigDecimal max = calculator.calculateMaxValue(col);

        int numberIndex = result.get(0).indexOf(colName);
        for (int i=0; i<result.size(); i++) {
            List<String> temp = new ArrayList<>(result.get(i));
            if (i == 0) {
                if (type == "zscore")
                    temp.add(numberIndex+1,colName+"_z");
                else
                    temp.add(numberIndex+1,colName+"_mm");
            } else {
                BigDecimal value = new BigDecimal(temp.get(numberIndex));
                BigDecimal bigDecimal;
                if (type == "zscore") {
                    bigDecimal = calculator.calculateZscore(value, mean, standardDeviation);
                } else {
                    bigDecimal = calculator.calculateMinMaxScaling(value, min, max);
                }
                temp.add(numberIndex+1,String.valueOf(bigDecimal));
            }
            fileWriter.writeFile(temp,destPath);
        }
        return new ScoringSummaryImp(mean,standardDeviation,variance,median,min,max);
    }

    @Override
    public ScoringSummary zscore(Path csvPath, Path destPath, String colToStandardize) {
        checkParams(csvPath, destPath, colToStandardize);
        String type = "zscore";
        return helper(csvPath, destPath, colToStandardize, type);
    }

    @Override
    public ScoringSummary minMaxScaling(Path csvPath, Path destPath, String colToNormalize) {
        checkParams(csvPath, destPath, colToNormalize);
        String type = "minmax";
        return helper(csvPath, destPath, colToNormalize, type);
    }
}
