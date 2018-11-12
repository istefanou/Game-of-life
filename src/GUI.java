

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class GUI {

    public static  boolean MoreInfo=false; //arxikh timh gia to checkbox
    static JFrame window = new JFrame("Simulation Window");//kurio parathiro
    static JFrame infowindow = new JFrame("Info");//menu me epiloges kai dedomena

    public GUI() {
        System.setProperty("java.util.Arrays.useLegacyMergeSort", "true");
        int length = 0;
        int height = 0;
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Give length");
            int k = Integer.parseInt(br.readLine());//diavazei diastaseis
            length = k;
            System.out.println("Give height");
            k = Integer.parseInt(br.readLine());
            height = k;
            World w = new World(length, height);//dhmiourgei antikeimeno tupou world me tis diastaseis tou xrhsh


            window.setSize(900, 900);//orizoume to megethos tou parathurou
            window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            window.setLayout(new GridLayout(length, height));//xwrizoume to parathiro se lengthxheight koutakia
            window.setLocationRelativeTo(null);
            infowindow.setSize(400, 400);
            infowindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            infowindow.setLayout(new GridLayout(12, 2, 10, 10));
            JLabel jl1 = new JLabel("Turn :" + w.turnnumber, SwingConstants.CENTER);//label me plhrofories
            JLabel jl2 = new JLabel("Rabbits :" + w.stat.get(1).population,SwingConstants.CENTER);
            JLabel jl3 = new JLabel("Sheep :" + w.stat.get(0).population,SwingConstants.CENTER);
            JLabel jl4 = new JLabel("Lions :" + w.stat.get(3).population,SwingConstants.CENTER);
            JLabel jl5 = new JLabel("Tigers :" + w.stat.get(2).population,SwingConstants.CENTER);
            JLabel jl6 = new JLabel("", SwingConstants.CENTER);
            JLabel jl7 = new JLabel("Plants/Population:" + (((length * height) * 100 / ((length * height) +  w.stat.get(0).population + w.stat.get(1).population + w.stat.get(2).population + w.stat.get(3).population))) + "%", SwingConstants.CENTER);
            JLabel jl20 = new JLabel("Plants :100%", SwingConstants.CENTER);
            JLabel jl8 = new JLabel( " Rabbits got killed :"+ w.stat.get(1).killed , SwingConstants.CENTER);
            JLabel jl9 = new JLabel(" Rabbits starved :"+w.stat.get(1).starved,SwingConstants.CENTER);
            JLabel jl10 = new JLabel(" Sheep got killed :"+w.stat.get(0).killed, SwingConstants.CENTER);
            JLabel jl11 = new JLabel(" Sheep starved :"+w.stat.get(0).starved, SwingConstants.CENTER);
            JLabel jl12 = new JLabel(" Tigers starved :"+w.stat.get(2).starved, SwingConstants.CENTER);
            JLabel jl13 = new JLabel(" Lions starved :"+w.stat.get(3).starved, SwingConstants.CENTER);
            JLabel jl14 = new JLabel(" Total Rabbits killed :"+w.stat.get(1).totalkilled, SwingConstants.CENTER);
            JLabel jl15 = new JLabel(" Total Rabbits starved :"+w.stat.get(1).totalstarved, SwingConstants.CENTER);
            JLabel jl16 = new JLabel(" Total Sheep killed :"+w.stat.get(0).totalkilled, SwingConstants.CENTER);
            JLabel jl17 = new JLabel(" Total Sheep starved :"+w.stat.get(0).totalstarved, SwingConstants.CENTER);
            JLabel jl18 = new JLabel(" Total Tigers starved :"+w.stat.get(2).totalstarved, SwingConstants.CENTER);
            JLabel jl19 = new JLabel(" Total Lions starved :"+w.stat.get(3).totalstarved, SwingConstants.CENTER);
            JLabel jl21 = new JLabel("Herbivores :"+(w.stat.get(0).population+w.stat.get(1).population), SwingConstants.CENTER);
            JLabel jl22 = new JLabel("Carnivores :"+(w.stat.get(2).population+ w.stat.get(3).population), SwingConstants.CENTER);
            infowindow.add(jl2);//prosthikh tou label sto parathiro
            infowindow.add(jl4);
            infowindow.add(jl3);
            infowindow.add(jl5);
            infowindow.add(jl21);
            infowindow.add(jl22);
            infowindow.add(jl7);
            infowindow.add(jl20);
            infowindow.add(jl8);
            infowindow.add(jl14);
            infowindow.add(jl9);
            infowindow.add(jl15);
            infowindow.add(jl10);
            infowindow.add(jl16);
            infowindow.add(jl11);
            infowindow.add(jl17);
            infowindow.add(jl12);
            infowindow.add(jl18);
            infowindow.add(jl13);
            infowindow.add(jl19);

            JButton jb1 = new JButton("Next Turn");//dhmiourgeia koubiou
            infowindow.add(jl1);
            infowindow.add(jb1);
            infowindow.add(jl6);
            JCheckBox jc1 = new JCheckBox("More Info");//dhmiourgeia checkbox
            infowindow.add(jc1);

            final int finalLength = length;
            final int finalHeight = height;
            ActionListener al1 = new ActionListener()

            {
                @Override
                public void actionPerformed(ActionEvent e) {//sto pathma tou koubiou
                    if(jc1.isSelected()) MoreInfo=true; // elenxei to checkbox
                    else MoreInfo=false;
                    w.WorldLoop();//trexei enan gyro
                    jl1.setText("Turn :" + w.turnnumber);//update tou label
                    jl2.setText("Rabbits :" +  w.stat.get(1).population);
                    jl3.setText("Sheep :" + w.stat.get(0).population);
                    jl4.setText("Lions :" +  w.stat.get(3).population);
                    jl5.setText("Tigers :" +  w.stat.get(2).population);
                    jl7.setText("Plants/Population:" + (((w.plantsleft) * 100 / ((w.plantsleft) +  w.stat.get(0).population + w.stat.get(1).population + w.stat.get(2).population + w.stat.get(3).population))) + "%");
                    jl8.setText(" Rabbits got killed :"+w.stat.get(1).killed);
                    jl9.setText(" Rabbits starved :"+w.stat.get(1).starved);
                    jl10.setText(" Sheep got killed :"+w.stat.get(0).killed);
                    jl11.setText(" Sheep starved :"+w.stat.get(0).starved);
                    jl12.setText(" Tigers starved :"+w.stat.get(2).starved);
                    jl13.setText(" Lions starved :"+w.stat.get(3).starved);
                    jl20.setText("Plants :" + ((w.plantsleft) * 100 / (finalLength * finalHeight)) + "%");
                    jl14.setText(" Total Rabbits killed :"+w.stat.get(1).totalkilled);
                    jl15.setText(" Total Rabbits starved :"+w.stat.get(1).totalstarved);
                    jl16.setText(" Total Sheep killed :"+w.stat.get(0).totalkilled);
                    jl17.setText(" Total Sheep starved :"+w.stat.get(0).totalstarved);
                    jl18.setText(" Total Tigers starved :"+w.stat.get(2).totalstarved);
                    jl19.setText(" Total Lions starved :"+w.stat.get(3).totalstarved);
                    jl21.setText("Herbivores :"+(w.stat.get(0).population+w.stat.get(1).population));
                    jl22.setText("Carnivores :"+(w.stat.get(2).population+ w.stat.get(3).population));

                    if (w.plantsleft == 0) {//elenxos an prepei na teliwsei to simulation
                        System.out.println("No plants left");
                        jl6.setText("No plants left");//katalhlo munhma
                        jb1.setEnabled(false); //disable to koubi gia ton gyro
                    } else if (w.carnileft == 0) {
                        jl6.setText("No carnivores left");
                        System.out.println("No carnivores left");
                        jb1.setEnabled(false);
                    }
                    ;

                }

            };
            jb1.addActionListener(al1);//to action listener na doulevei me ton koubi



            for (int i = 0; i < length; i++) {
                for (int j = 0; j < height; j++) {
                    window.add(w.location[i][j]);//prosthikh ton koutiwn sto parathiro
                    w.location[i][j].setVisible(true);//allagei se orato to kathe koutaki
                }
            }
            infowindow.setVisible(true);
            window.setVisible(true);

        }
        catch (NumberFormatException nfe1){
            System.out.println("Not an integer");
        }
        catch (IOException ioe){}
        catch(IllegalArgumentException iae){
            System.out.println("PREPEI NA EINAI THETIKES OI TIMES");
        }
        catch (NegativeArraySizeException nas){
            System.out.println("PREPEI NA EINAI THETIKES OI TIMES");
        }

    }




}
