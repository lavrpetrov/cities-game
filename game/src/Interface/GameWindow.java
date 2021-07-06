package Interface;

import Manager.AnswerBuilder;
import Manager.ConsoleManager;
import Manager.InfoBuilder;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.plaf.basic.BasicSplitPaneUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GameWindow {
    private ConsoleManager consoleManager;
    public static JFrame jFrame;
    private static JPanel startPanel;
    private static JButton enterButton;
    private static JTextField textCity;
    private static JTextField systemText;
    private static JButton giveUpButton;
    private static JLabel cityLabel1;
    private static JLabel cityLabel2;
    private static JLabel nameLabel;
    private boolean continueGame;


    public GameWindow(ConsoleManager consoleManager){
        this.consoleManager=consoleManager;
        loading();
        enterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                continueGame= consoleManager.processingOfGame(textCity.getText());
                textCity.setText("");
                systemText.setText(AnswerBuilder.getAndClear());
                if (!InfoBuilder.get().isEmpty()) {
                    JOptionPane.showMessageDialog(null, InfoBuilder.getAndClear());
                }
                if (!continueGame){
                    System.exit(0);
                }
            }
        });
        giveUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                continueGame=consoleManager.processingOfGame("stop");
                //textCity.setText("");
                systemText.setText(AnswerBuilder.get());
                if (!InfoBuilder.get().isEmpty()) {
                    JOptionPane.showMessageDialog(null, InfoBuilder.getAndClear());
                }
                if (!continueGame){
                    System.exit(0);
                }
            }
        });
    }

    public void loading(){
        JFrame jFrame=new JFrame("Cities-game");
        jFrame.setSize(800,500);
        startPanel=new JPanel();
        startPanel.setBackground(new Color(0x629CCE));
        startPanel.setLayout(new MigLayout(
                "insets 0,hidemode 3",
                // columns
                "[fill]" +
                        "[40,grow,fill]" +
                        "[100,grow,fill]" +
                        "[40,grow,fill]" +
                        "[fill]",
                // rows
                "[fill]" +
                        "[40,grow,fill]" +
                        "[5,grow,fill]" +
                        "[40,grow,fill]" +
                        "[40,grow,fill]" +
                        "[40,grow,fill]" +
                        "[25,grow,fill]" +
                        "[fill]"
        ));


        textCity=new JTextField();
        textCity.setFont(new Font("Arial",Font.ITALIC,20));
        startPanel.add(textCity, "cell 2 3,align center center, grow 0 0,width 250 ");

        enterButton=new JButton("Ввести");
        enterButton.setFont(new Font("Arial",Font.BOLD,60));
        enterButton.setForeground(new Color(0xE88D8D));
        startPanel.add(enterButton,"cell 2 5,align center center, grow 0 0");


        giveUpButton=new JButton("Сдаюсь");
        giveUpButton.setFont(new Font("Arial",Font.BOLD,60));
        giveUpButton.setForeground(new Color(0xE88D8D));
        startPanel.add(giveUpButton,"cell 2 6,align center center, grow 0 0");

        Image image1=Toolkit.getDefaultToolkit().createImage("gorod-animatsionnaya-kartinka-0029.gif");
        ImageIcon imageIcon1=new ImageIcon(image1);
        cityLabel1=new JLabel();
        imageIcon1.setImageObserver(cityLabel1);
        cityLabel1.setIcon(imageIcon1);
        startPanel.add(cityLabel1,"cell 1 1,align center center,grow 0 0,width 50");

        nameLabel=new JLabel();
        nameLabel.setText("Игра в города");
        nameLabel.setForeground(new Color(0xE88D8D));
        nameLabel.setFont(new Font("Arial",Font.BOLD,50));
        startPanel.add(nameLabel,"cell 2 1,align center center,grow 0 0");

        Image image2=Toolkit.getDefaultToolkit().createImage("gorod-animatsionnaya-kartinka-0011.gif");
        ImageIcon imageIcon=new ImageIcon(image2);
        cityLabel2=new JLabel();
        imageIcon.setImageObserver(cityLabel2);
        cityLabel2.setIcon(imageIcon);
        startPanel.add(cityLabel2,"cell 3 1,align center center,grow 0 0,width 50");

        systemText=new JTextField();
        systemText.setFont(new Font("Arial",Font.ITALIC,20));
        startPanel.add(systemText, "cell 2 4,align center center, grow 0 0,width 250 ");

        jFrame.add(startPanel);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);

    }
}
