import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main(String[] args) {
        new MyText();
    }
}

class MyText extends JFrame implements ActionListener {
    private JComboBox<String> partComboBox;
    private JButton searchButton, nextButton, prevButton;
    private JLabel label, partImageLabel;
    private Map<String, String[]> partImageMap;
    private String[] currentImagePaths;
    private int currentIndex;

    MyText() {
        label = new JLabel("Select part: ");
        label.setBounds(100, 30, 150, 30);

        String[] partOptions = {
                "Batteries", "Charger", "Tires", "Controllers", "Connectors",
                "Cycle Analysts", "DC-DC Converters", "Ebrakes", "Freewheels and Cassettes",
                "Lights", "Hub Motors", "Solar", "Spokes",
                "Throttles", "Torque Arms", "Wiring", "Rims"
        };

        partComboBox = new JComboBox<>(partOptions);
        partComboBox.setBounds(100, 60, 200, 30);

        searchButton = new JButton("Search");
        searchButton.setBounds(320, 60, 80, 30);
        searchButton.addActionListener(this);

        nextButton = new JButton("Next");
        nextButton.setBounds(420, 60, 80, 30);
        nextButton.addActionListener(this);

        prevButton = new JButton("Previous");
        prevButton.setBounds(520, 60, 100, 30);
        prevButton.addActionListener(this);

        partImageLabel = new JLabel();
        partImageLabel.setBounds(100, 100, 500, 500);

        partImageMap = new HashMap<>();
        initializeImageMap();

        this.add(label);
        this.add(partComboBox);
        this.add(searchButton);
        this.add(nextButton);
        this.add(prevButton);
        this.add(partImageLabel);

        this.setSize(700, 700);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    private void initializeImageMap() {
        partImageMap.put("Rims", new String[]{
                "C:/Users/II/Downloads/Ebikes Parts/Rims/rim1.jpg",
                "C:/Users/II/Downloads/Ebikes Parts/Rims/rim2.jpg",
                "C:/Users/II/Downloads/Ebikes Parts/Rims/rim3.jpg",
                "C:/Users/II/Downloads/Ebikes Parts/Rims/rim4.jpg"
        });

        // Add more Parts
        // partImageMap.put("Name of Part(Tires)", new String[]{"path1.jpg", "path2.jpg", ...});
        // Just follow the one above
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == searchButton) {
            String selectedPart = (String) partComboBox.getSelectedItem();
            displayPartImages(selectedPart);
        } else if (e.getSource() == nextButton) {
            showNextImage();
        } else if (e.getSource() == prevButton) {
            showPreviousImage();
        }
    }

    private void displayPartImages(String selectedPart) {
        currentImagePaths = partImageMap.get(selectedPart);

        if (currentImagePaths != null && currentImagePaths.length > 0) {
            currentIndex = 0;
            showImageAtIndex(currentIndex);
        }
    }

    private void showNextImage() {
        if (currentImagePaths != null && currentIndex < currentImagePaths.length - 1) {
            currentIndex++;
            showImageAtIndex(currentIndex);
        }
    }

    private void showPreviousImage() {
        if (currentImagePaths != null && currentIndex > 0) {
            currentIndex--;
            showImageAtIndex(currentIndex);
        }
    }

    private void showImageAtIndex(int index) {
        partImageLabel.setIcon(new ImageIcon(currentImagePaths[index]));
    }
}