import java.util.Random;


public abstract class Herbivore extends Animal{


    public Herbivore(int x, int y, int velocity, int stamina, int rep, World w) {
        super(x, y, velocity, stamina, rep, w);
        w.location[x][y].herb.add(this);
    }

    @Override
    public void move() {
        {
            Random rand = new Random();
            int x = rand.nextInt(velocity * 2) - velocity;
            int y = rand.nextInt(velocity * 2) - velocity;
            while(true)
                try {
                    w.location[this.x + x][this.y + y].herb.add(this);
                    w.location[this.x][this.y].herb.remove(this);
                    this.x=this.x+x;
                    this.y=this.y+y;
                    return;
                } catch (ArrayIndexOutOfBoundsException e){
                    x = rand.nextInt(velocity * 2) - velocity;
                    y = rand.nextInt(velocity * 2) - velocity;}
        }
    }

    @Override
    void eat() {//Search for grass in block
        if (w.location[x][y].hasgrass) {
            w.location[x][y].eaten();
            stamina = maxstamina;
            w.plantsleft-=1;
           if(GUI.MoreInfo) System.out.println("a " + getClass().getSimpleName() + " ate");
        }
        else {
            stamina-=1;
            starvation();
        }



    }
    public void death(){
        w.animals.remove(this);
        w.location[x][y].herb.remove(this);
        dead=true;
        if(GUI.MoreInfo) System.out.println("a " + getClass().getSimpleName() + " died");
    }
}
