import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class CelsiusPage implements ActionListener {
    
    //declare
    JFrame frame;
    JLabel inputLabel;
    JTextField inputField;
    JLabel inputTempLabel;
    JLabel input2Label;
    JComboBox inputTempField;
    JButton submitButton;
    JLabel outputLabel;
    JTextField outputField;
    JLabel outputTempLabel;
    
    //construct
    CelsiusPage() {
        
        frame = new JFrame("Konverter Suhu - Celsius (°C)");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLayout(null);
        
        inputLabel = new JLabel("Masukan nilai :");
        inputLabel.setBounds(40, 40, 140, 30);
        inputLabel.setFont(new Font("Comic Sans", Font.PLAIN, 20));

        inputField = new JTextField();
        inputField.setBounds(180, 28, 190, 50);
        inputField.setFont(new Font("Comic Sans", Font.PLAIN, 24));
        
        inputTempLabel = new JLabel("°C");
        inputTempLabel.setBounds(385, 40, 30, 30);
        inputTempLabel.setFont(new Font("Comic Sans", Font.PLAIN, 20));
        
        input2Label = new JLabel("Konversikan menjadi");
        input2Label.setBounds(40, 120, 180, 30);
        input2Label.setFont(new Font("Comic Sans", Font.PLAIN, 20));
        
        String[] temp = {"°F", "K", "°R"};
        inputTempField = new JComboBox(temp);
        inputTempField.setBounds(245, 112, 50, 40);
        inputTempField.setFont(new Font("Comic Sans", Font.PLAIN, 18));
        
        submitButton = new JButton("Kirim");
        submitButton.setBounds(330, 112, 80, 40);
        submitButton.setFont(new Font("Comic Sans", Font.PLAIN, 18));
        submitButton.setFocusable(false);
        
        outputLabel = new JLabel("Hasilnya :");
        outputLabel.setBounds(40, 220, 150, 30);
        outputLabel.setFont(new Font("Comic Sans", Font.PLAIN, 20));
        
        outputField = new JTextField();
        outputField.setBounds(180, 212, 190, 50);
        outputField.setFont(new Font("Comic Sans", Font.PLAIN, 24));
        outputField.setEditable(false);
        
        outputTempLabel = new JLabel("°C");
        outputTempLabel.setBounds(385, 220, 30, 30);
        outputTempLabel.setFont(new Font("Comic Sans", Font.PLAIN, 20));
        
        frame.add(inputLabel);
        frame.add(inputField);
        frame.add(inputTempLabel);
        frame.add(input2Label);
        frame.add(inputTempField);
        frame.add(submitButton);
        frame.add(outputLabel);
        frame.add(outputField);
        frame.add(outputTempLabel);
        
        frame.setVisible(true);
        
    }

    //method
    @Override
    public void actionPerformed(ActionEvent e) {
    }
    
}
