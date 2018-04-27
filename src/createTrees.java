import java.util.ArrayList;

public class createTrees
{
    public static ArrayList<SingleModel> initeTrees(int modelNumber)
    {
        ArrayList<SingleModel> trees = new ArrayList<>();
        for(int i =0;i < modelNumber;i++)
        {
            SingleModel tree = new SingleModel();
            tree.split = 0.5 + i;
            tree.height = 1;
            trees.add(tree);
        }
        return trees;
    }

    public static int predictLabel(double data,SingleModel tree)
    {
        int label;
        if(data < tree.split)
        {
            label = -1;
        }
        else
        {
            label = 1;
        }
        return label;

    }

    public static ArrayList<Integer> predictLabelsList(double data,ArrayList<SingleModel> tress,int modelNumber)
    {
        ArrayList<Integer> PLabels = new ArrayList<>();
        int label;
        for(int i = 0;i < modelNumber;i++)
        {
            label = predictLabel(data,tress.get(i));
            PLabels.add(label);
        }
        return PLabels;
    }

    public static ArrayList<SingleModel> freshTrees
            (ArrayList<SingleModel> trees,int dataLabel,ArrayList<Integer> labelList,int modelNumber)
    {
        for(int i = 0;i < modelNumber;i++ )
        {
            if(dataLabel != labelList.get(i))
            {
                if(dataLabel == 1)
                {
                    trees.get(i).split += clOnSingleSample.samplePr.get(i);
                }
                else
                {
                    trees.get(i).split -= clOnSingleSample.samplePr.get(i);
                }
            }
        }
        return trees;
    }
}
