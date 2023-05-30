package tierraMediaTP.Comparators;

import tierraMediaTP.ObjectsTierraMedia.Oferta;

import java.util.Comparator;

public class OfertaComparator implements Comparator<Oferta>{

	@Override
	public int compare(Oferta o1, Oferta o2) {
		return o2.compareTo(o1);
	}

	

}
