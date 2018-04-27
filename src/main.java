import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class main {
    public static void main(String[] args)
            throws IOException
    {
        String fileName = "/Users/liubonan/Downloads/Adaboost.OL/src/adaboost.txt";
        ArrayList<ArrayList<Double>> dataSet = dataSolve.loadData(fileName);
        ArrayList<Integer> realLableList = dataSolve.realLabelsList(fileName);
        int modelNumber = 5;
        ArrayList<SingleModel> trees = AdaboostOL.AdaboostOLTrain(dataSet,realLableList,modelNumber);
        int sampleNum = dataSet.size();
        for(int i = 0;i < modelNumber;i++) {
            System.out.println(trees.get(i).split);
        }
        for(int i = 0;i < modelNumber;i++)
        {
            System.out.println(modelsParameters.weightsList.get(i));
        }
        for(int i = 0;i < modelNumber;i++)
        {
            System.out.println(modelsParameters.choosePrs.get(i));
        }
        for(int i = 0;i < sampleNum;i++)
        {
            System.out.println(AdaboostOL.rightRatesList.get(i));
        }
    }
}
