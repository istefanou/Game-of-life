

public class Lion extends Carnivore {
    private  static int velocity=2;
    private static int stamina=3;
    private static int rep=6;


    public Lion(int x, int y,  World w) {

        super(x, y, velocity, stamina, rep, w);
        shortname='L';
        for( Statistics s : w.stat){
            if(this.getClass()==s.myClass){
                s.population++;


            }
        }
    }


    @Override
    protected void reproduce() {
        if(daysalive++>0&&daysalive%rep==0){
            new Lion(x,y,w);
            if(GUI.MoreInfo) System.out.println("a "+this.getClass().getSimpleName()+" was birthed");
        }
    }

}
