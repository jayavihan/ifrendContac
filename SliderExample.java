import java.util.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
interface WaterLevelObserver{
	public void update(int waterLevel);
}
class Alarm extends JFrame implements WaterLevelObserver{
	private JLabel lblAlarm;
	Alarm(){
		super("Alarm window");
		setSize(300,300);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new FlowLayout());			
		lblAlarm=new JLabel("");
		lblAlarm.setFont(new Font("",1,25));
		add(lblAlarm);
		setVisible(true);
	}
	public void update(int waterLevel){
		lblAlarm.setText(waterLevel>=50 ? "ON":"OFF");
	}
}
class Display extends JFrame implements WaterLevelObserver{
	private JLabel lblDisplay;
	Display(){
		super("Display window");
		setSize(300,300);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new FlowLayout());			
		lblDisplay=new JLabel("");
		lblDisplay.setFont(new Font("",1,25));
		add(lblDisplay);
		setVisible(true);
	}
	public void update(int waterLevel){
		lblDisplay.setText(waterLevel+"");
	}
}
interface WaterLevelObservableInterface{
	public void setWaterLevel(int waterLevel);
}
class WaterLevelObservable implements WaterLevelObservableInterface{
	private int waterLevel;
	private ArrayList<WaterLevelObserver>observerList=new ArrayList<>();
	
	public void addWaterLevelObserver(WaterLevelObserver ob){
		observerList.add(ob);
	}	
	
	public void setWaterLevel(int waterLevel){
		if(this.waterLevel!=waterLevel){
			this.waterLevel=waterLevel;
			notifyObject();
		}
	}
	public void notifyObject(){
		for(WaterLevelObserver ob : observerList){
			ob.update(waterLevel);
		}
	}
	
}
class WaterTank extends JFrame{
	private JSlider waterLevelSlider;
	private WaterLevelObservableInterface waterLevelObservable;
	
	WaterTank(WaterLevelObservableInterface waterLevelObservable){
		this.waterLevelObservable=waterLevelObservable;
		setSize(300,300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new FlowLayout());
		
		waterLevelSlider=new JSlider(JSlider.VERTICAL,0,100,50);//JSlider(int orientation, int min, int max, int value)
		waterLevelSlider.addChangeListener(new ChangeListener(){
			public void stateChanged(ChangeEvent evt){
				int waterLevel=waterLevelSlider.getValue();
				waterLevelObservable.setWaterLevel(waterLevel);
			}
		});
		add(waterLevelSlider);	
				
	}
}
class Demo{
	public static void main(String args[]){
		WaterLevelObservable waterLevelObservable=new WaterLevelObservable();
		waterLevelObservable.addWaterLevelObserver(new Alarm());
		waterLevelObservable.addWaterLevelObserver(new Display());
		new WaterTank(waterLevelObservable).setVisible(true);
		
	}
}
