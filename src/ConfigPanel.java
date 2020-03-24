import javax.swing.*;

public class ConfigPanel extends JPanel {
    final MainFrame frame;
    JLabel label; // we’re drawing regular polygons
    JLabel labelColor;
    private JSpinner sidesField; // number of sides
    private JComboBox colorCombo; // the color of the shape

    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }
    private void init() {
        //create the label and the spinner
        label = new JLabel("Number of sides:");
        setSidesField(new JSpinner(new SpinnerNumberModel(0, 0, 100, 1)));
        getSidesField().setValue(6); //default number of sides

        labelColor = new JLabel("Color:");
        setColorCombo(new JComboBox());
        getColorCombo().setPrototypeDisplayValue("text here");
        getColorCombo().setSize(400,30);
        add(label); //JPanel uses FlowLayout by default
        add(getSidesField());
        add(labelColor);
        add(getColorCombo());
    }

    public JSpinner getSidesField() {
        return sidesField;
    }

    public void setSidesField(JSpinner sidesField) {
        this.sidesField = sidesField;
    }

    public JComboBox getColorCombo() {
        return colorCombo;
    }

    public void setColorCombo(JComboBox colorCombo) {
        this.colorCombo = colorCombo;
    }
}
