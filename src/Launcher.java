import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;


@SuppressWarnings("serial")
public class Launcher extends JFrame{
	private static Launcher controller;
	private Fighter[] fighters;
	private FighterPool model;
	private LauncherView view;
	
	public Launcher(String t) {
		super(t);
		model = new FighterPool();
		fighters = model.getFighters();
		view = new LauncherView(fighters);	//creates the view, that stuff will be displyed on
		getContentPane().setPreferredSize(view.getPreferredSize());	//makes the window fit around the view
		pack();		
		
		add(view);
		setSize(1280, 720);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(true);
		
		view.getStart().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				handleStart();}});
		view.getP1Ready().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				handleP1Ready();}});
		view.getP2Ready().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				handleP2Ready();}});
		
		for (int i = 0; i < fighters.length; i++) {
				view.getP1Array()[i].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						handleP1selection(e); }});
				view.getP2Array()[i].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					handleP2selection(e);}});
		}
		
	}
	
	public static void main(String[] args) {
		controller = new Launcher("POWA!");
		controller.setVisible(true);
		
	}
	
	private void handleStart() {
		System.out.println("Start");
		int p1Index = -1;
		int p2Index = -1;
		for (int i = 0; i < fighters.length; i++) {
			if (view.getSelection()[i] == 1) {
				p1Index = i;
			}
			if (view.getSelection()[i] == 2) {
				p2Index = i;
			}
		}

		setVisible(false);
		AppGameContainer app;
		try {
			app = new AppGameContainer(new GameStart( fighters[p1Index], fighters[p2Index], new Battle(fighters[p1Index], fighters[p2Index])));
			app.setDisplayMode(1280, 720, false);
			app.start();
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}
	
	private void handleP2Ready() {
		if (view.getP2Ready().getText().equals("Ready!")) {
			view.setP2Ready(true);
		} else {
			view.setP2Ready(false);
		}
		view.update();
	}
	
	private void handleP1Ready() {
		if (view.getP1Ready().getText().equals("Ready!")) {
			view.setP1Ready(true);
		} else {
			view.setP1Ready(false);
		}
		view.update();
	}
	
	private void handleP1selection(ActionEvent e) {
		for (int i = 0; i < fighters.length; i++) {
			JButton button = view.getP1Array()[i];
			if (view.getSelection()[i] == 1)
				view.setSelection(i, 0);
			if (button.equals(e.getSource())) {
				System.out.println("P1 button " + i);
				view.setSelection(i, 1);
			}
			
		}
		view.update();
	}
	
	private void handleP2selection(ActionEvent e) {
		for (int i = 0; i < fighters.length; i++) {
			JButton button = view.getP2Array()[i];
			if (view.getSelection()[i] == 2)
				view.setSelection(i, 0);
			if (button.equals(e.getSource())) {
				System.out.println("P2 button " + i);
				view.setSelection(i, 2);
			}
		}
		view.update();
	}

}
