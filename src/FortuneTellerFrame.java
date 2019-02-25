import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Random;

public class FortuneTellerFrame extends JFrame {
    private ArrayList<String> fortunes;

    JPanel main, top, middle, bottom;
    JLabel label;
    JButton fortuneButton, quitBtn;
    JTextArea fortune;
    JScrollPane scrollPane;

    public FortuneTellerFrame()
    {
        super("Fortune Teller");
        // configure the GUI
        main = new JPanel();

        createTopPanel();
        createMiddlePanel();
        createBottomPanel();


        main.setLayout(new BorderLayout());
        main.add(top,BorderLayout.NORTH);
        main.add(scrollPane,BorderLayout.CENTER);
        main.add(bottom,BorderLayout.SOUTH);

        // And add Main to the JFrame
        add(main);

        generateFortune();
        setSize(400, 400);
        //frame.pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



    }

    private void createTopPanel()
    {
        // Top panel
        top = new JPanel();
        label = new JLabel("Fortune Teller");
        label.setFont(new Font("Helvetica", Font.PLAIN, 36));
        label.setForeground(Color.black);
        top.add(label);
        ImageIcon fortuneTeller = new ImageIcon(this.getClass().getResource("fortunetellerpic"));
    }
    private void createMiddlePanel()
    {
        this.fortune = new JTextArea();
        this.scrollPane = new JScrollPane(this.fortune);
    }

    private void createBottomPanel()
    {
        //Control Panel
        bottom = new JPanel();
        fortuneButton = new JButton("Read My Fortune");
        // clicker = new ClickListener();

        fortuneButton.addActionListener((ActionEvent ae) -> {

            Random rnd = new Random();
            String nextFortune = fortunes.get(rnd.nextInt(fortunes.size())) + "\n";

            while (fortune.getText().endsWith(nextFortune)) {
                nextFortune = fortunes.get(rnd.nextInt(fortunes.size())) + "\n";
            }

            fortune.append(nextFortune);


        });
        fortuneButton.setFont(new Font("Arial", Font.PLAIN, 18));
        quitBtn = new JButton("Quit");
        quitBtn.addActionListener((ActionEvent ae) -> {
            System.exit(0);
        });
        quitBtn.setFont(new Font("Arial", Font.PLAIN, 18));
        bottom.add(fortuneButton);
        bottom.add(quitBtn);
    }
    private void generateFortune(){
       this.fortunes = new ArrayList<String>(12);
        fortunes.add("You will ");
        fortunes.add("fortune 1");
        fortunes.add("fortune 2");
        fortunes.add("fortune 3");
        fortunes.add("fortune 4");
        fortunes.add("fortune 5");
        fortunes.add("fortune 6");
        fortunes.add("fortune 7");
        fortunes.add("fortune 8");
        fortunes.add("fortune 9");
        fortunes.add("fortune 10");
        fortunes.add("fortune 11");
    }




}
