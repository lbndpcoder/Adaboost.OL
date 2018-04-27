import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class dataSolve {
    public static ArrayList<ArrayList<Double>> loadData(String fileName)
            throws IOException
    {
        ArrayList<ArrayList<Double>> dataM = new ArrayList<>();
        FileInputStream fis = new FileInputStream(fileName);
        InputStreamReader irs = new InputStreamReader(fis,"UTF-8");
        BufferedReader br = new BufferedReader(irs);
        String line = "";
        while((line = br.readLine()) != null)
        {
            ArrayList<Double> dataPerline = new ArrayList<>();
            String[] s = line.split(" ");
            for(int i = 0;i < s.length - 1;i++)
            {
                dataPerline.add(Double.parseDouble(s[i]));
            }
            dataM.add(dataPerline);
        }
        return dataM;
    }
    public static ArrayList<Integer> realLabelsList(String fileName)
            throws IOException
    {
        ArrayList<Integer> labelList = new ArrayList<>();
        FileInputStream fis = new FileInputStream(fileName);
        InputStreamReader irs = new InputStreamReader(fis,"UTF-8");
        BufferedReader br = new BufferedReader(irs);
        String line = "";
        while((line = br.readLine()) != null)
        {
            String[] s = line.split(" ");
            int size = s.length;
            labelList.add(Integer.parseInt(s[size - 1]));
        }
        return labelList;
    }


}
