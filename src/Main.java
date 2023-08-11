import java.util.Scanner;
import java.util.Random;
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner playerInput = new Scanner(System.in);
        Random generator = new Random();
        Character player = new Character();
        Character zombie = new Character();
        Character ghost = new Character();
        Character goblin = new Character();
        Character dungeonBoss = new Character();

        String[] monsters = {"Zombie", "Ghost", "Goblin"};
        int rMonster = generator.nextInt(monsters.length);
        String randomMonster = monsters[rMonster];

        String[] monstersRepeatable = {"Zombie", "Ghost", "Goblin"};
        int rMonsterRepeatable = generator.nextInt(monstersRepeatable.length);
        String randomMonsterRepeatable = monstersRepeatable[rMonsterRepeatable];


        int monsterAttack = generator.nextInt(6);
        if (monsterAttack == 0) {
            monsterAttack = 1;
        }
        int monsterHealth = generator.nextInt(16);
        if (monsterHealth == 0) {
            monsterHealth = 1;
        }

        int playerRecover1 = generator.nextInt(11);
        if (playerRecover1 == 0) {
            playerRecover1 = 1;
        }
        int playerRecover2 = generator.nextInt(6);
        if (playerRecover2 == 0) {
            playerRecover2 = 1;
        }
        int playerStrength = generator.nextInt(6);
        if (playerStrength == 0) {
            playerStrength = 1;
        }

        //Health, attack, stamina(every monster that gets attacked drains one stamina, if you run away you lose an extra stamina point)

        //Player Stats
        player.attack = 5;
        player.health = 20;
        player.stamina = 20;
        int h = 1;
        int i = 1;

        //Zombie Stats
        zombie.name = "Zombie";
        zombie.attack = 2;
        zombie.health = 10;

        //Ghost Stats
        ghost.name = "Ghost";
        ghost.attack = 2;
        ghost.health = 10;

        //Goblin Stats
        goblin.name = "Goblin";
        goblin.attack = 2;
        goblin.health = 10;

        //Takes the combined stats of all monsters killed and fights the player
        //With these stats he's gonna be op so there are going to be dodge frames
        //To fight him you have to dodge his attacks by pressing certain keys at certain times
        int monstersKilled = 0;
        int combinedAttack = 0;
        int combinedHealth = 0;
        if (monstersKilled == 10) {
            System.out.println("...");
            Thread.sleep(3000);
            System.out.println("A new enemy appeared...");
            Thread.sleep(3000);
            System.out.println("T H E  D U N G E O N  B O S S");
            Thread.sleep(2000);
            System.out.println("Health: " + dungeonBoss.health);
            Thread.sleep(1000);
            System.out.println("Attack: " + dungeonBoss.attack);

        }
        dungeonBoss.name = "Dungeon Boss";
        dungeonBoss.attack = combinedAttack;
        dungeonBoss.health = combinedHealth;





       System.out.println("Welcome to dungeon run!");
       Thread.sleep(2000);
       System.out.println("In this game you will have to slay as many monsters as possible and stay alive");
       Thread.sleep(3000);
       System.out.println("What would you like you character's name to be?");
       String userName = playerInput.nextLine();
        player.name = userName;
        System.out.println("Great Choice!");
        Thread.sleep(2000);
        System.out.println("Here are " + userName + "'s Stats: ");
        Thread.sleep(1000);
        System.out.println("Attack: " + player.attack);
        Thread.sleep(1000);
        System.out.println("Health: " + player.health);
        Thread.sleep(1000);
        System.out.println("Stamina: " + player.stamina);
        Thread.sleep(1000);
        System.out.println("(Besides your attack which gets capped at 10 your base stats cannot go over 20)");
        Thread.sleep(4000);
       System.out.println("Lets begin!");
        Thread.sleep(2000);


       System.out.println(userName + "'s first encounter is a " + randomMonster + "!");
       Character monster;
       if (randomMonster.equals ("Zombie")) {
           monster = zombie;
           Thread.sleep(2000);
           System.out.println("Zombie Stats: ");
           Thread.sleep(1000);
           System.out.println("Attack: " + zombie.attack);
           Thread.sleep(1000);
           System.out.println("Health: " + zombie.health);
       }
       else if (randomMonster.equals ("Ghost")) {
           monster = ghost;
           Thread.sleep(2000);
           System.out.println("Ghost Stats: ");
           Thread.sleep(1000);
           System.out.println("Attack: " + ghost.attack);
           Thread.sleep(1000);
           System.out.println("Health: " + ghost.health);
       }
       else {
           monster = goblin;
           Thread.sleep(2000);
           System.out.println("Goblin Stats: ");
           Thread.sleep(1000);
           System.out.println("Attack: " + goblin.attack);
           Thread.sleep(1000);
           System.out.println("Health: " + goblin.health);
       }


       while (monster.health > 0 && player.health > 0 && player.stamina > 0) {
           Thread.sleep(2000);
           System.out.println("Would you like to Attack it, recover, or run away?");
           Thread.sleep(1500);
           System.out.println("Attacking drains 1 stamina from the user");
           Thread.sleep(500);
           System.out.println("and running away drains 2 stamina from the user");
           String userInput = playerInput.nextLine();
           if (userInput.equals("Attack") || userInput.equals("attack")) {
               monster.health = monster.health - player.attack;
               if (monster.health > 0) {
                   System.out.println("You dealt 5 damage to the " + monster.name);
                   Thread.sleep(1000);
                   System.out.println(monster.name + " health -> " + monster.health);
                   --player.stamina;
               }
               else {
                   --player.stamina;
                   if (monster.health < 0) {
                       monster.health = 0;
                   }
                   System.out.println(monster.name + " health -> " + monster.health);
                   Thread.sleep(1000);
                   System.out.println("The " + monster.name + " was killed");
               }
           }
           else if (userInput.equals("Recover") || userInput.equals("recover")) {
               if (player.health < 20) {
                   player.health = player.health + playerRecover1;
                   if (player.health > 20) {
                       player.health = 20;
                   }
                   System.out.println(userName + " recovered " + playerRecover1 + "hp");
               }
               if (player.stamina < 20) {
                   player.stamina = player.stamina + playerRecover2;
                   if (player.stamina > 20) {
                       player.stamina = 20;
                   }
                   System.out.println(userName + " recovered " + playerRecover2 + "stamina");
               }

           }
           else {
               player.stamina = player.stamina - 2;
               System.out.println(userName + " has " + player.stamina + " stamina left");
               Thread.sleep(1000);
               System.out.println(userName + " ran away");
               break;
           }
           if (monster.health > 0) {
               player.health = player.health - monster.attack;
               Thread.sleep(1000);
               System.out.println("The " + monster.name + " hits " + userName +  " for " + monster.attack + " damage!");
           }
       }

       Thread.sleep(2000);
        System.out.println("Here are your Current Stats: ");
        Thread.sleep(1000);
        System.out.println("Attack: " + player.attack);
        Thread.sleep(1000);
        System.out.println("Health: " + player.health);
        Thread.sleep(1000);
        System.out.println("Stamina: " + player.stamina);
        Thread.sleep(3000);

        //New randomized monster Stats
        zombie.attack = monsterAttack;
        zombie.health = monsterHealth;
        ghost.attack = monsterAttack;
        ghost.health = monsterHealth;
        goblin.attack = monsterAttack;
        goblin.health = monsterHealth;


        System.out.println("Now that you have completed the tutorial");
        Thread.sleep(1000);
        System.out.println("monster stats are randomized, healing is randomized");
        Thread.sleep(3000);
        System.out.println("and stamina recovery is randomized.");
        Thread.sleep(4000);
        System.out.println("Good luck!!!");
        Thread.sleep(4000);







       while (player.health > 0 && player.stamina > 0) {
           Character monsterRepeatable;
           if (randomMonsterRepeatable.equals ("Zombie")) {
               monsterRepeatable = zombie;
               combinedHealth = combinedHealth + zombie.health;
               combinedAttack = combinedAttack + zombie.attack;
           }
           else if (randomMonsterRepeatable.equals ("Ghost")) {
               monsterRepeatable = ghost;
               combinedHealth = combinedHealth + ghost.health;
               combinedAttack = combinedAttack + ghost.attack;
           }
           else {
               monsterRepeatable = goblin;
               combinedHealth = combinedHealth + goblin.health;
               combinedAttack = combinedAttack + goblin.attack;
           }

           if (h == 1) {
               System.out.println("A " + randomMonsterRepeatable + " appeared!");
           }
           if (monsterRepeatable == zombie) {
               System.out.println("Zombie Stats: ");
               System.out.println("Attack: " + zombie.attack);
               System.out.println("Health: " + zombie.health);
           }
           if (monsterRepeatable == ghost) {
               System.out.println("Ghost Stats: ");
               System.out.println("Attack: " + ghost.attack);
               System.out.println("Health: " + ghost.health);
           }
           if (monsterRepeatable == goblin) {
               System.out.println("Goblin Stats: ");
               System.out.println("Attack: " + goblin.attack);
               System.out.println("Health: " + goblin.health);
           }
           System.out.println("Would you like to Attack it, recover, or run away?");
           String userInputRepeatable = playerInput.nextLine();
           if (userInputRepeatable.equals ("Attack") || userInputRepeatable.equals ("attack")) {
               monsterRepeatable.health = monsterRepeatable.health - player.attack;
               if (monsterRepeatable.health > 0) {
                   --player.stamina;
                   System.out.println("You dealt 5 damage to the " + monsterRepeatable.name);
                   System.out.println(monsterRepeatable.name + " health: " + monsterRepeatable.health);
               }
               else {
                   --player.stamina;
                   if (monsterRepeatable.health < 0) {
                       monsterRepeatable.health = 0;
                   }
                   System.out.println(monsterRepeatable.name + " health: " + monsterRepeatable.health);
                   System.out.println(monsterRepeatable.name + " was killed");
                   ++monstersKilled;
               }
           }
           else if (userInputRepeatable.equals("Recover") || userInputRepeatable.equals("recover")) {
               if (player.health < 20) {
                   player.health = player.health + playerRecover1;
                   if (player.health > 20) {
                       player.health = 20;
                   }
                   System.out.println(userName + " recovered " + playerRecover1 + "hp");
               }
               if (player.stamina < 20) {
                   player.stamina = player.stamina + playerRecover2;
                   if (player.health > 20) {
                       player.health = 20;
                   }
                   System.out.println(userName + " recovered " + playerRecover2 + "stamina");
               }

           }
           else {
               player.stamina = player.stamina - 2;
               System.out.println(userName + " has " + player.stamina + " stamina left");
               Thread.sleep(1000);
               System.out.println(userName + " ran away");
           }
           if (monsterRepeatable.health > 0 && !(userInputRepeatable.equals ("run away"))) {
               player.health = player.health - monsterRepeatable.attack;
               System.out.println("The " + monsterRepeatable.name + " hits " + userName +  " for " + monsterRepeatable.attack + " damage!");
           }

           Thread.sleep(1000);
           System.out.println("Here are your Current Stats: ");
           System.out.println("Attack: " + player.attack);
           System.out.println("Health: " + player.health);
           System.out.println("Stamina: " + player.stamina);

           Thread.sleep(3000);
           if (monsterRepeatable.health <= 0 ) {
               //20% chance of finding a sandwich
               int sandwich = generator.nextInt(6);
               if(sandwich == 1) {
                   if (player.health < 20 || player.stamina < 20) {
                       if (player.health < 20) {
                           player.health = player.health + 5;
                           if (player.health > 20) {
                               player.health = 20;
                           }
                       }
                       if (player.stamina < 20) {
                           player.stamina = player.stamina + 5;
                           if (player.stamina > 20) {
                               player.stamina = 20;
                           }
                       }
                   }
                   Thread.sleep(1000);
                   System.out.println("You found a sandwich!");
                   Thread.sleep(2000);
                   System.out.println("Health -> " + player.health);
                   Thread.sleep(1000);
                   System.out.println("Stamina -> " + player.stamina);
                   Thread.sleep(1000);
                   System.out.println("Health and stamina boosted!");
               }
               //20% chance of finding a protein shake
               int proteinShake = generator.nextInt(6);
               if (proteinShake == 1 && player.attack < 10) {
                   player.attack = player.attack + playerStrength;
                   if (player.attack > 10) {
                       player.attack = 10;
                   }
                   Thread.sleep(1000);
                   System.out.println("You found a protein shake!");
                   Thread.sleep(1000);
                   System.out.println("Attack -> " + player.attack);
               }

               rMonsterRepeatable = generator.nextInt(monstersRepeatable.length);
               randomMonsterRepeatable = monstersRepeatable[rMonsterRepeatable];
               monsterAttack = generator.nextInt(6);
               if (monsterAttack == 0) {
                   monsterAttack = 1;
               }
               monsterHealth = generator.nextInt(16);
               if (monsterHealth == 0) {
                   monsterHealth = 1;
               }
               zombie.attack = monsterAttack;
               zombie.health = monsterHealth;
               ghost.attack = monsterAttack;
               ghost.health = monsterHealth;
               goblin.attack = monsterAttack;
               goblin.health = monsterHealth;
               System.out.println("A " + randomMonsterRepeatable + " appeared!");
           }
           ++h;
       }
        if (player.health <= 0) {
            System.out.println("You ran out of health! \nGame Over!");
        }
        if (player.stamina <= 0) {
            System.out.println("You ran out of Stamina!\n Game Over!");
        }
        if (dungeonBoss.health <= 0 && monstersKilled >= 10) {
            System.out.println("Congratulations!");
            System.out.println("You Win!");
        }
    }
}