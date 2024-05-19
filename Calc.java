import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.UIManager;

class Calc implements ActionListener {
    JFrame frame;
    JTextField screen;
    JButton nbtn[] = new JButton[10];
    JButton btnPlus, btnMinus, btnMult, btnDiv, btnrem, btnZero, btn2Zero, btneq, btnAc, btnDel, btnDec;
    Font ff1 = new Font("Ink.Free", Font.BOLD, 35);
    Font ff2 = new Font("Ink.Free", Font.BOLD, 25);
    UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookFeel");
    JPanel panel;
    char opr;
    Double num1, num2, res;

    public Calc() {
        frame = new JFrame();
        frame.setSize(360, 500);
        frame.setLocationRelativeTo(null);
        frame.setTitle("Calculator");
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.darkGray);

        screen = new JTextField("0");
        screen.setBounds(25, 25, 300, 50);
        screen.setBorder(null);
        screen.setBackground(Color.WHITE);
        screen.setFont(ff1);
        screen.setEditable(false);
        screen.setHorizontalAlignment(JTextField.RIGHT);
        frame.add(screen);

        panel = new JPanel();
        panel.setBounds(25, 100, 300, 320);
        panel.setLayout(new GridLayout(5, 4));
        frame.add(panel);

        for (int i = 1; i < 10; i++) {
            nbtn[i] = new JButton(String.valueOf(i));
            nbtn[i].setFont(ff2);
            nbtn[i].setBackground(new Color(40, 40, 40));
            nbtn[i].setForeground(Color.WHITE);
            nbtn[i].setBackground(Color.black);
            nbtn[i].addActionListener(this);
        }

        // Arithmetic buttons:

        btnPlus = new JButton("+");
        btnPlus.setFont(ff2);
        btnPlus.setBackground(new Color(40, 40, 40));
        btnPlus.setForeground(Color.green);
        btnPlus.setBackground(Color.black);
        btnMinus = new JButton("-");
        btnMinus.setFont(ff2);
        btnMinus.setBackground(new Color(40, 40, 40));
        btnMinus.setForeground(Color.green);
        btnMinus.setBackground(Color.black);
        btnMult = new JButton("*");
        btnMult.setFont(ff2);
        btnMult.setBackground(new Color(40, 40, 40));
        btnMult.setForeground(Color.green);
        btnMult.setBackground(Color.black);
        btnDiv = new JButton("/");
        btnDiv.setFont(ff2);
        btnDiv.setBackground(new Color(40, 40, 40));
        btnDiv.setForeground(Color.green);
        btnDiv.setBackground(Color.black);
        btnDec = new JButton(".");
        btnDec.setFont(ff2);
        btnDec.setBackground(new Color(40, 40, 40));
        btnDec.setForeground(Color.green);
        btnDec.setBackground(Color.black);
        btnrem = new JButton("%");
        btnrem.setFont(ff2);
        btnrem.setBackground(new Color(40, 40, 40));
        btnrem.setForeground(Color.green);
        btnrem.setBackground(Color.black);

        // Zeros button:

        btnZero = new JButton("0");
        btnZero.setFont(ff2);
        btnZero.setBackground(new Color(40, 40, 40));
        btnZero.setForeground(Color.WHITE);
        btnZero.setBackground(Color.black);
        btn2Zero = new JButton("00");
        btn2Zero.setFont(ff2);
        btn2Zero.setBackground(new Color(40, 40, 40));
        btn2Zero.setForeground(Color.white);
        btn2Zero.setBackground(Color.black);

        // All Clear and Clear buttons:
        btnDel = new JButton("C");
        btnDel.setFont(ff2);
        btnDel.setBackground(new Color(40, 40, 40));
        btnDel.setForeground(Color.white);
        btnDel.setBackground(Color.red);
        btnAc = new JButton("AC");
        btnAc.setFont(ff2);
        btnAc.setBackground(new Color(40, 40, 40));
        btnAc.setForeground(Color.white);
        btnAc.setBackground(Color.red);

