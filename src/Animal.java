


public abstract class Animal

{
    protected  int velocity;
    protected  int stamina;
    protected int maxstamina;
    protected  int rep;//reproduction
    protected int daysalive=0;
    protected int  x, y;
    protected World w;
    public boolean dead=false;
    public char shortname;

    public Animal(int x, int y,int velocity, int stamina, int rep,World w) {
        this.velocity = velocity;
        this.stamina = stamina;
        maxstamina=stamina;
        this.rep = rep;
        this.w = w;
        this.x=x;
        this.y=y;
        w.animals.add(this);

    }



    protected void starvation()

    {
        if (GUI.MoreInfo) System.out.println("a " + getClass().getSimpleName() + " didnt eat");

        if (stamina==0) {//ean to stamina tou zwou mhdenistei
            death();//to zwo pethenei
            for( Statistics s : w.stat)
            if(this.getClass()==s.myClass){
                s.starved++;
                s.totalstarved++;
                s.population--;
            }


            if(GUI.MoreInfo) System.out.println("a " + getClass().getSimpleName() + " starved");

        }
    }

    public void kill(Animal a){//xrhshmopoieitai gia na enhmeronontai oi plhrofories

        for( Statistics s : w.stat)
            if(a.getClass()==s.myClass){
                s.killed++;
                s.totalkilled++;
                s.population--;
            }

    }




    protected abstract void death();
    protected abstract void reproduce();
    public abstract void move() ;
    abstract void  eat();



}