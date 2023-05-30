package tierraMediaTP.Comparators;

import java.util.Comparator;

import tierraMediaTP.ObjectsTierraMedia.Oferta;

public class OfertaComparator implements Comparator<Oferta>{

	@Override
	public int compare(Oferta o1, Oferta o2) {
		return o2.compareTo(o1);
	}

	

}
