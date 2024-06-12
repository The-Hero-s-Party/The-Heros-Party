import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


//I'll figure the icon thing out later
//import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;


public class Webpage {


    JFrame window;
    Container con;
    JPanel gametitle, startbuttonPanel, mainText, choiceBoard, player;
    JLabel Hero, HP, HPno, Weapon, WeaponName;
    Font titleFont = new Font("Times New Roman", Font.PLAIN, 27);
    Font button = new Font("Times New Roman", Font.PLAIN, 20);
    JButton startButton, choice1, choice2, choice3, choice4;
    JTextArea mainTextArea;
    int playerHP, monsterHP, manaStone;
    String weapon, position;


    TitleScreen gameHandler = new TitleScreen();
    choiceHandler choiceHandler = new choiceHandler();

    //I need to cook up an image for the logo
    //ImageIcon logo = new ImageIcon("");


    public static void main(String[] args) throws Exception {


        new Webpage();
    }


    public Webpage(){


            //creates window and customize the size
            window = new JFrame();
            window.setSize(360,640);
            //allows window to be closed properly
            window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            //set background colour
            window.getContentPane().setBackground(Color.black);
            //disable defaultlayout of window
            window.setLayout(null);
            //window.setIconImage(logo.getImage());
            con = window.getContentPane();

            //add title and position it at a specfic point on the window
            gametitle = new JPanel();
            gametitle.setBounds(20,100,300,75);
            gametitle.setBackground(Color.blue);
            con.add(gametitle);
            Hero = new JLabel("The Hero's Party"); 
            Hero.setForeground(Color.white);
            Hero.setFont(titleFont);


            startbuttonPanel = new JPanel();
            startbuttonPanel.setBounds(125,350,100,50);
            startbuttonPanel.setBackground(Color.blue);

            startButton = new JButton("START");
            startButton.setBackground(Color.black);
            startButton.setForeground(Color.white);
            startButton.setFont(button);
            startButton.addActionListener(gameHandler);
            startButton.setFocusPainted(false);




            gametitle.add(Hero);
            startbuttonPanel.add(startButton);


            con.add(gametitle);
            con.add(startbuttonPanel);

            //allows user to see the window
            window.setVisible(true);
    }


