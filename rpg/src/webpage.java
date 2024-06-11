import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


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




    public static void main(String[] args) throws Exception {


        new Webpage();
    }


    public Webpage(){


            //customize webpage window
            window = new JFrame();
            window.setSize(360,640);
            window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            window.getContentPane().setBackground(Color.black);
            window.setLayout(null);
            window.setVisible(true);
            con = window.getContentPane();


            gametitle = new JPanel();
            gametitle.setBounds(20,100,300,75);
            gametitle.setBackground(Color.blue);
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




            gametitle.add(Hero);
            startbuttonPanel.add(startButton);


            con.add(gametitle);
            con.add(startbuttonPanel);
    }


    public void createGameScreen(){


        gametitle.setVisible(false);
        startbuttonPanel.setVisible(false);


        mainText = new JPanel();
        mainText.setBounds(20,150,300,150);
        mainText.setBackground(Color.pink);
        con.add(mainText);


        mainTextArea = new JTextArea();
        mainTextArea.setBounds(30,150,290,100);
        mainTextArea.setBackground(Color.green);
        mainTextArea.setForeground(Color.white);
        mainTextArea.setFont(button);
        mainTextArea.setLineWrap(true);
        mainText.add(mainTextArea);


        choiceBoard = new JPanel();
        choiceBoard.setBounds(75,400,200,250);
        choiceBoard.setBackground(Color.red);
        con.add(choiceBoard);


        choice1 = new JButton("Choice 1");
        choice1.setBackground(Color.black);
        choice1.setForeground(Color.white);
        choice1.setFont(button);
        choice1.addActionListener(choiceHandler);
        choice1.setActionCommand("c1");
        choiceBoard.add(choice1);
        choice2 = new JButton("Choice 2");
        choice2.setBackground(Color.black);
        choice2.setForeground(Color.white);
        choice2.setFont(button);
        choice2.addActionListener(choiceHandler);
        choice2.setActionCommand("c2");
        choiceBoard.add(choice2);
        choice3 = new JButton("Choice 3");
        choice3.setBackground(Color.black);
        choice3.setForeground(Color.white);
        choice3.setFont(button);
        choice3.addActionListener(choiceHandler);
        choice3.setActionCommand("c3");
        choiceBoard.add(choice3);
        choice4 = new JButton("Choice 3");
        choice4.setBackground(Color.black);
        choice4.setForeground(Color.white);
        choice4.setFont(button);
        choice4.addActionListener(choiceHandler);
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
    HPno.setText(""+playerHP);


    townGate();
}


public void townGate(){
    position = "townGate";
    mainTextArea.setText("You are at the gate of the town. \nA guard is standing in front of you. \n\nWhat will you do?");


    choice1.setText("Talk to the guard");
    choice2.setText("Attack the guard");
    choice3.setText("Leave");
    choice4.setText("");
}


public void talkGuard(){
    position = "talkGuard";
    mainTextArea.setText("Guard: Hello stranger. I haven't seen your face before. \nI'm sorry, but you have to leave.");
    choice1.setText(">");
    choice2.setText("");
    choice3.setText("");
    choice4.setText("");
}
public void attackGuard(){
    position = "attackGuard";
    mainTextArea.setText("Guard: Hey don't be stupid! \n\nThe guard fought back and you recieved 2 damage.");
    playerHP = playerHP - 2;
    HPno.setText(""+ playerHP);
    choice1.setText(">");
    choice2.setText("");
    choice3.setText("");
    choice4.setText("");
}
public void crossRoad(){
    position = "crossRoad";
    mainTextArea.setText("You are at an intersection. \nIf you go left, you will back to the town.");
    choice1.setText("Go North");
    choice2.setText("Go East");
    choice3.setText("Go South");
    choice4.setText("Go West");
}
public void north(){
    position = "north";
    mainTextArea.setText("There is a river. \nYou drink the water and rest. \n\n(Your HP has recovered by 1)");
    playerHP = playerHP + 1;
    HPno.setText(""+ playerHP);
    choice1.setText("Go South");
    choice2.setText("");
    choice3.setText("");
    choice4.setText("");


}
public void east(){
    position = "east";
    mainTextArea.setText("You walked into a forest and found a sword. \nYou obtained a sword.");
    weapon = "Sword";
    WeaponName.setText(weapon);
    choice1.setText("Go West");
    choice2.setText("");
    choice3.setText("");
    choice4.setText("");


}
public void south(){


}
public void west(){
    position = "west";
    mainTextArea.setText("You encounter a dragon!");
    choice1.setText("Fight");
    choice2.setText("Run");
    choice3.setText("");
    choice4.setText("");
}
public void fight(){
    position = "Fight";
    mainTextArea.setText("Monster HP: "+ monsterHP +"\n\nWhat are you going to do?");
    choice1.setText("Attack");
    choice2.setText("Run");
    choice3.setText("");
    choice4.setText("");
}
public void playerAttack(){
    position = "playerAttack";


    int playerDamage = 0;

//unsure how mixedInt works
    if(weapon.equals("Knife")){
        //playerDamage = new java.util.Random().mixedInt(3);
    }
    else if (weapon.equals("Sword")){
        //playerDamage = new java.util.Random().mixedInt(10);
    }


    mainTextArea.setText("You attacked the monster and did "+playerDamage + " damage");


    monsterHP = monsterHP - playerDamage;


    choice1.setText(">");
    choice2.setText("");
    choice3.setText("");
    choice4.setText("");
}
public void monsterAttack(){
    position = "monsterAttack";


    int monsterDamage = 0;


    //monsterDamage = new java.util.Random().mixedInt(4);


    mainTextArea.setText("The dragon attacked you and you received " + monsterDamage + " damage.");


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
