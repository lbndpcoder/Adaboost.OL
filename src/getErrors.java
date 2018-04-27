import java.util.ArrayList;

public class getErrors {
    public static int wrongOne(int label1,int label2)
    {
        if(label1 == label2)
        {
            return 0;
        }
        else
        {
            return 1;
        }
    }

    public static double RightRate(ArrayList<Integer> combineLabelsList,ArrayList<Integer> realLableLists)
    {
        int size = combineLabelsList.size();
        double count = 0;
        for(int i  =0;i < size;i++)
        {
            if(combineLabelsList.get(i) == realLableLists.get(i))
            {
                count++;
            }
        }
        double rightRate = count/size;
        return rightRate;
    }
}
