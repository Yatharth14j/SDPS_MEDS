package SDPSQuiz.Meds;

import java.util.ArrayList;
import java.util.List;

public class Disprin implements Meds {
    public List<String>salts;
    String name;
    @Override
    public int cost() {
        return 10;
    }

    public String name() {
        return "Disprin";
    }

    public Disprin()
    {
        name = "disprin";
        salts = new ArrayList<>();
        salts.add("benzene");
        salts.add("paracetamol");
    }

    @Override
    public List<String> getSalts() {
        return salts;
    }
}
