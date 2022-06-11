import javax.sql.rowset.spi.XmlWriter;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Game extends JFrame implements ActionListener {
    JPanel title_panel=new JPanel();
    JPanel button_panel=new JPanel();
    JButton[] buttons=new JButton[9];
    JButton start=new JButton();
    JPanel start_panel=new JPanel();
    JLabel title=new JLabel();
    boolean player_1;
    Random random =new Random();

    Game(){
        this.setSize(800,800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBackground(Color.BLACK);
        this.setLayout(new BorderLayout());
        this.setLocationRelativeTo(null);


        title_panel.setBounds(0,0,800,70);
        title_panel.setLayout(new BorderLayout());

        button_panel.setLayout(new GridLayout(3,3));


        start_panel.setBounds(0,0,200,170);
        start_panel.setBackground(new Color(30,129,176));
        start_panel.setLayout(new BorderLayout());

        start.setText("Start");
        start.setFont(new Font("Arial",Font.PLAIN,50));
        start.setSize(80,100);
        start.setBackground(new Color(30,129,176));
        start.setForeground(Color.white);
        start.setBorderPainted(false);
        start.setOpaque(true);
        start.setFocusable(false);
        start.setHorizontalAlignment(JButton.CENTER);
        start.addActionListener(this);

        title.setFont(new Font("Arial",Font.PLAIN,50));
        title.setForeground(Color.white);
        title.setBackground(new Color(30,129,176));
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setText("TicTacToe");
        title.setOpaque(true);


        for(int i=0;i<9;i++){
            buttons[i]=new JButton();
            button_panel.add(buttons[i]);
            buttons[i].setFont(new Font("Arial",Font.PLAIN,75));
            buttons[i].setBackground(null);
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
            buttons[i].setEnabled(false);
            buttons[i].setOpaque(true);

        }


        title_panel.add(title);
        start_panel.add(start);
        this.add(start_panel,BorderLayout.SOUTH);
        this.add(title_panel,BorderLayout.NORTH);
        this.add(button_panel);
        this.setVisible(true);


    }

    public void firstTurn(){
        for(int i=0;i<9;i++){
            buttons[i].setEnabled(true);
        }


        if(random.nextInt(2)==0){
            player_1=true;
            title.setText("X turn");

        }
        else{
            player_1=false;
            title.setText("O turn");

        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i=0;i<9;i++) {
            if(e.getSource()==buttons[i]) {
                if(player_1) {
                    if(buttons[i].getText()=="") {
                        buttons[i].setForeground(Color.GREEN);
                        buttons[i].setText("X");
                        player_1=false;
                        title.setText("O turn");
                        check();
                    }
                }
                else {
                    if(buttons[i].getText()=="") {
                        buttons[i].setForeground(Color.RED);
                        buttons[i].setText("O");
                        player_1=true;
                        title.setText("X turn");
                        check();
                    }
                }
            }
        }
        if(e.getSource()==start){
            if (start.getText().equals("Start")){
                firstTurn();
                start.setText("Reset");
            }else{
                start.setText("Start");
                title.setText("TicTacToe");
                for(int i=0;i<9;i++){
                    buttons[i].setBackground(null);
                    buttons[i].setFocusable(false);
                    buttons[i].addActionListener(this);
                    buttons[i].setEnabled(false);
                    buttons[i].setText("");
                    buttons[i].setOpaque(true);
                }
            }


        }
    }





    public void check(){
        //Check X
        if((buttons[0].getText()=="X" && buttons[1].getText()=="X" &&buttons[2].getText()=="X")){
            xWins(0,1,2);
        }
        if((buttons[3].getText()=="X" && buttons[4].getText()=="X" &&buttons[5].getText()=="X")){
            xWins(3,4,5);
        }
        if((buttons[6].getText()=="X" && buttons[7].getText()=="X" &&buttons[8].getText()=="X")){
            xWins(6,6,8);
        }
        if((buttons[0].getText()=="X" && buttons[3].getText()=="X" &&buttons[6].getText()=="X")){
            xWins(0,3,6);
        }
        if((buttons[1].getText()=="X" && buttons[4].getText()=="X" &&buttons[7].getText()=="X")){
            xWins(1,4,7);
        }
        if((buttons[2].getText()=="X" && buttons[5].getText()=="X" &&buttons[8].getText()=="X")){
            xWins(2,5,8);
        }
        if((buttons[0].getText()=="X" && buttons[4].getText()=="X" &&buttons[8].getText()=="X")){
            xWins(0,4,8);
        }
        if((buttons[2].getText()=="X" && buttons[4].getText()=="X" &&buttons[6].getText()=="X")){
            xWins(2,4,6);
        }

        //Check O

        if((buttons[0].getText()=="O" && buttons[1].getText()=="O" &&buttons[2].getText()=="O")){
            oWins(0,1,2);
        }
        if((buttons[3].getText()=="O" && buttons[4].getText()=="O" &&buttons[5].getText()=="O")){
            oWins(3,4,5);
        }
        if((buttons[6].getText()=="O" && buttons[7].getText()=="O" &&buttons[8].getText()=="O")){
            oWins(6,6,8);
        }
        if((buttons[0].getText()=="O" && buttons[3].getText()=="O" &&buttons[6].getText()=="O")){
            oWins(0,3,6);
        }
        if((buttons[1].getText()=="O" && buttons[4].getText()=="O" &&buttons[7].getText()=="O")){
            oWins(1,4,7);
        }
        if((buttons[2].getText()=="O" && buttons[5].getText()=="O" &&buttons[8].getText()=="O")){
            oWins(2,5,8);
        }
        if((buttons[0].getText()=="O" && buttons[4].getText()=="O" &&buttons[8].getText()=="O")){
            oWins(0,4,8);
        }
        if((buttons[2].getText()=="O" && buttons[4].getText()=="O" &&buttons[6].getText()=="O")){
            oWins(2,4,6);
        }




    }

    public void xWins(int a,int b, int c){
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);
        for(int i=0;i<9;i++){
            buttons[i].setEnabled(false);

        }
        title.setText("X Wins");


    }

    public void oWins(int a,int b, int c){
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);
        for(int i=0;i<9;i++){
            buttons[i].setEnabled(false);
        }
        title.setText("O Wins");


    }
    
}
