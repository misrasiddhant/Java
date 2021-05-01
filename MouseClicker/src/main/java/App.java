package main.java;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Robot;
import java.awt.event.InputEvent;



public class App {
    private JButton b_start;
    private JTextField a15TextField;
    private JPanel pan;
    boolean flag = false;
    static Robot robot;
    public App() {
        b_start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                flag = !flag;
                Thread thread = new Thread(){
                    public void run(){
                        int ms  = Integer.parseInt(a15TextField.getText());
                        int i=0;
                        try {
                            sleep(1500);
                        }catch (Exception e){
                            flag=false;
                        }

                        while(flag){
                            System.out.println(i);
                            i++;
                            try {
                                robot.mousePress(InputEvent.BUTTON1_MASK);
                                robot.mouseRelease(InputEvent.BUTTON1_MASK);
                                this.sleep(ms);
                            }
                            catch (Exception e){
                                flag=false;
                            }

                        }

                    }
                };

                thread.start();
            }
        });
        pan.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                flag=false;
            }
        });
    }

    public static void main(String[] args) throws Exception {
        robot = new Robot();
        JFrame frame = new JFrame("App");
        frame.setContentPane(new App().pan);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setAlwaysOnTop(true);
        frame.pack();
        frame.setVisible(true);
    }
}
