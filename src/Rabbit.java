

public class Rabbit extends Herbivore {
    private  static int velocity=3;
    private static int stamina=2;
    private static int rep=3;


    public Rabbit(int x, int y,  World w) {

        super(x, y, velocity, stamina, rep, w);
        shortname='R';
        for( Statistics s : w.stat){
            if(this.getClass()==s.myClass){
                s.population++;


            }
        }
    }


    @Override
    protected void reproduce() {
            if(daysalive++>0&&daysalive%rep==0){
                new Rabbit(x,y,w);
              if(GUI.MoreInfo)  System.out.println("a "+this.getClass().getSimpleName()+" was birthed");


        }
    }

}
