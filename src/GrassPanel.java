import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;


public class GrassPanel extends JPanel {
    public boolean hasgrass=true;//Default value true, all panels start with grass
    public  LinkedList<Herbivore> herb = new LinkedList<>();//Herbivores in that block
    public  LinkedList<Carnivore> carn = new LinkedList<>();
    private JLabel jlabel_placeholder = new JLabel("");
    public GrassPanel(){
        add(jlabel_placeholder);
        jlabel_placeholder.setVisible(true);

    }

    @Override
    public void paint(Graphics g) {//When the panels become visible
        super.paint(g);
        String temp="";
        if (hasgrass)
        {
            setBackground(Color.GREEN);
        }
        else setBackground(Color.lightGray);

        for(Animal a:carn)//Print Letters of animals in the panel
            temp=temp+a.shortname+" ";
        for(Animal a:herb)
            temp=temp+a.shortname+" ";
        jlabel_placeholder.setText(temp);
        jlabel_placeholder.validate();//Update panel information
    }

    public void eaten(){
        hasgrass=false;

    }





}
