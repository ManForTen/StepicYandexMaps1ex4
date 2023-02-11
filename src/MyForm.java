import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;

public class MyForm extends JFrame{

    private JPanel panel;
    private JLabel label;
    private JSlider slider1;

    MyForm() throws HeadlessException{
        super("Карта");
    }

    public void run() {
        addGui();
        addSliderActionListener();
    }

    public void addGui() {
        add(panel);
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600,600);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void addSliderActionListener() {
        slider1.addChangeListener(e -> {
            try {
                setImage();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
    }

    public void setImage() throws IOException {
        Image image = ImageIO.read(new URL("https://static-maps.yandex.ru/1.x/?ll=49.09893517912549,55.79675407179522&l=map&pt=49.09893517912549,55.79675407179522,flag&z=" + slider1.getValue()));
        label.setIcon(new ImageIcon(image));
    }

    public static void main(String[] args) {
        new MyForm().run();
    }
}
