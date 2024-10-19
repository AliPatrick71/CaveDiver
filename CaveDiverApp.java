import java.awt.*;
import javax.swing.*;

/**
 * Cave Diver Project
 * Author: 
 * Date: 9th October 2024
 * 
 * The CaveDiverApp class creates the main application window and controls user interaction 
 * with the cave grid, allowing the user to attempt to escape the cave or generate a new cave.
 */
public class CaveDiverApp extends JFrame {
    private CaveGrid caveGrid;  // The panel that displays the cave grid.
    private JTextField depthField;  // Text field for entering the diver's depth rating.

    /**
     * Constructs the main application window and sets up the GUI components.
     */
    public CaveDiverApp() {
        setTitle("Cave Diver");
        setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("Cave Diver", JLabel.CENTER);
        add(titleLabel, BorderLayout.NORTH);

        caveGrid = new CaveGrid();
        add(caveGrid, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout());

        JLabel depthLabel = new JLabel("Depth Rating:");
        depthField = new JTextField(5);
        JButton escapeButton = new JButton("Escape");
        JButton newCaveButton = new JButton("New Cave");

        // Handle the "Escape" button click.
        escapeButton.addActionListener(e -> escape());

        // Handle the "New Cave" button click.
        newCaveButton.addActionListener(e -> caveGrid.generateNewCave());

        bottomPanel.add(depthLabel);
        bottomPanel.add(depthField);
        bottomPanel.add(escapeButton);
        bottomPanel.add(newCaveButton);

        add(bottomPanel, BorderLayout.SOUTH);
    }

    /**
     * Handles the escape attempt by trying to find an escape route for the diver based on 
     * the depth rating entered by the user.
     */
    private void escape() {
        try {
            int depthRating = Integer.parseInt(depthField.getText());
            boolean success = caveGrid.findEscapeRoute(0, 0, 20, depthRating);
            if (!success) {
                JOptionPane.showMessageDialog(this, "No escape route found!");
            } else {
                caveGrid.repaint();  // Repaint the grid to show the escape route.
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid depth rating.");
        }
    }

    /**
     * The main method that launches the CaveDiverApp.
     * 
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        CaveDiverApp app = new CaveDiverApp();
        app.setSize(600, 600);
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setVisible(true);
    }
}
