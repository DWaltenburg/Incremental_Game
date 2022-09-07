package Incremental_Game.src.Package;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class WindowGUI extends JFrame implements WindowListener, ActionListener {

    private JLabel text = new JLabel("",SwingConstants.CENTER);
    private int resource = 0;
    private double increase = 1;
    private double BaseIncreaseCost = 10;
    private double BaseMultiplierCost = 100;
    private JButton ResourceUpButton;
    private JButton BaseIncreaseButton;
    private JButton BaseMultiplierButton;
    private static String title = "Minecraft 2.0";


    GridLayout GLayout = new GridLayout(0,2,30,20);


    public WindowGUI(String title) throws HeadlessException {
        super(title);
        setResizable(false);
        this.setLayout(GLayout);
        this.getRootPane().setBorder(BorderFactory.createEmptyBorder(5,30,20,30));

        this.addWindowListener(this);

        text.setText(resource + " Resources");
        text.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        this.add(text);
        this.add(new Label(" "));

        ResourceUpButton = new JButton("Increase Resources by 1");
        this.add(ResourceUpButton);
        ResourceUpButton.addActionListener(this);

        BaseIncreaseButton = new JButton("+1 Base Increase. Cost: 10");
        this.add(BaseIncreaseButton);
        BaseIncreaseButton.addActionListener(this);

        BaseMultiplierButton = new JButton("x1.5 Base Increase. Cost: 100");
        this.add(BaseMultiplierButton);
        BaseMultiplierButton.addActionListener(this);

    }

    public static void main(String[] args) {
        WindowGUI window = new WindowGUI(title);
        window.setBounds(100,100,400,300);
        window.setVisible(true);
        }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equalsIgnoreCase(this.ResourceUpButton.getText())) {
            this.resource = (int) (this.resource + this.increase);
            }

        if (e.getActionCommand().equalsIgnoreCase(this.BaseIncreaseButton.getText())) {
            if (this.resource>= this.BaseIncreaseCost) {
                this.increase = this.increase + 1;
                this.resource = (int) (this.resource - this.BaseIncreaseCost);
                this.BaseIncreaseCost = this.BaseIncreaseCost * 1.2;
                ResourceUpButton.setText("Increase Resources by " + (int)this.increase);
                BaseIncreaseButton.setText("+1 Base Increase. Cost: " + (int)this.BaseIncreaseCost);
            }
        }

        if (e.getActionCommand().equalsIgnoreCase(this.BaseMultiplierButton.getText())) {
            if (this.resource>= this.BaseMultiplierCost){
                this.increase = this.increase * 1.5;
                this.resource = (int) (this.resource - this.BaseMultiplierCost);
                this.BaseMultiplierCost = this.BaseMultiplierCost * 1.2;
                ResourceUpButton.setText("Increase Resources by " + (int)this.increase);
                BaseMultiplierButton.setText("x1.5 Base Increase. Cost: " + (int)this.BaseMultiplierCost);
            }
        }

        text.setText(resource + " Resources");
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        this.dispose();
        System.exit(0);
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
