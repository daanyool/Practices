import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ebike {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new LoginFrame();
        });
    }
}

class LoginFrame extends JFrame {
    private JPanel panel1;
    private JLabel usernameLabel, passwordLabel, logoLabel;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;

    LoginFrame() {
        super("User Login");

        setLayout(new BorderLayout());

        panel1 = new JPanel();
        //panel2 = new JPanel();

        panel1.setBackground(Color.gray);
       // panel2.setBackground(Color.LIGHT_GRAY);

        panel1.setPreferredSize(new Dimension(200, 100));
        //panel2.setPreferredSize(new Dimension(100, 100));

        panel1.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));

        // Add a logo
        ImageIcon logoIcon = new ImageIcon("Untitled.png");
        logoLabel = new JLabel(logoIcon);
        this.add(logoLabel);

        usernameLabel = new JLabel("Username: ");
        passwordLabel = new JLabel("Password: ");
        usernameField = new JTextField(15);
        passwordField = new JPasswordField(15);

        panel1.add(usernameLabel);
        panel1.add(usernameField);
        panel1.add(passwordLabel);
        panel1.add(passwordField);

        loginButton = new JButton("Log In");
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                if (username.equals("admin") && password.equals("password")) {
                    JFrame mainFrame = new Dashboard();
                    mainFrame.setVisible(true);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        panel1.add(loginButton);

       // JLabel label = new JLabel("EBIKE PARTS AND ACCESSORIES");
       // label.setFont(new Font("Arial", Font.BOLD, 24));

        //panel2.add(label);

        this.add(panel1, BorderLayout.WEST);
        //this.add(panel2, BorderLayout.NORTH);

        this.setSize(700, 700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}

class Dashboard extends JFrame {
    private JPanel panel1, panel2;
    private JLabel label, label2;
    private JComboBox<String> box;
    private JButton searchButton;
    private JMenu menu, submenu1, submenu2;
    private JMenuBar menubar;
    private JMenuItem n1, n2, n3, n4, n5, n6, n7, n8, t1;

    Dashboard() {
        menu = new JMenu("ABOUT US");
        submenu1 = new JMenu("MEMBERS");
        submenu2 = new JMenu("TEACHER");
        menubar = new JMenuBar();

        n1 = new JMenuItem("Batac");
        n2 = new JMenuItem("Ibona");
        n3 = new JMenuItem("Diaz");
        n4 = new JMenuItem("Daniel");
        n5 = new JMenuItem("Teopiz");
        n6 = new JMenuItem("Teogangco");
        n7 = new JMenuItem("Sy");
        n8 = new JMenuItem("Semontiza");

        t1 = new JMenuItem("Carl-san Kim");

        submenu1.add(n1);
        submenu1.add(n2);
        submenu1.add(n3);
        submenu1.add(n4);
        submenu1.add(n5);
        submenu1.add(n6);
        submenu1.add(n7);
        submenu1.add(n8);

        submenu2.add(t1);

        menu.add(submenu1);
        menu.add(submenu2);
        menubar.add(menu);

        panel1 = new JPanel();
        panel2 = new JPanel();

        panel1.setBackground(Color.gray);
        panel2.setBackground(Color.LIGHT_GRAY);

        panel1.setPreferredSize(new Dimension(200, 100));
        panel2.setPreferredSize(new Dimension(100, 100));

        panel1.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));

        String parts[] = {"Batteries", "Charger", "Tires", "Controllers", "Connectors",
                "Cycle Analysts", "DC-DC Converters", "Ebrakes", "Freewheels and Cassettes",
                "Lights", "Hub Motors", "Torque Sensors", "Solar", "Spokes",
                "Throttles", "Torque Arms", "Wiring", "Rims"};

        label2 = new JLabel("EBIKE PARTS AND ACCESSORIES");
        label2.setFont(new Font("Arial", Font.BOLD, 24));

        panel1.add(new JLabel("Parts:"));
        panel1.add(new JComboBox<>(parts));
        panel1.add(new JButton("Search"));

        String accessories[] = {"Helmet", "Locks", "Side Mirrors", "Bicycle Light", "Fenders", "Kickstands",
                "Phone mounts", "Speedometers", "Repair kits"};

        panel1.add(new JLabel("Accessories:"));
        panel1.add(new JComboBox<>(accessories));
        panel1.add(new JButton("Search"));

        panel2.add(label2);

        this.setJMenuBar(menubar);

        this.setLayout(new BorderLayout());
        this.add(panel1, BorderLayout.WEST);
        this.add(panel2, BorderLayout.NORTH);

        this.setSize(700, 700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}