        // equals too button:
        btneq = new JButton("=");
        btneq.setFont(ff2);
        btneq.setBackground(new Color(40, 40, 40));
        btneq.setForeground(Color.WHITE);
        btneq.setBackground(Color.orange);

        panel.add(btnAc);
        panel.add(btnDel);
        panel.add(btnrem);
        panel.add(btnDiv);
        panel.add(nbtn[7]);
        panel.add(nbtn[8]);
        panel.add(nbtn[9]);
        panel.add(btnMult);
        panel.add(nbtn[4]);
        panel.add(nbtn[5]);
        panel.add(nbtn[6]);
        panel.add(btnMinus);
        panel.add(nbtn[1]);
        panel.add(nbtn[2]);
        panel.add(nbtn[3]);
        panel.add(btnPlus);
        panel.add(btn2Zero);
        panel.add(btnZero);
        panel.add(btnDec);
        panel.add(btneq);

        btn2Zero.addActionListener(this);
        btnZero.addActionListener(this);
        btnDec.addActionListener(this);
        btnAc.addActionListener(this);
        btnDel.addActionListener(this);
        btnPlus.addActionListener(this);
        btnMinus.addActionListener(this);
        btnMult.addActionListener(this);
        btnDiv.addActionListener(this);
        btnrem.addActionListener(this);
        btneq.addActionListener(this);

        frame.setLayout(null);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        for (int i = 1; i < 10; i++) {
            if (e.getSource() == nbtn[i]) {
                screen.setText(screen.getText().concat(String.valueOf(i)));
            }
        }

        if (e.getSource() == btn2Zero) {
            screen.setText(screen.getText().concat("00"));
        }
        if (e.getSource() == btnZero) {
            screen.setText(screen.getText().concat("0"));
        }
        if (e.getSource() == btnDec) {
            screen.setText(screen.getText().concat("."));
        }

        if (e.getSource() == btnAc) {
            screen.setText("");
        }
        if (e.getSource() == btnDel) {
            String Delete = null;
            if (screen.getText().length() > 0) {
                StringBuilder str = new StringBuilder(screen.getText());
                str.deleteCharAt(screen.getText().length() - 1);
                Delete = str.toString();
                screen.setText(Delete);
            }
        }

        if (e.getSource() == btnPlus) {
            num1 = Double.parseDouble(screen.getText());
            opr = '+';
            screen.setText("");
        }
        if (e.getSource() == btnMinus) {
            num1 = Double.parseDouble(screen.getText());
            opr = '-';
            screen.setText("");
        }
        if (e.getSource() == btnMult) {
            num1 = Double.parseDouble(screen.getText());
            opr = '-';
            screen.setText("");
        }
        if (e.getSource() == btnDiv) {
            num1 = Double.parseDouble(screen.getText());
            opr = '/';
            screen.setText("");
        }
        if (e.getSource() == btnrem) {
            num1 = Double.parseDouble(screen.getText());
            opr = '%';
            screen.setText("");
        }
        if (e.getSource() == btneq) {
            try {
            num2 = Double.parseDouble(screen.getText());
            
            switch (opr) {
                case '+':
                    res = num1 + num2;
                    screen.setText(String.valueOf(res));
                    break;
                case '-':
                    res = num1 - num2;
                    screen.setText(String.valueOf(res));
                    break;
                case '*':
                    res = num1 * num2;
                    screen.setText(String.valueOf(res));
                    break;
                case '/':
                    res = num1 / num2;
                    screen.setText(String.valueOf(res));
                    break;
                case '%':
                    res = num1 % num2;
                    screen.setText(String.valueOf(res));
                    break;
            }
        }catch (Exception ex) {
                // TODO: handle exception
                JOptionPane.showMessageDialog(null,"--SYNTAX ERROR--");
                screen.setText("");
            }
        }
    }

    public static void main(String[] args) {
        new Calc();
    }
}
