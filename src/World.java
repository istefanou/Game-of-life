import java.util.LinkedList;
import java.util.Random;


public class World {

    public GrassPanel[][] location;//Contains the whole map created by blocks
    public LinkedList<Animal> animals = new LinkedList<>();//Contains all the animals of the world
    protected int plantsleft=0;
    protected int carnileft=0;
    protected int turnnumber;
    public  LinkedList<Statistics> stat = new LinkedList<>();//Contains statistical information


    public World(int width,int height) {


        stat.add(new Statistics(Sheep.class));
        stat.add(new Statistics(Rabbit.class));
        stat.add(new Statistics(Tiger.class));
        stat.add(new Statistics(Lion.class));

        plantsleft = width * height;
        location = new GrassPanel[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
               location[i][j] = new GrassPanel();//Creating the blocks
            }
        }

        Random rand = new Random();
        int x;
        int y;
        int z;
        z = rand.nextInt((width + height) / 2);
        for (int j = 0; j < z + 1; j++) {//Create a random amount of animals
            x = rand.nextInt(width);//With random coordinates
            y = rand.nextInt(height);
          new Lion(x, y, this);//First random creation is for lions
        }
        z = rand.nextInt(width * height);
        for (int j = 0; j < z + 1; j++) {
            x = rand.nextInt(width);
            y = rand.nextInt(height);
            new Sheep(x, y,  this);
        }
        z = rand.nextInt((width + height) / 2);
        for (int j = 0; j < z + 1; j++) {
            x = rand.nextInt(width);
            y = rand.nextInt(height);
           new Tiger(x, y, this);
        }
        z = rand.nextInt(width * height);
        for (int j = 0; j < z + 1; j++) {
            x = rand.nextInt(width);
            y = rand.nextInt(height);
           new Rabbit(x, y,  this);
        }
    }


    void WorldLoop() {
        turn();
        if(GUI.MoreInfo) {
            System.out.println("a turn passed");
            System.out.println("-------------");
            System.out.println("Current Turn: " + turnnumber);
        }
        turnnumber++;//Increase turn number
       GUI.window.repaint();//Update blocks ( strings and colors )
    }


    void  turn(){
        resetStat();
        LinkedList<Animal> temp = new LinkedList<>();//Create a temporary list of animals that will execute their actions this turn
        for(Animal a: animals)
           temp.add(a);
        int i=0;
        for(Animal a: temp){
            if(GUI.MoreInfo) System.out.println("animal no : " + i++);
            if(!a.dead){
            a.move();
            a.eat();
           if (!a.dead) a.reproduce();

            }
            else
            if(GUI.MoreInfo) System.out.println("a "+a.getClass().getSimpleName()+" is dead");
        }
    }

    private void resetStat(){
        //Reset of turn statistical information of the previous round
        for(Statistics s : stat){
            s.killed=0;
            s.starved=0;
        }
    }

}
