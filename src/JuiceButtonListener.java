import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JuiceButtonListener implements ActionListener{
	private JuiceWindow wind;
	private DispenserType dispenser;
	public JuiceButtonListener(JuiceWindow w, DispenserType d) {
		this.wind = w;
		this.dispenser = d;
	}
	public void actionPerformed(ActionEvent e) {
		
		wind.helperFunc(dispenser);
	}

}
