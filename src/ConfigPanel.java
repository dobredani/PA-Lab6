import com.sun.org.apache.bcel.internal.generic.JsrInstruction;

import javax.swing.*;
import java.awt.*;

public class ConfigPanel extends JPanel {
    final MainFrame frame;
    JLabel label; // we’re drawing regular polygons
    JLabel labelShape;
    JLabel labelSize;
    private JSpinner sidesField; // number of sides
    private JSlider sizeField; // number of sides
    private JComboBox shapeCombo; // the color of the shape

    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }
    private void init() {
        //create the label and the spinner
        label = new JLabel("Number of sides:");
        setSidesField(new JSpinner(new SpinnerNumberModel(6, 3, 100, 1)));
        getSidesField().setValue(6); //default number of sides

        labelSize = new JLabel("Size:");
        setSizeField(new JSlider(JSlider.HORIZONTAL,5,100,25));
        getSizeField().setValue(30); //default size

        labelShape = new JLabel("Shape:");
        setShapeCombo(new JComboBox());
        getShapeCombo().setPrototypeDisplayValue("text here");
        getShapeCombo().setPreferredSize(new Dimension(200,30 ));
        getShapeCombo().addItem("Regular Polygon");
        getShapeCombo().addItem("Node Shape");
        getShapeCombo().setSelectedIndex(1);

        add(label); //JPanel uses FlowLayout by default
        add(getSidesField());
        add(labelSize);
        add(getSizeField());
        add(labelShape);
        add(getShapeCombo());
    }

    public JSpinner getSidesField() {
        return sidesField;
    }

    public void setSidesField(JSpinner sidesField) {
        this.sidesField = sidesField;
    }

    public JComboBox getShapeCombo() {
        return shapeCombo;
    }

    public void setShapeCombo(JComboBox shapeCombo) {
        this.shapeCombo = shapeCombo;
    }

    public JSlider getSizeField() {
        return sizeField;
    }

    public void setSizeField(JSlider sizeField) {
        this.sizeField = sizeField;
    }
}
