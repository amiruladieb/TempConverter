import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;

class MainMenu implements ActionListener {

    //declare
    JFrame frame;
    JLabel menuLabel;
    JButton celsiusButton;    
    JButton fahrenheitButton;    
    JButton kelvinButton;    
    JButton reamurButton;    
    
    //construct
    MainMenu() {
        
        frame = new JFrame("Konverter Suhu - Menu Utama");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null); // this method display the JFrame to center position of a screen
        frame.setLayout(null);
        
        menuLabel = new JLabel("Pilih suhu asal :");
        menuLabel.setBounds(160, 25, 200, 20);
        menuLabel.setFont(new Font("Comic Sans", Font.PLAIN, 25));
        
        celsiusButton = new JButton("Celsius (°C)");
        celsiusButton.setBounds(130, 80, 225, 40);
        celsiusButton.setFont(new Font("Comic Sans", Font.PLAIN, 22));
        celsiusButton.setFocusable(false);
        celsiusButton.addActionListener(this);
        
        fahrenheitButton = new JButton("Fahrenheit (°F)");
        fahrenheitButton.setBounds(130, 140, 225, 40);
        fahrenheitButton.setFont(new Font("Comic Sans", Font.PLAIN, 22));
        fahrenheitButton.setFocusable(false);
        fahrenheitButton.addActionListener(this);
        
        kelvinButton = new JButton("Kelvin (K)");
        kelvinButton.setBounds(130, 200, 225, 40);
        kelvinButton.setFont(new Font("Comic Sans", Font.PLAIN, 22));
        kelvinButton.setFocusable(false);
        kelvinButton.addActionListener(this);
        
        reamurButton = new JButton("Reamur (°R)");
        reamurButton.setBounds(130, 260, 225, 40);
        reamurButton.setFont(new Font("Comic Sans", Font.PLAIN, 22));
        reamurButton.setFocusable(false);
        reamurButton.addActionListener(this);
        
        frame.add(menuLabel);
        frame.add(celsiusButton);
        frame.add(fahrenheitButton);
        frame.add(kelvinButton);
        frame.add(reamurButton);
        
        frame.setVisible(true);
    }
    
    //method
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == celsiusButton) {
            //close main menu
            frame.dispose(); 
            //instance
            CelsiusPage celsiusPage = new CelsiusPage();
        }
        
        if (e.getSource() == fahrenheitButton) {
            //close main menu
            frame.dispose(); 
            //instance
            FahrenheitPage fahrenheitPage = new FahrenheitPage();
        }
        
        if (e.getSource() == kelvinButton) {
            //close main menu
            frame.dispose(); 
            //instance
            KelvinPage kelvinPage = new KelvinPage();
        }
        
        if (e.getSource() == reamurButton) {
            //close main menu
            frame.dispose(); 
            //instance
            ReamurPage reamurPage = new ReamurPage();
        }
        
    }
    
    
}
