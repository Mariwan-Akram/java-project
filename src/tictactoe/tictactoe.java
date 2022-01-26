package tictactoe;



import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Random;

public class tictactoe extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;

	public class JLabelBox extends JLabel {

		private static final long serialVersionUID = 1L;
		public int Field = 0;
	}

	private int XWins = 0;
	private int OWins = 0;
	private int Draws = 0;

	private JPanel contentPane;
	private JButton btnNewGame, btnReset;
	private JLabelBox P1, P2, P3, P4, P5, P6, P7, P8, P9;
	private JLabel lblXWins, lblOWins, lblDraws;
	private TicTacToeAI TTT;
	private JLabel lblXWins_1;
	private JLabel lblOWins_1;
	private JLabel lblDraws_1;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					tictactoe frame = new tictactoe();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public tictactoe() {
		TTT = new TicTacToeAI();
		setResizable(false);
		setTitle("TicTacToe - DEMO");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 512, 278);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
	    contentPane.setLayout(null);

		P1 = new JLabelBox();
		P1.Field = 1;
		P1.addMouseListener(new LabelAdapter(P1));
		P1.setFont(new Font("Tahoma", Font.BOLD, 49));
		P1.setForeground(Color.GREEN);
		P1.setBackground(new Color(0, 0, 0));
		P1.setHorizontalAlignment(SwingConstants.CENTER);
		P1.setBounds(10, 10, 64, 64);
                
		P1.setOpaque(true);
		contentPane.add(P1);

		P2 = new JLabelBox();
		P2.Field = 2;
		P2.addMouseListener(new LabelAdapter(P2));
		P2.setOpaque(true);
		P2.setHorizontalAlignment(SwingConstants.CENTER);
		P2.setForeground(Color.GREEN);
		P2.setFont(new Font("Tahoma", Font.BOLD, 49));
		P2.setBackground(Color.BLACK);
		P2.setBounds(76, 10, 64, 64);
                
		contentPane.add(P2);

		P3 = new JLabelBox();
		P3.Field = 3;
		P3.addMouseListener(new LabelAdapter(P3));
		P3.setOpaque(true);
		P3.setHorizontalAlignment(SwingConstants.CENTER);
		P3.setForeground(Color.GREEN);
		P3.setFont(new Font("Tahoma", Font.BOLD, 49));
		P3.setBackground(Color.BLACK);
		P3.setBounds(142, 10, 64, 64);
		contentPane.add(P3);

		P4 = new JLabelBox();
		P4.Field = 4;
		P4.addMouseListener(new LabelAdapter(P4));
		P4.setOpaque(true);
		P4.setHorizontalAlignment(SwingConstants.CENTER);
		P4.setForeground(Color.GREEN);
		P4.setFont(new Font("Tahoma", Font.BOLD, 49));
		P4.setBackground(Color.BLACK);
		P4.setBounds(10, 76, 64, 64);
		contentPane.add(P4);

		P5 = new JLabelBox();
		P5.Field = 5;
		P5.addMouseListener(new LabelAdapter(P5));
		P5.setOpaque(true);
		P5.setHorizontalAlignment(SwingConstants.CENTER);
		P5.setForeground(Color.GREEN);
		P5.setFont(new Font("Tahoma", Font.BOLD, 49));
		P5.setBackground(Color.BLACK);
		P5.setBounds(76, 76, 64, 64);
		contentPane.add(P5);

		P6 = new JLabelBox();
		P6.Field = 6;
		P6.addMouseListener(new LabelAdapter(P6));
		P6.setOpaque(true);
		P6.setHorizontalAlignment(SwingConstants.CENTER);
		P6.setForeground(Color.GREEN);
		P6.setFont(new Font("Tahoma", Font.BOLD, 49));
		P6.setBackground(Color.BLACK);
		P6.setBounds(142, 76, 64, 64);
		contentPane.add(P6);

		P7 = new JLabelBox();
		P7.Field = 7;
		P7.addMouseListener(new LabelAdapter(P7));
		P7.setOpaque(true);
		P7.setHorizontalAlignment(SwingConstants.CENTER);
		P7.setForeground(Color.GREEN);
		P7.setFont(new Font("Tahoma", Font.BOLD, 49));
		P7.setBackground(Color.BLACK);
		P7.setBounds(10, 142, 64, 64);
		contentPane.add(P7);

		P8 = new JLabelBox();
		P8.Field = 8;
		P8.addMouseListener(new LabelAdapter(P8));
		P8.setOpaque(true);
		P8.setHorizontalAlignment(SwingConstants.CENTER);
		P8.setForeground(Color.GREEN);
		P8.setFont(new Font("Tahoma", Font.BOLD, 49));
		P8.setBackground(Color.BLACK);
		P8.setBounds(76, 142, 64, 64);
		contentPane.add(P8);

		P9 = new JLabelBox();
		P9.Field = 9;
		P9.addMouseListener(new LabelAdapter(P9));
		P9.setOpaque(true);
		P9.setHorizontalAlignment(SwingConstants.CENTER);
		P9.setForeground(Color.GREEN);
		P9.setFont(new Font("Tahoma", Font.BOLD, 49));
		P9.setBackground(Color.BLACK);
		P9.setBounds(142, 142, 64, 64);
		contentPane.add(P9);

		btnNewGame = new JButton("New game");
		btnNewGame.addActionListener(this);
		btnNewGame.setBounds(10, 216, 197, 23);
		contentPane.add(btnNewGame);

		

		lblXWins = new JLabel("0");
		lblXWins.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblXWins.setBounds(314, 13, 169, 36);
		contentPane.add(lblXWins);

		lblOWins = new JLabel("0");
		lblOWins.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblOWins.setBounds(314, 46, 169, 36);
		contentPane.add(lblOWins);

		lblDraws = new JLabel("0");
		lblDraws.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblDraws.setBounds(314, 84, 169, 30);
		contentPane.add(lblDraws);

		btnReset = new JButton("Reset");
		btnReset.setBounds(226, 127, 76, 23);
		btnReset.addActionListener(this);

		contentPane.add(btnReset);

		lblXWins_1 = new JLabel("X wins:");
		lblXWins_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblXWins_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblXWins_1.setBounds(226, 13, 76, 36);
		contentPane.add(lblXWins_1);

		lblOWins_1 = new JLabel("O wins:");
		lblOWins_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblOWins_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblOWins_1.setBounds(236, 46, 66, 36);
		contentPane.add(lblOWins_1);

		lblDraws_1 = new JLabel("Draws:");
		lblDraws_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblDraws_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDraws_1.setBounds(226, 84, 76, 30);
		contentPane.add(lblDraws_1);

		
	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == btnNewGame) {
			P1.setText("");
			P2.setText("");
			P3.setText("");
			P4.setText("");
			P5.setText("");
			P6.setText("");
			P7.setText("");
			P8.setText("");
			P9.setText("");
			TTT.NewGame();
		}

		if (e.getSource() == btnReset) {
			SetCounters(0);
		}

		
	}

	public void SetCounters(int Num) {
		switch (Num) {
		case 1:
			XWins++;
			break;
		case -1:
			OWins++;
			break;
		case 2:
			Draws++;
			break;
		case 0:
			XWins = 0;
			OWins = 0;
			Draws = 0;
			break;
		}
		lblXWins.setText(XWins + "");
		lblOWins.setText(OWins + "");
		lblDraws.setText(Draws + "");
	}

	class LabelAdapter extends MouseAdapter {
		JLabelBox sender;

		public LabelAdapter(JLabelBox sender) {
			this.sender = sender;
		}

		public void mouseReleased(MouseEvent me) {
			int GO = TTT.isGameOver();
			if (TTT.Move(sender.Field, 1) && GO == 0) {
				sender.setForeground(Color.GREEN);
				sender.setText("X");
                               
				ComputerMove(-1, Color.RED,0);
				if ((GO = TTT.isGameOver()) != 0)
					SetCounters(GO);
			}
		}
	}

	private void NewGame() {
		P1.setText("");
		P2.setText("");
		P3.setText("");
		P4.setText("");
		P5.setText("");
		P6.setText("");
		P7.setText("");
		P8.setText("");
		P9.setText("");
		TTT.NewGame();
	}
	
	

	private void ComputerMove(int player, Color pcolor,int move) {
		if (move==0) 
			move = TTT.isGameOver() == 0 ? TTT.GenerateMove(player) : 0;
		String PText = (player == 1) ? "X" : "O";

		switch (move) {
		case 1:
			P1.setForeground(pcolor);
			P1.setText(PText);
			TTT.Move(move, player);
			break;
		case 2:
			P2.setForeground(pcolor);
			P2.setText(PText);
			TTT.Move(move, player);
			break;
		case 3:
			P3.setForeground(pcolor);
			P3.setText(PText);
			TTT.Move(move, player);
			break;
		case 4:
			P4.setForeground(pcolor);
			P4.setText(PText);
			TTT.Move(move, player);
			break;
		case 5:
			P5.setForeground(pcolor);
			P5.setText(PText);
			TTT.Move(move, player);
			break;
		case 6:
			P6.setForeground(pcolor);
			P6.setText(PText);
			TTT.Move(move, player);
			break;
		case 7:
			P7.setForeground(pcolor);
			P7.setText(PText);
			TTT.Move(move, player);
			break;
		case 8:
			P8.setForeground(pcolor);
			P8.setText(PText);
			TTT.Move(move, player);
			break;
		case 9:
			P9.setForeground(pcolor);
			P9.setText(PText);
			TTT.Move(move, player);
			break;
		}
                
                
                if(P1.getText()=="X" || P1.getText()=="O"){
                P1.setToolTipText("THE CELL IS CHOOSEN");}
                
                   if(P2.getText()=="X" || P2.getText()=="O"){
                P2.setToolTipText("THE CELL IS CHOOSEN");}
                   
                      if(P3.getText()=="X" || P3.getText()=="O"){
                P3.setToolTipText("THE CELL IS CHOOSEN");}
                      
                      
                    if(P4.getText()=="X" || P4.getText()=="O"){
                P4.setToolTipText("THE CELL IS CHOOSEN");}
                
                   if(P5.getText()=="X" || P5.getText()=="O"){
                P5.setToolTipText("THE CELL IS CHOOSEN");}
                   
                      if(P6.getText()=="X" || P6.getText()=="O"){
                P6.setToolTipText("THE CELL IS CHOOSEN");}
                      
                      
                      
                     if(P7.getText()=="X" || P7.getText()=="O"){
                P7.setToolTipText("THE CELL IS CHOOSEN");}
                
                   if(P8.getText()=="X" || P8.getText()=="O"){
                P8.setToolTipText("THE CELL IS CHOOSEN");}
                   
                      if(P9.getText()=="X" || P9.getText()=="O"){
                P9.setToolTipText("THE CELL IS CHOOSEN");}
                
                

	}
}
