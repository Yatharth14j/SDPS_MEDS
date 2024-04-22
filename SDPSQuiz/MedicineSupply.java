package SDPSQuiz;

import SDPSQuiz.Meds.Meds;
import SDPSQuiz.Salts.BaseSalt;
import SDPSQuiz.Salts.SaltFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MedicineSupply {
    private Map<Meds,Integer>medicineQuantities;

    public MedicineSupply()
    {
        this.medicineQuantities = new HashMap<>();
    }

    public void addMedicine(Meds medicine , int quantity)
    {
        if(medicineQuantities.containsKey(medicine))
        {
            int existingQuantity = medicineQuantities.get(medicine);
            medicineQuantities.put(medicine, existingQuantity + quantity);
        }
        else
        {
            // If medicine is new, add it to the map
            medicineQuantities.put(medicine, quantity);
        }
    }

    public void getMedicine(Meds medicine , int quantity)
    {
        if(medicineQuantities.containsKey(medicine))
        {
            int existingQuantity = medicineQuantities.get(medicine);
            if (existingQuantity >= quantity)
            {
                medicineQuantities.put(medicine, existingQuantity - quantity);
                System.out.println(medicine.name() + " medicine delivered" );
                System.out.println("bill : " + quantity*medicine.cost());
            }
            else
            {
                System.out.println("Insufficient quantity of " + medicine.name());
                medicineQuantities.put(medicine, 0);
                System.out.println(existingQuantity + " units of" + medicine.name() + " medicine delivered" );
                //System.out.println("bill : " + existingQuantity*medicine.cost());
                int total = existingQuantity* medicine.cost() ;
                quantity -= existingQuantity;

                List<String> salts = medicine.getSalts();
                SaltFactory saltFactory = new SaltFactory();
                List<String> combs = new ArrayList<>();
                for(int i = 0 ; i < salts.size() ; ++i)
                {
                    BaseSalt baseSalt = saltFactory.getSalt(salts.get(i));
                    if(baseSalt == null)
                    {
                        System.out.println("Sorry !! We are having that much quantity only");
                        return;
                    }
                    total+= baseSalt.cost()*quantity;
                    combs.add(baseSalt.saltName());
                }
                System.out.println("Instead you can have these following combinations : ");
                for(String x : combs) System.out.println(x);
                System.out.println("Bill : " + total);

            }
        }
        else
        {
            List<String> salts = medicine.getSalts();
            SaltFactory saltFactory = new SaltFactory();
            System.out.println("Instead you can have these following combinations : ");
            List<String> combs = new ArrayList<>();
            int total = 0;
            for(int i = 0 ; i < salts.size() ; ++i)
            {
                BaseSalt baseSalt = saltFactory.getSalt(salts.get(i));
                if(baseSalt == null)
                {
                    System.out.println("Sorry !! We are unable to provide your requested medicines");
                    return;
                }
                total+= baseSalt.cost()*quantity;
                combs.add(baseSalt.saltName());
            }
            for(String x : combs) System.out.println(x);
            System.out.println("Bill : " + total);
        }
    }


}