    public void createGameScreen(){

        gametitle.setVisible(false);
        startbuttonPanel.setVisible(false);

        //create dialog text box and positions it
        mainText = new JPanel();
        mainText.setBounds(20,150,300,150);
        mainText.setBackground(Color.pink);
        con.add(mainText);

            //testing what this box does
        mainTextArea = new JTextArea("Main text? Where does this show up?!");
        mainTextArea.setBounds(30,150,290,100);
        mainTextArea.setBackground(Color.green);
        mainTextArea.setForeground(Color.white);
        mainTextArea.setFont(button);
        mainTextArea.setLineWrap(true);
        mainTextArea.setWrapStyleWord(true);
        mainTextArea.setEditable(false);


        mainText.add(mainTextArea);


        choiceBoard = new JPanel();
        choiceBoard.setBounds(75,400,200,250);
        choiceBoard.setBackground(Color.red);
            //test, what does this do?
        choiceBoard.setLayout(new GridLayout(4,1));
        con.add(choiceBoard);

        //create choice 1 button
        choice1 = new JButton("Choice 1");
        choice1.setBackground(Color.black);
        choice1.setForeground(Color.white);
        choice1.setFont(button);
        choice1.setFocusPainted(false);
        choice1.addActionListener(choiceHandler);
        choice1.setActionCommand("c1");
        choiceBoard.add(choice1);

        //create choice 2 button
        choice2 = new JButton("Choice 2");
        choice2.setBackground(Color.black);
        choice2.setForeground(Color.white);
        choice2.setFont(button);
        choice2.setFocusPainted(false);
        choice2.addActionListener(choiceHandler);
        choice2.setActionCommand("c2");
        choiceBoard.add(choice2);

        //create choice 3 button
        choice3 = new JButton("Choice 3");
        choice3.setBackground(Color.black);
        choice3.setForeground(Color.white);
        choice3.setFont(button);
        choice3.setFocusPainted(false);
        choice3.addActionListener(choiceHandler);
        choice3.setActionCommand("c3");
        choiceBoard.add(choice3);

        //create choice 4 button
        choice4 = new JButton("Choice 3");
        choice4.setBackground(Color.black);
        choice4.setForeground(Color.white);
        choice4.setFont(button);
        choice4.setFocusPainted(false);
        choice4.addActionListener(choiceHandler);
        //Disables highlighting on press
        choice4.setContentAreaFilled(false);
        choice4.setActionCommand("c4");
        choiceBoard.add(choice4);


        player = new JPanel();
        player.setBounds(2,70,338,60);
        player.setBackground(Color.blue);
        player.setLayout(new GridLayout(1,4));
        con.add(player);
        HP = new JLabel("HP:");
        HP.setFont(button);
        HP.setForeground(Color.white);
        player.add(HP);
        HPno = new JLabel();
        HPno.setFont(button);
        HPno.setForeground(Color.white);
        player.add(HPno);
        Weapon = new JLabel("Weapon:");
        Weapon.setFont(button);
        Weapon.setForeground(Color.white);
            //TESTING TESTING
        Weapon.setBackground(Color.red);
        player.add(Weapon);
        WeaponName = new JLabel();
        WeaponName.setFont(button);
        WeaponName.setForeground(Color.white);
        player.add(WeaponName);


        playerSetup();




}




public void playerSetup(){
    playerHP = 10;
    monsterHP = 20;
    weapon = "  knife";
    WeaponName.setText(weapon);
    HPno.setText("" + playerHP);


    townGate();
}


public void townGate(){
    position = "townGate";
    mainTextArea.setText("You are at the gate of the town. \nA guard is standing in front of you. \n\nWhat will you do?");

    //presents button options player can interact with
    choice1.setText("Talk to the guard");
    choice2.setText("Attack the guard");
    choice3.setText("Leave");
    choice4.setText("");
}

//talk to the guard route
public void talkGuard(){
    position = "talkGuard";
    mainTextArea.setText("Guard: Hello stranger. I haven't seen your face before. \nI'm sorry, but you have to leave.");
    choice1.setText(">");
    choice2.setText("");
    choice3.setText("");
    choice4.setText("");
}

//attack guard route
public void attackGuard(){
    position = "attackGuard";
    mainTextArea.setText("Guard: Hey don't be stupid! \n\nThe guard fought back and you recieved 2 damage.");
    //removes 2 HP from player's health
    playerHP = playerHP - 2;
    HPno.setText("" + playerHP);
    choice1.setText(">");
    choice2.setText("");
    choice3.setText("");
    choice4.setText("");
}

//leave route
public void crossRoad(){
    position = "crossRoad";
    mainTextArea.setText("You are at an intersection. \nIf you go left, you will back to the town.");
    //presents 4 directions the player can choose to explore
    choice1.setText("Go North");
    choice2.setText("Go East");
    choice3.setText("Go South");
    choice4.setText("Go West");
}

//north route
public void north(){
    position = "north";
    mainTextArea.setText("There is a river. \nYou drink the water and rest. \n\n(Your HP has recovered by 1)");
    //adds 1 HP to player's health 
    playerHP = playerHP + 1;
    HPno.setText(""+ playerHP);
    //forces player to return to the crossroads
    choice1.setText("Go South");
    choice2.setText("");
    choice3.setText("");
    choice4.setText("");


}

//east route
public void east(){
    position = "east";
    mainTextArea.setText("You walked into a forest and found a sword. \nYou obtained a sword.");
    //changes player's weapon from knife to sword
    weapon = "Sword";
    WeaponName.setText(weapon);
    //forces player to return to the crossroads
    choice1.setText("Go West");
    choice2.setText("");
    choice3.setText("");
    choice4.setText("");


}

//west route
public void west(){
    position = "west";
    mainTextArea.setText("You encounter a dragon!");
    //player chooses to run or fight
    choice1.setText("Fight");
    choice2.setText("Run");
    choice3.setText("");
    choice4.setText("");
}

//fight dragon route
public void fight(){
    position = "fight";
    mainTextArea.setText("Monster HP: "+ monsterHP +"\n\nWhat are you going to do?");
    choice1.setText("Attack");
    choice2.setText("Run");
    choice3.setText("");
    choice4.setText("");
}
public void playerAttack(){
    position = "playerAttack";


    int playerDamage = 0;

    //randomizes damage player inflicts on dragon. The sword does more damage than the knife
    if(weapon.equals("Knife")){
        playerDamage = new java.util.Random().nextInt(3);
    }
    else if (weapon.equals("Sword")){
        playerDamage = new java.util.Random().nextInt(10);
    }


    mainTextArea.setText("You attacked the monster and did " + playerDamage + " damage!");

    //update dragon's HP after player attacks
    monsterHP = monsterHP - playerDamage;


    choice1.setText(">");
    choice2.setText("");
    choice3.setText("");
    choice4.setText("");
}
public void monsterAttack(){
    position = "monsterAttack";


    int monsterDamage = 0;

    //randomize the damage dragon inflicts on player
    monsterDamage = new java.util.Random().nextInt(4);


    mainTextArea.setText("The dragon attacked you and you received " + monsterDamage + " damage!");

    //updates player's health after dragon attacks
    playerHP = playerHP - monsterDamage;
    HPno.setText("" + playerHP);


    choice1.setText(">");
    choice2.setText("");
    choice3.setText("");
    choice4.setText("");
}


public void win(){
    position = "win";


    mainTextArea.setText("You defeated the dragon!\nThe dragon dropped a mana stone. \n\n(You obtained a mana stone)");


    manaStone = 1;


    choice1.setText("Go East");
    choice2.setText("");
    choice3.setText("");
    choice4.setText("");
}
public void base(){
    position = "base";


    mainTextArea.setText("You are dead. \n\n<GAME OVER>");

    choice1.setText(">");
    choice2.setText("");
    choice3.setText("");
    choice4.setText("");
    choice1.setVisible(false);
    choice2.setVisible(false);
    choice3.setVisible(false);
    choice4.setVisible(false);
}
public void ending(){
    position = "ending";


    mainTextArea.setText("Guard: Oh you killed the dragon? Thank you so much! You are a hero! \nWelcome to the town! \n\nTHE END");


    choice1.setText(">");
    choice2.setText("");
    choice3.setText("");
    choice4.setText("");
    choice1.setVisible(false);
    choice2.setVisible(false);
    choice3.setVisible(false);
    choice4.setVisible(false);
}


