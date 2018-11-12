import java.util.LinkedList;
import java.util.Random;


public class World {

    public GrassPanel[][] location;//pinakas pou periexei ta koutakia
    public LinkedList<Animal> animals = new LinkedList<>();//lista pou periexei ta zwa
    protected int plantsleft=0;
    protected int carnileft=0;
    protected int turnnumber;
    public  LinkedList<Statistics> stat = new LinkedList<>();//lista pou periexei tis plhrofories pou zhtaei h askhsh


    public World(int width,int height) {


        stat.add(new Statistics(Sheep.class));//1o sheep
        stat.add(new Statistics(Rabbit.class));//2o rabbit ktlp
        stat.add(new Statistics(Tiger.class));
        stat.add(new Statistics(Lion.class));

        plantsleft = width * height;
            location = new GrassPanel[width][height];
            for (int i = 0; i < width; i++) {
                for (int j = 0; j < height; j++) {
                   location[i][j] = new GrassPanel();//dhmiourgeia twn koutiwn
                }
            }

            Random rand = new Random();
            int x;
            int y;
            int z;
            z = rand.nextInt((width + height) / 2);
            for (int j = 0; j < z + 1; j++) {//dhmiourgeia parametropihmenou tuxaiou plhthous zwwn
                x = rand.nextInt(width);//tuxaies suntetagmenes
                y = rand.nextInt(height);
              new Lion(x, y, this);//dhmiourgeia (lion)
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
       // while (plantsleft>0&&carnileft>0) {
            turn();
        if(GUI.MoreInfo) {
            System.out.println("a turn passed");
            System.out.println("-------------");
            System.out.println("Current Turn: " + turnnumber);
        }
        turnnumber++;//aukshsh arithou gyron pou exoun perasei
       GUI.window.repaint();//enhmerwnei ta koutakia ( strings kai xrwmata)



    }


    void  turn(){
        resetStat();//mhdenismos ton dedomenon gyrou
        LinkedList<Animal> temp = new LinkedList<>();//dhmiourgeia prosorhnhs listas gia na kalestoun oi diadikasies kathe zwou
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
        for(Statistics s : stat){
            s.killed=0;
            s.starved=0;
        }
    }

}
