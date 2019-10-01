

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class GUI {

    public static  boolean MoreInfo=false; //default value for checkbox providing extra information
    static JFrame window = new JFrame("Simulation Window");//simulation map
    static JFrame infowindow = new JFrame("Info");//information window of simulation

    public GUI() {
        int length = 0;
        int height = 0;
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Give length");
            int k = Integer.parseInt(br.readLine());
            length = k;
            System.out.println("Give height");
            k = Integer.parseInt(br.readLine());
            height = k;
            World w = new World(length, height);//create a map with given height and length
            window.setSize(900, 900);//window size
            window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            window.setLayout(new GridLayout(length, height));//split the window to grids
            window.setLocationRelativeTo(null);
            infowindow.setSize(400, 400);
            infowindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            infowindow.setLayout(new GridLayout(12, 2, 10, 10));
            //labels with information
            JLabel jlabel_turn = new JLabel("Turn :" + w.turnnumber, SwingConstants.CENTER);
            JLabel jlabel_rabbit_count = new JLabel("Rabbits :" + w.stat.get(1).population,SwingConstants.CENTER);
            JLabel jlabel_sheep_count = new JLabel("Sheep :" + w.stat.get(0).population,SwingConstants.CENTER);
            JLabel jlabel_lion_count = new JLabel("Lions :" + w.stat.get(3).population,SwingConstants.CENTER);
            JLabel jlabel_tiger_count = new JLabel("Tigers :" + w.stat.get(2).population,SwingConstants.CENTER);
            JLabel jlabel_placeholder = new JLabel("", SwingConstants.CENTER);
            JLabel jlabel_plants_to_population = new JLabel("Plants/Population:" + (((length * height) * 100 / ((length * height) +  w.stat.get(0).population + w.stat.get(1).population + w.stat.get(2).population + w.stat.get(3).population))) + "%", SwingConstants.CENTER);
            JLabel jlabel_plant_percentage_remaining = new JLabel("Plants :100%", SwingConstants.CENTER);
            JLabel jlabel_rabbits_killed_turn = new JLabel( " Rabbits got killed :"+ w.stat.get(1).killed , SwingConstants.CENTER);
            JLabel jlabel_rabbits_starved_turn = new JLabel(" Rabbits starved :"+w.stat.get(1).starved,SwingConstants.CENTER);
            JLabel jlabel_sheep_killed_turn = new JLabel(" Sheep got killed :"+w.stat.get(0).killed, SwingConstants.CENTER);
            JLabel jlabel_sheep_starved_turn = new JLabel(" Sheep starved :"+w.stat.get(0).starved, SwingConstants.CENTER);
            JLabel jlabel_tigers_starved_turn = new JLabel(" Tigers starved :"+w.stat.get(2).starved, SwingConstants.CENTER);
            JLabel jlabel_lions_starved_turn = new JLabel(" Lions starved :"+w.stat.get(3).starved, SwingConstants.CENTER);
            JLabel jlabel_rabbits_killed_total = new JLabel(" Total Rabbits killed :"+w.stat.get(1).totalkilled, SwingConstants.CENTER);
            JLabel jlabel_rabbits_starved_total = new JLabel(" Total Rabbits starved :"+w.stat.get(1).totalstarved, SwingConstants.CENTER);
            JLabel jlabel_sheep_killed_total = new JLabel(" Total Sheep killed :"+w.stat.get(0).totalkilled, SwingConstants.CENTER);
            JLabel jlabel_sheep_starved_total = new JLabel(" Total Sheep starved :"+w.stat.get(0).totalstarved, SwingConstants.CENTER);
            JLabel jlabel_tigers_starved_total = new JLabel(" Total Tigers starved :"+w.stat.get(2).totalstarved, SwingConstants.CENTER);
            JLabel jlabel_lions_starved_total = new JLabel(" Total Lions starved :"+w.stat.get(3).totalstarved, SwingConstants.CENTER);
            JLabel jlabel_herbivores_count = new JLabel("Herbivores :"+(w.stat.get(0).population+w.stat.get(1).population), SwingConstants.CENTER);
            JLabel jlabel_carnivores_count = new JLabel("Carnivores :"+(w.stat.get(2).population+ w.stat.get(3).population), SwingConstants.CENTER);
            //add labels to information window
            infowindow.add(jlabel_rabbit_count);
            infowindow.add(jlabel_lion_count);
            infowindow.add(jlabel_sheep_count);
            infowindow.add(jlabel_tiger_count);
            infowindow.add(jlabel_herbivores_count);
            infowindow.add(jlabel_carnivores_count);
            infowindow.add(jlabel_plants_to_population);
            infowindow.add(jlabel_plant_percentage_remaining);
            infowindow.add(jlabel_rabbits_killed_turn);
            infowindow.add(jlabel_rabbits_killed_total);
            infowindow.add(jlabel_rabbits_starved_turn);
            infowindow.add(jlabel_rabbits_starved_total);
            infowindow.add(jlabel_sheep_killed_turn);
            infowindow.add(jlabel_sheep_killed_total);
            infowindow.add(jlabel_sheep_starved_turn);
            infowindow.add(jlabel_sheep_starved_total);
            infowindow.add(jlabel_tigers_starved_turn);
            infowindow.add(jlabel_tigers_starved_total);
            infowindow.add(jlabel_lions_starved_turn);
            infowindow.add(jlabel_lions_starved_total);

            JButton jbutton_turn_button = new JButton("Next Turn");
            infowindow.add(jlabel_turn);
            infowindow.add(jbutton_turn_button);
            infowindow.add(jlabel_placeholder);
            JCheckBox jc1 = new JCheckBox("More Info");
            infowindow.add(jc1);

            final int finalLength = length;
            final int finalHeight = height;
            ActionListener al1 = new ActionListener()

            {
                @Override
                public void actionPerformed(ActionEvent e) {//On turn button click
                    if(jc1.isSelected()) MoreInfo=true; //check if extra information checkbox is selected
                    else MoreInfo=false;
                    w.WorldLoop();//Run a turn for the world
                    //Update labels
                    jlabel_turn.setText("Turn :" + w.turnnumber);
                    jlabel_rabbit_count.setText("Rabbits :" +  w.stat.get(1).population);
                    jlabel_sheep_count.setText("Sheep :" + w.stat.get(0).population);
                    jlabel_lion_count.setText("Lions :" +  w.stat.get(3).population);
                    jlabel_tiger_count.setText("Tigers :" +  w.stat.get(2).population);
                    jlabel_plants_to_population.setText("Plants/Population:" + (((w.plantsleft) * 100 / ((w.plantsleft) +  w.stat.get(0).population + w.stat.get(1).population + w.stat.get(2).population + w.stat.get(3).population))) + "%");
                    jlabel_rabbits_killed_turn.setText(" Rabbits got killed :"+w.stat.get(1).killed);
                    jlabel_rabbits_starved_turn.setText(" Rabbits starved :"+w.stat.get(1).starved);
                    jlabel_sheep_killed_turn.setText(" Sheep got killed :"+w.stat.get(0).killed);
                    jlabel_sheep_starved_turn.setText(" Sheep starved :"+w.stat.get(0).starved);
                    jlabel_tigers_starved_turn.setText(" Tigers starved :"+w.stat.get(2).starved);
                    jlabel_lions_starved_turn.setText(" Lions starved :"+w.stat.get(3).starved);
                    jlabel_plant_percentage_remaining.setText("Plants :" + ((w.plantsleft) * 100 / (finalLength * finalHeight)) + "%");
                    jlabel_rabbits_killed_total.setText(" Total Rabbits killed :"+w.stat.get(1).totalkilled);
                    jlabel_rabbits_starved_total.setText(" Total Rabbits starved :"+w.stat.get(1).totalstarved);
                    jlabel_sheep_killed_total.setText(" Total Sheep killed :"+w.stat.get(0).totalkilled);
                    jlabel_sheep_starved_total.setText(" Total Sheep starved :"+w.stat.get(0).totalstarved);
                    jlabel_tigers_starved_total.setText(" Total Tigers starved :"+w.stat.get(2).totalstarved);
                    jlabel_lions_starved_total.setText(" Total Lions starved :"+w.stat.get(3).totalstarved);
                    jlabel_herbivores_count.setText("Herbivores :"+(w.stat.get(0).population+w.stat.get(1).population));
                    jlabel_carnivores_count.setText("Carnivores :"+(w.stat.get(2).population+ w.stat.get(3).population));

                    if (w.plantsleft == 0) {//If all plants are eaten simulation will end
                        System.out.println("No plants left");
                        jlabel_placeholder.setText("No plants left");
                        jbutton_turn_button.setEnabled(false);
                    } else if (w.carnileft == 0) {//If all carnivores are dead simulation will end
                        jlabel_placeholder.setText("No carnivores left");
                        System.out.println("No carnivores left");
                        jbutton_turn_button.setEnabled(false);
                    }
                    ;

                }

            };
            jbutton_turn_button.addActionListener(al1);//Add action listener to turn button



            for (int i = 0; i < length; i++) {
                for (int j = 0; j < height; j++) {
                    window.add(w.location[i][j]);//Add all blocks to the window
                    w.location[i][j].setVisible(true);//Change each block to visible
                }
            }
            infowindow.setVisible(true);
            window.setVisible(true);

        }
        catch (NumberFormatException nfe1){
            System.out.println("Not an integer");
        }
        catch (IOException ioe){}
        catch(IllegalArgumentException iae){}
        catch (NegativeArraySizeException nas){
            System.out.println("Values must be positive");
        }

    }




}
