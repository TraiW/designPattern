package decorators;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EnabledDecorator extends Decorator {
    static JComponent disabled;
    JComponent decoratedComp;
    JComponent thisComp;

    public EnabledDecorator(JComponent c) {
        super(c);
        thisComp = this; //save this component
        this.decoratedComp = c;

        //catch mouse movements in inner class
        c.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                setDisabled();
                thisComp.repaint();
            }
        });
    }

    void setDisabled() {
        if (disabled != null) {
            disabled.setEnabled(true);
        }
        disabled = decoratedComp;
        decoratedComp.setEnabled(false);
    }
}
