package org.hsm.model.hedspi;

import java.util.Collection;

import javax.swing.DefaultComboBoxModel;

public class SortedHedspiObjectsComboModel<T extends HedspiObject> extends
		DefaultComboBoxModel<T> implements IObjectsContainer<T> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private SortedList<T> sortedList;

	public SortedHedspiObjectsComboModel() {
		sortedList = new SortedList<>();
	}

	@Override
	public void addObject(T obj) {
		sortedList.add(obj);
		updateModel();
	}

	@Override
	public void removeAll() {
		sortedList.clear();
		updateModel();
	}

	@Override
	public void removeObject(T obj) {
		sortedList.remove(obj);
		updateModel();
	}

	private void updateModel() {
		super.removeAllElements();
		for (T it : sortedList)
			super.addElement(it);
	}

	@Override
	public void addObjects(Collection<T> arr) {
		for (T it : arr)
			sortedList.add(it);
		updateModel();
	}

}
