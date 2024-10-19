

import javax.swing.*;
import java.awt.*;

public class CaveDiverApp extends JFrame {
    private CaveGrid caveGrid;
    private JTextField depthField;

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

        escapeButton.addActionListener(e -> escape());
        newCaveButton.addActionListener(e -> caveGrid.generateNewCave());

        bottomPanel.add(depthLabel);
        bottomPanel.add(depthField);
        bottomPanel.add(escapeButton);
        bottomPanel.add(newCaveButton);

        add(bottomPanel, BorderLayout.SOUTH);
    }

    private void escape() {
        try {
            int depthRating = Integer.parseInt(depthField.getText());
            boolean success = caveGrid.findEscapeRoute(0, 0, 20, depthRating);
            if (!success) {
                JOptionPane.showMessageDialog(this, "No escape route found!");
            } else {
                caveGrid.repaint();
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid depth rating.");
        }
    }

    public static void main(String[] args) {
        CaveDiverApp app = new CaveDiverApp();
        app.setSize(600, 600);
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setVisible(true);
    }
}
