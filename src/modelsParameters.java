import java.util.ArrayList;

public class modelsParameters {

    public static ArrayList<Double> weightsList = new ArrayList<>();
    public static ArrayList<Double> choosePrs = new ArrayList<>();
    public static int SampleNumber = 0;

    public static double chooseMax(double a,double b)
    {
        if(a > b)
        {return a;}
        else
        {return b;}
    }
    public static double chooseMin(double a,double b)
    {
        if(a < b)
        {return a;}
        else
        {return b;}
    }

    public static void freshSampleNumber()
    {
        SampleNumber++;
        if(SampleNumber > 100)
        {SampleNumber = 1;}
    }

    public static void initeWC(int modelNumber)
    {
        for(int i = 0;i < modelNumber;i++)
        {
            weightsList.add(0.0);
            choosePrs.add(1.0);
        }
    }
    public static void freshWeights
            (int modelNumber,int label,ArrayList<Integer> combineLabels)
    {
        for(int i = 0;i < modelNumber;i++)
        {
            double aa = chooseMax(weightsList.get(i)+4/Math.sqrt(SampleNumber)*clOnSingleSample.Z.get(i)/
                    (1 + Math.pow(Math.E,clOnSingleSample.S.get(i))),-2.0);
            double ab = chooseMin(aa,2);
            weightsList.set(i,ab);
            choosePrs.set(i,choosePrs.get(i)*Math.pow(Math.E,-getErrors.wrongOne(label,combineLabels.get(i))));
        }
    }
}
