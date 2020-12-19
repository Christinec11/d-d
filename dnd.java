import java.io.File;

import java.io.IOException;
import java.util.*;



class DNDcharacter implements Comparable<DNDcharacter>
{
    String name = "";
    String skill = "";
    int statistic = 0;
    int strength;
    int dexterity;
    int constitution;
    int intelligence;
    int wisdom;
    int charisma;

   public DNDcharacter(String name, int statistic, String skill, int strength, int dexterity, int constitution, int intelligence, int wisdom, int charisma)
   {
        this.name = name;
        this.statistic = statistic;
        this.skill = skill;
        this.strength = strength;
        this.dexterity = dexterity;
        this.constitution = constitution;
        this.intelligence = intelligence;
        this.wisdom = wisdom;
        this.charisma = charisma;
   }


   public String getSkill()
   {
       return this.skill;
   }

   public String getName()
   {
       return this.name;
   }

   public int getStat()
   {
       return this.statistic;
   }

   public int getStrength()
   {
       return this.strength;
   }

   public int getDexterity()
   {
       return this.dexterity;
   }
   public int getConstitution()
   {
       return this.constitution;
   }
   public int getIntelligence()
   {
       return this.intelligence;
   }
   public int getWisdom()
   {
       return this.wisdom;
   }

   public int getCharisma()
   {
       return this.charisma;
   }
   
    public static Comparator<DNDcharacter> charComp = new Comparator<DNDcharacter>(){
        public int compare(DNDcharacter char1, DNDcharacter char2){
            return char1.getCharisma() - char2.getCharisma();
        }
    };

    public static Comparator<DNDcharacter> dexComp = new Comparator<DNDcharacter>(){
        public int compare(DNDcharacter char1, DNDcharacter char2){
            return char1.getDexterity() - char2.getDexterity();
        }
    };

    public static Comparator<DNDcharacter> wisComp = new Comparator<DNDcharacter>(){
        public int compare(DNDcharacter char1, DNDcharacter char2){
            return char1.getWisdom() - char2.getWisdom();
        }
    };

    public static Comparator<DNDcharacter> strengthComp = new Comparator<DNDcharacter>(){
        public int compare(DNDcharacter char1, DNDcharacter char2){
            return char1.getStrength() - char2.getStrength();
        }
    };

    public static Comparator<DNDcharacter> intComp = new Comparator<DNDcharacter>(){
        public int compare(DNDcharacter char1, DNDcharacter char2){
            return char1.getIntelligence() - char2.getIntelligence();
        }
    };

    public static Comparator<DNDcharacter> getCon = new Comparator<DNDcharacter>(){
        public int compare(DNDcharacter char1, DNDcharacter char2){
            return char1.getConstitution() - char2.getConstitution();
        }
    };

    public int compareTo(DNDcharacter o) {
        
        return statistic-o.statistic;
    }

    public String toString()
    {
        
        return name+"(" + statistic +")";
    }
}
//every characters skill 
//add stuff to array then
//collections.sort

public class dnd {
    

    public static ArrayList<DNDcharacter> listofCharacters = new ArrayList<DNDcharacter>();
    public static void main(String[] args) throws IOException
    {
        File file = new File("character.txt");
        Scanner input = new Scanner(file);
        System.out.println("Please enter the skill you would like to sort D&D characters by:");
        Scanner in = new Scanner(System.in);
        System.out.println(in);
        String[] stat;
        readNames(input,listofCharacters,stat);
        sortStat(stat);

        //how would we sort by skill or stat
    }

    public static void readNames(Scanner input, ArrayList<DNDcharacter> listofCharacters,String [] stat)
    {
        
        while(input.hasNextLine());
        {
            
            String name = input.nextLine();
           int statistic;
           String skill;
            int str = 0,dex = 0,con = 0,intl = 0,wis = 0,chari = 0;

            String skillnstat = input.nextLine();
               stat = skillnstat.split(":");
                String skills = stat[0];
                Integer statistics = Integer.parseInt(stat[1]);
           
            for(int i = 0; i<6;i++)
            {
                // This is the strength field
                if (stat[0].equals("Strength"))
                    str = Integer.parseInt(stat[1]);

                    // This is the dexterity field
                else if (stat[0].equals("Dexterity"))
                    dex = Integer.parseInt(stat[1]);

                    // This is the constitution field
                else if (stat[0].equals("Constitution"))
                    con = Integer.parseInt(stat[1]);

                    // This is the intelligence field
                else if (stat[0].equals("Intelligence"))
                    intl = Integer.parseInt(stat[1]);

                    // This is the wisdom field
                else if (stat[0].equals("Wisdom"))
                    wis = Integer.parseInt(stat[1]);

                    // This is the charisma field
                else if (stat[0].equals("Charisma"))
                    chari = Integer.parseInt(stat[1]);
                
            }
            
            listofCharacters.add(new DNDcharacter(name, statistic,skill, str, dex, con, intl, wis, chari));
                // Skip ALL empty lines
                if(input.hasNextLine())
                {
                    if(input.nextLine().equals(""))
                    {

                    }
                }
                
    
    }


    }   
 public static void sortStat(String[] stat)
    {
        Arrays.sort(stat);
    }
}