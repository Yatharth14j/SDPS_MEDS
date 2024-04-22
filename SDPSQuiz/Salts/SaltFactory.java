package SDPSQuiz.Salts;

public class SaltFactory {
    public BaseSalt getSalt(String Str)
    {
        switch(Str)
        {
            case "benzene":
                return new Benzene();
            case "paracetamol":
                return new Paracetamol();
            default:
                return null;

        }
    }
}
