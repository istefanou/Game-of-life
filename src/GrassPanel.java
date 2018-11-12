import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;


public class GrassPanel extends JPanel {
    public boolean hasgrass=true;//arxika exoun ola ta kouta grasidi
    public  LinkedList<Herbivore> herb = new LinkedList<>();//lista me herbivore  gia to kouti
    public  LinkedList<Carnivore> carn = new LinkedList<>();
    private JLabel jl1 = new JLabel("");
    public GrassPanel(){
        add(jl1);
        jl1.setVisible(true);

    }

    @Override
    public void paint(Graphics g) {//kaleitai otan ginoun visible
        super.paint(g);
        String temp="";
        if ( hasgrass)//an exei grass prassino
        {
            setBackground(Color.GREEN);
        }
        else setBackground(Color.lightGray);

        for(Animal a:carn)//gia na emfanizei pia zwa exei to kouti
            temp=temp+a.shortname+" ";
        for(Animal a:herb)
            temp=temp+a.shortname+" ";
        jl1.setText(temp);
        jl1.validate();//enhmerwsh  tis plhrofories tou koutiou
    }

    public void eaten(){
        hasgrass=false;

    }





}
