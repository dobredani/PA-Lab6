
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ControlPanel extends JPanel {
    final MainFrame frame;
    JButton saveBtn = new JButton("Save");
    JButton loadBtn = new JButton("Load");
    JButton resetBtn = new JButton("Reset");
    JButton exitBtn = new JButton("Exit");

    public ControlPanel(MainFrame frame) {
        this.frame = frame; init();
    }
    private void init() {
        //change the default layout manager (just for fun)
        setLayout(new GridLayout(1, 4));
        add(loadBtn);
        add(saveBtn);
        add(resetBtn);
        add(exitBtn);

        //configure listeners for all buttons
        saveBtn.addActionListener(this::save);
        loadBtn.addActionListener(this::load);
        exitBtn.addActionListener(this::exit);
        resetBtn.addActionListener(this::reset);
    }

    private void save(ActionEvent e) {
        try {
            FileDialog fileDialog = new FileDialog(frame, "Save",FileDialog.SAVE);
            fileDialog.setFile("*.jpg");
            fileDialog.setVisible(true);
            File file = new File( fileDialog.getDirectory() + fileDialog.getFile());

            ImageIO.write( frame.canvas.image, "PNG", file);
        } catch (IOException ex) { System.err.println(ex); }
    }

    private void load(ActionEvent e){
        try {
            FileDialog fileDialog = new FileDialog(frame, "Keep calm and select a file",FileDialog.LOAD);
            fileDialog.setDirectory("D:\\");
            fileDialog.setFile("*.png");
            fileDialog.setVisible(true);
            File file = new File("D:\\" + fileDialog.getFile());

            if (file != null)
                frame.canvas.loadImage(ImageIO.read(file));
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }

    private void reset(ActionEvent e){
        frame.canvas.reset();
    }

    private void exit(ActionEvent e){
        frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
    }
}
