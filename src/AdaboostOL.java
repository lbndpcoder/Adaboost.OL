import java.util.ArrayList;
import java.util.Collections;

public class AdaboostOL {

    public static ArrayList<Double> rightRatesList = new ArrayList<>();


    /*public  static void initeEveryThing(int modelNumber)
    {
        modelsParameters.initeWC(modelNumber);
    }*/

    public static int Sign(double a)
    {
        if(a > 0.0)
        {return 1;}
        else
        {return -1;}
    }
    public static ArrayList<Integer> CombinePredictLabels
            (ArrayList<Integer> predictlabels,int modelNumber,ArrayList<Double> weights)
    {
        ArrayList<Integer> combineLabels = new ArrayList<>();
        ArrayList<Double> combineElments = new ArrayList<>();
        combineElments.add(0.0);
        for(int i = 0;i < modelNumber;i++)
        {
            combineElments.add(weights.get(i)*predictlabels.get(i));
        }
        int firstE = Sign(combineElments.get(1));
        combineLabels.add(firstE);
        for(int i = 2;i <= modelNumber;i++)
        {
            double Rtemp = combineElments.get(i)+combineLabels.get(i - 2);
            int temp = Sign(Rtemp);
            combineLabels.add(temp);
        }
        return combineLabels;
    }

    public static int chooseCombineLabels(ArrayList<Double> choosePrLists,ArrayList<Integer> combineLabels)
    {
        int choosenCombineLabel;
        Collections.sort(choosePrLists);
        Collections.reverse(choosePrLists);
        int size = choosePrLists.size();
        int count = 1;
        while(choosePrLists.get(count) == choosePrLists.get(count - 1) & count < size + 1)
        {
            count++;
        }
        if(count > 1)
        {double seed = Math.random()*count;
        int chooseNum = (int) Math.floor(seed);
        choosenCombineLabel = combineLabels.get(chooseNum);}
        else
        {
            choosenCombineLabel = combineLabels.get(0);
        }
        return choosenCombineLabel;
    }


    public static ArrayList<SingleModel> AdaboostOLTrain
            (ArrayList<ArrayList<Double>> dataSet,ArrayList<Integer> realLabelList,int modelNumber)
    {
        ArrayList<SingleModel> modeles = createTrees.initeTrees(modelNumber);
        ArrayList<Integer> choosenLabelList = new ArrayList<>();
        int feaNumber = dataSet.get(0).size();
        modelsParameters.initeWC(modelNumber);
        for(int i = 0;i < dataSet.size();i++)
        {
            ArrayList<Double> data = dataSet.get(i);
            int SingleLabel = realLabelList.get(i);
            ArrayList<Integer> predictLabels;//each basic model predicts
            for(int j = 0;j < feaNumber;j++)
            {

                double feData = data.get(j);//the single data under the single feature
                clOnSingleSample.initeParameters(modelNumber);//Z&S initialization
                predictLabels = createTrees.predictLabelsList(feData,modeles,modelNumber);
                ArrayList<Integer> combineLabels = CombinePredictLabels(predictLabels,modelNumber,modelsParameters.weightsList);

                //choose the the best expert and save the history
                int choosenLable = chooseCombineLabels(modelsParameters.choosePrs,combineLabels);
                choosenLabelList.add(choosenLable);
                double rightRate = getErrors.RightRate(choosenLabelList,realLabelList);
                rightRatesList.add(rightRate);

                clOnSingleSample.freshParameters(SingleLabel,predictLabels,modelNumber);
                modelsParameters.freshSampleNumber();
                modelsParameters.freshWeights(modelNumber,SingleLabel,combineLabels);

                modeles = createTrees.freshTrees(modeles,SingleLabel,predictLabels,modelNumber);
            }
        }
        return modeles;
    }
}
