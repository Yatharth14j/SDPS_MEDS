package SDPSQuiz;


import SDPSQuiz.Meds.Aspirin;
import SDPSQuiz.Meds.Disprin;
import SDPSQuiz.Meds.Meds;

public class Main {
    public static void main(String[] args) {
        MedicineSupply medicineSupply = new MedicineSupply();
        Meds med1 = new Aspirin();
        Meds med2 = new Disprin();

        medicineSupply.addMedicine(med1 , 10);
        medicineSupply.addMedicine(med2 , 20);

        medicineSupply.getMedicine(med2 , 15);




    }
}
