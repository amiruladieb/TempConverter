import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class KelvinPage implements ActionListener {
    
    //declare
    JFrame frame;
    JLabel inputLabel;
    JTextField inputField;
    JLabel inputTempLabel;
    JLabel input2Label;
    JComboBox inputTempField;
    JButton submitButton;
    JLabel notifLabel;
    JLabel notif2Label;
    JLabel outputLabel;
    JTextField outputField;
    JLabel outputTempLabel;
    JButton mainMenuButton;
    
    String inputTemp;
    double num, result;
    
    //construct
    KelvinPage() {
        
        frame = new JFrame("Konverter Suhu - Kelvin (K)");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null); // this method display the JFrame to center position of a screen
        frame.setLayout(null);
        frame.setResizable(false);

        //frame icon
        ImageIcon frameIcon = new ImageIcon("temperature.png");
        frame.setIconImage(frameIcon.getImage());
        
        inputLabel = new JLabel("Masukan nilai :");
        inputLabel.setBounds(40, 40, 140, 30);
        inputLabel.setFont(new Font("Comic Sans", Font.PLAIN, 20));

        inputField = new JTextField();
        inputField.setBounds(180, 28, 190, 50);
        inputField.setFont(new Font("Comic Sans", Font.PLAIN, 24));
        
        //inputField accept only numbers, dot, backspace, delete, left and right arrows keys
        inputField.addKeyListener(new KeyAdapter() {
            
            public void keyTyped(KeyEvent evt) {
                
                if (Character.isLetter(evt.getKeyChar())) {
                    evt.consume();
                }
                else if (inputField.getText().isEmpty()) {
                    notifLabel.setText("Masukan suhu awal terlebih dahulu !");
                    notifLabel.setVisible(true);
                }
                else {
                    
                    try {
                        Double.parseDouble(inputField.getText() + evt.getKeyChar());
                        notifLabel.setVisible(false);
                    }
                    catch (NumberFormatException e) {
                        evt.consume();
                    }
                    
                }
                
            }
            
        });
        
        inputTempLabel = new JLabel("K");
        inputTempLabel.setBounds(385, 40, 30, 30);
        inputTempLabel.setFont(new Font("Comic Sans", Font.PLAIN, 20));
        
        notifLabel = new JLabel("Masukan suhu awal terlebih dahulu !");
        notifLabel.setBounds(40, 85, 400, 20);
        notifLabel.setFont(new Font("Comic Sans", Font.ITALIC, 16));
        notifLabel.setForeground(Color.red);
        
        input2Label = new JLabel("Konversikan menjadi");
        input2Label.setBounds(40, 130, 180, 30);
        input2Label.setFont(new Font("Comic Sans", Font.PLAIN, 20));
        
        String[] temp = {" ", "°C", "°F", "°R"};
        inputTempField = new JComboBox(temp);
        inputTempField.setBounds(245, 125, 50, 40);
        inputTempField.setFont(new Font("Comic Sans", Font.PLAIN, 18));
        inputTempField.addActionListener(this);
        
        submitButton = new JButton("Kirim");
        submitButton.setBounds(330, 125, 80, 40);
        submitButton.setFont(new Font("Comic Sans", Font.PLAIN, 18));
        submitButton.setFocusable(false);
        submitButton.addActionListener(this);
        
        notif2Label = new JLabel("Silakan pilih suhu tujuan dahulu !");
        notif2Label.setBounds(40, 175, 250, 20);
        notif2Label.setFont(new Font("Comic Sans", Font.ITALIC, 16));
        notif2Label.setForeground(Color.red);
        
        outputLabel = new JLabel("Hasilnya :");
        outputLabel.setBounds(40, 230, 150, 30);
        outputLabel.setFont(new Font("Comic Sans", Font.PLAIN, 20));
        
        outputField = new JTextField();
        outputField.setBounds(180, 222, 190, 50);
        outputField.setFont(new Font("Comic Sans", Font.PLAIN, 24));
        outputField.setEditable(false);
        
        outputTempLabel = new JLabel();
        outputTempLabel.setBounds(385, 230, 30, 30);
        outputTempLabel.setFont(new Font("Comic Sans", Font.PLAIN, 20));
        
        mainMenuButton = new JButton("Menu Utama");
        mainMenuButton.setBounds(170, 350, 150, 40);
        mainMenuButton.setFont(new Font("Comic Sans", Font.PLAIN, 18));
        mainMenuButton.setFocusable(false);
        mainMenuButton.addActionListener(this);
        
        frame.add(inputLabel);
        frame.add(inputField);
        frame.add(inputTempLabel);
        frame.add(input2Label);
        frame.add(inputTempField);
        frame.add(submitButton);
        frame.add(notifLabel);
        frame.add(notif2Label);
        frame.add(outputLabel);
        frame.add(outputField);
        frame.add(outputTempLabel);
        frame.add(mainMenuButton);
        
        frame.setVisible(true);
        
    }

    //method
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == inputTempField) {
            
            inputTemp = String.valueOf(inputTempField.getSelectedItem());
            
            switch (inputTemp) {
                case " ":
                    notif2Label.setVisible(true);
                    break;
                case "°C":
                    notif2Label.setVisible(false);
                    break;
                case "°F":
                    notif2Label.setVisible(false);
                    break;
                case "°R":
                    notif2Label.setVisible(false);
                    break;
            }
            
            outputField.setText("");
            outputTempLabel.setText(inputTemp);
//            System.out.println(inputTemp);
            
        }
        
        if (e.getSource() == submitButton) {
            
            num = Double.parseDouble(inputField.getText());
//            System.out.println(num);

            if (inputField.getText().isEmpty()) {
//                JOptionPane.showMessageDialog(null, "isian kosong");
                notifLabel.setVisible(true);
                outputField.setText("");
            }
            
            if (num < 0) {
                notifLabel.setText("Skala Kelvin tidak mengandung nilai negatif.");
                notifLabel.setVisible(true);
                result = Double.parseDouble("");
            }

            switch (inputTemp) {
                case " ":
                    result = Double.parseDouble("");
                    break;
                case "°C":
                    result = num - 273.15;
                    break;
                case "°F":
                    result = (num * 9 / 5) - 459.67 ;
                    break;
                case "°R":
                    result = (num - 273.15) * 4 / 5;
                    break;
            }
            
            notifLabel.setVisible(false);
            notif2Label.setVisible(false);
            outputField.setText(String.valueOf(String.format("%.4f", result)));
            
        }
        
        if (e.getSource() == mainMenuButton) {
            //close main menu
            frame.dispose(); 
            //instance
            MainMenu mainMenu = new MainMenu();
        }
        
    }
    
}
