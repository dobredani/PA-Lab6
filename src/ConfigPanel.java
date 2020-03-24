import javax.swing.*;

public class ConfigPanel extends JPanel {
    final MainFrame frame;
    JLabel label; // we’re drawing regular polygons
    JLabel labelColor;
    JSpinner sidesField; // number of sides
    JComboBox colorCombo; // the color of the shape

    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }
    private void init() {
        //create the label and the spinner
        label = new JLabel("Number of sides:");
        sidesField = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
        sidesField.setValue(6); //default number of sides

        labelColor = new JLabel("Color:");
        colorCombo = new JComboBox();
        colorCombo.setPrototypeDisplayValue("text here");
        colorCombo.setSize(400,30);
        add(label); //JPanel uses FlowLayout by default
        add(sidesField);
        add(labelColor);
        add(colorCombo);
    }
}
