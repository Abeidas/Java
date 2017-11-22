import java.util.ArrayList;
public class myList {
	ArrayList<Integer> list;
	int minimum = 0;
	int maximum = 0;
	int sum = 0;
	int average = 0;
	public int insert(int n) {
		if (n > minimum) {
			list.set(0, n);
		}
		if ( n < maximum) {
			list.set(1, n);
		}
		sum += n;
		average = sum / ( list.size() - 2);
		list.set(2, average);
		for( int i = 3; i < list.size();i++) {
			if ( n < list.get(i)) {
				for ( int j = i; j < list.size(); j++) {
					list.set(j + 1, list.get(j));
				}
				return i;
			} else {
				list.set( list.size(), n);
			}
		}
		return 0;
	}
	public boolean remove ( int n) {
		for( int i = 3; i < list.size(); i++) {
			if( n == list.get(i)) {
				for( int j = i; j < list.size(); j++) {
					list.set(j - 1, list.get(j));
				}
				list.set(n - 1, 0);
				return true;
			}
		}
		return false;
	}
	public int minimum() {
		return list.get(0);
	}
	public int maximum() {
		return list.get(1);
	}
	public int average() {
		return list.get(2);
	}
}
