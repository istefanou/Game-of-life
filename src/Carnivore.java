import java.util.Random;

public abstract class Carnivore extends Animal {


    public Carnivore(int x, int y, int velocity, int stamina, int rep, World w) {
        super(x, y, velocity, stamina, rep, w);
        w.location[x][y].carn.add(this);
        w.carnileft++;//Keep track of carnivores left to end simulation if value is 0
    }

    @Override
    public void move() {
        {
            Random rand = new Random();
            int x = rand.nextInt(velocity * 2) - velocity;//Random movement of animal
            int y = rand.nextInt(velocity * 2) - velocity;
            while(true)
                try {
                    w.location[this.x + x][this.y + y].carn.add(this);//Save it to blocks carnivores
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
        Animal a = search();//Search for herbivore near it
                if (a!=null) {
                    a.death();//Mark animal found as dead
                    stamina = maxstamina;//Fill stamina
                    if (GUI.MoreInfo) System.out.println("a " + getClass().getSimpleName() + " ate");
                    kill(a);//Count kill statistics
                }
                else{
                    stamina-=1;
                    starvation();//Check if animal will starve
                }
    }
   private Animal search() {
       for (int i = x - 1; i <= x + 1; i++) {
           for (int k = y - 1; k <= y + 1; k++) {
               try{
                if (!w.location[i][k].herb.isEmpty())
                    return w.location[i][k].herb.get(0);}
               catch(ArrayIndexOutOfBoundsException e) {
                    ;
                    }
           }
       }
       return null;
   }

    public void death(){
        w.animals.remove(this);
        w.location[x][y].carn.remove(this);
        dead=true;
        w.carnileft-=1;
        if(GUI.MoreInfo)System.out.println("a " + getClass().getSimpleName() + " died");
    }
}
