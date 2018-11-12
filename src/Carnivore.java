import java.util.Random;

public abstract class Carnivore extends Animal {


    public Carnivore(int x, int y, int velocity, int stamina, int rep, World w) {
        super(x, y, velocity, stamina, rep, w);
        w.location[x][y].carn.add(this);
        w.carnileft++;//kratame ton arithmo carnileft gia na kseroumai pote prepei na teliwsei to simulation
    }

    @Override
    public void move() {
        {
            Random rand = new Random();
            int x = rand.nextInt(velocity * 2) - velocity;
            int y = rand.nextInt(velocity * 2) - velocity;//suntetegmenes gia na kinithei tuxai to zwo
            while(true)
                try {
                    w.location[this.x + x][this.y + y].carn.add(this);//prosthetei sthn lista tou koutou to zwo auto,o logos pou grapsame 2 move htan gia na kseroume ksexwrista poia carnivore kai pia herbivore vriskontai sto kouti
                    w.location[this.x][this.y].carn.remove(this);
                    this.x+=x;
                    this.y+=y;
                    return;
                } catch (ArrayIndexOutOfBoundsException e){
                     x = rand.nextInt(velocity * 2) - velocity;
                     y = rand.nextInt(velocity * 2) - velocity;
                }
        }
    }

    @Override
    void eat() {
        Animal a = search();//psaxnei gia herbivore konta tou
                if (a!=null) {
                    a.death();//an vrei tote kalei methodo oti pethane to herbivore
                    stamina = maxstamina;//gemizei to stamina
                    if (GUI.MoreInfo) System.out.println("a " + getClass().getSimpleName() + " ate");
                    kill(a);//enhmeronoumai ta zwa pou exoun fagothei
                }
                else{
                    stamina-=1;//alliws meiwnetai to stamina
                    starvation();}//elenxei an exei ginei 0 ktlp
    }
   private Animal search() {//anazhthsei sta geitonika koutia
       for (int i = x - 1; i <= x + 1; i++) {
           for (int k = y - 1; k <= y + 1; k++) {
               try{
                if (!w.location[i][k].herb.isEmpty())
                    return w.location[i][k].herb.get(0);}//an to vrei epistrefei thn topothesia
               catch(ArrayIndexOutOfBoundsException e) {
                    ;
                    }
           }
       }
       return null;
   }

    public void death(){//otan pethenei prepei na afaireitai apo tis listes
        w.animals.remove(this);
        w.location[x][y].carn.remove(this);
        dead=true;
        w.carnileft-=1;
        if(GUI.MoreInfo)System.out.println("a " + getClass().getSimpleName() + " died");
    }
}
