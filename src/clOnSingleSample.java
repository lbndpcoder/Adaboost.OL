import java.util.ArrayList;

public class clOnSingleSample {
    public static ArrayList<Integer> Z = new ArrayList<>();
    public static ArrayList<Double> S = new ArrayList<>();
    public static ArrayList<Double> samplePr = new ArrayList<>();

    /*initialization*/
    public static void initeParameters(int modelNumber)
    {
        if(Z.size() == 0)
        {
            for(int i = 0;i < modelNumber;i++)
            {
                Z.add(0);
                S.add(0.0);
                samplePr.add(0.0);
            }
        }
    }

    public static void freshParameters(int label,ArrayList<Integer> predictLabelsList,int modelNumber)
    {
        for(int i = 0;i < modelNumber;i++)
        {
            int zTemp = label*predictLabelsList.get(i);
            Z.set(i,zTemp);
        }

        for(int i = 1;i <= modelNumber;i++)
        {
            double Stemp = S.get(i - 1)+modelsParameters.weightsList.get(i - 1)*Z.get(i - 1);
            S.set(i - 1,Stemp);
            double samplePrtemp = 1/(1+Math.pow(Math.E,Stemp));
            samplePr.set(i - 1,samplePrtemp);
        }

        }
    }