    public class TitleScreen implements ActionListener{


        public void actionPerformed(ActionEvent event){


            createGameScreen();            
        }


    }
    public class choiceHandler implements ActionListener{


        public void actionPerformed(ActionEvent event){


            String playerChoice = event.getActionCommand();


            switch(position){
            case "townGate":
                switch(playerChoice){
                case "c1":
                    if (manaStone==1){
                        ending();
                    }
                    else{
                        talkGuard();
                    }
                    break;
                case "c2": attackGuard(); break;
                case "c3": crossRoad(); break;
                }
                break;
            case "talkGuard":
                switch(playerChoice){
                case "c1": townGate(); break;
                }
                break;
            case "attackGuard":
                switch(playerChoice){
                case "c1": townGate(); break;
                }
                break;
            case "crossRoad":
                switch(playerChoice){
                case "c1": north(); break;
                case "c2": east(); break;
                case "c3": townGate(); break;
                case "c4": west(); break;
                }
                break;
            case "north":
                switch(playerChoice){
                case "c1": crossRoad(); break;
                }
                break;
            case "east":
                switch(playerChoice){
                case "c1": crossRoad(); break;
                }
                break;
            case "west":
                switch(playerChoice){
                case "c1": fight(); break;
                case "c2": crossRoad(); break;
                }
                break;
            case "fight":
                switch(playerChoice){
                case "c1": playerAttack(); break;
                case "c2": crossRoad(); break;
                }
                break;
            case "playerAttack":
                switch(playerChoice){
                case "c1":
                    if (monsterHP<1){
                        win();
                    }
                    else{
                        monsterAttack();
                    }
                    break;
                }
                break;
            case "monsterAttack":
                switch(playerChoice){
                case "c1":
                    if (playerHP<1) {
                        base();
                    }
                    else{
                        fight();
                    }
                    break;
                }
                break;
            case "win":
                switch(playerChoice){
                case "c1": crossRoad();
                }
                break;  

        }
    }


    }
}
