import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;

@SuppressWarnings("serial")
public class Lottery extends JFrame
{
	private AllLines  _theBalls      = new AllLines(1, 49, 6);
	private int       _numberOfLines = 1;
	private JButton   _select        = null;
	private JList     _numberList    = null;
	private JComboBox _howOften      = null;
	private JComboBox _howMany       = null;

	public Lottery() {
		super();

		init();
	}

	public Lottery(String title) {
		super(title);

		init();
	}

	private class SelectEh implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			select();
		}
	} // class SelectEh

	private class HowManyEh implements ActionListener
	{
		public void actionPerformed(ActionEvent arg0) {
			selectedHowMany();
		}
	}

	private class HowOftenEh implements ActionListener
	{
		public void actionPerformed(ActionEvent arg0)
		{
			selectedHowOften();
		}
	}

	private void init()
	{

		GridBagLayout gbl = new GridBagLayout();
		getContentPane().setLayout(gbl);

		JLabel title=new JLabel("Pick lottery numbers", JLabel.CENTER);
		title.setAlignmentX(Component.CENTER_ALIGNMENT);
		addToFrame(gbl, title, 1.0, 1.0);

		JPanel p1 = createPanel(1);
		
		JLabel label1 = new JLabel("Select a number...",
				SwingConstants.CENTER);
		label1.setAlignmentX(Component.CENTER_ALIGNMENT);
		p1.add(label1);

		String[] occurs = {"Every Line", "Every Other Line",
				"Every Third Line", "Every Fourth Line",
				"Every Fifth Line", "Every Sixth Line",
		"Every Seventh Line"};
		_howOften= new JComboBox(occurs);
		_howOften.setAlignmentX(Component.CENTER_ALIGNMENT);
		p1.add(_howOften);
			
		addToFrame(gbl, p1, 2.0, 1.0);

		JPanel p2 = createPanel(1);
		
		JLabel label2 = new JLabel("How many lines?",
				SwingConstants.CENTER);
		label2.setAlignmentX(Component.CENTER_ALIGNMENT);
		p2.add(label2);
		String[] count = {"One", "Two", "Three", "Four", "Five", "Six",  "Seven"};
		_howMany  = new JComboBox(count);
		_howMany.setAlignmentX(Component.CENTER_ALIGNMENT);
		p2.add(_howMany);
		
		addToFrame(gbl, p2, 3.0, 1.0);		
		
		_select = new JButton("Select");
		_select.setAlignmentX(Component.CENTER_ALIGNMENT);
		addToFrame(gbl, _select, 4.0, 1.0);
		
		_numberList = new JList();
		
		DefaultListModel dlm = new DefaultListModel();
		
		_numberList.setModel(dlm);

		JScrollPane listScroller = new JScrollPane(_numberList);
		listScroller.setPreferredSize(new Dimension(120, 130));
		
		JPanel p3 = createPanel(1);
		p3.add(listScroller);
		
		addToFrame(gbl, p3, 5.0, 7.0);
		
		_select.addActionListener(new SelectEh());
		_howMany.addActionListener(new HowManyEh());
		_howOften.addActionListener(new HowOftenEh());

	}

	private void addToFrame(GridBagLayout gbl, Component comp, double row, double height) {
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.gridx      = 0;
		gbc.gridy      = (int)row;
		gbc.gridheight = (int)height;
		gbc.gridwidth  = 100;
		gbc.weightx    = 100;
		gbl.setConstraints(comp, gbc);
		getContentPane().add(comp);
	}

	private JPanel createPanel(int height) {
		JPanel p1 = new JPanel();
		p1.setLayout(new BoxLayout(p1, BoxLayout.Y_AXIS));
		p1.setBorder(new EtchedBorder());
		p1.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		return p1;
	}

	public void select()
	{
		int count;

		_numberList.removeAll();

		// Now select as many lines as were requested
		
		DefaultListModel dlm = (DefaultListModel)_numberList.getModel();
		dlm.clear();
		
		for (count = 0; count < _numberOfLines; count++)
		{
			LottoLine line = new LottoLine(_theBalls);
//			System.out.println(line.toString());
			
			dlm.add(count, line.toString());
		}
		
		pack();
	} // select

	public void selectedHowOften()
	{
		// System.out.println("Setting exclusion at "+Integer.toString(howOften.getSelectedIndex() + 1));
		_theBalls.setExclusion(_howOften.getSelectedIndex() + 1);
	} // selectedHowOften


	public void selectedHowMany()
	{
		_numberOfLines = _howMany.getSelectedIndex() + 1;
	} // selectedHowMany
}
