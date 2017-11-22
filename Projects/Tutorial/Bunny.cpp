/*
 * Bunny.h
 *
 *  Created on: 29.10.2015
 *      Author: Ahmad
 */
#include <stdlib.h>
#ifndef BUNNY_H_
#define BUNNY_H_

enum Sex { MALE, FEMALE };
enum Colour { WHITE, BROWN, BLACK, SPOTTED};
enum NAME { THUMPER, OREO, LOLO, PEPPER, SMOKEY, PEANUT};
class Bunny {
	public:
	    Bunny() {
	    	setSex();
	    	setName();

	    }

	void setSex() {
		sex = static_cast<Sex>(rand() % 2);
	}
	Sex getSex() {
		return sex;
	}
	void setName() {
		name = static_cast<NAME>(rand() % 6);
	}
	NAME getName() {
		return name;
	}
	Bunny getNext() {
		return *next;
	}
	private:
	    Sex sex;
	    Colour colour;
	    NAME name;
	    Bunny *next;
	    Bunny *mother;
};



#endif /* BUNNY_H_ */

