package marcusn;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

public class UnitConverterUi{

    private JFrame frame;
    private JPanel panel;
    private JButton b1c;
    private JButton b2f;
    private JTextField celciusIn;
    private JTextField fahrenheitIn;
    private JTextPane cOmvandlat;
    private JTextPane fOmvandlat;
    private JLabel cInforeq;
    private JLabel fInforeq;
    private JLabel cTillF;
    private JLabel fTillC;
    private Konverterare konv;

    public UnitConverterUi(){
        
    	//Initierar frame och panel
        frame = new JFrame("Temperaturomvandlare");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new JPanel();
        
        //Initierar celcius till farenheitraden 
        b1c = new JButton("Omvandla");
        cInforeq = new JLabel("Ange temp i Celcius:");
        celciusIn = new JTextField("", 15);
        cTillF = new JLabel("Är i Farenheit: ");
        cOmvandlat = new JTextPane();
        cOmvandlat.setEditable(false);
        
        //Initierar farenheit till celciusraden
        b2f = new JButton("Omvandla");
        fInforeq = new JLabel("Ange temp i Fahrenheit:"); 
        fahrenheitIn = new JTextField("", 15);
        fTillC = new JLabel("Är i Celcius: ");
        fOmvandlat = new JTextPane();
        fOmvandlat.setEditable(false);
        
        
        //Lagger till celcius till farenheitraderna
        panel.add(b1c);
        panel.add(cInforeq);
        panel.add(celciusIn);
        panel.add(cTillF);
        panel.add(cOmvandlat);
        
        //Lägger till fahrenheit till celciusraderna 
        panel.add(b2f);
        panel.add(fInforeq);
        panel.add(fahrenheitIn);
        panel.add(fTillC);
        panel.add(fOmvandlat);
        
        //startar actionListener
        knappVal();
    }

     // actionlisteners för 2st knappar, b1c och b2f. Vid knapptryckning av dessa så ändras 2st strings och 
      //matas direkt in i konverteraren. Det omvandlade värdet anges i svarsrutan.
    public void knappVal(){

        b1c.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0){
            	String knappTryckt = "celcius";
                String temperaturIn = celciusIn.getText();
                konv = new Konverterare(knappTryckt,temperaturIn);
                cOmvandlat.setText(konv.toString());
                if(konv.temp >= 32.1) {
                	cOmvandlat.setBackground(Color.red);	
                }
                if(konv.temp <= 32.0) {
                	cOmvandlat.setBackground(Color.blue);
                }  
            }
        });
        
        b2f.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0){
            	String knappTryckt = "fahrenheit";
                String temperaturIn = fahrenheitIn.getText();
                konv = new Konverterare(knappTryckt,temperaturIn);
                fOmvandlat.setText(konv.toString());
                	
                if(konv.temp >= 0.1) {
                	fOmvandlat.setBackground(Color.red);	
                }
                if(konv.temp <= 0) {
                	fOmvandlat.setBackground(Color.blue);
                }
           }    
        });
    }
    //uiInställningar
    public void visaUI() {
        frame.setVisible(true);
        frame.setSize(900, 200);
        frame.setContentPane(panel);
        panel.setLayout(new GridLayout(2,5));
        panel.setBorder(new EmptyBorder(5,5,5,5));
        panel.setOpaque(true);
        
    }
}