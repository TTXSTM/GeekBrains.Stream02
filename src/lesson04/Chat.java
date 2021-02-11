package lesson04;


    import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;


    public class Chat extends JFrame{
        JPanel jpN = new JPanel(new GridLayout());
        JPanel jpS = new JPanel(new GridLayout());

        JButton jb = new JButton("SEND");
        JTextArea jta = new JTextArea();
        JScrollPane jsp = new JScrollPane(jta);
        JTextField jtf = new JTextField();
        JMenuBar mainMenu = new JMenuBar();
        JMenuItem miFileExit = new JMenuItem("Exit");
        PrintWriter pw = new PrintWriter(new FileWriter("1.txt"));

        Chat() throws IOException {
            super("EZ chat");
            setSize(300, 400);
            setMinimumSize(new Dimension(300, 400));

            jta.setLineWrap(true);
            jta.setEditable(false);


            jb.addActionListener(e -> {
                sendMessage();
            });
            jtf.addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    if (e.getKeyCode() == KeyEvent.VK_ENTER) sendMessage();
                }
            });

            jpN.add(jsp);
            jpS.add(jtf);
            jpS.add(jb);

            add(jpN);
            add("South", jpS);

            //MENU
            setJMenuBar(mainMenu);


            miFileExit.addActionListener(e -> System.exit(0));
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            setLocationRelativeTo(null);
            setVisible(true);
        }


        void sendMessage() {
            String out = jtf.getText();
            jta.append(getTime() + ": " + out + "\n");
            pw.append(getTime() + ": " + out + "\n");
            pw.flush();
            jtf.setText("");
            jtf.grabFocus();
        }


        public String getTime() {
            return new SimpleDateFormat("HH:mm:ss").format(new Date());
        }

    }

