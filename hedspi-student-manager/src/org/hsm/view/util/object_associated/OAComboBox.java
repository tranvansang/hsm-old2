package org.hsm.view.util.object_associated;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

public class OAComboBox<T1 extends Object, T2 extends Object> extends
		OAComponentAbstract<T1, T2> {

	JComboBox<T1> comboBox;

	public OAComboBox(IObjectUpdater<T2, T1> comboBoxUpdaterArg) {
		this(comboBoxUpdaterArg, null);
	}

	public OAComboBox(IObjectUpdater<T2, T1> comboBoxUpdaterArg, T2 object) {
		super(comboBoxUpdaterArg, object);
		comboBox = new JComboBox<>();
		comboBox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				updateObjectValue();
			}
		});
	}

	public JComboBox<T1> getComboBox() {
		return comboBox;
	}

	@Override
	public T1 getValue() {
		return (T1) getComboBox().getSelectedItem();
	}

	@Override
	public void setValue(T1 value) {
		getComboBox().setSelectedItem(value);
	}

}