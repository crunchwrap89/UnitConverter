package marcusn;

public class UnitConverterMain {
  
	public static void main(String[] args) {
	 
              UnitConverterUi frame = new UnitConverterUi();
              frame.visaUI();
  }
}

class Konverterare{

    static String knappTryckt;
    static String temperaturIn;
    static String temperaturUt;
    static Double temp;

    public Konverterare(String knappTryckt, String temperaturIn){
        Konverterare.knappTryckt = knappTryckt;
        Konverterare.temperaturIn = temperaturIn;
        konverteraTemp();
    }

    public void konverteraTemp(){
        try{
            if(knappTryckt=="celcius"){
                temp=Double.parseDouble(temperaturIn);
                temp = temp * 1.8 + 32;
                temperaturUt=Double.toString(temp);
            }
            if(knappTryckt=="fahrenheit"){
                temp=Double.parseDouble(temperaturIn);
                temp = (temp - 32) * (5.0/9.0);
                temperaturUt=Double.toString(temp);
            }
        }catch(Exception e){
            temperaturUt = "Ange en giltig temperatur.";
            
        }
    }
    
    public String toString(){
        return "\n\n" +temperaturUt;
    }

}