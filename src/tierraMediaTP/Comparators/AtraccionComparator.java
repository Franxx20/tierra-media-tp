package tierraMediaTP.Comparators;

import java.util.Comparator;

import tierraMediaTP.ObjectsTierraMedia.Atraccion;

public class AtraccionComparator implements Comparator<Atraccion>{

	@Override
	public int compare(Atraccion o1, Atraccion o2) {
		return o2.compareTo(o1);
	}

}
