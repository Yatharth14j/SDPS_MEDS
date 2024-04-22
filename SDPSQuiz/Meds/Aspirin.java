package SDPSQuiz.Meds;

import java.util.ArrayList;
import java.util.List;

public class Aspirin implements Meds{
    public List<String> salts;
    String name ;
    @Override
    public int cost() {
        return 20;
    }

    @Override
    public String name() {
        return "Aspirin";
    }

    public Aspirin()
    {
        name = "Aspirin";
        salts = new ArrayList<>();
        salts.add("salt1");
        salts.add("salt2");

    }

    public List<String> getSalts()
    {
        return salts;
    }

}
