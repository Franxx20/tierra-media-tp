package tierraMediaTP.Comparators;

import tierraMediaTP.ObjectsTierraMedia.Atraccion;

import java.util.Comparator;

public class AtraccionComparator implements Comparator<Atraccion>{

	@Override
	public int compare(Atraccion o1, Atraccion o2) {
		return o2.compareTo(o1);
	}

}
